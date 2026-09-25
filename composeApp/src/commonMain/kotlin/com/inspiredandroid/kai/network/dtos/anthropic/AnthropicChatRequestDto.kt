
        val content: JsonElement,
        val description: String,
        val description: String? = null,
        val enum: List<String>? = null,
        val input_schema: InputSchema,
        val items: PropertySchema? = null,
        val name: String,
        val properties: Map<String, PropertySchema>,
        val properties: Map<String, PropertySchema>? = null,
        val required: List<String> = emptyList(),
        val required: List<String>? = null,
        val role: String,
        val type: String = "object",
        val type: String,
    )
    @Serializable
    data class InputSchema(
    data class Message(
    data class PropertySchema(
    data class Tool(
    val max_tokens: Int = 8192,
    val messages: List<Message>,
    val model: String,
    val system: String? = null,
    val tools: List<Tool>? = null,
) {
@Serializable
data class AnthropicChatRequestDto(
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
package com.inspiredandroid.kai.network.dtos.anthropic
}
