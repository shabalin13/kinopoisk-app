package com.shabalin13.kinopoisk.mediaCatalog.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaCatalog.presentation.theme.MediaCatalogDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings
import com.valentinilk.shimmer.shimmer

@Composable
internal fun MediaCatalogItemCardShimmer(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.shimmer(),
        horizontalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        Box(
            modifier = Modifier
                .height(MediaCatalogDimens.Poster.height)
                .width(MediaCatalogDimens.Poster.width)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(Spacings.small)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Spacings.extraLarge)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.6f)
                    .height(Spacings.large)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogItemCardShimmerPreview() {
    KinopoiskTheme {
        MediaCatalogItemCardShimmer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Paddings.small, horizontal = Paddings.medium)
                .height(MediaCatalogDimens.Poster.height)
        )
    }
}
