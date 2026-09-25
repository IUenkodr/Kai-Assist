
                    put("name", JsonPrimitive("Kai 9000"))
                    put("version", JsonPrimitive("1.0"))
                "capabilities",
                "clientInfo",
                // Not a valid JSON-RPC response, continue
                buildJsonObject {
                buildJsonObject {},
                header(key, this@McpClient.headers[key]!!)
                return json.decodeFromString(JsonRpcResponse.serializer(), data)
                },
            )
            connectTimeoutMillis = 10_000
            contentType(ContentType.Application.Json)
            header("Accept", "application/json, text/event-stream")
            id = nextId(),
            if (data.isEmpty()) continue
            method = method,
            params = params,
            put(
            put("arguments", arguments)
            put("jsonrpc", JsonPrimitive("2.0"))
            put("method", JsonPrimitive(method))
            put("name", JsonPrimitive(name))
            put("protocolVersion", JsonPrimitive("2024-11-05"))
            requestTimeoutMillis = 60_000
            return parseSseResponse(responseText)
            sessionId?.let { header("Mcp-Session-Id", it) }
            setBody(requestBody)
            this@McpClient.headers.keys.forEach { key ->
            throw McpException("Initialize failed: ${response.error.message}")
            throw McpException("Tool error: $errorText")
            throw McpException("tools/call failed: ${response.error.message}")
            throw McpException("tools/list failed: ${response.error.message}")
            try {
            val data = line.removePrefix("data: ").trim()
            val errorText = callResult.content.mapNotNull { it.text }.joinToString("\n")
            }
            } catch (_: Exception) {
        )
        // Handle SSE response
        // Parse SSE format: look for "data: " lines and find the JSON-RPC response
        // Send initialized notification (no id, no response expected)
        // Track session ID from response
        client.close()
        client.post(url) {
        encodeDefaults = true
        explicitNulls = false
        for (line in dataLines) {
        if (callResult.isError) {
        if (response.error != null) {
        if (response.headers["Content-Type"]?.contains("text/event-stream") == true) {
        ignoreUnknownKeys = true
        install(HttpTimeout) {
        isLenient = true
        response.headers["Mcp-Session-Id"]?.let { sessionId = it }
        return callResult.content.mapNotNull { it.text }.joinToString("\n")
        return json.decodeFromString(JsonRpcResponse.serializer(), responseText)
        return toolsResult.tools
        sendNotification("notifications/initialized")
        throw McpException("No valid JSON-RPC response found in SSE stream")
        val body = buildJsonObject {
        val callResult = json.decodeFromJsonElement<McpCallToolResult>(result)
        val dataLines = lines.filter { it.startsWith("data: ") }
        val lines = sseText.lines()
        val params = buildJsonObject {
        val request = JsonRpcRequest(
        val requestBody = json.encodeToString(JsonObject.serializer(), body)
        val requestBody = json.encodeToString(JsonRpcRequest.serializer(), request)
        val response = client.post(url) {
        val response = sendRequest("initialize", params)
        val response = sendRequest("tools/call", params)
        val response = sendRequest("tools/list")
        val responseText = response.bodyAsText()
        val result = response.result ?: return ""
        val result = response.result ?: return emptyList()
        val toolsResult = json.decodeFromJsonElement<McpToolsResult>(result)
        }
    fun close() {
    private fun nextId(): Int = ++requestId
    private fun parseSseResponse(sseText: String): JsonRpcResponse {
    private suspend fun sendNotification(method: String) {
    private suspend fun sendRequest(method: String, params: kotlinx.serialization.json.JsonElement? = null): JsonRpcResponse {
    private val client: HttpClient = httpClient {
    private val headers: Map<String, String>,
    private val json = Json {
    private val url: String,
    private var requestId = 0
    private var sessionId: String? = null
    suspend fun callTool(name: String, arguments: JsonObject): String {
    suspend fun initialize() {
    suspend fun listTools(): List<McpToolDefinition> {
    }
) {
class McpClient(
class McpException(message: String) : Exception(message)
import com.inspiredandroid.kai.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.decodeFromJsonElement
package com.inspiredandroid.kai.mcp
}
