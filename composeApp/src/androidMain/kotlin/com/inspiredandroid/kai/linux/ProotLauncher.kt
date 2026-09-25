import com.inspiredandroid.kai.smartTruncate
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

                    process.outputStream.flush()
                    process.outputStream.write(data)
                error = "Timed out after ${timeoutSeconds}s",
                exitCode = process.exitValue(),
                if (cancelled.get()) return@execute
                if (sb.length >= maxChars) break
                runCatching {
                sb.append(buf, 0, read)
                stderr = stderr.get().smartTruncate(maxOutputChars),
                stderr = stderr.get(1, TimeUnit.SECONDS).smartTruncate(maxOutputChars),
                stdout = stdout.get().smartTruncate(maxOutputChars),
                stdout = stdout.get(1, TimeUnit.SECONDS).smartTruncate(maxOutputChars),
                success = false,
                success = process.exitValue() == 0,
                timedOut = true,
                while (reader.read(buf) != -1) { /* discard */ }
                }
            "HOME" to "/root",
            "LANG" to "C.UTF-8",
            "LD_LIBRARY_PATH" to libDir,
            "PATH" to DEFAULT_GUEST_PATH,
            "PROOT_LOADER" to loaderPath,
            "PROOT_TMP_DIR" to tmpPath,
            "TERM" to "xterm-256color",
            )
            // Return what we have so the timed-out path can surface a clean result.
            // Stream closed under us (typically destroyForcibly on timeout).
            ProotResult(
            if (sb.length >= maxChars) {
            process.destroyForcibly()
            readBounded(process.errorStream.bufferedReader(), maxOutputChars)
            readBounded(process.inputStream.bufferedReader(), maxOutputChars)
            runCatching { process.waitFor(200, TimeUnit.MILLISECONDS) }
            var read: Int
            while (reader.read(buf).also { read = it } != -1) {
            writer.execute {
            }
        )
        // Destroying the proot process alone does not end a PTY session: proot
        // On Linux, close(fd) does NOT unblock a thread already inside read(fd),
        // Poll so a cancel() from another thread can short-circuit the wait.
        // bridge closes the PTY master, which hangs up the shell and lets proot exit.
        // so reader futures can sit waiting on a tracee pipe even after SIGKILL.
        // survives destroyForcibly() here, and its guest children (the bridge and
        // the shell under it) would outlive it as orphans anyway. Killing the
        File(rootfsPath).parentFile,
        ProotResult(success = false, error = e.message ?: "Failed to execute command in sandbox")
        Thread(runnable, "kai-proot-write").apply { isDaemon = true }
        add("--bind=$tmpPath:/tmp")
        add("--bind=/dev")
        add("--bind=/proc")
        add("--bind=/sys")
        add("--rootfs=$rootfsPath")
        add("-0")
        add("-c")
        add("-w")
        add("/bin/sh")
        add(command)
        add(prootPath)
        add(workingDir)
        addAll(extraArgs)
        binds.forEach { (host, guest) -> add("--bind=$host:$guest") }
        buildArgs(command, workingDir),
        buildEnv(extraEnv),
        cancelled.set(true)
        command: String,
        extraEnv: Map<String, String> = emptyMap(),
        guestPidFile: File? = null,
        if (cancelled.get() || data.isEmpty()) return
        if (cancelled.get()) return -1
        if (pid != null && pid > 0) runCatching { android.os.Process.killProcess(pid) }
        if (process.waitFor(timeoutSeconds, TimeUnit.SECONDS)) {
        if (raw.length <= maxChars) return raw
        killGuest()
        maxOutputChars: Int = DEFAULT_MAX_OUTPUT_CHARS,
        process.destroyForcibly()
        readerFutures.forEach { runCatching { it.get(500, TimeUnit.MILLISECONDS) } }
        readers: (Process, AtomicBoolean) -> List<CompletableFuture<Void>>,
        return "…" + raw.takeLast(maxChars)
        return (base + env + extraEnv).map { (k, v) -> "$k=$v" }.toTypedArray()
        return ProotHandle(process, cancelled, readers(process, cancelled), guestPidFile)
        return runCatching { process.exitValue() }.getOrDefault(-1)
        return sb.toString()
        runCatching {
        runCatching { file.delete() }
        runCatching { process.errorStream.close() }
        runCatching { process.inputStream.close() }
        runCatching { process.outputStream.close() }
        runCatching { writer.shutdownNow() }
        timeoutSeconds: Long,
        try {
        val base = mapOf(
        val buf = CharArray(8192)
        val cancelled = AtomicBoolean(false)
        val file = guestPidFile ?: return
        val loaderPath = File(prootPath).parent.orEmpty() + "/libproot-loader.so"
        val pid = runCatching { file.readText().trim().toIntOrNull() }.getOrNull()
        val process = start(command, workingDir, extraEnv)
        val raw = stderr.ifBlank { stdout }.ifBlank { error.orEmpty() }.trim()
        val sb = StringBuilder()
        val stderr = CompletableFuture.supplyAsync {
        val stdout = CompletableFuture.supplyAsync {
        while (!cancelled.get() && process.isAlive) {
        workingDir: String = "/root",
        workingDir: String,
        }
        } catch (_: IOException) {
        } else {
     * (early lines are often only the apt-utils debconf warning).
     * Best available explanation for a failure, trimmed for display.
     * Host-side file the guest bridge wrote its own pid into, for sessions that
     * Prefers the tail of the stream — apt/dpkg put the real error last
     * Runs [command] to completion. stdout and stderr are drained concurrently —
     * reading them in sequence deadlocks as soon as the other pipe's buffer fills.
     * run under a PTY. proot does not namespace pids, so it is a host pid.
     */
    )
    ): Process = Runtime.getRuntime().exec(
    ): ProotHandle {
    ): ProotResult = try {
    /**
    /** Extra host→guest binds on top of `/dev`, `/proc`, `/sys` and `/tmp`. */
    /** Flags the distro cannot work without — see [DistroSpec.prootArgs]. */
    /** Overrides and additions on top of the base environment. */
    /** Writes [line] plus a newline — one command to a shell reading stdin. */
    fun awaitExit(): Int {
    fun cancel() {
    fun execute(
    fun failureDetail(maxChars: Int = 500): String {
    fun isCancelled(): Boolean = cancelled.get()
    fun start(
    fun startStreaming(
    fun writeBytes(data: ByteArray) {
    fun writeLine(line: String) = writeText(line + "\n")
    fun writeText(text: String) = writeBytes(text.toByteArray(Charsets.UTF_8))
    private fun buildArgs(command: String, workingDir: String): Array<String> = buildList {
    private fun buildEnv(extraEnv: Map<String, String>): Array<String> {
    private fun killGuest() {
    private fun readBounded(reader: BufferedReader, maxChars: Int): String {
    private val binds: List<Pair<String, String>>,
    private val cancelled: AtomicBoolean,
    private val env: Map<String, String> = emptyMap(),
    private val extraArgs: List<String> = emptyList(),
    private val guestPidFile: File? = null,
    private val libDir: String,
    private val process: Process,
    private val prootPath: String,
    private val readerFutures: List<CompletableFuture<Void>>,
    private val rootfsPath: String,
    private val tmpPath: String,
    private val writer = Executors.newSingleThreadExecutor { runnable ->
    val error: String? = null,
    val exitCode: Int = -1,
    val stderr: String = "",
    val stdout: String = "",
    val success: Boolean,
    val timedOut: Boolean = false,
    }
    } catch (e: Exception) {
    }.toTypedArray()
 *
 * A running proot process.
 * Builds the proot command line and environment and starts the process. Both the
 * Writes go through one background thread: the pipe write blocks, and
 * chat sandbox's pipe-based executor and Kai Build's PTY executor go through
 * interactive input can arrive on the UI thread a keystroke at a time. A single
 * this; they differ only in how they read what comes back.
 * thread also keeps the bytes in the order they were produced.
 */
) {
/**
/** Default guest PATH. Callers that need vendor bin dirs override it. */
/** Outcome of a one-shot command inside a rootfs. */
class ProotHandle internal constructor(
class ProotLauncher(
const val DEFAULT_GUEST_PATH = "/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
data class ProotResult(
package com.inspiredandroid.kai.linux
private const val DEFAULT_MAX_OUTPUT_CHARS = 15_000
}
