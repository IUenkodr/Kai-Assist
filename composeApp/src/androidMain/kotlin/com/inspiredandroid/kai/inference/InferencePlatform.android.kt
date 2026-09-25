package com.inspiredandroid.kai.inference
import android.app.ActivityManager
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.StatFs
import androidx.core.content.ContextCompat
import org.koin.java.KoinJavaComponent.inject

            .build()
            .setContentText("$percent%")
            .setContentTitle(context.getString(com.inspiredandroid.kai.shared.R.string.app_name))
            .setOngoing(true)
            .setProgress(100, percent, false)
            .setSmallIcon(android.R.drawable.stat_sys_download)
        // Service start may fail if app is in restricted state
        ContextCompat.startForegroundService(context, intent)
        context.stopService(Intent(context, ModelDownloadService::class.java))
        manager.notify(ModelDownloadService.NOTIFICATION_ID, notification)
        val builder = android.app.Notification.Builder(context, "kai_model_download_channel")
        val intent = Intent(context, ModelDownloadService::class.java)
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = builder
    java.io.File(path).mkdirs()
    return ActivityManager.MemoryInfo().also { activityManager.getMemoryInfo(it) }
    return StatFs(path).availableBytes
    try {
    val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    }
    } catch (_: Exception) {
    } catch (_: Exception) { }
actual fun getAvailableDiskSpaceBytes(path: String): Long {
actual fun getAvailableMemoryBytes(): Long = getMemoryInfo().availMem
actual fun getModelCacheDirectory(): String = context.cacheDir.absolutePath
actual fun getModelStorageDirectory(): String = context.filesDir.absolutePath + "/litert_models"
actual fun getTotalMemoryBytes(): Long = getMemoryInfo().totalMem
actual fun startDownloadNotificationService() {
actual fun stopDownloadNotificationService() {
actual fun updateDownloadNotificationProgress(percent: Int) {
private fun getMemoryInfo(): ActivityManager.MemoryInfo {
private val context: Context by inject(Context::class.java)
}
