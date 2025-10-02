package com.shabalin13.kinopoisk.data.mediaDetails.usecases

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.repositories.MediaDetailsRepository
import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import javax.inject.Inject

internal class GetMediaDetailsUseCaseImpl @Inject constructor(
    private val repository: MediaDetailsRepository,
) : GetMediaDetailsUseCase {
    override suspend fun invoke(mediaId: Int): Result<MediaDetails> {
        return repository.getMediaDetails(mediaId)
    }
}
