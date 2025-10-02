package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsEffect {
    data object NavigateBack : MediaDetailsEffect
}
