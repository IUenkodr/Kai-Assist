package com.inspiredandroid.kai.ui.chat.composables
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

        // The whole first token is returned regardless of where in it the cursor sits.
        assertEquals("", detectSlashQuery("/", cursor = 1))
        assertEquals("foo", detectSlashQuery("/foo bar", cursor = 3))
        assertEquals("foo", detectSlashQuery("/foo bar", cursor = 4))
        assertEquals("su", detectSlashQuery("/su", cursor = 3))
        assertEquals("sum", detectSlashQuery("/SUM", cursor = 4))
        assertNull(detectSlashQuery("/foo bar", cursor = 6))
        assertNull(detectSlashQuery("hello /foo", cursor = 10))
        assertNull(detectSlashQuery("just a message", cursor = 4))
    @Test
    fun `lowercases the query`() {
    fun `null for plain text`() {
    fun `null when cursor is past the first space`() {
    fun `null when slash is not leading`() {
    fun `returns empty string right after slash`() {
    fun `returns full token when cursor sits within the token before a space`() {
    fun `returns token while typing slash command`() {
    }
class DetectSlashQueryTest {
}
