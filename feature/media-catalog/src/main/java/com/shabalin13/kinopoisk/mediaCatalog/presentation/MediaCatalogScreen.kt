package com.shabalin13.kinopoisk.mediaCatalog.presentation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogDataContent
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogInitialContent
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogSearchBar
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaCatalogScreen(
    viewModel: MediaCatalogViewModel,
    onMediaCatalogItemClick: (mediaId: Int) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        val state by viewModel.state.collectAsState()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {
            var searchQuery by rememberSaveable { mutableStateOf("") }

            LaunchedEffect(searchQuery) {
                viewModel.handleIntent(
                    MediaCatalogIntent.SearchMediaCatalogItemsForQuery(
                        searchQuery
                    )
                )
            }

            MediaCatalogSearchBar(
                searchQuery = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = { focusManager.clearFocus() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Paddings.small)
            )

            when (val currentState = state) {
                MediaCatalogState.Initial -> MediaCatalogInitialContent(
                    modifier = Modifier
                        .fillMaxSize()
                )

                is MediaCatalogState.Data -> MediaCatalogDataContent(
                    state = currentState,
                    onMediaCatalogItemClick = onMediaCatalogItemClick,
                    snackbarHostState = snackbarHostState,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}
