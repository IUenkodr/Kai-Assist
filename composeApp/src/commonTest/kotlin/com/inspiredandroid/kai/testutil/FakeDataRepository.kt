package com.inspiredandroid.kai.testutil
import com.inspiredandroid.kai.data.Conversation
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.EmailSyncState
import com.inspiredandroid.kai.data.FallbackStatus
import com.inspiredandroid.kai.data.FreeMode
import com.inspiredandroid.kai.data.HeartbeatConfig
import com.inspiredandroid.kai.data.HeartbeatLogEntry
import com.inspiredandroid.kai.data.ImportSection
import com.inspiredandroid.kai.data.MemoryEntry
import com.inspiredandroid.kai.data.ScheduledTask
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.ServiceInstance
import com.inspiredandroid.kai.data.SmsDraft
import com.inspiredandroid.kai.data.SmsSyncState
import com.inspiredandroid.kai.data.SystemPromptVariant
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.data.ensureSelectedModelPresent
import com.inspiredandroid.kai.inference.DownloadError
import com.inspiredandroid.kai.inference.DownloadedModel
import com.inspiredandroid.kai.inference.EngineState
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.ModelImportError
import com.inspiredandroid.kai.inference.ModelImportResult
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.mcp.McpServerConfig
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.tools.CommonTools
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.settings.SettingsModel
import io.github.vinceglb.filekit.PlatformFile
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

                    "tool" -> History.Role.TOOL
                    "user" -> History.Role.USER
                    descriptionRes = it.descriptionRes,
                    else -> History.Role.ASSISTANT
                    id = it.id,
                    subtitle = it.subtitle,
                "${service.id}_$counter"
                )
                SettingsModel(
                content = m.content,
                history
                history + History(role = History.Role.USER, content = question, uiSubmission = uiSubmission)
                history.subList(0, lastUserIndex + 1)
                id = m.id,
                role = when (m.role) {
                service.id
                var counter = 2
                while ("${service.id}_$counter" in usedIds) counter++
                },
            "${serviceId}_$counter"
            )
            // Prefill is handled by callers via updateInstanceCustomModelId in production;
            // tests rarely need it — leave blank unless set.
            History(
            chatHistory.update { history ->
            chatHistory.value = emptyList()
            configuredInstances.add(ServiceInstance(instanceId = instanceId, serviceId = service.id))
            currentConversationId.value = null
            ensureSelectedModelPresent(models, modelId)
            history + History(role = History.Role.ASSISTANT, content = "Test response")
            if (index >= 0) history.subList(0, index) else history
            if (lastUserIndex >= 0) history.subList(0, lastUserIndex) else history
            if (lastUserIndex >= 0) {
            mcpConnected.remove(serverId)
            mcpServers[index] = mcpServers[index].copy(isEnabled = enabled)
            mcpTools.remove(serverId)
            memories[index] = memories[index].copy(content = content)
            service.defaultModels.map {
            serviceId
            usedIds.add(instanceId)
            val index = history.indexOfFirst { it.id == messageId }
            val instanceId = if (service.id !in usedIds) {
            val lastUserIndex = history.indexOfLast { it.role == History.Role.USER }
            var counter = 2
            while ("${serviceId}_$counter" in existingIds) counter++
            }
            } else {
            },
        )
        .filter { it.userToggleable }
        // No-op in tests
        MutableStateFlow(
        _smsDrafts.value = _smsDrafts.value.filterNot { it.id == draftId }
        activeSkillId: String?,
        askCalls.add(question to files)
        askException?.let { throw it }
        askGate?.await()
        chatHistory.update { history ->
        chatHistory.value = conversation.messages.map { m ->
        chatHistory.value = emptyList()
        clearHistoryCalls++
        configuredInstances.add(instance)
        configuredInstances.addAll(reordered)
        configuredInstances.clear()
        configuredInstances.removeAll { it.instanceId == instanceId }
        currentConversationId.value = id
        currentConversationId.value = null
        currentService = service
        daemonEnabled = enabled
        dynamicUiEnabled = enabled
        emailAccounts.removeAll { it.id == id }
        emailEnabled = enabled
        emailPollIntervalMinutes = minutes
        files: List<PlatformFile>,
        for (service in services) {
        freeFallbackEnabled = enabled
        freeMode = mode
        freeServicePrimary = false
        freeServicePrimary = primary
        hasUnreadHeartbeat.value = false
        if (!enabled) {
        if (currentConversationId.value == id) {
        if (index >= 0) {
        if (question != null) {
        if (useCustom && instanceCustomModelIds[instanceId].isNullOrBlank()) {
        instanceApiKeys.remove(instanceId)
        instanceApiKeys[instanceId] = apiKey
        instanceBaseUrls.remove(instanceId)
        instanceBaseUrls[instanceId] = baseUrl
        instanceCustomModelIds[instanceId] = modelId
        instanceModels.getOrPut(instanceId) { MutableStateFlow(emptyList()) }.value = models
        instanceModels.remove(instanceId)
        instanceModels[instanceId]?.update { models ->
        instanceModels[instanceId]?.value = emptyList()
        instanceUseCustomModel[instanceId] = useCustom
        interactiveMode = enabled
        lastActiveSkillId = activeSkillId
        mcpConnected.add(serverId)
        mcpConnected.remove(serverId)
        mcpServers.add(config)
        mcpServers.filter { it.isEnabled }.forEach { mcpConnected.add(it.id) }
        mcpServers.removeAll { it.id == serverId }
        mcpTools.remove(serverId)
        memories.removeAll { it.key == key }
        memoryEnabled = enabled
        notificationsEnabled = enabled
        openAssistRequested.value = false
        openAssistRequested.value = true
        openHeartbeatRequested.value = false
        openHeartbeatRequested.value = true
        pendingShareText.value = null
        pendingShareText.value = text
        question: String?,
        regenerateCalls++
        restoreCurrentConversationCalls++
        return Result.success(mcpTools[serverId] ?: emptyList())
        return config
        return instance
        return true
        savedConversations.update { it.filter { c -> c.id != id } }
        scheduledTasks.removeAll { it.id == id }
        schedulingEnabled = enabled
        smsEnabled = enabled
        smsPermissionGranted = true
        smsPollIntervalMinutes = minutes
        smsSendEnabled = enabled
        smsSendPermissionGranted = true
        soulText = text
        storedKaiBuildLaunchAgent = agentId
        storedSandboxDistro = distro
        themeMode = mode
        uiScale = scale
        uiSubmission: com.inspiredandroid.kai.data.UiSubmission?,
        val byId = configuredInstances.associateBy { it.instanceId }
        val config = McpServerConfig(id = id, name = name, url = url, headers = headers)
        val conversation = savedConversations.value.find { it.id == id } ?: return
        val existingIds = configuredInstances.map { it.instanceId }.toSet()
        val id = name.lowercase().replace(Regex("[^a-z0-9]"), "_").take(30)
        val index = mcpServers.indexOfFirst { it.id == serverId }
        val index = memories.indexOfFirst { it.key == key }
        val instance = ServiceInstance(instanceId = instanceId, serviceId = serviceId)
        val instanceId = if (serviceId !in existingIds) {
        val reordered = orderedInstanceIds.mapNotNull { byId[it] }
        val usedIds = mutableSetOf<String>()
        }
        } else {
     * When non-null, [ask] suspends on this gate before doing any work. Tests can use this
     * concurrent ask prevention or to test cancel behavior).
     * to keep an in-flight ask in progress while inspecting state (e.g., to verify
     */
    ) {
    /**
    // Configured services management (instance-based)
    // Conversation management
    // Daemon mode
    // Email management
    // MCP servers
    // Memory management
    // On-device inference (LiteRT)
    // Per-instance settings
    // SMS management
    // Scheduling management
    // Soul (system prompt)
    fun setConfiguredServices(vararg services: Service) {
    fun setCurrentService(service: Service) {
    fun setInstanceApiKey(instanceId: String, apiKey: String) {
    fun setInstanceModels(instanceId: String, models: List<SettingsModel>) {
    override fun addConfiguredService(serviceId: String): ServiceInstance {
    override fun cancelLocalModelDownload() {}
    override fun cancelLocalModelImport() {}
    override fun clearHistory() {
    override fun clearInstanceModels(instanceId: String, service: Service) {
    override fun clearUnreadHeartbeat() {
    override fun consumeOpenAssistRequest() {
    override fun consumeOpenHeartbeatRequest() {
    override fun consumeOpenShareRequest() {
    override fun currentService(): Service = currentService
    override fun exportSettingsToJson(sections: Set<ImportSection>): String = "{}"
    override fun getConfiguredServiceInstances(): List<ServiceInstance> = configuredInstances.toList()
    override fun getEmailAccounts(): List<EmailAccount> = emailAccounts.toList()
    override fun getEmailPollIntervalMinutes(): Int = emailPollIntervalMinutes
    override fun getEmailSyncStates(): Map<String, EmailSyncState> = emptyMap()
    override fun getExportPreview(): Map<ImportSection, String?> = emptyMap()
    override fun getFreeMode(): FreeMode = freeMode
    override fun getHeartbeatConfig(): HeartbeatConfig = HeartbeatConfig()
    override fun getHeartbeatInstanceId(): String? = null
    override fun getHeartbeatLog(): List<HeartbeatLogEntry> = emptyList()
    override fun getHeartbeatPrompt(): String = ""
    override fun getInstalledSkills(): List<com.inspiredandroid.kai.skills.SkillManifest> = skills
    override fun getInstanceApiKey(instanceId: String): String = instanceApiKeys[instanceId] ?: ""
    override fun getInstanceBaseUrl(instanceId: String, service: Service): String = instanceBaseUrls[instanceId] ?: if (service is Service.OpenAICompatible) Service.DEFAULT_OPENAI_COMPATIBLE_BASE_URL else ""
    override fun getInstanceCustomModelId(instanceId: String): String = instanceCustomModelIds[instanceId] ?: ""
    override fun getInstanceModels(instanceId: String, service: Service): StateFlow<List<SettingsModel>> = instanceModels.getOrPut(instanceId) {
    override fun getInstanceUseCustomModel(instanceId: String): Boolean = instanceUseCustomModel[instanceId] ?: false
    override fun getKaiBuildLaunchAgent(): String? = storedKaiBuildLaunchAgent
    override fun getLocalAvailableModels(): List<LocalModel> = emptyList()
    override fun getLocalDownloadError(): StateFlow<DownloadError?>? = null
    override fun getLocalDownloadProgress(): StateFlow<Float?>? = null
    override fun getLocalDownloadedModels(): List<DownloadedModel> = fakeLocalDownloadedModels
    override fun getLocalDownloadingModelId(): StateFlow<String?>? = null
    override fun getLocalEngineState(): StateFlow<EngineState>? = null
    override fun getLocalFreeSpaceBytes(): Long = 0L
    override fun getLocalImportError(): StateFlow<ModelImportError?>? = null
    override fun getLocalImportProgress(): StateFlow<Float?>? = null
    override fun getLocalImportedModels(): List<LocalModel> = emptyList()
    override fun getLocalImportingFileName(): StateFlow<String?>? = null
    override fun getMcpServers(): List<McpServerConfig> = mcpServers.toList()
    override fun getMcpToolsForServer(serverId: String): List<ToolInfo> = mcpTools[serverId] ?: emptyList()
    override fun getMemories(): List<MemoryEntry> = memories.toList()
    override fun getModelContextTokens(modelId: String): Int = 0
    override fun getNotificationSyncState(): com.inspiredandroid.kai.data.NotificationSyncState = com.inspiredandroid.kai.data.NotificationSyncState()
    override fun getPendingEmailCount(): Int = 0
    override fun getPendingNotificationCount(): Int = 0
    override fun getPendingSmsCount(): Int = 0
    override fun getSandboxDistro(): LinuxDistro = storedSandboxDistro
    override fun getScheduledTasks(): List<ScheduledTask> = scheduledTasks.toList()
    override fun getServiceEntries(): List<ServiceEntry> = fakeServiceEntries
    override fun getSmsPollIntervalMinutes(): Int = smsPollIntervalMinutes
    override fun getSmsSyncState(): SmsSyncState = smsSyncState
    override fun getSoulText(): String = soulText
    override fun getThemeMode(): ThemeMode = themeMode
    override fun getToolDefinitions(): List<ToolInfo> = CommonTools.commonToolDefinitions
    override fun getTotalDeviceMemoryBytes(): Long = Long.MAX_VALUE
    override fun getUiScale(): Float = uiScale
    override fun hasSmsPermission(): Boolean = smsPermissionGranted
    override fun hasSmsSendPermission(): Boolean = smsSendPermissionGranted
    override fun importSettingsFromJson(json: String, sections: Set<ImportSection>, replace: Boolean): Int = 0
    override fun isDaemonEnabled(): Boolean = daemonEnabled
    override fun isDynamicUiEnabled(): Boolean = dynamicUiEnabled
    override fun isEmailEnabled(): Boolean = emailEnabled
    override fun isFreeFallbackEnabled(): Boolean = freeFallbackEnabled
    override fun isFreeServicePrimary(): Boolean = freeServicePrimary
    override fun isInteractiveModeActive(): Boolean = interactiveMode
    override fun isLocalInferenceAvailable(): Boolean = localInferenceAvailable
    override fun isMcpServerConnected(serverId: String): Boolean = serverId in mcpConnected
    override fun isMemoryEnabled(): Boolean = memoryEnabled
    override fun isNotificationListenerAccessGranted(): Boolean = notificationListenerAccessGranted
    override fun isNotificationsEnabled(): Boolean = notificationsEnabled
    override fun isSandboxEnabled(): Boolean = true
    override fun isSchedulingEnabled(): Boolean = schedulingEnabled
    override fun isSmsEnabled(): Boolean = smsEnabled
    override fun isSmsSendEnabled(): Boolean = smsSendEnabled
    override fun isUsingSharedKey(): Boolean = currentService == Service.Free
    override fun loadConversation(id: String) {
    override fun loadConversations() {
    override fun openNotificationListenerSettings() {}
    override fun popLastExchange() {
    override fun regenerate() {
    override fun removeConfiguredService(instanceId: String) {
    override fun removeMcpServer(serverId: String) {
    override fun reorderConfiguredServices(orderedInstanceIds: List<String>) {
    override fun requestOpenAssist() {
    override fun requestOpenHeartbeat() {
    override fun requestOpenShare(text: String) {
    override fun restoreCurrentConversation() {
    override fun setDaemonEnabled(enabled: Boolean) {
    override fun setDynamicUiEnabled(enabled: Boolean) {
    override fun setEmailEnabled(enabled: Boolean) {
    override fun setEmailPollIntervalMinutes(minutes: Int) {
    override fun setFreeFallbackEnabled(enabled: Boolean) {
    override fun setFreeMode(mode: FreeMode) {
    override fun setFreeServicePrimary(primary: Boolean) {
    override fun setHeartbeatActiveHours(start: Int, end: Int) {
    override fun setHeartbeatEnabled(enabled: Boolean) {
    override fun setHeartbeatInstanceId(instanceId: String?) {}
    override fun setHeartbeatIntervalMinutes(minutes: Int) {
    override fun setHeartbeatPrompt(text: String) {
    override fun setInteractiveMode(enabled: Boolean) {
    override fun setKaiBuildLaunchAgent(agentId: String?) {
    override fun setMcpServerEnabled(serverId: String, enabled: Boolean) {
    override fun setMemoryEnabled(enabled: Boolean) {
    override fun setModelContextTokens(modelId: String, contextTokens: Int) {}
    override fun setNotificationsEnabled(enabled: Boolean) {
    override fun setSandboxDistro(distro: LinuxDistro) {
    override fun setSandboxEnabled(enabled: Boolean) {
    override fun setSchedulingEnabled(enabled: Boolean) {
    override fun setSmsEnabled(enabled: Boolean) {
    override fun setSmsPollIntervalMinutes(minutes: Int) {
    override fun setSmsSendEnabled(enabled: Boolean) {
    override fun setSoulText(text: String) {
    override fun setThemeMode(mode: ThemeMode) {
    override fun setToolEnabled(toolId: String, enabled: Boolean) {
    override fun setUiScale(scale: Float) {
    override fun startLocalModelDownload(model: LocalModel) {}
    override fun startNewChat() {
    override fun supportedFileExtensions(): List<String> = if (fileAttachmentSupported) listOf("txt", "pdf", "png") else emptyList()
    override fun truncateFrom(messageId: String) {
    override fun updateInstanceApiKey(instanceId: String, apiKey: String) {
    override fun updateInstanceBaseUrl(instanceId: String, baseUrl: String) {
    override fun updateInstanceCustomModelId(instanceId: String, modelId: String) {
    override fun updateInstanceSelectedModel(instanceId: String, service: Service, modelId: String) {
    override fun updateInstanceUseCustomModel(instanceId: String, useCustom: Boolean) {
    override suspend fun addAssistantMessage(content: String) {}
    override suspend fun addMcpServer(name: String, url: String, headers: Map<String, String>): McpServerConfig {
    override suspend fun ask(
    override suspend fun askSilently(question: String): String = ""
    override suspend fun askSilentlyWithInstance(instanceId: String, prompt: String, timeoutMs: Long): String = ""
    override suspend fun askWithTools(prompt: String, instanceId: String?, conversationIdOverride: String?): String = ""
    override suspend fun browseSkillMarketplaces(): Result<List<com.inspiredandroid.kai.skills.RegistrySkillEntry>> = Result.success(emptyList())
    override suspend fun cancelScheduledTask(id: String) {
    override suspend fun clearPendingNotifications() {}
    override suspend fun connectEnabledMcpServers() {
    override suspend fun connectMcpServer(serverId: String): Result<List<ToolInfo>> {
    override suspend fun deleteConversation(id: String) {
    override suspend fun deleteLocalModel(modelId: String) {}
    override suspend fun deleteMemory(key: String) {
    override suspend fun discardSmsDraft(draftId: String) {
    override suspend fun getActiveSystemPrompt(variant: SystemPromptVariant): String? = soulText.ifEmpty { null }
    override suspend fun getOrCreateHeartbeatConversationId(): String = "fake-heartbeat-conversation"
    override suspend fun importLocalModel(source: PlatformFile): ModelImportResult = ModelImportResult.Failure(ModelImportError.COPY_FAILED)
    override suspend fun installBrowsedSkill(entry: com.inspiredandroid.kai.skills.RegistrySkillEntry): Result<com.inspiredandroid.kai.skills.SkillManifest> = Result.failure(NotImplementedError())
    override suspend fun installGitHubSkill(owner: String, repo: String, ref: String, path: String): Result<com.inspiredandroid.kai.skills.SkillManifest> = Result.failure(NotImplementedError())
    override suspend fun pollEmailAccount(accountId: String) {}
    override suspend fun pollSms() {}
    override suspend fun releaseLocalEngine() {}
    override suspend fun removeEmailAccount(id: String) {
    override suspend fun requestSmsPermission(): Boolean {
    override suspend fun requestSmsSendPermission(): Boolean {
    override suspend fun sendSmsDraft(draftId: String): Boolean = true
    override suspend fun uninstallSkill(id: String) {}
    override suspend fun updateMemoryContent(key: String, content: String) {
    override suspend fun validateConnection(service: Service, instanceId: String) {
    override val chatHistory: MutableStateFlow<List<History>> = MutableStateFlow(emptyList())
    override val currentConversationId: MutableStateFlow<String?> = MutableStateFlow(null)
    override val fallbackStatus: MutableStateFlow<FallbackStatus?> = MutableStateFlow(null)
    override val hasUnreadHeartbeat: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val openAssistRequested: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val openHeartbeatRequested: MutableStateFlow<Boolean> = MutableStateFlow(false)
    override val pendingShareText: MutableStateFlow<String?> = MutableStateFlow(null)
    override val savedConversations: MutableStateFlow<List<Conversation>> = MutableStateFlow(emptyList())
    override val smsDrafts: kotlinx.coroutines.flow.StateFlow<List<SmsDraft>> = _smsDrafts
    private val _smsDrafts = kotlinx.coroutines.flow.MutableStateFlow(emptyList<SmsDraft>())
    private val configuredInstances = mutableListOf<ServiceInstance>()
    private val emailAccounts = mutableListOf<EmailAccount>()
    private val instanceApiKeys = mutableMapOf<String, String>()
    private val instanceBaseUrls = mutableMapOf<String, String>()
    private val instanceCustomModelIds = mutableMapOf<String, String>()
    private val instanceModels = mutableMapOf<String, MutableStateFlow<List<SettingsModel>>>()
    private val instanceUseCustomModel = mutableMapOf<String, Boolean>()
    private val mcpConnected = mutableSetOf<String>()
    private val mcpServers = mutableListOf<McpServerConfig>()
    private val mcpTools = mutableMapOf<String, List<ToolInfo>>()
    private val memories = mutableListOf<MemoryEntry>()
    private val scheduledTasks = mutableListOf<ScheduledTask>()
    private var currentService: Service = Service.Free
    private var daemonEnabled = false
    private var dynamicUiEnabled = true
    private var emailEnabled = true
    private var emailPollIntervalMinutes = 15
    private var freeFallbackEnabled = true
    private var freeMode = FreeMode.FAST
    private var freeServicePrimary = false
    private var instanceCounter = 0
    private var interactiveMode = false
    private var memoryEnabled = true
    private var notificationListenerAccessGranted = false
    private var notificationsEnabled = false
    private var schedulingEnabled = true
    private var smsEnabled = false
    private var smsPermissionGranted = false
    private var smsPollIntervalMinutes = 15
    private var smsSendEnabled = false
    private var smsSendPermissionGranted = false
    private var smsSyncState = SmsSyncState()
    private var soulText = ""
    private var themeMode: ThemeMode = ThemeMode.System
    private var uiScale: Float = 1.0f
    val askCalls = mutableListOf<Pair<String?, List<PlatformFile>>>()
    var askException: Exception? = null
    var askGate: CompletableDeferred<Unit>? = null
    var clearHistoryCalls = 0
    var fakeLocalDownloadedModels: List<DownloadedModel> = emptyList()
    var fakeServiceEntries: List<ServiceEntry> = emptyList()
    var fileAttachmentSupported = true
    var lastActiveSkillId: String? = null
    var localInferenceAvailable = false
    var regenerateCalls = 0
    var restoreCurrentConversationCalls = 0
    var skills: List<com.inspiredandroid.kai.skills.SkillManifest> = emptyList()
    var storedKaiBuildLaunchAgent: String? = null
    var storedSandboxDistro: LinuxDistro = LinuxDistro.DEFAULT
    }
class FakeDataRepository : DataRepository {
}
