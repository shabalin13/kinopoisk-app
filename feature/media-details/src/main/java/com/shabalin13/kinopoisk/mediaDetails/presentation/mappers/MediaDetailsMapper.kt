package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import javax.inject.Inject

internal class MediaDetailsMapper @Inject constructor(
    private val headerMapper: MediaDetailsHeaderMapper,
) {
    fun mapDomainToUiModel(mediaDetails: MediaDetails): MediaDetailsUiModel {
        return MediaDetailsUiModel(
            id = mediaDetails.id,
            headerInfo = headerMapper.mapToHeaderInfo(mediaDetails)
        )
    }
}
