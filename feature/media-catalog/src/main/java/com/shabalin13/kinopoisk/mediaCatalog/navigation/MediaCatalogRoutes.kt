package com.shabalin13.kinopoisk.mediaCatalog.navigation

sealed class MediaCatalogRoutes(val route: String) {
    data object MediaCatalogGraph : MediaCatalogRoutes(BASE_ROUTE)
    data object MediaCatalogMain : MediaCatalogRoutes("$BASE_ROUTE/main")

    companion object {
        const val BASE_ROUTE = "mediaCatalog"
    }
}
