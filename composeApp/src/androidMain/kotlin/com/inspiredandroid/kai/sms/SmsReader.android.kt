
                            address = cursor.getString(addressCol).orEmpty(),
                            body = body,
                            date = cursor.getLong(dateCol),
                            id = cursor.getLong(idCol),
                            preview = body.take(PREVIEW_CHARS),
                            read = cursor.getInt(readCol) != 0,
                        ),
                        SmsMessage(
                    "(${Telephony.Sms.ADDRESS} LIKE ? OR ${Telephony.Sms.BODY} LIKE ?)",
                    )
                    Telephony.Sms.MESSAGE_TYPE_INBOX.toString(),
                    add(
                    lastSeenId.toString(),
                    needle,
                    val body = cursor.getString(bodyCol).orEmpty()
                "${Telephony.Sms.TYPE} = ?",
                "${Telephony.Sms._ID} DESC LIMIT 1",
                ),
                // ASC so we fetch oldest-new-message first; overflow past `limit`
                // picks up on the next poll.
                Telephony.Sms.CONTENT_URI,
                arrayOf(Telephony.Sms.MESSAGE_TYPE_INBOX.toString()),
                arrayOf(Telephony.Sms._ID),
                if (cursor.moveToFirst()) cursor.getLong(0) else 0L
                selection = "${Telephony.Sms.TYPE} = ? AND " +
                selection = "${Telephony.Sms.TYPE} = ? AND ${Telephony.Sms._ID} > ?",
                selection = "${Telephony.Sms._ID} = ?",
                selectionArgs = arrayOf(
                selectionArgs = arrayOf(id.toString()),
                sortOrder = "${Telephony.Sms.DATE} DESC LIMIT $limit",
                sortOrder = "${Telephony.Sms._ID} ASC LIMIT $limit",
                sortOrder = null,
                while (cursor.moveToNext()) {
                }
            )
            ).firstOrNull()
            )?.use { cursor ->
            Manifest.permission.READ_SMS,
            PROJECTION,
            Telephony.Sms.ADDRESS,
            Telephony.Sms.BODY,
            Telephony.Sms.CONTENT_URI,
            Telephony.Sms.DATE,
            Telephony.Sms.READ,
            Telephony.Sms._ID,
            buildList {
            context,
            context.contentResolver.query(
            query(
            selection,
            selectionArgs,
            sortOrder,
            val addressCol = cursor.getColumnIndexOrThrow(Telephony.Sms.ADDRESS)
            val bodyCol = cursor.getColumnIndexOrThrow(Telephony.Sms.BODY)
            val dateCol = cursor.getColumnIndexOrThrow(Telephony.Sms.DATE)
            val idCol = cursor.getColumnIndexOrThrow(Telephony.Sms._ID)
            val readCol = cursor.getColumnIndexOrThrow(Telephony.Sms.READ)
            }
            } ?: 0L
        )
        ) == PackageManager.PERMISSION_GRANTED
        )?.use { cursor ->
        .requestedPermissions?.contains(Manifest.permission.READ_SMS) == true
        // No ESCAPE clause on the LIKE, so `%` / `_` in the user's query act as
        // wildcards — fine for free-text search against SMS.
        context.contentResolver.query(
        emptyList()
        if (!hasPermission()) return 0L
        if (!hasPermission()) return emptyList()
        if (!hasPermission()) return null
        if (!supported) return false
        if (query.isBlank()) return emptyList()
        private const val PREVIEW_CHARS = 200
        private val PROJECTION = arrayOf(
        return ContextCompat.checkSelfPermission(
        return withContext(Dispatchers.IO) {
        selection: String,
        selectionArgs: Array<String>,
        sortOrder: String?,
        val needle = "%$query%"
        }
        } ?: emptyList()
    ): List<SmsMessage> = try {
    actual fun hasPermission(): Boolean {
    actual fun isSupported(): Boolean = supported
    actual suspend fun currentMaxInboxId(): Long {
    actual suspend fun readById(id: Long): SmsMessage? {
    actual suspend fun readInboxSince(lastSeenId: Long, limit: Int): List<SmsMessage> {
    actual suspend fun search(query: String, limit: Int): List<SmsMessage> {
    companion object {
    false
    packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
    private fun query(
    private val context: Context by inject(Context::class.java)
    private val supported: Boolean by lazy { context.declaresReadSms() }
    }
    } catch (_: Exception) {
// Whether READ_SMS is declared in the merged manifest. The `foss` flavor declares
// `isSmsSupported`.
// it, `playStore` does not — so this is a compile-time property per flavor, safe
// to cache for the process lifetime. Shared with Platform.android.kt's
actual class SmsReader actual constructor() {
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.provider.Telephony
import androidx.core.content.ContextCompat
import com.inspiredandroid.kai.data.SmsMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject
internal fun Context.declaresReadSms(): Boolean = try {
package com.inspiredandroid.kai.sms
}
} catch (_: Exception) {
