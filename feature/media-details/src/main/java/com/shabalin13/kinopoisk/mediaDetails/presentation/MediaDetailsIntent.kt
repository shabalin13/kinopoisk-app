package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsIntent {
    data object RateButtonClicked : MediaDetailsIntent
    data object ToggleWatchlistButtonClicked : MediaDetailsIntent
    data object ShareButtonClicked : MediaDetailsIntent
    data object ShowFullDescriptionButtonClicked : MediaDetailsIntent
    data object ShowAllVideosButtonClicked : MediaDetailsIntent
    data class VideoCardClicked(val videoUrl: String) : MediaDetailsIntent
    data object ShowAllActorsButtonClicked : MediaDetailsIntent
    data class PersonCardClicked(val personId: Int) : MediaDetailsIntent
}
