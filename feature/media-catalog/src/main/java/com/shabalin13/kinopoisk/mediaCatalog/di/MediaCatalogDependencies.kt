package com.shabalin13.kinopoisk.mediaCatalog.di

import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase

interface MediaCatalogDependencies {
    val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase
}
