import com.inspiredandroid.kai.getAvailableTools
import com.inspiredandroid.kai.getPlatformToolDefinitions
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.smartTruncate
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import org.jetbrains.compose.resources.getString

                            k.toString() to anyToJsonElement(v)
                        result.entries.associate { (k, v) ->
                        },
                    )
                    jsonParser.encodeToString(JsonElement.serializer(), jsonObject)
                    tool.execute(args)
                    val jsonObject = JsonObject(
                    withContext(ConversationIdElement(conversationId)) { tool.execute(args) }
                else -> """{"result": "$result"}"""
                if (conversationId != null) {
                is Map<*, *> -> {
                is String -> result
                }
                } else {
            """{"success": false, "error": "Tool '$name' timed out after ${tool.timeout}"}"""
            """{"success": false, "error": "Tool execution failed: ${e.message}"}"""
            // Cooperative cancellation (user pressed stop) must propagate, not become a
            // fake tool result the loop would keep reasoning about.
            ?: return """{"success": false, "error": "Unknown tool: $name"}"""
            element.booleanOrNull != null -> element.boolean
            element.doubleOrNull != null -> element.double
            element.intOrNull != null -> element.int
            element.isString -> element.content
            else -> element.content
            parseJsonToMap(arguments)
            return """{"success": false, "error": "Failed to parse arguments: ${e.message}"}"""
            throw e
            truncateResult(resultString)
            val result = withTimeout(tool.timeout) {
            val resultString = when (result) {
            value.entries.associate { (k, v) -> k.toString() to anyToJsonElement(v) },
            }
        )
        JsonNull -> "null"
        arguments: String,
        conversationId: String? = null,
        else -> JsonPrimitive(value.toString())
        is Boolean -> JsonPrimitive(value)
        is JsonArray -> element.map { jsonElementToAny(it) }
        is JsonObject -> element.entries.associate { (k, v) -> k to jsonElementToAny(v) }
        is JsonPrimitive -> when {
        is List<*> -> JsonArray(value.map { anyToJsonElement(it) })
        is Map<*, *> -> JsonObject(
        is Number -> JsonPrimitive(value)
        is String -> JsonPrimitive(value)
        key to jsonElementToAny(value)
        name: String,
        null -> JsonNull
        return jsonObject.toMap()
        return toolInfo.nameRes?.let { getString(it) } ?: toolInfo.name
        return try {
        val args = try {
        val jsonObject = jsonParser.parseToJsonElement(json).jsonObject
        val tool = tools.find { it.schema.name == name }
        val toolInfo = getPlatformToolDefinitions().find { it.id == toolId } ?: return toolId
        val tools = toolsProvider()
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } catch (e: TimeoutCancellationException) {
    ): String {
    private fun JsonObject.toMap(): Map<String, Any> = entries.associate { (key, value) ->
    private fun anyToJsonElement(value: Any?): JsonElement = when (value) {
    private fun jsonElementToAny(element: JsonElement): Any = when (element) {
    private fun parseJsonToMap(json: String): Map<String, Any> {
    private fun truncateResult(result: String): String = result.smartTruncate(MAX_TOOL_RESULT_LENGTH)
    private val jsonParser = Json { ignoreUnknownKeys = true }
    private val toolsProvider: () -> List<Tool> = { getAvailableTools() },
    suspend fun executeTool(
    suspend fun getToolDisplayName(toolId: String): String {
    }
) {
class ToolExecutor(
package com.inspiredandroid.kai.data
private const val MAX_TOOL_RESULT_LENGTH = 20_000
}
