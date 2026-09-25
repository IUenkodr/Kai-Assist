import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

            .flatMap { it.content.orEmpty() }
            .flatMap { it.summary.orEmpty() }
            .joinToString("")
            .joinToString("\n\n")
            .mapNotNull { it.text?.takeIf { text -> text.isNotBlank() } }
            .mapNotNull { it.text?.takeIf { text -> text.isNotEmpty() } }
            .takeIf { it.isNotBlank() }
        /** `function_call` items: the id the matching `function_call_output` must reference. */
        /** `message` items: the assistant's answer, as `output_text` parts. */
        /** `reasoning` items: the chain-of-thought summary, as `summary_text` parts. */
        @SerialName("call_id")
        get() = output.filter { it.type == "function_call" && it.name != null }
        get() = output.filter { it.type == "message" }
        get() = output.filter { it.type == "reasoning" }
        val arguments: String? = null,
        val callId: String? = null,
        val code: String? = null,
        val content: List<ContentPart>? = null,
        val message: String? = null,
        val name: String? = null,
        val role: String? = null,
        val summary: List<ContentPart>? = null,
        val text: String? = null,
        val type: String? = null,
     * Reasoning summary, when the model returned one. OpenAI only emits summaries for verified
     * never exposed by this API.
     * organizations that request them, so this is usually null — the raw chain-of-thought is
     */
    )
    /**
    /** Assistant answer text, concatenated across every `message` item in the turn. */
    /** Tool calls requested by this turn, in the order the model emitted them. */
    @Serializable
    data class ContentPart(
    data class OutputItem(
    data class ResponseError(
    val error: ResponseError? = null,
    val functionCalls: List<OutputItem>
    val output: List<OutputItem> = emptyList(),
    val outputText: String?
    val reasoningSummary: String?
    val status: String? = null,
 *
 * One flat [OutputItem] covers all of them (fields a given type doesn't use stay null) because the
 * Response body of OpenAI's Responses API (`POST /v1/responses`).
 * Unlike chat completions there is no single `message` object: [output] is an ordered list of
 * typed items — `reasoning`, `message`, `function_call` — and a turn can contain several of each.
 * union is small and kotlinx polymorphism would need a registered hierarchy for no benefit.
 */
) {
/**
@Serializable
data class OpenAIResponsesResponseDto(
package com.inspiredandroid.kai.network.dtos.openairesponses
}
