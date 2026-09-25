package com.inspiredandroid.kai.tools
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import org.koin.java.KoinJavaComponent.inject

            "exit_code" to (session.exitCode ?: -1),
            "finished" to finished,
            "message" to "Process started in background. Use manage_process tool to check status.",
            "offset" to offset,
            "running" to running,
            "session_id" to sessionId,
            "status" to "running",
            "status" to if (session.finished) "finished" else "running",
            "stderr" to session.stderr.takeLast(2000),
            "stdout" to sliced,
            "success" to true,
            "timed_out" to session.timedOut,
            "total" to sessions.size,
            "total_stdout_lines" to stdoutLines.size,
            ?: return mapOf("success" to false, "error" to "Unknown session: $sessionId")
            command = command,
            id = sessionId,
            return mapOf("success" to true, "message" to "Process already finished", "exit_code" to (session.exitCode ?: -1))
            session.exitCode = result["exit_code"] as? Int ?: -1
            session.finished = true
            session.stderr = result["stderr"] as? String ?: ""
            session.stdout = result["stdout"] as? String ?: ""
            session.timedOut = result["timed_out"] as? Boolean ?: false
            startTime = System.currentTimeMillis(),
            val result = executor.execute(command, timeoutSeconds, workingDir, envMap)
        "command" to command,
        "duration_seconds" to ((System.currentTimeMillis() - startTime) / 1000),
        "exit_code" to (exitCode ?: -1),
        "session_id" to id,
        "status" to if (finished) "finished" else "running",
        "stdout_length" to stdout.length,
        "timed_out" to timedOut,
        )
        @Volatile var exitCode: Int? = null,
        @Volatile var finished: Boolean = false,
        @Volatile var stderr: String = "",
        @Volatile var stdout: String = "",
        @Volatile var timedOut: Boolean = false,
        CompletableFuture.runAsync {
        command: String,
        envMap: Map<String, String>,
        if (session.finished) {
        return mapOf(
        return mapOf("success" to true, "message" to "Process marked as terminated")
        return mapOf("success" to true, "message" to "Session removed")
        session.exitCode = -1
        session.finished = true
        session.timedOut = true
        sessions.remove(sessionId)
        sessions[sessionId] = session
        timeoutSeconds: Long,
        val command: String,
        val executor = sandboxManager.createProotExecutor()
        val finished = sessions.values.filter { it.finished }.map { it.toInfo() }
        val id: String,
        val running = sessions.values.filter { !it.finished }.map { it.toInfo() }
        val session = Session(
        val session = sessions[sessionId]
        val sessionId = "bg-${nextId.getAndIncrement()}"
        val sliced = stdoutLines.drop(offset).take(limit).joinToString("\n")
        val startTime: Long,
        val stdoutLines = session.stdout.lines()
        workingDir: String,
        }
    )
    ): Map<String, Any> {
    class Session(
    fun kill(sessionId: String): Map<String, Any> {
    fun list(): Map<String, Any> {
    fun log(sessionId: String, offset: Int, limit: Int): Map<String, Any> {
    fun remove(sessionId: String): Map<String, Any> {
    fun startBackground(
    private fun Session.toInfo(): Map<String, Any> = mapOf(
    private val nextId = AtomicInteger(1)
    private val sessions = ConcurrentHashMap<String, Session>()
    return ProcessManager(sandboxManager)
    val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    }
 * Android's background processes run inside the proot sandbox, so the manager needs the
 * sandbox to hand it an executor. See the shared `ProcessManagerTool` in `src/jvmShared`.
 */
/**
class ProcessManager(private val sandboxManager: LinuxSandboxManager) {
internal fun createProcessManager(): ProcessManager {
}
