package com.shabalin13.kinopoisk.network.api

import androidx.annotation.IntRange
import com.shabalin13.kinopoisk.network.dto.MediaCatalogDto
import com.shabalin13.kinopoisk.network.dto.MediaItemDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [API documentation](https://api.kinopoisk.dev/documentation)
 */
interface KinopoiskApi {
    @GET("movie/search")
    suspend fun searchMedia(
        @Query(value = "query") query: String,
        @Query(value = "page") @IntRange(from = 1) page: Int,
        @Query(value = "limit") @IntRange(from = 1) limit: Int,
    ): Result<MediaCatalogDto>

    @GET("movie/{mediaId}")
    suspend fun getMediaItem(
        @Path(value = "mediaId") mediaId: Int,
    ): Result<MediaItemDto>
}
