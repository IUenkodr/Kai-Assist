import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.Platform
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxMigration
import com.inspiredandroid.kai.SandboxStatus
import com.inspiredandroid.kai.SandboxStatusLabel
import com.inspiredandroid.kai.currentPlatform
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.linux.LinuxDistro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

                _state.update { applyStatus(sandboxStatus, it) }
                isSandboxEnabled = dataRepository.isSandboxEnabled(),
                showSandbox = currentPlatform is Platform.Mobile.Android,
            ),
            // No distro seed: the controller is the only thing that knows which
            // install the sandbox is actually pointed at, and a sandbox older
            // than the picker has one the stored setting does not name.
            SandboxUiState(
            sandboxController.status.collect { sandboxStatus ->
            sandboxController.status.value,
            }
        ),
        _state.update { it.copy(distro = distro) }
        _state.update { it.copy(isSandboxEnabled = enabled) }
        applyStatus(
        dataRepository.setSandboxDistro(distro)
        dataRepository.setSandboxEnabled(enabled)
        distro = status.distro,
        hasError = status.error,
        if (_state.value.distro == distro || _state.value.isWorking) return
        installedDistros = status.installedDistros,
        isWorking = status.working,
        migration = status.migration,
        sandboxController.cancel()
        sandboxController.installPackages()
        sandboxController.migrateHome()
        sandboxController.reset()
        sandboxController.selectDistro(distro)
        sandboxController.setup()
        sandboxDiskUsageMB = status.diskUsageMB,
        sandboxInstalled = status.installed,
        sandboxPackagesInstalled = status.packagesInstalled,
        sandboxProgress = status.progress,
        sandboxReady = status.ready,
        sandboxStatusLabel = status.label,
        viewModelScope.launch {
        }
     *
     * Copies the other distribution's home in. Nothing is removed by it — the
     * Points the shell integration at another distribution. Nothing is removed:
     * The installed distro once [sandboxInstalled], the pending choice before
     * The state is updated ahead of the controller so the radio button answers
     * distribution it came from is still installed afterwards, and removing that
     * downstream should ever prefer the setting over what is on disk.
     * each keeps its own install, so this is a switch when the target is already
     * install's card should say.
     * stays the separate, deliberate Uninstall action.
     * that. The controller reports both through the same field because nothing
     * the tap; the controller's status then confirms it along with what the new
     * there and a plain "Install" offer when it is not.
     */
    )
    /**
    /** Distributions already on disk, so the picker can say which is a download. */
    /** Files the other install has and this one does not; null when there are none. */
    // Seed synchronously from the controller's current status so the first
    // already ready. The controller mirrors LinuxSandboxManager's synchronous
    // composition doesn't briefly render the install UI when the sandbox is
    // installation check, so reading status.value here returns the real state.
    fun onCancelSandbox() {
    fun onInstallPackages() {
    fun onMigrateHome() {
    fun onResetSandbox() {
    fun onSelectDistro(distro: LinuxDistro) {
    fun onSetupSandbox() {
    fun onToggleSandbox(enabled: Boolean) {
    init {
    private fun applyStatus(status: SandboxStatus, base: SandboxUiState): SandboxUiState = base.copy(
    private val _state = MutableStateFlow(
    private val dataRepository: DataRepository,
    private val sandboxController: SandboxController,
    val distro: LinuxDistro = LinuxDistro.DEFAULT,
    val hasError: Boolean = false,
    val installedDistros: Set<LinuxDistro> = emptySet(),
    val isSandboxEnabled: Boolean = true,
    val isWorking: Boolean = false,
    val migration: SandboxMigration? = null,
    val sandboxDiskUsageMB: Long = 0,
    val sandboxInstalled: Boolean = false,
    val sandboxPackagesInstalled: Boolean = false,
    val sandboxProgress: Float? = null,
    val sandboxReady: Boolean = false,
    val sandboxStatusLabel: SandboxStatusLabel? = null,
    val showSandbox: Boolean = false,
    val state = _state.asStateFlow()
    }
)
) : ViewModel() {
@Immutable
class SandboxViewModel(
data class SandboxUiState(
package com.inspiredandroid.kai.ui.settings
}
