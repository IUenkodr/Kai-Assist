
                // (sentinel arrived) or there's no in-flight command anymore.
                // Stop escalating as soon as the in-flight command finishes
                Result(exitCode = -1, cwd = "/root", bashPid = bashPid ?: 0, shellDied = true),
                command = "kids=\$(pgrep -P $parentPid); [ -n \"\$kids\" ] && kill -$signal \$kids",
                delay(500.milliseconds)
                if (done == null || done == true) return@launch
                reset()
                return
                return@withLock timeoutMap(sink, stderr = "Command timed out and shell was reset")
                sendSignalToChildren(pid, signal)
                sink.done.complete(Result(exitCode = exit, cwd = cwd, bashPid = pid))
                timeoutSeconds = 5,
                val cwd = parts[3]
                val done = currentSink.get()?.done?.isCompleted
                val exit = parts[1].toIntOrNull() ?: -1
                val pid = parts[2].toIntOrNull() ?: 0
            "cwd" to result.cwd,
            "exit_code" to if (timedOut) -1 else result.exitCode,
            "printf '\\n\\036%s\\037%d\\037%d\\037%s\\036\\n' '$nonce' \"\$__kai_st\" \"\$\$\" \"\$PWD\" >&2"
            "shell_died" to (shellDied || result.shellDied),
            "stderr" to stderr.smartTruncate(MAX_OUTPUT_LENGTH),
            "stdout" to sink.stdoutBuf.toString().smartTruncate(MAX_OUTPUT_LENGTH),
            "success" to (!timedOut && !shellDied && !result.shellDied && result.exitCode == 0),
            "timed_out" to timedOut,
            )
            // Even SIGKILL didn't free us — the shell itself must be wedged.
            // Hung command. Try a graduated cancel; if that doesn't shake it
            // No pid captured yet — the user expects cancel to actually do
            // Shell died. Wake up any in-flight command with a shellDied result
            // loose within a short grace, reset the shell.
            // so callers don't sit on a sentinel that will never come.
            // something, so nuke the shell. The next run lazily restarts it.
            Result(exitCode = -1, cwd = "/root", bashPid = 0, shellDied = true),
            bashPid = null
            cancelForeground()
            cmdFile.writeText(command)
            command = "exec bash --noprofile --norc",
            currentSink.getAndSet(null)?.done?.complete(
            currentSink.set(null)
            executor.execute(
            for (signal in listOf("INT", "TERM", "KILL")) {
            h.awaitExit()
            handle = null
            if (parts.size == 4 && parts[0] == sink.nonce) {
            if (recovered == null) {
            if (tail.isEmpty()) "Shell session ended" else "$tail\nShell session ended"
            onStderr = { line -> dispatchStderr(line) },
            onStdout = { line -> dispatchStdout(line) },
            pidText.toIntOrNull()?.let { bashPid = it }
            reset()
            return
            return@withLock buildResult(sink, recovered, timedOut = true)
            return@withLock buildResult(sink, result, shellDied = true)
            return@withLock errorMap(stderr = "Failed to stage command: ${e.message}")
            sink.stderrBuf.toString()
            val parts = payload.split(US)
            val payload = line.substring(1, line.length - 1)
            val pidText = line.substring(PID_PROBE_PREFIX.length, line.length - 1)
            val recovered = withTimeoutOrNull(2.seconds) { sink.done.await() }
            val tail = sink.stderrBuf.toString()
            }
        "cwd" to "/root",
        "exit_code" to -1,
        "shell_died" to false,
        "shell_died" to true,
        "stderr" to (sink.stderrBuf.toString() + "\n" + stderr).smartTruncate(MAX_OUTPUT_LENGTH),
        "stderr" to stderr,
        "stdout" to "",
        "stdout" to sink.stdoutBuf.toString().smartTruncate(MAX_OUTPUT_LENGTH),
        "success" to false,
        "timed_out" to false,
        "timed_out" to true,
        )
        // Capture bash's pid before any user command runs. The dispatcher
        // Fail any in-flight command.
        // Leading \n flushes any partial stderr line (e.g. Python's >>> prompt
        // Non-interactive bash. We have no tty, so -i would only emit prompts
        // Sentinel format: \x1e<nonce>\x1f<exit>\x1f<pid>\x1f<pwd>\x1e
        // Source the user command (preserves cwd/env), capture exit, emit sentinel.
        // Startup pid probe — handled regardless of whether a sink is active.
        // Suppress blank stderr lines. Sentinel emission prepends \n to flush
        // We use pgrep + xargs kill because some busybox builds don't have
        // any partial line ahead of it, which produces a stray empty line when
        // clean; bash still reads commands from stdin line by line, executes
        // it is a worthwhile tradeoff for clean output.
        // pgrep/pkill come from busybox and are present in the base rootfs.
        // pkill -P. Failure is swallowed; this is best-effort.
        // recognizes this marker on stderr and sets bashPid, so cancel on
        // stdin to any foreground child (so ssh can read passwords typed via
        // the sentinel pattern below — flushes any partial line first.
        // the very first command has something to signal. Leading \n matches
        // them in-process (so cd/export/. preserve state), and inherits its
        // there's nothing to flush. Legitimate blank stderr is rare; dropping
        // to stderr that we'd have to filter. --noprofile/--norc keep the env
        // with no trailing newline) so the sentinel arrives on a clean line.
        // writeInput).
        appendBounded(sink.stderrBuf, line)
        appendBounded(sink.stdoutBuf, line)
        bashPid = null
        bashPid = result.bashPid
        command: String,
        currentSink.getAndSet(null)?.done?.complete(
        currentSink.set(null)
        currentSink.set(sink)
        ensureShell()
        h.writeLine("printf '\\n\\036KAIBASHPID\\037%d\\036\\n' \"\$\$\" >&2")
        handle = h
        handle = null
        handle?.cancel()
        handle?.writeLine(line)
        if (handle != null) return
        if (line.isEmpty()) return
        if (line.length >= 2 && line.startsWith(RS) && line.endsWith(RS)) {
        if (line.startsWith(PID_PROBE_PREFIX) && line.endsWith(RS)) {
        if (pid == null) {
        if (result == null) {
        if (result.shellDied) {
        onStderr: ((String) -> Unit)? = null,
        onStdout: ((String) -> Unit)? = null,
        result: Result,
        return mapOf(
        return@withLock buildResult(sink, result)
        runCatching {
        scope.launch {
        shellDied: Boolean = false,
        sink.onStderr?.invoke(line)
        sink.onStdout?.invoke(line)
        sink: CommandSink,
        timedOut: Boolean = false,
        timeoutSeconds: Long,
        try {
        val bashPid: Int,
        val cmdFile = File(tmpPath, ".kai_cmd_$nonce")
        val cwd: String,
        val done: CompletableDeferred<Result> = CompletableDeferred(),
        val exitCode: Int,
        val h = executor.executeStreaming(
        val line = ". /tmp/.kai_cmd_$nonce; __kai_st=\$?; rm -f /tmp/.kai_cmd_$nonce; " +
        val nonce = randomNonce()
        val nonce: String,
        val onStderr: ((String) -> Unit)? = null,
        val onStdout: ((String) -> Unit)? = null,
        val pid = bashPid
        val result = withTimeoutOrNull(timeoutSeconds.seconds) { sink.done.await() }
        val shellDied: Boolean = false,
        val sink = CommandSink(nonce = nonce, onStdout = onStdout, onStderr = onStderr)
        val sink = currentSink.get() ?: return
        val stderr = if (shellDied || result.shellDied) {
        val stderrBuf: StringBuilder = StringBuilder(),
        val stdoutBuf: StringBuilder = StringBuilder(),
        watchdog = null
        watchdog = scope.launch {
        watchdog?.cancel()
        }
        } catch (e: Exception) {
        } else {
     * Best-effort interrupt of the foreground command without killing the
     * Concurrent calls are serialized by an internal mutex.
     * Falls back to a full shell reset if the pid isn't known yet (probe race)
     * Forward a stdin line to the running command. The shell's stdin is also
     * Run a single command in the persistent shell. Suspends until the
     * discipline, so we send signals to bash's children from a sibling proot.
     * interactive input (e.g. ssh password prompts) to the running process.
     * or if even SIGKILL doesn't free the foreground.
     * sentinel is observed, the per-command timeout fires, or the shell dies.
     * shell itself. Without a PTY we can't deliver SIGINT through line
     * the foreground command's stdin (no redirection), so this delivers
     */
    )
    ): Map<String, Any> = mutex.withLock {
    ): Map<String, Any> {
    /**
    /** Tear down the shell. Next [run] will lazily restart it. */
    @Volatile private var bashPid: Int? = null
    @Volatile private var handle: ProotHandle? = null
    buf.append(line)
    data class Result(
    fun cancelForeground() {
    fun reset() {
    fun writeInput(line: String) {
    if (buf.isNotEmpty()) buf.append('\n')
    if (buf.length >= MAX_OUTPUT_LENGTH) return
    private class CommandSink(
    private fun buildResult(
    private fun dispatchStderr(line: String) {
    private fun dispatchStdout(line: String) {
    private fun ensureShell() {
    private fun errorMap(stderr: String): Map<String, Any> = mapOf(
    private fun sendSignalToChildren(parentPid: Int, signal: String) {
    private fun timeoutMap(sink: CommandSink, stderr: String): Map<String, Any> = mapOf(
    private val currentSink = AtomicReference<CommandSink?>(null)
    private val executor: ProotExecutor,
    private val mutex = Mutex()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val tmpPath: String,
    private var watchdog: Job? = null
    suspend fun run(
    }
) {
// Marker emitted once at shell startup so we know bash's pid before any user
// Sentinel uses ASCII Record Separator (0x1e) and Unit Separator (0x1f),
// command has finished. Without this, cancel on the first command had nothing
// emitted to stderr so user redirects of stdout don't swallow it. Octal
// escapes for portability across bash/busybox printf.
// to signal (bashPid was null, set only from the sentinel of a completed run).
class PersistentSandboxShell(
import com.inspiredandroid.kai.linux.ProotHandle
import com.inspiredandroid.kai.smartTruncate
import java.io.File
import java.util.concurrent.atomic.AtomicReference
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
package com.inspiredandroid.kai.sandbox
private const val MAX_OUTPUT_LENGTH = 15_000
private const val PID_PROBE_PREFIX = "${RS}KAIBASHPID$US"
private const val RS = ""
private const val US = ""
private fun appendBounded(buf: StringBuilder, line: String) {
private fun randomNonce(): String = (0 until 16).map { "0123456789abcdef".random() }.joinToString("")
}
