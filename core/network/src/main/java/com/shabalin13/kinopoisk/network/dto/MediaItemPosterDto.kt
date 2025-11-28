package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemPosterDto(
    @SerialName("url") val url: String? = null,
    @SerialName("previewUrl") val previewUrl: String? = null,
)
