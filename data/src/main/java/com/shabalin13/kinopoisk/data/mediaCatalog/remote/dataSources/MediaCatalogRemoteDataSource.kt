package com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources

import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogDto

internal interface MediaCatalogRemoteDataSource {
    suspend fun getMediaCatalog(
        query: String,
        page: Int,
        pageSize: Int,
    ): Result<MediaCatalogDto>
}
