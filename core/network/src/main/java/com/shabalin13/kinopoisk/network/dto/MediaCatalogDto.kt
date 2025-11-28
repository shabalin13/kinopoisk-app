package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaCatalogDto(
    @SerialName(value = "docs") val items: List<MediaCatalogItemDto>,
    @SerialName(value = "total") val total: Int,
    @SerialName(value = "limit") val limit: Int,
    @SerialName(value = "page") val page: Int,
    @SerialName(value = "pages") val pages: Int,
)
