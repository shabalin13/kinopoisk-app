package com.shabalin13.kinopoisk.domain.repository

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem

interface MediaCatalogRepository {
    fun getMediaCatalogPagingSource(query: String): PagingSource<Int, MediaCatalogItem>
}
