
                            Res.string.sandbox_packages_upgrade_failed,
                            updateResult.errorSummary(),
                        ),
                        SnackbarMessage(Res.string.sandbox_packages_up_to_date)
                        SnackbarMessage(Res.string.sandbox_packages_upgrade_count, count.toString())
                        snackbarMessage = SnackbarMessage(
                        upgrading = false,
                    )
                    SnackbarMessage(Res.string.sandbox_packages_upgrade_failed, upgradeResult.errorSummary())
                    if (count == 0) {
                    it.copy(
                    val count = manager.countUpgraded(upgradeResult.stdout)
                    }
                    } else {
                ?: "exit code $exit"
                ?: stdout.lineSequence().filter { it.isNotBlank() }.lastOrNull()
                SnackbarMessage(failureRes, result.errorSummary())
                SnackbarMessage(successRes, pkg.name)
                _state.update {
                _state.update { it.copy(protectedPackages = status.distro.protectedPackages.toImmutableSet()) }
                else -> 5
                entry.description?.lowercase()?.contains(q) == true -> 4
                installed = parsed.toImmutableList(),
                installedNames = parsed.mapTo(mutableSetOf()) { p -> p.name }.toImmutableSet(),
                it
                it.copy(searchResults = results, searching = false)
                it.copy(upgrading = false, snackbarMessage = msg)
                name == q -> 0
                name.contains("-$q") || name.contains("_$q") -> 2
                name.contains(q) -> 3
                name.startsWith(q) -> 1
                return@launch
                val msg = if (upgradeResult.hasErrors(manager)) {
                }
                } else {
            )
            .take(SEARCH_RESULT_LIMIT)
            .toImmutableList()
            _state.update {
            _state.update { it.copy(loadingInstalled = false) }
            _state.update { it.copy(searchResults = persistentListOf(), searching = false) }
            _state.update { it.copy(searching = true) }
            _state.update { it.copy(snackbarMessage = msg) }
            applyInstalled(loadInstalled())
            cmd = packageManager.installCommand(pkg.name),
            cmd = packageManager.removeCommand(pkg.name),
            command = cmd,
            delay(SEARCH_DEBOUNCE_MS.milliseconds)
            failureRes = Res.string.sandbox_packages_install_failed,
            failureRes = Res.string.sandbox_packages_uninstall_failed,
            if (it.searchQuery == query) {
            if (line.isNotEmpty()) println("$LOG_TAG [$label] $line")
            if (mutating) next.add(name) else next.remove(name)
            if (updateResult.hasErrors(manager)) {
            it.copy(
            it.copy(mutating = next.toImmutableSet())
            markMutating(pkg.name, false)
            onStderr = { stderrChannel.trySend(it) },
            onStdout = { stdoutChannel.trySend(it) },
            pkg = pkg,
            println("$LOG_TAG [$label] <empty>")
            protectedPackages = sandboxController.status.value.distro.protectedPackages.toImmutableSet(),
            return
            return tail.take(ERROR_SUMMARY_MAX_CHARS)
            runSearch(query)
            sandboxController.status.collect { status ->
            sessionId = SandboxSessions.SYSTEM,
            successRes = Res.string.sandbox_packages_install_success,
            successRes = Res.string.sandbox_packages_uninstall_success,
            successWhenInstalled = false,
            successWhenInstalled = true,
            val isInstalled = pkg.name in _state.value.installedNames
            val manager = packageManager
            val msg = if (succeeded) {
            val name = entry.name.lowercase()
            val next = it.mutating.toMutableSet()
            val result = runAndCapture(cmd)
            val succeeded = isInstalled == successWhenInstalled
            val tail = stderr.lineSequence().filter { it.isNotBlank() }.lastOrNull()
            val updateResult = runAndCapture(manager.updateCommand)
            val upgradeResult = runAndCapture(manager.upgradeCommand)
            when {
            }
            } else {
        )
        ),
        // An uninstall/reinstall can swap the distro under a live Packages tab.
        // Fetch a large alphabetical pool, then re-rank so name-prefix hits surface
        // The base packages back the sandbox's own shell sessions — never offer to
        // a bare `head` would bury "fast*" under earlier description hits.
        // first — both package managers return matches (name + description) A–Z, so
        // remove them; this is the only entry point that sets pendingUninstall.
        PackagesUiState(
        _state.update {
        _state.update { it.copy(loadingInstalled = true) }
        _state.update { it.copy(pendingUninstall = null) }
        _state.update { it.copy(pendingUninstall = pkg) }
        _state.update { it.copy(searchQuery = query) }
        _state.update { it.copy(snackbarMessage = null) }
        _state.update { it.copy(upgrading = true) }
        body.lineSequence().forEach { line ->
        cmd: String,
        compareBy<PackageEntry> { entry ->
        failureRes: StringResource,
        fun errorSummary(): String {
        fun hasErrors(manager: PackageManagerSpec): Boolean = manager.hasErrors(stdout, stderr)
        get() = sandboxController.status.value.distro.packageManager
        if (_state.value.loadingInstalled) return
        if (_state.value.upgrading) return
        if (body.isEmpty()) {
        if (current.installed.isNotEmpty() || current.loadingInstalled) return
        if (pkg.name in _state.value.mutating) return
        if (pkg.name in sandboxController.status.value.distro.protectedPackages) return
        if (query.isBlank()) {
        log("loadInstalled", cmd, output)
        log("runSearch($query)", cmd, output)
        logMultiline("$label output", output)
        logMultiline("runAndCapture stderr", stderr)
        logMultiline("runAndCapture stdout", stdout)
        markMutating(pkg.name, true)
        mutateInstalled(
        pkg: PackageEntry,
        println("$LOG_TAG [$label] cmd=$cmd")
        println("$LOG_TAG [runAndCapture] exit=$exit cmd=$cmd")
        refreshInstalled()
        return CommandResult(exit, stdout, stderr)
        return manager.parseInstalled(output)
        searchJob = viewModelScope.launch {
        searchJob?.cancel()
        stderrChannel.close()
        stdoutChannel.close()
        successRes: StringResource,
        successWhenInstalled: Boolean,
        val cmd = manager.listInstalledCommand
        val cmd = manager.searchCommand(query, SEARCH_FETCH_LIMIT)
        val current = _state.value
        val exit = handle.awaitExit()
        val handle = sandboxController.executeCommandStreaming(
        val manager = packageManager
        val output = sandboxController.executeCommand(cmd, SandboxSessions.SYSTEM)
        val pkg = _state.value.pendingUninstall ?: return
        val results = rankSearchResults(manager.parseSearch(output), query)
        val stderr = buildString { for (line in stderrChannel) appendLine(line) }
        val stderrChannel = Channel<String>(capacity = Channel.UNLIMITED)
        val stdout = buildString { for (line in stdoutChannel) appendLine(line) }
        val stdoutChannel = Channel<String>(capacity = Channel.UNLIMITED)
        viewModelScope.launch {
        }
        }.thenBy { it.name.lowercase() },
     * Read per call rather than captured: the installed distro is only known once
     * the sandbox reports its status, and an uninstall/reinstall can change it
     * while this ViewModel is alive.
     */
    )
    ) {
    /**
    /** Base packages of the installed distro — these get no uninstall action. */
    // Package-manager exit codes don't mean what they normally do under proot, so
    // package's presence (install) or absence (uninstall) instead.
    // we verify success by re-reading the installed list and checking the
    fun cancelUninstall() {
    fun confirmUninstall() {
    fun consumeSnackbar() {
    fun install(pkg: PackageEntry) {
    fun refreshInstalled() {
    fun requestUninstall(pkg: PackageEntry) {
    fun start() {
    fun updateSearchQuery(query: String) {
    fun upgradePackages() {
    if (q.isEmpty() || results.isEmpty()) return results
    init {
    private data class CommandResult(val exit: Int, val stdout: String, val stderr: String) {
    private fun applyInstalled(parsed: List<PackageEntry>) {
    private fun log(label: String, cmd: String, output: String) {
    private fun logMultiline(label: String, body: String) {
    private fun markMutating(name: String, mutating: Boolean) {
    private fun mutateInstalled(
    private suspend fun loadInstalled(): List<PackageEntry> {
    private suspend fun runAndCapture(cmd: String): CommandResult {
    private suspend fun runSearch(query: String) {
    private val _state = MutableStateFlow(
    private val packageManager: PackageManagerSpec
    private val sandboxController: SandboxController,
    private var searchJob: Job? = null
    return results.sortedWith(
    val installed: ImmutableList<PackageEntry> = persistentListOf(),
    val installedNames: ImmutableSet<String> = persistentSetOf(),
    val loadingInstalled: Boolean = false,
    val mutating: ImmutableSet<String> = persistentSetOf(),
    val pendingUninstall: PackageEntry? = null,
    val protectedPackages: ImmutableSet<String> = persistentSetOf(),
    val q = query.trim().lowercase()
    val searchQuery: String = "",
    val searchResults: ImmutableList<PackageEntry> = persistentListOf(),
    val searching: Boolean = false,
    val snackbarMessage: SnackbarMessage? = null,
    val state = _state.asStateFlow()
    val upgrading: Boolean = false,
    }
 *
 *  aren't lost to alphabetical `head` truncation of description hits. */
 * 0 exact name · 1 name prefix · 2 name segment prefix (`foo-fast…` / `foo_fast…`)
 * Priority (then alphabetical by name within a tier):
 * Ranks package search hits so the list matches what a user expects when typing
 * a name fragment (e.g. "fast" → every package whose name *starts with* "fast"
 * before anything that only mentions "fast" in the description).
 * · 3 name contains · 4 description contains · 5 everything else
 */
)
) : ViewModel() {
/**
/** How many hits to pull before ranking — high enough that prefix matches
/** Max packages shown in the Packages search list after ranking. */
@Immutable
class SandboxPackagesViewModel(
data class PackagesUiState(
data class SnackbarMessage(val resource: StringResource, val arg: String? = null)
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxSessions
import com.inspiredandroid.kai.linux.PackageEntry
import com.inspiredandroid.kai.linux.PackageManagerSpec
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_packages_install_failed
import kai.composeapp.generated.resources.sandbox_packages_install_success
import kai.composeapp.generated.resources.sandbox_packages_uninstall_failed
import kai.composeapp.generated.resources.sandbox_packages_uninstall_success
import kai.composeapp.generated.resources.sandbox_packages_up_to_date
import kai.composeapp.generated.resources.sandbox_packages_upgrade_count
import kai.composeapp.generated.resources.sandbox_packages_upgrade_failed
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
internal fun rankSearchResults(results: List<PackageEntry>, query: String): List<PackageEntry> {
package com.inspiredandroid.kai.ui.sandbox
private const val ERROR_SUMMARY_MAX_CHARS = 200
private const val LOG_TAG = "SandboxPackages"
private const val SEARCH_DEBOUNCE_MS = 300L
private const val SEARCH_FETCH_LIMIT = 2000
private const val SEARCH_RESULT_LIMIT = 200
}
