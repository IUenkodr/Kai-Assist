package com.inspiredandroid.kai.ui.markdown
import kotlin.test.Test
import kotlin.test.assertEquals

        assertEquals("\uD83C\uDF89 \uD83D\uDE80 \u2728 \uD83D\uDC4D", flat)
        assertEquals("look: \uD83D\uDD25 hot", flat)
        assertEquals(listOf(Text(":unknown_made_up_thing:")), inlines(":unknown_made_up_thing:"))
        val flat = result.joinToString("") { (it as Text).value }
        val flat = strong.children.joinToString("") { (it as Text).value }
        val result = inlines("**look: :fire: hot**")
        val result = inlines(":tada: :rocket: :sparkles: :+1:")
        val strong = result.single() as Strong
    @Test
    fun `maps common shortcodes to emoji`() {
    fun `shortcodes work inside emphasis`() {
    fun `unknown shortcode is left as literal text`() {
    private fun inlines(text: String): List<InlineNode> = (parseMarkdown(text).blocks.single() as Paragraph).inlines
    }
class EmojiShortcodeTest {
}
