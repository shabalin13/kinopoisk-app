package com.shabalin13.kinopoisk.navigation

import androidx.navigation.NavHostController
import com.shabalin13.kinopoisk.navigation.navigator.AppNavigator

internal class AppNavigatorImpl(
    private val navController: NavHostController,
) : AppNavigator {
    override fun navigateBack() {
        if (navController.previousBackStackEntry != null) {
            navController.navigateUp()
        }
    }

    override fun navigateToMediaDetails(mediaId: Int) {
        navController.navigate(AppRoute.MediaDetails.Graph.createRoute(mediaId))
    }
}
