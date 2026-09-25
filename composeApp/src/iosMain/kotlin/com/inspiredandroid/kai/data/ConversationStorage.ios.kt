package com.inspiredandroid.kai.data
import com.inspiredandroid.kai.getAppFilesDirectory
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.NSFileManager
import platform.Foundation.dataWithContentsOfFile
import platform.posix.memcpy

        memcpy(pinned.addressOf(0), data.bytes, data.length)
    NSFileManager.defaultManager.removeItemAtPath(path, null)
    bytes.usePinned { pinned ->
    if (size == 0) return null
    return bytes
    val bytes = ByteArray(size)
    val data = NSData.dataWithContentsOfFile(path) ?: return null
    val path = "${getAppFilesDirectory()}/$LEGACY_FILE_NAME"
    val size = data.length.toInt()
    }
@file:OptIn(ExperimentalForeignApi::class)
actual fun deleteLegacyConversationFile() {
actual fun readLegacyConversationFile(): ByteArray? {
private const val LEGACY_FILE_NAME = "conversations.enc"
}
