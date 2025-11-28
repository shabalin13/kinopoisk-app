package com.shabalin13.kinopoisk.domain.repository

import com.shabalin13.kinopoisk.domain.model.MediaItem

interface MediaItemRepository {
    suspend fun getMediaItem(mediaId: Int): Result<MediaItem> // TODO("Change to FLow<MediaItem>")
    // TODO("suspend fun saveMediaItem(mediaItem: MediaItem)")
}
