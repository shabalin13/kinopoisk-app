package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun HeaderDescription(
    descriptionInfo: DescriptionInfoUiModel,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = descriptionInfo.description,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )

        TextButton(onClick = onButtonClick) {
            Text(
                text = stringResource(R.string.show_full_description_button_title)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HeaderDescriptionPreview() {
    KinopoiskTheme {
        HeaderDescription(
            descriptionInfo = DescriptionInfoUiModel(
                description = "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: " +
                    "родители умерли, едва ему исполнился год, а от дяди и тети, взявших сироту " +
                    "на воспитание, достаются лишь тычки да подзатыльники. Но в одиннадцатые " +
                    "день рождения Гарри все меняется...",
                ageRating = "12+"
            ),
            onButtonClick = { println("Show full description button clicked") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Paddings.small)
        )
    }
}
