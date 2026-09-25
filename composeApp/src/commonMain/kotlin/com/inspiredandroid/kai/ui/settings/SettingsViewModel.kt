package com.inspiredandroid.kai.ui.settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredandroid.kai.DaemonController
import com.inspiredandroid.kai.Platform
import com.inspiredandroid.kai.currentPlatform
import com.inspiredandroid.kai.data.DataRepository
import com.inspiredandroid.kai.data.ImportSection
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.data.supportsAgenticFlows
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.httpClient
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.ModelImportResult
import com.inspiredandroid.kai.isEmailSupported
import com.inspiredandroid.kai.isNotificationsSupported
import com.inspiredandroid.kai.isSmsSupported
import com.inspiredandroid.kai.mcp.PopularMcpServer
import com.inspiredandroid.kai.network.AnthropicInsufficientCreditsException
import com.inspiredandroid.kai.network.AnthropicInvalidApiKeyException
import com.inspiredandroid.kai.network.AnthropicOverloadedException
import com.inspiredandroid.kai.network.AnthropicRateLimitExceededException
import com.inspiredandroid.kai.network.GeminiInvalidApiKeyException
import com.inspiredandroid.kai.network.GeminiRateLimitExceededException
import com.inspiredandroid.kai.network.OpenAICompatibleConnectionException
import com.inspiredandroid.kai.network.OpenAICompatibleInvalidApiKeyException
import com.inspiredandroid.kai.network.OpenAICompatibleQuotaExhaustedException
import com.inspiredandroid.kai.network.OpenAICompatibleRateLimitExceededException
import com.inspiredandroid.kai.network.dtos.SponsorsResponseDto
import com.inspiredandroid.kai.skills.parseGitHubSkillUrl
import com.inspiredandroid.kai.tools.AppPermission
import com.inspiredandroid.kai.tools.PermissionController
import com.inspiredandroid.kai.tools.isLocalNetworkUrl
import io.github.vinceglb.filekit.PlatformFile
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.error_unknown
import kai.composeapp.generated.resources.error_unrecognized_github_repo
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toPersistentSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.getString

                                entry.instanceId,
                                entry.service,
                                result.modelId,
                            )
                            currentSponsors = dto.sponsors.current.toImmutableList(),
                            customModelId = dataRepository.getInstanceCustomModelId(instanceId),
                            dataRepository.deleteLocalModel(it.id)
                            dataRepository.updateInstanceSelectedModel(
                            if (tool.id == toolId) tool.copy(isEnabled = enabled) else tool
                            isInstallingSkill = false,
                            models = models.toImmutableList(),
                            pastSponsors = dto.sponsors.past.toImmutableList(),
                            selectedModel = models.firstOrNull { it.isSelected },
                            skillInstallError = message,
                            smsPendingCount = dataRepository.getPendingSmsCount(),
                            smsSyncState = dataRepository.getSmsSyncState(),
                            useCustomModel = useCustom,
                        )
                        .filter { it.service.isOnDevice }
                        .forEach { entry ->
                        ConnectionStatus.Error
                        ConnectionStatus.ErrorConnectionFailed
                        ConnectionStatus.ErrorInvalidKey
                        ConnectionStatus.ErrorQuotaExhausted
                        ConnectionStatus.ErrorRateLimited
                        Service.fromId(it.serviceId).isOnDevice
                        _state.update { it.copy(localFreeSpaceBytes = dataRepository.getLocalFreeSpaceBytes()) }
                        dataRepository.getLocalDownloadedModels().forEach {
                        e
                        e.copy(
                        e.copy(apiKey = apiKey, connectionStatus = ConnectionStatus.Unknown)
                        e.copy(baseUrl = baseUrl, connectionStatus = ConnectionStatus.Unknown)
                        else -> 2
                        emailAccounts = dataRepository.getEmailAccounts().toImmutableList(),
                        emailPendingCount = dataRepository.getPendingEmailCount(),
                        emailSyncStates = dataRepository.getEmailSyncStates().toImmutableMap(),
                        entry
                        entry.copy(connectionStatus = preservedStatus)
                        entry.copy(connectionStatus = status)
                        it is Service.AtlasCloud -> 1
                        it is Service.OpenAICompatible || it.isOnDevice -> 0
                        it.copy(
                        json(Json { ignoreUnknownKeys = true })
                        localDownloadError = error,
                        localDownloadProgress = progress,
                        localDownloadingModelId = modelId,
                        localImportError = error,
                        localImportProgress = progress,
                        localImportingFileName = name,
                        tools = server.tools.map { tool ->
                        }
                        }.toImmutableList(),
                    )
                    // Auto-select the imported model on every LiteRT instance.
                    // Download finished or cancelled — refresh
                    // First poll seeds lastSeenId to the current inbox max, so the AI
                    // Only preserve transient statuses (Connecting/Error) — derive Connected/Unknown from actual state
                    // importError flow already updated by the engine
                    // isn't drowned in historical messages on opt-in.
                    _state.update {
                    _state.update { it.copy(isInstallingSkill = false, showAddSkillDialog = false) }
                    _state.update { it.copy(localFreeSpaceBytes = dataRepository.getLocalFreeSpaceBytes()) }
                    _state.value.configuredServices
                    browsableSkills = result.getOrNull().orEmpty().toImmutableList(),
                    browseSkillsFailed = result.isFailure,
                    dataRepository.pollSms()
                    dataRepository.setSmsEnabled(true)
                    else -> ConnectionStatus.Error
                    emailPendingCount = dataRepository.getPendingEmailCount(),
                    emailSyncStates = dataRepository.getEmailSyncStates().toImmutableMap(),
                    heartbeatLog = dataRepository.getHeartbeatLog().toImmutableList(),
                    if (!hasOtherOnDevice) {
                    if (e.instanceId != instanceId) {
                    if (e.instanceId == instanceId) e.copy(customModelId = modelId) else e
                    if (e.instanceId == instanceId) {
                    if (entry.id == serverId) entry.copy(connectionStatus = status) else entry
                    if (entry.instanceId == instanceId) {
                    if (preservedStatus == McpConnectionStatus.Connecting || preservedStatus == McpConnectionStatus.Error) {
                    if (tool.id == toolId) tool.copy(isEnabled = enabled) else tool
                    install(ContentNegotiation) {
                    is AnthropicOverloadedException ->
                    is OpenAICompatibleConnectionException ->
                    is OpenAICompatibleInvalidApiKeyException, is GeminiInvalidApiKeyException, is AnthropicInvalidApiKeyException ->
                    is OpenAICompatibleQuotaExhaustedException, is AnthropicInsufficientCreditsException ->
                    is OpenAICompatibleRateLimitExceededException, is GeminiRateLimitExceededException, is AnthropicRateLimitExceededException ->
                    isBrowsingSkills = false,
                    isRefreshingHeartbeat = false,
                    isRefreshingSms = false,
                    it.copy(
                    notificationListenerAccessGranted = dataRepository.isNotificationListenerAccessGranted(),
                    notificationListenerBound = dataRepository.getNotificationSyncState().listenerBound,
                    notificationPendingCount = dataRepository.getPendingNotificationCount(),
                    refreshLocalModelsAfterChange()
                    refreshSkills()
                    refreshingEmailAccountIds = (it.refreshingEmailAccountIds - id).toPersistentSet(),
                    server.copy(
                    smsPendingCount = dataRepository.getPendingSmsCount(),
                    smsPermissionGranted = dataRepository.hasSmsPermission(),
                    smsSyncState = dataRepository.getSmsSyncState(),
                    updateConnectionStatus(instanceId, ConnectionStatus.Connected)
                    updateConnectionStatus(instanceId, ConnectionStatus.Unknown)
                    val dto = response.body<SponsorsResponseDto>()
                    val hasOtherOnDevice = dataRepository.getConfiguredServiceInstances().any {
                    val message = error.message ?: getString(Res.string.error_unknown)
                    val preservedStatus = existingStatuses[entry.id]
                    when {
                    }
                    } else {
                )
                // If removing the last on-device service, delete all downloaded models
                // Lazily fetch the marketplaces the first time the dialog opens.
                // Silently ignore - sponsors are non-critical
                McpConnectionStatus.Connected
                McpConnectionStatus.Unknown
                Triple(modelId, progress, error)
                Triple(name, progress, error)
                _state.update {
                _state.update { it.copy(memories = dataRepository.getMemories().toImmutableList()) }
                _state.update { it.copy(scheduledTasks = dataRepository.getScheduledTasks().toImmutableList()) }
                _state.update { it.copy(skillInstallError = getString(Res.string.error_unrecognized_github_repo)) }
                _state.update { it.copy(smsPermissionGranted = granted, isSmsEnabled = granted) }
                _state.update { it.copy(smsSendPermissionGranted = granted, isSmsSendEnabled = granted) }
                availableServicesToAdd = computeAvailableServices().toImmutableList(),
                browseSkillsFailed = if (show) it.browseSkillsFailed else false,
                compareBy<Service> {
                configuredServices = newEntries.toImmutableList(),
                configuredServices = state.configuredServices.map { e ->
                configuredServices = state.configuredServices.map { entry ->
                connectMcpServerWithStatus(server.id)
                connectMcpServerWithStatus(serverId)
                dataRepository.cancelScheduledTask(deletion.id)
                dataRepository.deleteMemory(deletion.key)
                dataRepository.removeConfiguredService(deletion.instanceId)
                dataRepository.removeEmailAccount(deletion.id)
                dataRepository.removeMcpServer(deletion.serverId)
                dataRepository.uninstallSkill(deletion.id)
                dataRepository.validateConnection(service, instanceId)
                expandedServiceId = if (it.expandedServiceId == instanceId) null else it.expandedServiceId,
                if (granted) dataRepository.setSmsSendEnabled(true)
                if (granted) {
                if (modelId == null && wasDownloading) {
                if (preservedStatus != null) entry.copy(connectionStatus = preservedStatus) else entry
                if (response.status.isSuccess()) {
                if (service.isOnDevice && dataRepository.getLocalDownloadedModels().isEmpty()) {
                if (service?.isOnDevice == true) {
                is ModelImportResult.Failure -> {
                is ModelImportResult.Success -> {
                isNotificationsEnabled = enabled,
                it.copy(
                localFreeSpaceBytes = dataRepository.getLocalFreeSpaceBytes(),
                localImportedModels = dataRepository.getLocalImportedModels().toImmutableList(),
                mcpServers = buildMcpServerEntries().map { entry ->
                mcpServers = state.mcpServers.map { entry ->
                mcpServers = state.mcpServers.map { server ->
                modelContextTokens = buildModelContextTokensMap(),
                notificationListenerAccessGranted = dataRepository.isNotificationListenerAccessGranted(),
                onFailure = { error ->
                onSuccess = {
                pendingDeletion = PendingDeletion.Service(instanceId),
                refreshInstanceModels(instanceId)
                refreshMcpServers()
                refreshServiceList()
                refreshSkills()
                return@launch
                showAddSkillDialog = show,
                skillInstallError = null,
                state.copy(
                tools = state.tools.map { tool ->
                updateConnectionStatus(instanceId, ConnectionStatus.ErrorLocalNetworkDenied)
                updateConnectionStatus(instanceId, status)
                val client = httpClient {
                val granted = dataRepository.requestSmsPermission()
                val granted = dataRepository.requestSmsSendPermission()
                val preservedStatus = existingStatuses[entry.instanceId]
                val response = client.get("https://ghs.vercel.app/v3/sponsors/SimonSchubert")
                val service = _state.value.configuredServices.find { it.instanceId == deletion.instanceId }?.service
                val status = when (e) {
                val wasDownloading = _state.value.localDownloadingModelId != null
                }
                } else {
                },
                }.thenBy { it.displayName },
                }.toImmutableList(),
            )
            .filter { !it.isOnDevice || dataRepository.isLocalInferenceAvailable() }
            .filter { it != Service.Free }
            .filter { it.service.isOnDevice }
            .filter { supportsAgenticFlows(it.serviceId, it.modelId) }
            .forEach { checkConnection(it.instanceId, it.service) }
            .sortedWith(
            .toImmutableList(),
            // Android 17+ blocks LAN traffic without the local network permission, so ask
            // Ask for the OS permission first; only flip the toggle on if it's granted.
            // before probing — otherwise the check fails with a misleading connection error.
            _state.update {
            _state.update { it.copy(isSmsEnabled = enabled) }
            _state.update { it.copy(isSmsSendEnabled = enabled) }
            _state.update { it.copy(memories = dataRepository.getMemories().toImmutableList()) }
            _state.update { it.copy(notificationPendingCount = 0) }
            _state.update { state ->
            apiKey = dataRepository.getInstanceApiKey(instance.instanceId),
            baseUrl = dataRepository.getInstanceBaseUrl(instance.instanceId, service),
            browseSkillMarketplaces()
            checkAllConnections()
            checkConnection(entry.instanceId, entry.service)
            checkConnection(instanceId, service)
            combine(downloadingFlow, progressFlow, errorFlow) { modelId, progress, error ->
            combine(importingFlow, importProgressFlow, importErrorFlow) { name, progress, error ->
            connectEnabledMcpServers()
            connectMcpServerWithStatus(config.id)
            connectMcpServerWithStatus(serverId)
            connectionStatus = if (dataRepository.isMcpServerConnected(config.id)) {
            current.copy(
            customModelId = dataRepository.getInstanceCustomModelId(instance.instanceId),
            daemonController.start()
            daemonController.stop()
            dataRepository.clearPendingNotifications()
            dataRepository.deleteLocalModel(modelId)
            dataRepository.getServiceEntries().any { it.instanceId == id }
            dataRepository.openNotificationListenerSettings()
            dataRepository.pollEmailAccount(id)
            dataRepository.pollSms()
            dataRepository.releaseLocalEngine()
            dataRepository.setSmsEnabled(enabled)
            dataRepository.setSmsSendEnabled(enabled)
            dataRepository.updateMemoryContent(key, content)
            delay(4.seconds)
            delay(800.milliseconds)
            executeDeletion(PendingDeletion.EmailAccount(id))
            executeDeletion(PendingDeletion.McpServer(serverId))
            executeDeletion(PendingDeletion.Memory(key))
            executeDeletion(PendingDeletion.Service(instanceId))
            executeDeletion(PendingDeletion.Skill(id))
            executeDeletion(PendingDeletion.Task(id))
            executeDeletion(deletion)
            fetchSponsors()
            hasCheckedInitialConnection = true
            id = config.id,
            if (isLocalNetworkUrl(baseUrl) && !localNetworkPermissionController.requestPermission()) {
            if (savedId != null && validId == null) dataRepository.setHeartbeatInstanceId(null)
            if (state.pendingDeletion == deletion) state.copy(pendingDeletion = null) else state
            instanceId = instance.instanceId,
            is PendingDeletion.EmailAccount -> {
            is PendingDeletion.McpServer -> {
            is PendingDeletion.Memory -> {
            is PendingDeletion.Service -> {
            is PendingDeletion.Skill -> {
            is PendingDeletion.Task -> {
            isEnabled = config.isEnabled,
            it.copy(
            it.copy(modelContextTokens = it.modelContextTokens.toMutableMap().apply { put(modelId, contextTokens) }.toImmutableMap())
            model.id to if (stored > 0) stored else model.defaultContextTokens
            models = models.toImmutableList(),
            name = config.name,
            refreshInstanceModels(instanceId)
            refreshLocalModelsAfterChange()
            refreshMcpServers()
            result.fold(
            return
            selectedModel = models.firstOrNull { it.isSelected },
            service = service,
            state.copy(
            super.onCleared()
            taskScheduler.triggerHeartbeatNow()
            tools = dataRepository.getMcpToolsForServer(config.id).toImmutableList(),
            try {
            updateConnectionStatus(instanceId, ConnectionStatus.Connected)
            updateConnectionStatus(instanceId, ConnectionStatus.Unknown)
            updateMcpConnectionStatus(serverId, McpConnectionStatus.Connected)
            updateMcpConnectionStatus(serverId, McpConnectionStatus.Error)
            url = config.url,
            useCustomModel = dataRepository.getInstanceUseCustomModel(instance.instanceId),
            val baseUrl = dataRepository.getInstanceBaseUrl(instanceId, service)
            val config = dataRepository.addMcpServer(name, url, headers)
            val existingStatuses = current.configuredServices.associate { it.instanceId to it.connectionStatus }
            val existingStatuses = current.mcpServers.associate { it.id to it.connectionStatus }
            val newEntries = buildConfiguredServiceEntries().map { entry ->
            val result = dataRepository.browseSkillMarketplaces()
            val result = install()
            val savedId = dataRepository.getHeartbeatInstanceId()
            val stored = dataRepository.getModelContextTokens(model.id)
            validateConnectionWithStatus(instanceId, service)
            viewModelScope.launch { notificationPermissionController.requestPermission() }
            viewModelScope.launch(backgroundDispatcher) {
            when (val result = dataRepository.importLocalModel(file)) {
            }
            } catch (_: Exception) {
            } catch (e: Exception) {
            } else {
            },
            }.collect { (modelId, progress, error) ->
            }.collect { (name, progress, error) ->
        )
        // Allow all non-Free services (multiple instances of same type are allowed)
        // ConversationStorage's in-memory flow — refresh it so imported chats appear
        // Guard against a stale async deletion clobbering a newer pending one from a rapid second Remove click.
        // Hide on-device services on platforms that don't support them
        // Import writes conversations to settings, but the chat list reads them from
        // Listener access is granted via system Settings, not a runtime permission
        // Observe download state from the engine singleton (survives activity recreation)
        // Pin OpenAI-Compatible and LiteRT (Local Model) to the top, then the featured Atlas Cloud
        // Re-read notification listener state every time the screen becomes visible:
        // Release engine so the next message re-initializes with the new context size
        // dialog. Set the toggle, then if access is missing, deep-link the user out
        // listener still drops everything until access is granted.
        // provider, then sort the rest alphabetically
        // so they can enable Kai there. The toggle reflects the user's *intent*; the
        // the user may have toggled access in system settings while we were backgrounded.
        // without an app restart.
        ConfiguredServiceEntry(
        CoroutineScope(backgroundDispatcher).launch {
        ImportResult.Failure
        McpServerUiState(
        _state.update {
        _state.update { current ->
        _state.update { it.copy(currentTab = tab) }
        _state.update { it.copy(emailPollIntervalMinutes = minutes) }
        _state.update { it.copy(expandedServiceId = instance.instanceId) }
        _state.update { it.copy(expandedServiceId = instanceId) }
        _state.update { it.copy(heartbeatActiveHoursStart = start, heartbeatActiveHoursEnd = end) }
        _state.update { it.copy(heartbeatIntervalMinutes = minutes) }
        _state.update { it.copy(heartbeatPrompt = text) }
        _state.update { it.copy(heartbeatSelectedInstanceId = instanceId) }
        _state.update { it.copy(isBrowsingSkills = true, browseSkillsFailed = false) }
        _state.update { it.copy(isDaemonEnabled = enabled) }
        _state.update { it.copy(isDynamicUiEnabled = enabled) }
        _state.update { it.copy(isEmailEnabled = enabled) }
        _state.update { it.copy(isFreeFallbackEnabled = enabled) }
        _state.update { it.copy(isHeartbeatEnabled = enabled) }
        _state.update { it.copy(isInstallingSkill = true, skillInstallError = null) }
        _state.update { it.copy(isMemoryEnabled = enabled) }
        _state.update { it.copy(isRefreshingHeartbeat = true) }
        _state.update { it.copy(isRefreshingSms = true) }
        _state.update { it.copy(isSchedulingEnabled = enabled) }
        _state.update { it.copy(pendingDeletion = PendingDeletion.EmailAccount(id)) }
        _state.update { it.copy(pendingDeletion = PendingDeletion.McpServer(serverId)) }
        _state.update { it.copy(pendingDeletion = PendingDeletion.Memory(key)) }
        _state.update { it.copy(pendingDeletion = PendingDeletion.Skill(id)) }
        _state.update { it.copy(pendingDeletion = PendingDeletion.Task(id)) }
        _state.update { it.copy(pendingDeletion = null) }
        _state.update { it.copy(refreshingEmailAccountIds = (it.refreshingEmailAccountIds + id).toPersistentSet()) }
        _state.update { it.copy(showAddMcpServerDialog = false) }
        _state.update { it.copy(showAddMcpServerDialog = show) }
        _state.update { it.copy(skills = dataRepository.getInstalledSkills().toImmutableList()) }
        _state.update { it.copy(smsPollIntervalMinutes = minutes) }
        _state.update { it.copy(soulText = text) }
        _state.update { it.copy(themeMode = mode) }
        _state.update { it.copy(uiScale = scale) }
        _state.update { state ->
        _state.value = buildFullState().copy(currentTab = currentTab)
        _state.value.configuredServices
        availableServicesToAdd = computeAvailableServices().toImmutableList(),
        checkAllConnections()
        checkConnection(instance.instanceId, service)
        checkConnectionDebounced(instanceId, entry.service)
        commitPendingDeletion()
        configuredServices = buildConfiguredServiceEntries().toImmutableList(),
        connectEnabledMcpServers()
        connectionCheckJobs[instanceId] = viewModelScope.launch {
        connectionCheckJobs[instanceId]?.cancel()
        dataRepository.cancelLocalModelDownload()
        dataRepository.cancelLocalModelImport()
        dataRepository.clearInstanceModels(instanceId, entry.service)
        dataRepository.loadConversations()
        dataRepository.openNotificationListenerSettings()
        dataRepository.reorderConfiguredServices(orderedIds)
        dataRepository.setDaemonEnabled(enabled)
        dataRepository.setDynamicUiEnabled(enabled)
        dataRepository.setEmailEnabled(enabled)
        dataRepository.setEmailPollIntervalMinutes(minutes)
        dataRepository.setFreeFallbackEnabled(enabled)
        dataRepository.setHeartbeatActiveHours(start, end)
        dataRepository.setHeartbeatEnabled(enabled)
        dataRepository.setHeartbeatInstanceId(instanceId)
        dataRepository.setHeartbeatIntervalMinutes(minutes)
        dataRepository.setHeartbeatPrompt(text)
        dataRepository.setMcpServerEnabled(serverId, enabled)
        dataRepository.setMemoryEnabled(enabled)
        dataRepository.setModelContextTokens(modelId, contextTokens)
        dataRepository.setNotificationsEnabled(enabled)
        dataRepository.setSchedulingEnabled(enabled)
        dataRepository.setSmsPollIntervalMinutes(minutes)
        dataRepository.setSoulText(text)
        dataRepository.setThemeMode(mode)
        dataRepository.setToolEnabled(toolId, enabled)
        dataRepository.setUiScale(scale)
        dataRepository.startLocalModelDownload(model)
        dataRepository.updateInstanceApiKey(instanceId, apiKey)
        dataRepository.updateInstanceBaseUrl(instanceId, baseUrl)
        dataRepository.updateInstanceCustomModelId(instanceId, modelId)
        dataRepository.updateInstanceSelectedModel(instanceId, entry.service, modelId)
        dataRepository.updateInstanceUseCustomModel(instanceId, useCustom)
        emailAccounts = dataRepository.getEmailAccounts().toImmutableList(),
        emailPendingCount = dataRepository.getPendingEmailCount(),
        emailPollIntervalMinutes = dataRepository.getEmailPollIntervalMinutes(),
        emailSyncStates = dataRepository.getEmailSyncStates().toImmutableMap(),
        for (entry in _state.value.configuredServices) {
        for (server in enabledServers) {
        heartbeatActiveHoursEnd = dataRepository.getHeartbeatConfig().activeHoursEnd,
        heartbeatActiveHoursStart = dataRepository.getHeartbeatConfig().activeHoursStart,
        heartbeatIntervalMinutes = dataRepository.getHeartbeatConfig().intervalMinutes,
        heartbeatLog = dataRepository.getHeartbeatLog().toImmutableList(),
        heartbeatPrompt = dataRepository.getHeartbeatPrompt(),
        heartbeatSelectedInstanceId = dataRepository.getHeartbeatInstanceId()?.takeIf { id ->
        heartbeatServiceEntries = dataRepository.getServiceEntries()
        if (!hasCheckedInitialConnection) {
        if (!localNetworkPermissionController.hasPermission()) return
        if (_state.value.isRefreshingHeartbeat) return
        if (_state.value.isRefreshingSms) return
        if (_state.value.localDownloadingModelId != null || _state.value.localImportingFileName != null) return
        if (_state.value.localImportingFileName != null) return
        if (_state.value.modelContextTokens[modelId] == contextTokens) return
        if (enabled && !dataRepository.hasSmsPermission()) {
        if (enabled && !dataRepository.hasSmsSendPermission()) {
        if (enabled && !dataRepository.isNotificationListenerAccessGranted()) {
        if (enabled) {
        if (errors == 0) ImportResult.Success else ImportResult.PartialSuccess(errors)
        if (id in _state.value.refreshingEmailAccountIds) return
        if (instanceId != null) {
        if (isNotificationsSupported) {
        if (result.isSuccess) {
        if (service == Service.Free) {
        if (service.isOnDevice) {
        if (service.requiresApiKey && dataRepository.getInstanceApiKey(instanceId).isBlank()) {
        if (show && _state.value.browsableSkills.isEmpty() && !_state.value.isBrowsingSkills) {
        if (source == null) {
        initialValue = _state.value,
        isDaemonEnabled = dataRepository.isDaemonEnabled(),
        isDynamicUiEnabled = dataRepository.isDynamicUiEnabled(),
        isEmailEnabled = dataRepository.isEmailEnabled(),
        isFreeFallbackEnabled = dataRepository.isFreeFallbackEnabled(),
        isHeartbeatEnabled = dataRepository.getHeartbeatConfig().enabled,
        isMemoryEnabled = dataRepository.isMemoryEnabled(),
        isNotificationsEnabled = dataRepository.isNotificationsEnabled(),
        isSchedulingEnabled = dataRepository.isSchedulingEnabled(),
        isSmsEnabled = dataRepository.isSmsEnabled(),
        isSmsSendEnabled = dataRepository.isSmsSendEnabled(),
        localAvailableModels = dataRepository.getLocalAvailableModels().toImmutableList(),
        localDownloadProgress = dataRepository.getLocalDownloadProgress()?.value,
        localDownloadingModelId = dataRepository.getLocalDownloadingModelId()?.value,
        localFreeSpaceBytes = dataRepository.getLocalFreeSpaceBytes(),
        localImportProgress = dataRepository.getLocalImportProgress()?.value,
        localImportedModels = dataRepository.getLocalImportedModels().toImmutableList(),
        localImportingFileName = dataRepository.getLocalImportingFileName()?.value,
        localNetworkPermissionController.openAppSettings()
        mcpServers = buildMcpServerEntries().toImmutableList(),
        memories = dataRepository.getMemories().toImmutableList(),
        modelContextTokens = buildModelContextTokensMap(),
        notificationListenerAccessGranted = dataRepository.isNotificationListenerAccessGranted(),
        notificationListenerBound = dataRepository.getNotificationSyncState().listenerBound,
        notificationPendingCount = dataRepository.getPendingNotificationCount(),
        onAddMcpServer = ::onAddMcpServer,
        onAddMcpServer(server.name, server.url, server.headers)
        onAddPopularMcpServer = ::onAddPopularMcpServer,
        onAddService = ::onAddService,
        onCancelLocalModelDownload = ::onCancelLocalModelDownload,
        onCancelLocalModelImport = ::onCancelLocalModelImport,
        onCancelTask = ::onCancelTask,
        onChangeApiKey = ::onChangeApiKey,
        onChangeBaseUrl = ::onChangeBaseUrl,
        onChangeCustomModelId = ::onChangeCustomModelId,
        onChangeEmailPollInterval = ::onChangeEmailPollInterval,
        onChangeHeartbeatActiveHours = ::onChangeHeartbeatActiveHours,
        onChangeHeartbeatInterval = ::onChangeHeartbeatInterval,
        onChangeHeartbeatService = ::onChangeHeartbeatService,
        onChangeModelContextTokens = ::onChangeModelContextTokens,
        onChangeSmsPollInterval = ::onChangeSmsPollInterval,
        onChangeThemeMode = ::onChangeThemeMode,
        onChangeUiScale = ::onChangeUiScale,
        onClearPendingNotifications = ::onClearPendingNotifications,
        onDeleteLocalModel = ::onDeleteLocalModel,
        onDeleteMemory = ::onDeleteMemory,
        onDownloadLocalModel = ::onDownloadLocalModel,
        onExpandService = ::onExpandService,
        onExportSettings = ::onExportSettings,
        onImportLocalModel = ::onImportLocalModel,
        onImportSettings = ::onImportSettings,
        onInstallBrowsedSkill = ::onInstallBrowsedSkill,
        onInstallGitHubSkill = ::onInstallGitHubSkill,
        onOpenAppPermissionSettings = ::onOpenAppPermissionSettings,
        onOpenNotificationListenerSettings = ::onOpenNotificationListenerSettings,
        onPrepareExport = ::onPrepareExport,
        onRecheckLocalNetworkPermission = ::onRecheckLocalNetworkPermission,
        onRefreshEmailAccount = ::onRefreshEmailAccount,
        onRefreshHeartbeat = ::onRefreshHeartbeat,
        onRefreshMcpServer = ::onRefreshMcpServer,
        onRefreshSms = ::onRefreshSms,
        onRemoveEmailAccount = ::onRemoveEmailAccount,
        onRemoveMcpServer = ::onRemoveMcpServer,
        onRemoveService = ::onRemoveService,
        onReorderServices = ::onReorderServices,
        onSaveHeartbeatPrompt = ::onSaveHeartbeatPrompt,
        onSaveSoul = ::onSaveSoul,
        onSelectModel = ::onSelectModel,
        onSelectTab = ::onSelectTab,
        onShowAddMcpServerDialog = ::onShowAddMcpServerDialog,
        onShowAddSkillDialog = ::onShowAddSkillDialog,
        onToggleDaemon = ::onToggleDaemon,
        onToggleDynamicUi = ::onToggleDynamicUi,
        onToggleEmail = ::onToggleEmail,
        onToggleFreeFallback = ::onToggleFreeFallback,
        onToggleHeartbeat = ::onToggleHeartbeat,
        onToggleMcpServer = ::onToggleMcpServer,
        onToggleMemory = ::onToggleMemory,
        onToggleNotifications = ::onToggleNotifications,
        onToggleScheduling = ::onToggleScheduling,
        onToggleSms = ::onToggleSms,
        onToggleSmsSend = ::onToggleSmsSend,
        onToggleTool = ::onToggleTool,
        onToggleUseCustomModel = ::onToggleUseCustomModel,
        onUndoDelete = ::onUndoDelete,
        onUninstallSkill = ::onUninstallSkill,
        onUpdateMemory = ::onUpdateMemory,
        pendingDeleteJob = null
        pendingDeleteJob = viewModelScope.launch(backgroundDispatcher) {
        pendingDeleteJob?.cancel()
        refreshInstanceModels(instanceId)
        refreshMcpServers()
        refreshServiceList()
        return Service.all
        return models.associate { model ->
        runSkillInstall { dataRepository.installBrowsedSkill(entry) }
        runSkillInstall { dataRepository.installGitHubSkill(source.owner, source.repo, source.ref, source.path) }
        scheduledTasks = dataRepository.getScheduledTasks().toImmutableList(),
        scope = viewModelScope,
        showDaemonToggle = currentPlatform is Platform.Mobile.Android,
        showEmailToggle = isEmailSupported,
        showNotificationsSection = isNotificationsSupported,
        showSmsSection = isSmsSupported,
        showUiScale = currentPlatform is Platform.Desktop,
        skills = dataRepository.getInstalledSkills().toImmutableList(),
        smsPendingCount = dataRepository.getPendingSmsCount(),
        smsPermissionGranted = dataRepository.hasSmsPermission(),
        smsPollIntervalMinutes = dataRepository.getSmsPollIntervalMinutes(),
        smsSendPermissionGranted = dataRepository.hasSmsSendPermission(),
        smsSyncState = dataRepository.getSmsSyncState(),
        soulText = dataRepository.getSoulText(),
        started = SharingStarted.WhileSubscribed(5_000),
        super.onCleared()
        themeMode = dataRepository.getThemeMode(),
        tools = dataRepository.getToolDefinitions().toImmutableList(),
        totalDeviceMemoryBytes = dataRepository.getTotalDeviceMemoryBytes(),
        uiScale = dataRepository.getUiScale(),
        updateConnectionStatus(instanceId, ConnectionStatus.Checking)
        updateMcpConnectionStatus(serverId, McpConnectionStatus.Connecting)
        val currentTab = _state.value.currentTab
        val deletion = _state.value.pendingDeletion ?: return
        val deletion = _state.value.pendingDeletion ?: run {
        val downloadingFlow = dataRepository.getLocalDownloadingModelId() ?: flowOf(null)
        val enabledServers = _state.value.mcpServers.filter { it.isEnabled && it.connectionStatus != McpConnectionStatus.Connected }
        val entry = _state.value.configuredServices.find { it.instanceId == instanceId } ?: return
        val errorFlow = dataRepository.getLocalDownloadError() ?: flowOf(null)
        val errors = dataRepository.importSettingsFromJson(bytes.decodeToString(), sections, replace)
        val importErrorFlow = dataRepository.getLocalImportError() ?: flowOf(null)
        val importProgressFlow = dataRepository.getLocalImportProgress() ?: flowOf(null)
        val importingFlow = dataRepository.getLocalImportingFileName() ?: flowOf(null)
        val instance = dataRepository.addConfiguredService(service.id)
        val instance = dataRepository.getConfiguredServiceInstances().firstOrNull { it.instanceId == instanceId } ?: return
        val models = dataRepository.getInstanceModels(instance.instanceId, service).value
        val models = dataRepository.getInstanceModels(instanceId, entry.service).value
        val models = dataRepository.getLocalAvailableModels() + dataRepository.getLocalImportedModels()
        val progressFlow = dataRepository.getLocalDownloadProgress() ?: flowOf(null)
        val result = dataRepository.connectMcpServer(serverId)
        val service = Service.fromId(instance.serviceId)
        val source = parseGitHubSkillUrl(input)
        validateConnectionWithStatus(instanceId, Service.fromId(instance.serviceId))
        validateConnectionWithStatus(instanceId, service)
        viewModelScope.launch {
        viewModelScope.launch(backgroundDispatcher) {
        when (deletion) {
        }
        } else {
        },
        }.also { validId ->
        }.toImmutableMap()
     * Called when the app resumes while a connection sits in the local-network-denied state.
     * Re-validates only if the permission is now granted — never re-prompts, so a user who
     * denied and stayed on the screen isn't nagged with another dialog.
     */
    )
    /**
    // Bound once so downstream Compose skipping works — a new SettingsActions
    // MCP server management
    // Skills ---------------------------------------------------------------
    // instance on every state emission would defeat it.
    fun onScreenVisible() {
    init {
    override fun onCleared() {
    private fun browseSkillMarketplaces() {
    private fun buildConfiguredServiceEntries(): List<ConfiguredServiceEntry> = dataRepository.getConfiguredServiceInstances().map { instance ->
    private fun buildFullState(): SettingsUiState = SettingsUiState(
    private fun buildMcpServerEntries(): List<McpServerUiState> = dataRepository.getMcpServers().map { config ->
    private fun buildModelContextTokensMap(): ImmutableMap<String, Int> {
    private fun checkAllConnections() {
    private fun checkConnection(instanceId: String, service: Service) {
    private fun checkConnectionDebounced(instanceId: String, service: Service) {
    private fun commitPendingDeletion() {
    private fun computeAvailableServices(): List<Service> {
    private fun connectEnabledMcpServers() {
    private fun fetchSponsors() {
    private fun onAddMcpServer(name: String, url: String, headers: Map<String, String>) {
    private fun onAddPopularMcpServer(server: PopularMcpServer) {
    private fun onAddService(service: Service) {
    private fun onCancelLocalModelDownload() {
    private fun onCancelLocalModelImport() {
    private fun onCancelTask(id: String) {
    private fun onChangeApiKey(instanceId: String, apiKey: String) {
    private fun onChangeBaseUrl(instanceId: String, baseUrl: String) {
    private fun onChangeCustomModelId(instanceId: String, modelId: String) {
    private fun onChangeEmailPollInterval(minutes: Int) {
    private fun onChangeHeartbeatActiveHours(start: Int, end: Int) {
    private fun onChangeHeartbeatInterval(minutes: Int) {
    private fun onChangeHeartbeatService(instanceId: String?) {
    private fun onChangeModelContextTokens(modelId: String, contextTokens: Int) {
    private fun onChangeSmsPollInterval(minutes: Int) {
    private fun onChangeThemeMode(mode: ThemeMode) {
    private fun onChangeUiScale(scale: Float) {
    private fun onClearPendingNotifications() {
    private fun onDeleteLocalModel(modelId: String) {
    private fun onDeleteMemory(key: String) {
    private fun onDownloadLocalModel(model: LocalModel) {
    private fun onExpandService(instanceId: String?) {
    private fun onExportSettings(sections: Set<ImportSection>): String = dataRepository.exportSettingsToJson(sections)
    private fun onImportLocalModel(file: PlatformFile) {
    private fun onImportSettings(bytes: ByteArray, sections: Set<ImportSection>, replace: Boolean): ImportResult = try {
    private fun onInstallBrowsedSkill(entry: com.inspiredandroid.kai.skills.RegistrySkillEntry) {
    private fun onInstallGitHubSkill(input: String) {
    private fun onOpenAppPermissionSettings() {
    private fun onOpenNotificationListenerSettings() {
    private fun onPrepareExport(): Map<ImportSection, String?> = dataRepository.getExportPreview()
    private fun onRecheckLocalNetworkPermission(instanceId: String) {
    private fun onRefreshEmailAccount(id: String) {
    private fun onRefreshHeartbeat() {
    private fun onRefreshMcpServer(serverId: String) {
    private fun onRefreshSms() {
    private fun onRemoveEmailAccount(id: String) {
    private fun onRemoveMcpServer(serverId: String) {
    private fun onRemoveService(instanceId: String) {
    private fun onReorderServices(orderedIds: List<String>) {
    private fun onSaveHeartbeatPrompt(text: String) {
    private fun onSaveSoul(text: String) {
    private fun onSelectModel(instanceId: String, modelId: String) {
    private fun onSelectTab(tab: SettingsTab) {
    private fun onShowAddMcpServerDialog(show: Boolean) {
    private fun onShowAddSkillDialog(show: Boolean) {
    private fun onToggleDaemon(enabled: Boolean) {
    private fun onToggleDynamicUi(enabled: Boolean) {
    private fun onToggleEmail(enabled: Boolean) {
    private fun onToggleFreeFallback(enabled: Boolean) {
    private fun onToggleHeartbeat(enabled: Boolean) {
    private fun onToggleMcpServer(serverId: String, enabled: Boolean) {
    private fun onToggleMemory(enabled: Boolean) {
    private fun onToggleNotifications(enabled: Boolean) {
    private fun onToggleScheduling(enabled: Boolean) {
    private fun onToggleSms(enabled: Boolean) {
    private fun onToggleSmsSend(enabled: Boolean) {
    private fun onToggleTool(toolId: String, enabled: Boolean) {
    private fun onToggleUseCustomModel(instanceId: String, useCustom: Boolean) {
    private fun onUndoDelete() {
    private fun onUninstallSkill(id: String) {
    private fun onUpdateMemory(key: String, content: String) {
    private fun refreshInstanceModels(instanceId: String) {
    private fun refreshLocalModelsAfterChange() {
    private fun refreshMcpServers() {
    private fun refreshServiceList() {
    private fun refreshSkills() {
    private fun updateConnectionStatus(instanceId: String, status: ConnectionStatus) {
    private fun updateMcpConnectionStatus(serverId: String, status: McpConnectionStatus) {
    private fun validateConnectionWithStatus(instanceId: String, service: Service) {
    private inline fun runSkillInstall(crossinline install: suspend () -> Result<com.inspiredandroid.kai.skills.SkillManifest>) {
    private suspend fun connectMcpServerWithStatus(serverId: String) {
    private suspend fun executeDeletion(deletion: PendingDeletion) {
    private val _state = MutableStateFlow(buildFullState())
    private val backgroundDispatcher: CoroutineContext = getBackgroundDispatcher(),
    private val daemonController: DaemonController,
    private val dataRepository: DataRepository,
    private val localNetworkPermissionController: PermissionController = PermissionController(AppPermission.LOCAL_NETWORK),
    private val notificationPermissionController: PermissionController,
    private val taskScheduler: TaskScheduler,
    private var connectionCheckJobs: MutableMap<String, Job> = mutableMapOf()
    private var hasCheckedInitialConnection = false
    private var pendingDeleteJob: Job? = null
    val actions: SettingsActions = SettingsActions(
    val state = _state.stateIn(
    }
    } catch (_: Exception) {
) : ViewModel() {
class SettingsViewModel(
}
