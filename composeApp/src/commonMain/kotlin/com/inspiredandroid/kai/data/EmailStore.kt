
            appSettings.removeEmailPassword(id)
            if (removed) current.filterNot { it.id == id } else current
            removeSyncState(id)
            removed = current.any { it.id == id }
        accounts.update { current ->
        accounts.update { current -> current.filterNot { it.id == account.id } + account }
        appSettings.setEmailPassword(accountId, password)
        appSettings.setEmailSyncStateJson(accountId, "")
        appSettings.setEmailSyncStateJson(state.accountId, json.encodeToString(state))
        if (removed) {
        itemSerializer = serializer<EmailAccount>(),
        keyOf = { it.accountId to it.uid },
        label = "EmailStore",
        label = "EmailStore.pending",
        label = "EmailStore.syncState",
        raw = appSettings.getEmailSyncStateJson(accountId),
        read = appSettings::getEmailAccountsJson,
        readJson = appSettings::getEmailPendingJson,
        return account
        return removed
        serializer = serializer<EmailMessage>(),
        serializer = serializer<EmailSyncState>(),
        var removed = false
        write = appSettings::setEmailAccountsJson,
        writeJson = appSettings::setEmailPendingJson,
        }
    )
    ) { EmailSyncState(accountId = accountId) }
    // Capped FIFO so a disabled or slow heartbeat can't let the buffer grow unbounded.
    // Password management (stored separately for security)
    // Sync state — one settings key per account, so it can't be a single accessor instance.
    fun getAccount(id: String): EmailAccount? = getAccounts().find { it.id == id }
    fun getAccounts(): List<EmailAccount> = accounts.get()
    fun getAllSyncStates(): Map<String, EmailSyncState> = getAccounts().associate { it.id to getSyncState(it.id) }
    fun getPassword(accountId: String): String = appSettings.getEmailPassword(accountId)
    fun getPending(): List<EmailMessage> = pendingQueue.get()
    fun getSyncState(accountId: String): EmailSyncState = decodeJsonOr(
    private fun removeSyncState(accountId: String) {
    private val accounts = SettingsJsonList(
    private val json = SharedJson
    private val pendingQueue = PendingQueue<EmailMessage, Pair<String, Long>>(
    suspend fun addAccount(account: EmailAccount): EmailAccount {
    suspend fun addPending(emails: List<EmailMessage>) = pendingQueue.add(emails)
    suspend fun removeAccount(id: String): Boolean {
    suspend fun removePending(emails: List<EmailMessage>) = pendingQueue.remove(emails)
    suspend fun setPassword(accountId: String, password: String) {
    suspend fun updateSyncState(state: EmailSyncState) {
    }
class EmailStore(private val appSettings: AppSettings) {
import kotlinx.serialization.serializer
package com.inspiredandroid.kai.data
}
