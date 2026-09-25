import java.io.File
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

                        session.stderrBuffer.appendLine(line)
                        session.stdoutBuffer.appendLine(line)
                    if (session.stderrBuffer.length < MAX_OUTPUT_LENGTH) {
                    if (session.stdoutBuffer.length < MAX_OUTPUT_LENGTH) {
                    }
                process.destroyForcibly()
                session.exitCode = -1
                session.exitCode = process.exitValue()
                session.timedOut = true
                synchronized(session.stderrBuffer) {
                synchronized(session.stdoutBuffer) {
                }
            "exit_code" to (session.exitCode ?: -1),
            "finished" to finished,
            "message" to "Process started in background. Use manage_process tool to check status.",
            "offset" to offset,
            "running" to running,
            "session_id" to sessionId,
            "status" to "running",
            "status" to if (session.finished) "finished" else "running",
            "stderr" to stderr.takeLast(2000),
            "stdout" to sliced,
            "success" to true,
            "timed_out" to session.timedOut,
            "total" to sessions.size,
            "total_stdout_lines" to stdoutLines.size,
            ?: return mapOf("success" to false, "error" to "Unknown session: $sessionId")
            ProcessBuilder("cmd", "/c", command)
            ProcessBuilder("sh", "-c", command)
            command = command,
            id = sessionId,
            if (!completed) {
            process = process,
            process.errorStream.bufferedReader().forEachLine { line ->
            process.inputStream.bufferedReader().forEachLine { line ->
            processBuilder.directory(workingDir)
            processBuilder.environment().putAll(envMap)
            return mapOf("success" to true, "message" to "Process already finished", "exit_code" to (session.exitCode ?: -1))
            session.finished = true
            session.process.destroyForcibly()
            startTime = System.currentTimeMillis(),
            val completed = process.waitFor(timeoutSeconds, TimeUnit.SECONDS)
            }
            } else {
        "command" to command,
        "duration_seconds" to ((System.currentTimeMillis() - startTime) / 1000),
        "exit_code" to (exitCode ?: -1),
        "session_id" to id,
        "status" to if (finished) "finished" else "running",
        "stdout_length" to stdoutBuffer.length,
        "timed_out" to timedOut,
        )
        // Drain stdout/stderr in background threads with bounded buffers
        // Monitor for completion/timeout
        @Volatile var exitCode: Int? = null,
        @Volatile var finished: Boolean = false,
        @Volatile var timedOut: Boolean = false,
        CompletableFuture.runAsync {
        command: String,
        envMap: Map<String, String>,
        if (!session.finished) {
        if (envMap.isNotEmpty()) {
        if (session.finished) {
        if (workingDir != null && workingDir.isDirectory) {
        processBuilder.redirectErrorStream(false)
        return mapOf(
        return mapOf("success" to true, "message" to "Process killed")
        return mapOf("success" to true, "message" to "Session removed")
        session.exitCode = -1
        session.finished = true
        session.process.destroyForcibly()
        sessions[sessionId] = session
        timeoutSeconds: Long,
        val command: String,
        val finished = sessions.values.filter { it.finished }.map { it.toInfo() }
        val id: String,
        val isWindows = System.getProperty("os.name").lowercase().contains("win")
        val process = processBuilder.start()
        val process: Process,
        val processBuilder = if (isWindows) {
        val running = sessions.values.filter { !it.finished }.map { it.toInfo() }
        val session = Session(
        val session = sessions.remove(sessionId)
        val session = sessions[sessionId]
        val sessionId = "bg-${nextId.getAndIncrement()}"
        val sliced = stdoutLines.drop(offset).take(limit).joinToString("\n")
        val startTime: Long,
        val stderr = synchronized(session.stderrBuffer) { session.stderrBuffer.toString() }
        val stderrBuffer: StringBuilder = StringBuilder(),
        val stdout = synchronized(session.stdoutBuffer) { session.stdoutBuffer.toString() }
        val stdoutBuffer: StringBuilder = StringBuilder(),
        val stdoutLines = stdout.lines()
        workingDir: File?,
        }
        } else {
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
    }
/** Desktop spawns host processes directly, so no collaborators are needed. */
class ProcessManager {
internal fun createProcessManager(): ProcessManager = ProcessManager()
package com.inspiredandroid.kai.tools
private const val MAX_OUTPUT_LENGTH = 30_000
}
