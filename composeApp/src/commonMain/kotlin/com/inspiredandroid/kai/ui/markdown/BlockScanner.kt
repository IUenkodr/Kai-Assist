package com.inspiredandroid.kai.ui.markdown
import com.inspiredandroid.kai.ui.dynamicui.KaiUiParser
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

                    blocks += Heading(1, InlineTokenizer.tokenize(line.trim()))
                    blocks += Heading(2, InlineTokenizer.tokenize(line.trim()))
                    blocks += splitResult.first
                    blocks += tableResult.first
                    continue
                    i += 2
                    i = splitResult.second
                    i = tableResult.second
                    if (indentOf(lk) < contentCol) break
                    if (isSiblingOrOuterMarker(lk, listIndent)) break
                    if (k >= end) break
                    itemLines += ""
                    itemLines += l.substring(contentCol.coerceAtMost(l.length))
                    itemLines += l.trimStart()
                    j++
                    return FenceBody(bodyLines.joinToString("\n"), closed = true, nextIndex = i + 1)
                    val lk = lines[k]
                    var k = j + 1
                    while (k < end && lines[k].isBlank()) k++
                ?: MATH_DISPLAY_BRACKET_INLINE_REGEX.matchEntire(line)
                HR_REGEX.matchEntire(line) == null
                TABLE_SEPARATOR_REGEX.matchEntire(lines[i + 1]) != null
                blocks += DisplayMath(mathInline.groupValues[1].trim())
                blocks += Heading(level, InlineTokenizer.tokenize(content.trim()))
                blocks += HorizontalRule
                blocks += block
                blocks += bq
                blocks += list
                blocks += math
                blocks += paragraph
                cells + List(headers.size - cells.size) { "" }
                cells += cur.toString()
                cells.take(headers.size)
                continue
                cur.append('|')
                cur.clear()
                else -> ColumnAlign.NONE
                i += 2
                i = k
                i = next
                i++
                if (ATX_HEADING_REGEX.matchEntire(line) != null) break
                if (BLOCKQUOTE_REGEX.matchEntire(line) != null) break
                if (FENCE_REGEX.matchEntire(line) != null) break
                if (HR_REGEX.matchEntire(line) != null) break
                if (MATH_DISPLAY_BRACKET_INLINE_REGEX.matchEntire(line) != null) break
                if (MATH_DISPLAY_BRACKET_OPEN_REGEX.matchEntire(line) != null) break
                if (MATH_DISPLAY_DOLLAR_FENCE_REGEX.matchEntire(line) != null) break
                if (MATH_DISPLAY_INLINE_REGEX.matchEntire(line) != null) break
                if (SETEXT_H1_REGEX.matchEntire(next) != null) {
                if (SETEXT_H2_REGEX.matchEntire(next) != null) {
                if (c.isNotEmpty() && c[0] == fenceChar && c.length >= fenceLen && closer.groupValues[3].isBlank()) {
                if (isListOpener(line)) break
                if (isSiblingOrOuterMarker(l, listIndent)) break
                if (k >= end) break
                if (l.isBlank()) {
                if (line.trim() == "kai-ui") break
                if (lineIndent >= contentCol) {
                if (lines[i].isBlank()) break
                if (m == null || m.groupValues[1].length != listIndent) break
                if (splitResult != null) {
                if (tableResult != null) {
                inner += lines[i]
                itemLines.removeAt(itemLines.lastIndex)
                j++
                return DisplayMath(bodyLines.joinToString("\n").trim()) to (i + 1)
                sawBlankBetweenItems = true
                t.endsWith(":") -> ColumnAlign.RIGHT
                t.startsWith(":") && t.endsWith(":") -> ColumnAlign.CENTER
                t.startsWith(":") -> ColumnAlign.LEFT
                val (block, next) = parseFence(lines, i, end, fenceMatch)
                val (bq, next) = parseBlockquote(lines, i, end, depth)
                val (list, next) = parseList(lines, i, end, isOrdered = ordered != null, depth = depth)
                val (math, next) = parseDisplayMath(lines, i, end, MathFence.Brackets)
                val (math, next) = parseDisplayMath(lines, i, end, MathFence.Dollars)
                val (paragraph, next) = parseParagraph(lines, i, end)
                val c = closer.groupValues[2]
                val content = atx.groupValues[2]
                val l = lines[j]
                val level = atx.groupValues[1].length
                val lineIndent = indentOf(l)
                val m = if (isOrdered) ORDERED_REGEX.matchEntire(lines[k]) else BULLET_REGEX.matchEntire(lines[k])
                val next = lines[i + 1]
                val splitResult = tryParseKaiUiSplit(lines, i, end)
                val tableResult = parseTable(lines, i, end)
                var k = i + 1
                while (k < end && lines[k].isBlank()) k++
                }
                } else {
            ) {
            MathFence.Brackets -> MATH_DISPLAY_BRACKET_CLOSE_REGEX
            MathFence.Dollars -> MATH_DISPLAY_DOLLAR_FENCE_REGEX
            accum.append(line)
            blocks += paragraph
            bm != null -> bm.groupValues[1].length
            bodyLines += lines[i]
            bodyLines += stripIndent(l, indent)
            cur.append(c)
            else -> return false
            i = j
            i = next
            i++
            if (!l.contains('|')) break
            if (BLOCKQUOTE_REGEX.matchEntire(line) != null) {
            if (HR_REGEX.matchEntire(line) != null) {
            if (MATH_DISPLAY_BRACKET_OPEN_REGEX.matchEntire(line) != null) {
            if (MATH_DISPLAY_DOLLAR_FENCE_REGEX.matchEntire(line) != null) {
            if (accum.isNotEmpty()) accum.append('\n')
            if (atx != null) {
            if (bullet != null || ordered != null) {
            if (c == '\\' && i + 1 < s.length && s[i + 1] == '|') {
            if (c == '|') {
            if (closer != null) {
            if (closerRegex.matchEntire(lines[i]) != null) {
            if (fenceMatch != null) {
            if (i != start) {
            if (i + 1 < end && !isListOpener(line) && !isBlockquoteOpener(line) &&
            if (l.isBlank()) break
            if (line.contains('|') && i + 1 < end &&
            if (line.isBlank()) break
            if (line.isBlank()) {
            if (line.length > MAX_LINE_REGEX_LEN) {
            if (line.trim() == "kai-ui") {
            if (m == null) {
            if (match == null || match.groupValues[1].length != listIndent) break
            if (mathInline != null) {
            info.equals("math", ignoreCase = true)
            info.equals("tex", ignoreCase = true) ||
            inner += m.groupValues[1]
            items += ListItem(children)
            om != null -> om.groupValues[1].length
            return DisplayMath(body.trim()) to next
            return decodeKaiUi(body) to next
            rows += padded.map { InlineTokenizer.tokenize(it.trim()) }.toImmutableList()
            val (paragraph, next) = parseParagraph(lines, i, end)
            val atx = ATX_HEADING_REGEX.matchEntire(line)
            val bullet = BULLET_REGEX.matchEntire(line)
            val c = s[i]
            val cells = splitRow(l)
            val children = scanLines(itemLines, 0, itemLines.size, depth + 1)
            val closer = FENCE_REGEX.matchEntire(l)
            val content = if (isOrdered) match.groupValues[5] else match.groupValues[4]
            val contentCol = listIndent + marker.length + spacing.length
            val fenceMatch = FENCE_REGEX.matchEntire(line)
            val itemLines = mutableListOf(content)
            val l = lines[i]
            val line = lines[i]
            val m = BLOCKQUOTE_REGEX.matchEntire(lines[i])
            val marker = if (isOrdered) match.groupValues[2] + match.groupValues[3] else match.groupValues[2]
            val match = if (isOrdered) ORDERED_REGEX.matchEntire(line) else BULLET_REGEX.matchEntire(line)
            val mathInline = MATH_DISPLAY_INLINE_REGEX.matchEntire(line)
            val ordered = ORDERED_REGEX.matchEntire(line)
            val padded = if (cells.size < headers.size) {
            val spacing = if (isOrdered) match.groupValues[4] else match.groupValues[3]
            val t = cell.trim()
            var j = i + 1
            when {
            while (itemLines.isNotEmpty() && itemLines.last().isBlank()) {
            while (j < end) {
            }
            } else {
        """^\s{0,3}(?:-(?:[ \t]*-){2,}|\*(?:[ \t]*\*){2,}|_(?:[ \t]*_){2,})\s*$""",
        ) {
        // Unclosed: tolerate for streaming — emit what we have.
        cells += cur.toString()
        depth: Int,
        end: Int,
        fence: MathFence,
        fenceChar: Char,
        fenceLen: Int,
        if (depth >= MAX_BLOCK_DEPTH) return flattenToParagraph(lines, start, end)
        if (headerCells.isEmpty() || sepCells.size != headerCells.size) return null
        if (indent == 0) return line
        if (info.equals("kai-ui", ignoreCase = true)) {
        if (info.equals("latex", ignoreCase = true) ||
        if (info.isNotEmpty() && !info.equals("json", ignoreCase = true)) return null
        if (j >= end) return null
        if (s.endsWith("|") && !s.endsWith("\\|")) s = s.substring(0, s.length - 1)
        if (s.startsWith("|")) s = s.substring(1)
        if (text.isEmpty()) return persistentListOf()
        indent: Int,
        is KaiUiParser.UiBlockResult.Error -> KaiUiError(result.rawJson)
        is KaiUiParser.UiBlockResult.Ui -> KaiUiBlock(result.node, result.rawJson)
        isOrdered: Boolean,
        lines: List<String>,
        null -> KaiUiError(body)
        openerMatch: MatchResult,
        return Blockquote(children) to i
        return CodeFence(language, body, closed) to next
        return DisplayMath(bodyLines.joinToString("\n").trim()) to i
        return FenceBody(bodyLines.joinToString("\n"), closed = false, nextIndex = i)
        return Paragraph(InlineTokenizer.tokenize(accum.toString())) to i
        return Table(headers, alignments.toImmutableList(), rows.toImmutableList()) to i
        return blocks.toImmutableList()
        return cells
        return decodeKaiUi(body) to next
        return indent <= currentIndent
        return line.substring(strip)
        return listBlock to i
        return n
        return persistentListOf(Paragraph(InlineTokenizer.tokenize(text)))
        return scanLines(lines, 0, lines.size, 0)
        start: Int,
        val (body, _, next) = readFenceBody(lines, j + 1, end, fenceChar, fenceLen, indent)
        val (body, closed, next) = readFenceBody(lines, start + 1, end, fenceChar, fenceLen, indent)
        val accum = StringBuilder()
        val alignments = sepCells.map { cell ->
        val blocks = mutableListOf<BlockNode>()
        val bm = BULLET_REGEX.matchEntire(line)
        val bodyLines = mutableListOf<String>()
        val cells = mutableListOf<String>()
        val children = scanLines(inner, 0, inner.size, depth + 1)
        val closerRegex = when (fence) {
        val cur = StringBuilder()
        val fence = FENCE_REGEX.matchEntire(lines[j]) ?: return null
        val fence = openerMatch.groupValues[2]
        val fenceChar = fence.groupValues[2][0]
        val fenceChar = fence[0]
        val fenceLen = fence.groupValues[2].length
        val fenceLen = fence.length
        val firstMatch = if (isOrdered) ORDERED_REGEX.matchEntire(lines[start])!! else BULLET_REGEX.matchEntire(lines[start])!!
        val headerCells = splitRow(lines[start])
        val headers = headerCells.map { InlineTokenizer.tokenize(it.trim()) }.toImmutableList()
        val immutableItems = items.toImmutableList()
        val indent = fence.groupValues[1].length
        val indent = openerMatch.groupValues[1].length
        val indent = when {
        val info = fence.groupValues[3].trim()
        val info = openerMatch.groupValues[3].trim()
        val inner = mutableListOf<String>()
        val items = mutableListOf<ListItem>()
        val language = info.takeIf { it.isNotEmpty() }
        val lines = normalized.split("\n")
        val listBlock = if (isOrdered) OrderedList(startNum, immutableItems, tight) else BulletList(immutableItems, tight)
        val listIndent = firstMatch.groupValues[1].length
        val normalized = text.replace("\r\n", "\n").replace("\r", "\n")
        val om = ORDERED_REGEX.matchEntire(line)
        val rows = mutableListOf<ImmutableList<ImmutableList<InlineNode>>>()
        val sepCells = splitRow(lines[start + 1])
        val startNum = if (isOrdered) firstMatch.groupValues[2].toIntOrNull() ?: 1 else 1
        val text = (start until end).joinToString("\n") { lines[it] }.trim()
        val tight = !sawBlankBetweenItems
        var i = 0
        var i = start
        var i = start + 1
        var i = start + 2
        var j = start + 1
        var n = 0
        var s = line.trim()
        var sawBlankBetweenItems = false
        var strip = 0
        while (i < end) {
        while (i < s.length) {
        while (j < end && lines[j].isBlank()) j++
        while (n < line.length && line[n] == ' ') n++
        while (strip < indent && strip < line.length && line[strip] == ' ') strip++
        }
    )
    ): FenceBody {
    ): Pair<BlockNode, Int> {
    ): Pair<BlockNode, Int>? {
    // =========================================================================================
    // Blockquote
    // Fenced code (including kai-ui)
    // Lists
    // Paragraph
    // Table
    fun scan(text: String): ImmutableList<BlockNode> {
    private const val MAX_BLOCK_DEPTH = 32
    private const val MAX_LINE_REGEX_LEN = 10_000
    private data class FenceBody(val body: String, val closed: Boolean, val nextIndex: Int)
    private enum class MathFence { Dollars, Brackets }
    private fun decodeKaiUi(body: String): BlockNode = when (val result = KaiUiParser.parseUiBlockBody(body)) {
    private fun flattenToParagraph(lines: List<String>, start: Int, end: Int): ImmutableList<BlockNode> {
    private fun indentOf(line: String): Int {
    private fun isBlockquoteOpener(line: String): Boolean = BLOCKQUOTE_REGEX.matchEntire(line) != null
    private fun isListOpener(line: String): Boolean = BULLET_REGEX.matchEntire(line) != null || ORDERED_REGEX.matchEntire(line) != null
    private fun isSiblingOrOuterMarker(line: String, currentIndent: Int): Boolean {
    private fun parseBlockquote(lines: List<String>, start: Int, end: Int, depth: Int): Pair<BlockNode, Int> {
    private fun parseDisplayMath(
    private fun parseFence(
    private fun parseList(
    private fun parseParagraph(lines: List<String>, start: Int, end: Int): Pair<BlockNode, Int> {
    private fun parseTable(
    private fun readFenceBody(
    private fun scanLines(lines: List<String>, start: Int, end: Int, depth: Int): ImmutableList<BlockNode> {
    private fun splitRow(line: String): List<String> {
    private fun stripIndent(line: String, indent: Int): String {
    private fun tryParseKaiUiSplit(
    private val ATX_HEADING_REGEX = Regex("""^\s{0,3}(#{1,6})(?:\s+(.*?))?\s*#*\s*$""")
    private val BLOCKQUOTE_REGEX = Regex("""^\s{0,3}>\s?(.*)$""")
    private val BULLET_REGEX = Regex("""^(\s*)([-*+])(\s+)(.*)$""")
    private val FENCE_REGEX = Regex("""^(\s{0,3})(`{3,}|~{3,})\s*(.*?)\s*$""")
    private val HR_REGEX = Regex(
    private val MATH_DISPLAY_BRACKET_CLOSE_REGEX = Regex("""^\s*\\\]\s*$""")
    private val MATH_DISPLAY_BRACKET_INLINE_REGEX = Regex("""^\s*\\\[([\s\S]+?)\\\]\s*$""")
    private val MATH_DISPLAY_BRACKET_OPEN_REGEX = Regex("""^\s*\\\[\s*$""")
    private val MATH_DISPLAY_DOLLAR_FENCE_REGEX = Regex("""^\s*\$\$\s*$""")
    private val MATH_DISPLAY_INLINE_REGEX = Regex("""^\s*\$\$([\s\S]+?)\$\$\s*$""")
    private val ORDERED_REGEX = Regex("""^(\s*)(\d{1,9})([.)])(\s+)(.*)$""")
    private val SETEXT_H1_REGEX = Regex("""^\s{0,3}=+\s*$""")
    private val SETEXT_H2_REGEX = Regex("""^\s{0,3}-+\s*$""")
    private val TABLE_SEPARATOR_REGEX = Regex("""^\s*\|?\s*:?-+:?\s*(\|\s*:?-+:?\s*)+\|?\s*$""")
    }
 *
 *    pattern (`kai-ui` on its own line followed by a `json` fence) from legacy LLM outputs.
 *  - ATX and setext headings
 *  - Blockquotes (`> `)
 *  - Bullet lists (`-`, `*`, `+`) and ordered lists (`1.`, `1)`), with nesting by indent
 *  - Fenced code blocks with info-string (```/~~~), including `kai-ui` and the split-block
 *  - GFM tables (pipe-delimited with alignment separator row)
 *  - Horizontal rules (`---`, `***`, `___`)
 *  - Paragraphs
 * Line-based block splitter. Scans raw markdown text into a list of [BlockNode]s.
 * Not supported: reference-style links, HTML blocks, footnotes, task lists, definition lists.
 * Scope (LLM-output subset — not full CommonMark):
 */
/**
internal object BlockScanner {
}
