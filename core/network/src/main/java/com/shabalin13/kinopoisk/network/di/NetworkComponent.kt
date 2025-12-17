package com.shabalin13.kinopoisk.network.di

import com.shabalin13.kinopoisk.common.di.DispatcherDependencies
import com.shabalin13.kinopoisk.network.api.KinopoiskApi
import dagger.Component

@NetworkScope
@Component(
    modules = [NetworkModule::class],
    dependencies = [DispatcherDependencies::class]
)
interface NetworkComponent : DispatcherDependencies {
    val kinopoiskApi: KinopoiskApi

    @Component.Factory
    interface Factory {
        fun create(
            dispatcherDependencies: DispatcherDependencies,
        ): NetworkComponent
    }
}
