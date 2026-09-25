package com.inspiredandroid.kai.network.dtos.gemini
import kotlinx.serialization.Serializable

        val description: String? = null,
        val displayName: String? = null,
        val inputTokenLimit: Long? = null,
        val name: String,
        val outputTokenLimit: Long? = null,
        val supportedGenerationMethods: List<String>? = null,
        val version: String? = null,
    )
    @Serializable
    data class Model(
    val models: List<Model>,
) {
@Serializable
data class GeminiModelsResponseDto(
}
