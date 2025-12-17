package com.shabalin13.kinopoisk.network.di

import com.shabalin13.kinopoisk.network.BuildConfig
import com.shabalin13.kinopoisk.network.api.KinopoiskApi
import com.shabalin13.kinopoisk.network.interceptor.ApiKeyInterceptor
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

@Module
internal class NetworkModule {
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
    @NetworkScope
    fun provideJsonConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }
        return json.asConverterFactory(contentType)
    }

    @Provides
    @NetworkScope
    fun provideResultCallAdapterFactory(): ResultCallAdapterFactory {
        return ResultCallAdapterFactory.create()
    }

    @Provides
    @NetworkScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @NetworkScope
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
    @NetworkScope
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
    @NetworkScope
    fun provideKinopoiskApi(retrofit: Retrofit): KinopoiskApi {
        return retrofit.create(KinopoiskApi::class.java)
    }
}
