package com.shabalin13.kinopoisk.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shabalin13.kinopoisk.di.FeatureDependencies

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
    ) {}
}
