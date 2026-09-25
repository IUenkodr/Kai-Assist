package com.inspiredandroid.kai.network.dtos.openairesponses
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

                            properties = mapOf("tz" to OpenAICompatibleChatRequestDto.PropertySchema(type = "string")),
                            required = listOf("tz"),
                        ),
                        description = "Current time",
                        name = "get_local_time",
                        parameters = OpenAICompatibleChatRequestDto.Parameters(
                        put("content", "hi")
                        put("role", "user")
                    ),
                    OpenAIResponsesRequestDto.Tool(
                    buildJsonObject {
                    },
                ),
                input = listOf(
                model = "gpt-5.6-luna",
                tools = listOf(
            ),
            OpenAIResponsesRequestDto(
        )
        // Function tools are tagged inline, not wrapped in a `function` object as on chat completions.
        // Nothing is retained server-side.
        // Strict mode would reject Kai's optional tool parameters, so it must be opted out of.
        assertEquals("function", tool["type"]?.jsonPrimitive?.content)
        assertEquals("get_local_time", tool["name"]?.jsonPrimitive?.content)
        assertEquals("gpt-5.6-luna", body["model"]?.jsonPrimitive?.content)
        assertEquals("object", parameters["type"]?.jsonPrimitive?.content)
        assertEquals(0, (body["input"] as JsonArray).size)
        assertEquals(false, body["store"]?.jsonPrimitive?.content?.toBoolean())
        assertEquals(false, tool["strict"]?.jsonPrimitive?.content?.toBoolean())
        assertNull(body["tools"])
        assertNull(tool["function"])
        assertTrue((parameters["properties"] as JsonObject).containsKey("tz"))
        encodeDefaults = true
        explicitNulls = false
        json.encodeToString(OpenAIResponsesRequestDto.serializer(), dto),
        val body = encode(
        val body = encode(OpenAIResponsesRequestDto(input = emptyList(), model = "gpt-5.6-luna", tools = null))
        val parameters = tool["parameters"] as JsonObject
        val tool = (body["tools"] as JsonArray).single() as JsonObject
    ) as JsonObject
    @Test
    fun `omits tools entirely when none are declared`() {
    fun `serializes a tool request the responses api accepts`() {
    private fun encode(dto: OpenAIResponsesRequestDto): JsonObject = json.parseToJsonElement(
    private val json = Json {
    }
 * Locks the wire shape of `/v1/responses` requests, using the same serializer settings the HTTP
 * `false` instead of dropping them.
 * client installs. `store` and `strict` carry meaning only because `encodeDefaults` emits them as
 */
/**
class OpenAIResponsesRequestDtoTest {
}
