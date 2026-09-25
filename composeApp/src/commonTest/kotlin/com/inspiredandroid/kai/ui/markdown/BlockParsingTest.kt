package com.inspiredandroid.kai.ui.markdown
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf

            assertEquals(level, heading.level)
            assertEquals(persistentListOf(Text("Title")), heading.inlines)
            val doc = parseMarkdown("$hashes Title")
            val hashes = "#".repeat(level)
            val heading = doc.blocks.single() as Heading
        assertEquals("1", (table.rows[0][0].single() as Text).value)
        assertEquals("Title", (heading.inlines.single() as Text).value)
        assertEquals("a", (list.items[0].children.single() as Paragraph).inlines.joinToString("") { (it as Text).value })
        assertEquals("code", fence.code)
        assertEquals("js", fence.language)
        assertEquals("kotlin", fence.language)
        assertEquals("let x = 1", fence.code)
        assertEquals("line 1\nline 2", (inner.inlines.single() as Text).value)
        assertEquals("print('hi')", fence.code)
        assertEquals("python", fence.language)
        assertEquals("quoted", (inner.inlines.single() as Text).value)
        assertEquals("val x = 1", fence.code)
        assertEquals(1, table.rows.size)
        assertEquals(2, doc.blocks.size)
        assertEquals(2, heading.level)
        assertEquals(2, list.items.size)
        assertEquals(2, nested.items.size)
        assertEquals(2, outer.items.size)
        assertEquals(2, table.headers.size)
        assertEquals(3, list.items.size)
        assertEquals(3, table.headers.size)
        assertEquals(5, list.start)
        assertEquals(Heading(1, persistentListOf(Text("Title"))), h1.blocks.single())
        assertEquals(Heading(2, persistentListOf(Text("Title"))), h2.blocks.single())
        assertEquals(HorizontalRule, parseMarkdown("***").blocks.single())
        assertEquals(HorizontalRule, parseMarkdown("- - -").blocks.single())
        assertEquals(HorizontalRule, parseMarkdown("---").blocks.single())
        assertEquals(HorizontalRule, parseMarkdown("___").blocks.single())
        assertEquals(emptyList(), parseMarkdown("   \n  ").blocks)
        assertEquals(emptyList(), parseMarkdown("").blocks)
        assertEquals(false, fence.closed)
        assertEquals(false, list.tight)
        assertEquals(listOf(ColumnAlign.LEFT, ColumnAlign.CENTER, ColumnAlign.RIGHT), table.alignments)
        assertEquals(null, fence.language)
        assertNotNull(nested)
        assertTrue(doc.blocks[0] is Paragraph)
        assertTrue(doc.blocks[1] is Heading)
        assertTrue(doc.blocks[1] is Paragraph)
        assertTrue(fence.closed)
        assertTrue(list.tight)
        for (level in 1..6) {
        val bq = doc.blocks.single() as Blockquote
        val doc = parseMarkdown("## Title ##")
        val doc = parseMarkdown("- a\n- b\n- c")
        val doc = parseMarkdown("- a\n\n- b")
        val doc = parseMarkdown("- outer\n  - inner1\n  - inner2\n- second")
        val doc = parseMarkdown("5. first\n6. second")
        val doc = parseMarkdown("> line 1\n> line 2")
        val doc = parseMarkdown("> quoted")
        val doc = parseMarkdown("```\ncode\n```")
        val doc = parseMarkdown("```kotlin\nval x = 1\n```")
        val doc = parseMarkdown("```python\nprint('hi')")
        val doc = parseMarkdown("a | b\n---|---\n1 | 2")
        val doc = parseMarkdown("first\n\nsecond")
        val doc = parseMarkdown("para\n# heading")
        val doc = parseMarkdown("| a | b | c |\n| :- | :-: | -: |\n| 1 | 2 | 3 |")
        val doc = parseMarkdown("~~~js\nlet x = 1\n~~~")
        val fence = doc.blocks.single() as CodeFence
        val first = outer.items[0]
        val h1 = parseMarkdown("Title\n===")
        val h2 = parseMarkdown("Title\n---")
        val heading = doc.blocks.single() as Heading
        val inner = bq.children.single() as Paragraph
        val list = doc.blocks.single() as BulletList
        val list = doc.blocks.single() as OrderedList
        val nested = first.children.firstOrNull { it is BulletList } as? BulletList
        val outer = doc.blocks.single() as BulletList
        val table = doc.blocks.single() as Table
        }
    @Test
    fun `atx heading allows trailing hashes`() {
    fun `atx headings h1 through h6`() {
    fun `blockquote multiple lines`() {
    fun `blockquote single line`() {
    fun `bullet list with dash`() {
    fun `empty input produces empty document`() {
    fun `fenced code block with language`() {
    fun `fenced code block with no language`() {
    fun `horizontal rules`() {
    fun `loose list via blank line between items`() {
    fun `multiple paragraphs separated by blank line`() {
    fun `nested bullet list`() {
    fun `ordered list starting at 5`() {
    fun `paragraph ends at heading opener`() {
    fun `setext h1 and h2`() {
    fun `simple table with alignment`() {
    fun `table without outer pipes`() {
    fun `tilde fence is supported`() {
    fun `unclosed fenced code is rendered with closed=false`() {
    }
class BlockParsingTest {
}
