package com.shabalin13.kinopoisk.mediaCatalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.shabalin13.kinopoisk.domain.model.MediaCatalogItem
import com.shabalin13.kinopoisk.domain.usecase.GetMediaCatalogPagingSourceUseCase
import com.shabalin13.kinopoisk.mediaCatalog.presentation.mapper.MediaCatalogItemMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MediaCatalogViewModel(
    private val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase,
    private val mapper: MediaCatalogItemMapper,
) : ViewModel() {

    private val _state = MutableStateFlow<MediaCatalogState>(MediaCatalogState.Initial)
    val state = _state.asStateFlow()

    private val _effect = Channel<MediaCatalogEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    private val _query = MutableStateFlow("")

    init {
        observeQuery()
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    private fun observeQuery() {
        _query
            .debounce(QUERY_DELAY)
            .distinctUntilChanged()
            .mapLatest { query ->
                if (query.isBlank()) {
                    MediaCatalogState.Initial
                } else {
                    val flow =
                        createPager(query).flow
                            .map { pagingData ->
                                pagingData.map { mapper.mapDomainToUiModel(it) }
                            }
                            .cachedIn(viewModelScope)
                    MediaCatalogState.Data(flow)
                }
            }
            .onEach { newState -> _state.update { newState } }
            .launchIn(viewModelScope)
    }

    fun handleIntent(intent: MediaCatalogIntent) {
        when (intent) {
            is MediaCatalogIntent.SearchQueryChanged ->
                _query.update {
                    intent.query
                }

            is MediaCatalogIntent.MediaCatalogItemCardClicked -> {
                viewModelScope.launch {
                    _effect.send(MediaCatalogEffect.NavigateToMediaDetails(intent.mediaId))
                }
            }
        }
    }

    private fun createPager(query: String): Pager<Int, MediaCatalogItem> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE
            )
        ) {
            getMediaCatalogPagingSourceUseCase(query)
        }
    }

    class MediaCatalogViewModelFactory @Inject constructor(
        private val getMediaCatalogPagingSourceUseCase: GetMediaCatalogPagingSourceUseCase,
        private val mapper: MediaCatalogItemMapper,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == MediaCatalogViewModel::class.java)
            return MediaCatalogViewModel(
                getMediaCatalogPagingSourceUseCase,
                mapper
            ) as T
        }
    }

    private companion object {
        const val QUERY_DELAY = 1000L
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 5
    }
}
