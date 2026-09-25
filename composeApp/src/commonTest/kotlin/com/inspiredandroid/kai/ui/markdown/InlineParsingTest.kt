
            listOf(Text("a "), InlineCode("b"), Text(" c "), InlineCode("d"), Text(" e")),
            listOf(Text("x "), InlineCode("*not*"), Text(" y")),
            strong.children,
        )
        // Asterisks are permissive — matches CommonMark behavior.
        // Regression: the previous LINK_REGEX inner group `(?:\\.|[^\[\]])*` allowed `\X` to
        // The bold pair bridges the code spans; `*` inside code is ignored.
        // closing `](url)`. The test runner's timeout catches a hang.
        // match either as one `\\.` or as two `[^…]` iterations. On Android's ICU regex,
        // this produced exponential backtracking when the input had many `\X` pairs and no
        assertEquals(
        assertEquals("https://example.com", link.href)
        assertEquals("https://example.com/x.png", image.src)
        assertEquals("photo", image.alt)
        assertEquals(3, result.size)
        assertEquals(InlineCode("code"), strong.children[1])
        assertEquals(Text(" after"), strong.children[2])
        assertEquals(Text("before "), strong.children[0])
        assertEquals(listOf(Emphasis(persistentListOf(Text("italic")))), inlines("*italic*"))
        assertEquals(listOf(Emphasis(persistentListOf(Text("italic")))), inlines("_italic_"))
        assertEquals(listOf(InlineCode("a*b*c")), inlines("`a*b*c`"))
        assertEquals(listOf(InlineCode("x = 1")), inlines("`x = 1`"))
        assertEquals(listOf(Strike(persistentListOf(Text("gone")))), inlines("~~gone~~"))
        assertEquals(listOf(Strong(persistentListOf(Text("bold")))), inlines("**bold**"))
        assertEquals(listOf(Strong(persistentListOf(Text("bold")))), inlines("__bold__"))
        assertEquals(listOf(Text("**unclosed")), result)
        assertEquals(listOf(Text("*literal*")), inlines("\\*literal\\*"))
        assertEquals(listOf(Text("*unclosed text")), result)
        assertEquals(listOf(Text("`not code`")), inlines("\\`not code\\`"))
        assertEquals(listOf(Text("foo_bar_baz")), inlines("foo_bar_baz"))
        assertEquals(listOf(Text("hello world")), inlines("hello world"))
        assertEquals(persistentListOf(Text("click here")), link.children)
        assertTrue(result.any { it is Emphasis })
        assertTrue(result.any { it is LineBreak })
        assertTrue(result.blocks.isNotEmpty())
        assertTrue(result[0] is Strong)
        assertTrue(result[1] is Text)
        assertTrue(result[2] is Emphasis)
        assertTrue(strong.children.any { it is Emphasis })
        return para.inlines
        val image = result.single() as Image
        val link = result.single() as Link
        val para = parseMarkdown(text).blocks.single() as Paragraph
        val pathological = "[start " + "\\X".repeat(60) + " end]not-a-paren"
        val result = inlines("![photo](https://example.com/x.png)")
        val result = inlines("**a `b` c `d` e**")
        val result = inlines("**before `code` after**")
        val result = inlines("**bold _and italic_ text**")
        val result = inlines("**bold** and *italic*")
        val result = inlines("**unclosed")
        val result = inlines("**x `*not*` y**")
        val result = inlines("*unclosed text")
        val result = inlines("[click here](https://example.com)")
        val result = inlines("foo*bar*baz")
        val result = inlines("line one  \nline two")
        val result = parseMarkdown(pathological)
        val strong = result.single() as Strong
    @Test
    fun `backslash escape of asterisk`() {
    fun `backslash escape of backtick`() {
    fun `emphasis asterisks inside inline code are not delimiters`() {
    fun `emphasis with single asterisk`() {
    fun `emphasis with single underscore`() {
    fun `hard line break from trailing double space`() {
    fun `image produces Image with src and alt`() {
    fun `inline code with special chars inside`() {
    fun `inline code`() {
    fun `intraword asterisks do form emphasis`() {
    fun `intraword underscores do not form emphasis`() {
    fun `link produces Link with href and children`() {
    fun `mixed bold and italic`() {
    fun `nested emphasis inside strong`() {
    fun `pathological backslash run does not hang the parser`() {
    fun `plain text is a single Text node`() {
    fun `strike with tildes`() {
    fun `strong span wraps inline code`() {
    fun `strong span wraps multiple inline code spans`() {
    fun `strong with double asterisks`() {
    fun `strong with double underscores`() {
    fun `unclosed emphasis degrades to literal`() {
    fun `unclosed strong degrades to literal`() {
    private fun inlines(text: String): List<InlineNode> {
    }
class InlineParsingTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf
package com.inspiredandroid.kai.ui.markdown
}
