package com.shabalin13.kinopoisk.domain.usecase

import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.domain.repository.MediaItemRepository
import javax.inject.Inject

class GetMediaItemUseCase @Inject constructor(
    private val repository: MediaItemRepository,
) {
    suspend operator fun invoke(mediaId: Int): Result<MediaItem> {
        return repository.getMediaItem(mediaId)
    }
}
