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
    data object ShowAllContributorsButtonClicked : MediaDetailsIntent
    data object ShowAllFactsButtonClicked : MediaDetailsIntent
    data class FactCardClicked(val factText: String) : MediaDetailsIntent
    data object ShowAllBloopersButtonClicked : MediaDetailsIntent
    data class BlooperCardClicked(val blooperText: String) : MediaDetailsIntent
    data object ShowAllLinkedMediaItemsButtonClicked : MediaDetailsIntent
    data class LinkedMediaItemCardClicked(val mediaId: Int) : MediaDetailsIntent
    data object ShowAllSimilarMediaItemsButtonClicked : MediaDetailsIntent
    data class SimilarMediaItemCardClicked(val mediaId: Int) : MediaDetailsIntent
}
