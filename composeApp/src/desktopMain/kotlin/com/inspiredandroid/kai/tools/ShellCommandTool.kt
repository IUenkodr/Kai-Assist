package com.inspiredandroid.kai.tools
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.smartTruncate
import java.io.BufferedReader
import java.io.File
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_execute_shell_command_description
import kai.composeapp.generated.resources.tool_execute_shell_command_name

                    "exit_code" to -1,
                    "stderr" to stderrFuture.get(1, TimeUnit.SECONDS).smartTruncate(MAX_OUTPUT_LENGTH),
                    "stdout" to stdoutFuture.get(1, TimeUnit.SECONDS).smartTruncate(MAX_OUTPUT_LENGTH),
                    "success" to false,
                    "timed_out" to true,
                "error" to (e.message ?: "Failed to execute command"),
                "exit_code" to exitCode,
                "stderr" to stderr,
                "stdout" to stdout,
                "success" to (exitCode == 0),
                "success" to false,
                "timed_out" to false,
                )
                ProcessBuilder("cmd", "/c", command)
                ProcessBuilder("sh", "-c", command)
                process.destroyForcibly()
                processBuilder.directory(workingDir)
                processBuilder.environment().putAll(envMap)
                readBounded(process.errorStream.bufferedReader())
                readBounded(process.inputStream.bufferedReader())
                return mapOf(
            "background" to ParameterSchema("boolean", "Run in background and return immediately with a session_id. Use manage_process tool to check status.", false),
            "command" to ParameterSchema("string", "The shell command to execute", true),
            "env" to ParameterSchema("object", "Environment variables to set (key-value pairs). Cannot override PATH or LD_PRELOAD.", false),
            "timeout" to ParameterSchema("integer", "Timeout in seconds (default $DEFAULT_TIMEOUT_SECONDS, max $MAX_TIMEOUT_SECONDS)", false),
            "working_dir" to ParameterSchema("string", "Working directory for the command", false),
            )
            .coerceIn(1, MAX_TIMEOUT_SECONDS)
            // Drain stdout/stderr concurrently to avoid pipe buffer deadlock
            ?.filterKeys { it.uppercase() !in BLOCKED_ENV_VARS }
            ?.mapValues { it.value.toString() }
            ?: emptyMap()
            ?: return mapOf("success" to false, "error" to "Command is required")
            if (!completed) {
            if (envMap.isNotEmpty()) {
            if (workingDir != null && workingDir.isDirectory) {
            mapOf(
            processBuilder.redirectErrorStream(false)
            return ProcessManagerTool.processManager.startBackground(command, timeoutSeconds, workingDir, envMap)
            return mapOf("success" to false, "error" to "Command is blocked for safety reasons")
            val completed = process.waitFor(timeoutSeconds, TimeUnit.SECONDS)
            val exitCode = process.exitValue()
            val isWindows = System.getProperty("os.name").lowercase().contains("win")
            val process = processBuilder.start()
            val processBuilder = if (isWindows) {
            val stderr = stderrFuture.get().smartTruncate(MAX_OUTPUT_LENGTH)
            val stderrFuture = CompletableFuture.supplyAsync {
            val stdout = stdoutFuture.get().smartTruncate(MAX_OUTPUT_LENGTH)
            val stdoutFuture = CompletableFuture.supplyAsync {
            }
            } else {
        "mac" in osName || "darwin" in osName -> "macOS"
        "win" in osName -> "Windows"
        ),
        description = "Execute a shell command on the device",
        description = buildDescription(),
        descriptionRes = Res.string.tool_execute_shell_command_description,
        else -> "Linux"
        id = "execute_shell_command",
        if (background) {
        if (isBlocked(command)) {
        if (sb.length >= MAX_OUTPUT_LENGTH) break
        isEnabled = false,
        name = "Execute Shell Command",
        name = "execute_shell_command",
        nameRes = Res.string.tool_execute_shell_command_name,
        parameters = mapOf(
        return try {
        sb.append(buf, 0, read)
        val background = args["background"] as? Boolean ?: false
        val command = args["command"] as? String
        val envMap = (args["env"] as? Map<String, Any>)
        val timeoutSeconds = ((args["timeout"] as? Number)?.toLong() ?: DEFAULT_TIMEOUT_SECONDS)
        val workingDir = (args["working_dir"] as? String)?.let { File(it) }
        while (reader.read(buf) != -1) { /* discard */ }
        }
        } catch (e: Exception) {
    "DYLD_FRAMEWORK_PATH",
    "DYLD_INSERT_LIBRARIES",
    "DYLD_LIBRARY_PATH",
    "LD_LIBRARY_PATH",
    "LD_PRELOAD",
    "PATH",
    )
    // Drain remaining to unblock the process even if we stop collecting
    @Suppress("UNCHECKED_CAST")
    Regex(""":\(\)\s*\{.*\|.*&\s*\}\s*;?\s*:"""), // fork bomb
    Regex(""">\s*/dev/[sh]d[a-z]"""), // > /dev/sda
    Regex("""\bhalt\b"""), // halt
    Regex("""\binit\s+[06]\b"""), // init 0 / init 6
    Regex("""\bpoweroff\b"""), // poweroff
    Regex("""\breboot\b"""), // reboot
    Regex("""\bshutdown\b"""), // shutdown
    Regex("""chmod\s+-[^\s]*R[^\s]*\s+[0-7]+\s+/(?:\s|$)"""), // chmod -R 777 /
    Regex("""dd\s+.*if=/dev/(zero|urandom|random)"""), // dd overwrite disk
    Regex("""format\s+[A-Za-z]:"""), // Windows format C:
    Regex("""mkfs\."""), // mkfs.ext4, mkfs.ntfs, etc.
    Regex("""rm\s+-[^\s]*r[^\s]*\s+/(?:\s|$)"""), // rm -rf /
    Regex("""rm\s+-[^\s]*r[^\s]*\s+/\*"""), // rm -rf /*
    Regex("""rm\s+-[^\s]*r[^\s]*\s+~(?:\s|$)"""), // rm -rf ~
    Regex("""rm\s+-[^\s]*r[^\s]*\s+~/\*"""), // rm -rf ~/*
    if (sb.length >= MAX_OUTPUT_LENGTH) {
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema = ToolSchema(
    return """Execute a shell command on the host machine ($platform, shell: $shell) and return stdout, stderr, and exit code.
    return sb.toString()
    val buf = CharArray(8192)
    val osName = System.getProperty("os.name", "").lowercase()
    val platform = when {
    val sb = StringBuilder()
    val shell = if ("win" in osName) "cmd.exe" else "sh"
    val toolInfo = ToolInfo(
    var read: Int
    while (reader.read(buf).also { read = it } != -1) {
    }
)
Default timeout: ${DEFAULT_TIMEOUT_SECONDS}s, max: ${MAX_TIMEOUT_SECONDS}s.
Each command runs in a fresh shell — use "cd dir && command" for directory changes.
Output is limited to ${MAX_OUTPUT_LENGTH} characters per stream; for large output, pipe through head/tail.
Set background=true to run long-lived processes (servers, builds). Use the manage_process tool to check on them."""
Use for file operations, system info, running scripts, installing packages, etc.
object ShellCommandTool : Tool {
private const val DEFAULT_TIMEOUT_SECONDS = 30L
private const val MAX_OUTPUT_LENGTH = 30_000
private const val MAX_TIMEOUT_SECONDS = 120L
private fun buildDescription(): String {
private fun isBlocked(command: String): Boolean = blockedPatterns.any { it.containsMatchIn(command) }
private fun readBounded(reader: BufferedReader): String {
private val BLOCKED_ENV_VARS = setOf(
private val blockedPatterns = listOf(
}
