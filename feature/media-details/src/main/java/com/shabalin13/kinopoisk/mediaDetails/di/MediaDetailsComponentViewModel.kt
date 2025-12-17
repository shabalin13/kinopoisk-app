package com.shabalin13.kinopoisk.mediaDetails.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

internal class MediaDetailsComponentViewModel(
    private val dependencies: MediaDetailsDependencies,
) : ViewModel() {

    val component = DaggerMediaDetailsComponent.factory().create(dependencies)

    class Factory(
        private val dependencies: MediaDetailsDependencies,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaDetailsComponentViewModel::class.java)
            return MediaDetailsComponentViewModel(dependencies) as T
        }
    }
}
