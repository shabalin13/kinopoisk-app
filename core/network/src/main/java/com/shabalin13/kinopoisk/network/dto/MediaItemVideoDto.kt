package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemVideoDto(
    @SerialName("url") val url: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("site") val site: String? = null,
)
