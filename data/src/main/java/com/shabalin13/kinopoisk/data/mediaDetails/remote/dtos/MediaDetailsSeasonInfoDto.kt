package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsSeasonInfoDto(
    @SerialName("number") val seasonNumber: Int? = null,
    @SerialName("episodesCount") val episodesCount: Int? = null,
)
