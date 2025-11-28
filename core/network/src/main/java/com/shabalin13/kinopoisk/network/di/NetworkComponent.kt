package com.shabalin13.kinopoisk.network.di

import com.shabalin13.kinopoisk.network.api.KinopoiskApi
import dagger.Component

@NetworkScope
@Component(
    modules = [NetworkModule::class],
//    dependencies = [DispatcherComponent::class]
)
interface NetworkComponent {
    val kinopoiskApi: KinopoiskApi
//    val dispatcher: CoroutineDispatcher

    @Component.Factory
    interface Factory {
        fun create(
//            dispatcherComponent: DispatcherComponent,
        ): NetworkComponent
    }
}
