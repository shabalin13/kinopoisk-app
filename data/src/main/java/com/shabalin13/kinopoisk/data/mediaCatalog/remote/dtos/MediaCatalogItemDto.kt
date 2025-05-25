package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaCatalogItemDto(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "alternativeName") val alternativeName: String? = null,
    @SerialName(value = "year") val year: Int? = null,
    @SerialName(value = "rating") val rating: RatingDto? = null,
    @SerialName(value = "poster") val poster: PosterDto? = null,
)
