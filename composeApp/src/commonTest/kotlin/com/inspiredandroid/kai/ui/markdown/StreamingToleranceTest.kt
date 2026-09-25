
                append(" ".repeat(i * 2))
                append("- item\n")
            ```kai-ui
            for (i in 0 until 500) {
            {"type":"column","children":[{"type":"text","value":"a"
            }
        """.trimIndent()
        assertEquals("kotlin", fence.language)
        assertEquals("val x =", fence.code)
        assertEquals(1, doc.blocks.size)
        assertEquals(2, doc.blocks.size)
        assertEquals(false, fence.closed)
        assertEquals(persistentListOf(Text("before ![alt")), para.inlines)
        assertEquals(persistentListOf(Text("before [foo")), para.inlines)
        assertEquals(persistentListOf(Text("this is *partial")), para.inlines)
        assertEquals(persistentListOf(Text(big)), para.inlines)
        assertTrue(doc.blocks.isNotEmpty())
        assertTrue(doc.blocks[0] is KaiUiBlock || doc.blocks[0] is KaiUiError)
        assertTrue(doc.blocks[1] is Paragraph)
        val big = "x".repeat(200_000)
        val doc = parseMarkdown("*".repeat(5_000))
        val doc = parseMarkdown("Full paragraph.\n\nPartial **bold")
        val doc = parseMarkdown("[".repeat(5_000))
        val doc = parseMarkdown("```kotlin\nval x =")
        val doc = parseMarkdown("before ![alt")
        val doc = parseMarkdown("before [foo")
        val doc = parseMarkdown("this is *partial")
        val doc = parseMarkdown("| a | b |\n| - |")
        val doc = parseMarkdown(big)
        val doc = parseMarkdown(md)
        val fence = doc.blocks.single() as CodeFence
        val md = """
        val md = "*".repeat(1_000) + "text" + "*".repeat(1_000)
        val md = "> ".repeat(10_000) + "leaf"
        val md = buildString {
        val para = doc.blocks.single() as Paragraph
        }
    @Test
    fun `deeply nested emphasis does not crash`() {
    fun `deeply nested list does not crash`() {
    fun `document always renders - even after malformed table`() {
    fun `extremely deep blockquote does not crash`() {
    fun `huge single paragraph falls back to plain text`() {
    fun `long run of asterisks does not crash`() {
    fun `long run of bracket openers does not crash`() {
    fun `partial image yields literal text`() {
    fun `partial link yields literal text`() {
    fun `trailing incomplete paragraph still renders`() {
    fun `truncated kai-ui json is repaired into a block`() {
    fun `unclosed code fence yields open fence`() {
    fun `unclosed emphasis yields literal text`() {
    }
class StreamingToleranceTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf
package com.inspiredandroid.kai.ui.markdown
}
