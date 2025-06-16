package com.shabalin13.kinopoisk.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shabalin13.kinopoisk.di.FeatureDependencies
import com.shabalin13.kinopoisk.mediaCatalog.navigation.MediaCatalogEntry

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
                Log.d("MediaDetails", "Selected Media Catalog Item: $mediaId")
            }
        ).invoke(this)
    }
}
