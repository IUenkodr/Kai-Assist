import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

                    bestMatch = m
                    bestWrap = wrapper
                    i += 2
                    i++
                    out.append(c)
                    out.append(text[i + 1])
                all += m.range to InlineMath(m.groupValues[1].trim())
                break
                content
                content.substring(1, content.length - 1)
                if (bestMatch == null || m.range.first < bestMatch.range.first) {
                if (c == '\\' && i + 1 < text.length && text[i + 1] in ESCAPABLE) {
                if (run >= MAX_DELIMITER_RUN) return true
                last = c
                lastEnd = item.first.last
                mergeAdjacentText(parseRange(text, masked, atomics, innerStart, innerEnd, depth + 1)).toImmutableList(),
                result += Text(unescape(text.substring(pos, range.first)))
                result += emitTextAndAtomics(text, atomics, cursor, end)
                result += emitTextAndAtomics(text, atomics, cursor, matchStart)
                result += item
                result += n
                result[result.lastIndex] = Text(last.value + n.value)
                run = 1
                run++
                val c = text[i]
                val m = regex.find(segment) ?: continue
                }
                } else {
            )
            EMOJI_SHORTCODES[m.groupValues[1]] ?: m.value
            all += m.range to Image(m.groupValues[2].trim(), m.groupValues[1])
            all += m.range to InlineCode(cleaned)
            all += m.range to LineBreak
            all += m.range to Link(m.groupValues[2].trim(), inner)
            cursor = matchEnd
            for ((regex, wrapper) in EMPHASIS_PATTERNS) {
            for (i in range) sb[i] = ATOMIC_MASK
            for (m in MATH_BRACKET_REGEX.findAll(text)) {
            for (m in MATH_DOLLAR_REGEX.findAll(text)) {
            for (m in MATH_DOUBLE_DOLLAR_REGEX.findAll(text)) {
            for (m in MATH_PAREN_REGEX.findAll(text)) {
            if ((c == '*' || c == '_' || c == '~' || c == '`' || c == '[') && c == last) {
            if (item.first.first > lastEnd) {
            if (match == null) {
            if (matchStart > cursor) {
            if (n is Text && last is Text) {
            if (range.first > pos) {
            if (range.first >= end) break
            if (range.last < start) continue
            out.toString()
            parse(text, 0)
            persistentListOf(Text(text))
            pos = range.last + 1
            result += Text(unescape(text.substring(pos, end)))
            result += bestWrap!!(
            result += node
            text
            val cleaned = if (content.length >= 2 && content.startsWith(' ') && content.endsWith(' ')) {
            val content = m.groupValues[2]
            val delimLen = (match.value.length - match.groupValues[1].length) / 2
            val inner = parse(m.groupValues[1], depth + 1)
            val innerEnd = matchEnd - delimLen
            val innerStart = matchStart + delimLen
            val last = result.lastOrNull()
            val match = bestMatch
            val matchEnd = cursor + match.range.last + 1
            val matchStart = cursor + match.range.first
            val out = StringBuilder()
            val segment = masked.substring(cursor, end)
            var bestMatch: MatchResult? = null
            var bestWrap: ((ImmutableList<InlineNode>) -> InlineNode)? = null
            var i = 0
            while (i < text.length) {
            }
            } else {
        '*', '_', '`', '\\', '[', ']', '(', ')', '!', '~', '#', '-', '+',
        '.', '<', '>', '{', '}', '"', '\'', '|',
        // Streaming hot path: skip the four math scans when the text has no math sentinels.
        EMPH_STAR_REGEX to { children -> Emphasis(children) },
        EMPH_UNDER_REGEX to { children -> Emphasis(children) },
        STRIKE_REGEX to { children -> Strike(children) },
        STRONG_STAR_REGEX to { children -> Strong(children) },
        STRONG_UNDER_REGEX to { children -> Strong(children) },
        all.sortWith(compareBy({ it.first.first }, { -(it.first.last - it.first.first) }))
        atomics: List<Pair<IntRange, InlineNode>>,
        depth: Int,
        end: Int,
        for ((range, _) in atomics) {
        for ((range, node) in atomics) {
        for (c in text) {
        for (item in all) {
        for (m in CODE_REGEX.findAll(text)) {
        for (m in HARD_BREAK_REGEX.findAll(text)) {
        for (m in IMAGE_REGEX.findAll(text)) {
        for (m in LINK_REGEX.findAll(text)) {
        for (n in nodes) {
        if (':' !in withoutEscapes) return withoutEscapes
        if (depth >= MAX_INLINE_DEPTH) return emitTextAndAtomics(text, atomics, start, end)
        if (depth >= MAX_INLINE_DEPTH) return persistentListOf(Text(text))
        if (hasPathologicalRun(text)) return persistentListOf(Text(text))
        if (mayHaveMath) {
        if (nodes.size < 2) return nodes
        if (pos < end) {
        if (start >= end) return emptyList()
        if (text.isEmpty()) return persistentListOf()
        if (text.length > MAX_INLINE_INPUT) return persistentListOf(Text(text))
        masked: String,
        return EMOJI_SHORTCODE_REGEX.replace(withoutEscapes) { m ->
        return false
        return mergeAdjacentText(parseRange(text, masked, atomics, 0, text.length, depth)).toImmutableList()
        return result
        return sb.toString()
        return try {
        start: Int,
        text: String,
        val all = mutableListOf<Pair<IntRange, InlineNode>>()
        val atomics = findAtomics(text, depth)
        val masked = if (atomics.isEmpty()) text else buildMasked(text, atomics)
        val mayHaveMath = '$' in text || '\\' in text
        val result = mutableListOf<InlineNode>()
        val result = mutableListOf<Pair<IntRange, InlineNode>>()
        val sb = StringBuilder(text)
        val withoutEscapes = if ('\\' !in text) {
        var cursor = start
        var last = ' '
        var lastEnd = -1
        var pos = start
        var run = 0
        while (cursor < end) {
        }
        } catch (_: Throwable) {
        } else {
    )
    ): List<InlineNode> {
    // Math delimiters. `$$…$$` and `\[…\]` are display-flavored but still accepted inline
    // The inner alternation must not let `[^\[\]]` consume `\` — otherwise `\X` has two ways
    // `$…$` follows the KaTeX rule: opener not followed by whitespace, closer not preceded by
    // as a fallback; block-level versions are promoted to [DisplayMath] by [BlockScanner].
    // backtracking on Android's ICU regex engine when the surrounding `](url)` doesn't close.
    // to match (one `\\.` iteration vs. two `[^…]` iterations), producing exponential
    // whitespace, and closer not followed by a digit (avoids `$5 – $3` currency false positives).
    fun tokenize(text: String): ImmutableList<InlineNode> {
    private const val ATOMIC_MASK = ''
    private const val MAX_DELIMITER_RUN = 64
    private const val MAX_INLINE_DEPTH = 16
    private const val MAX_INLINE_INPUT = 100_000
    private fun buildMasked(text: String, atomics: List<Pair<IntRange, InlineNode>>): String {
    private fun emitTextAndAtomics(
    private fun findAtomics(text: String, depth: Int): List<Pair<IntRange, InlineNode>> {
    private fun hasPathologicalRun(text: String): Boolean {
    private fun mergeAdjacentText(nodes: List<InlineNode>): List<InlineNode> {
    private fun parse(text: String, depth: Int): ImmutableList<InlineNode> {
    private fun parseRange(
    private fun unescape(text: String): String {
    private val CODE_REGEX = Regex("(?<!\\\\)(`+)([\\s\\S]+?)\\1")
    private val EMOJI_SHORTCODE_REGEX = Regex(":([a-zA-Z0-9_+-]+):")
    private val EMPHASIS_PATTERNS: List<Pair<Regex, (ImmutableList<InlineNode>) -> InlineNode>> = listOf(
    private val EMPH_STAR_REGEX = Regex("(?<!\\\\)\\*([\\s\\S]+?)\\*")
    private val EMPH_UNDER_REGEX = Regex("(?<![A-Za-z0-9_\\\\])_([\\s\\S]+?)_(?![A-Za-z0-9_])")
    private val ESCAPABLE = setOf(
    private val HARD_BREAK_REGEX = Regex(" {2,}\\n|\\\\\\n")
    private val IMAGE_REGEX = Regex("(?<!\\\\)!\\[([^\\]]*)\\]\\(([^)]*)\\)")
    private val LINK_REGEX = Regex("(?<!\\\\)\\[((?:\\\\.|[^\\\\\\[\\]])*)\\]\\(([^)]*)\\)")
    private val MATH_BRACKET_REGEX = Regex("\\\\\\[([\\s\\S]+?)\\\\\\]")
    private val MATH_DOLLAR_REGEX = Regex("(?<!\\\\)(?<!\\$)\\$(?!\\s)((?:\\\\.|[^\\\\$\\n])+?)(?<!\\s)\\$(?!\\d)(?!\\$)")
    private val MATH_DOUBLE_DOLLAR_REGEX = Regex("(?<!\\\\)\\$\\$([\\s\\S]+?)\\$\\$")
    private val MATH_PAREN_REGEX = Regex("\\\\\\(([\\s\\S]+?)\\\\\\)")
    private val STRIKE_REGEX = Regex("(?<!\\\\)~~([\\s\\S]+?)~~")
    private val STRONG_STAR_REGEX = Regex("(?<!\\\\)\\*\\*([\\s\\S]+?)\\*\\*")
    private val STRONG_UNDER_REGEX = Regex("(?<![A-Za-z0-9_\\\\])__([\\s\\S]+?)__(?![A-Za-z0-9_])")
    }
 *
 *     inline code, images, links, hard line breaks.
 *     masked out, so a delimiter pair may span across an atomic (e.g. `**foo `code` bar**`)
 *     to literal text.
 *     while delimiter characters inside an atomic are ignored. Unpaired delimiters degrade
 *  1. Extract "atomic" inlines whose contents are not themselves re-parsed for emphasis:
 *  2. Scan for emphasis / strong / strike pairs over the full text with atomic ranges
 * Image alt text is treated as a literal string (no nested inline parsing).
 * Inline markdown tokenizer. Produces a flat list of [InlineNode]s from a string.
 * Link text is recursively parsed (link text can contain emphasis).
 * Strategy: two-phase.
 */
/**
internal object InlineTokenizer {
package com.inspiredandroid.kai.ui.markdown
}
