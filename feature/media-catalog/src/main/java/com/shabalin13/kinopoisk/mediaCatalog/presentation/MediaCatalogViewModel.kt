package com.shabalin13.kinopoisk.mediaCatalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shabalin13.kinopoisk.domain.mediaCatalog.usecases.GetMediaCatalogPagingSourceUseCase
import javax.inject.Inject

internal class MediaCatalogViewModel(
    private val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase,
) : ViewModel() {

    class MediaCatalogViewModelFactory @Inject constructor(
        private val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaCatalogViewModel::class.java)
            return MediaCatalogViewModel(
                getMediaCatalogPagingSourceUseCase
            ) as T
        }
    }
}
