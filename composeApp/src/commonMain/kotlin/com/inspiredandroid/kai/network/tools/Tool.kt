
    suspend fun execute(args: Map<String, Any>): Any // Return result as JSON-serializable
    val description: String,
    val name: String,
    val parameters: Map<String, ParameterSchema>, // e.g., type: "string", required: true
    val rawSchema: JsonObject? = null,
    val required: Boolean,
    val schema: ToolSchema
    val timeout: Duration get() = 30.seconds
    val type: String,
)
@Serializable
data class ParameterSchema(
data class ToolSchema(
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
interface Tool {
package com.inspiredandroid.kai.network.tools
}
