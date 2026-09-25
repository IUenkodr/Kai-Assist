package com.inspiredandroid.kai.network.dtos.openairesponses
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

        val description: String? = null,
        val name: String,
        val parameters: OpenAICompatibleChatRequestDto.Parameters? = null,
        val strict: Boolean = false,
        val type: String = "function",
     *
     * API tags function tools inline. The parameter schema is byte-identical, so the shared
     * Kept `false` so OpenAI does not retain the conversation server-side. Kai replays the whole
     * Same JSON Schema as the chat-completions tool, minus the `function` wrapper — the Responses
     * [strict] is explicitly `false`: omitting it makes the API attempt strict mode, which
     * `OpenAISchemaDialect` conversion is reused rather than duplicated.
     * history on every request, so it never needs `previous_response_id` chaining.
     * parameters, so strict mode would reject them.
     * requires every property to be listed in `required`. Kai's tool schemas have optional
     */
    )
    /**
    @Serializable
    data class Tool(
    val input: List<JsonObject>,
    val model: String? = null,
    val store: Boolean = false,
    val tools: List<Tool>? = null,
 *
 * 'none'.` Those models reason by default, so the rejection happens even though Kai never sends
 * /v1/chat/completions. To use function tools, use /v1/responses or set reasoning_effort to
 * Needed because OpenAI rejects function tools combined with reasoning on
 * Request body for OpenAI's Responses API (`POST /v1/responses`).
 * [input] holds heterogeneous items (messages, `function_call`, `function_call_output`) whose
 * `/v1/chat/completions` for the GPT-5.6 family:
 * `400 Function tools with reasoning_effort are not supported for gpt-5.6-terra in
 * `data/providers/OpenAIResponsesInput.kt`.
 * `reasoning_effort`.
 * required fields differ per type, so they are built as raw JSON objects — see
 */
) {
/**
@Serializable
data class OpenAIResponsesRequestDto(
}
