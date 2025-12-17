package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsSectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    onButtonClick: (() -> Unit)? = null,
) {
    Row(
        modifier = if (onButtonClick != null) {
            Modifier
                .clickable(
                    interactionSource = null,
                    indication = ripple(),
                    onClick = onButtonClick
                )
                .then(modifier)
        } else {
            modifier
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.weight(1f)
        )

        if (onButtonClick != null) {
            Text(
                text = stringResource(R.string.section_header_button_title),
                textAlign = TextAlign.End,
                maxLines = 1,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsSectionHeaderPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsSectionHeader(
                title = "Трейлеры и Тизеры",
                onButtonClick = { println("Button clicked") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MediaDetailsDimens.SectionHeader.height)
                    .padding(horizontal = Paddings.medium)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsSectionHeaderPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsSectionHeader(
                title = "Очень длинное название для конкретной секции",
                onButtonClick = { println("Button clicked") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MediaDetailsDimens.SectionHeader.height)
                    .padding(horizontal = Paddings.medium)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsSectionHeaderPreview3() {
    KinopoiskTheme {
        Surface {
            MediaDetailsSectionHeader(
                title = "Трейлеры и Тизеры",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(MediaDetailsDimens.SectionHeader.height)
                    .padding(horizontal = Paddings.medium)
            )
        }
    }
}
