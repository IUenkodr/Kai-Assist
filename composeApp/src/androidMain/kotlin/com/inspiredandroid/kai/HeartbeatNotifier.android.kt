import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.inspiredandroid.kai.shared.R
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.notification_channel_description
import kai.composeapp.generated.resources.notification_channel_name
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.getString
import org.koin.java.KoinJavaComponent.inject

            this.description = description
        .build()
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .setContentText(body)
        .setContentTitle(title)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setSmallIcon(R.drawable.ic_notification)
        .setStyle(NotificationCompat.BigTextStyle().bigText(body))
        HEARTBEAT_NOTIFICATION_ID,
        NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).apply {
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        context,
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent,
        putExtra(EXTRA_OPEN_HEARTBEAT, true)
        },
    )
    ensureChannel(notificationManager)
    if (manager.getNotificationChannel(CHANNEL_ID) != null) return
    manager.createNotificationChannel(
    notificationManager.notify(HEARTBEAT_NOTIFICATION_ID, notification)
    val context: Context by inject(Context::class.java)
    val description = runBlocking { getString(Res.string.notification_channel_description) }
    val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)?.apply {
    val name = runBlocking { getString(Res.string.notification_channel_name) }
    val notification = NotificationCompat.Builder(context, CHANNEL_ID)
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val pendingIntent = PendingIntent.getActivity(
    }
 * ChatViewModel observer can load the heartbeat conversation.
 * Fixed ID so a new heartbeat report replaces any earlier unread one in the tray
 * Intent extra read by MainActivity when the user taps a heartbeat notification. The
 * instead of piling up. The app only ever has one pending heartbeat conversation.
 * receiver forwards the signal to `DataRepository.requestOpenHeartbeat()` so the
 */
/**
/** Shared with the AI `send_notification` tool — ensures the channel is created once. */
actual fun sendHeartbeatNotification(title: String, body: String) {
const val EXTRA_OPEN_HEARTBEAT = "com.inspiredandroid.kai.OPEN_HEARTBEAT"
package com.inspiredandroid.kai
private const val CHANNEL_ID = "kai_ai_notifications"
private const val HEARTBEAT_NOTIFICATION_ID = 9002
private fun ensureChannel(manager: NotificationManager) {
}
