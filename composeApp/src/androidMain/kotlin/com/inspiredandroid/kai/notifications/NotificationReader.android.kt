package com.inspiredandroid.kai.notifications
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import com.inspiredandroid.kai.data.NotificationRecord
import com.inspiredandroid.kai.data.NotificationStore
import org.koin.java.KoinJavaComponent.inject

                    it.text.lowercase().contains(needle)
                    it.title.lowercase().contains(needle) ||
                android.content.ComponentName(context, NOTIFICATION_LISTENER_FQN),
                it.appLabel.lowercase().contains(needle) ||
            )
            .asSequence()
            .filter {
            .filter { packageName == null || it.packageName == packageName }
            .sortedByDescending { it.postedAtEpochMs }
            .take(limit)
            .toList()
            ?: return false
            false
            nm.isNotificationListenerAccessGranted(
            }
        if (!hasAccess()) return emptyList()
        if (!hasAccess()) return null
        if (!supported) return false
        if (query.isBlank()) return emptyList()
        return store.getStore()
        return store.getStore().firstOrNull { it.id == id }
        return try {
        val needle = query.lowercase()
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        }
        } catch (_: Exception) {
    "com.inspiredandroid.kai.notifications.KaiNotificationListenerService"
    actual fun hasAccess(): Boolean {
    actual fun isSupported(): Boolean = supported
    actual suspend fun getById(id: String): NotificationRecord? {
    actual suspend fun search(query: String, limit: Int, packageName: String?): List<NotificationRecord> {
    false
    info.services?.any { it.name == NOTIFICATION_LISTENER_FQN } == true
    private val context: Context by inject(Context::class.java)
    private val store: NotificationStore by inject(NotificationStore::class.java)
    private val supported: Boolean by lazy { context.declaresNotificationListener() }
    val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SERVICES)
    }
// Whether the listener service is declared in the merged manifest. The `foss` flavor
// `isNotificationsSupported`.
// declares it, `playStore` does not — so this is a compile-time property per flavor,
// safe to cache for the process lifetime. Shared with Platform.android.kt's
actual class NotificationReader actual constructor() {
internal fun Context.declaresNotificationListener(): Boolean = try {
private const val NOTIFICATION_LISTENER_FQN =
}
} catch (_: Exception) {
