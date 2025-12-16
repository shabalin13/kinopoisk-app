package com.shabalin13.kinopoisk.mediaCatalog.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.shabalin13.kinopoisk.mediaCatalog.presentation.model.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.mediaCatalog.presentation.theme.MediaCatalogDimens
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import kotlinx.coroutines.flow.flowOf

@Composable
internal fun MediaCatalogListContent(
    mediaCatalogItems: LazyPagingItems<MediaCatalogItemUiModel>,
    listState: LazyListState,
    onMediaCatalogItemClick: (mediaId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(vertical = Paddings.small)
    ) {
        items(
            count = mediaCatalogItems.itemCount,
        ) { index ->
            Column {
                val mediaCatalogItem = mediaCatalogItems[index]

                val cardModifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Paddings.small, horizontal = Paddings.medium)
                    .height(MediaCatalogDimens.Poster.height)

                if (mediaCatalogItem != null) {
                    MediaCatalogItemCard(
                        mediaCatalogItem = mediaCatalogItem,
                        onCardClick = onMediaCatalogItemClick,
                        modifier = cardModifier
                    )
                } else {
                    MediaCatalogItemCardShimmer(
                        modifier = cardModifier
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(fraction = 0.75f)
                    )
                }
            }
        }

        if (mediaCatalogItems.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Paddings.medium)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogListContentPreview() {
    KinopoiskTheme {
        MediaCatalogListContent(
            mediaCatalogItems = flowOf(
                PagingData.from(
                    listOf(
                        MediaCatalogItemUiModel(
                            id = 689,
                            name = "Гарри Поттер и философский камень",
                            posterUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                            additionalInfo = "Harry Potter and the Sorcerer's Stone Part 1, 2001",
                            rating = RatingUiModel(value = "8.3", color = RatingColors.high)
                        ),
                        MediaCatalogItemUiModel(
                            id = 690,
                            name = "Гарри Поттер и философский камень 2",
                            posterUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
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
                            posterUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                            additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                            rating = RatingUiModel(value = "3.9", color = RatingColors.low)
                        ),
                        MediaCatalogItemUiModel(
                            id = 692,
                            name = "Гарри Поттер и философский камень 4",
                            posterUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                                "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                            additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                            rating = RatingUiModel(value = "2.0", color = RatingColors.low)
                        )
                    )
                )
            ).collectAsLazyPagingItems(),
            listState = rememberLazyListState(),
            onMediaCatalogItemClick = { mediaId -> println("Selected MediaCatalogItemId: $mediaId") },
            modifier = Modifier.fillMaxSize()
        )
    }
}
