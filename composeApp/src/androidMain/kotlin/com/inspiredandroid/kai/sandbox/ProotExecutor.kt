
                    if (cancelled.get()) break
                    reader.readLine()
                    throw e
                onLine(line)
                streamLines(process.errorStream.bufferedReader(), cancelled, onStderr)
                streamLines(process.inputStream.bufferedReader(), cancelled, onStdout)
                val line = try {
                } ?: break
                } catch (e: IOException) {
            "exit_code" to result.exitCode,
            "stderr" to result.stderr,
            "stdout" to result.stdout,
            "success" to result.success,
            "timed_out" to result.timedOut,
            CompletableFuture.runAsync {
            command = command,
            extraEnv = extraEnv,
            maxOutputChars = MAX_OUTPUT_LENGTH,
            result.error?.let { return mapOf("success" to false, "error" to it) }
            runCatching { reader.close() }
            timeoutSeconds = timeoutSeconds.coerceIn(1, MAX_TIMEOUT_SECONDS),
            while (!cancelled.get()) {
            workingDir = workingDir,
            }
            },
        )
        cancelled: AtomicBoolean,
        command = command,
        command: String,
        extraEnv = extraEnv,
        extraEnv: Map<String, String> = emptyMap(),
        if (!result.success && result.stdout.isEmpty() && result.stderr.isEmpty() && !result.timedOut) {
        listOf(
        onLine: (String) -> Unit,
        onStderr: (String) -> Unit,
        onStdout: (String) -> Unit,
        reader: BufferedReader,
        return mapOf(
        timeoutSeconds: Long = DEFAULT_TIMEOUT_SECONDS,
        try {
        val result = launcher.execute(
        workingDir = workingDir,
        workingDir: String = "/root",
        }
        } finally {
    ) {
    ) { process, cancelled ->
    ): Map<String, Any> {
    ): ProotHandle = launcher.startStreaming(
    fun execute(
    fun executeStreaming(
    private fun streamLines(
    }
 *
 * Everything about starting the process — argv, binds, environment — lives in
 * The chat sandbox's view of a rootfs: line-oriented output over pipes, and
 * results shaped as the map the shell tool and background jobs already consume.
 * the shared [ProotLauncher], which Kai Build's PTY executor uses too.
 */
/**
class ProotExecutor(private val launcher: ProotLauncher) {
import com.inspiredandroid.kai.linux.ProotHandle
import com.inspiredandroid.kai.linux.ProotLauncher
import java.io.BufferedReader
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
package com.inspiredandroid.kai.sandbox
private const val DEFAULT_TIMEOUT_SECONDS = 30L
private const val MAX_OUTPUT_LENGTH = 15_000
private const val MAX_TIMEOUT_SECONDS = 180L
}
