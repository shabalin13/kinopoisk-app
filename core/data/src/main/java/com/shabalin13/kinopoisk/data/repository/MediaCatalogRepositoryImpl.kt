package com.shabalin13.kinopoisk.data.repository

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.data.datasource.remote.MediaCatalogPagingSource
import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.domain.repository.MediaCatalogRepository
import javax.inject.Inject

// TODO("Add Dispatcher into constructor")
@DataScope
internal class MediaCatalogRepositoryImpl @Inject constructor(
    private val mediaCatalogPagingSourceFactory: MediaCatalogPagingSource.Factory,
) : MediaCatalogRepository {
    override fun getMediaCatalogPagingSource(query: String): PagingSource<Int, MediaCatalogItem> {
        return mediaCatalogPagingSourceFactory.create(query)
    }
}
