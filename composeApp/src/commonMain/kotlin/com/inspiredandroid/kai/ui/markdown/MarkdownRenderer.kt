import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.inspiredandroid.kai.ui.dynamicui.FrozenSubmission
import com.inspiredandroid.kai.ui.dynamicui.KaiUiRenderer
import com.inspiredandroid.kai.ui.markdown.math.MathFormula
import kotlinx.collections.immutable.persistentListOf

                        inlines = cell,
                        modifier = Modifier.weight(1f).padding(4.dp),
                        style = MaterialTheme.typography.bodyLarge,
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        textAlign = alignTextFor(block.alignments.getOrNull(i)),
                    )
                    InlineContent(
                    code = block.code,
                    language = block.language,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
                BlockRenderer(block, isInteractive, onUiCallback, frozen)
                CodeFenceBlock(
                block.headers.forEachIndexed { i, cell ->
                row.forEachIndexed { i, cell ->
                }
            .fillMaxWidth()
            .horizontalScroll(scroll),
            .padding(vertical = 8.dp)
            HorizontalDivider()
            ListItemRow("${block.start + index}.", 24.dp, item, isInteractive, onUiCallback, frozen)
            ListItemRow("•", 16.dp, item, isInteractive, onUiCallback, frozen)
            MarkdownDocument(persistentListOf(Paragraph(persistentListOf(com.inspiredandroid.kai.ui.markdown.Text(content)))))
            Row {
            block.children.forEach { BlockRenderer(it, isInteractive, onUiCallback, frozen) }
            code = block.rawJson,
            color = MaterialTheme.colorScheme.outline,
            contentDescription = img.alt,
            for (block in document.blocks) {
            frozen = frozen,
            if (block.code.isNotBlank() || !block.language.isNullOrBlank()) {
            isInteractive = isInteractive,
            item.children.forEach { BlockRenderer(it, isInteractive, onUiCallback, frozen) }
            language = "json",
            model = img.src,
            modifier = Modifier.fillMaxHeight(),
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            modifier = Modifier.padding(vertical = 4.dp),
            modifier = Modifier.padding(vertical = 8.dp),
            modifier = Modifier.widthIn(min = scaledMarkerWidth).padding(end = 4.dp),
            node = block.node,
            onCallback = onUiCallback,
            style = MaterialTheme.typography.bodyLarge,
            text = marker,
            thickness = 3.dp,
            }
        )
        1 -> typography.headlineSmall
        2 -> typography.titleLarge
        3 -> typography.titleMedium
        4 -> typography.titleSmall
        5 -> typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        AsyncImage(
        Column(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(start = 8.dp)) {
        Column(modifier) {
        HorizontalRule -> HorizontalDivider(Modifier.padding(vertical = 8.dp))
        MathFormula(latex = block.latex, display = true)
        Text(
        VerticalDivider(
        block.items.forEachIndexed { index, item ->
        contentAlignment = Alignment.Center,
        else -> typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        for (item in block.items) {
        for (row in block.rows) {
        if (block.headers.any { it.isNotEmpty() }) {
        inlines = block.inlines,
        is Blockquote -> BlockquoteBlock(block, isInteractive, onUiCallback, frozen)
        is BulletList -> BulletListBlock(block, isInteractive, onUiCallback, frozen)
        is CodeFence -> {
        is DisplayMath -> DisplayMathBlock(block)
        is Heading -> HeadingBlock(block)
        is KaiUiBlock -> KaiUiRenderer(
        is KaiUiError -> CodeFenceBlock(
        is OrderedList -> OrderedListBlock(block, isInteractive, onUiCallback, frozen)
        is Paragraph -> ParagraphBlock(block)
        is Table -> TableBlock(block)
        modifier = Modifier
        modifier = Modifier.padding(vertical = 2.dp),
        modifier = Modifier.padding(vertical = 4.dp),
        return
        runCatching { parseMarkdown(content) }.getOrElse {
        style = MaterialTheme.typography.bodyLarge,
        style = style,
        val img = block.inlines[0] as Image
        }
    )
    ) {
    // The marker column is sized for the default font scale; scale it so "10." still
    // Wrap in horizontal scroll so wide formulas overflow cleanly instead of squishing
    // an unusually long marker widens instead of being clipped.
    // fits when body text doubles, and keep it a minimum rather than a fixed width so
    // their children into a narrow column (KaTeX/MathJax use the same pattern).
    Box(
    Column(Modifier.padding(vertical = 4.dp)) {
    Column(modifier = Modifier.padding(vertical = 2.dp)) {
    ColumnAlign.CENTER -> TextAlign.Center
    ColumnAlign.LEFT -> TextAlign.Start
    ColumnAlign.RIGHT -> TextAlign.End
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onSurface) {
    InlineContent(
    MarkdownContent(doc, modifier, isInteractive, onUiCallback, frozen)
    Row {
    Row(modifier = Modifier.padding(vertical = 4.dp).height(IntrinsicSize.Min)) {
    block: BlockNode,
    block: Blockquote,
    block: BulletList,
    block: OrderedList,
    content: String,
    document: MarkdownDocument,
    else -> TextAlign.Unspecified
    frozen: FrozenSubmission? = null,
    frozen: FrozenSubmission?,
    if (block.inlines.size == 1 && block.inlines[0] is Image) {
    isInteractive: Boolean = false,
    isInteractive: Boolean,
    item: ListItem,
    marker: String,
    markerWidth: androidx.compose.ui.unit.Dp,
    modifier: Modifier = Modifier,
    onUiCallback: (String, Map<String, String>) -> Unit,
    onUiCallback: (event: String, data: Map<String, String>) -> Unit = { _, _ -> },
    val doc = remember(content) {
    val scaledMarkerWidth = markerWidth * LocalDensity.current.fontScale
    val scroll = rememberScrollState()
    val style = when (block.level) {
    val typography = MaterialTheme.typography
    when (block) {
    }
 *
 * Kai-UI blocks dispatch to [KaiUiRenderer]; pass `isInteractive = false` to render them as
 * Render a parsed [MarkdownDocument] as a Compose layout. Each block becomes one child of the
 * outer [Column]; inline content is rendered as [androidx.compose.ui.text.AnnotatedString].
 * read-only (completed historical messages keep their layout but disable buttons/inputs).
 */
) {
/**
@Composable
fun MarkdownContent(
package com.inspiredandroid.kai.ui.markdown
private fun BlockRenderer(
private fun BlockquoteBlock(
private fun BulletListBlock(
private fun DisplayMathBlock(block: DisplayMath) {
private fun HeadingBlock(block: Heading) {
private fun ListItemRow(
private fun OrderedListBlock(
private fun ParagraphBlock(block: Paragraph) {
private fun TableBlock(block: Table) {
private fun alignTextFor(align: ColumnAlign?): TextAlign = when (align) {
}
