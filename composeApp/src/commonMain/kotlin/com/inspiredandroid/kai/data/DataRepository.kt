
        activeSkillId: String? = null,
        files: List<PlatformFile>,
        question: String?,
        uiSubmission: UiSubmission? = null,
     * (long-press home / power button) with `ACTION_ASSIST`. `true` means "start a
     * Pulse that fires when another app shares plain text into Kai via Android
     * Pulse that fires when the app is launched via the Android assist gesture
     * Pulse that fires when the user taps a heartbeat push notification while the app is
     * Resolve the persistent heartbeat conversation's id, creating an empty
     * Used by the scheduler to bind the heartbeat / scheduled-task tool calls
     * [Conversation] with [Conversation.TYPE_HEARTBEAT] if none exists yet.
     * `ACTION_SEND`. Non-null means "start a fresh chat, put this text in the
     * `ChatViewModel` in its init block.
     * composer, then call [consumeOpenShareRequest]". Collected by `ChatViewModel`
     * conversation now, then call [consumeOpenHeartbeatRequest]". Collected by
     * fresh chat now, then call [consumeOpenAssistRequest]". Collected by
     * in its init block. The text is not sent until the user taps send.
     * not already on the heartbeat conversation. `true` means "load the heartbeat
     * to a stable sandbox session before the AI starts emitting tool calls.
     */
    )
    /**
    /** Agent a freshly opened Kai Build project starts with; null is a plain shell. */
    /** Distro a fresh sandbox install would use. An existing install keeps its own. */
    // Background ask with tools (no chat history update, supports tool-calling loop).
    // Configured services management
    // Conversation management
    // Daemon mode
    // Dynamic UI
    // Email
    // Export/Import
    // Heartbeat
    // Heartbeat notification
    // Interactive mode
    // Kai Build
    // Linux Sandbox
    // MCP servers
    // Memory management
    // Notifications (FOSS-only on Android; other platforms return stub values).
    // On-device inference (LiteRT)
    // Per-app filtering is delegated to the system Notification Access "Apps" picker.
    // Per-instance settings
    // Read and send are independent opt-ins with separate runtime permissions.
    // SMS (FOSS-only on Android; other platforms return stub values).
    // Scheduling management
    // Silent ask (no tools, no chat history update)
    // Skills (stored in the Linux sandbox at ~/skills/<id>/; Android-only)
    // Soul (system prompt)
    // Theme mode
    // Tool management
    // UI Scale
    // When `conversationIdOverride` is set, tool calls during this run route to that
    // conversation's sandbox session instead of inheriting the active chat's id —
    // in the user's currently-viewed chat shell.
    // used by the heartbeat / scheduled tasks so their shell commands don't land
    fun addConfiguredService(serviceId: String): ServiceInstance
    fun cancelLocalModelDownload()
    fun cancelLocalModelImport()
    fun clearHistory()
    fun clearInstanceModels(instanceId: String, service: Service)
    fun clearUnreadHeartbeat()
    fun consumeOpenAssistRequest()
    fun consumeOpenHeartbeatRequest()
    fun consumeOpenShareRequest()
    fun currentService(): Service
    fun exportSettingsToJson(sections: Set<ImportSection> = ImportSection.entries.toSet()): String
    fun getConfiguredServiceInstances(): List<ServiceInstance>
    fun getEmailAccounts(): List<EmailAccount>
    fun getEmailPollIntervalMinutes(): Int
    fun getEmailSyncStates(): Map<String, EmailSyncState>
    fun getExportPreview(): Map<ImportSection, String?>
    fun getFreeMode(): FreeMode
    fun getHeartbeatConfig(): HeartbeatConfig
    fun getHeartbeatInstanceId(): String?
    fun getHeartbeatLog(): List<HeartbeatLogEntry>
    fun getHeartbeatPrompt(): String
    fun getInstalledSkills(): List<SkillManifest>
    fun getInstanceApiKey(instanceId: String): String
    fun getInstanceBaseUrl(instanceId: String, service: Service): String
    fun getInstanceCustomModelId(instanceId: String): String
    fun getInstanceModels(instanceId: String, service: Service): StateFlow<List<SettingsModel>>
    fun getInstanceUseCustomModel(instanceId: String): Boolean
    fun getKaiBuildLaunchAgent(): String?
    fun getLocalAvailableModels(): List<LocalModel>
    fun getLocalDownloadError(): StateFlow<DownloadError?>?
    fun getLocalDownloadProgress(): StateFlow<Float?>?
    fun getLocalDownloadedModels(): List<DownloadedModel>
    fun getLocalDownloadingModelId(): StateFlow<String?>?
    fun getLocalEngineState(): StateFlow<EngineState>?
    fun getLocalFreeSpaceBytes(): Long
    fun getLocalImportError(): StateFlow<ModelImportError?>?
    fun getLocalImportProgress(): StateFlow<Float?>?
    fun getLocalImportedModels(): List<LocalModel>
    fun getLocalImportingFileName(): StateFlow<String?>?
    fun getMcpServers(): List<McpServerConfig>
    fun getMcpToolsForServer(serverId: String): List<ToolInfo>
    fun getMemories(): List<MemoryEntry>
    fun getModelContextTokens(modelId: String): Int
    fun getNotificationSyncState(): NotificationSyncState
    fun getPendingEmailCount(): Int
    fun getPendingNotificationCount(): Int
    fun getPendingSmsCount(): Int
    fun getSandboxDistro(): LinuxDistro
    fun getScheduledTasks(): List<ScheduledTask>
    fun getServiceEntries(): List<ServiceEntry>
    fun getSmsPollIntervalMinutes(): Int
    fun getSmsSyncState(): SmsSyncState
    fun getSoulText(): String
    fun getThemeMode(): ThemeMode
    fun getToolDefinitions(): List<ToolInfo>
    fun getTotalDeviceMemoryBytes(): Long
    fun getUiScale(): Float
    fun hasSmsPermission(): Boolean
    fun hasSmsSendPermission(): Boolean
    fun importSettingsFromJson(json: String, sections: Set<ImportSection>, replace: Boolean): Int
    fun isDaemonEnabled(): Boolean
    fun isDynamicUiEnabled(): Boolean
    fun isEmailEnabled(): Boolean
    fun isFreeFallbackEnabled(): Boolean
    fun isFreeServicePrimary(): Boolean
    fun isInteractiveModeActive(): Boolean
    fun isLocalInferenceAvailable(): Boolean
    fun isMcpServerConnected(serverId: String): Boolean
    fun isMemoryEnabled(): Boolean
    fun isNotificationListenerAccessGranted(): Boolean
    fun isNotificationsEnabled(): Boolean
    fun isSandboxEnabled(): Boolean
    fun isSchedulingEnabled(): Boolean
    fun isSmsEnabled(): Boolean
    fun isSmsSendEnabled(): Boolean
    fun isUsingSharedKey(): Boolean
    fun loadConversation(id: String)
    fun loadConversations()
    fun openNotificationListenerSettings()
    fun popLastExchange()
    fun regenerate()
    fun removeConfiguredService(instanceId: String)
    fun removeMcpServer(serverId: String)
    fun reorderConfiguredServices(orderedInstanceIds: List<String>)
    fun requestOpenAssist()
    fun requestOpenHeartbeat()
    fun requestOpenShare(text: String)
    fun restoreCurrentConversation()
    fun setDaemonEnabled(enabled: Boolean)
    fun setDynamicUiEnabled(enabled: Boolean)
    fun setEmailEnabled(enabled: Boolean)
    fun setEmailPollIntervalMinutes(minutes: Int)
    fun setFreeFallbackEnabled(enabled: Boolean)
    fun setFreeMode(mode: FreeMode)
    fun setFreeServicePrimary(primary: Boolean)
    fun setHeartbeatActiveHours(start: Int, end: Int)
    fun setHeartbeatEnabled(enabled: Boolean)
    fun setHeartbeatInstanceId(instanceId: String?)
    fun setHeartbeatIntervalMinutes(minutes: Int)
    fun setHeartbeatPrompt(text: String)
    fun setInteractiveMode(enabled: Boolean)
    fun setKaiBuildLaunchAgent(agentId: String?)
    fun setMcpServerEnabled(serverId: String, enabled: Boolean)
    fun setMemoryEnabled(enabled: Boolean)
    fun setModelContextTokens(modelId: String, contextTokens: Int)
    fun setNotificationsEnabled(enabled: Boolean)
    fun setSandboxDistro(distro: LinuxDistro)
    fun setSandboxEnabled(enabled: Boolean)
    fun setSchedulingEnabled(enabled: Boolean)
    fun setSmsEnabled(enabled: Boolean)
    fun setSmsPollIntervalMinutes(minutes: Int)
    fun setSmsSendEnabled(enabled: Boolean)
    fun setSoulText(text: String)
    fun setThemeMode(mode: ThemeMode)
    fun setToolEnabled(toolId: String, enabled: Boolean)
    fun setUiScale(scale: Float)
    fun startLocalModelDownload(model: LocalModel)
    fun startNewChat()
    fun supportedFileExtensions(): List<String>
    fun truncateFrom(messageId: String)
    fun updateInstanceApiKey(instanceId: String, apiKey: String)
    fun updateInstanceBaseUrl(instanceId: String, baseUrl: String)
    fun updateInstanceCustomModelId(instanceId: String, modelId: String)
    fun updateInstanceSelectedModel(instanceId: String, service: Service, modelId: String)
    fun updateInstanceUseCustomModel(instanceId: String, useCustom: Boolean)
    suspend fun addAssistantMessage(content: String)
    suspend fun addMcpServer(name: String, url: String, headers: Map<String, String>): McpServerConfig
    suspend fun ask(
    suspend fun askSilently(question: String): String
    suspend fun askSilentlyWithInstance(instanceId: String, prompt: String, timeoutMs: Long = 0L): String
    suspend fun askWithTools(prompt: String, instanceId: String? = null, conversationIdOverride: String? = null): String
    suspend fun browseSkillMarketplaces(): Result<List<RegistrySkillEntry>>
    suspend fun cancelScheduledTask(id: String)
    suspend fun clearPendingNotifications()
    suspend fun connectEnabledMcpServers()
    suspend fun connectMcpServer(serverId: String): Result<List<ToolInfo>>
    suspend fun deleteConversation(id: String)
    suspend fun deleteLocalModel(modelId: String)
    suspend fun deleteMemory(key: String)
    suspend fun discardSmsDraft(draftId: String)
    suspend fun getActiveSystemPrompt(variant: SystemPromptVariant = SystemPromptVariant.CHAT_REMOTE): String?
    suspend fun getOrCreateHeartbeatConversationId(): String
    suspend fun importLocalModel(source: PlatformFile): ModelImportResult
    suspend fun installBrowsedSkill(entry: RegistrySkillEntry): Result<SkillManifest>
    suspend fun installGitHubSkill(owner: String, repo: String, ref: String, path: String): Result<SkillManifest>
    suspend fun pollEmailAccount(accountId: String)
    suspend fun pollSms()
    suspend fun releaseLocalEngine()
    suspend fun removeEmailAccount(id: String)
    suspend fun requestSmsPermission(): Boolean
    suspend fun requestSmsSendPermission(): Boolean
    suspend fun sendSmsDraft(draftId: String): Boolean
    suspend fun uninstallSkill(id: String)
    suspend fun updateMemoryContent(key: String, content: String)
    suspend fun validateConnection(service: Service, instanceId: String)
    val chatHistory: StateFlow<List<History>>
    val currentConversationId: StateFlow<String?>
    val fallbackStatus: StateFlow<FallbackStatus?>
    val hasUnreadHeartbeat: StateFlow<Boolean>
    val openAssistRequested: StateFlow<Boolean>
    val openHeartbeatRequested: StateFlow<Boolean>
    val pendingShareText: StateFlow<String?>
    val savedConversations: StateFlow<List<Conversation>>
    val smsDrafts: StateFlow<List<SmsDraft>>
import com.inspiredandroid.kai.inference.DownloadError
import com.inspiredandroid.kai.inference.DownloadedModel
import com.inspiredandroid.kai.inference.EngineState
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.ModelImportError
import com.inspiredandroid.kai.inference.ModelImportResult
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.mcp.McpServerConfig
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.skills.RegistrySkillEntry
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.settings.SettingsModel
import io.github.vinceglb.filekit.PlatformFile
import kotlinx.coroutines.flow.StateFlow
interface DataRepository {
package com.inspiredandroid.kai.data
}
