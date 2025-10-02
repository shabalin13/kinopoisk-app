package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsFeesDto(
    @SerialName("world") val world: MediaDetailsFeeDto? = null,
    @SerialName("russia") val russia: MediaDetailsFeeDto? = null,
    @SerialName("usa") val usa: MediaDetailsFeeDto? = null,
)
