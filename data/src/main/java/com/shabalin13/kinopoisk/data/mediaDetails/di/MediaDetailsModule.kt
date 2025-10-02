package com.shabalin13.kinopoisk.data.mediaDetails.di

import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsMarketingMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsMediaItemsMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsNotesMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsPeopleMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsRatingsMapper
import com.shabalin13.kinopoisk.data.mediaDetails.mappers.MediaDetailsVideosMapper
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dataSources.MediaDetailsRemoteDataSource
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dataSources.MediaDetailsRemoteDataSourceImpl
import com.shabalin13.kinopoisk.data.mediaDetails.repositories.MediaDetailsRepositoryImpl
import com.shabalin13.kinopoisk.data.mediaDetails.usecases.GetMediaDetailsUseCaseImpl
import com.shabalin13.kinopoisk.domain.mediaDetails.repositories.MediaDetailsRepository
import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface MediaDetailsModule {

    @Binds
    fun bindMediaDetailsRemoteDataSource(
        mediaDetailsRemoteDataSourceImpl: MediaDetailsRemoteDataSourceImpl,
    ): MediaDetailsRemoteDataSource

    @Binds
    fun bindMediaDetailsRepository(
        mediaDetailsRepositoryImpl: MediaDetailsRepositoryImpl,
    ): MediaDetailsRepository

    @Binds
    fun bindGetMediaDetailsUseCase(
        getMediaDetailsUseCaseImpl: GetMediaDetailsUseCaseImpl,
    ): GetMediaDetailsUseCase

    companion object {
        @Provides
        fun provideMediaDetailsRatingsMapper(): MediaDetailsRatingsMapper =
            MediaDetailsRatingsMapper()

        @Provides
        fun provideMediaDetailsPeopleMapper(): MediaDetailsPeopleMapper = MediaDetailsPeopleMapper()

        @Provides
        fun provideMediaDetailsMarketingMapper(): MediaDetailsMarketingMapper =
            MediaDetailsMarketingMapper()

        @Provides
        fun provideMediaDetailsMediaItemsMapper(): MediaDetailsMediaItemsMapper =
            MediaDetailsMediaItemsMapper()

        @Provides
        fun provideMediaDetailsNotesMapper(): MediaDetailsNotesMapper = MediaDetailsNotesMapper()

        @Provides
        fun provideMediaDetailsVideosMapper(): MediaDetailsVideosMapper = MediaDetailsVideosMapper()

        @Provides
        fun provideMediaDetailsMapper(
            ratingsMapper: MediaDetailsRatingsMapper,
            peopleMapper: MediaDetailsPeopleMapper,
            marketingMapper: MediaDetailsMarketingMapper,
            mediaItemsMapper: MediaDetailsMediaItemsMapper,
            notesMapper: MediaDetailsNotesMapper,
            videosMapper: MediaDetailsVideosMapper,
        ): MediaDetailsMapper {
            return MediaDetailsMapper(
                ratingsMapper,
                peopleMapper,
                marketingMapper,
                mediaItemsMapper,
                notesMapper,
                videosMapper,
            )
        }
    }
}
