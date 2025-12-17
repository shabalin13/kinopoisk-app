package com.shabalin13.kinopoisk.mediaDetails.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.MediaDetailsDataContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.MediaDetailsErrorContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.MediaDetailsLoadingContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MediaItemUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.VideoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.mediaDetails.R as mediaDetailsR
import com.shabalin13.kinopoisk.ui.R as uiR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MediaDetailsScreen(
    state: MediaDetailsState,
    handleIntent: (MediaDetailsIntent) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(mediaDetailsR.string.media_details_top_bar_title),
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { handleIntent(MediaDetailsIntent.BackButtonClicked) }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(uiR.string.back_button_title)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {
            when (state) {
                MediaDetailsState.Initial -> Unit
                MediaDetailsState.Loading -> MediaDetailsLoadingContent(Modifier.fillMaxSize())
                is MediaDetailsState.Data -> MediaDetailsDataContent(
                    state,
                    handleIntent,
                    Modifier.fillMaxSize()
                )

                is MediaDetailsState.Error -> MediaDetailsErrorContent(
                    state,
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsScreenPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsScreen(
                state = MediaDetailsState.Initial,
                handleIntent = { }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsScreenPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsScreen(
                state = MediaDetailsState.Loading,
                handleIntent = { }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsScreenPreview3() {
    KinopoiskTheme {
        Surface {
            MediaDetailsScreen(
                state = MediaDetailsState.Error("Что-то пошло не так..."),
                handleIntent = { }
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsScreenPreview4() {
    KinopoiskTheme {
        Surface {
            MediaDetailsScreen(
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
                handleIntent = { }
            )
        }
    }
}
