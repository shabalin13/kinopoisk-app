package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsPremieresDto(
    @SerialName("world") val world: String? = null,
    @SerialName("russia") val russia: String? = null,
)
