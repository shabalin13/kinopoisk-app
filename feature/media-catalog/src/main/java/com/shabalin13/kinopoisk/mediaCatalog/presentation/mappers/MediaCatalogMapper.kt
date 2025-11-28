package com.shabalin13.kinopoisk.mediaCatalog.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogScope
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import javax.inject.Inject

@MediaCatalogScope
internal class MediaCatalogMapper @Inject constructor() {
    fun mapDomainToUiModel(mediaCatalogItem: MediaCatalogItem): MediaCatalogItemUiModel {
        val additionalInfoText = listOfNotNull(
            mediaCatalogItem.alternativeName,
            mediaCatalogItem.year?.toString()
        ).joinToString(separator = ", ")

        val ratingUiModel = mediaCatalogItem.rating?.run(RatingUiModel::from)

        return MediaCatalogItemUiModel(
            id = mediaCatalogItem.id,
            name = mediaCatalogItem.name,
            posterPreviewUrl = mediaCatalogItem.posterUrl,
            additionalInfo = additionalInfoText,
            rating = ratingUiModel
        )
    }
}
