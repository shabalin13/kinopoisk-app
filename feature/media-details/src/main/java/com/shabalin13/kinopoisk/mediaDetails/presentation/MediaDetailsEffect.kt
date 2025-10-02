package com.shabalin13.kinopoisk.mediaDetails.presentation

internal sealed interface MediaDetailsEffect {
    data object NavigateBack : MediaDetailsEffect
    data class NavigateToMediaDetails(val mediaId: Int) : MediaDetailsEffect
    data class OpenVideoUrl(val videoUrl: String) : MediaDetailsEffect
}
