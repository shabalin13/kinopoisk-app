package com.shabalin13.kinopoisk.di

import com.shabalin13.kinopoisk.ui.formatters.DurationFormatter
import com.shabalin13.kinopoisk.ui.formatters.DurationFormatterImpl
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import com.shabalin13.kinopoisk.ui.resources.ResourceProviderImpl
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
