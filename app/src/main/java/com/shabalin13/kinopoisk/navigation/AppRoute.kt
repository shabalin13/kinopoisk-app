package com.shabalin13.kinopoisk.navigation

internal sealed class AppRoute(val route: String) {
    data object AppGraph : AppRoute(BASE_ROUTE)

    companion object {
        const val BASE_ROUTE = "kinopoisk"
    }
}
