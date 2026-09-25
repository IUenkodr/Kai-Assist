
                    ?: return mapOf("success" to false, "error" to "session_id is required for kill")
                    ?: return mapOf("success" to false, "error" to "session_id is required for log")
                    ?: return mapOf("success" to false, "error" to "session_id is required for remove")
                processManager.kill(sessionId)
                processManager.log(sessionId, offset, limit)
                processManager.remove(sessionId)
                val limit = (args["limit"] as? Number)?.toInt() ?: 200
                val offset = (args["offset"] as? Number)?.toInt() ?: 0
                val sessionId = args["session_id"] as? String
            "action" to ParameterSchema("string", "Action to perform: list, log, kill, or remove", true),
            "kill" -> {
            "limit" to ParameterSchema("integer", "Max lines to return for log (default: 200)", false),
            "list" -> processManager.list()
            "log" -> {
            "offset" to ParameterSchema("integer", "Line offset for log output (default: 0)", false),
            "remove" -> {
            "session_id" to ParameterSchema("string", "Session ID of the process (required for log, kill, remove)", false),
            ?: return mapOf("success" to false, "error" to "Action is required")
            else -> mapOf("success" to false, "error" to "Unknown action: $action. Use: list, log, kill, remove")
            }
        ),
        // Availability follows the execute_shell_command switch, so a switch of its own
        // would read back a setting nothing consults.
        description = """Manage background shell processes started with execute_shell_command (background=true).
        description = "Manage background shell processes",
        descriptionRes = null,
        id = "manage_process",
        isEnabled = false,
        name = "Manage Process",
        name = "manage_process",
        nameRes = null,
        parameters = mapOf(
        return when (action) {
        userToggleable = false,
        val action = args["action"] as? String
        }
    )
    internal val processManager by lazy { createProcessManager() }
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema = ToolSchema(
    override val timeout = 10.seconds
    val toolInfo = ToolInfo(
    }
 * Shared by Android and desktop — the two builds differ only in how the underlying
 * [ProcessManager] reaches its processes (proot sandbox vs. host `ProcessBuilder`), which each
 * identical, so it lives here rather than being maintained twice.
 * source set supplies through its own `createProcessManager()`. The tool surface itself is
 */
- kill: Terminate a running process (params: session_id)
- list: Show all running and finished background processes
- log: Get output from a process (params: session_id, offset, limit)
- remove: Remove a finished process from the list (params: session_id)""",
/**
Actions:
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kotlin.time.Duration.Companion.seconds
object ProcessManagerTool : Tool {
package com.inspiredandroid.kai.tools
}
