package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PosterDto(
    @SerialName(value = "previewUrl") val previewUrl: String? = null,
)
