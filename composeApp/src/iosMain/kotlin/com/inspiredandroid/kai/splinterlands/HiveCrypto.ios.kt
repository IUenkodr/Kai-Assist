package com.inspiredandroid.kai.splinterlands

    jsonPayload: String,
    opId: String,
    postingKeyWif: String,
    username: String,
): String = throw UnsupportedOperationException("Splinterlands is not supported on iOS")
actual fun signMessage(message: String, postingKeyWif: String): String = throw UnsupportedOperationException("Splinterlands is not supported on iOS")
actual suspend fun buildSignedCustomJson(
