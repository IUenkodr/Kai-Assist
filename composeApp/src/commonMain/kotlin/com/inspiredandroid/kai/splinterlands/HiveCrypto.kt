
    jsonPayload: String,
    opId: String,
    postingKeyWif: String,
    username: String,
 * Build and sign a Hive custom_json operation, returning the signed transaction as JSON.
 * Returns the signature as a hex string (compact recovery format).
 * Signs a message (username + timestamp) with the Hive posting key.
 * The transaction is NOT broadcast — just signed for submission to the Splinterlands battle_tx endpoint.
 */
): String
/**
expect fun signMessage(message: String, postingKeyWif: String): String
expect suspend fun buildSignedCustomJson(
package com.inspiredandroid.kai.splinterlands
