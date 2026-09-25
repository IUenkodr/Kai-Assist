package com.inspiredandroid.kai.ui.markdown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

        // Here we ensure the no-space-after-opener KaTeX rule keeps "$5 and $3" out of math.
        // Unclosed `$$` should not crash and should not swallow the rest of the document.
        // `$5 and` does not have a closing `$` before another context; with closing it would.
        // `$x$` wins as atomic before the `*...*` emphasis scanner runs.
        assertEquals(3, blocks.size)
        assertEquals(3, result.size)
        assertEquals(DisplayMath("E = mc^2"), doc.blocks.single())
        assertEquals(DisplayMath("\\int_0^1 x\\,dx"), doc.blocks.single())
        assertEquals(DisplayMath("e^{i\\pi} + 1 = 0"), doc.blocks.single())
        assertEquals(DisplayMath("x = 1"), doc.blocks.single())
        assertEquals(DisplayMath("x = \\frac{a}{b}"), blocks[1])
        assertEquals(InlineMath("\\frac{1}{2}"), result.single())
        assertEquals(InlineMath("a + b"), result[1])
        assertEquals(InlineMath("x+1"), result[1])
        assertEquals(InlineMath("x^2"), result[1])
        assertEquals(Text(" yes"), result[2])
        assertEquals(Text("result is "), result[0])
        assertTrue(blocks[0] is Paragraph)
        assertTrue(blocks[2] is Paragraph)
        assertTrue(doc.blocks.any { it is DisplayMath })
        assertTrue(doc.blocks.single() is CodeFence)
        assertTrue(emphasis.children.any { it is InlineMath })
        assertTrue(result.none { it is InlineMath })
        assertTrue(result.none { it is InlineMath }, "got: $result")
        return para.inlines
        val blocks = doc.blocks
        val doc = parseMarkdown("Before\n\n\$\$\nx = \\frac{a}{b}\n\$\$\n\nAfter")
        val doc = parseMarkdown("\$\$E = mc^2\$\$")
        val doc = parseMarkdown("\$\$\nx = 1")
        val doc = parseMarkdown("\\[\nx = 1\n\\]")
        val doc = parseMarkdown("\\[x = 1\\]")
        val doc = parseMarkdown("```kotlin\nval x = 1\n```")
        val doc = parseMarkdown("```latex\ne^{i\\pi} + 1 = 0\n```")
        val doc = parseMarkdown("```math\nx = 1\n```")
        val doc = parseMarkdown("```tex\n\\int_0^1 x\\,dx\n```")
        val emphasis = result.single() as Emphasis
        val para = parseMarkdown(text).blocks.single() as Paragraph
        val result = inlines("*italic \$y\$*")
        val result = inlines("I have \$5 and \$3 left")
        val result = inlines("\$\\frac{1}{2}\$")
        val result = inlines("cost \$ 5 is \$ here")
        val result = inlines("math \$\$x+1\$\$ ok")
        val result = inlines("price: \\\$5")
        val result = inlines("result is \$x^2\$ yes")
        val result = inlines("see \\(a + b\\) here")
    @Test
    fun `display math block with double dollar on own lines`() {
    fun `display math bracket form multi-line`() {
    fun `display math bracket form`() {
    fun `display math single line block`() {
    fun `dollar followed by digit is not math`() {
    fun `dollar with space after opener is not math`() {
    fun `double dollar inline treated as math`() {
    fun `escaped dollar is literal`() {
    fun `inline backslash paren math`() {
    fun `inline dollar math`() {
    fun `latex code fence renders as display math`() {
    fun `math code fence renders as display math`() {
    fun `math inside emphasis does not break`() {
    fun `math with nested braces and escapes`() {
    fun `non-math code fence stays as code`() {
    fun `streaming unclosed display math yields empty-ish block`() {
    fun `tex code fence renders as display math`() {
    private fun inlines(text: String): List<InlineNode> {
    }
/** Markdown-level integration: how `$`/`$$`/`\(…\)`/`\[…\]` become [InlineMath]/[DisplayMath]. */
class MathParsingTest {
}
