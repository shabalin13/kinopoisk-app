package com.shabalin13.kinopoisk.mediaCatalog.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.MediaCatalogItemUiModel
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import java.util.Locale

internal class MediaCatalogMapper {
    fun mapToUi(mediaCatalogItem: MediaCatalogItem): MediaCatalogItemUiModel {
        val additionalInfoText = listOfNotNull(
            mediaCatalogItem.alternativeName,
            mediaCatalogItem.year?.toString()
        ).joinToString(separator = ", ")

        val ratingUiModel = mediaCatalogItem.rating?.let { rating ->
            val color = when {
                rating > HIGH_RATING_THRESHOLD -> RatingColors.high
                rating in MEDIUM_RATING_THRESHOLD..HIGH_RATING_THRESHOLD -> RatingColors.medium
                else -> RatingColors.low
            }
            RatingUiModel(
                value = String.format(Locale.US, "%.1f", rating),
                color = color
            )
        }

        return MediaCatalogItemUiModel(
            id = mediaCatalogItem.id,
            name = mediaCatalogItem.name,
            posterPreviewUrl = mediaCatalogItem.posterPreviewUrl,
            additionalInfo = additionalInfoText,
            rating = ratingUiModel
        )
    }

    private companion object {
        const val HIGH_RATING_THRESHOLD = 7.0
        const val MEDIUM_RATING_THRESHOLD = 5.0
    }
}
