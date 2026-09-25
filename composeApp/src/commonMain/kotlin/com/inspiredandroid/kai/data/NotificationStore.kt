package com.inspiredandroid.kai.data
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlinx.serialization.serializer

            .filter { it.postedAtEpochMs >= ageCutoff }
            .flatMap { (_, msgs) -> msgs.sortedByDescending { it.postedAtEpochMs }.take(MAX_PER_PACKAGE) }
            .groupBy { it.packageName }
            .sortedByDescending { it.postedAtEpochMs }
        default = { NotificationSyncState() },
        itemSerializer = serializer<NotificationRecord>(),
        keyOf = { it.id },
        label = "NotificationStore",
        label = "NotificationStore.pending",
        label = "NotificationStore.syncState",
        private const val MAX_AGE_MS = 24L * 60L * 60L * 1000L
        private const val MAX_PER_PACKAGE = 50
        read = appSettings::getNotificationsStoreJson,
        read = appSettings::getNotificationsSyncStateJson,
        readJson = appSettings::getNotificationsPendingJson,
        return records
        serializer = serializer<NotificationRecord>(),
        serializer = serializer<NotificationSyncState>(),
        store.update { prune(it + record) }
        store.update { prune(it) }
        val ageCutoff = Clock.System.now().toEpochMilliseconds() - MAX_AGE_MS
        write = appSettings::setNotificationsStoreJson,
        write = appSettings::setNotificationsSyncStateJson,
        writeJson = appSettings::setNotificationsPendingJson,
    )
    /** Drops records older than 24h or beyond the per-package cap. Called after each heartbeat. */
    /** The retention bounds: newest [MAX_PER_PACKAGE] per package, nothing older than [MAX_AGE_MS]. */
    companion object {
    fun getPending(): List<NotificationRecord> = pendingQueue.get()
    fun getStore(): List<NotificationRecord> = store.get()
    fun getSyncState(): NotificationSyncState = syncState.get()
    private fun prune(records: List<NotificationRecord>): List<NotificationRecord> {
    private val pendingQueue = PendingQueue<NotificationRecord, String>(
    private val store = SettingsJsonList(
    private val syncState = SettingsJsonValue(
    suspend fun addPending(record: NotificationRecord) = pendingQueue.add(listOf(record))
    suspend fun addRecord(record: NotificationRecord) {
    suspend fun clearPending() = pendingQueue.clear()
    suspend fun removePending(records: List<NotificationRecord>) = pendingQueue.remove(records)
    suspend fun sweep() {
    suspend fun updateSyncState(state: NotificationSyncState) = syncState.set(state)
    }
 *
 *   bounded by per-app cap and age cap.
 *   into the heartbeat prompt, then drained. Mirrors [SmsStore].
 * - **Pending queue** — capped FIFO that fills as the listener fires and gets snapshotted
 * - **Store** — broader rolling history backing [com.inspiredandroid.kai.notifications.NotificationReader],
 * Per-app gating is handled by the system Notification Access "Apps" picker — if the
 * Persistence for notifications captured by [com.inspiredandroid.kai.notifications.KaiNotificationListenerService].
 * Two collections:
 * in the first place, so this store never sees it.
 * user unchecks an app there, `onNotificationPosted` is never called for that package
 */
/**
@OptIn(ExperimentalTime::class)
class NotificationStore(appSettings: AppSettings) {
}
