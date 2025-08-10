package com.shabalin13.kinopoisk.mediaDetails.presentation.models

import com.shabalin13.kinopoisk.ui.models.RatingUiModel

internal data class MetaInfoUiModel(
    val rating: RatingUiModel? = null,
    val alternativeName: String? = null,
    val summary: String? = null,
)
