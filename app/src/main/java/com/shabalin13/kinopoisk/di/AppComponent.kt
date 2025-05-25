package com.shabalin13.kinopoisk.di

import com.shabalin13.kinopoisk.data.di.DataComponent
import dagger.Component

@Component(
    modules = [AppModule::class],
    dependencies = [DataComponent::class]
)
internal interface AppComponent : FeatureDependencies {

    @Component.Factory
    interface Factory {
        fun create(
            dataComponent: DataComponent,
        ): AppComponent
    }
}
