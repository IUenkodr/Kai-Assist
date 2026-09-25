package com.inspiredandroid.kai.inference
import com.inspiredandroid.kai.getAppFilesDirectory
import java.io.File

        dir = dir.parentFile ?: return 0L
    // No foreground service needed on desktop
    // No notification on desktop
    return dir.usableSpace
    var dir = File(path)
    while (!dir.exists()) {
    }
actual fun getAvailableDiskSpaceBytes(path: String): Long {
actual fun getAvailableMemoryBytes(): Long = Long.MAX_VALUE // Desktop OSes manage memory via swap and cache eviction; skip the check
actual fun getModelCacheDirectory(): String = System.getProperty("java.io.tmpdir") ?: getAppFilesDirectory()
actual fun getModelStorageDirectory(): String = getAppFilesDirectory() + "/litert_models"
actual fun getTotalMemoryBytes(): Long = Long.MAX_VALUE
actual fun startDownloadNotificationService() {
actual fun stopDownloadNotificationService() {
actual fun updateDownloadNotificationProgress(percent: Int) {
}
