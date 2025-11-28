package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaItemBlooper
import com.shabalin13.kinopoisk.domain.model.MediaItemFact
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.BloopersInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.FactsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.NoteInfoUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class MediaDetailsNotesMapper @Inject constructor() {
    fun mapFactsToFactsInfo(facts: List<MediaItemFact>): FactsInfoUiModel? {
        if (facts.isEmpty()) return null

        return FactsInfoUiModel(
            facts = facts.take(FactsInfoUiModel.MAX_VISIBLE).map { fact ->
                NoteInfoUiModel(
                    text = fact.value,
                    isSpoiler = fact.isSpoiler
                )
            },
            isMore = facts.size > FactsInfoUiModel.MAX_VISIBLE
        )
    }

    fun mapBloopersToBloopersInfo(bloopers: List<MediaItemBlooper>): BloopersInfoUiModel? {
        if (bloopers.isEmpty()) return null

        return BloopersInfoUiModel(
            bloopers = bloopers.take(BloopersInfoUiModel.MAX_VISIBLE).map { blooper ->
                NoteInfoUiModel(
                    text = blooper.value,
                    isSpoiler = blooper.isSpoiler
                )
            },
            isMore = bloopers.size > BloopersInfoUiModel.MAX_VISIBLE
        )
    }
}
