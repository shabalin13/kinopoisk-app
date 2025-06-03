package com.shabalin13.kinopoisk.domain.mediaCatalog.repositories

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem

interface MediaCatalogRepository {
    fun getMediaCatalogPagingSource(query: String): PagingSource<Int, MediaCatalogItem>
}
