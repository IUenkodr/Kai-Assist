package com.inspiredandroid.kai.mcp
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

                    "Authorization": "Bearer token123",
                    "X-API-Version": "2"
                "another": 42
                "futureField": "ignored",
                "headers": {
                "id": "abc",
                "isEnabled": true
                "name": "Server"
                "name": "Server",
                "url": "https://example.com"
                "url": "https://example.com",
                },
            headers = mapOf("Authorization" to "Bearer xyz", "X-Custom" to "value"),
            headers = mapOf("h" to "v"),
            id = "id1",
            id = "test_server",
            isEnabled = false,
            isEnabled = true,
            json.decodeFromString(McpServerConfig.serializer(), jsonString)
            name = "Name 1",
            name = "Test Server",
            url = "https://example.com/mcp",
            url = "https://x.example",
            {
            }
        """.trimIndent()
        )
        // Missing 'url' (required)
        assertEquals("2", decoded.headers["X-API-Version"])
        assertEquals("Bearer token123", decoded.headers["Authorization"])
        assertEquals("Server", decoded.name)
        assertEquals("abc", decoded.id)
        assertEquals(2, decoded.headers.size)
        assertEquals(a, b)
        assertEquals(original, decoded)
        assertEquals(true, decoded.isEnabled)
        assertFailsWith<SerializationException> {
        assertTrue(a != c)
        assertTrue(decoded.headers.isEmpty())
        assertTrue(encoded.contains("\"headers\""))
        assertTrue(encoded.contains("\"id\""))
        assertTrue(encoded.contains("\"isEnabled\""))
        assertTrue(encoded.contains("\"name\""))
        assertTrue(encoded.contains("\"url\""))
        encodeDefaults = true
        ignoreUnknownKeys = true
        val a = McpServerConfig(id = "x", name = "X", url = "u")
        val b = McpServerConfig(id = "x", name = "X", url = "u")
        val c = a.copy(isEnabled = false)
        val config = McpServerConfig(
        val decoded = json.decodeFromString(McpServerConfig.serializer(), encoded)
        val decoded = json.decodeFromString(McpServerConfig.serializer(), jsonString)
        val encoded = json.encodeToString(McpServerConfig.serializer(), config)
        val encoded = json.encodeToString(McpServerConfig.serializer(), original)
        val jsonString = """
        val original = McpServerConfig(
        }
    @Test
    fun `decodes headers map correctly`() {
    fun `decoding fails when required field is missing`() {
    fun `encoded JSON contains all fields`() {
    fun `equality is structural`() {
    fun `headers default to empty map when absent`() {
    fun `isEnabled defaults to true when absent in JSON`() {
    fun `round trip preserves all fields`() {
    fun `unknown fields are ignored when ignoreUnknownKeys is true`() {
    private val json = Json {
    }
class McpServerConfigTest {
}
