package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemSeasonInfoDto(
    @SerialName("number") val seasonNumber: Int? = null,
    @SerialName("episodesCount") val episodesCount: Int? = null,
)
