package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources

import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogDto
import com.shabalin13.kinopoisk.data.remote.KinopoiskApi
import javax.inject.Inject

internal class MediaCatalogRemoteDataSourceImpl @Inject constructor(
    private val kinopoiskApi: KinopoiskApi,
) : MediaCatalogRemoteDataSource {
    override suspend fun getMediaCatalog(
        query: String,
        page: Int,
        pageSize: Int,
    ): Result<MediaCatalogDto> {
        return kinopoiskApi.searchMediaCatalog(query, page, pageSize)
    }
}
