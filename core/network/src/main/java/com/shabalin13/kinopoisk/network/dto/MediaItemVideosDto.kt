package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemVideosDto(
    @SerialName("trailers") val trailers: List<MediaItemVideoDto>? = null,
    @SerialName("teasers") val teasers: List<MediaItemVideoDto>? = null,
)
