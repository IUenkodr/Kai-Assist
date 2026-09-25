import androidx.compose.runtime.Immutable
import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.EmailSyncState
import com.inspiredandroid.kai.data.HeartbeatLogEntry
import com.inspiredandroid.kai.data.MemoryEntry
import com.inspiredandroid.kai.data.ScheduledTask
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.SmsSyncState
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.inference.DownloadError
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.ModelImportError
import com.inspiredandroid.kai.network.dtos.SponsorsResponseDto
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.skills.RegistrySkillEntry
import com.inspiredandroid.kai.skills.SkillManifest
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.collections.immutable.persistentSetOf
import org.jetbrains.compose.resources.StringResource

     * (currently Ollama Cloud and OpenRouter only).
     * True when this entry was typed by the user and is not (yet) present in the
     * True when this model is on the provider's free tier according to the
     * curated [com.inspiredandroid.kai.data.FreeTierModels] catalog
     * instead of accumulating intermediate keystrokes in the picker.
     * provider's model list. At most one manual entry is kept; retyping replaces it
     */
    /**
    /** Human-readable name to display in place of [id], when the provider exposes one. */
    /** LMArena Elo score, or null when unknown. */
    /** Max context window in tokens, from the API or the curated catalog. */
    /** OpenAI-Compatible only: when true, [customModelId] is used for chat instead of [selectedModel]. */
    /** Parameter count, pre-formatted for display (e.g. "70B", "8B", "3.3B"). */
    /** Release date as "YYYY-MM" or "YYYY-MM-DD", from the API or the curated catalog. */
    Agent,
    Checking,
    Connected,
    Connecting,
    Error,
    ErrorConnectionFailed,
    ErrorInvalidKey,
    ErrorLocalNetworkDenied,
    ErrorQuotaExhausted,
    ErrorRateLimited,
    General,
    Integrations,
    Sandbox,
    Services,
    Tools,
    Unknown,
    data class EmailAccount(val id: String) : PendingDeletion
    data class McpServer(val serverId: String) : PendingDeletion
    data class Memory(val key: String) : PendingDeletion
    data class PartialSuccess(val errorCount: Int) : ImportResult
    data class Service(val instanceId: String) : PendingDeletion
    data class Skill(val id: String) : PendingDeletion
    data class Task(val id: String) : PendingDeletion
    data object Failure : ImportResult
    data object Success : ImportResult
    val apiKey: String = "",
    val arenaScore: Int? = null,
    val availableServicesToAdd: ImmutableList<Service> = persistentListOf(),
    val baseUrl: String = "",
    val browsableSkills: ImmutableList<RegistrySkillEntry> = persistentListOf(),
    val browseSkillsFailed: Boolean = false,
    val configuredServices: ImmutableList<ConfiguredServiceEntry> = persistentListOf(),
    val connectionStatus: ConnectionStatus = ConnectionStatus.Unknown,
    val connectionStatus: McpConnectionStatus,
    val contextWindow: Long? = null,
    val currentSponsors: ImmutableList<SponsorsResponseDto.Sponsor> = persistentListOf(),
    val currentTab: SettingsTab = SettingsTab.Services,
    val customModelId: String = "",
    val description: String? = null,
    val descriptionRes: StringResource? = null,
    val displayName: String? = null,
    val emailAccounts: ImmutableList<EmailAccount> = persistentListOf(),
    val emailPendingCount: Int = 0,
    val emailPollIntervalMinutes: Int = 15,
    val emailSyncStates: ImmutableMap<String, EmailSyncState> = persistentMapOf(),
    val expandedServiceId: String? = null,
    val heartbeatActiveHoursEnd: Int = 22,
    val heartbeatActiveHoursStart: Int = 8,
    val heartbeatIntervalMinutes: Int = 30,
    val heartbeatLog: ImmutableList<HeartbeatLogEntry> = persistentListOf(),
    val heartbeatPrompt: String = "",
    val heartbeatSelectedInstanceId: String? = null,
    val heartbeatServiceEntries: ImmutableList<ServiceEntry> = persistentListOf(),
    val id: String,
    val instanceId: String,
    val isBrowsingSkills: Boolean = false,
    val isDaemonEnabled: Boolean = false,
    val isDynamicUiEnabled: Boolean = true,
    val isEmailEnabled: Boolean = true,
    val isEnabled: Boolean,
    val isFreeFallbackEnabled: Boolean = true,
    val isFreeTier: Boolean = false,
    val isHeartbeatEnabled: Boolean = true,
    val isInstallingSkill: Boolean = false,
    val isManualEntry: Boolean = false,
    val isMemoryEnabled: Boolean = true,
    val isNotificationsEnabled: Boolean = false,
    val isRefreshingHeartbeat: Boolean = false,
    val isRefreshingSms: Boolean = false,
    val isSchedulingEnabled: Boolean = true,
    val isSelected: Boolean = false,
    val isSmsEnabled: Boolean = false,
    val isSmsSendEnabled: Boolean = false,
    val localAvailableModels: ImmutableList<LocalModel> = persistentListOf(),
    val localDownloadError: DownloadError? = null,
    val localDownloadProgress: Float? = null,
    val localDownloadingModelId: String? = null,
    val localFreeSpaceBytes: Long = 0L,
    val localImportError: ModelImportError? = null,
    val localImportProgress: Float? = null,
    val localImportedModels: ImmutableList<LocalModel> = persistentListOf(),
    val localImportingFileName: String? = null,
    val mcpServers: ImmutableList<McpServerUiState> = persistentListOf(),
    val memories: ImmutableList<MemoryEntry> = persistentListOf(),
    val modelContextTokens: ImmutableMap<String, Int> = persistentMapOf(),
    val models: ImmutableList<SettingsModel> = persistentListOf(),
    val name: String,
    val notificationListenerAccessGranted: Boolean = false,
    val notificationListenerBound: Boolean = false,
    val notificationPendingCount: Int = 0,
    val parameterCount: String? = null,
    val pastSponsors: ImmutableList<SponsorsResponseDto.Sponsor> = persistentListOf(),
    val pendingDeletion: PendingDeletion? = null,
    val refreshingEmailAccountIds: ImmutableSet<String> = persistentSetOf(),
    val releaseDate: String? = null,
    val scheduledTasks: ImmutableList<ScheduledTask> = persistentListOf(),
    val selectedModel: SettingsModel? = null,
    val service: Service,
    val showAddMcpServerDialog: Boolean = false,
    val showAddSkillDialog: Boolean = false,
    val showDaemonToggle: Boolean = false,
    val showEmailToggle: Boolean = false,
    val showNotificationsSection: Boolean = false,
    val showSmsSection: Boolean = false,
    val showUiScale: Boolean = false,
    val skillInstallError: String? = null,
    val skills: ImmutableList<SkillManifest> = persistentListOf(),
    val smsPendingCount: Int = 0,
    val smsPermissionGranted: Boolean = false,
    val smsPollIntervalMinutes: Int = 15,
    val smsSendPermissionGranted: Boolean = false,
    val smsSyncState: SmsSyncState = SmsSyncState(),
    val soulText: String = "",
    val subtitle: String,
    val themeMode: ThemeMode = ThemeMode.System,
    val tools: ImmutableList<ToolInfo> = persistentListOf(),
    val tools: ImmutableList<ToolInfo>,
    val totalDeviceMemoryBytes: Long = Long.MAX_VALUE,
    val uiScale: Float = 1.0f,
    val url: String,
    val useCustomModel: Boolean = false,
)
@Immutable
data class ConfiguredServiceEntry(
data class McpServerUiState(
data class SettingsModel(
data class SettingsUiState(
enum class ConnectionStatus {
enum class McpConnectionStatus {
enum class SettingsTab {
package com.inspiredandroid.kai.ui.settings
sealed interface ImportResult {
sealed interface PendingDeletion {
}
