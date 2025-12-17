package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.RelatedMediaItem
import com.shabalin13.kinopoisk.network.dto.RelatedMediaItemDto
import javax.inject.Inject

@DataScope
internal class RelatedMediaItemMapper @Inject constructor() {
    fun mapDtoToDomain(dto: RelatedMediaItemDto): RelatedMediaItem? {
        val name = dto.name
        return if (name.isNullOrBlank()) {
            null
        } else {
            RelatedMediaItem(
                id = dto.id,
                name = name,
                alternativeName = dto.alternativeName?.takeIf { it.isNotBlank() },
                year = dto.year?.takeIf { it >= 1 },
                rating = dto.ratings?.kp?.takeIf { it > 1 },
                posterUrl = dto.poster?.previewUrl?.takeIf { it.isNotBlank() }
            )
        }
    }
}
