package com.shabalin13.kinopoisk.domain.model

data class MediaCatalogItem(
    val id: Int,
    val name: String,
    val posterUrl: String?,
    val alternativeName: String?,
    val year: Int?,
    val rating: Double?,
)
