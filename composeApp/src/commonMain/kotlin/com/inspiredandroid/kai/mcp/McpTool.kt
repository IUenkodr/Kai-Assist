
                        // Skip malformed properties
                        put(name, ParameterSchema(type, description, name in required, rawSchema = propObj))
                        val description = propObj["description"]?.jsonPrimitive?.content ?: ""
                        val propObj = prop.jsonObject
                        val type = propObj["type"]?.jsonPrimitive?.content ?: "string"
                    try {
                    }
                    } catch (_: Exception) {
                emptySet()
                for ((name, prop) in properties) {
                inputSchema["required"]?.jsonArray?.map { it.jsonPrimitive.content }?.toSet() ?: emptySet()
                put(key, anyToJsonElement(value))
                }
            for ((key, value) in args) {
            if (inputSchema == null) return emptyMap()
            mapOf("success" to false, "error" to (e.message ?: "MCP tool call failed"))
            mapOf("success" to true, "result" to result)
            return buildMap {
            val properties = inputSchema["properties"]?.jsonObject ?: return emptyMap()
            val required = try {
            val result = client.callTool(metadata.name, jsonArgs)
            value.entries.associate { (k, v) -> k.toString() to anyToJsonElement(v) },
            }
            } catch (_: Exception) {
        )
        description = metadata.description,
        else -> JsonPrimitive(value.toString())
        fun convertInputSchema(inputSchema: JsonObject?): Map<String, ParameterSchema> {
        fun toolId(serverId: String, toolName: String): String = "mcp_${serverId}_$toolName"
        is Boolean -> JsonPrimitive(value)
        is Double -> JsonPrimitive(value)
        is Int -> JsonPrimitive(value)
        is List<*> -> JsonArray(value.map { anyToJsonElement(it) })
        is Long -> JsonPrimitive(value)
        is Map<*, *> -> JsonObject(
        is Number -> JsonPrimitive(value)
        is String -> JsonPrimitive(value)
        name = metadata.name,
        null -> JsonNull
        parameters = convertInputSchema(metadata.inputSchema),
        return try {
        val jsonArgs = buildJsonObject {
        }
        } catch (e: Exception) {
    )
    companion object {
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema: ToolSchema = ToolSchema(
    override val timeout: Duration = 60.seconds
    private fun anyToJsonElement(value: Any?): JsonElement = when (value) {
    private val client: McpClient,
    private val metadata: McpToolMetadata,
    }
) : Tool {
class McpTool(
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolSchema
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
package com.inspiredandroid.kai.mcp
}
