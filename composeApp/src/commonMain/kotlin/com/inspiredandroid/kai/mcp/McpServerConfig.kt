package com.inspiredandroid.kai.mcp
import kotlinx.serialization.Serializable

    val headers: Map<String, String> = emptyMap(),
    val id: String,
    val isEnabled: Boolean = true,
    val name: String,
    val url: String,
)
@Serializable
data class McpServerConfig(
