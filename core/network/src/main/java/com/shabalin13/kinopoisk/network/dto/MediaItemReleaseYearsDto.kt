package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemReleaseYearsDto(
    @SerialName("start") val start: Int? = null,
    @SerialName("end") val end: Int? = null,
)
