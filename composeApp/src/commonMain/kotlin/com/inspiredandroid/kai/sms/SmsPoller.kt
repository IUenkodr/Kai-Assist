package com.inspiredandroid.kai.sms
import com.inspiredandroid.kai.data.SmsStore
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

                        lastAttemptEpochMs = attemptAt,
                        lastError = "Permission not granted",
                        lastError = null,
                        lastSeenId = smsReader.currentMaxInboxId(),
                        lastSyncEpochMs = attemptAt,
                    ),
                    lastAttemptEpochMs = attemptAt,
                    lastError = e.message ?: e::class.simpleName ?: "Poll failed",
                    syncState.copy(
                )
                ),
                lastAttemptEpochMs = attemptAt,
                lastError = null,
                lastSyncEpochMs = attemptAt,
                return
                smsStore.addPending(newMessages)
                smsStore.updateSyncState(
                syncState.copy(
                unreadCount = newMessages.count { !it.read },
                updated = updated.copy(lastSeenId = newMessages.maxOf { it.id })
            )
            // First-time enable: seed lastSeenId to the current max and skip the read —
            // everything already in the inbox is "history" and shouldn't flood the
            // pending queue. Subsequent polls only pick up messages with _id > lastSeenId.
            if (!smsReader.hasPermission()) {
            if (newMessages.isNotEmpty()) {
            if (syncState.lastSeenId == 0L) {
            smsStore.updateSyncState(
            smsStore.updateSyncState(updated)
            val newMessages = smsReader.readInboxSince(syncState.lastSeenId, MAX_FETCH_PER_POLL)
            var updated = syncState.copy(
            }
        const val MAX_FETCH_PER_POLL = 50
        if (!smsReader.isSupported()) return
        try {
        val attemptAt = Clock.System.now().toEpochMilliseconds()
        val syncState = smsStore.getSyncState()
        }
        } catch (e: Exception) {
    companion object {
    private val smsReader: SmsReader,
    private val smsStore: SmsStore,
    suspend fun poll() {
    }
) {
@OptIn(ExperimentalTime::class)
class SmsPoller(
}
