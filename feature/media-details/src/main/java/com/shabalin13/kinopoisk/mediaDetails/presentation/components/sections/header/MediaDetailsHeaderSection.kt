package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.header

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.RatingsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun MediaDetailsHeaderSection(
    headerInfo: HeaderInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        GlideImage(
            model = headerInfo.posterUrl,
            contentDescription = stringResource(R.string.poster_content_description),
            contentScale = ContentScale.Crop,
            loading = placeholder(R.drawable.poster_placeholder),
            failure = placeholder(R.drawable.poster_placeholder),
            transition = CrossFade,
            modifier = Modifier
                .height(MediaDetailsDimens.Poster.height)
                .width(MediaDetailsDimens.Poster.width)
        )

        Spacer(Modifier.height(Spacings.medium))

        Text(
            text = headerInfo.name,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(Modifier.height(Spacings.medium))

        headerInfo.metaInfo?.let { metaInfo ->
            HeaderMetaInfo(metaInfo)
        }

        Spacer(Modifier.height(Spacings.medium))

        HeaderActionButtons(
            headerInfo.actionButtonsInfo,
            handleIntent = handleIntent,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(Spacings.medium))

        headerInfo.descriptionInfo?.let { descriptionInfo ->
            HeaderDescription(
                descriptionInfo = descriptionInfo,
                onButtonClick = { handleIntent(MediaDetailsIntent.ShowFullDescriptionButtonClicked) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.height(Spacings.extraSmall))

        headerInfo.ratingsInfo?.let { ratingsInfo ->
            HeaderRatings(
                ratingsInfo = ratingsInfo,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsHeaderSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsHeaderSection(
                headerInfo = HeaderInfoUiModel(
                    name = "Гарри Поттер и философский камень",
                    posterUrl = null,
                    metaInfo = MetaInfoUiModel(
                        alternativeName = "Harry Potter and the Sorcerer's Stone",
                        summary = "2001, фэнтэзи, приключения, детектив, триллер, боевик, ужасы" +
                            "\nВеликобритания, США, Россия, Уругвай, Китая, Австралия, 2 ч 32 мин, 12+",
                    ),
                    descriptionInfo = DescriptionInfoUiModel(
                        description = "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: " +
                            "родители умерли, едва ему исполнился год, а от дяди и тети, взявших сироту " +
                            "на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатые " +
                            "день рождения Гарри все меняется...",
                        ageRating = "12+"
                    ),
                    ratingsInfo = RatingsInfoUiModel(
                        kpRating = RatingUiModel.from(8.7),
                        imdbRating = RatingUiModel.from(6.5)
                    )
                ),
                handleIntent = { intent ->
                    when (intent) {
                        MediaDetailsIntent.RateButtonClicked -> println("Rate button clicked")
                        MediaDetailsIntent.ShareButtonClicked -> println("Share button clicked")
                        MediaDetailsIntent.ToggleWatchlistButtonClicked -> println("Toggle watchlist button clicked")
                        MediaDetailsIntent.ShowFullDescriptionButtonClicked ->
                            println("Show full description button clicked")

                        else -> Unit
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.medium)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsHeaderSectionPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsHeaderSection(
                headerInfo = HeaderInfoUiModel(
                    name = "Гарри Поттер и философский камень"
                ),
                handleIntent = { intent ->
                    when (intent) {
                        MediaDetailsIntent.RateButtonClicked -> println("Rate button clicked")
                        MediaDetailsIntent.ShareButtonClicked -> println("Share button clicked")
                        MediaDetailsIntent.ToggleWatchlistButtonClicked -> println("Toggle watchlist button clicked")
                        MediaDetailsIntent.ShowFullDescriptionButtonClicked ->
                            println("Show full description button clicked")

                        else -> Unit
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Paddings.medium)
            )
        }
    }
}
