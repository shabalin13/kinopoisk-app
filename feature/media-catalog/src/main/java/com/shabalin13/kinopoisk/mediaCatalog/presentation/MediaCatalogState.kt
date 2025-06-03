package com.shabalin13.kinopoisk.mediaCatalog.presentation

import androidx.paging.PagingData
import com.shabalin13.kinopoisk.mediaCatalog.presentation.models.MediaCatalogItemUiModel
import kotlinx.coroutines.flow.Flow

internal sealed class MediaCatalogState {
    data object Initial : MediaCatalogState()
    data class Data(val mediaCatalogItemsFlow: Flow<PagingData<MediaCatalogItemUiModel>>) :
        MediaCatalogState()
}
