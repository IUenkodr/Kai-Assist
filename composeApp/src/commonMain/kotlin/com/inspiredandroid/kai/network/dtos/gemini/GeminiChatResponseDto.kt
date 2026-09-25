import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

        val args: Map<String, JsonElement>? = null,
        val functionCall: FunctionCall? = null,
        val isThought: Boolean get() = thought == true
        val name: String,
        val text: String? = null,
        val thought: Boolean? = null,
        val thoughtSignature: String? = null,
    )
    ) {
    ?.filterNot { it.isThought }
    ?.joinToString("\n") { it.text ?: "" }
    ?: ""
    @Serializable
    data class Candidate(val content: Content? = null)
    data class Content(val parts: List<Part>? = null)
    data class FunctionCall(
    data class Part(
    val candidates: List<Candidate>,
    }
) {
@Serializable
data class GeminiChatResponseDto(
fun GeminiChatResponseDto.extractText(): String = candidates.firstOrNull()?.content?.parts
package com.inspiredandroid.kai.network.dtos.gemini
}
