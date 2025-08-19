package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.bloopers

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsNoteCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.BloopersInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.NoteInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.ShowAllCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsBloopersSection(
    bloopersInfo: BloopersInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.bloopers_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllBloopersButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.BloopersSection.NoteCard.height),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
            contentPadding = PaddingValues(horizontal = Paddings.medium)
        ) {
            items(bloopersInfo.bloopers) { blooperInfo ->
                MediaDetailsNoteCard(
                    noteInfo = blooperInfo,
                    onCardClick = { handleIntent(MediaDetailsIntent.BlooperCardClicked(blooperInfo.text)) },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(MediaDetailsDimens.BloopersSection.NoteCard.width)
                )
            }

            if (bloopersInfo.isMore) {
                item {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllBloopersButtonClicked) },
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(MediaDetailsDimens.BloopersSection.ShowAllCard.width)
                    )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsBloopersSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsBloopersSection(
                bloopersInfo = BloopersInfoUiModel(
                    bloopers = listOf(
                        NoteInfoUiModel(
                            text = "Во 2-м и 3-м сезонах Рик и остальные разъезжают на кроссовере " +
                                "Hundai Tucson 2012 года выпуска. Это нестыковка, потому что по сюжету сериала " +
                                "зомби-апокалипсис происходит в 2010 году.",
                            isSpoiler = true
                        )
                    ),
                    isMore = true
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsBloopersSectionPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsBloopersSection(
                bloopersInfo = BloopersInfoUiModel(
                    bloopers = listOf(
                        NoteInfoUiModel(
                            text = "Во 2-м и 3-м сезонах Рик и остальные разъезжают на кроссовере " +
                                "Hundai Tucson 2012 года выпуска. Это нестыковка, потому что по сюжету сериала " +
                                "зомби-апокалипсис происходит в 2010 году.",
                            isSpoiler = false
                        )
                    ),
                    isMore = false
                ),
                handleIntent = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
