package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.statistics

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.StatisticsInfoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsStatisticsCard(
    statisticsInfo: StatisticsInfoUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = Paddings.medium, vertical = Paddings.small),
        verticalArrangement = Arrangement.spacedBy(Spacings.extraSmall)
    ) {
        Text(
            text = statisticsInfo.statistics,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = statisticsInfo.description,
            style = MaterialTheme.typography.bodyMedium,
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
internal fun MediaDetailsStatisticsCardPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsStatisticsCard(
                statisticsInfo = StatisticsInfoUiModel(
                    statistics = "21 марта 2002",
                    description = "Премьера (Россия)"
                ),
                modifier = Modifier
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsStatisticsCardPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsStatisticsCard(
                statisticsInfo = StatisticsInfoUiModel(
                    statistics = "$5.5 млн",
                    description = "Сборы (Россия)"
                ),
                modifier = Modifier
            )
        }
    }
}
