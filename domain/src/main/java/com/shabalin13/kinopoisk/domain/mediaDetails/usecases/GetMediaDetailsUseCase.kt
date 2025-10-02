package com.shabalin13.kinopoisk.domain.mediaDetails.usecases

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails

interface GetMediaDetailsUseCase {
    suspend operator fun invoke(mediaId: Int): Result<MediaDetails>
}
