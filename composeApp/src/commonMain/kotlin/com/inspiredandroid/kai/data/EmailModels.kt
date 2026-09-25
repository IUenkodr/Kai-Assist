import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

    val accountId: String,
    val body: String = "",
    val bodyHtml: String = "",
    val date: String = "",
    val displayName: String = "",
    val email: String,
    val from: String,
    val id: String,
    val imapHost: String,
    val imapPort: Int = 993,
    val isRead: Boolean = false,
    val lastAttemptEpochMs: Long = 0L,
    val lastError: String? = null,
    val lastSeenUid: Long = 0L,
    val lastSyncEpochMs: Long = 0L,
    val listUnsubscribe: String = "",
    val listUnsubscribePost: String = "",
    val messageId: String = "",
    val preview: String = "",
    val sentFolder: String = "",
    val smtpHost: String,
    val smtpPort: Int = 587,
    val subject: String,
    val to: String = "",
    val uid: Long,
    val unreadCount: Int = 0,
    val useStartTls: Boolean = true,
    val username: String = "",
)
@Immutable
@Serializable
data class EmailAccount(
data class EmailMessage(
data class EmailSyncState(
package com.inspiredandroid.kai.data
