package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.network.dto.MediaCatalogDto
import javax.inject.Inject

@DataScope
internal class MediaCatalogMapper @Inject constructor(
    private val mediaCatalogItemMapper: MediaCatalogItemMapper,
) {
    fun mapDtoToDomain(dto: MediaCatalogDto): List<MediaCatalogItem> {
        return dto.items.mapNotNull { mediaCatalogItemDto ->
            mediaCatalogItemMapper.mapDtoToDomain(mediaCatalogItemDto)
        }
    }
}
