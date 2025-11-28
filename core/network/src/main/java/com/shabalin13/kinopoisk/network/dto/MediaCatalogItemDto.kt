package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaCatalogItemDto(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "alternativeName") val alternativeName: String? = null,
    @SerialName(value = "year") val year: Int? = null,
    @SerialName(value = "rating") val ratings: MediaCatalogItemRatingsDto? = null,
    @SerialName(value = "poster") val poster: MediaCatalogItemPosterDto? = null,
)
