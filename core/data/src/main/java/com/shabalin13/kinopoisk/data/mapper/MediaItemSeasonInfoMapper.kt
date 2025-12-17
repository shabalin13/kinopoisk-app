package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemSeasonInfo
import com.shabalin13.kinopoisk.network.dto.MediaItemSeasonInfoDto
import javax.inject.Inject

@DataScope
internal class MediaItemSeasonInfoMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemSeasonInfoDto): MediaItemSeasonInfo? {
        val seasonNumber = dto.seasonNumber?.takeIf { it >= 1 }
        val episodesCount = dto.episodesCount?.takeIf { it >= 1 }
        return if (seasonNumber != null && episodesCount != null) {
            MediaItemSeasonInfo(seasonNumber, episodesCount)
        } else {
            null
        }
    }
}
