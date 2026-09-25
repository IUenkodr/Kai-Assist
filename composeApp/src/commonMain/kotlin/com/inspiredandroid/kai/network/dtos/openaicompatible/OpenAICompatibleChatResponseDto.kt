
                        return stripped.takeIf { it.isNotBlank() }
                        val stripped = raw.replace(toolCallMarkerRegex, "").trim()
                    // Some providers (e.g. Ollama) embed tool calls as <TOOLCALL>[...] markers
                    // in the content field alongside structured tool_calls — strip them.
                    if (raw != null && !toolCalls.isNullOrEmpty()) {
                    return raw
                    val raw = content?.takeIf { it.isNotBlank() } ?: effectiveReasoning
                    }
                (part as? JsonObject)?.get("text")?.jsonPrimitive?.contentOrNull
                get() = content.isNullOrBlank() && !effectiveReasoning.isNullOrBlank()
                get() = reasoningContent ?: reasoning
                get() {
                if (!trimmedReasoning.endsWith(trimmedAnswer)) return reasoning
                if (answer.isNullOrBlank() || isContentFromReasoning) return reasoning
                return trimmedReasoning.removeSuffix(trimmedAnswer).trimEnd().takeIf { it.isNotBlank() }
                val reasoning = effectiveReasoning ?: return null
                val trimmedAnswer = answer.trim()
                val trimmedReasoning = reasoning.trimEnd()
                }
             * "Thinking" section duplicates the answer rendered below it.
             * LongCat (flash thinking) and a few others stream the final answer as the tail of
             * Reasoning trace with the answer text trimmed off if the provider appended it.
             * `reasoning_content`, then return the same text in `content` — without this, the
             */
            /**
            /** Returns [content] if non-blank, otherwise falls back to reasoning. */
            /** True when the effective content comes from reasoning rather than [content]. */
            /** Whichever reasoning field the provider used, normalized to one accessor. */
            // DeepSeek returns `reasoning_content`; OpenRouter returns `reasoning`.
            @SerialName("reasoning_content")
            @SerialName("tool_calls")
            @Serializable(with = FlexibleContentSerializer::class)
            else -> ""
            fun reasoningTraceFor(answer: String?): String? {
            is JsonArray -> element.mapNotNull { part ->
            is JsonPrimitive -> element.content
            val content: String? = null,
            val effectiveContent: String?
            val effectiveReasoning: String?
            val isContentFromReasoning: Boolean
            val reasoning: String? = null,
            val reasoningContent: String? = null,
            val role: String? = null,
            val toolCalls: List<ToolCall>? = null,
            }
            }.joinToString("")
        ) {
        @Serializable
        PrimitiveSerialDescriptor("FlexibleContent", PrimitiveKind.STRING)
        data class Message(
        encoder.encodeString(value)
        return when (val element = jsonDecoder.decodeJsonElement()) {
        val arguments: String,
        val function: FunctionCall,
        val id: String,
        val jsonDecoder = decoder as? JsonDecoder ?: return decoder.decodeString()
        val name: String,
        val type: String = "function",
        }
    )
    @Serializable
    data class Choice(val message: Message? = null) {
    data class FunctionCall(
    data class ToolCall(
    override fun deserialize(decoder: Decoder): String {
    override fun serialize(encoder: Encoder, value: String) {
    override val descriptor: SerialDescriptor =
    val choices: List<Choice>,
    }
 * Reads `message.content` whether the provider sends a plain string or an OpenAI-style array of
 * concatenating the `text` fields, so downstream code keeps seeing a simple [String]. Applied only
 * content blocks (e.g. `[{"type":"text","text":"..."}]`). Array forms are flattened by
 * to nullable fields, so kotlinx handles a literal JSON `null` before this runs.
 */
) {
/**
@Serializable
data class OpenAICompatibleChatResponseDto(
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive
internal object FlexibleContentSerializer : KSerializer<String> {
package com.inspiredandroid.kai.network.dtos.openaicompatible
private val toolCallMarkerRegex = Regex("<TOOLCALL>[\\s\\S]*?</TOOLCALL>|<TOOLCALL>[\\s\\S]*$")
}
