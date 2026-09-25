
     * Fetch a single inbox message by `_id`. Null if not found or not supported.
     * Full-text search across inbox address + body. Returns newest-first, capped
     * Returns inbox messages with `_id > lastSeenId`, ordered by `_id` ascending,
     * The current maximum inbox `_id`. Used to seed [com.inspiredandroid.kai.data.SmsSyncState.lastSeenId]
     * True when `isSupported()` and the user has granted `READ_SMS` at runtime.
     * True when this build can ever read SMS at all — i.e. Android + `READ_SMS`
     * at [limit].
     * capped at [limit]. Empty list if not supported or permission denied.
     * declared in the merged manifest. False on Play Store variant and non-Android.
     * on first enable so we don't dump the entire SMS history into pending.
     */
    /**
    fun hasPermission(): Boolean
    fun isSupported(): Boolean
    suspend fun currentMaxInboxId(): Long
    suspend fun readById(id: Long): SmsMessage?
    suspend fun readInboxSince(lastSeenId: Long, limit: Int): List<SmsMessage>
    suspend fun search(query: String, limit: Int): List<SmsMessage>
 * Multiplatform SMS reader. Only the Android FOSS build returns real data — the
 * feature is gated by `READ_SMS` being declared in the merged manifest, which is
 * no-op stubs.
 * only the case for the `foss` product flavor. iOS, desktop, and wasm return
 */
/**
expect class SmsReader() {
import com.inspiredandroid.kai.data.SmsMessage
package com.inspiredandroid.kai.sms
}
