package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.linkedMediaItems

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsRelatedMediaItemCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.config.MediaDetailsConfig
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.RelatedMediaItemUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.component.ShowAllCard
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsLinkedMediaItemsSection(
    linkedMediaItems: List<RelatedMediaItemUiModel>,
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
                .height(MediaDetailsDimens.RelatedMediaItemCard.height),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
            contentPadding = PaddingValues(horizontal = Paddings.medium)
        ) {
            items(linkedMediaItems.take(MediaDetailsConfig.MAX_VISIBLE_LINKED_MEDIA_ITEMS)) { linkedMediaItem ->
                MediaDetailsRelatedMediaItemCard(
                    relatedMediaItem = linkedMediaItem,
                    onCardClick = {
                        handleIntent(
                            MediaDetailsIntent.LinkedMediaItemCardClicked(
                                linkedMediaItem.id
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(MediaDetailsDimens.RelatedMediaItemCard.width)
                )
            }

            if (linkedMediaItems.size > MediaDetailsConfig.MAX_VISIBLE_LINKED_MEDIA_ITEMS) {
                item {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllLinkedMediaItemsButtonClicked) },
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(MediaDetailsDimens.RelatedMediaItemCard.width)
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
                linkedMediaItems = listOf(
                    RelatedMediaItemUiModel(
                        id = 688,
                        name = "Гарри Поттер и Тайная комната",
                        posterUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                            "/4774061/1ef65bfb-b16b-42aa-a54a-758395253290/x1000",
                        year = 2002,
                        rating = RatingUiModel.from(8.1)
                    ),
                    RelatedMediaItemUiModel(
                        id = 322,
                        name = "Гарри Поттер и узник Азкабана",
                        posterUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                            "/4303601/3eabac99-fb98-4b12-ba9f-6172782d54c6/x1000",
//                            year = 2004,
                        rating = RatingUiModel.from(8.2)
                    ),
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
                linkedMediaItems = listOf(
                    RelatedMediaItemUiModel(
                        id = 688,
                        name = "Гарри Поттер и Тайная комната",
                        posterUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                            "/4774061/1ef65bfb-b16b-42aa-a54a-758395253290/x1000",
                        year = 2002,
                        rating = RatingUiModel.from(8.1)
                    ),
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
