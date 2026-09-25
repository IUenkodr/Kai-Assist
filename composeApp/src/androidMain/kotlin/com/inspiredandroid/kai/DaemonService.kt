
            .build()
            .setContentIntent(pendingIntent)
            .setContentText(getString(R.string.daemon_notification_text))
            .setContentTitle(getString(R.string.app_name))
            .setOngoing(true)
            .setSmallIcon(android.R.drawable.ic_popup_sync)
            0,
            CHANNEL_ID,
            NotificationManager.IMPORTANCE_LOW,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            description = getString(R.string.daemon_channel_description)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            getString(R.string.daemon_channel_name),
            intent,
            return
            startForeground(NOTIFICATION_ID, notification)
            stopSelf()
            this,
        )
        ).apply {
        // The scheduler owns its own long-lived scope; this foreground service's job is
        // asks the OS to re-create us if we're killed, which will re-trigger onCreate and
        // call start() again — idempotent no-op if the loop is already running.
        // to keep the app process alive so that scope keeps running. START_STICKY (below)
        createNotificationChannel()
        manager.createNotificationChannel(channel)
        private const val CHANNEL_ID = "kai_daemon_channel"
        private const val NOTIFICATION_ID = 9001
        return builder
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
        super.onCreate()
        super.onDestroy()
        taskScheduler.start()
        try {
        val builder = Notification.Builder(this, CHANNEL_ID)
        val channel = NotificationChannel(
        val intent = packageManager.getLaunchIntentForPackage(packageName)?.apply {
        val manager = getSystemService(NotificationManager::class.java)
        val notification = buildNotification()
        val pendingIntent = PendingIntent.getActivity(
        }
        } catch (_: Exception) {
    companion object {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onCreate() {
    override fun onDestroy() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY
    override fun onTimeout(startId: Int, fgsType: Int) {
    private fun buildNotification(): Notification {
    private fun createNotificationChannel() {
    private val taskScheduler: TaskScheduler by inject()
    }
class DaemonService : Service() {
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.inspiredandroid.kai.data.TaskScheduler
import com.inspiredandroid.kai.shared.R
import org.koin.android.ext.android.inject
package com.inspiredandroid.kai
}
