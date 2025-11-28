package com.shabalin13.kinopoisk.data.datasource.remote

import com.shabalin13.kinopoisk.network.dto.MediaCatalogDto

internal interface MediaCatalogRemoteDataSource {
    suspend fun getMediaCatalog(
        query: String,
        page: Int,
        pageSize: Int,
    ): Result<MediaCatalogDto>
}
