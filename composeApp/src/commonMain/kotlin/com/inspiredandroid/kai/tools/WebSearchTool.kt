
                            b.toInt().and(0xFF).toString(16).uppercase().padStart(2, '0'),
                        "snippet" to snippet,
                        "title" to title,
                        "url" to url,
                        )
                        append(
                        append('%')
                        append(byte.toChar())
                        append(encoded[i])
                        i += 3
                        i++
                    ),
                    append(' ')
                    append(encoded[i])
                    for (b in bytes) {
                    i++
                    if (byte != null) {
                    mapOf(
                    val byte = hex.toIntOrNull(16)
                    val bytes = c.toString().encodeToByteArray()
                    val hex = encoded.substring(i + 1, i + 3)
                    }
                    } else {
                )
                c == ' ' -> append('+')
                c.isLetterOrDigit() || c in "-_.~" -> append(c)
                else -> {
                encoded[i] == '%' && i + 2 < encoded.length -> {
                encoded[i] == '+' -> {
                header("User-Agent", "Mozilla/5.0 (compatible; Kai/1.0)")
                mapOf("success" to true, "results" to emptyList<Any>(), "message" to "No results found")
                mapOf("success" to true, "results" to results)
                results.add(
                }
            "query" to ParameterSchema("string", "The search query", true),
            // Extract the actual URL from DDG redirect: //duckduckgo.com/l/?uddg=ENCODED_URL
            ?: return mapOf("success" to false, "error" to "Query is required")
            if (results.isEmpty()) {
            if (results.size >= MAX_RESULTS) break
            if (url.isNotBlank() && title.isNotBlank()) {
            mapOf("success" to false, "error" to "Search failed: ${e.message}")
            requestTimeoutMillis = 15_000
            return decodeURLComponent(uddgParam)
            val encoded = query.encodeURLQueryComponent()
            val href = hrefRegex.find(linkTag)?.groupValues?.get(1) ?: continue
            val html = response.bodyAsText()
            val linkTag = linkTags.getOrNull(i)?.value ?: continue
            val response = client.get("https://lite.duckduckgo.com/lite/?q=$encoded") {
            val results = parseResults(html)
            val snippet = snippets.getOrNull(i)?.groupValues?.get(1)?.stripHtml()?.trim() ?: ""
            val title = links[i].groupValues[1].stripHtml().trim()
            val url = extractUrlFromRedirect(href)
            when {
            }
            } else {
        ),
        .replace("&#39;", "'")
        .replace("&#x27;", "'")
        .replace("&amp;", "&")
        .replace("&gt;", ">")
        .replace("&lt;", "<")
        .replace("&nbsp;", " ")
        .replace("&quot;", "\"")
        // DuckDuckGo Lite returns results in a table structure
        // Links: <a rel="nofollow" href="//duckduckgo.com/l/?uddg=URL" class='result-link'>Title</a>
        // Not a redirect, use as-is (add https: if protocol-relative)
        // Snippets: <td class='result-snippet'>...</td>
        description = "Search the web for current information",
        description = "Search the web for current information. Returns titles, URLs, and snippets. Before answering questions about recent events, news, current prices, weather, or anything time-sensitive, search first. Also use this when you're unsure about facts or the user asks you to look something up.",
        descriptionRes = Res.string.tool_web_search_description,
        for (c in this@encodeURLQueryComponent) {
        for (i in links.indices) {
        id = "web_search",
        if (uddgParam != null) {
        install(HttpTimeout) {
        name = "Web Search",
        name = "web_search",
        nameRes = Res.string.tool_web_search_name,
        parameters = mapOf(
        return if (href.startsWith("//")) "https:$href" else href
        return results
        return try {
        val linkTags = fullLinkRegex.findAll(html).toList()
        val links = linkRegex.findAll(html).toList()
        val query = args["query"]?.toString()
        val results = mutableListOf<Map<String, String>>()
        val snippets = snippetRegex.findAll(html).toList()
        val uddgParam = uddgRegex.find(href)?.groupValues?.get(1)
        var i = 0
        while (i < encoded.length) {
        }
        } catch (e: Exception) {
    )
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema = ToolSchema(
    private fun String.encodeURLQueryComponent(): String = buildString {
    private fun String.stripHtml(): String = replace(htmlTagRegex, "")
    private fun decodeURLComponent(encoded: String): String = buildString {
    private fun extractUrlFromRedirect(href: String): String {
    private fun parseResults(html: String): List<Map<String, String>> {
    private val client = httpClient {
    private val fullLinkRegex = Regex("""<a\s[^>]*class=['"]result-link['"][^>]*>""")
    private val hrefRegex = Regex("""href=['"]([^'"]*?)['"]""")
    private val htmlTagRegex = Regex("<[^>]*>")
    private val linkRegex = Regex("""<a[^>]+class=['"]result-link['"][^>]*>([\s\S]*?)</a>""")
    private val snippetRegex = Regex("""<td[^>]+class=['"]result-snippet['"][^>]*>([\s\S]*?)</td>""")
    private val uddgRegex = Regex("""uddg=([^&]+)""")
    val toolInfo = ToolInfo(
    }
import com.inspiredandroid.kai.httpClient
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_web_search_description
import kai.composeapp.generated.resources.tool_web_search_name
object WebSearchTool : Tool {
package com.inspiredandroid.kai.tools
private const val MAX_RESULTS = 5
}
