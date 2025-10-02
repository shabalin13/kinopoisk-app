package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.similarMediaItems

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaItemInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.SimilarMediaItemsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.ShowAllCard
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsSimilarMediaItemsSection(
    similarMediaItemsInfo: SimilarMediaItemsInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.similar_media_items_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllSimilarMediaItemsButtonClicked) },
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
            items(similarMediaItemsInfo.similarMediaItems) { similarMediaItemInfo ->
                MediaDetailsMediaItemCard(
                    mediaItemInfo = similarMediaItemInfo,
                    onCardClick = {
                        handleIntent(
                            MediaDetailsIntent.SimilarMediaItemCardClicked(
                                similarMediaItemInfo.id
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(MediaDetailsDimens.MediaItemCard.width)
                )
            }

            if (similarMediaItemsInfo.isMore) {
                item {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllSimilarMediaItemsButtonClicked) },
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
internal fun MediaDetailsSimilarMediaItemsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsSimilarMediaItemsSection(
                similarMediaItemsInfo = SimilarMediaItemsInfoUiModel(
                    similarMediaItems = listOf(
                        MediaItemInfoUiModel(
                            id = 328,
                            name = "Властелин колец: Братство Кольца",
                            posterPreviewUrl = "https://avatars.mds.yandex.net/" +
                                "get-kinopoisk-image/6201401/a2d5bcae-a1a9-442f-" +
                                "8195-f5373a5ba77f/x1000",
                            year = 2001,
                            rating = RatingUiModel.from(8.6)
                        ),
                        MediaItemInfoUiModel(
                            id = 403986,
                            name = "Перси Джексон и похититель молний",
                            posterPreviewUrl = "https://avatars.mds.yandex.net/" +
                                "get-kinopoisk-image/1946459/f36090b4-" +
                                "bfea-4e1f-8e13-69dbeaa613ab/x1000",
                            year = 2010,
                            rating = RatingUiModel.from(6.2)
                        )
                    ),
                    isMore = true
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
