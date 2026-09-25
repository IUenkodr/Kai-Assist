
            ToolCallInfo(id = "call_1", name = "search", arguments = """{"q":"hi"}"""),
            content = "hello",
            reasoningContent = "thinking…",
            role = History.Role.ASSISTANT,
        )
        ),
        assertEquals("assistant", dto.role)
        assertEquals("let me think about this", dto.reasoningContent)
        assertEquals(1, dto.tool_calls?.size)
        assertNull(dto.reasoningContent)
        assertNull(dto.reasoningContent, "Groq/Cerebras reject this field — must not be emitted")
        assertNull(plain.toGroqMessageDto(ReasoningRequestMode.NONE).reasoningContent)
        assertNull(plain.toGroqMessageDto(ReasoningRequestMode.REASONING_CONTENT).reasoningContent)
        content = "",
        isThinking = true,
        reasoningContent = "let me think about this",
        role = History.Role.ASSISTANT,
        toolCalls = persistentListOf(
        val dto = assistantWithToolCallAndReasoning().toGroqMessageDto()
        val dto = assistantWithToolCallAndReasoning().toGroqMessageDto(ReasoningRequestMode.NONE)
        val dto = assistantWithToolCallAndReasoning().toGroqMessageDto(ReasoningRequestMode.REASONING_CONTENT)
        val plain = History(
    )
    @Test
    fun `NONE mode strips reasoning_content from assistant tool-call message`() {
    fun `REASONING_CONTENT mode preserves reasoning_content on assistant tool-call message`() {
    fun `default mode is NONE`() {
    fun `non-tool-call assistant messages never carry reasoning_content regardless of mode`() {
    private fun assistantWithToolCallAndReasoning() = History(
    }
 *
 * Groq and Cerebras return HTTP 400 when this field is included; providers like DeepSeek
 * Guards the per-service gating of `reasoning_content` on outgoing assistant messages.
 * require it for multi-turn tool calling with reasoning models.
 * thinking-mode, Fireworks, LongCat, MiniMax, Moonshot, Venice, Z.AI and OpenCode Zen
 */
/**
class ToGroqMessageDtoReasoningTest {
import com.inspiredandroid.kai.data.ReasoningRequestMode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlinx.collections.immutable.persistentListOf
package com.inspiredandroid.kai.ui.chat
}
