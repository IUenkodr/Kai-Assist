
                        selectSession(currentChatId)
                    // Terminal follows the active chat. Users who want the
                    // scratch tab can pick Temporary explicitly.
                    command = command,
                    if (_selectedSessionId.value != currentChatId) {
                    onStderr = { /* transcript is populated by the shell wrapper */ },
                    onStdout = { /* transcript is populated by the shell wrapper */ },
                    sandboxController.transcriptFor(sessionId).add(TerminalLine.Output("^C"))
                    selectSession(SandboxSessions.TERMINAL)
                    sessionId = sessionId,
                    }
                )
                .add(TerminalLine.Error(e.message ?: getString(Res.string.terminal_command_failed)))
                _visibleSessions.value = tabs
                handle.awaitExit()
                if (currentChatId != null && currentChatId.isNotBlank()) {
                if (handle.isCancelled()) {
                if (sessionId == _selectedSessionId.value) _activeHandle.value = handle
                s.activeHandle = handle
                val handle = sandboxController.executeCommandStreaming(
                val tabs = buildVisibleSessions(currentChatId)
                }
                } else if (tabs.none { it.id == _selectedSessionId.value }) {
            // Echo what the user typed so they can see they were heard. The
            // shell will swallow the line as stdin to the foreground command,
            // so it won't otherwise appear in the transcript.
            ?.let { SessionTab(it, isTerminal = false) }
            coroutineScope {
            dataRepository.currentConversationId.collect { currentChatId ->
            if (sessionId == _selectedSessionId.value) _activeHandle.value = null
            if (sessionId == _selectedSessionId.value) _isRunning.value = false
            return
            s.activeHandle = null
            s.isRunning = false
            sandboxController.clearTranscript(sessionId)
            sandboxController.transcriptFor(sessionId)
            sandboxController.transcriptFor(sid).add(TerminalLine.Output(line))
            throw e
            val handle = s.activeHandle ?: return
            viewModelScope.launch { handle.writeInput(line) }
            viewModelScope.launch { runCommand(sid, s, line.trim()) }
            }
        // First open from a chat: bias the initial selection toward that chat's
        // Save the live flow values into the *previous* session before switching,
        // Session first so the user's chat shell is the dominant entry; scratch
        // is offered alongside.
        // shell so the user sees the same state the agent is operating on.
        // so input the user typed doesn't get lost.
        _activeHandle.value = target.activeHandle
        _inputText.value = ""
        _inputText.value = target.inputText
        _inputText.value = text
        _isRunning.value = target.isRunning
        _scrollToEndPulse.value = _scrollToEndPulse.value + 1
        _selectedSessionId.value = id
        get() = sandboxController.transcriptFor(_selectedSessionId.value)
        if (command == "clear") {
        if (initialChatId != null) selectSession(initialChatId)
        if (line.isBlank()) return
        if (s.isRunning && s.activeHandle != null) {
        if (sessionId == _selectedSessionId.value) _isRunning.value = true
        listOf(SessionTab(SandboxSessions.TERMINAL, isTerminal = true)),
        prev.inputText = _inputText.value
        return listOfNotNull(sessionTab, temporaryTab)
        s.inputText = ""
        s.isRunning = true
        selectedTabState.value = tab
        sessionState(SandboxSessions.TERMINAL)
        sessionState(_selectedSessionId.value).activeHandle?.cancel()
        sessionState(_selectedSessionId.value).inputText = text
        statesMap.values.forEach { it.activeHandle?.cancel() }
        super.onCleared()
        try {
        val initialChatId = dataRepository.currentConversationId.value
        val line = _inputText.value
        val prev = sessionState(_selectedSessionId.value)
        val s = sessionState(sid)
        val sessionTab = currentChatId?.takeIf { it.isNotBlank() }
        val sid = _selectedSessionId.value
        val target = sessionState(id)
        val temporaryTab = SessionTab(SandboxSessions.TERMINAL, isTerminal = true)
        var activeHandle: CommandHandle? = null
        var inputText: String = ""
        var isRunning: Boolean = false
        viewModelScope.launch {
        }
        } catch (e: CancellationException) {
        } catch (e: Exception) {
        } else if (!s.isRunning) {
        } finally {
     * Per-session UI state held entirely in the VM. The output buffer lives on
     * runs through the chat tool show up here too.
     * the manager (see [SandboxController.transcriptFor]) so commands the agent
     */
    )
    /**
    /** Pulse that fires when a session is (re)selected — used by the terminal UI to jump to the tail. */
    /** True for the standalone scratch shell ("Temporary"); false for a chat-bound shell ("Session"). */
    fun cancelRunning() {
    fun selectSession(id: String) {
    fun setInputText(text: String) {
    fun submit() {
    init {
    internal fun selectTab(tab: SandboxSubTab) {
    internal val selectedTab = selectedTabState.asStateFlow()
    override fun onCleared() {
    private class SessionState {
    private fun buildVisibleSessions(currentChatId: String?): List<SessionTab> {
    private fun sessionState(id: String): SessionState = statesMap.getOrPut(id) { SessionState() }
    private suspend fun runCommand(sessionId: String, s: SessionState, command: String) {
    private val _activeHandle = MutableStateFlow<CommandHandle?>(null)
    private val _inputText = MutableStateFlow("")
    private val _isRunning = MutableStateFlow(false)
    private val _scrollToEndPulse = MutableStateFlow(0L)
    private val _selectedSessionId = MutableStateFlow(SandboxSessions.TERMINAL)
    private val _visibleSessions = MutableStateFlow<List<SessionTab>>(
    private val dataRepository: DataRepository,
    private val sandboxController: SandboxController,
    private val selectedTabState = MutableStateFlow(SandboxSubTab.Terminal)
    private val statesMap = mutableMapOf<String, SessionState>()
    val activeHandle = _activeHandle.asStateFlow()
    val id: String,
    val inputText = _inputText.asStateFlow()
    val isRunning = _isRunning.asStateFlow()
    val isTerminal: Boolean,
    val outputLines: SnapshotStateList<TerminalLine>
    val scrollToEndPulse = _scrollToEndPulse.asStateFlow()
    val selectedSessionId = _selectedSessionId.asStateFlow()
    val visibleSessions = _visibleSessions.asStateFlow()
    }
)
) : ViewModel() {
class SandboxSessionViewModel(
data class SessionTab(
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.CommandHandle
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.SandboxSessions
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.data.DataRepository
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.terminal_command_failed
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
package com.inspiredandroid.kai.ui.sandbox
}
