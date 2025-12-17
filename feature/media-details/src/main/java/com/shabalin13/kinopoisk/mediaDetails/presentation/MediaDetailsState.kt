package com.shabalin13.kinopoisk.mediaDetails.presentation

import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MediaItemUiModel

internal sealed interface MediaDetailsState {
    data object Initial : MediaDetailsState
    data object Loading : MediaDetailsState
    data class Data(val mediaItem: MediaItemUiModel) : MediaDetailsState
    data class Error(val message: String) : MediaDetailsState
}
