package com.shabalin13.kinopoisk.navigation

sealed class AppRoute(open val route: String) {
    data object AppGraph : AppRoute("kinopoisk")

    sealed class MediaCatalog(override val route: String) : AppRoute(route) {
        data object Graph : MediaCatalog(BASE_ROUTE)
        data object Main : MediaCatalog("$BASE_ROUTE/main")

        companion object {
            const val BASE_ROUTE = "media_catalog"
        }
    }

    sealed class MediaDetails(override val route: String) : AppRoute(route) {
        data object Graph : MediaDetails("$BASE_ROUTE/{$MEDIA_ID_KEY}") {
            fun createRoute(mediaId: Int) = "$BASE_ROUTE/$mediaId"
        }

        data object Main : MediaDetails("$BASE_ROUTE/{$MEDIA_ID_KEY}/main")

        companion object {
            const val BASE_ROUTE = "media_details"
            const val MEDIA_ID_KEY = "media_id"
        }
    }
}
