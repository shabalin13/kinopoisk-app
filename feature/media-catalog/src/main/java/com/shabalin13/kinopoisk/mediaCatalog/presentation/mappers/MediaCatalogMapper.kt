package com.shabalin13.kinopoisk.mediaCatalog.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.ui.models.RatingUiModel

internal class MediaCatalogMapper {
    fun mapDomainToUiModel(mediaCatalogItem: MediaCatalogItem): MediaCatalogItemUiModel {
        val additionalInfoText = listOfNotNull(
            mediaCatalogItem.alternativeName,
            mediaCatalogItem.year?.toString()
        ).joinToString(separator = ", ")

        val ratingUiModel = mediaCatalogItem.rating?.run(RatingUiModel::from)

        return MediaCatalogItemUiModel(
            id = mediaCatalogItem.id,
            name = mediaCatalogItem.name,
            posterPreviewUrl = mediaCatalogItem.posterPreviewUrl,
            additionalInfo = additionalInfoText,
            rating = ratingUiModel
        )
    }
}
