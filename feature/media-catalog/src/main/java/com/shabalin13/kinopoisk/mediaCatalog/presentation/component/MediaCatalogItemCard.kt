package com.shabalin13.kinopoisk.mediaCatalog.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.shabalin13.kinopoisk.mediaCatalog.R
import com.shabalin13.kinopoisk.mediaCatalog.presentation.model.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.mediaCatalog.presentation.theme.MediaCatalogDimens
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import com.shabalin13.kinopoisk.ui.theme.Spacings

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun MediaCatalogItemCard(
    mediaCatalogItem: MediaCatalogItemUiModel,
    onCardClick: (mediaId: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .clickable(
                indication = ripple(),
                interactionSource = null,
                onClick = { onCardClick(mediaCatalogItem.id) }
            )
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        GlideImage(
            model = mediaCatalogItem.posterUrl,
            contentDescription = mediaCatalogItem.name,
            contentScale = ContentScale.Crop,
            loading = placeholder(R.drawable.media_catalog_poster_placeholder),
            failure = placeholder(R.drawable.media_catalog_poster_placeholder),
            transition = CrossFade,
            modifier = Modifier
                .height(MediaCatalogDimens.Poster.height)
                .width(MediaCatalogDimens.Poster.width)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(Spacings.extraSmall)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = mediaCatalogItem.name,
                    modifier = Modifier.weight(1f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )

                mediaCatalogItem.rating?.let { rating ->
                    Text(
                        text = rating.value,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleLarge,
                        color = rating.color
                    )
                }
            }

            mediaCatalogItem.additionalInfo?.let { additionalInfoText ->
                Text(
                    text = additionalInfoText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogItemCardPreview() {
    KinopoiskTheme {
        MediaCatalogItemCard(
            mediaCatalogItem = MediaCatalogItemUiModel(
                id = 689,
                name = "Гарри Поттер и философский камень",
                posterUrl = "https://image.openmoviedb.com/kinopoisk-images/" +
                    "1898899/27ed5c19-a045-49dd-8624-5f629c5d96e0/x1000",
                additionalInfo = "Harry Potter and the Sorcerer's Stone, 2001",
                rating = RatingUiModel(
                    value = "8.3",
                    color = RatingColors.high
                )
            ),
            onCardClick = { mediaId -> println("Selected MediaCatalogItemId: $mediaId") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Paddings.small, horizontal = Paddings.medium)
                .height(MediaCatalogDimens.Poster.height)
        )
    }
}
