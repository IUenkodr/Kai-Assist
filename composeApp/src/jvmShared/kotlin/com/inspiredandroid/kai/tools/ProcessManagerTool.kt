package com.inspiredandroid.kai.tools

import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

object ProcessManagerTool : Tool {
    override val timeout: Duration = 10.seconds

    override val schema = ToolSchema(
        name = "manage_process",
        description = "Manage background shell processes",
        parameters = mapOf(
            "action" to ParameterSchema(
                type = "string",
                description = "Action to perform: list, log, kill, or remove",
                required = true,
            ),
            "session_id" to ParameterSchema(
                type = "string",
                description = "Session ID of the process",
                required = false,
            ),
            "offset" to ParameterSchema(
                type = "integer",
                description = "Line offset for log output",
                required = false,
            ),
            "limit" to ParameterSchema(
                type = "integer",
                description = "Maximum number of log lines",
                required = false,
            ),
        ),
    )

    private val processManager by lazy { createProcessManager() }

    override suspend fun execute(args: Map<String, Any>): Any {
        val action = args["action"] as? String
            ?: return mapOf("success" to false, "error" to "Action is required")

        val sessionId = args["session_id"] as? String
        val offset = (args["offset"] as? Number)?.toInt() ?: 0
        val limit = (args["limit"] as? Number)?.toInt() ?: 200

        return when (action) {
            "list" -> processManager.list()
            "log" -> {
                sessionId ?: return mapOf("success" to false, "error" to "session_id is required for log")
                processManager.log(sessionId, offset, limit)
            }
            "kill" -> {
                sessionId ?: return mapOf("success" to false, "error" to "session_id is required for kill")
                processManager.kill(sessionId)
            }
            "remove" -> {
                sessionId ?: return mapOf("success" to false, "error" to "session_id is required for remove")
                processManager.remove(sessionId)
            }
            else -> mapOf("success" to false, "error" to "Unknown action: $action")
        }
    }
}

