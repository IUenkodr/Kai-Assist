package com.inspiredandroid.kai.daemon

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DaemonClient {
    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    fun sendRequest(request: DaemonRequest): DaemonResponse {
        // Platform-specific Unix socket communication can be implemented
        // in platform source sets when available.
        val encodedRequest = json.encodeToString(request)
        encodedRequest.length // Keep serialization exercised until transport exists.

        return DaemonResponse(
            status = "error",
            message = "Platform socket implementation pending"
        )
    }
}
