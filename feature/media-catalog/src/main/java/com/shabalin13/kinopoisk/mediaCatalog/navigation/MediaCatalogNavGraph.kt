package com.shabalin13.kinopoisk.mediaCatalog.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogComponentViewModel
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogDependencies
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogScreen
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogViewModel

fun NavGraphBuilder.mediaCatalogNavGraph(
    navController: NavController,
    dependencies: MediaCatalogDependencies,
    onMediaCatalogItemClick: (mediaId: Int) -> Unit,
) {
    composable(MediaCatalogRoutes.MediaCatalogMain.route) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(MediaCatalogRoutes.MediaCatalogGraph.route)
        }

        val componentViewModel: MediaCatalogComponentViewModel = viewModel(
            viewModelStoreOwner = parentEntry,
            factory = MediaCatalogComponentViewModel.Factory(dependencies)
        )

        val viewModel = viewModel<MediaCatalogViewModel>(
            factory = componentViewModel.component.mediaCatalogViewModelFactory()
        )

        val state by viewModel.state.collectAsStateWithLifecycle()

        MediaCatalogScreen(
            state = state,
            handleIntent = viewModel::handleIntent,
            onMediaCatalogItemClick = onMediaCatalogItemClick
        )
    }
}
