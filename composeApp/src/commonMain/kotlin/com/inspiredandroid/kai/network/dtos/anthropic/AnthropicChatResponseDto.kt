import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

        val id: String? = null,
        val input: JsonObject? = null,
        val name: String? = null,
        val text: String? = null,
        val type: String,
    )
    @Serializable
    data class ContentBlock(
    val content: List<ContentBlock> = emptyList(),
    val stop_reason: String? = null,
) {
@Serializable
data class AnthropicChatResponseDto(
fun AnthropicChatResponseDto.extractText(): String = content.filter { it.type == "text" }.mapNotNull { it.text }.joinToString("\n")
package com.inspiredandroid.kai.network.dtos.anthropic
}
