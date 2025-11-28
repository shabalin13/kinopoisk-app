package com.shabalin13.kinopoisk.network.interceptor

import com.shabalin13.kinopoisk.network.di.ApiKey
import com.shabalin13.kinopoisk.network.di.NetworkScope
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

@NetworkScope
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
