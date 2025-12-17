package com.shabalin13.kinopoisk.di

import com.shabalin13.kinopoisk.ui.formatter.DurationFormatter
import com.shabalin13.kinopoisk.ui.formatter.DurationFormatterImpl
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import com.shabalin13.kinopoisk.ui.resource.ResourceProviderImpl
import dagger.Binds
import dagger.Module

@Module
internal interface AppModule {
    @Binds
    @AppScope
    fun bindResourceProvider(resourceProviderImpl: ResourceProviderImpl): ResourceProvider

    @Binds
    @AppScope
    fun bindDurationFormatter(durationFormatterImpl: DurationFormatterImpl): DurationFormatter
}
