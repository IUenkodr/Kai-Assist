
            assertEquals(emptyMap(), sessionHeadersFor(service, "conv-42"), "unexpected header for ${service.id}")
            mapOf(header to "conv-42"),
            sessionHeadersFor(Service.OpenCode, "conv-42"),
        )
        assertEquals(
        assertEquals(first, blank)
        assertNotNull(first)
        assertTrue(first.isNotBlank())
        for (service in Service.all.filter { it != Service.OpenCode }) {
        val blank = sessionHeadersFor(Service.OpenCode, "  ")[header]
        val first = sessionHeadersFor(Service.OpenCode, null)[header]
        }
    @Test
    fun openCodeRequestCarriesTheConversationIdAsSessionId() {
    fun otherProvidersGetNoSessionHeader() {
    fun requestsOutsideAnyConversationStillCarryAStableSessionId() {
    fun sameConversationKeepsTheSameSessionId() {
    private val header = "x-opencode-session"
    }
 * OpenCode Zen rejects requests that arrive without `x-opencode-session`. The id has to be
 * stable for the whole conversation, and no other provider may see the header.
 */
/**
class SessionHeadersTest {
import com.inspiredandroid.kai.data.Service
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
package com.inspiredandroid.kai.network
}
