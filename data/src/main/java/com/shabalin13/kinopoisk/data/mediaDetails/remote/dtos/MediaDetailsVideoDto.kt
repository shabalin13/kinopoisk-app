package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsVideoDto(
    @SerialName("url") val url: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("site") val site: String? = null,
)
