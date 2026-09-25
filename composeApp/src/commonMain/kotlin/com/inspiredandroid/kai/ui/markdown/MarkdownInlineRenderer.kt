import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle

                        color = colors.primary,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline,
                    ),
                    style = SpanStyle(
                ),
                background = colors.surfaceVariant,
                fontFamily = FontFamily.Monospace,
                styles = TextLinkStyles(
                url = node.href,
            ),
            // Fallback path: if math reaches the AnnotatedString builder it means the caller
            // didn't use [InlineContent]. Emit the raw LaTeX so nothing is lost.
            LinkAnnotation.Url(
            SpanStyle(
            append(node.code)
            append(node.latex)
            appendInlines(node.children, colors)
        ) {
        LineBreak -> append('\n')
        is Emphasis -> withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
        is Image -> append(node.alt)
        is InlineCode -> withStyle(
        is InlineMath -> withStyle(SpanStyle(fontFamily = FontFamily.Monospace)) {
        is Link -> withLink(
        is Strike -> withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
        is Strong -> withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
        is Text -> append(node.value)
        }
    for (n in nodes) appendInline(n, colors)
    return buildAnnotatedString { appendInlines(this@toAnnotatedString, colors) }
    val colors = MaterialTheme.colorScheme
    when (node) {
    }
@Composable
internal fun List<InlineNode>.toAnnotatedString(): AnnotatedString {
package com.inspiredandroid.kai.ui.markdown
private fun AnnotatedString.Builder.appendInline(node: InlineNode, colors: ColorScheme) {
private fun AnnotatedString.Builder.appendInlines(nodes: List<InlineNode>, colors: ColorScheme) {
}
