package com.shabalin13.kinopoisk.mediaCatalog.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaCatalog.R
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaCatalogInitialContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.initial_content_message),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(Paddings.large)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogInitialContentPreview() {
    KinopoiskTheme {
        MediaCatalogInitialContent(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
