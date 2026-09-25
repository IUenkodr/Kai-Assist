
            Message(role = "assistant", content = JsonPrimitive("answer")),
            Message(role = "assistant", content = JsonPrimitive("done")),
            assistantWithCalls("checking", "call_1"),
            assistantWithCalls("let me check", "call_1"),
            assistantWithCalls("text", "call_1"),
            assistantWithCalls(null, "call_1"),
            assistantWithCalls(null, "call_1", "call_2"),
            toolResult("call_1"),
            toolResult("call_2"),
            toolResult("old_call"),
            toolResult(null),
            user("anything else?"),
            user("hi"),
            user("next question"),
        )
        // Legacy behavior: callers that don't supply a set get pairing checks only.
        // Repros Bug B: the user disabled `search` between turns, so the assistant's prior
        // Simulates a context-trim that cut into the middle of an earlier tool turn.
        // The assistant turn keeps its text but loses tool_calls; the tool response is dropped.
        // Tool_calls and the paired response are gone; assistant text survives.
        // call_1 went unanswered (the response carried no id), so the calls are stripped and the
        // text-less assistant turn is removed, leaving only the user message.
        // tool_call to it is orphan relative to the current request's tools array.
        assertEquals("assistant", result[1].role)
        assertEquals("call_1", result[2].tool_call_id)
        assertEquals("tool", result[2].role)
        assertEquals("user", result.first().role)
        assertEquals(2, result.size)
        assertEquals(3, result.size)
        assertEquals(4, result.size)
        assertEquals(JsonPrimitive("checking"), result[1].content)
        assertEquals(JsonPrimitive("let me check"), result[1].content)
        assertEquals(JsonPrimitive("text"), result[1].content)
        assertEquals(input, sanitizeToolMessages(input))
        assertEquals(listOf("call_1"), result[1].tool_calls?.map { it.id })
        assertEquals(listOf(user("hi")), result)
        assertNull(result[1].tool_calls)
        assertNull(result[1].tool_calls, "Unanswered tool_calls must be stripped")
        assertTrue(result.none { it.role == "tool" })
        content = JsonPrimitive("result"),
        content = content?.let { JsonPrimitive(it) },
        role = "assistant",
        role = "tool",
        tool_call_id = callId,
        tool_calls = ids.map { ToolCall(id = it, function = FunctionCall(name = "search", arguments = "{}")) },
        val input = listOf(
        val result = sanitizeToolMessages(input)
        val result = sanitizeToolMessages(input, declaredToolNames = emptySet())
        val result = sanitizeToolMessages(input, declaredToolNames = null)
        val result = sanitizeToolMessages(input, declaredToolNames = setOf("calculator"))
        val result = sanitizeToolMessages(input, declaredToolNames = setOf("search"))
    )
    @Test
    fun `assistant tool_calls with neither responses nor text is dropped entirely`() {
    fun `assistant tool_calls with no responses keeps text and drops the calls`() {
    fun `balanced sequence is left unchanged`() {
    fun `empty declaredToolNames strips every historic tool_call`() {
    fun `leading orphan tools from trimming are dropped while later turns survive`() {
    fun `null declaredToolNames preserves historic tool_calls regardless of name`() {
    fun `orphan tool message without preceding tool_calls is dropped`() {
    fun `partial responses keep only the answered calls`() {
    fun `tool response with null id is dropped as an orphan`() {
    fun `tool_call to a tool not in declaredToolNames is dropped along with its response`() {
    fun `tool_call whose name is in declaredToolNames is preserved`() {
    private fun assistantWithCalls(content: String?, vararg ids: String) = Message(
    private fun toolResult(callId: String?) = Message(
    private fun user(text: String) = Message(role = "user", content = JsonPrimitive(text))
    }
 * "An assistant message with 'tool_calls' must be followed by tool messages responding to each
 * 'tool_call_id'."
 * (DeepSeek via OpenCode Zen). A violation produces a 400:
 * Guards the tool-call pairing invariant required by strict OpenAI-compatible providers
 */
/**
class SanitizeToolMessagesTest {
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.FunctionCall
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.ToolCall
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.JsonPrimitive
package com.inspiredandroid.kai.data.providers
}
