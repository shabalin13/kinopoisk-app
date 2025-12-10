package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.facts

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsNoteCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.config.MediaDetailsConfig
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.NoteUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.component.ShowAllCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun MediaDetailsFactsSection(
    facts: List<NoteUiModel>,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.facts_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllFactsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.FactsSection.NoteCard.height),
            horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
            contentPadding = PaddingValues(horizontal = Paddings.medium)
        ) {
            items(facts.take(MediaDetailsConfig.MAX_VISIBLE_FACTS)) { fact ->
                MediaDetailsNoteCard(
                    note = fact,
                    onCardClick = { handleIntent(MediaDetailsIntent.FactCardClicked(fact.text)) },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(MediaDetailsDimens.FactsSection.NoteCard.width)
                )
            }

            if (facts.size > MediaDetailsConfig.MAX_VISIBLE_FACTS) {
                item {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllFactsButtonClicked) },
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(MediaDetailsDimens.FactsSection.ShowAllCard.width)
                    )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsFactsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsFactsSection(
                facts = listOf(
                    NoteUiModel(
                        text = "Фильм снят по мотивам романа Дж.К. Роулинг «Гарри Поттер и " +
                            "философский камень» (Harry Potter and the Philosopher's Stone, 1997).",
                        isSpoiler = false
                    )
                ),
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsFactsSectionPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsFactsSection(
                facts = listOf(
                    NoteUiModel(
                        text = "Фильм снят по мотивам романа Дж.К. Роулинг «Гарри Поттер и " +
                            "философский камень» (Harry Potter and the Philosopher's Stone, 1997).",
                        isSpoiler = true
                    )
                ),
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
