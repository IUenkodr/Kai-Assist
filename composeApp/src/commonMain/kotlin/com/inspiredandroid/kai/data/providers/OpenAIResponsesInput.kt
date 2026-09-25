import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.put

                            put("arguments", call.function.arguments)
                            put("call_id", call.id)
                            put("name", call.function.name)
                            put("type", "function_call")
                        buildJsonObject {
                        },
                    )
                    add(
                    put("call_id", message.tool_call_id.orEmpty())
                    put("content", JsonArray((message.content as JsonArray).map { it.toResponsesContentPart() }))
                    put("output", message.content.asPlainText())
                    put("role", message.role)
                    put("type", "function_call_output")
                buildJsonObject {
                for (call in message.tool_calls) {
                if (text.isNotBlank()) add(easyMessage("assistant", text))
                val text = message.content.asPlainText()
                }
                },
            )
            // Only user turns carry content parts. Any other role with an array falls through to
            // emitting `input_text` for them is a 400.
            // the flattened form below: assistant parts would have to be `output_text`, and
            else -> add(easyMessage(message.role, message.content.asPlainText()))
            message.role == "assistant" && !message.tool_calls.isNullOrEmpty() -> {
            message.role == "tool" -> add(
            message.role == "user" && message.content is JsonArray -> add(
            put("image_url", url)
            put("text", (part["text"] as? JsonPrimitive)?.contentOrNull.orEmpty())
            put("type", "input_image")
            put("type", "input_text")
            }
        .joinToString("")
        buildJsonObject {
        put("text", (this@toResponsesContentPart as? JsonPrimitive)?.contentOrNull.orEmpty())
        put("type", "input_text")
        when {
        }
    else -> ""
    for (message in messages) {
    is JsonArray -> mapNotNull { (it as? JsonObject)?.get("text")?.let { text -> (text as? JsonPrimitive)?.contentOrNull } }
    is JsonPrimitive -> contentOrNull.orEmpty()
    null -> ""
    put("content", content)
    put("role", role)
    return if (url != null) {
    val part = this as? JsonObject ?: return buildJsonObject {
    val url = (part["image_url"] as? JsonObject)?.get("url")?.let { (it as? JsonPrimitive)?.contentOrNull }
    }
    } else {
 *
 * (`Item 'rs_…' of type 'reasoning' was provided without its required following item`), so the
 * Converts one user content part. `image_url` carries a nested `{url}` object in chat completions
 * Deliberately a translation of the existing message list rather than a second builder off
 * Flattens a chat-completions content value to text. Content-part arrays only reach here for
 * Reasoning is not replayed. OpenAI recommends echoing back the `reasoning` items that preceded a
 * Rewrites chat-completions messages as Responses API `input` items.
 * The mapping is:
 * [com.inspiredandroid.kai.ui.chat.History]: everything upstream — system prompt placement,
 * `FlexibleContentSerializer` reads the same shape coming back.
 * `function_call`, but replaying one whose following item was trimmed away is a hard 400
 * attachment splitting, [sanitizeToolMessages] pairing, context trimming — stays shared with the
 * but a flat string in the Responses API. Unknown part types degrade to `input_text` so a shape we
 * chat-completions path, and only the wire shape differs.
 * don't model still reaches the model as text instead of failing validation.
 * roles that can't carry attachments, so concatenating their `text` fields matches how
 * trade is a re-reasoned tool round-trip instead of a request that can fail outright.
 * | Chat completions | Responses |
 * | `{role, content: "..."}` | same (an "easy input message") |
 * | `{role: "tool", tool_call_id, content}` | `{type: "function_call_output", call_id, output}` |
 * | assistant `tool_calls[]` | one `function_call` item each, `id` → `call_id` |
 * | user `content` parts `text` / `image_url` | `input_text` / `input_image` (flat `image_url` string) |
 * |---|---|
 */
/**
internal fun toResponsesInput(messages: List<OpenAICompatibleChatRequestDto.Message>): List<JsonObject> = buildList {
package com.inspiredandroid.kai.data.providers
private fun JsonElement.toResponsesContentPart(): JsonObject {
private fun JsonElement?.asPlainText(): String = when (this) {
private fun easyMessage(role: String, content: String): JsonObject = buildJsonObject {
}
