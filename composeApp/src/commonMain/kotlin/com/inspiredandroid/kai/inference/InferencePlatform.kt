package com.inspiredandroid.kai.inference

expect fun getAvailableDiskSpaceBytes(path: String): Long
expect fun getAvailableMemoryBytes(): Long
expect fun getModelCacheDirectory(): String
expect fun getModelStorageDirectory(): String
expect fun getTotalMemoryBytes(): Long
expect fun startDownloadNotificationService()
expect fun stopDownloadNotificationService()
expect fun updateDownloadNotificationProgress(percent: Int)
