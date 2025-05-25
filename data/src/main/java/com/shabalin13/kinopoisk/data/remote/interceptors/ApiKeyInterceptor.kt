package com.shabalin13.kinopoisk.data.remote.interceptors

import com.shabalin13.kinopoisk.data.di.ApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class ApiKeyInterceptor @Inject constructor(
    @ApiKey private val apiKey: String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("X-API-KEY", apiKey)
                .build()
        )
    }
}
