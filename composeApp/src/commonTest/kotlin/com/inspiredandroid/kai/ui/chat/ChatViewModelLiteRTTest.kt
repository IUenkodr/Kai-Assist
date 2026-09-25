package com.inspiredandroid.kai.ui.chat
import app.cash.turbine.test
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.inference.DownloadedModel
import com.inspiredandroid.kai.testutil.FakeDataRepository
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                displayName = "Gemma 4 E2B IT",
                filePath = "/fake/path/model.litertlm",
                id = "gemma-4-e2b-it",
                sizeBytes = 2_580_000_000L,
                updated = awaitItem()
            ),
            // Simulate switching primary service to Gemini
            DownloadedModel(
            assertNotNull(state.warning)
            assertNull(state.warning)
            assertNull(updated.warning)
            do {
            fakeRepository.fakeServiceEntries = listOf(geminiServiceEntry(), litertServiceEntry())
            testDispatcher.scheduler.advanceUntilIdle()
            val state = awaitItem()
            var updated: ChatUiState
            viewModel.refreshSettings()
            } while (updated.warning != null)
        )
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeDataRepository()
        fakeRepository.fakeLocalDownloadedModels = emptyList()
        fakeRepository.fakeLocalDownloadedModels = listOf(
        fakeRepository.fakeServiceEntries = listOf(geminiServiceEntry())
        fakeRepository.fakeServiceEntries = listOf(geminiServiceEntry(), litertServiceEntry())
        fakeRepository.fakeServiceEntries = listOf(litertServiceEntry())
        icon = Service.Gemini.icon,
        icon = Service.LiteRT.icon,
        instanceId = "gemini",
        instanceId = "litert",
        modelId = "",
        modelId = "gemini-2.0-flash",
        return ChatViewModel(fakeRepository, noOpScheduler, unconfinedDispatcher)
        serviceId = Service.Gemini.id,
        serviceId = Service.LiteRT.id,
        serviceName = Service.Gemini.displayName,
        serviceName = Service.LiteRT.displayName,
        val noOpScheduler = TaskScheduler(fakeRepository, enabled = false)
        val viewModel = createViewModel()
        viewModel.state.test {
        }
    )
    @AfterTest
    @BeforeTest
    @Test
    fun `no warning when LiteRT has downloaded models`() = runTest {
    fun `no warning when LiteRT is secondary service with no models`() = runTest {
    fun `no warning when primary service is not on-device`() = runTest {
    fun `warning cleared after switching to non-on-device service`() = runTest {
    fun `warning shown when LiteRT is primary service with no downloaded models`() = runTest {
    fun setup() {
    fun tearDown() {
    private fun createViewModel(): ChatViewModel {
    private fun geminiServiceEntry() = ServiceEntry(
    private fun litertServiceEntry() = ServiceEntry(
    private lateinit var fakeRepository: FakeDataRepository
    private val testDispatcher = StandardTestDispatcher()
    private val unconfinedDispatcher = UnconfinedTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class ChatViewModelLiteRTTest {
}
