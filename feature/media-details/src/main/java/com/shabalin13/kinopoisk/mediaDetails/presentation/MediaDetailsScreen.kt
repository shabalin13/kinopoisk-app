package com.shabalin13.kinopoisk.mediaDetails.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.RatingColors

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
@Composable
internal fun MediaDetailsScreenPreview() {
    KinopoiskTheme {
        MediaDetailsScreen(
            state = MediaDetailsState.Initial,
            handleIntent = { }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaDetailsScreenPreview2() {
    KinopoiskTheme {
        MediaDetailsScreen(
            state = MediaDetailsState.Loading,
            handleIntent = { }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaDetailsScreenPreview3() {
    KinopoiskTheme {
        MediaDetailsScreen(
            state = MediaDetailsState.Error("Что-то пошло не так..."),
            handleIntent = { }
        )
    }
}

@Suppress("MagicNumber")
@Preview(showSystemUi = true)
@Composable
internal fun MediaDetailsScreenPreview4() {
    KinopoiskTheme {
        MediaDetailsScreen(
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
                    )
                )
            ),
            handleIntent = { }
        )
    }
}
