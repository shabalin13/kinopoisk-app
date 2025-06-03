package com.shabalin13.kinopoisk.mediaCatalog.presentation

internal sealed class MediaCatalogIntent {
    data class SearchMediaCatalogItemsForQuery(val query: String) : MediaCatalogIntent()
}
