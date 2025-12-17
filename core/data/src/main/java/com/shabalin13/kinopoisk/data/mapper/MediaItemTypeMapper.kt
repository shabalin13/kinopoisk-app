package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemType
import com.shabalin13.kinopoisk.network.dto.MediaItemTypeDto
import javax.inject.Inject

@DataScope
internal class MediaItemTypeMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemTypeDto): MediaItemType {
        return when (dto) {
            MediaItemTypeDto.MOVIE -> MediaItemType.MOVIE
            MediaItemTypeDto.TV_SERIES -> MediaItemType.TV_SERIES
            MediaItemTypeDto.CARTOON -> MediaItemType.CARTOON
            MediaItemTypeDto.ANIME -> MediaItemType.ANIME
            MediaItemTypeDto.ANIMATED_SERIES -> MediaItemType.ANIMATED_SERIES
            MediaItemTypeDto.TV_SHOW -> MediaItemType.TV_SHOW
        }
    }
}
