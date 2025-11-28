package com.shabalin13.kinopoisk.mediaCatalog.di

import com.shabalin13.kinopoisk.domain.usecase.GetMediaCatalogPagingSourceUseCase

interface MediaCatalogDependencies {
    val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase
}
