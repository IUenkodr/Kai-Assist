import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolSchema
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

                ParameterSchema(type = type, description = "", required = false)
            "command" to "string",
            "timeout" to "integer",
            "unparseable block should remain visible: ${extracted.cleanedText}",
            180
            </function>
            </parameter>
            </tool_call>
            <function=execute_shell_command>
            <parameter=command>
            <parameter=command>echo one</parameter>
            <parameter=command>echo two</parameter>
            <parameter=timeout>
            <tool_call>
            description = "",
            extracted.cleanedText.contains("<tool_call>"),
            mid
            name = name,
            parameters = parameters.mapValues { (_, type) ->
            ssh hk-server "echo hi"
            },
            下载链接中的空格需要 URL 编码。让我用正确格式重新下载:
        """.trimIndent()
        )
        ),
        // surrounding prose preserved, xml stripped
        // timeout coerced to a JSON number; command stays a string
        // without a schema we can't know the type, so it stays a string
        assertEquals("beforeafter", extracted.cleanedText)
        assertEquals("execute_shell_command", call.name)
        assertEquals("just a regular message", extracted.cleanedText)
        assertEquals("mid", extracted.cleanedText)
        assertEquals("下载链接中的空格需要 URL 编码。让我用正确格式重新下载:", extracted.cleanedText)
        assertEquals(1, extracted.calls.size)
        assertEquals(2, extracted.calls.size)
        assertTrue(
        assertTrue(call.arguments.contains("\"command\":\"ls\""))
        assertTrue(call.arguments.contains("\"command\":\"ssh hk-server \\\"echo hi\\\"\""), "command not preserved: ${call.arguments}")
        assertTrue(call.arguments.contains("\"timeout\":180"), "expected unquoted integer, got: ${call.arguments}")
        assertTrue(call.arguments.contains("\"timeout\":5"))
        assertTrue(extracted.calls.isEmpty())
        assertTrue(extracted.calls[0].arguments.contains("\"count\":\"42\""))
        name = "execute_shell_command",
        override suspend fun execute(args: Map<String, Any>): Any = ""
        override val schema = ToolSchema(
        parameters = mapOf(
        val call = extracted.calls[0]
        val extracted = extractInlineToolCalls("just a regular message", listOf(execShell))
        val extracted = extractInlineToolCalls(raw, listOf(execShell))
        val extracted = extractInlineToolCalls(raw, tools = emptyList())
        val raw = """
        val raw = """<tool_call><function=mystery_tool><parameter=count>42</parameter></function></tool_call>"""
        val raw = """before<tool_call>{"name":"execute_shell_command","arguments":{"command":"ls","timeout":5}}</tool_call>after"""
        val raw = "intro <tool_call>not xml and not json</tool_call> tail"
    )
    @Test
    fun `handles multiple inline tool calls in one message`() {
    fun `keeps unparseable block in cleaned text rather than dropping it`() {
    fun `parses hermes style xml block and coerces integer timeout`() {
    fun `parses json flavor with arguments field`() {
    fun `passes through text without any tool_call`() {
    fun `unknown tool falls back to string parameters`() {
    private fun stubTool(name: String, parameters: Map<String, String>): Tool = object : Tool {
    private val execShell = stubTool(
    }
class InlineToolCallParserTest {
package com.inspiredandroid.kai.network.dtos.openaicompatible
}
