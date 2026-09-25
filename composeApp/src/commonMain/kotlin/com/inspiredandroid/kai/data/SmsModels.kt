package com.inspiredandroid.kai.data
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

    FAILED,
    PENDING,
    SENDING,
    SENT,
    val address: String,
    val body: String = "",
    val body: String,
    val createdAtEpochMs: Long,
    val date: Long,
    val id: Long,
    val id: String,
    val inReplyToSmsId: Long? = null,
    val lastAttemptEpochMs: Long = 0L,
    val lastError: String? = null,
    val lastSeenId: Long = 0L,
    val lastSyncEpochMs: Long = 0L,
    val preview: String,
    val read: Boolean = false,
    val status: SmsDraftStatus = SmsDraftStatus.PENDING,
    val unreadCount: Int = 0,
 * An outgoing SMS the AI has staged. Nothing is actually sent until the user
 * defensive gate between AI intent and real-world action.
 * taps Send in the `PendingSmsBanner` — the existence of a draft is the
 */
)
/**
@Immutable
@Serializable
data class SmsDraft(
data class SmsMessage(
data class SmsSyncState(
enum class SmsDraftStatus {
}
