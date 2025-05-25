package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RatingDto(
    @SerialName("kp") val kp: Double? = null,
    @SerialName("imdb") val imdb: Double? = null,
)
