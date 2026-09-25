package com.inspiredandroid.kai.ui.dynamicui
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

              {"type":"button","label":"Gorgonzola","action":{"type":"callback","event":"pick","data":{"choice":"gor"}}}
              {"type":"button","label":"Mozzarella","action":{"type":"callback","event":"pick","data":{"choice":"moz"}}},
              {"type":"text","value":"Pick a cheese"},
            Anything else?
            Intro line.
            ]}
            ```
            ```kai-ui
            {"type":"alert","title":"Heads up","message":"Pick carefully"}
            {"type":"code","code":"val x = 42","language":"kotlin"}
            {"type":"column","children":[
        """.trimIndent()
        assertEquals("", message.toSpeakableText())
        assertEquals("Hello world", "**Hello** world".toSpeakableText())
        assertTrue(spoken.contains("Anything else?"))
        assertTrue(spoken.contains("Gorgonzola"))
        assertTrue(spoken.contains("Heads up"))
        assertTrue(spoken.contains("Intro line"))
        assertTrue(spoken.contains("Mozzarella"))
        assertTrue(spoken.contains("Pick a cheese"))
        assertTrue(spoken.contains("Pick carefully"))
        val message = """
        val spoken = message.toSpeakableText()
    @Test
    fun `plain markdown passes through strip-markdown`() {
    fun `skips code nodes`() {
    fun `speaks alert title and message`() {
    fun `speaks text nodes and button labels inside a kai-ui fence`() {
    }
class KaiUiTtsTest {
}
