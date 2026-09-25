
                            ?: ContentType.Application.FormUrlEncoded,
                        contentTypeArg?.let { runCatching { ContentType.parse(it) }.getOrNull() }
                    )
                    contentType(
                    setBody(bodyArg)
                "body" to body,
                "content_type" to responseCt,
                "final_url" to response.call.request.url.toString(),
                "status" to response.status.value,
                "success" to response.status.isSuccess(),
                a == 0 -> true
                a == 10 -> true
                a == 127 -> true
                a == 169 && b == 254 -> true
                a == 172 && b in 16..31 -> true
                a == 192 && b == 168 -> true
                description = "Content-Type header for the request body. Defaults to application/x-www-form-urlencoded when a body is present.",
                description = "HTTP method: GET (default), POST, or HEAD",
                description = "Request body (POST only). For RFC 8058 one-click unsubscribe use `List-Unsubscribe=One-Click`.",
                description = "The absolute http(s) URL to fetch",
                else -> false
                header("User-Agent", "Mozilla/5.0 (compatible; Kai/1.0)")
                if (bodyArg != null && methodArg == "POST") {
                method = HttpMethod.parse(methodArg)
                rawBody
                rawBody.replace(HTML_TAG_REGEX, "").decodeHtmlEntities()
                required = false,
                required = true,
                type = "string",
                }
            "HTML responses are stripped of tags; large responses are truncated.",
            "Redirects are followed for GET/HEAD only. Private/loopback addresses are blocked. " +
            "Use this to read web pages, hit API endpoints, or act on links from emails (e.g. RFC 8058 " +
            "body" to ParameterSchema(
            "content_type" to ParameterSchema(
            "method" to ParameterSchema(
            "one-click unsubscribe: POST to the https list-unsubscribe URL with body `List-Unsubscribe=One-Click`). " +
            "url" to ParameterSchema(
            )
            ),
            ?: return mapOf("success" to false, "error" to "invalid URL")
            ?: return mapOf("success" to false, "error" to "url is required")
            connectTimeoutMillis = 10_000
            mapOf(
            mapOf("success" to false, "error" to "fetch failed: ${e.message}")
            requestTimeoutMillis = 15_000
            return mapOf("success" to false, "error" to "blocked host: ${parsed.host}")
            return mapOf("success" to false, "error" to "method must be one of $ALLOWED_METHODS")
            return mapOf("success" to false, "error" to "only http and https schemes are allowed")
            return when {
            val (a, b) = octets[0].toInt() to octets[1].toInt()
            val body = if (responseCt.startsWith("text/html", ignoreCase = true)) {
            val rawBody = if (methodArg == "HEAD") "" else response.bodyAsText()
            val response = client.request(urlArg) {
            val responseCt = response.headers["Content-Type"].orEmpty()
            }
            } else {
        ),
        description = "Fetch the contents of a URL and return the response body to the agent",
        description = "Fetch the contents of an https/http URL and return the status and response body. " +
        descriptionRes = Res.string.tool_fetch_url_description,
        id = "fetch_url",
        if (h == "::1" || h == "0:0:0:0:0:0:0:1") return true
        if (h == "localhost" || h.endsWith(".localhost")) return true
        if (h.isEmpty()) return true
        if (h.startsWith("fe80:") || h.startsWith("fc") || h.startsWith("fd")) return true
        if (isBlockedHost(parsed.host)) {
        if (methodArg !in ALLOWED_METHODS) {
        if (octets.size == 4 && octets.all { it.toIntOrNull() != null }) {
        if (scheme != "http" && scheme != "https") {
        install(HttpTimeout) {
        name = "Fetch URL",
        name = "fetch_url",
        nameRes = Res.string.tool_fetch_url_name,
        parameters = mapOf(
        return false
        return try {
        val bodyArg = args["body"]?.toString()
        val contentTypeArg = args["content_type"]?.toString()
        val h = host.lowercase().trim('[', ']')
        val methodArg = (args["method"]?.toString() ?: "GET").uppercase()
        val octets = h.split(".")
        val parsed = runCatching { Url(urlArg) }.getOrNull()
        val scheme = parsed.protocol.name.lowercase()
        val urlArg = args["url"]?.toString()
        }
        } catch (e: Exception) {
    )
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema = ToolSchema(
    private fun isBlockedHost(host: String): Boolean {
    private val client = httpClient {
    val toolInfo = ToolInfo(
    }
import com.inspiredandroid.kai.httpClient
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_fetch_url_description
import kai.composeapp.generated.resources.tool_fetch_url_name
object FetchUrlTool : Tool {
package com.inspiredandroid.kai.tools
private val ALLOWED_METHODS = setOf("GET", "POST", "HEAD")
private val HTML_TAG_REGEX = Regex("<[^>]*>")
}
