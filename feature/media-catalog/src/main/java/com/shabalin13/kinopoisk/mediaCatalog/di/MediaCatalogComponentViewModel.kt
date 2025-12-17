package com.shabalin13.kinopoisk.mediaCatalog.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

internal class MediaCatalogComponentViewModel(
    private val dependencies: MediaCatalogDependencies,
) : ViewModel() {

    val component = DaggerMediaCatalogComponent.factory().create(dependencies)

    class Factory(
        private val dependencies: MediaCatalogDependencies,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaCatalogComponentViewModel::class.java)
            return MediaCatalogComponentViewModel(dependencies) as T
        }
    }
}
