package com.inspiredandroid.kai.network.dtos
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

        val avatar: String = "",
        val current: List<Sponsor> = emptyList(),
        val past: List<Sponsor> = emptyList(),
        val username: String = "",
    )
    @Immutable
    @Serializable
    data class Sponsor(
    data class SponsorsData(
    val sponsors: SponsorsData = SponsorsData(),
) {
@Serializable
data class SponsorsResponseDto(
}
