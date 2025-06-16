package com.shabalin13.kinopoisk.mediaCatalog.navigation

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogComponentViewModel
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogDependencies
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogScreen
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogViewModel

internal fun NavGraphBuilder.mediaCatalogNavGraph(
    navController: NavController,
    dependencies: MediaCatalogDependencies,
    onMediaCatalogItemClick: (mediaId: Int) -> Unit,
) {
    navigation(
        startDestination = MediaCatalogRoute.MediaCatalogMain.route,
        route = MediaCatalogRoute.MediaCatalogGraph.route
    ) {
        composable(MediaCatalogRoute.MediaCatalogMain.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(MediaCatalogRoute.MediaCatalogGraph.route)
            }

            val componentViewModel: MediaCatalogComponentViewModel = viewModel(
                viewModelStoreOwner = parentEntry,
                factory = MediaCatalogComponentViewModel.Factory(dependencies)
            )

            val viewModel = viewModel<MediaCatalogViewModel>(
                factory = componentViewModel.component.mediaCatalogViewModelFactory()
            )

            MediaCatalogScreen(
                viewModel = viewModel,
                onMediaCatalogItemClick = onMediaCatalogItemClick
            )
        }
    }
}
