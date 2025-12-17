package com.shabalin13.kinopoisk.mediaDetails.presentation.component

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.actors.MediaDetailsActorsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.bloopers.MediaDetailsBloopersSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.contributors.MediaDetailsContributorsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.facts.MediaDetailsFactsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.header.MediaDetailsHeaderSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.linkedMediaItems.MediaDetailsLinkedMediaItemsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.seasons.MediaDetailsSeasonsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.similarMediaItems.MediaDetailsSimilarMediaItemsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.statistics.MediaDetailsStatisticsSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.videos.MediaDetailsVideosSection
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MediaItemUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.VideoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
@Suppress("LongMethod")
internal fun MediaDetailsDataContent(
    state: MediaDetailsState.Data,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = Paddings.medium),
        verticalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        MediaDetailsHeaderSection(
            headerInfo = state.mediaItem.headerInfo,
            handleIntent = handleIntent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Paddings.medium),
        )

        state.mediaItem.seasonsInfo?.let { seasonsInfo ->
            MediaDetailsSeasonsSection(
                seasonsInfo = seasonsInfo,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.videos?.let { videos ->
            MediaDetailsVideosSection(
                videos = videos,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.actors?.let { actors ->
            MediaDetailsActorsSection(
                actors = actors,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.contributors?.let { contributors ->
            MediaDetailsContributorsSection(
                contributors = contributors,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.facts?.let { facts ->
            MediaDetailsFactsSection(
                facts = facts,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.bloopers?.let { bloopers ->
            MediaDetailsBloopersSection(
                bloopers = bloopers,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.linkedMediaItems?.let { linkedMediaItems ->
            MediaDetailsLinkedMediaItemsSection(
                linkedMediaItems = linkedMediaItems,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.similarMediaItems?.let { similarMediaItems ->
            MediaDetailsSimilarMediaItemsSection(
                similarMediaItems = similarMediaItems,
                handleIntent = handleIntent,
                modifier = Modifier.fillMaxWidth()
            )
        }

        state.mediaItem.statisticsInfos?.let { statisticsInfos ->
            MediaDetailsStatisticsSection(
                statisticsInfos = statisticsInfos,
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
                    MediaItemUiModel(
                        689,
                        headerInfo = HeaderInfoUiModel(
                            name = "Гарри Поттер и философский камень",
                            posterUrl = null,
                            metaInfo = MetaInfoUiModel(
                                alternativeName = "Harry Potter and the Sorcerer's Stone",
                                summary = "2001, фэнтэзи, приключения\nВеликобритания, 2 ч 32 мин, 12+",
                            ),
                            description = "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: " +
                                "родители умерли, едва ему исполнился год, а от дяди и тети, взявших сироту " +
                                "на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатые " +
                                "день рождения Гарри все меняется..."
                        ),
                        videos = listOf(
                            VideoUiModel(
                                videoUrl = "https://www.youtube.com/embed/ly3tLiu-bmc",
                                posterUrl = "https://img.youtube.com/vi/ly3tLiu-bmc/hqdefault.jpg",
                                name = "Гарри Поттер и философский камень"
                            ),
                            VideoUiModel(
                                videoUrl = "https://www.youtube.com/embed/TXB31YDIJwk",
                                posterUrl = "https://img.youtube.com/vi/TXB31YDIJwk/hqdefault.jpg",
                                name = "Гарри Поттер и философский камень - Трейлер"
                            ),
                            VideoUiModel(
                                videoUrl = "https://www.youtube.com/embed/k71hjl3zWsA",
                                posterUrl = "https://img.youtube.com/vi/k71hjl3zWsA/hqdefault.jpg",
                                name = "Trailer 3"
                            ),
                            VideoUiModel(
                                videoUrl = "https://www.youtube.com/embed/Q61YhARNOPg",
                                posterUrl = "https://img.youtube.com/vi/Q61YhARNOPg/hqdefault.jpg",
                                name = "Trailer 2"
                            ),
                            VideoUiModel(
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
