package com.inspiredandroid.kai.sms
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.SmsManager
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

                    @Suppress("DEPRECATION")
                    SmsManager.getDefault()
                    context.getSystemService(SmsManager::class.java)
                    manager.sendMultipartTextMessage(address, null, parts, null, null)
                    manager.sendTextMessage(address, null, body, null, null)
                SmsSendResult.Failure(e.message ?: e::class.simpleName ?: "Send failed")
                SmsSendResult.Success
                if (parts.size <= 1) {
                val manager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val parts = manager.divideMessage(body)
                }
                } else {
            return SmsSendResult.Failure("SEND_SMS permission not granted")
            try {
            }
            } catch (e: Exception) {
        Manifest.permission.SEND_SMS,
        context,
        if (!hasPermission()) {
        if (address.isBlank()) return SmsSendResult.Failure("Missing address")
        if (body.isEmpty()) return SmsSendResult.Failure("Empty body")
        return withContext(Dispatchers.IO) {
        }
    ) == PackageManager.PERMISSION_GRANTED
    actual fun hasPermission(): Boolean = ContextCompat.checkSelfPermission(
    actual suspend fun send(address: String, body: String): SmsSendResult {
    private val context: Context by inject(Context::class.java)
    }
actual class SmsSender actual constructor() {
}
