
        assertEquals("/root/climber_action.gif", toSandboxPath("file:///root/climber_action.gif"))
        assertEquals("/root/my file.gif", toSandboxPath("file:///root/my%20file.gif"))
        assertEquals("/root/out.png", toSandboxPath("/root/out.png"))
        assertNull(toSandboxPath("foo/bar.gif"))
        assertNull(toSandboxPath("http://example.com"))
        assertNull(toSandboxPath("https://example.com/a.gif"))
        assertNull(toSandboxPath("mailto:someone@example.com"))
        assertNull(toSandboxPath("tel:12345"))
    @Test
    fun `bare absolute path maps to itself`() {
    fun `file scheme link maps to sandbox path`() {
    fun `http and https links are not sandbox paths`() {
    fun `mailto and other schemes are not sandbox paths`() {
    fun `percent escapes are decoded`() {
    fun `relative link is not a sandbox path`() {
    }
class SandboxUriHandlerTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
package com.inspiredandroid.kai.ui
}
