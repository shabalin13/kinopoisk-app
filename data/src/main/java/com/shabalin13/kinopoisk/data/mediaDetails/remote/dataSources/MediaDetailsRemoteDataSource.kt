package com.shabalin13.kinopoisk.data.mediaDetails.remote.dataSources

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsDto

internal interface MediaDetailsRemoteDataSource {
    suspend fun getMediaDetails(mediaId: Int): Result<MediaDetailsDto>
}
