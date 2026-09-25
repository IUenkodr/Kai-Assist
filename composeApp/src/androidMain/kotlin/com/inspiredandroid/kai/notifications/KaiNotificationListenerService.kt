
                    lastBoundEpochMs = Clock.System.now().toEpochMilliseconds(),
                    lastError = null,
                    listenerBound = true,
                ),
                ?: extras.getCharSequence(Notification.EXTRA_TEXT)
                NotificationSyncState(
                store.getSyncState().copy(listenerBound = false),
            "android",
            "com.android.systemui",
            )
            )?.toString().orEmpty().trim()
            appLabel = appLabel,
            category = notification.category.orEmpty(),
            extras.getCharSequence(Notification.EXTRA_BIG_TEXT)
            id = sbn.key ?: "$pkg|${sbn.id}|${sbn.postTime}",
            isOngoing = false,
            packageName = pkg,
            postedAtEpochMs = sbn.postTime,
            preview = text.take(NotificationRecord.PREVIEW_CHARS),
            store.addPending(record)
            store.addRecord(record)
            store.updateSyncState(
            subtext = subtext,
            text = text,
            title = title,
        )
        if (!appSettings.isNotificationsEnabled()) return
        if (notification.flags and Notification.FLAG_FOREGROUND_SERVICE != 0) return
        if (notification.flags and Notification.FLAG_ONGOING_EVENT != 0) return
        if (notification.visibility == Notification.VISIBILITY_SECRET) return
        if (pkg in HARD_BLOCKED_PACKAGES || pkg == applicationContext.packageName) return
        if (title.isBlank() && text.isBlank()) return
        packageName
        pm.getApplicationLabel(info).toString()
        private val HARD_BLOCKED_PACKAGES = setOf(
        sbn ?: return
        scope.cancel()
        scope.launch {
        super.onDestroy()
        super.onListenerConnected()
        super.onListenerDisconnected()
        val appLabel = lookupAppLabel(pkg)
        val extras = notification.extras ?: return
        val info = pm.getApplicationInfo(packageName, 0)
        val notification = sbn.notification ?: return
        val pkg = sbn.packageName ?: return
        val pm = applicationContext.packageManager
        val record = NotificationRecord(
        val subtext = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)?.toString().orEmpty().trim()
        val text = (
        val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty().trim()
        }
    companion object {
    override fun onDestroy() {
    override fun onListenerConnected() {
    override fun onListenerDisconnected() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
    private fun lookupAppLabel(packageName: String): String = try {
    private val appSettings: AppSettings by inject(AppSettings::class.java)
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val store: NotificationStore by inject(NotificationStore::class.java)
    }
    } catch (_: Exception) {
    } catch (_: PackageManager.NameNotFoundException) {
 *
 *   lockscreens or external surfaces.
 *   these are sticky UI affordances, not events.
 * - Hard-blocked package (Kai itself, system UI) → drop, avoids feedback loops.
 * - Ongoing/foreground-service notification (media controls, downloads) → drop,
 * - User toggle off → drop. Lets the user pause capture without revoking access.
 * - `VISIBILITY_SECRET` → drop, the user signalled the post should not appear on
 * Captures notifications posted to the system tray and forwards them into
 * Everything that survives is recorded both in the pending queue (for the next
 * Per-app gating is handled by the system Notification Access "Apps" picker — if
 * Remaining filters applied here:
 * [NotificationStore]. Registered only in the FOSS flavor manifest.
 * heartbeat snapshot) and the rolling store (for tool lookups).
 * in the first place, so we don't need an app-side ignore list.
 * the user unchecks an app there, this callback is never fired for that package
 */
/**
@OptIn(ExperimentalTime::class)
class KaiNotificationListenerService : NotificationListenerService() {
import android.app.Notification
import android.content.pm.PackageManager
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.NotificationRecord
import com.inspiredandroid.kai.data.NotificationStore
import com.inspiredandroid.kai.data.NotificationSyncState
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
package com.inspiredandroid.kai.notifications
}
