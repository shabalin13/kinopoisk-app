package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.statistics

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.StatisticsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsStatisticsSection(
    statisticsInfos: List<StatisticsInfoUiModel>,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.statistics_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllStatisticsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
            contentPadding = PaddingValues(horizontal = Paddings.medium)
        ) {
            items(statisticsInfos) { statisticsInfo ->
                MediaDetailsStatisticsCard(
                    statisticsInfo = statisticsInfo
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsStatisticsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsStatisticsSection(
                statisticsInfos = listOf(
                    StatisticsInfoUiModel(
                        statistics = "21 марта 2002",
                        description = "Премьера (Россия)"
                    ),
                    StatisticsInfoUiModel(
                        statistics = "$5.5 млн",
                        description = "Сборы (Россия)"
                    )
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
