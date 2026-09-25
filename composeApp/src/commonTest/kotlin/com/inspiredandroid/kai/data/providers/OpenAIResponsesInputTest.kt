package com.inspiredandroid.kai.data.providers
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.requiresResponsesApi
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

                            function = OpenAICompatibleChatRequestDto.FunctionCall(name = "get_local_time", arguments = """{"tz":"UTC"}"""),
                            function = OpenAICompatibleChatRequestDto.FunctionCall(name = "get_local_time", arguments = "{}"),
                            id = "call_1",
                        "image_url",
                        ),
                        OpenAICompatibleChatRequestDto.ToolCall(
                        buildJsonObject { put("url", "data:image/png;base64,AAA") },
                    )
                    ),
                    content = JsonPrimitive("checking the clock"),
                    content = null,
                    put(
                    put("text", "what is this")
                    put("type", "image_url")
                    put("type", "text")
                    role = "assistant",
                    tool_calls = listOf(
                ),
                OpenAICompatibleChatRequestDto.Message(
                OpenAICompatibleChatRequestDto.Message(role = "assistant", content = JsonPrimitive("hello")),
                OpenAICompatibleChatRequestDto.Message(role = "system", content = JsonPrimitive("be brief")),
                OpenAICompatibleChatRequestDto.Message(role = "tool", content = JsonPrimitive("12:00"), tool_call_id = "call_1"),
                OpenAICompatibleChatRequestDto.Message(role = "user", content = JsonPrimitive("hi")),
                buildJsonObject {
                },
            ),
            listOf(
        )
        // Aggregators translate to the Responses API themselves and only accept chat completions.
        // Flat string, not the nested {url} object chat completions uses.
        // No `id` field: replaying the provider's item id without its reasoning item is a 400.
        // Older OpenAI families keep working on chat completions.
        // The OpenAI-Compatible service only qualifies when pointed at OpenAI.
        assertEquals("""{"tz":"UTC"}""", call.str("arguments"))
        assertEquals("", input[0].str("content"))
        assertEquals("12:00", output.str("output"))
        assertEquals("assistant", input[0].str("role"))
        assertEquals("call_1", call.str("call_id"))
        assertEquals("call_1", output.str("call_id"))
        assertEquals("checking the clock", input[0].str("content"))
        assertEquals("data:image/png;base64,AAA", image["image_url"]?.jsonPrimitive?.content)
        assertEquals("function_call", call.str("type"))
        assertEquals("function_call", input[1].str("type"))
        assertEquals("function_call_output", output.str("type"))
        assertEquals("get_local_time", call.str("name"))
        assertEquals("input_image", image.str("type"))
        assertEquals("input_text", (parts[0] as JsonObject).str("type"))
        assertEquals("what is this", (parts[0] as JsonObject).str("text"))
        assertEquals(1, input.size)
        assertEquals(2, input.size)
        assertEquals(3, input.size)
        assertEquals(listOf("be brief", "hi", "hello"), input.map { it.str("content") })
        assertEquals(listOf("system", "user", "assistant"), input.map { it.str("role") })
        assertFalse(requiresResponsesApi(Service.OpenAI, "gpt-4o"))
        assertFalse(requiresResponsesApi(Service.OpenAI, "gpt-5.5"))
        assertFalse(requiresResponsesApi(Service.OpenAICompatible, "gpt-5.6-luna", "http://localhost:11434/v1"))
        assertFalse(requiresResponsesApi(Service.OpenRouter, "openai/gpt-5.6-luna"))
        assertNull(call["id"])
        assertTrue(input.none { it.containsKey("type") }, "easy messages must not carry a type tag")
        assertTrue(requiresResponsesApi(Service.OpenAI, "GPT-5.6-Terra"))
        assertTrue(requiresResponsesApi(Service.OpenAI, "gpt-5.6"))
        assertTrue(requiresResponsesApi(Service.OpenAI, "gpt-5.6-luna"))
        assertTrue(requiresResponsesApi(Service.OpenAI, "gpt-5.6-luna-xhigh"))
        assertTrue(requiresResponsesApi(Service.OpenAICompatible, "gpt-5.6-luna", "https://api.openai.com/v1"))
        val call = input[0]
        val chatParts = JsonArray(
        val image = parts[1] as JsonObject
        val input = toResponsesInput(
        val input = toResponsesInput(listOf(OpenAICompatibleChatRequestDto.Message(role = "assistant", content = null)))
        val input = toResponsesInput(listOf(OpenAICompatibleChatRequestDto.Message(role = "user", content = chatParts)))
        val output = input[1]
        val parts = input[0]["content"] as JsonArray
    @Test
    fun `assistant text alongside tool calls is emitted before the calls`() {
    fun `assistant tool calls become function_call items keyed by call_id`() {
    fun `missing content serializes as empty text rather than null`() {
    fun `only openai endpoints route the gpt-5_6 family to the responses api`() {
    fun `system and plain messages become easy input messages`() {
    fun `user content parts are retagged for the responses api`() {
    private fun JsonObject.str(key: String): String? = (this[key] as? JsonPrimitive)?.content
    }
 * (issue #469). A wrong shape here is a hard 400 from OpenAI, not a degraded answer.
 * Guards the chat-completions → Responses API translation that lets the GPT-5.6 family use tools
 */
/**
class OpenAIResponsesInputTest {
}
