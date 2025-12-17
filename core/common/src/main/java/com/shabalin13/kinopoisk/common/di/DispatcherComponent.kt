package com.shabalin13.kinopoisk.common.di

import dagger.Component

@DispatcherScope
@Component(
    modules = [DispatcherModule::class]
)
interface DispatcherComponent : DispatcherDependencies {
    @Component.Factory
    interface Factory {
        fun create(): DispatcherComponent
    }
}
