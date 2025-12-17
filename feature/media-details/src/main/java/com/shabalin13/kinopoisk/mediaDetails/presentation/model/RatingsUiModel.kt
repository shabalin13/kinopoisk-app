package com.shabalin13.kinopoisk.mediaDetails.presentation.model

import com.shabalin13.kinopoisk.ui.model.RatingUiModel

internal data class RatingsUiModel(
    val kpRating: RatingUiModel? = null,
    val imdbRating: RatingUiModel? = null,
)
