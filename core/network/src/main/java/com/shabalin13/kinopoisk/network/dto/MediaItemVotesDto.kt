package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemVotesDto(
    @SerialName("kp") val kp: Int? = null,
    @SerialName("imdb") val imdb: Int? = null,
    @SerialName("filmCritics") val filmCritics: Int? = null,
)
