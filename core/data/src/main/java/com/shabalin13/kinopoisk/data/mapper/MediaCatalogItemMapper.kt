package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.network.dto.MediaCatalogItemDto
import javax.inject.Inject

@DataScope
internal class MediaCatalogItemMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaCatalogItemDto): MediaCatalogItem? {
        if (dto.name.isBlank()) return null
        return MediaCatalogItem(
            id = dto.id,
            name = dto.name,
            posterUrl = dto.poster?.previewUrl,
            alternativeName = dto.alternativeName.takeIf { !it.isNullOrBlank() },
            year = dto.year?.takeIf { it >= 1 },
            rating = dto.ratings?.kp?.takeIf { it >= 1 }
        )
    }
}
