package com.shabalin13.kinopoisk.data.datasource.remote

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.network.api.KinopoiskApi
import com.shabalin13.kinopoisk.network.dto.MediaCatalogDto
import javax.inject.Inject

@DataScope
internal class MediaCatalogRemoteDataSourceImpl @Inject constructor(
    private val kinopoiskApi: KinopoiskApi,
) : MediaCatalogRemoteDataSource {
    override suspend fun getMediaCatalog(
        query: String,
        page: Int,
        pageSize: Int,
    ): Result<MediaCatalogDto> {
        return kinopoiskApi.searchMedia(query, page, pageSize)
    }
}
