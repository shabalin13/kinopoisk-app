package com.shabalin13.kinopoisk.domain.model

data class MediaItemRatings(
    val kp: MediaItemRating?,
    val imdb: MediaItemRating?,
    val filmCritics: MediaItemRating?,
)
