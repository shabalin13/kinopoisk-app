package com.shabalin13.kinopoisk.data.remote

import androidx.annotation.IntRange
import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dtos.MediaCatalogDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [API documentation](https://api.kinopoisk.dev/documentation)
 */
internal interface KinopoiskApi {
    @GET("movie/search")
    suspend fun searchMediaCatalog(
        @Query(value = "query") query: String,
        @Query(value = "page") @IntRange(from = 1) page: Int,
        @Query(value = "limit") @IntRange(from = 1) limit: Int,
    ): Result<MediaCatalogDto>

    @GET("movie/{mediaId}")
    suspend fun fetchMediaDetails(
        @Path(value = "mediaId") mediaId: Int,
    ): Result<MediaDetailsDto>
}
