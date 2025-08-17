package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.actors

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
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.components.ShowAllCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings

@Composable
internal fun MediaDetailsActorsSection(
    actorsInfo: ActorsInfoUiModel,
    handleIntent: (MediaDetailsIntent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        MediaDetailsSectionHeader(
            title = stringResource(R.string.actors_section_header_title),
            onButtonClick = { handleIntent(MediaDetailsIntent.ShowAllActorsButtonClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(MediaDetailsDimens.SectionHeader.height)
                .padding(horizontal = Paddings.medium)
        )

        val rowsCount = minOf(
            actorsInfo.actors.size,
            MediaDetailsConfig.ACTORS_SECTION_ROWS_COUNT
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(rowsCount),
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    MediaDetailsDimens.PersonCard.height * rowsCount +
                        Paddings.small * 2 * rowsCount
                )
        ) {
            items(actorsInfo.actors) { actorInfo ->
                MediaDetailsPersonCard(
                    personInfo = actorInfo,
                    onCardClick = { handleIntent(MediaDetailsIntent.PersonCardClicked(actorInfo.id)) },
                    modifier = Modifier
                        .padding(horizontal = Paddings.medium, vertical = Paddings.small)
                        .width(MediaDetailsDimens.PersonCard.width)
                        .height(MediaDetailsDimens.PersonCard.height)
                )
            }

            if (actorsInfo.isMore) {
                item(
                    span = { GridItemSpan(rowsCount) }
                ) {
                    ShowAllCard(
                        onCardClick = { handleIntent(MediaDetailsIntent.ShowAllActorsButtonClicked) },
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

@Suppress("LongMethod")
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsActorsSectionPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsActorsSection(
                actorsInfo = ActorsInfoUiModel(
                    actors = listOf(
                        PersonInfoUiModel(
                            id = 40778,
                            name = "Дэниэл Рэдклифф",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                            additionalInfo = "Harry Potter"
                        ),
                        PersonInfoUiModel(
                            id = 40780,
                            name = "Руперт Гринт",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40780.jpg",
                            additionalInfo = "Ron Weasley"
                        ),
                        PersonInfoUiModel(
                            id = 40779,
                            name = "Эмма Уотсон",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40779.jpg",
                            additionalInfo = "Hermione Granger"
                        ),
                        PersonInfoUiModel(
                            id = 10022,
                            name = "Ричард Харрис",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_10022.jpg",
                            additionalInfo = "Albus Dumbledore"
                        ),
                        PersonInfoUiModel(
                            id = 202,
                            name = "Алан Рикман",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_202.jpg",
                            additionalInfo = "Professor Snape"
                        ),
                        PersonInfoUiModel(
                            id = 20620,
                            name = "Мэгги Смит",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_20620.jpg",
                            additionalInfo = "Professor McGonagall"
                        ),
                        PersonInfoUiModel(
                            id = 24216,
                            name = "Робби Колтрейн",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_24216.jpg",
                            additionalInfo = "Hagrid"
                        ),
                        PersonInfoUiModel(
                            id = 26071,
                            name = "Том Фелтон",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_26071.jpg",
                            additionalInfo = "Draco Malfoy"
                        ),
                        PersonInfoUiModel(
                            id = 40795,
                            name = "Мэттью Льюис",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40795.jpg",
                            additionalInfo = "Neville Longbottom"
                        ),
                        PersonInfoUiModel(
                            id = 14492,
                            name = "Иэн Харт",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_14492.jpg",
                            additionalInfo = "Professor Quirrell"
                        )
                    ),
                    isMore = false
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
internal fun MediaDetailsActorsSectionPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsActorsSection(
                actorsInfo = ActorsInfoUiModel(
                    actors = listOf(
                        PersonInfoUiModel(
                            id = 40778,
                            name = "Дэниэл Рэдклифф",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                            additionalInfo = "Harry Potter"
                        ),
                        PersonInfoUiModel(
                            id = 40780,
                            name = "Руперт Гринт",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40780.jpg",
                            additionalInfo = "Ron Weasley"
                        ),
                        PersonInfoUiModel(
                            id = 40779,
                            name = "Эмма Уотсон",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40779.jpg",
                            additionalInfo = "Hermione Granger"
                        )
                    ),
                    isMore = true
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
internal fun MediaDetailsActorsSectionPreview3() {
    KinopoiskTheme {
        Surface {
            MediaDetailsActorsSection(
                actorsInfo = ActorsInfoUiModel(
                    actors = listOf(
                        PersonInfoUiModel(
                            id = 40778,
                            name = "Дэниэл Рэдклифф",
                            photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                            additionalInfo = "Harry Potter"
                        ),
                    ),
                    isMore = false
                ),
                handleIntent = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
