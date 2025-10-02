package com.shabalin13.kinopoisk.domain.mediaDetails.models

data class MediaDetailsRatings(
    val kp: MediaDetailsRating?,
    val imdb: MediaDetailsRating?,
    val filmCritics: MediaDetailsRating?,
)
