package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsState {
    data object Initial : MediaDetailsState
    data object Loading : MediaDetailsState
    data class Error(val message: String) : MediaDetailsState
}
