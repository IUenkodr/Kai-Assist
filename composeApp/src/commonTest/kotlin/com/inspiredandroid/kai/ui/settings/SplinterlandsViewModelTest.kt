package com.inspiredandroid.kai.ui.settings
import app.cash.turbine.test
import com.inspiredandroid.kai.DaemonController
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.splinterlands.SplinterlandsApi
import com.inspiredandroid.kai.splinterlands.SplinterlandsBattleRunner
import com.inspiredandroid.kai.splinterlands.SplinterlandsStore
import com.inspiredandroid.kai.testutil.FakeDataRepository
import com.russhwolf.settings.MapSettings
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                override fun start() {}
                override fun stop() {}
            // Verify persisted
            SplinterlandsApi(),
            assertEquals(listOf("gemini"), updatedState.splinterlandsInstanceIds)
            assertEquals(listOf("gemini", "openai"), initialState.splinterlandsInstanceIds)
            assertEquals(listOf("openai"), updatedState.splinterlandsInstanceIds)
            assertEquals(listOf("openai", "gemini"), fakeSplinterlandsStore.getInstanceIds())
            assertEquals(listOf("openai", "gemini"), updatedState.splinterlandsInstanceIds)
            assertTrue(initialState.splinterlandsInstanceIds.isEmpty())
            assertTrue(state.splinterlandsInstanceIds.isEmpty())
            fakeRepository,
            fakeSplinterlandsStore,
            initialState.onAddSplinterlandsService("gemini")
            initialState.onRemoveSplinterlandsService("gemini")
            initialState.onReorderSplinterlandsServices(listOf("openai", "gemini"))
            object : DaemonController {
            val initialState = awaitItem()
            val state = awaitItem()
            val updatedState = awaitItem()
            },
        )
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeDataRepository()
        fakeRepository.setConfiguredServices(Service.Gemini)
        fakeRepository.setConfiguredServices(Service.Gemini, Service.OpenAI)
        fakeSplinterlandsBattleRunner = SplinterlandsBattleRunner(
        fakeSplinterlandsStore = SplinterlandsStore(testSettings)
        fakeSplinterlandsStore.setInstanceIds(listOf("gemini", "openai"))
        val testSettings = com.inspiredandroid.kai.data.AppSettings(MapSettings())
        val viewModel = SplinterlandsViewModel(fakeRepository, fakeSplinterlandsStore, fakeSplinterlandsBattleRunner, SplinterlandsApi())
        viewModel.state.test {
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `initial splinterlands instanceIds is empty`() = runTest {
    fun `onAddSplinterlandsService adds service to list`() = runTest {
    fun `onRemoveSplinterlandsService removes service from list`() = runTest {
    fun `onReorderSplinterlandsServices changes priority order`() = runTest {
    fun setup() {
    fun tearDown() {
    private lateinit var fakeRepository: FakeDataRepository
    private lateinit var fakeSplinterlandsBattleRunner: SplinterlandsBattleRunner
    private lateinit var fakeSplinterlandsStore: SplinterlandsStore
    private val testDispatcher = StandardTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class SplinterlandsViewModelTest {
}
