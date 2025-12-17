package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MediaItemTypeDto {
    @SerialName("movie")
    MOVIE,

    @SerialName("tv-series")
    TV_SERIES,

    @SerialName("cartoon")
    CARTOON,

    @SerialName("anime")
    ANIME,

    @SerialName("animated-series")
    ANIMATED_SERIES,

    @SerialName("tv-show")
    TV_SHOW,
}
