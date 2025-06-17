package com.shabalin13.kinopoisk.mediaDetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsDependencies

object MediaDetailsEntry {
    fun getNavGraph(
        navController: NavController,
        dependencies: MediaDetailsDependencies,
    ): NavGraphBuilder.() -> Unit {
        return {
            mediaDetailsNavGraph(navController, dependencies)
        }
    }

    fun getRoute(mediaId: Int): String = MediaDetailsRoute.MediaDetailsGraph.createRoute(mediaId)
}
