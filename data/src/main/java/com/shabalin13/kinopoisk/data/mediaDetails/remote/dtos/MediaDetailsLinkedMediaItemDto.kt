package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsLinkedMediaItemDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("alternativeName") val alternativeName: String? = null,
    @SerialName("year") val year: Int? = null,
    @SerialName("rating") val rating: MediaDetailsRatingsDto? = null,
    @SerialName("poster") val poster: MediaDetailsPosterDto? = null,
)
