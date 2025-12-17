package com.shabalin13.kinopoisk.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shabalin13.kinopoisk.di.FeatureDependencies
import com.shabalin13.kinopoisk.mediaCatalog.navigation.mediaCatalogNavGraph
import com.shabalin13.kinopoisk.mediaDetails.navigation.mediaDetailsNavGraph
import com.shabalin13.kinopoisk.navigation.navigator.AppNavigator

@Composable
internal fun AppNavGraph(
    navController: NavHostController,
    appNavigator: AppNavigator,
    featureDependencies: FeatureDependencies,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.MediaCatalog.Graph.route,
        modifier = modifier,
        route = AppRoute.AppGraph.route
    ) {
        mediaCatalogNavGraph(
            navController = navController,
            dependencies = featureDependencies,
            navigator = appNavigator
        )

        mediaDetailsNavGraph(
            navController = navController,
            dependencies = featureDependencies,
            navigator = appNavigator
        )
    }
}
