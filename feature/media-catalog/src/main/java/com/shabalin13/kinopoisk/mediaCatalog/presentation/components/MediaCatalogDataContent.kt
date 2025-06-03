package com.shabalin13.kinopoisk.mediaCatalog.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.shabalin13.kinopoisk.mediaCatalog.R
import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogState
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import kotlinx.coroutines.flow.flowOf

@Composable
internal fun MediaCatalogDataContent(
    state: MediaCatalogState.Data,
    onMediaCatalogItemClick: (mediaId: Int) -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    val mediaCatalogItems = state.mediaCatalogItemsFlow.collectAsLazyPagingItems()
    val listState = rememberLazyListState()
    val focusManager = LocalFocusManager.current
    val refreshLoadState = mediaCatalogItems.loadState.refresh
    val unknownErrorMessage = stringResource(R.string.unknown_error_message)

    LaunchedEffect(listState.isScrollInProgress) {
        if (listState.isScrollInProgress) {
            focusManager.clearFocus()
        }
    }

    LaunchedEffect(mediaCatalogItems.loadState.append) {
        val error = mediaCatalogItems.loadState.append as? LoadState.Error
        error?.let {
            snackbarHostState.showSnackbar(
                message = it.error.localizedMessage ?: unknownErrorMessage
            )
        }
    }

    when (refreshLoadState) {
        is LoadState.Loading -> MediaCatalogLoadingContent(modifier)

        is LoadState.Error -> MediaCatalogErrorContent(
            message = refreshLoadState.error.localizedMessage ?: unknownErrorMessage,
            onRetryClick = { mediaCatalogItems.retry() },
            modifier = modifier
        )

        else -> MediaCatalogListContent(
            mediaCatalogItems = mediaCatalogItems,
            listState = listState,
            onMediaCatalogItemClick = { mediaId ->
                focusManager.clearFocus()
                onMediaCatalogItemClick(mediaId)
            },
            modifier = modifier
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MediaCatalogDataContentPreview() {
    KinopoiskTheme {
        MediaCatalogDataContent(
            state = MediaCatalogState.Data(
                mediaCatalogItemsFlow = flowOf(
                    PagingData.from(
                        listOf(
                            MediaCatalogItemUiModel(
                                id = 689,
                                name = "Гарри Поттер и философский камень",
                                posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                    "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                                additionalInfo = "Harry Potter and the Sorcerer's Stone Part 1, 2001",
                                rating = RatingUiModel(value = "8.3", color = RatingColors.high)
                            ),
                            MediaCatalogItemUiModel(
                                id = 690,
                                name = "Гарри Поттер и философский камень 2",
                                posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                    "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                                additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                                rating = RatingUiModel(
                                    value = "5.6",
                                    color = RatingColors.medium
                                )
                            ),
                            MediaCatalogItemUiModel(
                                id = 691,
                                name = "Гарри Поттер и философский камень 3",
                                posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                    "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                                additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                                rating = RatingUiModel(value = "3.9", color = RatingColors.low)
                            ),
                            MediaCatalogItemUiModel(
                                id = 692,
                                name = "Гарри Поттер и философский камень 4",
                                posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                    "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                                additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                                rating = RatingUiModel(value = "2.0", color = RatingColors.low)
                            )
                        )
                    )
                )
            ),
            onMediaCatalogItemClick = { mediaId -> println("Selected MediaCatalogItemId: $mediaId") },
            snackbarHostState = remember { SnackbarHostState() },
            modifier = Modifier.fillMaxSize()
        )
    }
}
