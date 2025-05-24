package com.shabalin13.kinopoisk.domain.mediaCatalog.models

data class MediaCatalogItem(
    val id: Int,
    val name: String,
    val posterPreviewUrl: String?,
    val alternativeName: String?,
    val year: Int?,
    val rating: Double?,
)
