package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.header

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.RatingsInfoUiModel
import com.shabalin13.kinopoisk.ui.R
import com.shabalin13.kinopoisk.ui.components.RatingChip
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun HeaderRatings(
    ratingsInfo: RatingsInfoUiModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacings.medium)
    ) {
        ratingsInfo.kpRating?.let { kpRating ->
            RatingChip(
                icon = ImageVector.vectorResource(R.drawable.core_kinopoisk_icon),
                rating = kpRating,
                modifier = Modifier
            )
        }

        ratingsInfo.imdbRating?.let { imdbRating ->
            RatingChip(
                icon = ImageVector.vectorResource(R.drawable.core_imdb_icon),
                rating = imdbRating,
                modifier = Modifier
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderRatingsPreview() {
    KinopoiskTheme {
        Surface {
            HeaderRatings(
                ratingsInfo = RatingsInfoUiModel(
                    kpRating = RatingUiModel.from(8.7),
                    imdbRating = RatingUiModel.from(6.5)
                ),
                modifier = Modifier
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderRatingsPreview2() {
    KinopoiskTheme {
        Surface {
            HeaderRatings(
                ratingsInfo = RatingsInfoUiModel(
                    imdbRating = RatingUiModel.from(6.5)
                ),
                modifier = Modifier
            )
        }
    }
}
