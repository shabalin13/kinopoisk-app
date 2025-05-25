package com.shabalin13.kinopoisk

import android.app.Application
import com.shabalin13.kinopoisk.data.di.DaggerDataComponent
import com.shabalin13.kinopoisk.di.AppComponent
import com.shabalin13.kinopoisk.di.DaggerAppComponent

class KinopoiskApplication : Application() {
    @Suppress("UnusedPrivateProperty")
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            DaggerDataComponent.factory().create()
        )
    }
}
