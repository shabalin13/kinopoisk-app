package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemRatingsDto(
    @SerialName("kp") val kp: Double? = null,
    @SerialName("imdb") val imdb: Double? = null,
    @SerialName("filmCritics") val filmCritics: Double? = null,
)
