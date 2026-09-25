
    val errorReason: UiError,
    val nextServiceName: String? = null,
    val serviceName: String,
 * Emitted while [DataRepository.ask] walks the configured fallback chain. Only set when a
 * service has just failed and the loop is moving on — the UI keeps showing this status while
 * the next service is being tried, so silent fallbacks are visible to the user.
 */
)
/**
data class FallbackStatus(
import com.inspiredandroid.kai.network.UiError
package com.inspiredandroid.kai.data
