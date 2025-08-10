package com.shabalin13.kinopoisk.mediaDetails.presentation

import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel

internal sealed interface MediaDetailsState {
    data object Initial : MediaDetailsState
    data object Loading : MediaDetailsState
    data class Data(val mediaDetails: MediaDetailsUiModel) : MediaDetailsState
    data class Error(val message: String) : MediaDetailsState
}
