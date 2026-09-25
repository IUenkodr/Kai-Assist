
    actual fun hasPermission(): Boolean = false
    actual suspend fun send(address: String, body: String): SmsSendResult = SmsSendResult.Failure("SMS sending not supported on this platform")
actual class SmsSender actual constructor() {
package com.inspiredandroid.kai.sms
}
