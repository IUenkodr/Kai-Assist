import app.cash.turbine.test
import com.inspiredandroid.kai.CommandHandle
import com.inspiredandroid.kai.NoOpCommandHandle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxFileEntry
import com.inspiredandroid.kai.SandboxMigration
import com.inspiredandroid.kai.SandboxStatus
import com.inspiredandroid.kai.SandboxStatusLabel
import com.inspiredandroid.kai.TextFileResult
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.testutil.FakeDataRepository
import io.github.vinceglb.filekit.PlatformFile
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

                SandboxStatus(error = true, label = SandboxStatusLabel.Failure.Setup("boom"))
                diskUsageMB = 250L,
                distro = LinuxDistro.ALPINE,
                distro = LinuxDistro.DEBIAN,
                error = false,
                installed = true,
                installedDistros = setOf(LinuxDistro.ALPINE),
                installedDistros = setOf(LinuxDistro.DEBIAN, LinuxDistro.ALPINE),
                label = SandboxStatusLabel.Downloading,
                label = SandboxStatusLabel.Ready,
                migration = SandboxMigration(from = LinuxDistro.ALPINE, fileCount = 42, bytes = 1_500_000),
                packagesInstalled = true,
                progress = 1.0f,
                ready = true,
                working = false,
                working = true,
            )
            // Each distribution keeps its own install, so switching away from an
            // installed one is a change of address rather than a reinstall.
            assertEquals(1.0f, updated.sandboxProgress)
            assertEquals(250L, updated.sandboxDiskUsageMB)
            assertEquals(42, migration?.fileCount)
            assertEquals(LinuxDistro.ALPINE, awaitItem().distro)
            assertEquals(LinuxDistro.ALPINE, fakeRepository.getSandboxDistro())
            assertEquals(LinuxDistro.ALPINE, fakeSandboxController.selectedDistro)
            assertEquals(LinuxDistro.ALPINE, migration?.from)
            assertEquals(LinuxDistro.DEBIAN, awaitItem().distro)
            assertEquals(LinuxDistro.DEBIAN, fakeRepository.getSandboxDistro())
            assertEquals(SandboxStatusLabel.Failure.Setup("boom"), updated.sandboxStatusLabel)
            assertEquals(SandboxStatusLabel.Ready, updated.sandboxStatusLabel)
            assertEquals(emptySet(), awaitItem().installedDistros)
            assertEquals(null, awaitItem().migration)
            assertEquals(null, fakeSandboxController.selectedDistro)
            assertEquals(setOf(LinuxDistro.ALPINE), awaitItem().installedDistros)
            assertFalse(initial.sandboxReady)
            assertFalse(updated.hasError)
            assertFalse(updated.isSandboxEnabled)
            assertFalse(updated.isWorking)
            assertTrue(awaitItem().isWorking)
            assertTrue(awaitItem().sandboxInstalled)
            assertTrue(initial.isSandboxEnabled)
            assertTrue(state.isSandboxEnabled)
            assertTrue(updated.hasError)
            assertTrue(updated.sandboxInstalled)
            assertTrue(updated.sandboxPackagesInstalled)
            assertTrue(updated.sandboxReady)
            cancelAndIgnoreRemainingEvents()
            cancelCalls++
            command: String,
            expectNoEvents()
            fakeSandboxController.status.value =
            fakeSandboxController.status.value = SandboxStatus(
            installPackagesCalls++
            migrateHomeCalls++
            onStderr: (String) -> Unit,
            onStdout: (String) -> Unit,
            resetCalls++
            selectedDistro = distro
            sessionId: String,
            setupCalls++
            skipItems(1)
            testDispatcher.scheduler.advanceUntilIdle()
            val initial = awaitItem()
            val migration = awaitItem().migration
            val state = awaitItem()
            val updated = awaitItem()
            viewModel.onSelectDistro(LinuxDistro.ALPINE)
            viewModel.onToggleSandbox(false)
        ): CommandHandle = NoOpCommandHandle
        // Legacy installs are Alpine no matter what the setting defaults to.
        Dispatchers.resetMain()
        Dispatchers.setMain(testDispatcher)
        assertEquals(1, fakeSandboxController.cancelCalls)
        assertEquals(1, fakeSandboxController.installPackagesCalls)
        assertEquals(1, fakeSandboxController.migrateHomeCalls)
        assertEquals(1, fakeSandboxController.resetCalls)
        assertEquals(1, fakeSandboxController.setupCalls)
        fakeRepository = FakeDataRepository()
        fakeSandboxController = FakeSandboxController()
        override fun cancel() {
        override fun installPackages() {
        override fun migrateHome() {
        override fun reset() {
        override fun selectDistro(distro: LinuxDistro) {
        override fun setup() {
        override suspend fun deleteEntry(path: String, recursive: Boolean): Boolean = false
        override suspend fun executeCommand(command: String, sessionId: String): String = ""
        override suspend fun executeCommandStreaming(
        override suspend fun importFile(directoryPath: String, source: PlatformFile): Result<String> = Result.failure(UnsupportedOperationException())
        override suspend fun listDirectory(path: String): List<SandboxFileEntry> = emptyList()
        override suspend fun openFile(path: String): Result<Unit> = Result.failure(UnsupportedOperationException())
        override suspend fun readTextFile(path: String, maxBytes: Int, force: Boolean): TextFileResult = TextFileResult.Unreadable
        override suspend fun renameEntry(path: String, newName: String): Result<String> = Result.failure(UnsupportedOperationException())
        override suspend fun writeTextFile(path: String, content: String): Boolean = false
        override val sessions = MutableStateFlow<List<String>>(emptyList())
        override val status = MutableStateFlow(SandboxStatus())
        val viewModel = SandboxViewModel(fakeRepository, fakeSandboxController)
        var cancelCalls = 0
        var installPackagesCalls = 0
        var migrateHomeCalls = 0
        var resetCalls = 0
        var selectedDistro: LinuxDistro? = null
        var setupCalls = 0
        viewModel.onCancelSandbox()
        viewModel.onInstallPackages()
        viewModel.onMigrateHome()
        viewModel.onResetSandbox()
        viewModel.onSetupSandbox()
        viewModel.state.test {
        }
    @AfterTest
    @BeforeTest
    @Test
    fun `a pending migration flows into state so the card can offer it`() = runTest {
    fun `controller error status flows into hasError`() = runTest {
    fun `controller status updates flow into state`() = runTest {
    fun `initial state reflects sandbox enabled flag from repository`() = runTest {
    fun `installed distributions flow into state for the picker`() = runTest {
    fun `installed distro from the controller wins over the stored setting`() = runTest {
    fun `onCancelSandbox delegates to controller`() = runTest {
    fun `onInstallPackages delegates to controller`() = runTest {
    fun `onMigrateHome delegates to controller`() = runTest {
    fun `onResetSandbox delegates to controller`() = runTest {
    fun `onSelectDistro is ignored while an install is running`() = runTest {
    fun `onSelectDistro persists the choice before anything is installed`() = runTest {
    fun `onSelectDistro re-points the sandbox once a rootfs exists`() = runTest {
    fun `onSetupSandbox delegates to controller`() = runTest {
    fun `onToggleSandbox persists to repository`() = runTest {
    fun setup() {
    fun tearDown() {
    private class FakeSandboxController : SandboxController {
    private lateinit var fakeRepository: FakeDataRepository
    private lateinit var fakeSandboxController: FakeSandboxController
    private val testDispatcher = StandardTestDispatcher()
    }
@OptIn(ExperimentalCoroutinesApi::class)
class SandboxViewModelTest {
package com.inspiredandroid.kai.ui.settings
}
