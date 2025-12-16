package com.shabalin13.kinopoisk.mediaCatalog.presentation

internal sealed interface MediaCatalogIntent {
    data class SearchQueryChanged(val query: String) : MediaCatalogIntent
    data class MediaCatalogItemCardClicked(val mediaId: Int) : MediaCatalogIntent
}
