package com.shabalin13.kinopoisk.data.repository

import com.shabalin13.kinopoisk.common.di.DefaultDispatcher
import com.shabalin13.kinopoisk.data.datasource.remote.MediaItemRemoteDataSource
import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.data.mapper.MediaItemMapper
import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.domain.repository.MediaItemRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@DataScope
internal class MediaItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: MediaItemRemoteDataSource,
    private val mapper: MediaItemMapper,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) : MediaItemRepository {
    override suspend fun getMediaItem(mediaId: Int): Result<MediaItem> =
        withContext(defaultDispatcher) {
            val result = remoteDataSource.getMediaItem(mediaId)
            result.map {
                mapper.mapDtoToDomain(it)
            }
        }
}
