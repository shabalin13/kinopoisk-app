package com.shabalin13.kinopoisk.mediaCatalog.presentation.models

import com.shabalin13.kinopoisk.ui.models.RatingUiModel

internal data class MediaCatalogItemUiModel(
    val id: Int,
    val name: String,
    val posterPreviewUrl: String? = null,
    val additionalInfo: String? = null,
    val rating: RatingUiModel? = null,
)
