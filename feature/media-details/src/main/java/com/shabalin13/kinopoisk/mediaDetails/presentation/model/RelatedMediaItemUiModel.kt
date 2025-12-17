package com.shabalin13.kinopoisk.mediaDetails.presentation.model

import com.shabalin13.kinopoisk.ui.model.RatingUiModel

internal data class RelatedMediaItemUiModel(
    val id: Int,
    val name: String,
    val posterUrl: String? = null,
    val year: Int? = null,
    val rating: RatingUiModel? = null,
)
