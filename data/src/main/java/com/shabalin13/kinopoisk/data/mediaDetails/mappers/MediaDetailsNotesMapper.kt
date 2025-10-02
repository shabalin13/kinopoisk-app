package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import androidx.core.text.HtmlCompat
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsNoteDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsBlooper
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFact

internal class MediaDetailsNotesMapper {
    private fun mapNoteDtoToFact(noteDto: MediaDetailsNoteDto): MediaDetailsFact? {
        return if (noteDto.type?.uppercase() != "FACT" || noteDto.value.isNullOrBlank()) {
            null
        } else {
            MediaDetailsFact(
                value = HtmlCompat.fromHtml(noteDto.value, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    .toString(),
                isSpoiler = noteDto.isSpoiler ?: false
            )
        }
    }

    fun mapNotesDtoToFacts(notesDto: List<MediaDetailsNoteDto>?): List<MediaDetailsFact> {
        return notesDto?.mapNotNull(::mapNoteDtoToFact) ?: emptyList()
    }

    private fun mapNoteDtoToBlooper(noteDto: MediaDetailsNoteDto): MediaDetailsBlooper? {
        return if (noteDto.type?.uppercase() != "BLOOPER" || noteDto.value.isNullOrBlank()) {
            null
        } else {
            MediaDetailsBlooper(
                value = HtmlCompat.fromHtml(noteDto.value, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    .toString(),
                isSpoiler = noteDto.isSpoiler ?: false
            )
        }
    }

    fun mapNotesDtoToBloopers(notesDto: List<MediaDetailsNoteDto>?): List<MediaDetailsBlooper> {
        return notesDto?.mapNotNull(::mapNoteDtoToBlooper) ?: emptyList()
    }
}
