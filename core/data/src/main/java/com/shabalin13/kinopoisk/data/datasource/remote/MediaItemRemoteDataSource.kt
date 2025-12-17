package com.shabalin13.kinopoisk.data.datasource.remote

import com.shabalin13.kinopoisk.network.dto.MediaItemDto

internal interface MediaItemRemoteDataSource {
    suspend fun getMediaItem(mediaId: Int): Result<MediaItemDto>
}
