package com.shabalin13.kinopoisk.mediaCatalog.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogComponentViewModel
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogDependencies
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogEffect
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogScreen
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogViewModel
import com.shabalin13.kinopoisk.navigation.AppRoute
import com.shabalin13.kinopoisk.navigation.navigator.MediaCatalogNavigator

fun NavGraphBuilder.mediaCatalogNavGraph(
    navController: NavController,
    dependencies: MediaCatalogDependencies,
    navigator: MediaCatalogNavigator,
) {
    navigation(
        startDestination = AppRoute.MediaCatalog.Main.route,
        route = AppRoute.MediaCatalog.Graph.route
    ) {
        composable(AppRoute.MediaCatalog.Main.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(AppRoute.MediaCatalog.Graph.route)
            }

            val componentViewModel: MediaCatalogComponentViewModel = viewModel(
                viewModelStoreOwner = parentEntry,
                factory = MediaCatalogComponentViewModel.Factory(dependencies)
            )

            val viewModel = viewModel<MediaCatalogViewModel>(
                factory = componentViewModel.component.mediaCatalogViewModelFactory()
            )

            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(viewModel.effect) {
                viewModel.effect.collect { effect ->
                    when (effect) {
                        is MediaCatalogEffect.NavigateToMediaDetails -> navigator.navigateToMediaDetails(
                            effect.mediaId
                        )
                    }
                }
            }

            MediaCatalogScreen(
                state = state,
                handleIntent = viewModel::handleIntent
            )
        }
    }
}
