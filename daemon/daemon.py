import socket
import os
import json
import pty
import select
import threading
import signal
import time
from datetime import datetime

SOCKET_PATH = "/tmp/kai_daemon.sock"
SKILLS_PATH = os.path.expanduser("~/skills")
TASK_REGISTRY = {}
task_counter = 1
BUFFER_SIZE = 1000 

def get_process_metrics(pid):
    try:
        with open(f"/proc/{pid}/status", "r") as f:
            lines = f.readlines()
            vm_rss = 0
            for line in lines:
                if "VmRSS" in line:
                    vm_rss = int(line.split(":")[1].strip().split(" ")[0])
                    break
        with open(f"/proc/{pid}/stat", "r") as f:
            stat = f.read().split()
            cpu_ticks = int(stat[13]) + int(stat[14])
        return {"mem_kb": vm_rss, "cpu_ticks": cpu_ticks}
    except Exception:
        return None

def pty_reader(task_id, master_fd):
    global TASK_REGISTRY
    while True:
        try:
            r, _, _ = select.select([master_fd], [], [], 0.1)
            if r:
                data = os.read(master_fd, 1024)
                if not data:
                    if task_id in TASK_REGISTRY:
                        TASK_REGISTRY[task_id]["status"] = "COMPLETED"
                    break
                decoded = data.decode('utf-8', errors='replace')
                if task_id in TASK_REGISTRY:
                    TASK_REGISTRY[task_id]["buffer"].append(decoded)
                    if len(TASK_REGISTRY[task_id]["buffer"]) > BUFFER_SIZE:
                        TASK_REGISTRY[task_id]["buffer"].pop(0)
                else:
                    break
        except Exception:
            break

def scan_skills():
    try:
        skills = []
        if os.path.exists(SKILLS_PATH):
            for f in os.listdir(SKILLS_PATH):
                if f.endswith(('.sh', '.py')):
                    skills.append(f)
        return skills
    except Exception:
        return []

def skill_indexer():
    global TASK_REGISTRY
    # Immediate scan on start
    TASK_REGISTRY["__skills_manifest__"] = {"last_updated": str(datetime.now()), "skills": scan_skills()}
    while True:
        TASK_REGISTRY["__skills_manifest__"] = {"last_updated": str(datetime.now()), "skills": scan_skills()}
        time.sleep(3)

def watchdog():
    global TASK_REGISTRY
    while True:
        for tid, info in list(TASK_REGISTRY.items()):
            if tid == "__skills_manifest__": continue
            pid = info.get("pid")
            # Verify if process is still alive
            try:
                os.kill(pid, 0)
                if info.get("status") == "RUNNING":
                    metrics = get_process_metrics(pid)
                    if metrics: info["metrics"] = metrics
            except ProcessLookupError:
                info["status"] = "COMPLETED"
        time.sleep(2)

def handle_client(conn):
    global task_counter
    try:
        while True:
            data = conn.recv(4096)
            if not data: break
            try:
                request = json.loads(data.decode('utf-8'))
                cmd = request.get("command")
                params = request.get("params", {})
                response = {"status": "error", "message": "Unknown command"}
                if cmd == "ping":
                    response = {"status": "ok", "message": "pong", "timestamp": str(datetime.now())}
                elif cmd == "start_task":
                    shell_cmd = params.get("command")
                    task_id = f"bg-{task_counter}"
                    pid, master_fd = pty.fork()
                    if pid == 0:
                        os.execlp("bash", "bash", "-c", shell_cmd)
                    else:
                        TASK_REGISTRY[task_id] = {
                            "master_fd": master_fd, "pid": pid, "command": shell_cmd,
                            "start_time": str(datetime.now()), "status": "RUNNING", "buffer": []
                        }
                        threading.Thread(target=pty_reader, args=(task_id, master_fd), daemon=True).start()
                        task_counter += 1
                        response = {"status": "ok", "task_id": task_id, "pid": pid}
                elif cmd == "list_tasks":
                    tasks_snapshot = {tid: {k: v for k, v in info.items() if k != "master_fd"} 
                                     for tid, info in TASK_REGISTRY.items() if tid != "__skills_manifest__"}
                    response = {"status": "ok", "tasks": tasks_snapshot}
                elif cmd == "get_skills":
                    # Force a fresh scan for immediate feedback
                    manifest = {"last_updated": str(datetime.now()), "skills": scan_skills()}
                    TASK_REGISTRY["__skills_manifest__"] = manifest
                    response = {"status": "ok", "manifest": manifest}
                elif cmd == "get_logs":
                    task_id = params.get("task_id")
                    if task_id in TASK_REGISTRY:
                        response = {"status": "ok", "logs": "".join(TASK_REGISTRY[task_id]["buffer"])}
                    else:
                        response = {"status": "error", "message": "Task not found"}
                elif cmd == "kill_task":
                    task_id = params.get("task_id")
                    if task_id in TASK_REGISTRY:
                        info = TASK_REGISTRY[task_id]
                        try:
                            os.kill(info["pid"], signal.SIGKILL)
                            os.close(info["master_fd"])
                            del TASK_REGISTRY[task_id]
                            response = {"status": "ok", "message": f"Killed {task_id}"}
                        except ProcessLookupError:
                            response = {"status": "error", "message": "Process already dead"}
                    else:
                        response = {"status": "error", "message": "Task not found"}
                conn.sendall(json.dumps(response).encode('utf-8'))
            except json.JSONDecodeError:
                conn.sendall(json.dumps({"status": "error", "message": "Invalid JSON"}).encode('utf-8'))
    except Exception as e:
        print(f"Client error: {e}")
    finally:
        conn.close()

def start_daemon():
    if os.path.exists(SOCKET_PATH): os.remove(SOCKET_PATH)
    server = socket.socket(socket.AF_UNIX, socket.SOCK_STREAM)
    server.bind(SOCKET_PATH)
    server.listen(5)
    os.chmod(SOCKET_PATH, 0o777)
    threading.Thread(target=skill_indexer, daemon=True).start()
    threading.Thread(target=watchdog, daemon=True).start()
    print(f"Kai-Daemon v0.3.1 (Stable) started on {SOCKET_PATH}")
    try:
        while True:
            conn, addr = server.accept()
            threading.Thread(target=handle_client, args=(conn,), daemon=True).start()
    except KeyboardInterrupt:
        pass
    finally:
        server.close()
        if os.path.exists(SOCKET_PATH): os.remove(SOCKET_PATH)

if __name__ == "__main__":
    start_daemon()
