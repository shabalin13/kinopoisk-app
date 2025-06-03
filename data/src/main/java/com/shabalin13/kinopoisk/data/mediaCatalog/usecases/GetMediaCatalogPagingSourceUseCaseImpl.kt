package com.shabalin13.kinopoisk.data.mediaCatalog.usecases

import androidx.paging.PagingSource
import com.shabalin13.kinopoisk.domain.mediaCatalog.models.MediaCatalogItem
import com.shabalin13.kinopoisk.domain.mediaCatalog.repositories.MediaCatalogRepository
import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase
import javax.inject.Inject

internal class GetMediaCatalogPagingSourceUseCaseImpl @Inject constructor(
    private val repository: MediaCatalogRepository,
) : GetMediaCatalogPagingSourceUseCase {
    override fun invoke(query: String): PagingSource<Int, MediaCatalogItem> {
        return repository.getMediaCatalogPagingSource(query)
    }
}
