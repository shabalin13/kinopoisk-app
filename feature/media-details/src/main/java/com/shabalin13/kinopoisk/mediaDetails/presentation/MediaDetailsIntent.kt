package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsIntent {
    data object RateButtonClicked : MediaDetailsIntent
    data object ToggleWatchlistButtonClicked : MediaDetailsIntent
    data object ShareButtonClicked : MediaDetailsIntent
}
