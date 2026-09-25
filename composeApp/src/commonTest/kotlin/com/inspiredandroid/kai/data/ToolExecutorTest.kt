import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolSchema
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest

            FakeTool(timeout = 100.milliseconds) { delay(10.minutes) },
            completed = true
            executor.executeTool("fake_tool", "{}")
        )
        assertFailsWith<CancellationException> {
        assertTrue(!completed)
        assertTrue(job.isCancelled)
        assertTrue(result.contains("Tool execution failed"))
        assertTrue(result.contains("timed out"))
        job.cancel()
        job.join()
        name: String = "fake_tool",
        override suspend fun execute(args: Map<String, Any>): Any = block()
        override val schema = ToolSchema(name = name, description = "test tool", parameters = emptyMap())
        override val timeout: Duration = 30.minutes,
        private val block: suspend () -> Any,
        runCurrent()
        val executor = executorWith(
        val executor = executorWith(FakeTool { awaitCancellation() })
        val executor = executorWith(FakeTool { throw CancellationException("stop") })
        val executor = executorWith(FakeTool { throw IllegalStateException("boom") })
        val job = launch {
        val result = executor.executeTool("fake_tool", "{}")
        var completed = false
        }
    ) : Tool {
    @Test
    fun `executeTool is cooperatively cancellable while a tool is running`() = runTest {
    fun `executeTool propagates CancellationException instead of returning an error result`() = runTest {
    fun `executeTool reports a generic exception as an error result`() = runTest {
    fun `executeTool reports a timeout as an error result`() = runTest {
    private class FakeTool(
    private fun executorWith(tool: Tool) = ToolExecutor(toolsProvider = { listOf(tool) })
    }
 * Tests for the [ToolExecutor.executeTool] error and cancellation contract. Tool lookup is
 * injected via the `toolsProvider` constructor parameter, so no Koin container is needed.
 */
/**
class ToolExecutorTest {
package com.inspiredandroid.kai.data
}
