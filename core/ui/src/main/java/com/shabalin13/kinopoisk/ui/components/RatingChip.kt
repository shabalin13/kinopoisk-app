package com.shabalin13.kinopoisk.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shabalin13.kinopoisk.ui.R
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
fun RatingChip(
    icon: ImageVector,
    rating: RatingUiModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(
                horizontal = Paddings.small,
                vertical = Paddings.extraSmall
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacings.small)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = rating.value,
            tint = icon.tintColor,
            modifier = Modifier.size(28.dp)
        )

        Text(
            text = rating.value,
            style = MaterialTheme.typography.headlineSmall,
            color = rating.color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RatingChipPreview() {
    KinopoiskTheme {
        Surface {
            RatingChip(
                icon = ImageVector.vectorResource(R.drawable.core_kinopoisk_icon),
                rating = RatingUiModel.from(8.7),
                modifier = Modifier
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RatingChipPreview2() {
    KinopoiskTheme {
        Surface {
            RatingChip(
                icon = ImageVector.vectorResource(R.drawable.core_imdb_icon),
                rating = RatingUiModel.from(6.7),
                modifier = Modifier
            )
        }
    }
}
