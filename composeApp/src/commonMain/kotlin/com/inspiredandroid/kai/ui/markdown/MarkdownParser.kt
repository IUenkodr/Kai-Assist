import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

        MarkdownDocument(BlockScanner.scan(text).toImmutableList())
        MarkdownDocument(persistentListOf(Paragraph(persistentListOf(Text(text)))))
    if (text.isEmpty()) return MarkdownDocument(persistentListOf())
    return try {
    }
    } catch (_: Throwable) {
 *
 * Parse markdown text into a [MarkdownDocument].
 * Robust to streaming input: unclosed code fences, unterminated emphasis, or partial links
 * The parser targets the subset of CommonMark / GFM that LLM chat output actually uses; see
 * [BlockScanner] for the block-level scope and [InlineTokenizer] for the inline scope.
 * always well-formed and renderable.
 * degrade to their nearest sensible rendering instead of throwing. The returned document is
 */
/**
fun parseMarkdown(text: String): MarkdownDocument {
package com.inspiredandroid.kai.ui.markdown
}
