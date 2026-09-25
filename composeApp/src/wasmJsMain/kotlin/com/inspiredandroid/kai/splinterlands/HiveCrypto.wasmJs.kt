package com.inspiredandroid.kai.splinterlands

    jsonPayload: String,
    opId: String,
    postingKeyWif: String,
    username: String,
): String = throw UnsupportedOperationException("Splinterlands is not supported on Web")
actual fun signMessage(message: String, postingKeyWif: String): String = throw UnsupportedOperationException("Splinterlands is not supported on Web")
actual suspend fun buildSignedCustomJson(
