package com.shabalin13.kinopoisk.mediaCatalog.presentation

internal sealed interface MediaCatalogEffect {
    data class NavigateToMediaDetails(val mediaId: Int) : MediaCatalogEffect
}
