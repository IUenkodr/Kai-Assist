
                 "content": [{"type": "output_text", "text": "42", "annotations": []}]}
                 "content": [{"type": "output_text", "text": "a"}, {"type": "output_text", "text": "b"}]},
                 "encrypted_content": "gAAAA"},
                 "name": "get_local_time", "arguments": "{}", "status": "completed"}
                 "summary": [{"type": "summary_text", "text": "Need the clock."}],
                {"id": "fc_1", "type": "function_call", "call_id": "call_abc",
                {"id": "msg_1", "type": "message", "role": "assistant",
                {"id": "rs_1", "type": "reasoning",
                {"id": "rs_1", "type": "reasoning", "summary": []},
                {"type": "function_call", "call_id": "call_1", "name": "x", "arguments": "{}"},
                {"type": "function_call", "call_id": "call_2", "name": "y", "arguments": "{}"}
                {"type": "message", "role": "assistant",
              "id": "resp_1",
              "output": [
              "status": "completed",
              ]
            """
            """.trimIndent(),
            {
            {"status": "failed", "output": [], "error": {"code": "server_error", "message": "upstream failure"}}
            }
        )
        assertEquals("42", dto.outputText)
        assertEquals("Need the clock.", dto.reasoningSummary)
        assertEquals("ab", dto.outputText)
        assertEquals("call_abc", dto.functionCalls[0].callId)
        assertEquals("get_local_time", dto.functionCalls[0].name)
        assertEquals("upstream failure", dto.error?.message)
        assertEquals("{}", dto.functionCalls[0].arguments)
        assertEquals(1, dto.functionCalls.size)
        assertEquals(listOf("call_1", "call_2"), dto.functionCalls.map { it.callId })
        assertNull(dto.outputText)
        assertNull(dto.reasoningSummary)
        assertTrue(dto.functionCalls.isEmpty())
        val dto = parse(
    @Test
    fun `concatenates parallel tool calls and multi-part text`() {
    fun `reads answer text out of the message item`() {
    fun `reads tool calls and reasoning summaries from a tool turn`() {
    fun `surfaces a failed response instead of parsing it as empty`() {
    private fun parse(body: String) = json.decodeFromString(OpenAIResponsesResponseDto.serializer(), body)
    private val json = Json { ignoreUnknownKeys = true }
    }
/** Parsing guard for the `/v1/responses` output array (issue #469). */
class OpenAIResponsesResponseDtoTest {
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.Json
package com.inspiredandroid.kai.network.dtos.openairesponses
}
