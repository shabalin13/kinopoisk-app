package com.shabalin13.kinopoisk.data.mediaCatalog.mapper

import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogDto
import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogItemDto
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem

internal class MediaCatalogMapper {
    fun mapToDomain(mediaCatalogDto: MediaCatalogDto): List<MediaCatalogItem> {
        return mediaCatalogDto.items.mapNotNull { mediaCatalogItemDto ->
            mapToDomain(mediaCatalogItemDto)
        }
    }

    fun mapToDomain(mediaCatalogItemDto: MediaCatalogItemDto): MediaCatalogItem? {
        if (mediaCatalogItemDto.name.isBlank()) return null
        return MediaCatalogItem(
            id = mediaCatalogItemDto.id,
            name = mediaCatalogItemDto.name,
            posterPreviewUrl = mediaCatalogItemDto.poster?.previewUrl,
            alternativeName = mediaCatalogItemDto.alternativeName.takeIf { !it.isNullOrBlank() },
            year = mediaCatalogItemDto.year?.takeIf { it >= 1 },
            rating = mediaCatalogItemDto.rating?.kp?.takeIf { it >= 1 }
        )
    }
}
