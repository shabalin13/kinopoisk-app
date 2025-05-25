package com.shabalin13.kinopoisk.mediaCatalog.di

import com.shabalin13.kinopoisk.mediaCatalog.presentation.MediaCatalogViewModel
import dagger.Component

@Component(
    dependencies = [MediaCatalogDependencies::class]
)
internal interface MediaCatalogComponent {
    fun mediaCatalogViewModelFactory(): MediaCatalogViewModel.MediaCatalogViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: MediaCatalogDependencies,
        ): MediaCatalogComponent
    }
}
