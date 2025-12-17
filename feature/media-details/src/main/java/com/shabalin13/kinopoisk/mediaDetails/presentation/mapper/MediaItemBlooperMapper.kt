package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemBlooper
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.NoteUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemBlooperMapper @Inject constructor() {
    fun mapDomainToUiModel(blooper: MediaItemBlooper): NoteUiModel {
        return NoteUiModel(
            text = blooper.value,
            isSpoiler = blooper.isSpoiler
        )
    }
}
