package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsVideosDto(
    @SerialName("trailers") val trailers: List<MediaDetailsVideoDto>? = null,
    @SerialName("teasers") val teasers: List<MediaDetailsVideoDto>? = null,
)
