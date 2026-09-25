
                            result.insert(commaIdx, '}')
                            stack.removeAt(stack.lastIndex)
                        if (commaIdx >= 0) {
                        stack.getOrNull(stack.size - 2) == '['
                        stack.lastOrNull() == '{' &&
                        val commaIdx = result.lastIndexOf(',')
                        }
                    ) {
                    // LLM forgot to close the object before the next array element.
                    // Only repair when the parent of the open object is an array.
                    // Repair `,{` or `,[` appearing where an object expects a key: the
                    if (lastSig == ',' &&
                    lastSig = c
                    result.append(c)
                    stack.add(c)
                    stack.removeAt(stack.lastIndex)
                    }
                ']' -> if (stack.isNotEmpty() && stack.last() == '[') {
                '{', '[' -> {
                '}' -> if (stack.isNotEmpty() && stack.last() == '{') {
                UiBlockResult.Error(repaired)
                UiBlockResult.Ui(ColumnNode(children = children.toImmutableList()), repaired)
                append(if (stack[i] == '{') '}' else ']')
                break
                continue
                else -> {
                escaped = false
                escaped = true
                inString = !inString
                lastSig = c
                result.append(c)
                s = before
                s = s.dropLast(1).trimEnd()
                }
            // Possible orphaned key — find its opening quote.
            UiBlockResult.Error(json)
            append(trimmed)
            for (i in stack.indices.reversed()) {
            if (before.isEmpty() || before.last() in setOf(',', '{', '[')) {
            if (c == '"') {
            if (c == '\\' && inString) {
            if (c.isWhitespace()) {
            if (escaped) {
            if (inString) {
            if (last != '"') break
            if (last == ',' || last == ':') {
            if (lastQuote >= 0) s = s.substring(0, lastQuote)
            if (openQuote < 0) break
            if (stack.isEmpty()) return result.toString()
            null
            parseSingleNode(json)?.let { UiBlockResult.Ui(it, json) }
            println("kai-ui parse error: ${e.message} | ${json.take(500)}")
            println("kai-ui parse error: failed to deserialize line | ${line.take(500)}")
            return if (children.isNotEmpty()) {
            val before = s.substring(0, openQuote).trimEnd()
            val children = lines.mapNotNull { tryParseLine(it) }
            val last = s.last()
            val lastQuote = s.lastIndexOf('"')
            val openQuote = s.lastIndexOf('"', s.lastIndex - 1)
            when (c) {
            }
            } else {
        // If we were inside a string when input ended, backtrack to before that string opened.
        // Last structural char emitted outside of strings. Used to detect `,{` / `,[`
        // Strip trailing whitespace, commas, colons, and orphaned key strings.
        // Unclosed JSON — trim trailing incomplete content and then close open structures.
        // element (LLMs sometimes forget to close each object in an array of objects).
        // inside an object, which signals a missing closing `}` before the next array
        ?: run {
        ?: runCatching { parseSingleNode(sanitizeJson(line)) }.getOrNull()
        data class Error(val rawJson: String) : UiBlockResult
        data class Ui(val node: KaiUiNode, val rawJson: String) : UiBlockResult
        for (c in raw) {
        if (inString) {
        if (lines.size > 1 && lines.all { it.startsWith("{") }) {
        if (raw.isEmpty()) return raw
        if (raw[0] != '{' && raw[0] != '[') return raw
        return buildString {
        return s
        return try {
        s = s.trimEnd()
        val json = sanitizeJson(repaired)
        val lines = repaired.lines().map { it.trim() }.filter { it.isNotEmpty() }
        val repaired = fixJsonSyntax(rawBlock)
        val result = StringBuilder()
        val stack = mutableListOf<Char>()
        val trimmed = trimTrailingIncomplete(result.toString(), inString)
        var escaped = false
        var inString = false
        var lastSig: Char = ' '
        var s = json
        while (s.isNotEmpty()) {
        }
        } catch (e: Exception) {
     *
     *    the historical behavior, but returned here as-is for per-node composition).
     *  - A single JSON object (e.g. `{"type":"column", ...}`)
     *  - NDJSON: one object per line (wrapped in an implicit `ColumnNode` by callers that want
     * Decode the raw body of a kai-ui fence (everything between the opening and closing triple
     * JSON. Handles incomplete strings, trailing commas, trailing colons, and orphaned keys.
     * Mismatched closers are skipped; unclosed structures are trimmed and then closed.
     * Repair JSON with extra closing braces/brackets using stack-based matching.
     * Supports two shapes:
     * Trim trailing incomplete content from truncated JSON so appending closers produces valid
     * backticks). Returns either a decoded [KaiUiNode] or an [UiBlockResult.Error] carrying the
     * repaired JSON so callers can display it as a code block.
     */
    /**
    /** Fix common LLM JSON syntax errors like `"key=[` instead of `"key":[`. */
    /** Parse a repaired JSON string into a [KaiUiNode] via the direct builder pipeline. */
    /** Result of decoding a kai-ui fence body; consumed by the markdown parser. */
    /** Try to parse a single NDJSON line, retrying with `sanitizeJson` on the first failure. */
    // =========================================================================================
    // Internals
    // Public API
    // Stage 2: syntax repair
    fun parseUiBlockBody(rawBlock: String): UiBlockResult? {
    private fun fixJsonSyntax(raw: String): String = brokenKeySyntax.replace(raw) { "\"${it.groupValues[1]}\":${it.groupValues[2]}" }
    private fun parseSingleNode(json: String): KaiUiNode? = parseNode(SharedJson.parseToJsonElement(json))
    private fun sanitizeJson(raw: String): String {
    private fun trimTrailingIncomplete(json: String, inString: Boolean): String {
    private fun tryParseLine(line: String): KaiUiNode? = runCatching { parseSingleNode(line) }.getOrNull()
    private val brokenKeySyntax = Regex(""""(\w+)=([{\[])""")
    sealed interface UiBlockResult {
    }
 *
 *      Each reader tolerates common LLM mistakes locally, so missing or miscoerced fields fall
 *      [parseNode] in `KaiUiNodeBuilders.kt`, constructing [KaiUiNode] instances field-by-field.
 *      back to their data-class defaults and the node still builds.
 *      body to [parseUiBlockBody].
 *      so `parseToJsonElement` can succeed.
 *   1. **Block extraction** — the markdown parser locates `kai-ui` fences and hands the raw
 *   2. **Syntax repair** — fix broken key syntax, trim mismatched braces, close truncated JSON
 *   3. **Direct build** — walk the resulting [kotlinx.serialization.json.JsonElement] tree via
 * Decodes the body of a `kai-ui` fenced JSON block into a [KaiUiNode].
 * Only the `parseToJsonElement` call in stage 3 can produce a [UiBlockResult.Error];
 * The parse pipeline runs each block through three stages:
 * everything downstream of that returns a best-effort node or a null that callers filter out.
 */
/**
import com.inspiredandroid.kai.data.SharedJson
import kotlinx.collections.immutable.toImmutableList
object KaiUiParser {
package com.inspiredandroid.kai.ui.dynamicui
}
