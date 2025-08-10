package com.shabalin13.kinopoisk.mediaDetails.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsState
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

@Composable
internal fun MediaDetailsErrorContent(
    state: MediaDetailsState.Error,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = state.message,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaDetailsErrorContentPreview() {
    KinopoiskTheme {
        MediaDetailsErrorContent(
            state = MediaDetailsState.Error("Что-то пошло не так..."),
            modifier = Modifier.fillMaxSize()
        )
    }
}
