import com.inspiredandroid.kai.network.tools.Tool
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

            // Couldn't make sense of this block — keep it visible rather than silently dropping it.
            break
            calls.add(parsed)
            cleaned.append(content, openIdx, blockEnd)
            cleaned.append(content, pos, content.length)
            put(key, coerceParameterValue(raw, type))
            val key = match.groupValues[1]
            val raw = match.groupValues[2].trim()
            val type = schema?.parameters?.get(key)?.type
        ?: return null
        argsElement == null -> "{}"
        argsElement is JsonObject -> argsElement.toString()
        cleaned.append(content, pos, openIdx)
        else -> argsElement.toString()
        else -> null
        for (match in parameterTagRegex.findAll(body)) {
        if (openIdx < 0) {
        if (parsed != null) {
        inner.contains("<function=") -> parseXmlFlavor(inner, tools)
        inner.startsWith("{") -> parseJsonFlavor(inner)
        pos = blockEnd
        val blockEnd = if (closeIdx >= 0) closeIdx + CLOSE_TAG.length else content.length
        val closeIdx = content.indexOf(CLOSE_TAG, openIdx + OPEN_TAG.length)
        val inner = content.substring(openIdx + OPEN_TAG.length, innerEnd).trim()
        val innerEnd = if (closeIdx >= 0) closeIdx else content.length
        val openIdx = content.indexOf(OPEN_TAG, pos)
        val parsed = parseToolCallBlock(inner, tools)
        }
        } else {
    "array", "object" -> parseJsonOrNull(raw) ?: JsonPrimitive(raw)
    "boolean" -> raw.toBooleanStrictOrNull()?.let { JsonPrimitive(it) } ?: JsonPrimitive(raw)
    "integer" -> raw.toLongOrNull()?.let { JsonPrimitive(it) } ?: JsonPrimitive(raw)
    "number" -> raw.toDoubleOrNull()?.let { JsonPrimitive(it) } ?: JsonPrimitive(raw)
    // No schema hint — keep as string. Numeric-looking values stay strings to match
    // the model's literal output unless the schema explicitly asked for a number.
    ParsedInlineToolCall(name = name, arguments = argsJson)
    content: String,
    declaredType: String?,
    else -> JsonPrimitive(raw)
    if (!content.contains(OPEN_TAG)) return InlineToolCallExtraction(content, emptyList())
    if (inner.isEmpty()) return null
    ignoreUnknownKeys = true
    isLenient = true
    lenientJson.parseToJsonElement(raw)
    null
    raw: String,
    return InlineToolCallExtraction(cleaned.toString().trim(), calls)
    return ParsedInlineToolCall(name = name, arguments = json.toString())
    return when {
    tools: List<Tool>,
    val argsElement = obj["arguments"] ?: obj["parameters"]
    val argsJson = when {
    val arguments: String,
    val body = funcMatch.groupValues[2]
    val calls = mutableListOf<ParsedInlineToolCall>()
    val calls: List<ParsedInlineToolCall>,
    val cleaned = StringBuilder()
    val cleanedText: String,
    val funcMatch = functionTagRegex.find(inner) ?: return null
    val json = buildJsonObject {
    val name = funcMatch.groupValues[1]
    val name = obj["name"]?.jsonPrimitive?.contentOrNull?.takeIf { it.isNotBlank() }
    val name: String,
    val obj = lenientJson.parseToJsonElement(inner).jsonObject
    val schema = tools.firstOrNull { it.schema.name == name }?.schema
    var pos = 0
    while (pos < content.length) {
    }
 *
 *  - Hermes / OpenHands XML: `<function=NAME><parameter=KEY>VALUE</parameter>…</function>`
 *  - JSON: `{ "name": "...", "arguments": { … } }`
 * Parameter values are coerced to JSON primitive types using the tool's schema so
 * Some OpenAI-compatible models (Qwen, Hermes-style fine-tunes, and a number of
 * Two block flavors are accepted:
 * `timeout=180` becomes a number rather than the string "180".
 * field. Detect those blocks, convert each one into a synthetic tool call, and
 * inside the assistant content instead of populating the structured `tool_calls`
 * return the surrounding natural-language text with the blocks removed.
 * self-hosted endpoints) occasionally emit tool calls as inline `<tool_call>` XML
 */
)
): InlineToolCallExtraction {
): kotlinx.serialization.json.JsonElement = when (declaredType) {
/**
internal data class InlineToolCallExtraction(
internal data class ParsedInlineToolCall(
internal fun extractInlineToolCalls(
package com.inspiredandroid.kai.network.dtos.openaicompatible
private const val CLOSE_TAG = "</tool_call>"
private const val OPEN_TAG = "<tool_call>"
private fun coerceParameterValue(
private fun parseJsonFlavor(inner: String): ParsedInlineToolCall? = try {
private fun parseJsonOrNull(raw: String): kotlinx.serialization.json.JsonElement? = try {
private fun parseToolCallBlock(inner: String, tools: List<Tool>): ParsedInlineToolCall? {
private fun parseXmlFlavor(inner: String, tools: List<Tool>): ParsedInlineToolCall? {
private val functionTagRegex = Regex("<function=([\\w.\\-]+)>([\\s\\S]*?)</function>")
private val lenientJson = Json {
private val parameterTagRegex = Regex("<parameter=([\\w.\\-]+)>([\\s\\S]*?)</parameter>")
}
} catch (_: Throwable) {
