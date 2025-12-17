package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RelatedMediaItemDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("alternativeName") val alternativeName: String? = null,
    @SerialName("year") val year: Int? = null,
    @SerialName("rating") val ratings: MediaItemRatingsDto? = null,
    @SerialName("poster") val poster: MediaItemPosterDto? = null,
)
