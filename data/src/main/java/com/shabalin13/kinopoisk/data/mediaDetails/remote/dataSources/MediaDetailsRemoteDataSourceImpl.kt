package com.shabalin13.kinopoisk.data.mediaDetails.remote.dataSources

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsDto
import com.shabalin13.kinopoisk.data.remote.KinopoiskApi
import javax.inject.Inject

internal class MediaDetailsRemoteDataSourceImpl @Inject constructor(
    private val kinopoiskApi: KinopoiskApi,
) : MediaDetailsRemoteDataSource {
    override suspend fun getMediaDetails(mediaId: Int): Result<MediaDetailsDto> {
        return kinopoiskApi.fetchMediaDetails(mediaId)
    }
}
