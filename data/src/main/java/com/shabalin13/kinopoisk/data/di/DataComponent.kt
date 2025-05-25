package com.shabalin13.kinopoisk.data.di

import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase
import dagger.Component

@Component(
    modules = [DataModule::class]
)
interface DataComponent {
    val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase

    @Component.Factory
    interface Factory {
        fun create(): DataComponent
    }
}
