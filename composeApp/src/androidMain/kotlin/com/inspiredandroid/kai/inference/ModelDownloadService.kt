package com.inspiredandroid.kai.inference
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.inspiredandroid.kai.shared.R

            .build()
            .setContentIntent(pendingIntent)
            .setContentText(getString(R.string.download_notification_text))
            .setContentTitle(getString(R.string.app_name))
            .setOngoing(true)
            .setProgress(100, 0, true)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            0,
            CHANNEL_ID,
            NotificationManager.IMPORTANCE_LOW,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            description = getString(R.string.download_channel_description)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            getString(R.string.download_channel_name),
            intent,
            startForeground(NOTIFICATION_ID, notification)
            stopSelf()
            this,
        )
        ).apply {
        const val NOTIFICATION_ID = 9002
        createNotificationChannel()
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        private const val CHANNEL_ID = "kai_model_download_channel"
        return builder
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
        super.onCreate()
        super.onDestroy()
        try {
        val builder = Notification.Builder(this, CHANNEL_ID)
        val channel = NotificationChannel(
        val intent = packageManager.getLaunchIntentForPackage(packageName)?.apply {
        val notification = buildNotification()
        val pendingIntent = PendingIntent.getActivity(
        }
        } catch (_: Exception) {
    companion object {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onCreate() {
    override fun onDestroy() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_NOT_STICKY
    override fun onTimeout(startId: Int, fgsType: Int) {
    private fun buildNotification(): Notification {
    private fun createNotificationChannel() {
    }
class ModelDownloadService : Service() {
}
