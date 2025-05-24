package com.shabalin13.kinopoisk.data.mediaCatalog.mapper

import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogItemDto
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem

internal class MediaCatalogMapper {
    fun mapToDomain(mediaCatalogItemDto: MediaCatalogItemDto): MediaCatalogItem {
        return MediaCatalogItem(
            id = mediaCatalogItemDto.id,
            name = mediaCatalogItemDto.name,
            posterPreviewUrl = mediaCatalogItemDto.poster?.previewUrl,
            alternativeName = mediaCatalogItemDto.alternativeName,
            year = mediaCatalogItemDto.year,
            rating = mediaCatalogItemDto.rating?.kp
        )
    }
}
