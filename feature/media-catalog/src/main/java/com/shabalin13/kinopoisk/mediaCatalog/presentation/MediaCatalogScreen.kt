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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogDataContent
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogInitialContent
import com.shabalin13.kinopoisk.mediaCatalog.presentation.components.MediaCatalogSearchBar
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaCatalogScreen(
    state: MediaCatalogState,
    handleIntent: (intent: MediaCatalogIntent) -> Unit,
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {
            var searchQuery by rememberSaveable { mutableStateOf("") }

            LaunchedEffect(searchQuery) {
                handleIntent(
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

            when (state) {
                MediaCatalogState.Initial -> MediaCatalogInitialContent(
                    modifier = Modifier
                        .fillMaxSize()
                )

                is MediaCatalogState.Data -> MediaCatalogDataContent(
                    state = state,
                    onMediaCatalogItemClick = onMediaCatalogItemClick,
                    snackbarHostState = snackbarHostState,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogScreenPreview() {
    KinopoiskTheme {
        MediaCatalogScreen(
            state = MediaCatalogState.Initial,
            handleIntent = { },
            onMediaCatalogItemClick = { mediaId -> println("Selected MediaCatalogItemId: $mediaId") }
        )
    }
}
