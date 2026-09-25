
        assertEquals("", speak("***"))
        assertEquals("", speak("---"))
        assertEquals("", speak("___"))
        assertEquals("", speak("```kotlin\nval x = 1\n```"))
        assertEquals("A, B. 1, 2. 3, 4", speak(md))
        assertEquals("Deep", speak("###### Deep"))
        assertEquals("Hello world", speak("Hello world"))
        assertEquals("Subtitle", speak("## Subtitle"))
        assertEquals("Title", speak("# Title"))
        assertEquals("a\n\nb", speak("a\n\n\n\nb"))
        assertEquals("already done.", speak("- already done."))
        assertEquals("bold and italic", speak("**bold** and *italic*"))
        assertEquals("bold text", speak("**bold text**"))
        assertEquals("bold text", speak("__bold text__"))
        assertEquals("click here", speak("[click here](https://example.com)"))
        assertEquals("code here", speak("`code here`"))
        assertEquals("first.\nsecond.", speak("1. first\n2. second"))
        assertEquals("is it?", speak("- is it?"))
        assertEquals("italic", speak("*italic*"))
        assertEquals("italic", speak("_italic_"))
        assertEquals("item one.\nitem two.", speak("- item one\n- item two"))
        assertEquals("item.", speak("* item"))
        assertEquals("photo", speak("![photo](https://example.com/img.png)"))
        assertEquals("quoted text", speak("> quoted text"))
        assertEquals("removed", speak("~~removed~~"))
        assertEquals("wow!", speak("- wow!"))
        assertEquals(expected, speak(input))
        val expected = "Hello\n\nThis is bold and italic with code.\n\nitem one.\nitem two."
        val input = "# Hello\n\nThis is **bold** and *italic* with `code`.\n\n- item one\n- item two"
        val md = "| A | B |\n| - | - |\n| 1 | 2 |\n| 3 | 4 |"
    @Test
    fun `blockquote yields inner text`() {
    fun `drops code block entirely`() {
    fun `horizontal rules become empty`() {
    fun `list items keep existing end punctuation`() {
    fun `mixed markdown document`() {
    fun `multiple blank lines collapse to single paragraph break`() {
    fun `ordered list items get period separator`() {
    fun `plain text passes through unchanged`() {
    fun `strips bold and italic combined`() {
    fun `strips bold`() {
    fun `strips headers`() {
    fun `strips images keeping alt text`() {
    fun `strips inline code keeping text`() {
    fun `strips italic`() {
    fun `strips links keeping text`() {
    fun `strips strikethrough`() {
    fun `table reads headers and rows`() {
    fun `unordered list items get period separator`() {
    private fun speak(md: String) = parseMarkdown(md).toSpeakableText()
    }
class MarkdownToSpeakableTextTest {
import kotlin.test.Test
import kotlin.test.assertEquals
package com.inspiredandroid.kai.ui.markdown
}
