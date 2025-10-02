package com.shabalin13.kinopoisk.mediaDetails.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import com.shabalin13.kinopoisk.mediaDetails.presentation.mappers.MediaDetailsMapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class MediaDetailsViewModel(
    private val mediaId: Int,
    private val getMediaDetailsUseCase: GetMediaDetailsUseCase,
    private val mapper: MediaDetailsMapper,
) : ViewModel() {

    private val _state = MutableStateFlow<MediaDetailsState>(MediaDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _effect = Channel<MediaDetailsEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            _state.value = MediaDetailsState.Loading
            val result = getMediaDetailsUseCase(mediaId)
            _state.value = result.fold(
                onSuccess = {
                    withContext(Dispatchers.Default) {
                        MediaDetailsState.Data(mapper.mapDomainToUiModel(it))
                    }
                },
                onFailure = {
                    MediaDetailsState.Error(it.message ?: "Error")
                }
            )
        }
    }

    @Suppress("CyclomaticComplexMethod")
    fun handleIntent(intent: MediaDetailsIntent) {
        when (intent) {
            MediaDetailsIntent.RateButtonClicked -> onRateButtonClicked()
            MediaDetailsIntent.ToggleWatchlistButtonClicked -> onToggleWatchlistButtonClicked()

            MediaDetailsIntent.ShareButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShareButtonClicked")
            }

            MediaDetailsIntent.ShowFullDescriptionButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowFullDescriptionButtonClicked")
            }

            is MediaDetailsIntent.VideoCardClicked -> {
                Log.d("MediaDetailsIntent", "VideoCardClicked ${intent.videoUrl}")
            }

            MediaDetailsIntent.ShowAllActorsButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllActorsButtonClicked")
            }

            is MediaDetailsIntent.PersonCardClicked -> {
                Log.d("MediaDetailsIntent", "PersonCardClicked #${intent.personId}")
            }

            MediaDetailsIntent.ShowAllContributorsButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllContributorsButtonClicked")
            }

            MediaDetailsIntent.ShowAllFactsButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllFactsButtonClicked")
            }

            is MediaDetailsIntent.FactCardClicked -> {
                Log.d("MediaDetailsIntent", "FactCardClicked ${intent.factText}")
            }

            MediaDetailsIntent.ShowAllBloopersButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllBloopersButtonClicked")
            }

            is MediaDetailsIntent.BlooperCardClicked -> {
                Log.d("MediaDetailsIntent", "BlooperCardClicked ${intent.blooperText}")
            }

            MediaDetailsIntent.ShowAllLinkedMediaItemsButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllLinkedMediaItemsButtonClicked")
            }

            is MediaDetailsIntent.LinkedMediaItemCardClicked -> {
                Log.d("MediaDetailsIntent", "LinkedMediaItemCardClicked ${intent.mediaId}")
                viewModelScope.launch {
                    _effect.send(MediaDetailsEffect.NavigateToMediaDetails(intent.mediaId))
                }
            }

            MediaDetailsIntent.ShowAllSimilarMediaItemsButtonClicked -> {
                Log.d("MediaDetailsIntent", "ShowAllSimilarMediaItemsButtonClicked")
            }

            is MediaDetailsIntent.SimilarMediaItemCardClicked -> {
                Log.d("MediaDetailsIntent", "SimilarMediaItemCardClicked ${intent.mediaId}")
                viewModelScope.launch {
                    _effect.send(MediaDetailsEffect.NavigateToMediaDetails(intent.mediaId))
                }
            }

            MediaDetailsIntent.BackButtonClicked ->
                viewModelScope.launch {
                    _effect.send(MediaDetailsEffect.NavigateBack)
                }
        }
    }

    private fun onRateButtonClicked() {
        _state.update { state ->
            if (state is MediaDetailsState.Data) {
                val current = state.mediaDetails.headerInfo.actionButtonsInfo.isRated
                state.copy(
                    mediaDetails = state.mediaDetails.copy(
                        headerInfo = state.mediaDetails.headerInfo.copy(
                            actionButtonsInfo = state.mediaDetails.headerInfo.actionButtonsInfo.copy(
                                isRated = !current
                            )
                        )
                    )
                )
            } else {
                state
            }
        }
    }

    private fun onToggleWatchlistButtonClicked() {
        _state.update { state ->
            if (state is MediaDetailsState.Data) {
                val current = state.mediaDetails.headerInfo.actionButtonsInfo.isInWatchlist
                state.copy(
                    mediaDetails = state.mediaDetails.copy(
                        headerInfo = state.mediaDetails.headerInfo.copy(
                            actionButtonsInfo = state.mediaDetails.headerInfo.actionButtonsInfo.copy(
                                isInWatchlist = !current
                            )
                        )
                    )
                )
            } else {
                state
            }
        }
    }

    class MediaDetailsViewModelFactory @AssistedInject constructor(
        @Assisted(MEDIA_ID_TAG) private val mediaId: Int,
        private val getMediaDetailsUseCase: GetMediaDetailsUseCase,
        private val mapper: MediaDetailsMapper,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaDetailsViewModel::class.java)
            return MediaDetailsViewModel(mediaId, getMediaDetailsUseCase, mapper) as T
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
