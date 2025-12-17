package com.shabalin13.kinopoisk.domain.usecase

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.domain.repository.MediaCatalogRepository
import javax.inject.Inject

class GetMediaCatalogPagingSourceUseCase @Inject constructor(
    private val repository: MediaCatalogRepository,
) {
    operator fun invoke(query: String): PagingSource<Int, MediaCatalogItem> {
        return repository.getMediaCatalogPagingSource(query)
    }
}
