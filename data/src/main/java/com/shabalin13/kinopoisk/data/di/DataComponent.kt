package com.shabalin13.kinopoisk.data.di

import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase
import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import dagger.Component

@Component(
    modules = [DataModule::class]
)
interface DataComponent {
    val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase
    val getMediaDetailsUseCase: GetMediaDetailsUseCase

    @Component.Factory
    interface Factory {
        fun create(): DataComponent
    }
}
