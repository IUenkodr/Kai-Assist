import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.modelSupportsImages
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.chat.toGroqMessageDto
import kotlinx.serialization.json.JsonPrimitive

                    // Nothing answered the calls: strip them, keeping the turn only if it still
                    // carries text. An assistant message with neither content nor tool_calls is
                    // itself rejected by some providers.
                    following.add(messages[j])
                    if (msg.content != null) result.add(msg.copy(tool_calls = null))
                    j++
                    msg.tool_calls
                    msg.tool_calls.filter { it.function.name in declaredToolNames }
                    result.add(msg.copy(tool_calls = keptCalls))
                    result.addAll(matched)
                // Collect the contiguous run of tool responses that belong to this turn.
                // Drop tool_calls referencing tools not declared on this request. A null
                // [declaredToolNames] disables this filter so callers that don't care about
                // declared-tool cross-checking (legacy tests) keep prior behavior.
                content = JsonPrimitive(systemPrompt),
                i = j
                i++
                if (keptCalls.isEmpty()) {
                result.add(msg)
                role = "system",
                val callsInDeclaredSet = if (declaredToolNames == null) {
                val following = ArrayList<OpenAICompatibleChatRequestDto.Message>()
                val keptCallIds = callsInDeclaredSet.map { it.id }.toSet()
                val keptCalls = callsInDeclaredSet.filter { it.id in respondedIds }
                val matched = following.filter { it.tool_call_id != null && it.tool_call_id in keptCallIds }
                val respondedIds = matched.mapNotNull { it.tool_call_id }.toSet()
                var j = i + 1
                while (j < messages.size && messages[j].role == "tool") {
                }
                } else {
            ),
            // A tool message reaching this point was not consumed by an assistant block above,
            // Drop empty assistant turns that strict providers reject.
            // so it has no preceding tool_calls to answer — drop the orphan.
            OpenAICompatibleChatRequestDto.Message(
            declaredToolNames,
            else -> {
            messages.map { it.toGroqMessageDto(service.reasoningRequestMode, supportsImages) },
            msg.role == "assistant" && !msg.tool_calls.isNullOrEmpty() -> {
            msg.role == "assistant" && msg.content == null && msg.tool_calls.isNullOrEmpty() -> i++
            msg.role == "tool" -> i++
            }
        )
        ),
        add(
        sanitizeToolMessages(
        val msg = messages[i]
        when {
        }
    )
    // Images go through only when both the service and the specific model accept them.
    // Mixed services (e.g. Z.AI) host text-only and vision models side by side.
    addAll(
    declaredToolNames: Set<String>? = null,
    if (!systemPrompt.isNullOrEmpty()) {
    messages: List<History>,
    messages: List<OpenAICompatibleChatRequestDto.Message>,
    modelId: String,
    return result
    service: Service,
    systemPrompt: String?,
    val result = ArrayList<OpenAICompatibleChatRequestDto.Message>(messages.size)
    val supportsImages = service.supportsImages && modelSupportsImages(modelId)
    var i = 0
    while (i < messages.size) {
    }
 *
 *    `tools[]` array — Groq rejects calls to tools that aren't declared on the request.
 *    message answering each `tool_call_id`.
 * "An assistant message with 'tool_calls' must be followed by tool messages responding to each
 * 'tool_call_id'."
 * 1. An `assistant` message carrying `tool_calls` must be immediately followed by one `tool`
 * 2. A `tool` message must answer a `tool_call_id` from the assistant turn directly before it.
 * 3. Every `tool_calls` entry must reference a tool that is also in the current request's
 * A history can violate this after context trimming drops part of a turn, after a tool run is
 * Enforces the tool-call pairing invariant that strict OpenAI-compatible providers (DeepSeek via
 * OpenCode Zen, etc.) require:
 * Pass [declaredToolNames] = `null` to keep historic call-name fidelity (still enforces pairing).
 * Pass a (possibly empty) set to strip undeclared calls too — an empty set means "this request
 * Sending such a sequence triggers a 400:
 * This pass walks the messages, drops `tool_calls` whose function name is not in
 * [declaredToolNames], pairs each remaining assistant `tool_calls` turn with the tool responses
 * declares no tools, so every historical tool_call is orphan."
 * interrupted (assistant requested calls that were never executed), when a provider returns a
 * malformed/empty id, or when the user toggles a tool off between turns that referenced it.
 * message), and removes assistant turns left with neither content nor tool calls.
 * that follow it, drops any `tool_call` that has no matching response (and any orphan `tool`
 */
): List<OpenAICompatibleChatRequestDto.Message> = buildList {
): List<OpenAICompatibleChatRequestDto.Message> {
/**
internal fun buildOpenAIMessages(
internal fun sanitizeToolMessages(
package com.inspiredandroid.kai.data.providers
}
