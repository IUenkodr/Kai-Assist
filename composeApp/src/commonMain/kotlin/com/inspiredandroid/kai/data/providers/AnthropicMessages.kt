package com.inspiredandroid.kai.data.providers
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicChatRequestDto
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.chat.toAnthropicContentBlocks
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

                            content = JsonArray(pendingToolResults),
                            role = "user",
                        ),
                        AnthropicChatRequestDto.Message(
                        content = msg.toAnthropicContentBlocks(),
                        role = if (msg.role == History.Role.ASSISTANT) "assistant" else "user",
                    )
                    ),
                    AnthropicChatRequestDto.Message(
                    add(
                    pendingToolResults = mutableListOf()
                    pendingToolResults.addAll(blocks)
                )
                add(
                content = JsonArray(pendingToolResults),
                if (blocks is JsonArray) {
                if (pendingToolResults.isNotEmpty()) {
                role = "user",
                val blocks = msg.toAnthropicContentBlocks()
                }
            ),
            AnthropicChatRequestDto.Message(
            History.Role.TOOL -> {
            History.Role.TOOL_EXECUTING -> { /* skip */ }
            else -> {
            }
        )
        add(
        when (msg.role) {
        }
    for (msg in messages) {
    if (pendingToolResults.isNotEmpty()) {
    messages: List<History>,
    var pendingToolResults = mutableListOf<JsonElement>()
    }
): List<AnthropicChatRequestDto.Message> = buildList {
internal fun buildAnthropicMessages(
}
