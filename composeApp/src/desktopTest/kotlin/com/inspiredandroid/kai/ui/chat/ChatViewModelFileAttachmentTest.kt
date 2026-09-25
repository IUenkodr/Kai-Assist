import app.cash.turbine.test
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.testutil.FakeDataRepository
import io.github.vinceglb.filekit.PlatformFile
import java.io.File
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                    break
                    filesCleared = true
                if (next.files.isEmpty()) {
                val next = awaitItem()
                }
            "a-really-long-name-without-ext",
            "a-really-long-screenshot-name.png",
            // drain states until files is empty (ask clears them on dispatch)
            assertEquals(1, fakeRepository.askCalls.size)
            assertEquals(1, state.files.size)
            assertEquals(listOf(first), afterFirst.files.toList())
            assertEquals(listOf(first, second), afterSecond.files.toList())
            assertEquals(listOf(pngFile), fakeRepository.askCalls.first().second.toList())
            assertEquals(listOf(second), state.files.toList())
            assertEquals(pngFile, state.files.first())
            assertNotNull(state.snackbarMessage)
            assertNull(state.snackbarMessage)
            assertTrue(filesCleared)
            assertTrue(state.files.isEmpty())
            awaitItem()
            maxChars = 10,
            maxChars = 16,
            skipItems(1)
            val afterFirst = awaitItem()
            val afterSecond = awaitItem()
            val state = awaitItem()
            var filesCleared = false
            viewModel.state.value.actions.addFile(first)
            viewModel.state.value.actions.addFile(pngFile)
            viewModel.state.value.actions.addFile(second)
            viewModel.state.value.actions.addFile(unsupportedFile)
            viewModel.state.value.actions.ask("describe this")
            viewModel.state.value.actions.removeFile(first)
            while (true) {
            }
        )
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        assertEquals("cat.png", com.inspiredandroid.kai.ui.chat.composables.truncateFileName("cat.png"))
        assertEquals(10, result.length)
        assertFalse(result == "a-really-long-screenshot-name.png")
        assertTrue(result.contains("…"), "ellipsis must be present, got: $result")
        assertTrue(result.endsWith(".png"), "extension must be preserved, got: $result")
        assertTrue(result.endsWith("…"))
        assertTrue(result.length <= 16, "result must respect maxChars, got ${result.length}: $result")
        fakeRepository = FakeDataRepository()
        fakeRepository.fileAttachmentSupported = true
        file.deleteOnExit()
        return ChatViewModel(fakeRepository, noOpScheduler, unconfinedDispatcher)
        return PlatformFile(file)
        val file = File.createTempFile("kai-test-", ".$extension")
        val first = tempPlatformFile("png")
        val noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        val pngFile = tempPlatformFile("png")
        val result = com.inspiredandroid.kai.ui.chat.composables.truncateFileName(
        val second = tempPlatformFile("txt")
        val unsupportedFile = tempPlatformFile("xyz")
        val viewModel = createViewModel()
        viewModel.state.test {
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `addFile appends multiple files so all are queued for the next prompt`() = runTest {
    fun `addFile stores file when extension is supported`() = runTest {
    fun `addFile surfaces snackbar when extension is not supported`() = runTest {
    fun `ask clears the queued files after submitting`() = runTest {
    fun `removeFile removes the specified file and keeps the rest`() = runTest {
    fun `truncateFileName handles names without extension`() {
    fun `truncateFileName returns short names unchanged`() {
    fun `truncateFileName shortens long names and keeps extension`() {
    fun setup() {
    fun tearDown() {
    private fun createViewModel(): ChatViewModel {
    private fun tempPlatformFile(extension: String): PlatformFile {
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    private val unconfinedDispatcher = UnconfinedTestDispatcher()
    }
 * Regression tests for [ChatViewModel.addFile] / [ChatViewModel.removeFile]. These live in
 * desktopTest instead of commonTest because constructing a [PlatformFile] requires a
 * platform-specific constructor (JVM wraps a real [java.io.File]).
 */
/**
@OptIn(ExperimentalCoroutinesApi::class)
class ChatViewModelFileAttachmentTest {
package com.inspiredandroid.kai.ui.chat
}
