package com.shabalin13.kinopoisk.mediaDetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class MediaDetailsViewModel(
    private val mediaId: Int,
    private val getMediaDetailsUseCase: GetMediaDetailsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<MediaDetailsState?>(null)
    val state = _state.asStateFlow()

    @Suppress("UnusedParameter")
    fun handleIntent(intent: MediaDetailsIntent) {
        TODO()
    }

    class MediaDetailsViewModelFactory @AssistedInject constructor(
        @Assisted(MEDIA_ID_TAG) private val mediaId: Int,
        private val getMediaDetailsUseCase: GetMediaDetailsUseCase,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaDetailsViewModel::class.java)
            return MediaDetailsViewModel(mediaId, getMediaDetailsUseCase) as T
        }

        @AssistedFactory
        interface Factory {
            fun create(
                @Assisted(MEDIA_ID_TAG) mediaId: Int,
            ): MediaDetailsViewModelFactory
        }

        companion object {
            const val MEDIA_ID_TAG = "MEDIA_ID_TAG"
        }
    }
}
