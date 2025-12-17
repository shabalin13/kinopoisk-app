package com.shabalin13.kinopoisk

import android.app.Application
import com.shabalin13.kinopoisk.common.di.DaggerDispatcherComponent
import com.shabalin13.kinopoisk.data.di.DaggerDataComponent
import com.shabalin13.kinopoisk.di.AppComponent
import com.shabalin13.kinopoisk.di.DaggerAppComponent
import com.shabalin13.kinopoisk.di.FeatureDependencies
import com.shabalin13.kinopoisk.network.di.DaggerNetworkComponent

class KinopoiskApplication : Application() {
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            DaggerDataComponent.factory().create(
                DaggerNetworkComponent.factory().create(
                    DaggerDispatcherComponent.factory().create()
                )
            ),
            applicationContext
        )
    }

    fun getFeatureDependencies(): FeatureDependencies = appComponent
}
