package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.videos

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.VideoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsVideosSection(
    videos: List<VideoUiModel>,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.videos_section_header_title),
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = Paddings.medium),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium)
        ) {
            items(videos) { video ->
                MediaDetailsVideoCard(
                    video = video,
                    onCardClick = { handleIntent(MediaDetailsIntent.VideoCardClicked(video.videoUrl)) },
                    modifier = Modifier
                        .width(MediaDetailsDimens.VideoCard.width)
                        .height(MediaDetailsDimens.VideoCard.height)
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsVideosSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsVideosSection(
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
                handleIntent = { videoUrl ->
                    println("VideoCard ($videoUrl) clicked")
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
