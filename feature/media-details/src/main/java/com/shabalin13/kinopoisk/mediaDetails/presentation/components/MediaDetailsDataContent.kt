package com.shabalin13.kinopoisk.mediaDetails.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsState
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.header.MediaDetailsHeaderSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.videos.MediaDetailsVideosSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsDataContent(
    state: MediaDetailsState.Data,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = Paddings.medium),
        verticalArrangement = Arrangement.spacedBy(Spacings.small)
    ) {
        MediaDetailsHeaderSection(
            headerInfo = state.mediaDetails.headerInfo,
            handleIntent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Paddings.medium),
        )

        state.mediaDetails.videosInfo?.let { videosInfo ->
            MediaDetailsVideosSection(
                videosInfo = videosInfo,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsDataContentPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsDataContent(
                state = MediaDetailsState.Data(
                    MediaDetailsUiModel(
                        689,
                        headerInfo = HeaderInfoUiModel(
                            name = "Гарри Поттер и философский камень",
                            posterUrl = null,
                            metaInfo = MetaInfoUiModel(
                                rating = RatingUiModel("8.3", RatingColors.high),
                                alternativeName = "Harry Potter and the Sorcerer's Stone",
                                summary = "2001, фэнтэзи, приключения\nВеликобритания, 2 ч 32 мин, 12+",
                            ),
                            descriptionInfo = DescriptionInfoUiModel(
                                description = "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: " +
                                    "родители умерли, едва ему исполнился год, а от дяди и тети, взявших сироту " +
                                    "на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатые " +
                                    "день рождения Гарри все меняется...",
                                ageRating = "12+"
                            )
                        ),
                        videosInfo = listOf(
                            VideoInfoUiModel(
                                videoUrl = "https://www.youtube.com/embed/ly3tLiu-bmc",
                                posterUrl = "https://img.youtube.com/vi/ly3tLiu-bmc/hqdefault.jpg",
                                name = "Гарри Поттер и философский камень"
                            ),
                            VideoInfoUiModel(
                                videoUrl = "https://www.youtube.com/embed/TXB31YDIJwk",
                                posterUrl = "https://img.youtube.com/vi/TXB31YDIJwk/hqdefault.jpg",
                                name = "Гарри Поттер и философский камень - Трейлер"
                            ),
                            VideoInfoUiModel(
                                videoUrl = "https://www.youtube.com/embed/k71hjl3zWsA",
                                posterUrl = "https://img.youtube.com/vi/k71hjl3zWsA/hqdefault.jpg",
                                name = "Trailer 3"
                            ),
                            VideoInfoUiModel(
                                videoUrl = "https://www.youtube.com/embed/Q61YhARNOPg",
                                posterUrl = "https://img.youtube.com/vi/Q61YhARNOPg/hqdefault.jpg",
                                name = "Trailer 2"
                            ),
                            VideoInfoUiModel(
                                videoUrl = "https://www.youtube.com/embed/PbdM1db3JbY",
                                posterUrl = "https://img.youtube.com/vi/PbdM1db3JbY/hqdefault.jpg",
                                name = "Trailer"
                            )
                        ),
                    )
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
