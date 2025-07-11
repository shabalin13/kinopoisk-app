package com.shabalin13.kinopoisk.mediaCatalog.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
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
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaCatalogErrorContent(
    message: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Spacings.medium))

            Button(
                onClick = onRetryClick
            ) {
                Text(
                    text = stringResource(R.string.retry_button_title)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
internal fun MediaCatalogErrorContentPreview() {
    KinopoiskTheme {
        MediaCatalogErrorContent(
            "Что-то пошло не так. Возможно, вам нужно выключить VPN",
            { },
            Modifier.fillMaxSize()
        )
    }
}
