import app.cash.turbine.test
import com.inspiredandroid.kai.DaemonController
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.testutil.FakeDataRepository
import com.inspiredandroid.kai.tools.AppPermission
import com.inspiredandroid.kai.tools.PermissionController
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                "https://custom.example.com/v1/",
                .filterIsInstance<app.cash.turbine.Event.Item<SettingsUiState>>()
                .last().value
                SettingsModel(id = "gemini-flash", subtitle = ""),
                SettingsModel(id = "gemini-pro", subtitle = ""),
                assertEquals("Test Server", lastState.mcpServers[0].name)
                assertEquals(1, lastState.mcpServers.size)
                assertFalse(lastState.mcpServers[0].isEnabled)
                assertFalse(lastState.showAddMcpServerDialog)
                fakeRepository.getInstanceBaseUrl(instanceId, Service.OpenAICompatible),
            "gemini",
            )
            ),
            // Collapse
            // Deletion is deferred (undo snackbar), collect until actually removed
            // Dialog should close and server should appear
            // First remove: Gemini becomes pending.
            // Gemini is gone, OpenAI is still pending so its snackbar stays visible.
            // Let the committed (now-stale) executeDeletion for Gemini finish without advancing the 4s delay for OpenAI.
            // Models should be empty until API key is validated and models are fetched
            // Models should have been cleared
            // No exception means success
            // Remove by instanceId (which equals serviceId for first instances)
            // Second remove fires before the 4s undo timeout: commits Gemini immediately and queues OpenAI.
            // Should contain all other services including already-configured ones (multi-instance)
            // Should not contain Free
            // Toggle a tool - should not crash even with no MCP servers
            // Use instanceId instead of Service
            assertEquals(
            assertEquals("You are a helpful assistant.", fakeRepository.getSoulText())
            assertEquals("You are a helpful assistant.", updated.soulText)
            assertEquals("anthropic", updatedState.configuredServices[0].instanceId)
            assertEquals("gemini", state.configuredServices[0].instanceId)
            assertEquals("groqcloud", updatedState.expandedServiceId)
            assertEquals("new-api-key", updatedState.configuredServices[0].apiKey)
            assertEquals("openai", afterFirst.configuredServices[0].instanceId)
            assertEquals("openai", afterSecond.configuredServices[0].instanceId)
            assertEquals("openai", expandedState.expandedServiceId)
            assertEquals("openai", state.configuredServices[1].instanceId)
            assertEquals("openai_2", afterSecond.configuredServices[1].instanceId)
            assertEquals("sk-test-123", fakeRepository.getInstanceApiKey("anthropic"))
            assertEquals(1, afterFirst.configuredServices.size)
            assertEquals(1, initialState.mcpServers.size)
            assertEquals(1, lastState.configuredServices.size)
            assertEquals(1, updatedState.configuredServices.size)
            assertEquals(1.5f, fakeRepository.getUiScale())
            assertEquals(1.5f, updated.uiScale)
            assertEquals(2, afterCommit.configuredServices.size)
            assertEquals(2, afterSecond.configuredServices.size)
            assertEquals(2, initialState.configuredServices.size)
            assertEquals(2, state.configuredServices.size)
            assertEquals(3, awaitItem().configuredServices.size)
            assertEquals(30, fakeRepository.getEmailPollIntervalMinutes())
            assertEquals(30, updated.emailPollIntervalMinutes)
            assertEquals(45, updated.heartbeatIntervalMinutes)
            assertEquals(ConnectionStatus.Unknown, updatedState.configuredServices.first().connectionStatus)
            assertEquals(PendingDeletion.Service("openai"), afterCommit.pendingDeletion)
            assertEquals(Service.Anthropic, updatedState.configuredServices[0].service)
            assertEquals(Service.Gemini, state.configuredServices[0].service)
            assertEquals(Service.Groq, afterCommit.configuredServices[1].service)
            assertEquals(Service.Groq, updatedState.configuredServices[0].service)
            assertEquals(Service.OpenAI, afterCommit.configuredServices[0].service)
            assertEquals(Service.OpenAI, lastState.configuredServices[0].service)
            assertEquals(Service.OpenAI, state.configuredServices[1].service)
            assertEquals(SettingsTab.Tools, updated.currentTab)
            assertEquals(null, collapsedState.expandedServiceId)
            assertEquals(null, initialState.expandedServiceId)
            assertFalse(fakeRepository.isDynamicUiEnabled())
            assertFalse(fakeRepository.isFreeFallbackEnabled())
            assertFalse(fakeRepository.isMemoryEnabled())
            assertFalse(fakeRepository.isSchedulingEnabled())
            assertFalse(hideState.showAddMcpServerDialog)
            assertFalse(initialState.showAddMcpServerDialog)
            assertFalse(models.first { it.id == "gemini-flash" }.isSelected)
            assertFalse(updated.isDynamicUiEnabled)
            assertFalse(updated.isFreeFallbackEnabled)
            assertFalse(updated.isMemoryEnabled)
            assertFalse(updated.isSchedulingEnabled)
            assertTrue(initialState.configuredServices.isEmpty())
            assertTrue(initialState.isDynamicUiEnabled)
            assertTrue(initialState.isFreeFallbackEnabled)
            assertTrue(initialState.isMemoryEnabled)
            assertTrue(initialState.isSchedulingEnabled)
            assertTrue(initialState.mcpServers.isEmpty())
            assertTrue(initialState.mcpServers[0].isEnabled)
            assertTrue(lastState.mcpServers.isEmpty())
            assertTrue(models.first { it.id == "gemini-pro" }.isSelected)
            assertTrue(models.isEmpty())
            assertTrue(showState.showAddMcpServerDialog)
            assertTrue(state.availableServicesToAdd.contains(Service.DeepSeek))
            assertTrue(state.availableServicesToAdd.contains(Service.Gemini))
            assertTrue(state.availableServicesToAdd.contains(Service.OpenAI))
            assertTrue(state.availableServicesToAdd.none { it == Service.Free })
            assertTrue(state.configuredServices.isEmpty())
            assertTrue(state.mcpServers.isEmpty())
            awaitItem()
            cancelAndIgnoreRemainingEvents()
            if (lastState != null) {
            listOf(
            requireNotNull(lastState)
            testDispatcher.scheduler.advanceUntilIdle()
            testDispatcher.scheduler.runCurrent()
            val afterCommit = cancelAndConsumeRemainingEvents()
            val afterFirst = awaitItem()
            val afterSecond = awaitItem()
            val collapsedState = awaitItem()
            val expandedState = awaitItem()
            val hideState = awaitItem()
            val initialState = awaitItem()
            val instanceId = initialState.configuredServices.first().instanceId
            val lastState = (updates.filterIsInstance<app.cash.turbine.Event.Item<SettingsUiState>>().lastOrNull()?.value)
            val lastState = updates.filterIsInstance<app.cash.turbine.Event.Item<SettingsUiState>>().lastOrNull()?.value
            val models = fakeRepository.getInstanceModels("anthropic", Service.Anthropic).value
            val models = fakeRepository.getInstanceModels("gemini", Service.Gemini).value
            val showState = awaitItem()
            val state = awaitItem()
            val updated = awaitItem()
            val updatedState = awaitItem()
            val updates = cancelAndConsumeRemainingEvents()
            viewModel.actions.onAddMcpServer("Test Server", "https://example.com/mcp", emptyMap())
            viewModel.actions.onAddService(Service.Anthropic)
            viewModel.actions.onAddService(Service.Groq)
            viewModel.actions.onAddService(Service.OpenAI)
            viewModel.actions.onChangeApiKey("anthropic", "new-key")
            viewModel.actions.onChangeApiKey("anthropic", "sk-test-123")
            viewModel.actions.onChangeApiKey("groqcloud", "new-api-key")
            viewModel.actions.onChangeBaseUrl(instanceId, "https://custom.example.com/v1/")
            viewModel.actions.onChangeBaseUrl(instanceId, "https://x.example/v1")
            viewModel.actions.onChangeEmailPollInterval(30)
            viewModel.actions.onChangeHeartbeatInterval(45)
            viewModel.actions.onChangeUiScale(1.5f)
            viewModel.actions.onExpandService("openai")
            viewModel.actions.onExpandService(null)
            viewModel.actions.onRemoveMcpServer(initialState.mcpServers[0].id)
            viewModel.actions.onRemoveService("gemini")
            viewModel.actions.onRemoveService("openai")
            viewModel.actions.onSaveSoul("You are a helpful assistant.")
            viewModel.actions.onSelectModel("gemini", "gemini-pro")
            viewModel.actions.onSelectTab(SettingsTab.Tools)
            viewModel.actions.onShowAddMcpServerDialog(false)
            viewModel.actions.onShowAddMcpServerDialog(true)
            viewModel.actions.onToggleDynamicUi(false)
            viewModel.actions.onToggleFreeFallback(false)
            viewModel.actions.onToggleMcpServer(config.id, false)
            viewModel.actions.onToggleMemory(false)
            viewModel.actions.onToggleScheduling(false)
            viewModel.actions.onToggleTool("some_tool", false)
            }
        )
        // Pre-add a server
        // Pre-populate models
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeDataRepository()
        fakeRepository.addMcpServer("Test", "https://example.com/mcp", emptyMap())
        fakeRepository.setConfiguredServices(Service.Anthropic)
        fakeRepository.setConfiguredServices(Service.Gemini)
        fakeRepository.setConfiguredServices(Service.Gemini, Service.OpenAI)
        fakeRepository.setConfiguredServices(Service.Gemini, Service.OpenAI, Service.Groq)
        fakeRepository.setConfiguredServices(Service.Groq)
        fakeRepository.setConfiguredServices(Service.OpenAICompatible)
        fakeRepository.setInstanceModels(
        fakeRepository.setInstanceModels("anthropic", listOf(SettingsModel(id = "claude-old", subtitle = "")))
        noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        override fun start() {}
        override fun stop() {}
        val config = fakeRepository.addMcpServer("Test", "https://example.com/mcp", emptyMap())
        val viewModel = SettingsViewModel(fakeRepository, fakeDaemonController, fakeNotificationPermissionController, noOpScheduler, testDispatcher)
        viewModel.state.test {
        }
    // --- Expand state ---
    // --- MCP Server Tests ---
    // --- Per-instance settings persistence ---
    // --- Service Tests (continued) ---
    // --- Soul / dynamic UI / memory toggles ---
    // --- Tab selection ---
    @AfterTest
    @BeforeTest
    @Test
    fun `adding Anthropic service shows no models before validation`() = runTest {
    fun `adding same service type twice creates unique instanceIds`() = runTest {
    fun `availableServicesToAdd contains all non-Free services`() = runTest {
    fun `initial state has empty configured services when none configured`() = runTest {
    fun `initial state has empty mcp servers when none configured`() = runTest {
    fun `initial state reflects configured services`() = runTest {
    fun `onAddMcpServer adds server and closes dialog`() = runTest {
    fun `onAddService adds a new configured service`() = runTest {
    fun `onChangeApiKey clears models for that instance`() = runTest {
    fun `onChangeApiKey persists to repository`() = runTest {
    fun `onChangeApiKey updates API key for specific instance`() = runTest {
    fun `onChangeBaseUrl persists to repository`() = runTest {
    fun `onChangeBaseUrl resets connectionStatus to Unknown`() = runTest {
    fun `onChangeEmailPollInterval persists and reflects in state`() = runTest {
    fun `onChangeHeartbeatInterval persists and reflects in state`() = runTest {
    fun `onChangeUiScale persists and reflects in state`() = runTest {
    fun `onExpandService updates expandedServiceId`() = runTest {
    fun `onRemoveMcpServer removes server`() = runTest {
    fun `onRemoveService removes a configured service by instanceId`() = runTest {
    fun `onSaveSoul persists soul text`() = runTest {
    fun `onSelectModel marks the chosen model as selected on the repository`() = runTest {
    fun `onSelectTab updates currentTab`() = runTest {
    fun `onToggleDynamicUi persists and reflects in state`() = runTest {
    fun `onToggleFreeFallback persists and reflects in state`() = runTest {
    fun `onToggleMcpServer disables server and updates status`() = runTest {
    fun `onToggleMemory persists and reflects in state`() = runTest {
    fun `onToggleScheduling persists and reflects in state`() = runTest {
    fun `onToggleTool does not crash with no mcp servers`() = runTest {
    fun `rapid onRemoveService keeps the new pendingDeletion after the previous commits`() = runTest {
    fun `showAddMcpServerDialog toggles correctly`() = runTest {
    fun setup() {
    fun tearDown() {
    private lateinit var fakeRepository: FakeDataRepository
    private lateinit var noOpScheduler: TaskScheduler
    private val fakeDaemonController = object : DaemonController {
    private val fakeNotificationPermissionController = PermissionController(AppPermission.POST_NOTIFICATIONS)
    private val testDispatcher = StandardTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class SettingsViewModelTest {
package com.inspiredandroid.kai.ui.settings
}
