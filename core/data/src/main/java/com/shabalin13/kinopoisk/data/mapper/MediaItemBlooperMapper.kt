package com.shabalin13.kinopoisk.data.mapper

import androidx.core.text.HtmlCompat
import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemBlooper
import com.shabalin13.kinopoisk.network.dto.MediaItemNoteDto
import javax.inject.Inject

@DataScope
internal class MediaItemBlooperMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemNoteDto): MediaItemBlooper? {
        val value = dto.value
        return if (dto.type?.uppercase() != "BLOOPER" || value.isNullOrBlank()) {
            null
        } else {
            MediaItemBlooper(
                value = HtmlCompat.fromHtml(value, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    .toString(),
                isSpoiler = dto.isSpoiler ?: false
            )
        }
    }
}
