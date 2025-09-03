package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.linkedMediaItems

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsMediaItemCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.LinkedMediaItemsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaItemInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.ShowAllCard
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsLinkedMediaItemsSection(
    linkedMediaItemsInfo: LinkedMediaItemsInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.linked_media_items_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllLinkedMediaItemsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.MediaItemCard.height),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
            contentPadding = PaddingValues(horizontal = Paddings.medium)
        ) {
            items(linkedMediaItemsInfo.linkedMediaItems) { linkedMediaItemInfo ->
                MediaDetailsMediaItemCard(
                    mediaItemInfo = linkedMediaItemInfo,
                    onCardClick = {
                        handleIntent(
                            MediaDetailsIntent.LinkedMediaItemCardClicked(
                                linkedMediaItemInfo.id
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(MediaDetailsDimens.MediaItemCard.width)
                )
            }

            if (linkedMediaItemsInfo.isMore) {
                item {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllLinkedMediaItemsButtonClicked) },
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(MediaDetailsDimens.MediaItemCard.width)
                    )
                }
            }
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsLinkedMediaItemsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsLinkedMediaItemsSection(
                linkedMediaItemsInfo = LinkedMediaItemsInfoUiModel(
                    linkedMediaItems = listOf(
                        MediaItemInfoUiModel(
                            id = 688,
                            name = "Гарри Поттер и Тайная комната",
                            posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                                "/4774061/1ef65bfb-b16b-42aa-a54a-758395253290/x1000",
                            year = 2002,
                            rating = RatingUiModel.from(8.1)
                        ),
                        MediaItemInfoUiModel(
                            id = 322,
                            name = "Гарри Поттер и узник Азкабана",
                            posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                                "/4303601/3eabac99-fb98-4b12-ba9f-6172782d54c6/x1000",
//                            year = 2004,
                            rating = RatingUiModel.from(8.2)
                        ),
                    ),
                    isMore = true
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsLinkedMediaItemsSectionPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsLinkedMediaItemsSection(
                linkedMediaItemsInfo = LinkedMediaItemsInfoUiModel(
                    linkedMediaItems = listOf(
                        MediaItemInfoUiModel(
                            id = 688,
                            name = "Гарри Поттер и Тайная комната",
                            posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                                "/4774061/1ef65bfb-b16b-42aa-a54a-758395253290/x1000",
                            year = 2002,
                            rating = RatingUiModel.from(8.1)
                        ),
                    ),
                    isMore = true
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
