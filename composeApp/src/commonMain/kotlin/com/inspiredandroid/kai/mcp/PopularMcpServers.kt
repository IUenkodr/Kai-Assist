package com.inspiredandroid.kai.mcp
import androidx.compose.runtime.Immutable

            .firstOrNull { matchesPopularMcpUrl(server.url, it.url) && it.headers.isNotEmpty() }
            ?.headers
            ?: return@map server
            changed = true
            server
            server.copy(headers = merged)
        description = "AI-powered docs for any GitHub repo",
        description = "Check links, phones, and emails for scams",
        description = "Convert URLs to markdown, web search, image search",
        description = "Diagrams and whiteboards",
        description = "Domain availability across 1,444+ TLDs",
        description = "Flexible flight search across airlines",
        description = "Global weather forecasts and air quality",
        description = "Real-time NYC transit info",
        description = "Real-time crypto prices and market data",
        description = "Realtime web search and content extraction",
        description = "Stock data, market news, and price history",
        description = "Up-to-date library and framework docs",
        description = "Web docs, search, and browser compatibility",
        else -> normalizedUrl
        if (merged === server.headers || merged == server.headers) {
        name = "CoinGecko",
        name = "Context7",
        name = "DeepWiki",
        name = "Find-A-Domain",
        name = "Jina AI",
        name = "Kiwi.com",
        name = "MDN",
        name = "Malwarebytes",
        name = "Open-Meteo Weather",
        name = "Parallel Search",
        name = "SubwayInfo NYC",
        name = "Yahoo Finance",
        name = "tldraw",
        normalizedUrl.startsWith("http://") -> normalizedUrl.removePrefix("http://")
        normalizedUrl.startsWith("https://") -> normalizedUrl.removePrefix("https://")
        requiresAuth = true,
        savedHost == "mcp.jina.ai"
        savedHost == popularHost &&
        url = "https://api.findadomain.dev/mcp",
        url = "https://gateway.mcpservers.org/yahoo-finance/mcp",
        url = "https://mcp.api.coingecko.com/mcp",
        url = "https://mcp.context7.com/mcp",
        url = "https://mcp.deepwiki.com/mcp",
        url = "https://mcp.jina.ai/v1",
        url = "https://mcp.kiwi.com",
        url = "https://mcp.mdn.mozilla.net",
        url = "https://mcp.open-mcp.org/api/server/open-weather@latest/mcp",
        url = "https://scamguard.malwarebytes.com/claude/mcp",
        url = "https://search.parallel.ai/mcp",
        url = "https://subwayinfo.nyc/mcp",
        url = "https://tldraw-mcp-app.tldraw.workers.dev/mcp",
        val defaults = popular
        val merged = mergeMissingHeaders(server.headers, defaults)
        }
        } else {
     * Default request headers applied on one-tap add (no-auth servers).
     * Existing saved configs only receive keys they do not already define (never overwritten).
     * When true, selecting this popular entry prefills the add form and shows an API key field
     * instead of one-tap adding.
     */
    ),
    /**
    PopularMcpServer(
    defaults: Map<String, String>,
    existing: Map<String, String>,
    if (defaults.isEmpty()) return existing
    if (raw.isEmpty()) return raw
    if (saved == popular) return true
    if (servers.isEmpty()) return servers
    popular: List<PopularMcpServer> = popularMcpServers,
    return host.ifBlank { null }
    return if (changed) updated else servers
    return if (raw.startsWith("Bearer ", ignoreCase = true)) raw else "Bearer $raw"
    return if (toAdd.isEmpty()) existing else existing + toAdd
    return savedHost != null &&
    servers: List<McpServerConfig>,
    val description: String,
    val existingKeysLower = existing.keys.map { it.lowercase() }.toSet()
    val headers: Map<String, String> = emptyMap(),
    val host = withoutScheme.substringBefore('/').substringBefore('?').substringBefore('#')
    val name: String,
    val popular = normalizeMcpUrl(popularUrl)
    val popularHost = mcpHost(popular)
    val raw = apiKey.trim()
    val requiresAuth: Boolean = false,
    val saved = normalizeMcpUrl(savedUrl)
    val savedHost = mcpHost(saved)
    val toAdd = defaults.filterKeys { it.lowercase() !in existingKeysLower }
    val updated = servers.map { server ->
    val url: String,
    val withoutScheme = when {
    var changed = false
    }
 *
 * Apply popular-server default headers to saved configs without overwriting user headers.
 * Curated free MCP endpoints. Most require no API key (one-tap add).
 * Jina search tools need a free API key from jina.ai — selecting it prefills the form with an auth field.
 * Jina's `/v1` and `/sse` paths are aliases of the same host.
 * Returns the same list instance when nothing changes.
 * This list is the **runtime** source of truth for the Settings one-tap sheet — not a
 * True when [savedUrl] is the same popular endpoint as [popularUrl].
 * `update-popular-mcp-servers` skill.
 * live probe. Selection policy, last probe results, and the mirrored snapshot live in
 * the OKF bundle `docs/knowledge/popular-mcp/`. Refresh both via the
 */
)
): List<McpServerConfig> {
): Map<String, String> {
/**
/** Merge [defaults] into [existing], keeping any header key the user already set (case-insensitive). */
/** Normalize a pasted API key into an Authorization header value. */
@Immutable
data class PopularMcpServer(
internal fun applyPopularDefaultHeaders(
internal fun authorizationHeaderValue(apiKey: String): String {
internal fun matchesPopularMcpUrl(savedUrl: String, popularUrl: String): Boolean {
internal fun mergeMissingHeaders(
private fun mcpHost(normalizedUrl: String): String? {
private fun normalizeMcpUrl(url: String): String = url.trim().trimEnd('/').lowercase()
val popularMcpServers = listOf(
}
