package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.seasons

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.SeasonsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaDetailsSeasonsSection(
    seasonsInfo: SeasonsInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.seasons_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllSeasonsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        Text(
            text = seasonsInfo,
            modifier = Modifier.padding(horizontal = Paddings.medium),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsSeasonsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsSeasonsSection(
                seasonsInfo = "11 сезонов, 177 серий",
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
