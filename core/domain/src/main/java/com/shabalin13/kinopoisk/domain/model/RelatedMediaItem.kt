package com.shabalin13.kinopoisk.domain.model

data class RelatedMediaItem(
    val id: Int,
    val name: String,
    val alternativeName: String?,
    val year: Int?,
    val rating: Double?,
    val posterUrl: String?,
)
