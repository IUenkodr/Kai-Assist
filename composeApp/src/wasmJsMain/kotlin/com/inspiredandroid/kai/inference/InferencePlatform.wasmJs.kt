package com.inspiredandroid.kai.inference

actual fun getAvailableDiskSpaceBytes(path: String): Long = 0L
actual fun getAvailableMemoryBytes(): Long = Long.MAX_VALUE
actual fun getModelCacheDirectory(): String = ""
actual fun getModelStorageDirectory(): String = ""
actual fun getTotalMemoryBytes(): Long = Long.MAX_VALUE
actual fun startDownloadNotificationService() {}
actual fun stopDownloadNotificationService() {}
actual fun updateDownloadNotificationProgress(percent: Int) {}
