package com.inspiredandroid.kai.network.dtos.openaicompatible
import kotlinx.serialization.Serializable

        /** Groq-style. */
        /** OpenRouter-style. */
        /** Some providers (notably OpenRouter) include a human-readable name. */
        val context_length: Long? = null,
        val context_window: Long? = null,
        val created: Long? = null,
        val description: String? = null,
        val id: String,
        val isActive: Boolean? = true,
        val isSelected: Boolean = false,
        val name: String? = null,
        val owned_by: String? = null,
        val type: String? = null,
    )
    @Serializable
    data class Model(
    val data: List<Model>,
) {
@Serializable
data class OpenAICompatibleModelResponseDto(
}
