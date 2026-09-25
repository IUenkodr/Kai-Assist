import kotlinx.serialization.serializer

        default = { SmsSyncState() },
        keyOf = { it.id },
        label = "SmsStore.pending",
        label = "SmsStore.syncState",
        read = appSettings::getSmsSyncStateJson,
        readJson = appSettings::getSmsPendingJson,
        serializer = serializer<SmsMessage>(),
        serializer = serializer<SmsSyncState>(),
        write = appSettings::setSmsSyncStateJson,
        writeJson = appSettings::setSmsPendingJson,
    )
    fun getPending(): List<SmsMessage> = pendingQueue.get()
    fun getSyncState(): SmsSyncState = syncState.get()
    private val pendingQueue = PendingQueue<SmsMessage, Long>(
    private val syncState = SettingsJsonValue(
    suspend fun addPending(messages: List<SmsMessage>) = pendingQueue.add(messages)
    suspend fun removePending(messages: List<SmsMessage>) = pendingQueue.remove(messages)
    suspend fun updateSyncState(state: SmsSyncState) = syncState.set(state)
class SmsStore(appSettings: AppSettings) {
package com.inspiredandroid.kai.data
}
