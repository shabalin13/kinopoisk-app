package com.shabalin13.kinopoisk.mediaDetails.presentation.models

import com.shabalin13.kinopoisk.ui.models.RatingUiModel

internal data class MediaItemInfoUiModel(
    val id: Int,
    val name: String,
    val posterPreviewUrl: String? = null,
    val year: Int? = null,
    val rating: RatingUiModel? = null,
)
