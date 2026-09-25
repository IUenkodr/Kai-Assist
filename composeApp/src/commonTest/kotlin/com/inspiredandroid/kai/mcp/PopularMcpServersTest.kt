import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertSame
import kotlin.test.assertTrue

            McpServerConfig(id = "ctx", name = "Context7", url = "https://mcp.context7.com/mcp"),
            McpServerConfig(id = "jina_ai", name = "Jina AI", url = "https://mcp.jina.ai/v1"),
        )
        // Already has a Bearer prefix (any casing) — leave value as-is
        assertEquals("", authorizationHeaderValue("   "))
        assertEquals("1", merged["X-Custom"])
        assertEquals("2", merged["X-Other"])
        assertEquals("Bearer jina_abc", authorizationHeaderValue("  jina_abc  "))
        assertEquals("Bearer jina_abc", authorizationHeaderValue("Bearer jina_abc"))
        assertEquals("Bearer jina_abc", authorizationHeaderValue("jina_abc"))
        assertEquals("Bearer user-key", merged["Authorization"])
        assertEquals("Bearer user-key", merged["authorization"])
        assertEquals("bearer jina_abc", authorizationHeaderValue("bearer jina_abc"))
        assertEquals(1, merged.size)
        assertEquals(defaults, mergeMissingHeaders(existing, defaults))
        assertFalse(matchesPopularMcpUrl("https://example.com/mcp", "https://mcp.context7.com/mcp"))
        assertFalse(matchesPopularMcpUrl("https://search.parallel.ai/mcp", "https://mcp.jina.ai/v1"))
        assertSame(servers, updated)
        assertTrue(jina.headers.isEmpty())
        assertTrue(jina.requiresAuth)
        assertTrue(matchesPopularMcpUrl("https://mcp.jina.ai/sse", "https://mcp.jina.ai/v1"))
        assertTrue(matchesPopularMcpUrl("https://mcp.jina.ai/v1", "https://mcp.jina.ai/v1"))
        assertTrue(matchesPopularMcpUrl("https://mcp.jina.ai/v1/", "https://mcp.jina.ai/v1"))
        assertTrue(updated[0].headers.isEmpty())
        val defaults = mapOf("Authorization" to "Bearer default-key")
        val defaults = mapOf("Authorization" to "Bearer default-key", "X-Other" to "2")
        val existing = emptyMap<String, String>()
        val existing = mapOf("Authorization" to "Bearer user-key", "X-Custom" to "1")
        val existing = mapOf("authorization" to "Bearer user-key")
        val jina = popularMcpServers.single { it.name == "Jina AI" }
        val merged = mergeMissingHeaders(existing, defaults)
        val servers = listOf(
        val updated = applyPopularDefaultHeaders(servers)
    @Test
    fun `applyPopularDefaultHeaders is no-op for jina without default headers`() {
    fun `applyPopularDefaultHeaders is no-op when nothing to migrate`() {
    fun `authorizationHeaderValue prefixes Bearer when missing`() {
    fun `jina popular entry requires auth and has no default secret headers`() {
    fun `matchesPopularMcpUrl treats jina v1 and sse as same host`() {
    fun `mergeMissingHeaders adds missing defaults`() {
    fun `mergeMissingHeaders is case insensitive for existing keys`() {
    fun `mergeMissingHeaders keeps existing Authorization`() {
    }
class PopularMcpServersTest {
package com.inspiredandroid.kai.mcp
}
