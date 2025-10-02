package com.shabalin13.kinopoisk.data.mediaDetails.repositories

import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsMapper
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dataSources.MediaDetailsRemoteDataSource
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.repositories.MediaDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class MediaDetailsRepositoryImpl @Inject constructor(
    private val dataSource: MediaDetailsRemoteDataSource,
    private val mapper: MediaDetailsMapper,
) : MediaDetailsRepository {
    override suspend fun getMediaDetails(mediaId: Int): Result<MediaDetails> {
        val result = dataSource.getMediaDetails(mediaId)
        return withContext(Dispatchers.Default) {
            result.map {
                mapper.mapDtoToDomain(it)
            }
        }
    }
}
