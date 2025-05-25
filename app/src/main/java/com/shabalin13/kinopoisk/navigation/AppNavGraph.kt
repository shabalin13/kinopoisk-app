package com.shabalin13.kinopoisk.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import com.shabalin13.kinopoisk.di.FeatureDependencies
import com.shabalin13.kinopoisk.mediaCatalog.navigation.MediaCatalogEntry
import com.shabalin13.kinopoisk.mediaCatalog.navigation.MediaCatalogRoutes

@Suppress("UnusedParameter")
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    featureDependencies: FeatureDependencies,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.AppGraph.route,
        modifier = modifier
    ) {
        navigation(
            startDestination = MediaCatalogRoutes.MediaCatalogGraph.route,
            route = AppRoutes.AppGraph.route
        ) {
            navigation(
                startDestination = MediaCatalogRoutes.MediaCatalogMain.route,
                route = MediaCatalogRoutes.MediaCatalogGraph.route
            ) {
                MediaCatalogEntry.getNavGraph(
                    navController,
                    featureDependencies,
                    onMediaCatalogItemClick = { mediaId ->
                        Log.d("MediaDetails", "Selected Media Catalog Item: $mediaId")
                    }
                ).invoke(this)
            }
        }
    }
}
