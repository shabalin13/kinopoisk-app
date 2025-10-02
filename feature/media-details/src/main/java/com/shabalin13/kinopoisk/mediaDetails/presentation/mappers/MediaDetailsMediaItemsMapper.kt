package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsLinkedMediaItem
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsSimilarMediaItem
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.LinkedMediaItemsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaItemInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.SimilarMediaItemsInfoUiModel
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import javax.inject.Inject

internal class MediaDetailsMediaItemsMapper @Inject constructor() {
    fun mapLinkedMediaItemsToLinkedMediaItemsInfo(
        linkedMediaItems: List<MediaDetailsLinkedMediaItem>,
    ): LinkedMediaItemsInfoUiModel? {
        if (linkedMediaItems.isEmpty()) return null

        return LinkedMediaItemsInfoUiModel(
            linkedMediaItems = linkedMediaItems.take(LinkedMediaItemsInfoUiModel.MAX_VISIBLE)
                .map { linkedMediaItem ->
                    MediaItemInfoUiModel(
                        id = linkedMediaItem.id,
                        name = linkedMediaItem.name,
                        posterPreviewUrl = linkedMediaItem.posterPreviewUrl,
                        year = linkedMediaItem.year,
                        rating = linkedMediaItem.rating?.run(RatingUiModel::from)
                    )
                },
            isMore = linkedMediaItems.size > LinkedMediaItemsInfoUiModel.MAX_VISIBLE
        )
    }

    fun mapSimilarMediaItemsToSimilarMediaItemsInfo(
        similarMediaItems: List<MediaDetailsSimilarMediaItem>,
    ): SimilarMediaItemsInfoUiModel? {
        if (similarMediaItems.isEmpty()) return null

        return SimilarMediaItemsInfoUiModel(
            similarMediaItems = similarMediaItems.take(SimilarMediaItemsInfoUiModel.MAX_VISIBLE)
                .map { similarMediaItem ->
                    MediaItemInfoUiModel(
                        id = similarMediaItem.id,
                        name = similarMediaItem.name,
                        posterPreviewUrl = similarMediaItem.posterPreviewUrl,
                        year = similarMediaItem.year,
                        rating = similarMediaItem.rating?.run(RatingUiModel::from)
                    )
                },
            isMore = similarMediaItems.size > SimilarMediaItemsInfoUiModel.MAX_VISIBLE
        )
    }
}
