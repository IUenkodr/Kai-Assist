
        // Echoed back on assistant turns that produced tool_calls for providers
        // Moonshot/Kimi thinking, Venice, Z.AI/GLM thinking, OpenCode Zen,
        // OpenRouter). Groq/Cerebras strict-reject it, so emission is gated by
        // Service.reasoningRequestMode.
        // that require it (DeepSeek thinking, Fireworks, LongCat, MiniMax,
        @SerialName("reasoning_content")
        val additionalProperties: Boolean? = null,
        val arguments: String, // JSON string of the args → parse it in your code
        val content: JsonElement? = null, // String or array of content parts (for vision)
        val description: String? = null,
        val enum: List<String>? = null, // Optional enum values
        val function: Function,
        val function: FunctionCall,
        val id: String,
        val items: PropertySchema? = null, // For type: "array"
        val name: String,
        val parameters: Parameters? = null,
        val properties: Map<String, PropertySchema>,
        val properties: Map<String, PropertySchema>? = null, // For type: "object"
        val reasoningContent: String? = null,
        val required: List<String>? = null,
        val role: String, // "system", "user", "assistant", "tool"
        val strict: Boolean? = null, // Optional (for Structured Outputs / strict mode)
        val tool_call_id: String? = null, // Required for "tool" role messages
        val tool_calls: List<ToolCall>? = null,
        val type: String = "function",
        val type: String = "function", // Currently only "function" is widely supported
        val type: String = "object",
        val type: String, // "string", "number", "boolean", "integer", "array", "object"
    )
    @Serializable
    data class Function(
    data class FunctionCall(
    data class Message(
    data class Parameters(
    data class PropertySchema(
    data class Tool(
    data class ToolCall(
    val messages: List<Message>,
    val model: String? = null,
    val tools: List<Tool>? = null,
) {
@Serializable
data class OpenAICompatibleChatRequestDto(
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
package com.inspiredandroid.kai.network.dtos.openaicompatible
}
