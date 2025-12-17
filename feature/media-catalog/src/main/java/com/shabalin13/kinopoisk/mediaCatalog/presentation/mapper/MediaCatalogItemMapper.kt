package com.shabalin13.kinopoisk.mediaCatalog.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogScope
import com.shabalin13.kinopoisk.mediaCatalog.presentation.model.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import javax.inject.Inject

@MediaCatalogScope
internal class MediaCatalogItemMapper @Inject constructor() {
    fun mapDomainToUiModel(mediaCatalogItem: MediaCatalogItem): MediaCatalogItemUiModel {
        val additionalInfo = listOfNotNull(
            mediaCatalogItem.alternativeName,
            mediaCatalogItem.year?.toString()
        ).joinToString(separator = ", ")

        return MediaCatalogItemUiModel(
            id = mediaCatalogItem.id,
            name = mediaCatalogItem.name,
            posterUrl = mediaCatalogItem.posterUrl,
            additionalInfo = additionalInfo,
            rating = mediaCatalogItem.rating?.run(RatingUiModel::from)
        )
    }
}
