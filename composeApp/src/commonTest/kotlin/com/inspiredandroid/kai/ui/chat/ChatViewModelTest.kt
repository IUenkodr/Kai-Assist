package com.inspiredandroid.kai.ui.chat
import app.cash.turbine.test
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.network.AnthropicInsufficientCreditsException
import com.inspiredandroid.kai.network.AnthropicInvalidApiKeyException
import com.inspiredandroid.kai.network.AnthropicOverloadedException
import com.inspiredandroid.kai.network.AnthropicRateLimitExceededException
import com.inspiredandroid.kai.network.GeminiInvalidApiKeyException
import com.inspiredandroid.kai.network.GeminiRateLimitExceededException
import com.inspiredandroid.kai.network.GenericNetworkException
import com.inspiredandroid.kai.network.OpenAICompatibleInvalidApiKeyException
import com.inspiredandroid.kai.network.OpenAICompatibleRateLimitExceededException
import com.inspiredandroid.kai.testutil.FakeDataRepository
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

                cleared = awaitItem()
                clearedState = awaitItem()
                errorState = awaitItem()
                finalState = awaitItem()
                loadingState = awaitItem()
                ready = awaitItem()
                shared = awaitItem()
                state = awaitItem()
            // Clear exception and ask again
            // Clear history
            // Content ID should be preserved when stopping
            // Error should be cleared when loading starts
            // First call - will fail
            // Restore hasn't run yet — initial state still has isRestoring=true.
            // Trigger an error first
            // Verify ask was called with null
            // Wait for completion
            // Wait for completion - collect all states until we get a non-loading state with history
            // Wait for error
            // Wait for history to be populated
            // Wait for loading state which should have cleared error
            History(role = History.Role.ASSISTANT, content = "reply"),
            History(role = History.Role.USER, content = "old"),
            assertEquals("Hello", finalState.history[0].content)
            assertEquals("content-123", notSpeakingState.isSpeakingContentId)
            assertEquals("content-123", speakingState.isSpeakingContentId)
            assertEquals(0, fakeRepository.askCalls.size)
            assertEquals(1, fakeRepository.clearHistoryCalls)
            assertEquals(1, fakeRepository.restoreCurrentConversationCalls)
            assertEquals(2, finalState.history.size)
            assertEquals(History.Role.ASSISTANT, finalState.history[1].role)
            assertEquals(History.Role.USER, finalState.history[0].role)
            assertFalse(awaitItem().isRestoring)
            assertFalse(disabledState.isSpeechOutputEnabled)
            assertFalse(errorState.isLoading)
            assertFalse(finalState.isLoading)
            assertFalse(initialState.isLoading)
            assertFalse(initialState.isSpeaking)
            assertFalse(initialState.isSpeechOutputEnabled)
            assertFalse(notSpeakingState.isSpeaking)
            assertFalse(state.isInteractiveMode)
            assertNotNull(errorState.error)
            assertNull(cleared.composerPrefill)
            assertNull(clearedState.error)
            assertNull(fakeRepository.pendingShareText.value)
            assertNull(loadingState.error)
            assertTrue(awaitItem().isRestoring)
            assertTrue(clearedState.history.isEmpty())
            assertTrue(enabledState.isSpeechOutputEnabled)
            assertTrue(fakeRepository.askCalls.any { it.first == null })
            assertTrue(finalState.history.isNotEmpty())
            assertTrue(initialState.history.isEmpty())
            assertTrue(shared.history.isEmpty())
            assertTrue(speakingState.isSpeaking)
            assertTrue(state.history.isEmpty())
            assertTrue(state.showPrivacyInfo)
            assertTrue(state.supportedFileExtensions.isEmpty())
            assertTrue(state.supportedFileExtensions.isNotEmpty())
            backgroundDispatcher.scheduler.advanceUntilIdle()
            cancelAndIgnoreRemainingEvents()
            do {
            enabledState.actions.toggleSpeechOutput()
            errorState.actions.ask("Second")
            errorState.actions.clearHistory()
            fakeRepository.askException = null
            fakeRepository.requestOpenShare("Translate this")
            initialState.actions.ask("First")
            initialState.actions.ask("Hello")
            initialState.actions.retry()
            initialState.actions.setIsSpeaking(true, "content-123")
            initialState.actions.toggleSpeechOutput()
            skipItems(1)
            speakingState.actions.setIsSpeaking(false, "")
            state.actions.consumeComposerPrefill()
            testDispatcher.scheduler.advanceUntilIdle()
            val disabledState = awaitItem()
            val enabledState = awaitItem()
            val initialState = awaitItem()
            val notSpeakingState = awaitItem()
            val speakingState = awaitItem()
            val state = awaitItem()
            var cleared: ChatUiState
            var clearedState: ChatUiState
            var errorState: ChatUiState
            var finalState: ChatUiState
            var loadingState: ChatUiState
            var ready: ChatUiState
            var shared: ChatUiState
            var state: ChatUiState
            } while (!loadingState.isLoading && loadingState.error != null)
            } while (cleared.composerPrefill != null)
            } while (clearedState.error != null || clearedState.history.isNotEmpty())
            } while (errorState.error == null)
            } while (finalState.history.isEmpty() || finalState.isLoading)
            } while (finalState.isLoading || finalState.history.isEmpty())
            } while (finalState.isLoading)
            } while (ready.isRestoring || ready.history.size < 2)
            } while (shared.composerPrefill != "Translate this")
            } while (state.composerPrefill != "Summarize this article")
        )
        // Isolated paused dispatcher so the launched restore coroutine doesn't run synchronously.
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        assertEquals(0, fakeRepository.restoreCurrentConversationCalls)
        assertEquals(1, fakeRepository.restoreCurrentConversationCalls)
        createViewModel()
        fakeRepository = FakeDataRepository()
        fakeRepository.askException = AnthropicInsufficientCreditsException()
        fakeRepository.askException = AnthropicInvalidApiKeyException()
        fakeRepository.askException = AnthropicOverloadedException()
        fakeRepository.askException = AnthropicRateLimitExceededException()
        fakeRepository.askException = GeminiInvalidApiKeyException()
        fakeRepository.askException = GeminiRateLimitExceededException()
        fakeRepository.askException = GenericNetworkException("Error")
        fakeRepository.askException = GenericNetworkException("First error")
        fakeRepository.askException = OpenAICompatibleInvalidApiKeyException()
        fakeRepository.askException = OpenAICompatibleRateLimitExceededException()
        fakeRepository.chatHistory.value = listOf(
        fakeRepository.fileAttachmentSupported = false
        fakeRepository.fileAttachmentSupported = true
        fakeRepository.requestOpenShare("Summarize this article")
        fakeRepository.requestOpenShare("shared article")
        fakeRepository.setCurrentService(Service.Free)
        return ChatViewModel(fakeRepository, noOpScheduler, unconfinedDispatcher)
        testDispatcher.scheduler.advanceUntilIdle()
        val backgroundDispatcher = StandardTestDispatcher()
        val noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        val viewModel = ChatViewModel(fakeRepository, noOpScheduler, backgroundDispatcher)
        val viewModel = createViewModel()
        viewModel.state.test {
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `allowFileAttachment is false when repository does not support it`() = runTest {
    fun `allowFileAttachment is true when repository supports it`() = runTest {
    fun `ask clears previous error`() = runTest {
    fun `ask completes successfully and updates history`() = runTest {
    fun `clearHistory clears history and error`() = runTest {
    fun `failed ask with AnthropicInsufficientCreditsException sets error`() = runTest {
    fun `failed ask with AnthropicInvalidApiKeyException sets error`() = runTest {
    fun `failed ask with AnthropicOverloadedException sets error`() = runTest {
    fun `failed ask with AnthropicRateLimitExceededException sets error`() = runTest {
    fun `failed ask with GeminiInvalidApiKeyException sets error`() = runTest {
    fun `failed ask with GeminiRateLimitExceededException sets error`() = runTest {
    fun `failed ask with GroqInvalidApiKeyException sets error`() = runTest {
    fun `failed ask with GroqRateLimitExceededException sets error`() = runTest {
    fun `initial state reflects isUsingSharedKey from repository`() = runTest {
    fun `pending share skips restoring the last conversation`() = runTest {
    fun `restore runs off the main thread and flips isRestoring`() = runTest {
    fun `restore still runs when nothing is shared`() = runTest {
    fun `retry calls ask with null`() = runTest {
    fun `setIsSpeaking updates speaking state`() = runTest {
    fun `share while already running starts a new chat and prefills`() = runTest {
    fun `shared text starts a new chat and prefills the composer without sending`() = runTest {
    fun `successful ask adds messages to history`() = runTest {
    fun `toggleSpeechOutput toggles isSpeechOutputEnabled`() = runTest {
    fun setup() {
    fun tearDown() {
    private fun createViewModel(): ChatViewModel {
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    private val unconfinedDispatcher = UnconfinedTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class ChatViewModelTest {
}
