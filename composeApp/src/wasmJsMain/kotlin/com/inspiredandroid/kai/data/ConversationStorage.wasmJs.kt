import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlinx.browser.localStorage

        Base64.decode(stored)
        null
    if (stored.startsWith("{")) return null // Already plain JSON, not legacy
    localStorage.removeItem(LEGACY_STORAGE_KEY)
    return try {
    val stored = localStorage.getItem(LEGACY_STORAGE_KEY) ?: return null
    }
    } catch (_: Exception) {
@OptIn(ExperimentalEncodingApi::class)
actual fun deleteLegacyConversationFile() {
actual fun readLegacyConversationFile(): ByteArray? {
package com.inspiredandroid.kai.data
private const val LEGACY_STORAGE_KEY = "kaimutableConversations"
}
