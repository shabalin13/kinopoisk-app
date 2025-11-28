package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemFeesDto(
    @SerialName("world") val world: MediaItemFeeDto? = null,
    @SerialName("russia") val russia: MediaItemFeeDto? = null,
    @SerialName("usa") val usa: MediaItemFeeDto? = null,
)
