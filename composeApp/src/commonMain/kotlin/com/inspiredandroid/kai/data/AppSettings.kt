
                "All your stored memories are listed in the system prompt grouped by category.\n\n" +
                "Do not store trivial or transient information."
                "Use the memory_forget tool to remove outdated or incorrect memories.\n" +
                "When you learn important information about the user (name, preferences, projects, goals, etc.), " +
                "proactively use the memory_store tool to save it.\n" +
                ThemeMode.System
                ThemeMode.valueOf(raw)
                false
                v.jsonPrimitive.content.toBoolean()
            "You have persistent memory across conversations. " +
            @OptIn(kotlin.io.encoding.ExperimentalEncodingApi::class)
            json["conversations"]?.jsonArray?.size
            kotlin.io.encoding.Base64.decode(encoded)
            null
            return try {
            settings.putString(KEY_CURRENT_CONVERSATION_ID, id)
            settings.remove(KEY_CURRENT_CONVERSATION_ID)
            try {
            }
            } catch (_: Exception) {
            } catch (_: IllegalArgumentException) {
        .ifEmpty { getSplinterlandsPostingKey() } // fallback to legacy key
        // Basic memory guidance shared by every chat variant. The advanced `## Structured
        // Learning` block lives in `ChatSystemPromptBuilder.DEFAULT_STRUCTURED_LEARNING_SECTION`
        // Migrate the legacy boolean OLED toggle: true → OledBlack, false → System.
        // and is composed in only for the remote variant.
        ?.let { id -> LinuxDistro.entries.firstOrNull { it.id == id } }
        _themeModeFlow.value = mode
        _uiScaleFlow.value = scale
        const val DEFAULT_MEMORY_INSTRUCTIONS =
        const val KEY_AGENT_MEMORIES = "agent_memories"
        const val KEY_APP_OPENS = "app_opens"
        const val KEY_BASE_URL_V1_MIGRATION_COMPLETE = "base_url_v1_migration_complete"
        const val KEY_CONFIGURED_SERVICES = "configured_services"
        const val KEY_CONVERSATIONS = "conversations_json"
        const val KEY_CURRENT_CONVERSATION_ID = "current_conversation_id"
        const val KEY_CURRENT_CONVERSATION_MIGRATED = "current_conversation_migrated"
        const val KEY_CURRENT_INTERACTIVE_MODE = "current_interactive_mode"
        const val KEY_CURRENT_SERVICE_ID = "current_service_id"
        const val KEY_CUSTOM_MODEL_MIGRATION_COMPLETE = "custom_model_migration_complete_v1"
        const val KEY_DAEMON_ENABLED = "daemon_enabled"
        const val KEY_DYNAMIC_UI_ENABLED = "dynamic_ui_enabled"
        const val KEY_EMAIL_ACCOUNTS = "email_accounts"
        const val KEY_EMAIL_ENABLED = "email_enabled"
        const val KEY_EMAIL_PASSWORD_PREFIX = "email_password_"
        const val KEY_EMAIL_PENDING = "email_pending"
        const val KEY_EMAIL_POLL_INTERVAL = "email_poll_interval"
        const val KEY_EMAIL_SYNC_PREFIX = "email_sync_"
        const val KEY_ENCRYPTION_KEY = "encryption_key"
        const val KEY_FREE_FALLBACK_ENABLED = "free_fallback_enabled"
        const val KEY_FREE_MODE = "free_mode"
        const val KEY_FREE_SERVICE_PRIMARY = "free_service_primary"
        const val KEY_HEARTBEAT_CONFIG = "heartbeat_config"
        const val KEY_HEARTBEAT_LOG = "heartbeat_log"
        const val KEY_HEARTBEAT_PROMPT = "heartbeat_prompt"
        const val KEY_INSTANCE_MIGRATION_COMPLETE = "instance_migration_complete_v1"
        const val KEY_KAI_BUILD_LAUNCH_AGENT = "kai_build_launch_agent"
        const val KEY_MCP_SERVERS = "mcp_servers"
        const val KEY_MEMORY_ENABLED = "memory_enabled"
        const val KEY_MEMORY_INSTRUCTIONS = "memory_instructions"
        const val KEY_MIGRATION_COMPLETE = "migration_complete_v1"
        const val KEY_MODEL_CONTEXT_PREFIX = "model_context_"
        const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
        const val KEY_NOTIFICATIONS_PENDING = "notifications_pending"
        const val KEY_NOTIFICATIONS_STORE = "notifications_store"
        const val KEY_NOTIFICATIONS_SYNC_STATE = "notifications_sync_state"
        const val KEY_OLED_MODE_ENABLED = "oled_mode_enabled"
        const val KEY_SANDBOX_DISTRO = "sandbox_distro"
        const val KEY_SANDBOX_ENABLED = "sandbox_enabled"
        const val KEY_SCHEDULED_TASKS = "scheduled_tasks"
        const val KEY_SCHEDULING_ENABLED = "scheduling_enabled"
        const val KEY_SERVICES_MIGRATION_COMPLETE = "services_migration_complete_v1"
        const val KEY_SMS_DRAFTS = "sms_drafts"
        const val KEY_SMS_ENABLED = "sms_enabled"
        const val KEY_SMS_PENDING = "sms_pending"
        const val KEY_SMS_POLL_INTERVAL = "sms_poll_interval"
        const val KEY_SMS_SEND_ENABLED = "sms_send_enabled"
        const val KEY_SMS_SYNC_STATE = "sms_sync_state"
        const val KEY_SOUL = "soul_text"
        const val KEY_SPLINTERLANDS_ACCOUNT = "splinterlands_account"
        const val KEY_SPLINTERLANDS_BATTLE_LOG = "splinterlands_battle_log"
        const val KEY_SPLINTERLANDS_ENABLED = "splinterlands_enabled"
        const val KEY_SPLINTERLANDS_INSTANCE_ID = "splinterlands_instance_id"
        const val KEY_SPLINTERLANDS_INSTANCE_IDS = "splinterlands_instance_ids"
        const val KEY_SPLINTERLANDS_POSTING_KEY = "splinterlands_posting_key"
        const val KEY_THEME_MODE = "theme_mode"
        const val KEY_TOOL_PREFIX = "tool_enabled_"
        const val KEY_UI_SCALE = "ui_scale"
        if (id == null) {
        if (raw.isNotEmpty()) {
        return FreeMode.entries.find { it.name == stored } ?: FreeMode.FAST
        return if (settings.getBoolean(KEY_OLED_MODE_ENABLED, false)) ThemeMode.OledBlack else ThemeMode.System
        return newCount
        return try {
        sections[ImportSection.CONVERSATIONS] = "${conversations.size}"
        sections[ImportSection.CONVERSATIONS] = count?.let { "$it" }
        sections[ImportSection.EMAIL] = "${emails.size}"
        sections[ImportSection.EMAIL] = count?.let { "$it" }
        sections[ImportSection.HEARTBEAT] = null
        sections[ImportSection.MCP] = "${mcp.size}"
        sections[ImportSection.MCP] = count?.let { "$it" }
        sections[ImportSection.MEMORY] = "${memories.size}"
        sections[ImportSection.MEMORY] = count?.let { "$it" }
        sections[ImportSection.SCHEDULING] = "${tasks.size}"
        sections[ImportSection.SCHEDULING] = count?.let { "$it" }
        sections[ImportSection.SERVICES] = "${configured.size}"
        sections[ImportSection.SERVICES] = count?.let { "$it" }
        sections[ImportSection.SMS] = null
        sections[ImportSection.SOUL] = null
        sections[ImportSection.SPLINTERLANDS] = null
        sections[ImportSection.TOOLS] = "$enabled"
        sections[ImportSection.TOOLS] = enabled?.let { "$it" }
        settings.putBoolean("$KEY_TOOL_PREFIX$toolId", enabled)
        settings.putBoolean(KEY_CURRENT_CONVERSATION_MIGRATED, true)
        settings.putBoolean(KEY_CURRENT_INTERACTIVE_MODE, enabled)
        settings.putBoolean(KEY_DAEMON_ENABLED, enabled)
        settings.putBoolean(KEY_DYNAMIC_UI_ENABLED, enabled)
        settings.putBoolean(KEY_EMAIL_ENABLED, enabled)
        settings.putBoolean(KEY_FREE_FALLBACK_ENABLED, enabled)
        settings.putBoolean(KEY_FREE_SERVICE_PRIMARY, primary)
        settings.putBoolean(KEY_MEMORY_ENABLED, enabled)
        settings.putBoolean(KEY_NOTIFICATIONS_ENABLED, enabled)
        settings.putBoolean(KEY_SANDBOX_ENABLED, enabled)
        settings.putBoolean(KEY_SCHEDULING_ENABLED, enabled)
        settings.putBoolean(KEY_SMS_ENABLED, enabled)
        settings.putBoolean(KEY_SMS_SEND_ENABLED, enabled)
        settings.putBoolean(KEY_SPLINTERLANDS_ENABLED, enabled)
        settings.putFloat(KEY_UI_SCALE, scale)
        settings.putInt("$KEY_MODEL_CONTEXT_PREFIX$modelId", contextTokens)
        settings.putInt(KEY_APP_OPENS, newCount)
        settings.putInt(KEY_EMAIL_POLL_INTERVAL, minutes)
        settings.putInt(KEY_SMS_POLL_INTERVAL, minutes)
        settings.putString("${KEY_EMAIL_PASSWORD_PREFIX}$accountId", password)
        settings.putString("${KEY_EMAIL_SYNC_PREFIX}$accountId", json)
        settings.putString("${KEY_SPLINTERLANDS_POSTING_KEY}_$accountId", key)
        settings.putString(KEY_AGENT_MEMORIES, json)
        settings.putString(KEY_CONVERSATIONS, json)
        settings.putString(KEY_EMAIL_ACCOUNTS, json)
        settings.putString(KEY_EMAIL_PENDING, json)
        settings.putString(KEY_FREE_MODE, mode.name)
        settings.putString(KEY_HEARTBEAT_CONFIG, json)
        settings.putString(KEY_HEARTBEAT_LOG, json)
        settings.putString(KEY_HEARTBEAT_PROMPT, text)
        settings.putString(KEY_KAI_BUILD_LAUNCH_AGENT, agentId.orEmpty())
        settings.putString(KEY_MCP_SERVERS, json)
        settings.putString(KEY_NOTIFICATIONS_PENDING, json)
        settings.putString(KEY_NOTIFICATIONS_STORE, json)
        settings.putString(KEY_NOTIFICATIONS_SYNC_STATE, json)
        settings.putString(KEY_SANDBOX_DISTRO, distro.id)
        settings.putString(KEY_SCHEDULED_TASKS, json)
        settings.putString(KEY_SMS_DRAFTS, json)
        settings.putString(KEY_SMS_PENDING, json)
        settings.putString(KEY_SMS_SYNC_STATE, json)
        settings.putString(KEY_SOUL, text)
        settings.putString(KEY_SPLINTERLANDS_ACCOUNT, json)
        settings.putString(KEY_SPLINTERLANDS_BATTLE_LOG, json)
        settings.putString(KEY_SPLINTERLANDS_INSTANCE_ID, instanceId)
        settings.putString(KEY_SPLINTERLANDS_INSTANCE_IDS, json)
        settings.putString(KEY_THEME_MODE, mode.name)
        settings.remove("${KEY_EMAIL_PASSWORD_PREFIX}$accountId")
        settings.remove(KEY_CONVERSATIONS)
        val count = json["agent_memories"]?.jsonArray?.size
        val count = json["configured_services"]?.jsonArray?.size
        val count = json["email_accounts"]?.jsonArray?.size
        val count = json["mcp_servers"]?.jsonArray?.size
        val count = json["scheduled_tasks"]?.jsonArray?.size
        val count = try {
        val currentCount = settings.getInt(KEY_APP_OPENS, 0)
        val enabled = json["tool_overrides"]?.jsonObject?.count { (_, v) ->
        val enabled = toolOverrides.count { (_, v) ->
        val encoded = settings.getStringOrNull(KEY_ENCRYPTION_KEY) ?: return null
        val newCount = currentCount + 1
        val raw = settings.getString(KEY_THEME_MODE, "")
        val stored = settings.getStringOrNull(KEY_FREE_MODE) ?: return FreeMode.FAST
        }
        } catch (_: Exception) {
        } else {
     * "picked the shell" both come back as null.
     * Kai Build's "Open with" choice — the agent a freshly opened project starts,
     * Sandboxes predating the picker never recorded one, and the default must
     * The distribution the user actually picked, or null if they never have.
     * Which distribution the shell integration runs in. Each keeps its own
     * install, so changing this points the sandbox at the other one rather than
     * is what everything downstream reads.
     * not be mistaken for a choice — it would point them away from the Linux
     * or null for a plain shell. Stored as an empty string so "never picked" and
     * replacing anything — and an install always records its own distro, which
     * they have been using all along.
     */
    /**
    // Agent memories
    // App open tracking
    // Daemon mode
    // Dynamic UI
    // Email
    // Free fallback
    // Heartbeat config
    // Heartbeat log
    // Heartbeat prompt
    // Linux Sandbox
    // Local model context size
    // MCP Servers
    // Memory
    // Notifications (FOSS-only, Android-only — settings layer is platform-agnostic, feature
    // SMS (FOSS-only, Android-only — settings layer is platform-agnostic, feature gate
    // Scheduling
    // Soul (system prompt)
    // Splinterlands
    // Tool enable/disable settings
    // UI Scale
    // gate is enforced by the listener service being declared only in foss/AndroidManifest.xml)
    // is enforced by the READ_SMS permission being declared only in foss/AndroidManifest.xml)
    CONVERSATIONS,
    Dark,
    EMAIL,
    HEARTBEAT,
    Light,
    MCP,
    MEMORY,
    OledBlack,
    SCHEDULING,
    SERVICES,
    SMS,
    SOUL,
    SPLINTERLANDS,
    System,
    TOOLS,
    companion object {
    fun getConversationsJson(): String? = settings.getStringOrNull(KEY_CONVERSATIONS)
    fun getCurrentConversationId(): String? = settings.getStringOrNull(KEY_CURRENT_CONVERSATION_ID)
    fun getCurrentInteractiveMode(): Boolean = settings.getBoolean(KEY_CURRENT_INTERACTIVE_MODE, false)
    fun getEmailAccountsJson(): String = settings.getString(KEY_EMAIL_ACCOUNTS, "")
    fun getEmailPassword(accountId: String): String = settings.getString("${KEY_EMAIL_PASSWORD_PREFIX}$accountId", "")
    fun getEmailPendingJson(): String = settings.getString(KEY_EMAIL_PENDING, "")
    fun getEmailPollIntervalMinutes(): Int = settings.getInt(KEY_EMAIL_POLL_INTERVAL, 15)
    fun getEmailSyncStateJson(accountId: String): String = settings.getString("${KEY_EMAIL_SYNC_PREFIX}$accountId", "")
    fun getEncryptionKey(): ByteArray? {
    fun getFreeMode(): FreeMode {
    fun getHeartbeatConfigJson(): String = settings.getString(KEY_HEARTBEAT_CONFIG, "")
    fun getHeartbeatLogJson(): String = settings.getString(KEY_HEARTBEAT_LOG, "")
    fun getHeartbeatPrompt(): String = settings.getString(KEY_HEARTBEAT_PROMPT, "")
    fun getKaiBuildLaunchAgent(): String? = settings.getStringOrNull(KEY_KAI_BUILD_LAUNCH_AGENT)?.takeIf { it.isNotEmpty() }
    fun getMcpServersJson(): String = settings.getString(KEY_MCP_SERVERS, "")
    fun getMemoriesJson(): String = settings.getString(KEY_AGENT_MEMORIES, "[]")
    fun getMemoryInstructions(): String = settings.getString(KEY_MEMORY_INSTRUCTIONS, DEFAULT_MEMORY_INSTRUCTIONS)
    fun getModelContextTokens(modelId: String): Int = settings.getInt("$KEY_MODEL_CONTEXT_PREFIX$modelId", 0)
    fun getNotificationsPendingJson(): String = settings.getString(KEY_NOTIFICATIONS_PENDING, "")
    fun getNotificationsStoreJson(): String = settings.getString(KEY_NOTIFICATIONS_STORE, "")
    fun getNotificationsSyncStateJson(): String = settings.getString(KEY_NOTIFICATIONS_SYNC_STATE, "")
    fun getSandboxDistro(): LinuxDistro = LinuxDistro.fromId(settings.getStringOrNull(KEY_SANDBOX_DISTRO))
    fun getSandboxDistroOrNull(): LinuxDistro? = settings.getStringOrNull(KEY_SANDBOX_DISTRO)
    fun getScheduledTasksJson(): String = settings.getString(KEY_SCHEDULED_TASKS, "[]")
    fun getSmsDraftsJson(): String = settings.getString(KEY_SMS_DRAFTS, "")
    fun getSmsPendingJson(): String = settings.getString(KEY_SMS_PENDING, "")
    fun getSmsPollIntervalMinutes(): Int = settings.getInt(KEY_SMS_POLL_INTERVAL, 15)
    fun getSmsSyncStateJson(): String = settings.getString(KEY_SMS_SYNC_STATE, "")
    fun getSoulText(): String = settings.getString(KEY_SOUL, "")
    fun getSplinterlandsAccountJson(): String = settings.getString(KEY_SPLINTERLANDS_ACCOUNT, "")
    fun getSplinterlandsBattleLogJson(): String = settings.getString(KEY_SPLINTERLANDS_BATTLE_LOG, "")
    fun getSplinterlandsInstanceId(): String = settings.getString(KEY_SPLINTERLANDS_INSTANCE_ID, "")
    fun getSplinterlandsInstanceIdsJson(): String = settings.getString(KEY_SPLINTERLANDS_INSTANCE_IDS, "")
    fun getSplinterlandsPostingKey(): String = settings.getString(KEY_SPLINTERLANDS_POSTING_KEY, "")
    fun getSplinterlandsPostingKey(accountId: String): String = settings.getString("${KEY_SPLINTERLANDS_POSTING_KEY}_$accountId", "")
    fun getThemeMode(): ThemeMode = _themeModeFlow.value
    fun getUiScale(): Float = _uiScaleFlow.value
    fun isCurrentConversationMigrated(): Boolean = settings.getBoolean(KEY_CURRENT_CONVERSATION_MIGRATED, false)
    fun isDaemonEnabled(): Boolean = settings.getBoolean(KEY_DAEMON_ENABLED, false)
    fun isDynamicUiEnabled(): Boolean = settings.getBoolean(KEY_DYNAMIC_UI_ENABLED, true)
    fun isEmailEnabled(): Boolean = settings.getBoolean(KEY_EMAIL_ENABLED, true)
    fun isFreeFallbackEnabled(): Boolean = settings.getBoolean(KEY_FREE_FALLBACK_ENABLED, true)
    fun isFreeServicePrimary(): Boolean = settings.getBoolean(KEY_FREE_SERVICE_PRIMARY, false)
    fun isMemoryEnabled(): Boolean = settings.getBoolean(KEY_MEMORY_ENABLED, true)
    fun isNotificationsEnabled(): Boolean = settings.getBoolean(KEY_NOTIFICATIONS_ENABLED, false)
    fun isSandboxEnabled(): Boolean = settings.getBoolean(KEY_SANDBOX_ENABLED, true)
    fun isSchedulingEnabled(): Boolean = settings.getBoolean(KEY_SCHEDULING_ENABLED, true)
    fun isSmsEnabled(): Boolean = settings.getBoolean(KEY_SMS_ENABLED, false)
    fun isSmsSendEnabled(): Boolean = settings.getBoolean(KEY_SMS_SEND_ENABLED, false)
    fun isSplinterlandsEnabled(): Boolean = settings.getBoolean(KEY_SPLINTERLANDS_ENABLED, false)
    fun isToolEnabled(toolId: String, defaultEnabled: Boolean = true): Boolean = settings.getBoolean("$KEY_TOOL_PREFIX$toolId", defaultEnabled)
    fun markCurrentConversationMigrated() {
    fun removeConversationsJson() {
    fun removeEmailPassword(accountId: String) {
    fun setConversationsJson(json: String) {
    fun setCurrentConversationId(id: String?) {
    fun setCurrentInteractiveMode(enabled: Boolean) {
    fun setDaemonEnabled(enabled: Boolean) {
    fun setDynamicUiEnabled(enabled: Boolean) {
    fun setEmailAccountsJson(json: String) {
    fun setEmailEnabled(enabled: Boolean) {
    fun setEmailPassword(accountId: String, password: String) {
    fun setEmailPendingJson(json: String) {
    fun setEmailPollIntervalMinutes(minutes: Int) {
    fun setEmailSyncStateJson(accountId: String, json: String) {
    fun setFreeFallbackEnabled(enabled: Boolean) {
    fun setFreeMode(mode: FreeMode) {
    fun setFreeServicePrimary(primary: Boolean) {
    fun setHeartbeatConfigJson(json: String) {
    fun setHeartbeatLogJson(json: String) {
    fun setHeartbeatPrompt(text: String) {
    fun setKaiBuildLaunchAgent(agentId: String?) {
    fun setMcpServersJson(json: String) {
    fun setMemoriesJson(json: String) {
    fun setMemoryEnabled(enabled: Boolean) {
    fun setModelContextTokens(modelId: String, contextTokens: Int) {
    fun setNotificationsEnabled(enabled: Boolean) {
    fun setNotificationsPendingJson(json: String) {
    fun setNotificationsStoreJson(json: String) {
    fun setNotificationsSyncStateJson(json: String) {
    fun setSandboxDistro(distro: LinuxDistro) {
    fun setSandboxEnabled(enabled: Boolean) {
    fun setScheduledTasksJson(json: String) {
    fun setSchedulingEnabled(enabled: Boolean) {
    fun setSmsDraftsJson(json: String) {
    fun setSmsEnabled(enabled: Boolean) {
    fun setSmsPendingJson(json: String) {
    fun setSmsPollIntervalMinutes(minutes: Int) {
    fun setSmsSendEnabled(enabled: Boolean) {
    fun setSmsSyncStateJson(json: String) {
    fun setSoulText(text: String) {
    fun setSplinterlandsAccountJson(json: String) {
    fun setSplinterlandsBattleLogJson(json: String) {
    fun setSplinterlandsEnabled(enabled: Boolean) {
    fun setSplinterlandsInstanceId(instanceId: String) {
    fun setSplinterlandsInstanceIdsJson(json: String) {
    fun setSplinterlandsPostingKey(accountId: String, key: String) {
    fun setThemeMode(mode: ThemeMode) {
    fun setToolEnabled(toolId: String, enabled: Boolean) {
    fun setUiScale(scale: Float) {
    fun trackAppOpen(): Int {
    if (configured != null && configured.isNotEmpty()) {
    if (conversations != null && conversations.isNotEmpty()) {
    if (emails != null && emails.isNotEmpty()) {
    if (heartbeatHasPrompt || heartbeatHasConfig || heartbeatHasLog) {
    if (json["configured_services"] != null || json["current_service_id"] != null || json["free_fallback_enabled"] != null || json["instance_settings"] != null) {
    if (json["conversations"] != null) {
    if (json["email_enabled"] != null || json["email_accounts"] != null) {
    if (json["heartbeat_config"] != null || json["heartbeat_prompt"] != null || json["heartbeat_log"] != null) {
    if (json["mcp_servers"] != null) {
    if (json["memory_enabled"] != null || json["agent_memories"] != null) {
    if (json["scheduling_enabled"] != null || json["scheduled_tasks"] != null) {
    if (json["sms_enabled"] != null || json["sms_poll_interval"] != null || json["sms_send_enabled"] != null) {
    if (json["soul_text"] != null) {
    if (json["splinterlands_account"] != null) {
    if (json["splinterlands_enabled"] != null || json["splinterlands_account"] != null) {
    if (json["tool_overrides"] != null) {
    if (mcp != null && mcp.isNotEmpty()) {
    if (memories != null && memories.isNotEmpty()) {
    if (smsEnabled || smsSendEnabled) {
    if (tasks != null && tasks.isNotEmpty()) {
    if (toolOverrides != null && toolOverrides.isNotEmpty()) {
    private fun loadInitialThemeMode(): ThemeMode {
    private val _themeModeFlow = MutableStateFlow(loadInitialThemeMode())
    private val _uiScaleFlow = MutableStateFlow(settings.getFloat(KEY_UI_SCALE, defaultUiScale))
    return sections
    val configured = json["configured_services"]?.jsonArray
    val conversations = json["conversations"]?.jsonArray
    val emails = json["email_accounts"]?.jsonArray
    val heartbeatHasConfig = json["heartbeat_config"] != null
    val heartbeatHasLog = json["heartbeat_log"]?.jsonArray?.isNotEmpty() == true
    val heartbeatHasPrompt = json["heartbeat_prompt"] != null
    val instanceId: String,
    val mcp = json["mcp_servers"]?.jsonArray
    val memories = json["agent_memories"]?.jsonArray
    val sections = mutableMapOf<ImportSection, String?>()
    val serviceId: String,
    val smsEnabled = json["sms_enabled"]?.jsonPrimitive?.content?.toBoolean() == true
    val smsSendEnabled = json["sms_send_enabled"]?.jsonPrimitive?.content?.toBoolean() == true
    val tasks = json["scheduled_tasks"]?.jsonArray
    val themeModeFlow: StateFlow<ThemeMode> = _themeModeFlow
    val toolOverrides = json["tool_overrides"]?.jsonObject
    val uiScaleFlow: StateFlow<Float> = _uiScaleFlow
    }
 * Stricter than [detectImportSections]: only includes sections that contain actual user data,
 * `splinterlands_enabled = false`, `mcp_servers = []`). Used to drive the Export preview dialog.
 * skipping ones that exist purely because of default feature-toggle flags (e.g. `sms_enabled = false`,
 */
)
/**
class AppSettings(internal val settings: Settings) {
data class ServiceInstance(
enum class ImportSection {
enum class ThemeMode {
fun detectExportableSections(json: JsonObject): Map<ImportSection, String?> {
fun detectImportSections(json: JsonObject): Map<ImportSection, String?> {
import com.inspiredandroid.kai.defaultUiScale
import com.inspiredandroid.kai.linux.LinuxDistro
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
package com.inspiredandroid.kai.data
}
