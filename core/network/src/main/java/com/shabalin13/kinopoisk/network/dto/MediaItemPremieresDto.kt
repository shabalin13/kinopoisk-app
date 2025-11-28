package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemPremieresDto(
    @SerialName("world") val world: String? = null,
    @SerialName("russia") val russia: String? = null,
)
