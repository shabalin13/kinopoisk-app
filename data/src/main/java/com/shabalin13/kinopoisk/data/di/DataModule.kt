package com.shabalin13.kinopoisk.data.di

import com.shabalin13.kinopoisk.data.BuildConfig
import com.shabalin13.kinopoisk.data.mediaCatalog.di.MediaCatalogModule
import com.shabalin13.kinopoisk.data.mediaDetails.di.MediaDetailsModule
import com.shabalin13.kinopoisk.data.remote.KinopoiskApi
import com.shabalin13.kinopoisk.data.remote.interceptors.ApiKeyInterceptor
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module(
    includes = [MediaCatalogModule::class, MediaDetailsModule::class]
)
internal class DataModule {

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    @Provides
    @ApiKey
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    fun provideJsonConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }
        return json.asConverterFactory(contentType)
    }

    @Provides
    fun provideResultCallAdapterFactory(): ResultCallAdapterFactory {
        return ResultCallAdapterFactory.create()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        @BaseUrl baseUrl: String,
        converterFactory: Converter.Factory,
        resultCallAdapterFactory: ResultCallAdapterFactory,
        client: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(resultCallAdapterFactory)
            .build()
    }

    @Provides
    fun provideKinopoiskApi(retrofit: Retrofit): KinopoiskApi {
        return retrofit.create(KinopoiskApi::class.java)
    }
}
