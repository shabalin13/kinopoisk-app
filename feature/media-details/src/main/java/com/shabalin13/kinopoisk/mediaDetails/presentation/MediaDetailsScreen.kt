package com.shabalin13.kinopoisk.mediaDetails.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.MediaDetailsDataContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.MediaDetailsErrorContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.MediaDetailsLoadingContent
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

@Composable
internal fun MediaDetailsScreen(
    state: MediaDetailsState,
    handleIntent: (MediaDetailsIntent) -> Unit,
) {
    Scaffold { innerPadding ->
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
                    MediaDetailsUiModel(
                        689,
                        headerInfo = HeaderInfoUiModel(
                            name = "Гарри Поттер и философский камень",
                            posterUrl = null,
                            metaInfo = MetaInfoUiModel(
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
                handleIntent = { }
            )
        }
    }
}
