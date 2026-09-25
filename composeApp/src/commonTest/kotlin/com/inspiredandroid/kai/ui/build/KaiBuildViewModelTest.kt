package com.inspiredandroid.kai.ui.build
import app.cash.turbine.test
import com.inspiredandroid.kai.FileBrowserSource
import com.inspiredandroid.kai.KaiBuildController
import com.inspiredandroid.kai.NoOpFileBrowserSource
import com.inspiredandroid.kai.build.BuildEnvironmentState
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.testutil.FakeDataRepository
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                environment = BuildEnvironmentState.Ready,
                installedAgents = persistentSetOf("claude-code", "grok"),
            ),
            KaiBuildState(
            assertEquals("claude-code", awaitItem().launchAgentId)
            assertEquals("grok", awaitItem().launchAgentId)
            assertEquals("grok", fakeRepository.getKaiBuildLaunchAgent())
            assertNull(awaitItem().launchAgentId)
            cancelAndIgnoreRemainingEvents()
            deleted += name
            renamed += name to newName
            return newName
            startedWith += agentId
            testDispatcher.scheduler.advanceUntilIdle()
            viewModel.setLaunchAgent("grok")
        )
        /** Agent ids passed to [startSession], oldest first. */
        /** Old-to-new pairs passed to [renameProject], oldest first. */
        /** Project names passed to [deleteProject], oldest first. */
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        assertEquals(listOf("demo" to "demo-2"), fakeController.renamed)
        assertEquals(listOf("old-demo"), fakeController.deleted)
        assertEquals(listOf<String?>("claude-code"), fakeController.startedWith)
        assertEquals(listOf<String?>(null), fakeController.startedWith)
        assertNull(fakeRepository.getKaiBuildLaunchAgent())
        fakeController = FakeKaiBuildController()
        fakeRepository = FakeDataRepository()
        fakeRepository.storedKaiBuildLaunchAgent = "claude-code"
        fakeRepository.storedKaiBuildLaunchAgent = "grok"
        fakeRepository.storedKaiBuildLaunchAgent = "opencode"
        override fun cancel() {}
        override fun closeSession(id: String) {}
        override fun createProject(name: String): String? = name
        override fun deleteProject(name: String) {
        override fun install(agentIds: Set<String>) {}
        override fun leaveProject(project: String) {}
        override fun refresh() {}
        override fun renameProject(name: String, newName: String): String {
        override fun resizeTerminal(columns: Int, rows: Int) {}
        override fun resumeProject(project: String): Boolean = false
        override fun selectSession(id: String) {}
        override fun startSession(project: String, agentId: String?) {
        override fun uninstall() {}
        override fun writeToTerminal(text: String) {}
        override val files: FileBrowserSource = NoOpFileBrowserSource
        override val state = MutableStateFlow(
        val deleted = mutableListOf<String>()
        val renamed = mutableListOf<Pair<String, String>>()
        val startedWith = mutableListOf<String?>()
        val viewModel = KaiBuildViewModel(fakeController, fakeRepository)
        viewModel.deleteProject("old-demo")
        viewModel.openProject("demo")
        viewModel.renameProject("demo", "demo-2")
        viewModel.setLaunchAgent(null)
        viewModel.uiState.test {
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `a remembered agent that is no longer installed falls back to a shell`() = runTest {
    fun `deleting and renaming reach the environment`() = runTest {
    fun `launch agent is restored on the next app start`() = runTest {
    fun `picking the shell again clears the stored agent`() = runTest {
    fun `setLaunchAgent persists the choice`() = runTest {
    fun setup() {
    fun tearDown() {
    private class FakeKaiBuildController : KaiBuildController {
    private lateinit var fakeController: FakeKaiBuildController
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class KaiBuildViewModelTest {
}
