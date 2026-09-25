package com.inspiredandroid.kai.ui.markdown
import com.inspiredandroid.kai.ui.dynamicui.AlertNode
import com.inspiredandroid.kai.ui.dynamicui.ColumnNode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

            After
            Before
            Intro.
            Outro.
            ```
            ```json
            ```kai-ui
            kai-ui
            not json at all
            {"type":"alert","message":"hi"}
            {"type":"alert","title":"Heads up","message":"Hello"}
            {"type":"alert","title":"Heads up","message":"Take care"}
            {"type":"text","value":"a"}
            {"type":"text","value":"b"}
        """.trimIndent()
        assertEquals("Heads up", alert.title)
        assertEquals("Hello", alert.message)
        assertEquals(2, col.children.size)
        assertEquals(3, blocks.size)
        assertTrue(block is KaiUiBlock)
        assertTrue(block is KaiUiError)
        assertTrue(blocks[0] is Paragraph)
        assertTrue(blocks[1] is KaiUiBlock)
        assertTrue(blocks[2] is Paragraph)
        assertTrue(spoken.contains("Heads up"))
        assertTrue(spoken.contains("Intro"))
        assertTrue(spoken.contains("Outro"))
        assertTrue(spoken.contains("Take care"))
        val alert = block.node as AlertNode
        val block = parseMarkdown(md).blocks.single()
        val blocks = parseMarkdown(md).blocks
        val col = block.node as ColumnNode
        val md = """
        val spoken = parseMarkdown(md).toSpeakableText()
    @Test
    fun `kai-ui block speakable text walks the node tree`() {
    fun `kai-ui block surrounded by markdown produces three blocks`() {
    fun `kai-ui fence produces KaiUiBlock`() {
    fun `malformed kai-ui fence produces KaiUiError`() {
    fun `ndjson multi-line kai-ui wraps children in a column`() {
    fun `split-block pattern with json fence is treated as kai-ui`() {
    }
class KaiUiBlockIntegrationTest {
}
