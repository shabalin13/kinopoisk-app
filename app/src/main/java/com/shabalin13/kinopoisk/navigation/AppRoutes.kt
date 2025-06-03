package com.shabalin13.kinopoisk.navigation

sealed class AppRoutes(val route: String) {
    data object AppGraph : AppRoutes(BASE_ROUTE)

    private companion object {
        const val BASE_ROUTE = "kinopoisk"
    }
}
