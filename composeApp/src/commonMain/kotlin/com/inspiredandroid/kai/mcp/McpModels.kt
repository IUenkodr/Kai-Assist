package com.inspiredandroid.kai.mcp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

    @SerialName("isError")
    val code: Int,
    val content: List<McpContent> = emptyList(),
    val data: JsonElement? = null,
    val description: String,
    val description: String? = null,
    val error: JsonRpcError? = null,
    val id: Int,
    val id: Int? = null,
    val inputSchema: JsonObject? = null,
    val inputSchema: JsonObject?,
    val isError: Boolean = false,
    val jsonrpc: String = "2.0",
    val message: String,
    val method: String,
    val name: String,
    val params: JsonElement? = null,
    val result: JsonElement? = null,
    val serverId: String,
    val text: String? = null,
    val tools: List<McpToolDefinition> = emptyList(),
    val type: String,
)
@Serializable
data class JsonRpcError(
data class JsonRpcRequest(
data class JsonRpcResponse(
data class McpCallToolResult(
data class McpContent(
data class McpToolDefinition(
data class McpToolMetadata(
data class McpToolsResult(
