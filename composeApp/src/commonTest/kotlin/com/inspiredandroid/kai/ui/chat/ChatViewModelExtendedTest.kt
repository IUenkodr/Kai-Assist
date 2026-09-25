import app.cash.turbine.test
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.testutil.FakeDataRepository
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                cancelledState = awaitItem()
                clearedState = awaitItem()
                exitedState = awaitItem()
                initialState = awaitItem()
                interactiveState = awaitItem()
                loadingState = awaitItem()
                makeServiceEntry("anthropic", Service.Anthropic),
                makeServiceEntry("gemini", Service.Gemini),
                makeServiceEntry("openai", Service.OpenAI),
                stateWithHistory = awaitItem()
            )
            // Calling clearSnackbar when there's nothing to clear should be safe
            // First ask is now suspended at the gate, isLoading should be true
            // No new ask call recorded
            // Order should be unchanged
            // Release gate so the cancelled coroutine can finish unwinding
            // Release the gate so the first ask completes
            // Repository should have been told to reorder
            // Repository.regenerate must have been called
            // Second ask should be ignored entirely while loading
            // The fake's reorderConfiguredServices changes configuredInstances, but
            // Update fakeServiceEntries to reflect the reorder happens via getServiceEntries
            // Wait for initial state to surface
            // Wait for initial state to surface the pre-populated history
            // ask was invoked again with a null question (retry semantics)
            // fakeServiceEntries is independent — update it after reorder happens.
            History(role = History.Role.ASSISTANT, content = "Hello"),
            History(role = History.Role.ASSISTANT, content = "Old answer"),
            History(role = History.Role.USER, content = "First"),
            History(role = History.Role.USER, content = "Hi"),
            assertEquals("gemini", configured[0].instanceId)
            assertEquals("gemini", initialState.availableServices.first().instanceId)
            assertEquals("openai", configured.first().instanceId)
            assertEquals("openai", configured[1].instanceId)
            assertEquals("openai", reordered.availableServices.first().instanceId)
            assertEquals(1, fakeRepository.askCalls.size)
            assertEquals(1, fakeRepository.regenerateCalls)
            assertEquals(2, stateWithHistory.history.size)
            assertFalse(cancelledState.isLoading)
            assertFalse(clearedState.isInteractiveMode)
            assertFalse(clearedState.isLoading)
            assertFalse(exitedState.isInteractiveMode)
            assertFalse(exitedState.isLoading)
            assertFalse(fakeRepository.isInteractiveModeActive())
            assertFalse(initialState.isInteractiveMode)
            assertFalse(state.showPrivacyInfo)
            assertNull(clearedState.error)
            assertNull(exitedState.error)
            assertNull(initialState.snackbarMessage)
            assertNull(interactiveState.error)
            assertTrue(clearedState.history.isEmpty())
            assertTrue(fakeRepository.askCalls.any { it.first == null })
            assertTrue(fakeRepository.isInteractiveModeActive())
            assertTrue(interactiveState.isInteractiveMode)
            assertTrue(loadingState.isLoading)
            assertTrue(state.files.isEmpty())
            cancelAndIgnoreRemainingEvents()
            do {
            fakeRepository.askGate = null
            fakeRepository.fakeServiceEntries = listOf(
            gate.complete(Unit)
            initial.actions.enterInteractiveMode()
            initialState.actions.ask("first")
            initialState.actions.ask("hello")
            initialState.actions.clearSnackbar()
            initialState.actions.enterInteractiveMode()
            initialState.actions.regenerate()
            initialState.actions.selectService("nonexistent_id")
            initialState.actions.selectService("openai")
            interactiveState.actions.exitInteractiveMode()
            loadingState.actions.ask("second")
            loadingState.actions.cancel()
            makeServiceEntry("anthropic", Service.Anthropic),
            makeServiceEntry("gemini", Service.Gemini),
            makeServiceEntry("openai", Service.OpenAI),
            skipItems(1)
            stateWithHistory.actions.startNewChat()
            testDispatcher.scheduler.advanceUntilIdle()
            val configured = fakeRepository.getConfiguredServiceInstances()
            val initial = awaitItem()
            val initialState = awaitItem()
            val reordered = awaitItem()
            val state = awaitItem()
            var cancelledState: ChatUiState
            var clearedState: ChatUiState
            var exitedState: ChatUiState
            var initialState: ChatUiState
            var interactiveState: ChatUiState
            var loadingState: ChatUiState
            var stateWithHistory: ChatUiState
            } while (!interactiveState.isInteractiveMode)
            } while (!loadingState.isLoading)
            } while (cancelledState.isLoading)
            } while (clearedState.history.isNotEmpty())
            } while (exitedState.isInteractiveMode)
            } while (initialState.history.size < 2)
            } while (stateWithHistory.history.isEmpty())
        )
        // Gate the first ask so it stays in flight
        // Pre-populate some history
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeDataRepository()
        fakeRepository.askGate = gate
        fakeRepository.chatHistory.value = listOf(
        fakeRepository.fakeServiceEntries = listOf(
        fakeRepository.setConfiguredServices(Service.Gemini, Service.OpenAI)
        fakeRepository.setConfiguredServices(Service.Gemini, Service.OpenAI, Service.Anthropic)
        fakeRepository.setCurrentService(Service.Gemini)
        icon = service.icon,
        instanceId = instanceId,
        modelId = "test-model",
        return ChatViewModel(fakeRepository, noOpScheduler, unconfinedDispatcher)
        serviceId = service.id,
        serviceName = service.displayName,
        val gate = CompletableDeferred<Unit>()
        val noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        val viewModel = createViewModel()
        viewModel.state.test {
        }
    )
    // ---- Concurrent ask prevention ----
    // ---- cancel ----
    // ---- clearSnackbar ----
    // ---- enter / exit interactive mode ----
    // ---- files ----
    // ---- regenerate ----
    // ---- selectService ----
    // ---- showPrivacyInfo ----
    // ---- startNewChat ----
    @AfterTest
    @BeforeTest
    @Test
    fun `cancel stops an in-flight ask and resets isLoading`() = runTest {
    fun `clearSnackbar clears the snackbar message`() = runTest {
    fun `concurrent ask is ignored while a previous ask is still loading`() = runTest {
    fun `enterInteractiveMode sets the flag and clears error`() = runTest {
    fun `exitInteractiveMode clears the flag and stops loading`() = runTest {
    fun `files list defaults to empty`() = runTest {
    fun `regenerate truncates to last user message and re-asks with null`() = runTest {
    fun `selectService is a no-op when instanceId is unknown`() = runTest {
    fun `selectService reorders configured services so the selected instance is first`() = runTest {
    fun `showPrivacyInfo is false when current service is not Free`() = runTest {
    fun `startNewChat clears history error and isLoading`() = runTest {
    fun setup() {
    fun tearDown() {
    private fun createViewModel(): ChatViewModel {
    private fun makeServiceEntry(instanceId: String, service: Service) = ServiceEntry(
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    private val unconfinedDispatcher = UnconfinedTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class ChatViewModelExtendedTest {
package com.inspiredandroid.kai.ui.chat
}
