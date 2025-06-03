package com.shabalin13.kinopoisk.mediaCatalog.di

import com.shabalin13.kinopoisk.mediaCatalog.presentation.mappers.MediaCatalogMapper
import dagger.Module
import dagger.Provides

@Module
internal class MediaCatalogModule {

    @Provides
    fun provideMediaCatalogMapper(): MediaCatalogMapper {
        return MediaCatalogMapper()
    }
}
