package com.shabalin13.kinopoisk.domain.mediaDetails.models

data class MediaDetailsSimilarMediaItem(
    val id: Int,
    val name: String,
    val alternativeName: String?,
    val year: Int?,
    val rating: Double?,
    val posterPreviewUrl: String?,
)
