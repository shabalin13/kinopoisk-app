package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemReleaseYears
import com.shabalin13.kinopoisk.network.dto.MediaItemReleaseYearsDto
import javax.inject.Inject

@DataScope
internal class MediaItemReleaseYearsMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemReleaseYearsDto): MediaItemReleaseYears? {
        val start = dto.start
        if (start == null || start < 1) return null
        return MediaItemReleaseYears(
            start = start,
            end = dto.end?.takeIf { it >= 1 }
        )
    }
}
