import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.KaiBuildController
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalKeyEncoder
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
import com.inspiredandroid.kai.data.DataRepository
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toImmutableSet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn

            (current + id).toImmutableSet()
            (current - id).toImmutableSet()
            applicationCursorKeys = controller.state.value.activeSession?.terminal?.applicationCursorKeys ?: false,
            build = build,
            build = controller.state.value,
            controller.startSession(name, launchAgentId.value.installedIn(controller.state.value))
            key = key,
            launchAgentId = launchAgent.installedIn(build),
            launchAgentId = launchAgentId.value.installedIn(controller.state.value),
            modifiers = modifiers,
            openProject = project,
            openProject.value = null
            selectedAgents = selected,
        )
        ),
        KaiBuildUiState(
        controller.closeSession(id)
        controller.createProject(name)?.let(::openProject)
        controller.install(setOf(id))
        controller.refresh()
        controller.renameProject(name, newName)
        controller.startSession(project, agentId)
        controller.state,
        controller.writeToTerminal(TerminalKeyEncoder.encodeText(text, modifiers))
        controller.writeToTerminal(encoded)
        controller.writeToTerminal(report)
        controller.writeToTerminal(text)
        dataRepository.setKaiBuildLaunchAgent(agentId)
        if (!controller.resumeProject(name)) {
        if (controller.state.value.sessions.none { it.project == project }) {
        if (openProject.value == null || report.isEmpty()) return
        if (openProject.value == null || text.isEmpty()) return
        if (openProject.value == null) return
        initialValue = KaiBuildUiState(
        launchAgentId,
        launchAgentId.value = agentId
        openProject,
        openProject.value = name
        openProject.value = null
        openProject.value?.let(controller::leaveProject)
        scope = viewModelScope,
        selectedAgents,
        selectedAgents.value = (selectedAgents.value + id).toImmutableSet()
        selectedAgents.value = if (id in current) {
        started = SharingStarted.WhileSubscribed(5_000),
        val current = selectedAgents.value
        val encoded = TerminalKeyEncoder.encode(
        val project = openProject.value ?: return
        }
        } else {
     * Drops a remembered agent that the environment no longer has — the choice
     * Picks what the next opened project starts with; null is a plain shell.
     * Remembered across app runs — the row is a preference, not a per-visit pick.
     * Sends a mouse report for a touch on the cell grid. Already encoded by the
     * grid, which is the only place that knows which cell was under the finger.
     * outlives an uninstall, and starting a session on a binary that is gone
     * would only print "command not found".
     */
    )
    ) { build, selected, launchAgent, project ->
    /**
    /** Agent a project opens with — null means a plain shell. */
    /** Agents ticked on the setup screen, before Debian exists. */
    /** Both are offered from the list only, so neither can pull the ground from under an open project. */
    /** Closes one tab; closing the last one of the project steps back to the list. */
    /** Installs a single agent into an environment that is already set up. */
    /** Non-null while the user is inside a project's terminal. */
    /** Opens another session in the project the user is already in. */
    /** Opens the project on the shells it already had, or starts its first one. */
    /** Sends characters typed on the soft or hardware keyboard, one press at a time. */
    /** Sends one key press from the key row (arrows, Esc, Ctrl+C, Shift+Tab, …). */
    /** Steps back to the list; the project's shells keep running until closed. */
    /** Submits a finished input line (caller includes the trailing carriage return). */
    // main thread once per terminal repaint.
    // viewModelScope is Main.immediate, so without this the merge runs on the
    fun cancel() = controller.cancel()
    fun closeProject() {
    fun closeSession(id: String) {
    fun createProject(name: String) {
    fun deleteProject(name: String) = controller.deleteProject(name)
    fun install() = controller.install(selectedAgents.value)
    fun installAgent(id: String) {
    fun openProject(name: String) {
    fun renameProject(name: String, newName: String) {
    fun resizeTerminal(columns: Int, rows: Int) = controller.resizeTerminal(columns, rows)
    fun selectSession(id: String) = controller.selectSession(id)
    fun sendKey(key: TerminalKey, modifiers: TerminalModifiers) {
    fun sendMouse(report: String) {
    fun sendText(text: String, modifiers: TerminalModifiers) {
    fun setLaunchAgent(agentId: String?) {
    fun startSession(agentId: String?) {
    fun submitLine(text: String) {
    fun toggleAgent(id: String) {
    fun uninstall() = controller.uninstall()
    init {
    private fun String?.installedIn(build: KaiBuildState): String? = this?.takeIf { it in build.installedAgents }
    private val controller: KaiBuildController,
    private val dataRepository: DataRepository,
    private val launchAgentId = MutableStateFlow(dataRepository.getKaiBuildLaunchAgent())
    private val openProject = MutableStateFlow<String?>(null)
    private val selectedAgents = MutableStateFlow<ImmutableSet<String>>(persistentSetOf())
    val build: KaiBuildState = KaiBuildState(),
    val launchAgentId: String? = null,
    val openProject: String? = null,
    val selectedAgents: ImmutableSet<String> = persistentSetOf(),
    val uiState: StateFlow<KaiBuildUiState> = combine(
    }
    }.flowOn(Dispatchers.Default).stateIn(
)
) : ViewModel() {
@Immutable
class KaiBuildViewModel(
data class KaiBuildUiState(
package com.inspiredandroid.kai.ui.build
}
