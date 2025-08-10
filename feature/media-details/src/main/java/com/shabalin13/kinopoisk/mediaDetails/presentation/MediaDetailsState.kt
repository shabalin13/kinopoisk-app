package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsState
internal sealed interface MediaDetailsState {
    data object Initial : MediaDetailsState
    data object Loading : MediaDetailsState
}
