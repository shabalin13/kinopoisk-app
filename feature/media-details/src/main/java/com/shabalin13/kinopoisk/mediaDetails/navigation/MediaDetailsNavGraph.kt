package com.shabalin13.kinopoisk.mediaDetails.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsComponentViewModel
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsDependencies
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsEffect
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsScreen
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsViewModel

internal fun NavGraphBuilder.mediaDetailsNavGraph(
    navController: NavController,
    dependencies: MediaDetailsDependencies,
) {
    navigation(
        startDestination = MediaDetailsRoute.MediaDetailsMain.route,
        route = MediaDetailsRoute.MediaDetailsGraph.route,
        arguments = listOf(navArgument(MediaDetailsRoute.MEDIA_ID_KEY) { type = NavType.IntType })
    ) {
        composable(MediaDetailsRoute.MediaDetailsMain.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(MediaDetailsRoute.MediaDetailsGraph.route)
            }
            val arguments = requireNotNull(parentEntry.arguments)
            val mediaId = arguments.getInt(MediaDetailsRoute.MEDIA_ID_KEY)

            val componentViewModel: MediaDetailsComponentViewModel = viewModel(
                viewModelStoreOwner = parentEntry,
                factory = MediaDetailsComponentViewModel.Factory(dependencies)
            )

            val viewModel = viewModel<MediaDetailsViewModel>(
                factory = componentViewModel.component.mediaDetailsViewModelFactory()
                    .create(mediaId)
            )
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(viewModel.effect) {
                viewModel.effect.collect { effect ->
                    when (effect) {
                        MediaDetailsEffect.NavigateBack -> {
                            if (navController.previousBackStackEntry != null) {
                                navController.navigateUp()
                            }
                        }
                    }
                }
            }

            MediaDetailsScreen(
                state = state,
                handleIntent = viewModel::handleIntent
            )
        }
    }
}
