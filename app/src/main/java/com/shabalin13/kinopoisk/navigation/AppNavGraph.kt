package com.shabalin13.kinopoisk.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shabalin13.kinopoisk.di.FeatureDependencies
import com.shabalin13.kinopoisk.mediaCatalog.navigation.MediaCatalogEntry
import com.shabalin13.kinopoisk.mediaDetails.navigation.MediaDetailsEntry

@Composable
fun AppNavGraph(
    navController: NavHostController,
    featureDependencies: FeatureDependencies,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MediaCatalogEntry.getRoute(),
        modifier = modifier,
        route = AppRoute.AppGraph.route
    ) {
        MediaCatalogEntry.getNavGraph(
            navController = navController,
            dependencies = featureDependencies,
            onMediaCatalogItemClick = { mediaId ->
                navController.navigate(MediaDetailsEntry.getRoute(mediaId))
            }
        ).invoke(this)

        MediaDetailsEntry.getNavGraph(
            navController = navController,
            dependencies = featureDependencies,
            onNavigateToMediaDetails = { mediaId ->
                navController.navigate(MediaDetailsEntry.getRoute(mediaId))
            }
        ).invoke(this)
    }
}
