package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemFact
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.NoteUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemFactMapper @Inject constructor() {
    fun mapDomainToUiModel(fact: MediaItemFact): NoteUiModel {
        return NoteUiModel(
            text = fact.value,
            isSpoiler = fact.isSpoiler
        )
    }
}
