
                .build()
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText(message)
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_notification)
                .setStyle(NotificationCompat.BigTextStyle().bigText(message))
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
                context,
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent,
                notificationId,
                return NotificationResult.Error("Notification permission denied")
            )
            CHANNEL_ID,
            NotificationManager.IMPORTANCE_DEFAULT,
            NotificationResult.Error("Failed to send notification: ${e.message}")
            NotificationResult.Success(notificationId, message)
            channelName,
            description = channelDescription
            if (!granted) {
            notificationManager.notify(notificationId, notification)
            val granted = permissionController.requestPermission()
            val intent = context.packageManager.getLaunchIntentForPackage(context.packageName)?.apply {
            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            val notificationId = notificationIdCounter.incrementAndGet()
            val pendingIntent = PendingIntent.getActivity(
            }
        ).apply {
        // Check and request permission if needed
        createNotificationChannel()
        if (!permissionController.hasPermission()) {
        message: String,
        notificationManager.createNotificationChannel(channel)
        private const val CHANNEL_ID = "kai_ai_notifications"
        return try {
        title: String,
        val channel = NotificationChannel(
        val channelDescription = runBlocking { getString(Res.string.notification_channel_description) }
        val channelName = runBlocking { getString(Res.string.notification_channel_name) }
        }
        } catch (e: Exception) {
    ): NotificationResult {
    companion object {
    data class Error(val message: String) : NotificationResult()
    data class Success(val notificationId: Int, val message: String) : NotificationResult()
    init {
    private fun createNotificationChannel() {
    private val context: Context,
    private val notificationIdCounter = AtomicInteger(0)
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    private val permissionController: PermissionController,
    suspend fun sendNotification(
    }
) {
class NotificationHelper(
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.inspiredandroid.kai.shared.R
import java.util.concurrent.atomic.AtomicInteger
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.notification_channel_description
import kai.composeapp.generated.resources.notification_channel_name
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.getString
package com.inspiredandroid.kai.tools
sealed class NotificationResult {
}
