
        LineBreak -> sb.append(' ')
        is Emphasis -> node.children.forEach { appendInline(sb, it) }
        is Image -> sb.append(node.alt)
        is InlineCode -> sb.append(node.code)
        is InlineMath -> sb.append(node.latex)
        is Link -> node.children.forEach { appendInline(sb, it) }
        is Strike -> node.children.forEach { appendInline(sb, it) }
        is Strong -> node.children.forEach { appendInline(sb, it) }
        is Text -> sb.append(node.value)
        pieces += row.joinToString(", ") { inlinesToText(it) }
        pieces += table.headers.joinToString(", ") { inlinesToText(it) }
    HorizontalRule -> ""
    for (n in inlines) appendInline(sb, n)
    for (row in table.rows) {
    if (table.headers.any { it.isNotEmpty() }) {
    if (text.isEmpty()) return text
    is Blockquote -> block.children.joinToString(". ") { blockToSpeakable(it) }.trim()
    is BulletList -> block.items.joinToString("\n") { itemToSpeakable(it) }
    is CodeFence -> ""
    is DisplayMath -> block.latex
    is Heading -> inlinesToText(block.inlines)
    is KaiUiBlock -> block.node.collectSpeakableText()
    is KaiUiError -> ""
    is OrderedList -> block.items.joinToString("\n") { itemToSpeakable(it) }
    is Paragraph -> inlinesToText(block.inlines)
    is Table -> tableToSpeakable(block)
    return ensureSentenceEnd(text)
    return if (last == '.' || last == '?' || last == '!') text else "$text."
    return pieces.joinToString(". ")
    return pieces.joinToString("\n\n").trim()
    return sb.toString()
    val last = text.last()
    val pieces = blocks.mapNotNull { blockToSpeakable(it).takeIf { p -> p.isNotBlank() } }
    val pieces = mutableListOf<String>()
    val sb = StringBuilder()
    val text = item.children.joinToString(". ") { blockToSpeakable(it) }.trim()
    when (node) {
    }
 * TTS-friendly text extracted from a parsed [MarkdownDocument]. Strips markdown formatting,
 * drops code blocks, reads link text (not URLs), and walks kai-ui blocks for their human-
 * readable labels.
 */
/**
fun MarkdownDocument.toSpeakableText(): String {
import com.inspiredandroid.kai.ui.dynamicui.collectSpeakableText
package com.inspiredandroid.kai.ui.markdown
private fun appendInline(sb: StringBuilder, node: InlineNode) {
private fun blockToSpeakable(block: BlockNode): String = when (block) {
private fun ensureSentenceEnd(text: String): String {
private fun inlinesToText(inlines: List<InlineNode>): String {
private fun itemToSpeakable(item: ListItem): String {
private fun tableToSpeakable(table: Table): String {
}
