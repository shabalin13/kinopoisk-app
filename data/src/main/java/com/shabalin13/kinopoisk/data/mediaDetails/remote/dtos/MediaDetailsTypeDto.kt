package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class MediaDetailsTypeDto {
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
