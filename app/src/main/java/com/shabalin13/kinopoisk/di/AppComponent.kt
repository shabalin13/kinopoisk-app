package com.shabalin13.kinopoisk.di

import android.content.Context
import com.shabalin13.kinopoisk.data.di.DataComponent
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [AppModule::class],
    dependencies = [DataComponent::class]
)
internal interface AppComponent : FeatureDependencies {
    @Component.Factory
    interface Factory {
        fun create(
            dataComponent: DataComponent,
            @BindsInstance context: Context,
        ): AppComponent
    }
}
