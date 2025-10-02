package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsVotesDto(
    @SerialName("kp") val kp: Int? = null,
    @SerialName("imdb") val imdb: Int? = null,
    @SerialName("filmCritics") val filmCritics: Int? = null,
)
