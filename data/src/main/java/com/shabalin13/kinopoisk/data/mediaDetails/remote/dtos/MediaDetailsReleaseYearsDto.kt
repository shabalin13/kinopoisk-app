package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsReleaseYearsDto(
    @SerialName("start") val start: Int? = null,
    @SerialName("end") val end: Int? = null,
)
