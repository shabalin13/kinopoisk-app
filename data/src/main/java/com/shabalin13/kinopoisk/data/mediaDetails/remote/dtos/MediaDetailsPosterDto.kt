package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsPosterDto(
    @SerialName("url") val url: String? = null,
    @SerialName("previewUrl") val previewUrl: String? = null,
)
