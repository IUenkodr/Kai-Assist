
     * Full-text search across `appLabel`, `title`, and `text`. Newest-first, capped at [limit].
     * Optional [packageName] filter restricts to a single app.
     */
    /**
    /** Fetch a single record by `StatusBarNotification.key`. Null if not found. */
    /** True when [isSupported] and the user has granted notification listener access. */
    /** True when this build can ever capture notifications — i.e. Android + listener registered. */
    fun hasAccess(): Boolean
    fun isSupported(): Boolean
    suspend fun getById(id: String): NotificationRecord?
    suspend fun search(query: String, limit: Int, packageName: String?): List<NotificationRecord>
 *
 * Multiplatform notification reader. Only the Android FOSS build returns real data —
 * Unlike [com.inspiredandroid.kai.sms.SmsReader] which queries the system content
 * and wasm return no-op stubs (notification access is either restricted or doesn't
 * exist on those platforms).
 * merged manifest, which is only the case for the `foss` product flavor. iOS, desktop,
 * provider, this reads from the in-process [com.inspiredandroid.kai.data.NotificationStore]
 * the feature is gated by the `KaiNotificationListenerService` being declared in the
 * — the listener service writes records there as they arrive.
 */
/**
expect class NotificationReader() {
import com.inspiredandroid.kai.data.NotificationRecord
package com.inspiredandroid.kai.notifications
}
