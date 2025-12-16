package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.common

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shabalin13.kinopoisk.mediaDetails.presentation.config.MediaDetailsConfig
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.NoteUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.component.SpoilerCard
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

@Composable
internal fun MediaDetailsNoteCard(
    note: NoteUiModel,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isSpoilerRevealed by rememberSaveable { mutableStateOf(!note.isSpoiler) }

    Crossfade(
        targetState = isSpoilerRevealed,
        modifier = Modifier
            .clickable(
                indication = ripple(),
                interactionSource = null,
                onClick = {
                    if (isSpoilerRevealed) {
                        onCardClick()
                    } else {
                        isSpoilerRevealed = true
                    }
                }
            )
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .then(modifier),
        animationSpec = tween(MediaDetailsConfig.NOTE_CARD_ANIMATION_DURATION_MILLIS)
    ) { isTextShown ->
        val innerModifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        if (isTextShown) {
            Text(
                text = note.text,
                modifier = innerModifier,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis
            )
        } else {
            SpoilerCard(
                modifier = innerModifier
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsNoteCardPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsNoteCard(
                note = NoteUiModel(
                    text = "Дж. К. Роулинг продала права на создание фильмов по первым четырем книгам приключений " +
                        "Гарри Поттера в 1999 году за скромную сумму в один миллион фунтов стерлингов " +
                        "(на тот момент чуть больше 1,5 млн. долларов). " +
                        "Что намного важнее, было оговорено, что писательница будет получать определённую " +
                        "часть от сборов каждого из фильмов, и будет иметь значительный контроль над всеми " +
                        "стадиями производства картин.",
                    isSpoiler = false,
                ),
                onCardClick = {},
                modifier = Modifier
                    .width(MediaDetailsDimens.FactsSection.NoteCard.width)
                    .height(MediaDetailsDimens.FactsSection.NoteCard.height)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsNoteCardPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsNoteCard(
                NoteUiModel(
                    text = "Фильм снят по мотивам романа Дж.К. Роулинг «Гарри Поттер и " +
                        "философский камень» (Harry Potter and the Philosopher's Stone, 1997).",
                    isSpoiler = true
                ),
                onCardClick = {},
                modifier = Modifier
                    .width(MediaDetailsDimens.FactsSection.NoteCard.width)
                    .height(MediaDetailsDimens.FactsSection.NoteCard.height)
            )
        }
    }
}
