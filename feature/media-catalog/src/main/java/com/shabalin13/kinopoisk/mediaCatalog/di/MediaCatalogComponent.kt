package com.shabalin13.kinopoisk.mediaCatalog.di

import dagger.Component

@Component(
    dependencies = [MediaCatalogDependencies::class]
)
internal interface MediaCatalogComponent {
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: MediaCatalogDependencies,
        ): MediaCatalogComponent
    }
}
