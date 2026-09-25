package com.inspiredandroid.kai.sms

     * Fires the message via the system's default SMS stack. Long bodies are
     * [SmsSendResult.Failure] on a precondition violation (missing permission,
     * bad address, platform unsupported).
     * split into multiple parts. Returns [SmsSendResult.Success] on accepted
     * submission (delivery is best-effort and may complete asynchronously), or
     */
    /**
    data class Failure(val message: String) : SmsSendResult()
    data object Success : SmsSendResult()
    fun hasPermission(): Boolean
    suspend fun send(address: String, body: String): SmsSendResult
 * Multiplatform SMS sender. Only the Android FOSS build actually sends — the
 * Play Store flavor doesn't declare `SEND_SMS`, so [hasPermission] returns
 * false there and [send] no-ops with a failure result. iOS/desktop/wasm stub
 * the same way.
 */
/**
expect class SmsSender() {
sealed class SmsSendResult {
}
