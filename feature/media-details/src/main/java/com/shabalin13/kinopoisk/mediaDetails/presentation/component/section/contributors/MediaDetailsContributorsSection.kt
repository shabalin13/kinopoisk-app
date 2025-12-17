package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.contributors

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsIntent
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsPersonCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.config.MediaDetailsConfig
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.PersonUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.component.ShowAllCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaDetailsContributorsSection(
    contributors: List<PersonUiModel>,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.contributors_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllContributorsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        val rowsCount = minOf(
            contributors.size,
            MediaDetailsConfig.CONTRIBUTORS_SECTION_ROWS_COUNT
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(rowsCount),
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    MediaDetailsDimens.PersonCard.height * rowsCount +
                        Paddings.small * 2 * rowsCount
                ),
        ) {
            items(contributors.take(MediaDetailsConfig.MAX_VISIBLE_CONTRIBUTORS)) { contributor ->
                MediaDetailsPersonCard(
                    person = contributor,
                    onCardClick = {
                        handleIntent(
                            MediaDetailsIntent.PersonCardClicked(contributor.id)
                        )
                    },
                    modifier = Modifier
                        .padding(horizontal = Paddings.medium, vertical = Paddings.small)
                        .width(MediaDetailsDimens.PersonCard.width)
                        .height(MediaDetailsDimens.PersonCard.height)
                )
            }

            if (contributors.size > MediaDetailsConfig.MAX_VISIBLE_CONTRIBUTORS) {
                item(
                    span = { GridItemSpan(rowsCount) }
                ) {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllContributorsButtonClicked) },
                        modifier = Modifier.padding(
                            horizontal = Paddings.large,
                            vertical = Paddings.small
                        )
                    )
                }
            }
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsContributorsSectionPreview() {
    KinopoiskTheme {
        Surface {
            val contributor = PersonUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                additionalInfo = "Режиссер"
            )
            MediaDetailsContributorsSection(
                contributors = List(9) { contributor },
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsContributorsSectionPreview2() {
    KinopoiskTheme {
        Surface {
            val contributor = PersonUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg"
            )
            MediaDetailsContributorsSection(
                contributors = List(3) { contributor },
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Suppress("MagicNumber")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsContributorsSectionPreview3() {
    KinopoiskTheme {
        Surface {
            val contributor = PersonUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg"
            )
            MediaDetailsContributorsSection(
                contributors = List(2) { contributor },
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
