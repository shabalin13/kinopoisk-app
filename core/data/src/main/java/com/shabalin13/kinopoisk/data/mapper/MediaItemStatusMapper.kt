package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemStatus
import com.shabalin13.kinopoisk.network.dto.MediaItemStatusDto
import javax.inject.Inject

@DataScope
internal class MediaItemStatusMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemStatusDto): MediaItemStatus {
        return when (dto) {
            MediaItemStatusDto.FILMING -> MediaItemStatus.FILMING
            MediaItemStatusDto.PRE_PRODUCTION -> MediaItemStatus.PRE_PRODUCTION
            MediaItemStatusDto.COMPLETED -> MediaItemStatus.COMPLETED
            MediaItemStatusDto.ANNOUNCED -> MediaItemStatus.ANNOUNCED
            MediaItemStatusDto.POST_PRODUCTION -> MediaItemStatus.POST_PRODUCTION
        }
    }
}
