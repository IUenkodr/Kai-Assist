
                    if (cancelled.get()) break
                    stream.read(buf)
                    throw e
                CompletableFuture.runAsync { streamBytes(process.errorStream, cancelled, onOutput) },
                CompletableFuture.runAsync { streamBytes(process.inputStream, cancelled, onOutput) },
                if (n < 0) break
                if (n > 0) onOutput(buf, n)
                val n = try {
                }
                } catch (e: IOException) {
            """.trimMargin()
            )
            command = wrapWithPty(command),
            guestPidFile = pidFile,
            listOf(
            runCatching { stream.close() }
            while (!cancelled.get()) {
            workingDir = workingDir,
            |
            |                    break
            |                break
            |                data = os.read(master, 8192)
            |                if e.errno == errno.EIO:
            |                os.write(master, data)
            |                raise
            |                stdin_open = False
            |            # Short timeout so we notice UI resize without extra IPC.
            |            continue
            |            data = os.read(0, 8192)
            |            else:
            |            except OSError as e:
            |            if not data:
            |            os.kill(pid, signal.SIGWINCH)
            |            os.write(1, data)
            |            parts = f.read().split()
            |            pass
            |            poll_winsize()
            |            r, _, _ = select.select(rfds, [], [], 0.05)
            |            return
            |            rfds.append(0)
            |            try:
            |        except (InterruptedError, select.error):
            |        except OSError:
            |        if len(parts) < 2:
            |        if master in r:
            |        if nr < 1 or nc < 1 or get_winsize(master) == (nr, nc):
            |        if stdin_open and 0 in r:
            |        if stdin_open:
            |        nr, nc = int(parts[0]), int(parts[1])
            |        os.close(master)
            |        pass
            |        poll_winsize()
            |        rfds = [master]
            |        set_winsize(master, nr, nc)
            |        try:
            |        with open(WS_PATH, 'r') as f:
            |    # Compared against the PTY's real size, not the last value written:
            |    # Prefer a clean dynamic-linker search inside the rootfs.
            |    # anything inside the guest that sets the size itself (a login script
            |    # running stty, an app resizing its own tty) would otherwise stick, and
            |    # struct winsize { row, col, xpixel, ypixel }
            |    # the app would keep drawing at a width the host viewport never had.
            |    except (OSError, ValueError, struct.error):
            |    except OSError:
            |    fcntl.ioctl(fd, termios.TIOCSWINSZ, struct.pack('HHHH', r, c, 0, 0))
            |    os._exit(127)
            |    os.environ.pop('LD_LIBRARY_PATH', None)
            |    os.environ['COLORTERM'] = 'truecolor'
            |    os.environ['COLUMNS'] = str(COLS)
            |    os.environ['LINES'] = str(ROWS)
            |    os.environ['TERM'] = 'xterm-256color'
            |    os.execvp('/bin/bash', ['bash', '-lc', cmd])
            |    os.kill(pid, signal.SIGWINCH)
            |    packed = fcntl.ioctl(fd, termios.TIOCGWINSZ, struct.pack('HHHH', 0, 0, 0, 0))
            |    pass
            |    r, c, _, _ = struct.unpack('HHHH', packed)
            |    raise SystemExit(os.WEXITSTATUS(status))
            |    raise SystemExit(os.waitstatus_to_exitcode(status))
            |    return r, c
            |    set_winsize(master, ROWS, COLS)
            |    try:
            |    while True:
            |# Host writes "rows cols" here (bind-mounted /tmp) when the UI resizes.
            |ROWS, COLS = $rows, $columns
            |WS_PATH = '$winsizePath'
            |_, status = os.waitpid(pid, 0)
            |cmd = base64.b64decode('$cmdB64').decode()
            |def get_winsize(fd):
            |def poll_winsize():
            |def set_winsize(fd, r, c):
            |except OSError:
            |finally:
            |if hasattr(os, 'waitstatus_to_exitcode'):
            |if os.WIFEXITED(status):
            |if pid == 0:
            |import base64, errno, fcntl, os, pty, select, signal, struct, sys, termios
            |pid, master = pty.fork()
            |raise SystemExit(1)
            |stdin_open = True
            |try:
            }
        ) { process, cancelled ->
        // `$$` is this shell's pid and `exec` keeps it for python, so the file holds
        // the bridge's real pid — that is what cancelling a session has to kill.
        cancelled: AtomicBoolean,
        command = command,
        command: String,
        maxOutputChars = MAX_OUTPUT_CHARS,
        onOutput: (ByteArray, Int) -> Unit,
        return """echo $dollar > /tmp/$pidFileName; exec python3 -c "import base64;exec(base64.b64decode('$scriptB64'))""""
        return launcher.startStreaming(
        runCatching { pidFile.delete() }
        stream: java.io.InputStream,
        timeoutSeconds = timeoutSeconds,
        timeoutSeconds: Long = 120,
        try {
        val buf = ByteArray(4096)
        val cmdB64 = Base64.getEncoder().encodeToString(command.toByteArray(Charsets.UTF_8))
        val dollar = "${'$'}${'$'}"
        val pidFile = File(tmpPath, pidFileName)
        val script = """
        val scriptB64 = Base64.getEncoder().encodeToString(script.toByteArray(Charsets.UTF_8))
        workingDir = workingDir,
        workingDir: String = "/root",
        workingDir: String,
        }
        } finally {
     *
     * Important: we do **not** use bare `pty.spawn` alone — TUI apps (Grok, etc.) query
     * Interactive session: PTY inside the guest, raw byte stream to [onOutput].
     * Runs [command] under a real PTY via python3 (always installed with base packages).
     * `pty.fork()`, set winsize, SIGWINCH, then bridge master ↔ stdio.
     * size via `TIOCGWINSZ`. A fresh PTY is often 0×0, so they paint nothing. We
     * stderr is merged onto the PTY by python's pty.spawn; any leftover host
     * stderr is still forwarded.
     */
    )
    ) {
    ): ProotHandle {
    ): ProotResult = launcher.execute(
    /**
    /** File name (inside the bind-mounted tmp dir) the PTY bridge records its pid in. */
    /** Guest path the host writes "rows cols" to — one file per live session. */
    fun execute(
    fun executeStreaming(
    private fun streamBytes(
    private fun wrapWithPty(command: String): String {
    private val columns: Int = 80,
    private val launcher: ProotLauncher,
    private val pidFileName: String = "kai-pid",
    private val rows: Int = 24,
    private val tmpPath: String,
    private val winsizePath: String = "/tmp/kai-winsize",
    }
 *
 * Kai Build's view of a rootfs: interactive sessions under a real PTY, raw
 * The proot invocation itself — argv, binds, environment — comes from the
 * bytes rather than lines.
 * shared [ProotLauncher], the same one the chat sandbox uses.
 */
) {
/**
/** Install logs are worth keeping in full; the shell tool's 15k cap is not enough. */
class BuildProotExecutor(
import com.inspiredandroid.kai.linux.ProotHandle
import com.inspiredandroid.kai.linux.ProotLauncher
import com.inspiredandroid.kai.linux.ProotResult
import java.io.File
import java.io.IOException
import java.util.Base64
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
package com.inspiredandroid.kai.build.runtime
private const val MAX_OUTPUT_CHARS = 200_000
}
