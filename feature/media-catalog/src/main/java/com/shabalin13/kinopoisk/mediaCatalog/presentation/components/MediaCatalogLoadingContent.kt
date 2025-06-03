package com.shabalin13.kinopoisk.mediaCatalog.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

@Composable
internal fun MediaCatalogLoadingContent(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogLoadingContentPreview() {
    KinopoiskTheme {
        MediaCatalogLoadingContent(
            modifier = Modifier.fillMaxSize()
        )
    }
}
