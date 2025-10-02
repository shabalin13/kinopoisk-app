package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsLinkedMediaItemDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsSimilarMediaItemDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsLinkedMediaItem
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsSimilarMediaItem

internal class MediaDetailsMediaItemsMapper {
    private fun mapLinkedItemDtoToLinkedItem(
        linkedItemDto: MediaDetailsLinkedMediaItemDto,
    ): MediaDetailsLinkedMediaItem? {
        return if (linkedItemDto.name.isNullOrBlank()) {
            null
        } else {
            MediaDetailsLinkedMediaItem(
                id = linkedItemDto.id,
                name = linkedItemDto.name,
                alternativeName = linkedItemDto.alternativeName?.takeIf { it.isNotBlank() },
                year = linkedItemDto.year?.takeIf { it >= 1 },
                rating = linkedItemDto.rating?.kp?.takeIf { it > 1 },
                posterPreviewUrl = linkedItemDto.poster?.previewUrl?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun mapLinkedItemsDtoToLinkedItems(
        linkedItemsDto: List<MediaDetailsLinkedMediaItemDto>?,
    ): List<MediaDetailsLinkedMediaItem> {
        return linkedItemsDto?.mapNotNull(::mapLinkedItemDtoToLinkedItem) ?: emptyList()
    }

    private fun mapSimilarItemDtoToSimilarItem(
        similarItemDto: MediaDetailsSimilarMediaItemDto,
    ): MediaDetailsSimilarMediaItem? {
        return if (similarItemDto.name.isNullOrBlank()) {
            null
        } else {
            MediaDetailsSimilarMediaItem(
                id = similarItemDto.id,
                name = similarItemDto.name,
                alternativeName = similarItemDto.alternativeName?.takeIf { it.isNotBlank() },
                year = similarItemDto.year?.takeIf { it >= 1 },
                rating = similarItemDto.rating?.kp?.takeIf { it > 1 },
                posterPreviewUrl = similarItemDto.poster?.previewUrl?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun mapSimilarItemsDtoToSimilarItems(
        similarItemsDto: List<MediaDetailsSimilarMediaItemDto>?,
    ): List<MediaDetailsSimilarMediaItem> {
        return similarItemsDto?.mapNotNull(::mapSimilarItemDtoToSimilarItem) ?: emptyList()
    }
}
