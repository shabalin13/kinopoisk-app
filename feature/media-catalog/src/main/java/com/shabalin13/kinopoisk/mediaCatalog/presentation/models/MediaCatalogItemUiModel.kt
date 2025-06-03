package com.shabalin13.kinopoisk.mediaCatalog.presentation.models

internal data class MediaCatalogItemUiModel(
    val id: Int,
    val name: String,
    val posterPreviewUrl: String?,
    val additionalInfo: String?,
    val rating: RatingUiModel?,
)
