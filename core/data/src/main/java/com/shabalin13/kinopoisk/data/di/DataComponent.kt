package com.shabalin13.kinopoisk.data.di

import com.shabalin13.kinopoisk.domain.repository.MediaCatalogRepository
import com.shabalin13.kinopoisk.domain.repository.MediaItemRepository
import com.shabalin13.kinopoisk.network.di.NetworkComponent
import dagger.Component

@DataScope
@Component(
    modules = [DataModule::class],
    dependencies = [NetworkComponent::class]
)
interface DataComponent {
    val mediaCatalogRepository: MediaCatalogRepository
    val mediaItemRepository: MediaItemRepository

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
        ): DataComponent
    }
}
