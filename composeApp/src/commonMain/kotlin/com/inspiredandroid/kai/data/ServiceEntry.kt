package com.inspiredandroid.kai.data
import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.DrawableResource

    val icon: DrawableResource,
    val instanceId: String,
    val modelId: String,
    val serviceId: String,
    val serviceName: String,
)
@Immutable
data class ServiceEntry(
