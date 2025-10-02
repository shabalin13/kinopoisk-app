package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.contributors

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsPersonCard
import com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers.MediaDetailsSectionHeader
import com.shabalin13.kinopoisk.mediaDetails.presentation.config.MediaDetailsConfig
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ContributorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.ShowAllCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaDetailsContributorsSection(
    contributorsInfo: ContributorsInfoUiModel,
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
            contributorsInfo.contributors.size,
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
            items(contributorsInfo.contributors) { contributorInfo ->
                MediaDetailsPersonCard(
                    personInfo = contributorInfo,
                    onCardClick = {
                        handleIntent(
                            MediaDetailsIntent.PersonCardClicked(contributorInfo.id)
                        )
                    },
                    modifier = Modifier
                        .padding(horizontal = Paddings.medium, vertical = Paddings.small)
                        .width(MediaDetailsDimens.PersonCard.width)
                        .height(MediaDetailsDimens.PersonCard.height)
                )
            }

            if (contributorsInfo.isMore) {
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
            val contributor = PersonInfoUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                additionalInfo = "Режиссер"
            )
            MediaDetailsContributorsSection(
                contributorsInfo = ContributorsInfoUiModel(
                    contributors = List(9) { contributor },
                    isMore = false
                ),
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
            val contributor = PersonInfoUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg"
            )
            MediaDetailsContributorsSection(
                contributorsInfo = ContributorsInfoUiModel(
                    contributors = List(3) { contributor },
                    isMore = true
                ),
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
            val contributor = PersonInfoUiModel(
                id = 123,
                name = "Крис Коламбус",
                photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg"
            )
            MediaDetailsContributorsSection(
                contributorsInfo = ContributorsInfoUiModel(
                    contributors = List(2) { contributor },
                    isMore = false
                ),
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
