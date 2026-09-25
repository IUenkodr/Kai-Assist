import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.chat.ToolCallInfo
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.collections.immutable.persistentListOf

                    .mapNotNull { it.tool_call_id }
                    .takeWhile { it.role == "tool" }
                    .toSet()
                    ToolCallInfo(id = "call_img", name = "generate_image", arguments = """{"prompt":"cat"}"""),
                    prev?.role == "tool"
                ),
                assertTrue(precededByCalls, "orphan tool message at index $i")
                assertTrue(unanswered.isEmpty(), "tool_call_ids without a response: $unanswered")
                content = "",
                content = "Sure, generating that now.",
                reasoningContent = "the user wants an image",
                role = History.Role.ASSISTANT,
                toolCalls = persistentListOf(
                val precededByCalls = (prev?.role == "assistant" && !prev.tool_calls.isNullOrEmpty()) ||
                val prev = messages.getOrNull(i - 1)
                val responded = messages.drop(i + 1)
                val unanswered = msg.tool_calls.map { it.id }.filter { it !in responded }
            ),
            // <-- tool result row is missing here
            History(
            History(role = History.Role.ASSISTANT, content = "Done, pushed to your device."),
            History(role = History.Role.TOOL, content = "saved to /img.png", toolCallId = "call_img", toolName = "generate_image"),
            History(role = History.Role.USER, content = "make me an image"),
            History(role = History.Role.USER, content = "try to make tool_calls"),
            if (msg.role == "assistant" && !msg.tool_calls.isNullOrEmpty()) {
            if (msg.role == "tool") {
            }
        )
        // History as it would be left after OpenCode produced tool calls but the loop never
        // The dangling tool_calls are stripped; the assistant text survives.
        // another message.
        // appended the results (e.g. it failed over to OpenRouter mid-turn), then the user sends
        assertEquals(1, messages.count { it.role == "tool" })
        assertEquals(listOf("call_img"), toolCallTurn.tool_calls?.map { it.id })
        assertEquals(null, assistant.tool_calls)
        assertNoDanglingToolCalls(messages)
        assertTrue(messages.last().role == "user")
        for ((i, msg) in messages.withIndex()) {
        val assistant = messages.single { it.role == "assistant" }
        val history = listOf(
        val messages = buildOpenAIMessages(Service.OpenCode, history, systemPrompt = "be helpful", modelId = "test-model")
        val messages = buildOpenAIMessages(Service.OpenCode, history, systemPrompt = null, modelId = "test-model")
        val toolCallTurn = messages.single { it.role == "assistant" && !it.tool_calls.isNullOrEmpty() }
        }
    @Test
    fun `a complete tool turn is preserved intact`() {
    fun `orphaned assistant tool-call turn from a prior interrupted run is repaired`() {
    private fun assertNoDanglingToolCalls(messages: List<com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message>) {
    }
 *
 * "An assistant message with 'tool_calls' must be followed by tool messages responding to each
 * 'tool_call_id'."
 * End-to-end guard for the OpenCode/DeepSeek tool-call crash:
 * Reproduces the reported scenario where an earlier tool turn was interrupted (a cancel, an app
 * kill, or a provider failing over to a fallback service mid-loop) and left an assistant tool-call
 * row in history with no tool responses behind it. The next request must not resend that orphan.
 */
/**
class BuildOpenAIMessagesPairingTest {
package com.inspiredandroid.kai.data.providers
}
