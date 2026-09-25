
        val args: Map<String, JsonElement>? = null,
        val data: String,
        val functionCall: FunctionCall? = null,
        val functionResponse: FunctionResponse? = null,
        val inline_data: InlineData? = null,
        val mime_type: String,
        val name: String,
        val parts: List<Part>,
        val response: Map<String, JsonElement>,
        val role: String? = null,
        val text: String? = null,
        val thoughtSignature: String? = null,
    )
    @Serializable
    data class Content(
    data class FunctionCall(
    data class FunctionResponse(
    data class InlineData(
    data class Part(
    val contents: List<Content>,
    val description: String,
    val description: String? = null,
    val enum: List<String>? = null,
    val functionDeclarations: List<FunctionDeclaration>,
    val items: PropertySchema? = null,
    val name: String,
    val parameters: FunctionParameters,
    val properties: Map<String, PropertySchema>,
    val properties: Map<String, PropertySchema>? = null,
    val required: List<String> = emptyList(),
    val required: List<String>? = null,
    val systemInstruction: Content? = null,
    val tools: List<GeminiTool>? = null,
    val type: String = "object",
    val type: String,
)
) {
@Serializable
data class FunctionDeclaration(
data class FunctionParameters(
data class GeminiChatRequestDto(
data class GeminiTool(
data class PropertySchema(
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
package com.inspiredandroid.kai.network.dtos.gemini
}
