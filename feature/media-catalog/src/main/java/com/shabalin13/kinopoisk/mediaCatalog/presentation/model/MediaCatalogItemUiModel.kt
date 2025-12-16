package com.shabalin13.kinopoisk.mediaCatalog.presentation.model

import com.shabalin13.kinopoisk.ui.model.RatingUiModel

internal data class MediaCatalogItemUiModel(
    val id: Int,
    val name: String,
    val posterUrl: String? = null,
    val additionalInfo: String? = null,
    val rating: RatingUiModel? = null,
)
