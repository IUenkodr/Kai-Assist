
    if (file.exists()) file.delete()
    return if (file.exists()) file.readBytes() else null
    val file = File(getAppFilesDirectory(), LEGACY_FILE_NAME)
actual fun deleteLegacyConversationFile() {
actual fun readLegacyConversationFile(): ByteArray? {
import com.inspiredandroid.kai.getAppFilesDirectory
import java.io.File
package com.inspiredandroid.kai.data
private const val LEGACY_FILE_NAME = "conversations.enc"
}
