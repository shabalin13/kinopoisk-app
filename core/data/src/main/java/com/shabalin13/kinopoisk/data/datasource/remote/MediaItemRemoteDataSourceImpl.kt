package com.shabalin13.kinopoisk.data.datasource.remote

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.network.api.KinopoiskApi
import com.shabalin13.kinopoisk.network.dto.MediaItemDto
import javax.inject.Inject

@DataScope
internal class MediaItemRemoteDataSourceImpl @Inject constructor(
    private val kinopoiskApi: KinopoiskApi,
) : MediaItemRemoteDataSource {
    override suspend fun getMediaItem(mediaId: Int): Result<MediaItemDto> {
        return kinopoiskApi.getMediaItem(mediaId)
    }
}
