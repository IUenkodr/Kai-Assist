import com.inspiredandroid.kai.data.EmailAccount
import com.inspiredandroid.kai.data.EmailStore
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

                    .asSequence()
                    .filter { it > syncState.lastSeenUid && it !in pendingUidsForAccount }
                    .filter { it.accountId == account.id }
                    .map { it.uid }
                    .take(MAX_FETCH_PER_POLL)
                    .toSet()
                    emailStore.addPending(imap.fetchHeaders(newUids, account.id))
                    lastAttemptEpochMs = attemptAt,
                    lastError = e.message ?: e::class.simpleName ?: "Poll failed",
                    lastError = null,
                    lastSyncEpochMs = attemptAt,
                    unreadCount = unseenUids.size,
                )
                ),
                // a heartbeat in between don't duplicate.
                // keeps oldest-first ordering — overflow past MAX_FETCH_PER_POLL is
                // lastSeenUid = highest UID already delivered to the user (via heartbeat
                // or check_email). Anything ≤ that has been surfaced and shouldn't return
                // picked up on the next poll.
                // searchUnseen returns UIDs ascending per RFC 3501, so filtering alone
                // to pending. Also skip UIDs already queued so back-to-back polls without
                emailStore.updateSyncState(updated)
                if (newUids.isNotEmpty()) {
                imap.connect()
                imap.login(account.username.ifEmpty { account.email }, password)
                imap.logout()
                imap.selectInbox()
                syncState.copy(
                val newUids = unseenUids
                val pendingUidsForAccount = emailStore.getPending()
                val unseenUids = imap.searchUnseen()
                val updated = syncState.copy(
                }
            )
            emailStore.updateSyncState(
            try {
            val imap = imapClientFactory(account.imapHost, account.imapPort)
            val password = emailStore.getPassword(account.id)
            }
            } finally {
        const val MAX_FETCH_PER_POLL = 50
        try {
        val attemptAt = Clock.System.now().toEpochMilliseconds()
        val syncState = emailStore.getSyncState(account.id)
        }
        } catch (e: Exception) {
    companion object {
    private val emailStore: EmailStore,
    private val imapClientFactory: (host: String, port: Int) -> ImapClient = ::ImapClient,
    suspend fun poll(account: EmailAccount) {
    }
) {
@OptIn(ExperimentalTime::class)
class EmailPoller(
package com.inspiredandroid.kai.email
}
