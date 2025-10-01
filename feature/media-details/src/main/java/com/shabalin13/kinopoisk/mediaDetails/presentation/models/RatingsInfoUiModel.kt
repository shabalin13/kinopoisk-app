package com.shabalin13.kinopoisk.mediaDetails.presentation.models

import com.shabalin13.kinopoisk.ui.models.RatingUiModel

internal data class RatingsInfoUiModel(
    val kpRating: RatingUiModel? = null,
    val imdbRating: RatingUiModel? = null,
)
