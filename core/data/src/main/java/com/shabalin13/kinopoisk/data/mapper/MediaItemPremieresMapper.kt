package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemPremieres
import com.shabalin13.kinopoisk.network.dto.MediaItemPremieresDto
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@DataScope
internal class MediaItemPremieresMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemPremieresDto): MediaItemPremieres? {
        val worldPremiere = dto.world?.takeIf { it.isNotBlank() }?.let {
            Instant.parse(it).toLocalDateTime(TimeZone.UTC).date
        }
        val russiaPremiere = dto.russia?.takeIf { it.isNotBlank() }?.let {
            Instant.parse(it).toLocalDateTime(TimeZone.UTC).date
        }
        return if (worldPremiere == null && russiaPremiere == null) {
            null
        } else {
            MediaItemPremieres(
                world = worldPremiere,
                russia = russiaPremiere
            )
        }
    }
}
