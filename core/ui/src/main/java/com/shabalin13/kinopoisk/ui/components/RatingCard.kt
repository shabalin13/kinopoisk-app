package com.shabalin13.kinopoisk.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
fun RatingCard(
    rating: RatingUiModel,
    modifier: Modifier = Modifier,
) {
    Text(
        text = rating.value,
        color = Color.White,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Clip,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
            .background(rating.color)
            .padding(vertical = Paddings.extraSmall, horizontal = Paddings.small)
    )
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HighRatingCardPreview() {
    KinopoiskTheme {
        Surface {
            RatingCard(
                rating = RatingUiModel.from(8.1),
                modifier = Modifier
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MediumRatingCardPreview() {
    KinopoiskTheme {
        Surface {
            RatingCard(
                rating = RatingUiModel.from(6.0),
                modifier = Modifier
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LowRatingCardPreview() {
    KinopoiskTheme {
        Surface {
            RatingCard(
                rating = RatingUiModel.from(2.5),
                modifier = Modifier
            )
        }
    }
}
