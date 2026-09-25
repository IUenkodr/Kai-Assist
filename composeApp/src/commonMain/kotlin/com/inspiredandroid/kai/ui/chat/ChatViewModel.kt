
                        .firstOrNull { it.type == Conversation.TYPE_HEARTBEAT }?.id
                        clearUnreadHeartbeat()
                        error = UiError.Resource(Res.string.error_local_network_permission),
                        error = exception.toUiError(),
                        isLoading = false,
                        loadConversation(heartbeatId)
                        showFreeProviderSuggestions = false,
                        showFreeProviderSuggestions = showUpsell,
                    )
                    contentId
                    dataRepository.consumeOpenAssistRequest()
                    dataRepository.consumeOpenHeartbeatRequest()
                    dataRepository.consumeOpenShareRequest()
                    error = null,
                    exception = exception,
                    files = persistentListOf(),
                    id = it.id,
                    if (heartbeatId != null) {
                    isHeartbeat = isHeartbeat,
                    isInteractive = isInteractive,
                    isLoading = true,
                    it.copy(
                    it.copy(isLoading = false)
                    it.isSpeakingContentId
                    noConfiguredServices = dataRepository.getConfiguredServiceInstances().isEmpty(),
                    retryIfNoValidKaiUi()
                    showFreeProviderSuggestions = false,
                    startNewChat()
                    startNewChat(composerPrefill = text)
                    title = if (isHeartbeat) "" else it.title.ifEmpty { getString(Res.string.conversation_untitled) },
                    updatedAt = it.updatedAt,
                    val heartbeatId = dataRepository.savedConversations.value
                    }
                "JSON parse error in: ${errorBlock.rawJson.take(200)}"
                "No kai-ui code fence found in your response."
                "Remember: respond with ONLY a single ```kai-ui code fence containing valid JSON. No text outside the fence."
                )
                .collect {
                .collect { text ->
                .filter { it }
                .filterNotNull()
                // Auto-retry in interactive mode if the response has no valid kai-ui
                // CancellationException must be re-thrown to properly propagate coroutine cancellation
                ConversationSummary(
                _state.update {
                _state.update { it.copy(fallbackStatus = status) }
                _state.update { it.copy(smsDrafts = drafts.toImmutableList()) }
                composerPrefill = composerPrefill,
                composerPrefill = null,
                dataRepository.ask(strippedQuestion, files, uiSubmission, activeSkillId)
                dataRepository.openAssistRequested.value
                dataRepository.restoreCurrentConversation()
                error = null,
                icon = mode.icon,
                if (_state.value.isInteractiveMode) {
                if (exception is CancellationException) throw exception
                instanceId = mode.instanceId,
                isInteractiveMode = false,
                isInteractiveMode = isInteractive,
                isInteractiveMode = true,
                isLoading = false,
                isSpeaking = isSpeaking,
                isSpeakingContentId = if (isSpeaking) {
                isSpeechOutputEnabled = !it.isSpeechOutputEnabled,
                it.copy(
                it.copy(snackbarMessage = Res.string.error_unsupported_file_type)
                modelId = "",
                presetInteractiveModeForCurrentConversation()
                return@launch
                serviceId = Service.Free.id,
                serviceName = freeModeNames.getValue(mode),
                showFreeProviderSuggestions = false,
                val isHeartbeat = it.type == Conversation.TYPE_HEARTBEAT
                val isInteractive = it.type == Conversation.TYPE_INTERACTIVE
                val showUpsell = shouldShowFreeProviderSuggestions(
                }
                } else {
                },
            "Pressed: $event"
            "Responded with: $formattedData"
            )
            .map {
            .sortedByDescending { it.updatedAt }
            // ACTION_SEND or ACTION_ASSIST.
            // Android 17+ blocks LAN traffic without the local network permission — without
            // Build error feedback for the AI
            // Go back to initial prompt — clear history but stay in interactive mode
            // Share and assist both want a fresh chat. Skip restore so a slow
            // asking first, requests to self-hosted servers silently never leave the device.
            // load cannot clobber startNewChat() when Kai is cold-started from
            ?: return text to null
            Res.string.litert_no_model_warning
            ServiceEntry(
            UiSubmission(sourceContent = it.content, values = data, pressedEvent = event)
            _state.update {
            _state.update { it.copy(isRestoring = false) }
            _state.update { it.copy(pendingConversationDeletion = null) }
            actions = actions,
            configuredEntries + freeModes
            conversation.type == Conversation.TYPE_INTERACTIVE
            currentConversationId = conversationId,
            currentCoroutineContext().ensureActive()
            dataRepository.ask(retryMessage, emptyList())
            dataRepository.clearHistory()
            dataRepository.connectEnabledMcpServers()
            dataRepository.deleteConversation(id)
            dataRepository.deleteConversation(pendingId)
            dataRepository.discardSmsDraft(draftId)
            dataRepository.fallbackStatus.collect { status ->
            dataRepository.isInteractiveModeActive()
            dataRepository.loadConversations()
            dataRepository.openAssistRequested
            dataRepository.openHeartbeatRequested
            dataRepository.pendingShareText
            dataRepository.popLastExchange()
            dataRepository.restoreCurrentConversation()
            dataRepository.sendSmsDraft(draftId)
            dataRepository.setFreeMode(freeMode)
            dataRepository.setFreeServicePrimary(true)
            dataRepository.smsDrafts.collect { drafts ->
            delay(4.seconds)
            freeModes + configuredEntries
            hasUnreadHeartbeat = hasUnreadHeartbeat,
            history = history.toImmutableList(),
            if (!ensureLocalNetworkPermission()) {
            if (!skipRestore) {
            if (hasValidUi) return
            installedSkills = dataRepository.getInstalledSkills().toImmutableList(),
            it.copy(
            it.copy(error = null, showFreeProviderSuggestions = false)
            it.copy(files = (it.files + file).toImmutableList())
            it.copy(files = it.files.filterNot { f -> f == file }.toImmutableList())
            it.copy(isLoading = false)
            it.copy(snackbarMessage = null)
            null
            presetInteractiveModeForCurrentConversation()
            return
            savedConversations = summaries.toImmutableList(),
            showPrivacyInfo = dataRepository.isUsingSharedKey(),
            supportedFileExtensions = dataRepository.supportedFileExtensions().toImmutableList(),
            try {
            updateAvailableServices()
            val blocks = parseMarkdown(lastAssistant.content).blocks
            val errorBlock = blocks.filterIsInstance<KaiUiError>().firstOrNull()
            val errorDetail = if (errorBlock != null) {
            val formattedData = data.entries.joinToString(", ") { "${it.key}: ${it.value}" }
            val hasValidUi = blocks.any { it is KaiUiBlock }
            val lastAssistant = dataRepository.chatHistory.value.lastRenderedAssistant() ?: return
            val retryMessage = "[SYSTEM] Your previous response failed to render as interactive UI. $errorDetail " +
            val skipRestore = dataRepository.pendingShareText.value != null ||
            }
            } catch (exception: Exception) {
            } else {
        )
        ),
        // Android foreground service). Reset the predicate so the daemon path keeps
        // Capture files before launching coroutine to avoid race with files being cleared
        // ChatScreen gates the interactive-mode branch on !isRestoring to avoid a flash.
        // Keep restoreCurrentConversation off the main thread; see issue #197 (large persisted
        // Prevent concurrent requests
        // The scheduler lives longer than this ViewModel (it's a singleton driving the
        // on Android — ViewModel lifecycle is too narrow (survives backgrounding).
        // running without a stale reference to a dead state flow. The foreground-visible
        // signal (`appInForeground`) is tracked separately via `ProcessLifecycleOwner`
        // tool outputs caused ANRs when JSON-decoded synchronously during VM construction).
        ChatUiState(
        _state,
        _state.update {
        _state.update { it.copy(availableServices = entries, warning = warning, showPrivacyInfo = dataRepository.isUsingSharedKey()) }
        _state.update { it.copy(composerPrefill = null) }
        _state.update { it.copy(isInteractiveMode = isInteractive) }
        _state.update { it.copy(pendingConversationDeletion = id) }
        _state.update { it.copy(pendingConversationDeletion = null) }
        addFile = ::addFile,
        ask = ::ask,
        ask(null)
        askInternal(message, submission)
        askInternal(question, null)
        cancel = ::cancel,
        clearHistory = ::clearHistory,
        clearSnackbar = ::clearSnackbar,
        clearUnreadHeartbeat = ::clearUnreadHeartbeat,
        commitPendingConversationDeletion()
        consumeComposerPrefill = ::consumeComposerPrefill,
        currentJob = null
        currentJob = viewModelScope.launch(backgroundDispatcher) {
        currentJob?.cancel()
        dataRepository.chatHistory,
        dataRepository.clearHistory()
        dataRepository.clearUnreadHeartbeat()
        dataRepository.currentConversationId,
        dataRepository.hasUnreadHeartbeat,
        dataRepository.loadConversation(id)
        dataRepository.regenerate()
        dataRepository.reorderConfiguredServices(reordered)
        dataRepository.savedConversations,
        dataRepository.setFreeServicePrimary(false)
        dataRepository.setInteractiveMode(false)
        dataRepository.setInteractiveMode(isInteractive)
        dataRepository.setInteractiveMode(true)
        dataRepository.startNewChat()
        dataRepository.truncateFrom(messageId)
        deleteConversation = ::deleteConversation,
        discardSmsDraft = ::discardSmsDraft,
        enterInteractiveMode = ::enterInteractiveMode,
        exitInteractiveMode = ::exitInteractiveMode,
        goBackInteractiveMode = ::goBackInteractiveMode,
        if (!isLocalNetworkUrl(baseUrl)) return true
        if (!trimmed.startsWith('/')) return text to null
        if (_state.value.isLoading) return
        if (ext.isEmpty() || ext !in supported) {
        if (freeMode != null) {
        if (instanceId !in currentIds) return
        if (rawId.isEmpty()) return text to null
        if (text == null) return null to null
        if (userCount <= 1) {
        initialValue = _state.value,
        loadConversation = ::loadConversation,
        pendingConversationDeleteJob = null
        pendingConversationDeleteJob = viewModelScope.launch(backgroundDispatcher) {
        pendingConversationDeleteJob?.cancel()
        private val FREE_MODE_INSTANCE_IDS = FreeMode.entries.associateBy { it.instanceId }
        regenerate = ::regenerate,
        removeFile = ::removeFile,
        repeat(maxRetries) {
        resubmit = ::resubmit,
        retry = ::retry,
        return localNetworkPermissionController.requestPermission()
        return text to skill.id
        scope = viewModelScope,
        selectService = ::selectService,
        sendSmsDraft = ::sendSmsDraft,
        setIsSpeaking = ::setIsSpeaking,
        startNewChat = { startNewChat() },
        started = SharingStarted.WhileSubscribed(5_000),
        state.copy(
        submitUiCallback = ::submitUiCallback,
        submitUiCallback(event, data)
        super.onCleared()
        taskScheduler.isLoadingCheck = { _state.value.isLoading }
        taskScheduler.isLoadingCheck = { false }
        taskScheduler.start()
        toggleSpeechOutput = ::toggleSpeechOutput,
        undoDeleteConversation = ::undoDeleteConversation,
        updateAvailableServices()
        val (strippedQuestion, activeSkillId) = parseSkillInvocation(question)
        val baseUrl = dataRepository.getInstanceBaseUrl(instance.instanceId, Service.fromId(instance.serviceId))
        val configuredEntries = dataRepository.getServiceEntries()
        val conversation = dataRepository.savedConversations.value.find { it.id == currentId }
        val conversation = dataRepository.savedConversations.value.find { it.id == id }
        val currentFreeMode = dataRepository.getFreeMode()
        val currentId = dataRepository.currentConversationId.value
        val currentIds = instances.map { it.instanceId }
        val entries = if (freeIsPrimary) {
        val ext = file.extension.lowercase()
        val files = _state.value.files
        val firstSpace = trimmed.indexOfFirst { it.isWhitespace() }
        val freeIsPrimary = dataRepository.isFreeServicePrimary() || configuredEntries.isEmpty()
        val freeMode = FREE_MODE_INSTANCE_IDS[instanceId]
        val freeModes = (listOf(currentFreeMode) + FreeMode.entries.filter { it != currentFreeMode }).map { mode ->
        val instance = dataRepository.getConfiguredServiceInstances().firstOrNull() ?: return true
        val instances = dataRepository.getConfiguredServiceInstances()
        val isInteractive = conversation?.type == Conversation.TYPE_INTERACTIVE
        val isInteractive = if (conversation != null) {
        val lastAssistant = dataRepository.chatHistory.value.lastRenderedAssistant()
        val message = if (data.isNotEmpty()) {
        val pendingId = _state.value.pendingConversationDeletion ?: return
        val primaryService = entries.firstOrNull()?.let { Service.fromId(it.serviceId) }
        val rawId = if (firstSpace < 0) trimmed.substring(1) else trimmed.substring(1, firstSpace)
        val reordered = listOf(instanceId) + currentIds.filter { it != instanceId }
        val skill = dataRepository.getInstalledSkills().firstOrNull { it.id.equals(rawId, ignoreCase = true) }
        val submission = lastAssistant?.let {
        val summaries = conversations
        val supported = dataRepository.supportedFileExtensions()
        val trimmed = text.trimStart()
        val userCount = dataRepository.chatHistory.value.count { it.role == History.Role.USER }
        val warning = if (primaryService?.isOnDevice == true && dataRepository.getLocalDownloadedModels().isEmpty()) {
        viewModelScope.launch {
        viewModelScope.launch(backgroundDispatcher) {
        }
        } else {
        }.toImmutableList()
     * If [text] begins with `/<skill-id>`, look up the skill among the currently-
     * Resolves the interactive mode flag from the currently-loaded conversation, or — when
     * True unless the active service points at a local network host and the user
     * denied the local network permission. Cheap no-op on non-Android platforms.
     * how to parse the args after the slash command. Falls through with null skill
     * id when no match — slash commands are opt-in.
     * installed-and-enabled skills and return its id alongside the verbatim user
     * text. The text is sent unchanged so the conversation visibly reflects what
     * the user typed; the skill's instructions in the system prompt tell the model
     * there is no loaded conversation (new empty chat) — falls back to the persisted flag.
     */
    )
    ) { state, history, conversations, conversationId, hasUnreadHeartbeat ->
    /**
    companion object {
    fun refreshSettings() {
    init {
    override fun onCleared() {
    private fun addFile(file: PlatformFile) {
    private fun ask(question: String?) {
    private fun askInternal(question: String?, uiSubmission: UiSubmission?) {
    private fun cancel() {
    private fun clearHistory() {
    private fun clearSnackbar() {
    private fun clearUnreadHeartbeat() {
    private fun commitPendingConversationDeletion() {
    private fun consumeComposerPrefill() {
    private fun deleteConversation(id: String) {
    private fun discardSmsDraft(draftId: String) {
    private fun enterInteractiveMode() {
    private fun exitInteractiveMode() {
    private fun goBackInteractiveMode() {
    private fun loadConversation(id: String) {
    private fun parseSkillInvocation(text: String?): Pair<String?, String?> {
    private fun presetInteractiveModeForCurrentConversation() {
    private fun regenerate() {
    private fun removeFile(file: PlatformFile) {
    private fun resubmit(messageId: String, event: String, data: Map<String, String>) {
    private fun retry() {
    private fun selectService(instanceId: String) {
    private fun sendSmsDraft(draftId: String) {
    private fun setIsSpeaking(isSpeaking: Boolean, contentId: String) {
    private fun startNewChat(composerPrefill: String? = null) {
    private fun submitUiCallback(event: String, data: Map<String, String>) {
    private fun toggleSpeechOutput() {
    private fun undoDeleteConversation() {
    private fun updateAvailableServices() {
    private suspend fun ensureLocalNetworkPermission(): Boolean {
    private suspend fun retryIfNoValidKaiUi(maxRetries: Int = 2) {
    private val _state = MutableStateFlow(
    private val actions = ChatActions(
    private val backgroundDispatcher: CoroutineContext = getBackgroundDispatcher(),
    private val dataRepository: DataRepository,
    private val freeModeNames: Map<FreeMode, String> = FreeMode.entries.associateWith { "Free ${it.modelId.replaceFirstChar { c -> c.uppercase() }}" }
    private val localNetworkPermissionController: PermissionController = PermissionController(AppPermission.LOCAL_NETWORK),
    private val taskScheduler: TaskScheduler,
    private var currentJob: Job? = null
    private var pendingConversationDeleteJob: Job? = null
    val state = combine(
    }
    }.distinctUntilChanged().stateIn(
) : ViewModel() {
class ChatViewModel(
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.data.Conversation
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.data.FreeMode
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.data.UiSubmission
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.network.UiError
import com.inspiredandroid.kai.network.shouldShowFreeProviderSuggestions
import com.inspiredandroid.kai.network.toUiError
import com.inspiredandroid.kai.tools.AppPermission
import com.inspiredandroid.kai.tools.PermissionController
import com.inspiredandroid.kai.tools.isLocalNetworkUrl
import com.inspiredandroid.kai.ui.markdown.KaiUiBlock
import com.inspiredandroid.kai.ui.markdown.KaiUiError
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.extension
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.conversation_untitled
import kai.composeapp.generated.resources.error_local_network_permission
import kai.composeapp.generated.resources.error_unsupported_file_type
import kai.composeapp.generated.resources.litert_no_model_warning
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.seconds
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
package com.inspiredandroid.kai.ui.chat
}
