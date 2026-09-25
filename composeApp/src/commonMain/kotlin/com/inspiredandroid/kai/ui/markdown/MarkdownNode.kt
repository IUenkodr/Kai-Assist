import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.ui.dynamicui.KaiUiNode
import kotlinx.collections.immutable.ImmutableList

    val alignments: ImmutableList<ColumnAlign>,
    val closed: Boolean,
    val code: String,
    val headers: ImmutableList<ImmutableList<InlineNode>>,
    val items: ImmutableList<ListItem>,
    val language: String?,
    val rows: ImmutableList<ImmutableList<ImmutableList<InlineNode>>>,
    val start: Int,
    val tight: Boolean,
) : BlockNode
@Immutable
data class Blockquote(val children: ImmutableList<BlockNode>) : BlockNode
data class BulletList(val items: ImmutableList<ListItem>, val tight: Boolean) : BlockNode
data class CodeFence(
data class DisplayMath(val latex: String) : BlockNode
data class Emphasis(val children: ImmutableList<InlineNode>) : InlineNode
data class Heading(val level: Int, val inlines: ImmutableList<InlineNode>) : BlockNode
data class Image(val src: String, val alt: String) : InlineNode
data class InlineCode(val code: String) : InlineNode
data class InlineMath(val latex: String) : InlineNode
data class KaiUiBlock(val node: KaiUiNode, val rawJson: String) : BlockNode
data class KaiUiError(val rawJson: String) : BlockNode
data class Link(val href: String, val children: ImmutableList<InlineNode>) : InlineNode
data class ListItem(val children: ImmutableList<BlockNode>)
data class MarkdownDocument(val blocks: ImmutableList<BlockNode>)
data class OrderedList(
data class Paragraph(val inlines: ImmutableList<InlineNode>) : BlockNode
data class Strike(val children: ImmutableList<InlineNode>) : InlineNode
data class Strong(val children: ImmutableList<InlineNode>) : InlineNode
data class Table(
data class Text(val value: String) : InlineNode
data object HorizontalRule : BlockNode
data object LineBreak : InlineNode
enum class ColumnAlign { LEFT, CENTER, RIGHT, NONE }
package com.inspiredandroid.kai.ui.markdown
sealed interface BlockNode
sealed interface InlineNode
