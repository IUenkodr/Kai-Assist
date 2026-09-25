import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import com.inspiredandroid.kai.ui.markdown.toSpeakableText

            children.forEach { it.walk(parts) }
            description?.let { parts += it }
            if (headers.isNotEmpty()) parts += headers.joinToString(", ")
            label?.let { parts += it }
            parts += label
            parts += message
            parts += tab.label
            parts += text
            parts += title
            parts += value
            rows.forEach { parts += it.joinToString(", ") }
            selected?.let { parts += it }
            source?.let { parts += it }
            tab.children.forEach { it.walk(parts) }
            title?.takeIf { it.isNotBlank() }?.let { parts += it }
        is AccordionNode -> {
        is AlertNode -> {
        is AvatarNode -> name?.let { parts += it }
        is BadgeNode -> parts += value
        is BoxNode -> children.forEach { it.walk(parts) }
        is ButtonNode -> parts += label
        is CardNode -> children.forEach { it.walk(parts) }
        is CheckboxNode -> parts += label
        is ChipGroupNode -> chips.forEach { parts += it.label }
        is CodeNode -> Unit
        is ColumnNode -> children.forEach { it.walk(parts) }
        is CountdownNode -> label?.let { parts += it }
        is DividerNode -> Unit
        is IconNode -> Unit
        is ImageNode -> alt?.let { parts += it }
        is ListNode -> items.forEach { it.walk(parts) }
        is ProgressNode -> label?.let { parts += it }
        is QuoteNode -> {
        is RadioGroupNode -> {
        is RowNode -> children.forEach { it.walk(parts) }
        is SelectNode -> {
        is SliderNode -> label?.let { parts += it }
        is StatNode -> {
        is SwitchNode -> parts += label
        is TableNode -> {
        is TabsNode -> tabs.forEach { tab ->
        is TextInputNode -> (value ?: label ?: placeholder)?.let { parts += it }
        is TextNode -> parts += value
        }
    return parts.asSequence().filter { it.isNotBlank() }.joinToString(". ")
    val parts = mutableListOf<String>()
    walk(parts)
    when (this) {
    }
 * TTS-friendly text for a message that may contain kai-ui fences. Routed through the unified
 * form says, not the JSON behind it.
 * markdown parser: formatting is stripped, code blocks dropped, and kai-ui blocks walked for
 * their human-readable labels (titles, alerts, chips, table cells) so the user hears what the
 */
/**
fun String.toSpeakableText(): String = parseMarkdown(this).toSpeakableText()
internal fun KaiUiNode.collectSpeakableText(): String {
package com.inspiredandroid.kai.ui.dynamicui
private fun KaiUiNode.walk(parts: MutableList<String>) {
}
