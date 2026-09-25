package com.inspiredandroid.kai.data
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

        const val PREVIEW_CHARS = 200
    companion object {
    val appLabel: String,
    val category: String = "",
    val id: String,
    val isOngoing: Boolean = false,
    val lastBoundEpochMs: Long = 0L,
    val lastError: String? = null,
    val listenerBound: Boolean = false,
    val packageName: String,
    val postedAtEpochMs: Long,
    val preview: String = text.take(PREVIEW_CHARS),
    val subtext: String = "",
    val text: String,
    val title: String,
    }
)
) {
@Immutable
@Serializable
data class NotificationRecord(
data class NotificationSyncState(
}
