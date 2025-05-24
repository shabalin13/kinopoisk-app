package com.shabalin13.kinopoisk.domain.mediaCatalog.usecases

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem

interface GetMediaCatalogPagingSourceUseCase {
    operator fun invoke(query: String): PagingSource<Int, MediaCatalogItem>
}
