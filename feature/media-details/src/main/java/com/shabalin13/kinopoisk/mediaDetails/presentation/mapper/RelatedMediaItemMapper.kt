package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.RelatedMediaItem
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.RelatedMediaItemUiModel
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class RelatedMediaItemMapper @Inject constructor() {
    fun mapDomainToUiModel(relatedMediaItem: RelatedMediaItem): RelatedMediaItemUiModel {
        return RelatedMediaItemUiModel(
            id = relatedMediaItem.id,
            name = relatedMediaItem.name,
            posterUrl = relatedMediaItem.posterUrl,
            year = relatedMediaItem.year,
            rating = relatedMediaItem.rating?.run(RatingUiModel::from)
        )
    }
}
