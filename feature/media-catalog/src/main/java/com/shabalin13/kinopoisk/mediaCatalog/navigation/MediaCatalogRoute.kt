package com.shabalin13.kinopoisk.mediaCatalog.navigation

internal sealed class MediaCatalogRoute(val route: String) {
    data object MediaCatalogGraph : MediaCatalogRoute(BASE_ROUTE)
    data object MediaCatalogMain : MediaCatalogRoute("$BASE_ROUTE/main")

    companion object {
        const val BASE_ROUTE = "mediaCatalog"
    }
}
