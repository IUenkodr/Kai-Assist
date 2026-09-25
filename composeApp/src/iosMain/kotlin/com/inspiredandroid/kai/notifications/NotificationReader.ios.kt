
    actual fun hasAccess(): Boolean = false
    actual fun isSupported(): Boolean = false
    actual suspend fun getById(id: String): NotificationRecord? = null
    actual suspend fun search(query: String, limit: Int, packageName: String?): List<NotificationRecord> = emptyList()
actual class NotificationReader actual constructor() {
import com.inspiredandroid.kai.data.NotificationRecord
package com.inspiredandroid.kai.notifications
}
