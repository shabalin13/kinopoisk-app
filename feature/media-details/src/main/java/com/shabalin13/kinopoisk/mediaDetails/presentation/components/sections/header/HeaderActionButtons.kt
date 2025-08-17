package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.header

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActionButtonsInfoUiModel
import com.shabalin13.kinopoisk.ui.components.ActionButton
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun HeaderActionButtons(
    actionButtonsInfo: ActionButtonsInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.star_rate_icon),
            text = stringResource(R.string.rate_button_title),
            onActionClick = { handleIntent(MediaDetailsIntent.RateButtonClicked) },
            selectedIcon = ImageVector.vectorResource(R.drawable.star_rate_selected_icon),
            isSelected = actionButtonsInfo.isRated
        )

        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.watchlist_add_icon),
            text = stringResource(R.string.toggle_watchlist_button_title),
            onActionClick = { handleIntent(MediaDetailsIntent.ToggleWatchlistButtonClicked) },
            selectedIcon = ImageVector.vectorResource(R.drawable.watchlist_add_selected_icon),
            isSelected = actionButtonsInfo.isInWatchlist
        )

        ActionButton(
            icon = ImageVector.vectorResource(R.drawable.share_icon),
            text = stringResource(R.string.share_button_title),
            onActionClick = { handleIntent(MediaDetailsIntent.ShareButtonClicked) }
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderActionButtonsPreview() {
    KinopoiskTheme {
        Surface {
            HeaderActionButtons(
                actionButtonsInfo = ActionButtonsInfoUiModel(),
                handleIntent = { intent ->
                    when (intent) {
                        MediaDetailsIntent.RateButtonClicked -> println("Rate button clicked")
                        MediaDetailsIntent.ShareButtonClicked -> println("Share button clicked")
                        MediaDetailsIntent.ToggleWatchlistButtonClicked -> println("Toggle watchlist button clicked")
                        else -> Unit
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Paddings.small)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderActionButtonsPreview2() {
    KinopoiskTheme {
        Surface {
            HeaderActionButtons(
                actionButtonsInfo = ActionButtonsInfoUiModel(
                    isRated = true,
                    isInWatchlist = true
                ),
                handleIntent = { intent ->
                    when (intent) {
                        MediaDetailsIntent.RateButtonClicked -> println("Rate button clicked")
                        MediaDetailsIntent.ShareButtonClicked -> println("Share button clicked")
                        MediaDetailsIntent.ToggleWatchlistButtonClicked -> println("Toggle watchlist button clicked")
                        else -> Unit
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Paddings.small)
            )
        }
    }
}
