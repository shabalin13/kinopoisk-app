package com.shabalin13.kinopoisk.data.di

import com.shabalin13.kinopoisk.data.datasource.remote.MediaCatalogRemoteDataSource
import com.shabalin13.kinopoisk.data.datasource.remote.MediaCatalogRemoteDataSourceImpl
import com.shabalin13.kinopoisk.data.datasource.remote.MediaItemRemoteDataSource
import com.shabalin13.kinopoisk.data.datasource.remote.MediaItemRemoteDataSourceImpl
import com.shabalin13.kinopoisk.data.repository.MediaCatalogRepositoryImpl
import com.shabalin13.kinopoisk.data.repository.MediaItemRepositoryImpl
import com.shabalin13.kinopoisk.domain.repository.MediaCatalogRepository
import com.shabalin13.kinopoisk.domain.repository.MediaItemRepository
import dagger.Binds
import dagger.Module

@Module
internal interface DataModule {
    @Binds
    @DataScope
    fun bindMediaCatalogRemoteDataSource(
        mediaCatalogRemoteDataSourceImpl: MediaCatalogRemoteDataSourceImpl,
    ): MediaCatalogRemoteDataSource

    @Binds
    @DataScope
    fun bindMediaCatalogRepository(
        mediaCatalogRepositoryImpl: MediaCatalogRepositoryImpl,
    ): MediaCatalogRepository

    @Binds
    @DataScope
    fun bindMediaItemRemoteDataSource(
        mediaItemRemoteDataSourceImpl: MediaItemRemoteDataSourceImpl,
    ): MediaItemRemoteDataSource

    @Binds
    @DataScope
    fun bindMediaItemRepository(
        mediaItemRepositoryImpl: MediaItemRepositoryImpl,
    ): MediaItemRepository
}
