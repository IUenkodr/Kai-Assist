package com.inspiredandroid.kai.ui.markdown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.inspiredandroid.kai.ui.markdown.math.MathFormula
import kotlinx.collections.immutable.ImmutableList

                    style = style,
                    text = seg.nodes.toAnnotatedString().flattenNewlines(),
                    textAlign = textAlign,
                )
                current.clear()
                is InlineSegment.Math -> MathFormula(latex = seg.latex, display = false)
                is InlineSegment.TextRun -> Text(
                out += InlineSegment.TextRun(current.toList())
            current += n
            else -> Unit
            if (current.isNotEmpty()) {
            is Emphasis -> if (containsMath(n.children)) return true
            is InlineMath -> return true
            is Link -> if (containsMath(n.children)) return true
            is Strike -> if (containsMath(n.children)) return true
            is Strong -> if (containsMath(n.children)) return true
            modifier = modifier,
            out += InlineSegment.Math(n.latex)
            style = style,
            text = inlines.toAnnotatedString(),
            textAlign = textAlign,
            when (seg) {
            }
        )
        // Top-align keeps adjacent text anchored when a math child (e.g. a fraction) is tall,
        // which in turn keeps list-bullets aligned with their first line of content.
        Text(
        for (seg in segments) {
        horizontalArrangement = Arrangement.Start,
        if (n is InlineMath) {
        itemVerticalAlignment = Alignment.Top,
        modifier = modifier,
        return
        verticalArrangement = Arrangement.Center,
        when (n) {
        }
        } else {
    ) {
    AnnotatedString(text.replace('\n', ' '), spanStyles, paragraphStyles)
    FlowRow(
    data class Math(val latex: String) : InlineSegment
    data class TextRun(val nodes: List<InlineNode>) : InlineSegment
    for (n in nodes) {
    if (!containsMath(inlines)) {
    if (current.isNotEmpty()) out += InlineSegment.TextRun(current.toList())
    inlines: ImmutableList<InlineNode>,
    modifier: Modifier = Modifier,
    return false
    return out
    style: TextStyle,
    textAlign: TextAlign = TextAlign.Unspecified,
    this
    val current = mutableListOf<InlineNode>()
    val out = mutableListOf<InlineSegment>()
    val segments = remember(inlines) { splitAroundMath(inlines) }
    }
 * Render a list of [InlineNode]s. When no [InlineMath] is present this delegates to a plain
 * [Text] — preserving native text selection, word wrapping, and alignment. When math is
 * and [MathFormula] composables. Formulas stay atomic at wrap boundaries; text segments
 * present, the inlines are split around each formula and laid out as a [FlowRow] of text
 * wrap normally within their own Text.
 */
) {
/**
/** `\n` inside a FlowRow TextRun forces a hard break that breaks flow around math; flatten to spaces. */
@Composable
@OptIn(ExperimentalLayoutApi::class)
internal fun InlineContent(
private fun AnnotatedString.flattenNewlines(): AnnotatedString = if ('\n' !in text) {
private fun containsMath(nodes: List<InlineNode>): Boolean {
private fun splitAroundMath(nodes: List<InlineNode>): List<InlineSegment> {
private sealed interface InlineSegment {
}
} else {
