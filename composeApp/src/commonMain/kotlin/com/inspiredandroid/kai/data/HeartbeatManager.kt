import androidx.compose.runtime.Immutable
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

                        appLabel = record.appLabel,
                        id = record.id,
                        preview = record.preview,
                        title = record.title,
                    )
                    HeartbeatPendingNotification(
                    accountEmail = accountEmailById[msg.accountId] ?: msg.accountId,
                    from = msg.address,
                    from = msg.from,
                    id = msg.id,
                    preview = msg.preview,
                    subject = msg.subject,
                "If everything looks good and nothing needs attention, respond with exactly: HEARTBEAT_OK\n" +
                "If something needs attention (stale memories, due tasks, user follow-ups), address it.\n" +
                "You cannot enable, disable, or reschedule heartbeat — the schedule is a user setting."
                )
                .map { record ->
                .sortedByDescending { it.postedAtEpochMs }
                .take(MAX_NOTIFICATIONS_IN_PROMPT)
                HeartbeatPendingEmail(
                HeartbeatPendingSms(
                category = entry.category,
                content = entry.content,
                email = account.email,
                hitCount = entry.hitCount,
                key = entry.key,
                lastError = syncState.lastError,
                lastSyncEpochMs = syncState.lastSyncEpochMs,
                unreadCount = syncState.unreadCount,
                }
            "[HEARTBEAT] This is an automatic self-check. Review your memories and pending tasks. " +
            )
            EmailAccountSummary(
            HeartbeatPromotionCandidate(
            customOrDefaultPrompt = customPrompt.ifEmpty { DEFAULT_HEARTBEAT_PROMPT },
            emailAccounts = emailAccounts,
            emptyList()
            error = error,
            heartbeatAdditions = heartbeatAdditions,
            pendingEmails = heartbeatPending,
            pendingEmails.map { msg ->
            pendingNotifications
            pendingNotifications = heartbeatNotifications,
            pendingSms = heartbeatSms,
            pendingSms.map { msg ->
            pendingTasks = pendingTasks,
            promotionCandidates = promotionCandidates,
            recentResponses = recentResponses,
            success = success,
            timestampEpochMs = Clock.System.now().toEpochMilliseconds(),
            val syncState = emailStore!!.getSyncState(account.id)
            }
        )
        // Cap the heartbeat snapshot so a flurry of group-chat pings can't blow out the
        // Check active hours
        // Check elapsed time
        // prompt. Newest first; the rest stay in the pending queue and will surface on
        // subsequent heartbeats (or via `check_notifications` on demand).
        const val DEFAULT_HEARTBEAT_PROMPT =
        default = { HeartbeatConfig() },
        if (!config.enabled) return false
        if (currentHour < config.activeHoursStart || currentHour >= config.activeHoursEnd) return false
        itemSerializer = serializer<HeartbeatLogEntry>(),
        label = "HeartbeatManager.config",
        label = "HeartbeatManager.log",
        log.update { (listOf(entry) + it).take(MAX_LOG_ENTRIES) }
        pendingEmails: List<EmailMessage> = emptyList(),
        pendingNotifications: List<NotificationRecord> = emptyList(),
        pendingSms: List<SmsMessage> = emptyList(),
        private const val MAX_LOG_ENTRIES = 5
        private const val MAX_NOTIFICATIONS_IN_PROMPT = 20
        read = appSettings::getHeartbeatConfigJson,
        read = appSettings::getHeartbeatLogJson,
        recentResponses: List<String> = emptyList(),
        return buildHeartbeatPrompt(
        return elapsedMs >= intervalMs
        saveConfig(config.copy(lastHeartbeatEpochMs = Clock.System.now().toEpochMilliseconds()))
        serializer = serializer<HeartbeatConfig>(),
        val accountEmailById = accounts.associate { it.id to it.email }
        val accounts = if (emailEnabled) emailStore.getAccounts() else emptyList()
        val config = getConfig()
        val currentHour = localNow.hour
        val customPrompt = appSettings.getHeartbeatPrompt()
        val elapsedMs = now.toEpochMilliseconds() - config.lastHeartbeatEpochMs
        val emailAccounts: List<EmailAccountSummary> = accounts.map { account ->
        val emailEnabled = emailStore != null && appSettings.isEmailEnabled()
        val entry = HeartbeatLogEntry(
        val heartbeatAdditions = tasksSplit.heartbeatAdditions
        val heartbeatNotifications: List<HeartbeatPendingNotification> = if (notificationsEnabled) {
        val heartbeatPending: List<HeartbeatPendingEmail> = if (emailEnabled) {
        val heartbeatSms: List<HeartbeatPendingSms> = if (smsEnabled) {
        val intervalMs = config.intervalMinutes * 60_000L
        val localNow = now.toLocalDateTime(TimeZone.currentSystemDefault())
        val notificationsEnabled = appSettings.isNotificationsEnabled()
        val now = Clock.System.now()
        val pendingTasks = tasksSplit.scheduled
        val promotionCandidates = memoryStore.getPromotionCandidates().map { entry ->
        val smsEnabled = appSettings.isSmsEnabled()
        val tasksSplit = taskStore.getPendingTasksPartitioned()
        write = appSettings::setHeartbeatConfigJson,
        write = appSettings::setHeartbeatLogJson,
        }
        } else {
    )
    ): String {
    companion object {
    fun buildHeartbeatPrompt(
    fun getConfig(): HeartbeatConfig = config.get()
    fun getHeartbeatLog(): List<HeartbeatLogEntry> = log.get()
    fun isHeartbeatDue(): Boolean {
    fun markHeartbeatExecuted(config: HeartbeatConfig = getConfig()) {
    fun saveConfig(config: HeartbeatConfig) = this.config.set(config)
    private val appSettings: AppSettings,
    private val config = SettingsJsonValue(
    private val emailStore: EmailStore? = null,
    private val log = SettingsJsonList(
    private val memoryStore: MemoryStore,
    private val taskStore: TaskStore,
    suspend fun recordHeartbeat(success: Boolean, error: String? = null) {
    val activeHoursEnd: Int = 22,
    val activeHoursStart: Int = 8,
    val enabled: Boolean = true,
    val error: String? = null,
    val heartbeatInstanceId: String? = null,
    val intervalMinutes: Int = 30,
    val lastHeartbeatEpochMs: Long = 0L,
    val success: Boolean,
    val timestampEpochMs: Long,
    }
)
) {
@Immutable
@OptIn(ExperimentalTime::class)
@Serializable
class HeartbeatManager(
data class HeartbeatConfig(
data class HeartbeatLogEntry(
package com.inspiredandroid.kai.data
}
