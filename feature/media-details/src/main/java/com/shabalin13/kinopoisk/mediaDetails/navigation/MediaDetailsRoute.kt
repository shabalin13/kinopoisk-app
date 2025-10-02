package com.shabalin13.kinopoisk.mediaDetails.navigation

internal sealed class MediaDetailsRoute(val route: String) {
    data object MediaDetailsGraph : MediaDetailsRoute("$BASE_ROUTE/{$MEDIA_ID_KEY}") {
        fun createRoute(mediaId: Int) = "$BASE_ROUTE/$mediaId"
    }

    data object MediaDetailsMain : MediaDetailsRoute("$BASE_ROUTE/{$MEDIA_ID_KEY}/main")

    companion object {
        const val BASE_ROUTE = "mediaDetails"
        const val MEDIA_ID_KEY = "mediaId"
    }
}
