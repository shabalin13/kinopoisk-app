package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaItemInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.RatingCard
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun MediaDetailsMediaItemCard(
    mediaItemInfo: MediaItemInfoUiModel,
    onCardClick: (mediaId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .width(MediaDetailsDimens.MediaItemCard.width)
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = { onCardClick(mediaItemInfo.id) }
            )
    ) {
        Box(
            modifier = Modifier
                .height(MediaDetailsDimens.MediaItemCard.Poster.height)
                .width(MediaDetailsDimens.MediaItemCard.Poster.width)
                .clickable(
                    indication = ripple(),
                    interactionSource = interactionSource,
                    onClick = { onCardClick(mediaItemInfo.id) }
                )
        ) {
            GlideImage(
                model = mediaItemInfo.posterPreviewUrl,
                contentDescription = mediaItemInfo.name,
                contentScale = ContentScale.Crop,
                loading = placeholder(R.drawable.media_item_poster_placeholder),
                failure = placeholder(R.drawable.media_item_poster_placeholder),
                transition = CrossFade,
                modifier = Modifier.fillMaxSize()
            )

            mediaItemInfo.rating?.let { rating ->
                RatingCard(
                    rating = rating,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(Paddings.small)
                )
            }
        }

        Spacer(Modifier.height(Spacings.small))

        Text(
            text = mediaItemInfo.name,
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge
        )

        mediaItemInfo.year?.let { year ->
            Spacer(Modifier.height(Spacings.extraSmall))

            Text(
                text = "$year",
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsMediaItemCardPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsMediaItemCard(
                mediaItemInfo = MediaItemInfoUiModel(
                    id = 688,
                    name = "Гарри Поттер и Тайная комната",
                    posterPreviewUrl = "https://image.openmoviedb.com/kinopoisk-images" +
                        "/4774061/1ef65bfb-b16b-42aa-a54a-758395253290/x1000",
                    year = 2002,
                    rating = RatingUiModel.from(8.1)
                ),
                onCardClick = { println("CardClicked #$it") },
                modifier = Modifier
                    .height(MediaDetailsDimens.MediaItemCard.height)
            )
        }
    }
}
