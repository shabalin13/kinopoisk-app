package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaCatalogItemPosterDto(
    @SerialName(value = "previewUrl") val previewUrl: String? = null,
)
