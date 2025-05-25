package com.shabalin13.kinopoisk.data.mediaCatalog.di

import com.shabalin13.kinopoisk.data.mediaCatalog.mapper.MediaCatalogMapper
import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources.MediaCatalogRemoteDataSource
import com.shabalin13.kinopoisk.data.mediaCatalog.remote.dataSources.MediaCatalogRemoteDataSourceImpl
import com.shabalin13.kinopoisk.data.mediaCatalog.repositories.MediaCatalogRepositoryImpl
import com.shabalin13.kinopoisk.data.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCaseImpl
import com.shabalin13.kinopoisk.domain.mediaCatalog.repositories.MediaCatalogRepository
import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface MediaCatalogModule {

    @Binds
    fun bindMediaCatalogRemoteDataSource(
        mediaCatalogRemoteDataSourceImpl: MediaCatalogRemoteDataSourceImpl,
    ): MediaCatalogRemoteDataSource

    @Binds
    fun bindMediaCatalogRepository(
        mediaCatalogRepositoryImpl: MediaCatalogRepositoryImpl,
    ): MediaCatalogRepository

    @Binds
    fun bindGetMediaCatalogPagingSourceUseCase(
        getMediaCatalogPagingSourceUseCaseImpl: GetMediaCatalogPagingSourceUseCaseImpl,
    ): GetMediaCatalogPagingSourceUseCase

    companion object {
        @Provides
        fun provideMediaCatalogMapper(): MediaCatalogMapper {
            return MediaCatalogMapper()
        }
    }
}
