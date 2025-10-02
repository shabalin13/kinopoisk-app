package com.shabalin13.kinopoisk.mediaCatalog.presentation

internal sealed interface MediaCatalogIntent {
    data class SearchMediaCatalogItemsForQuery(val query: String) : MediaCatalogIntent
}
