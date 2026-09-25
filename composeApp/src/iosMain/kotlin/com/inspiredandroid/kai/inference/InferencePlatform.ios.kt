import com.inspiredandroid.kai.getAppFilesDirectory
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSFileSystemFreeSize
import platform.Foundation.NSNumber
import platform.Foundation.NSProcessInfo
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

    NSFileManager.defaultManager.createDirectoryAtPath(dir, true, null, null)
    dir
    return free?.longLongValue ?: 0L
    val attrs = NSFileManager.defaultManager.attributesOfFileSystemForPath(path, null)
    val cacheRoot = paths.firstOrNull() as? String ?: getAppFilesDirectory()
    val dir = "$cacheRoot/litert"
    val dir = getAppFilesDirectory() + "/litert_models"
    val free = attrs?.get(NSFileSystemFreeSize) as? NSNumber
    val paths = NSSearchPathForDirectoriesInDomains(NSCachesDirectory, NSUserDomainMask, true)
// iOS has no foreground-service equivalent. Download progress is surfaced in-app; if a
// iOS surfaces low-memory conditions via UIApplication.didReceiveMemoryWarning rather
// than a queryable "available" value. Skip the pre-check (matches desktop) and rely on
// the system warning + initialize() retry-with-CPU-backend path.
// user-visible notification is needed later, wire it through UNUserNotificationCenter.
@OptIn(ExperimentalForeignApi::class)
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
actual fun getAvailableDiskSpaceBytes(path: String): Long {
actual fun getAvailableMemoryBytes(): Long = Long.MAX_VALUE
actual fun getModelCacheDirectory(): String = modelCacheDir
actual fun getModelStorageDirectory(): String = modelStorageDir
actual fun getTotalMemoryBytes(): Long = NSProcessInfo.processInfo.physicalMemory.toLong()
actual fun startDownloadNotificationService() {}
actual fun stopDownloadNotificationService() {}
actual fun updateDownloadNotificationProgress(percent: Int) {}
package com.inspiredandroid.kai.inference
private val modelCacheDir: String by lazy {
private val modelStorageDir: String by lazy {
}
