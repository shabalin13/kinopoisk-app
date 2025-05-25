package com.shabalin13.kinopoisk.data.mediaCatalog.repositories

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources.MediaCatalogPagingSource
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem
import com.shabalin13.kinopoisk.domain.mediaCatalog.repositories.MediaCatalogRepository
import javax.inject.Inject

internal class MediaCatalogRepositoryImpl @Inject constructor(
    private val mediaCatalogPagingSourceFactory: MediaCatalogPagingSource.Factory,
) : MediaCatalogRepository {
    override fun getMediaCatalogPagingSource(query: String): PagingSource<Int, MediaCatalogItem> {
        return mediaCatalogPagingSourceFactory.create(query)
    }
}
