package com.inspiredandroid.kai.sms
import com.inspiredandroid.kai.data.SmsMessage

    actual fun hasPermission(): Boolean = false
    actual fun isSupported(): Boolean = false
    actual suspend fun currentMaxInboxId(): Long = 0L
    actual suspend fun readById(id: Long): SmsMessage? = null
    actual suspend fun readInboxSince(lastSeenId: Long, limit: Int): List<SmsMessage> = emptyList()
    actual suspend fun search(query: String, limit: Int): List<SmsMessage> = emptyList()
actual class SmsReader actual constructor() {
}
