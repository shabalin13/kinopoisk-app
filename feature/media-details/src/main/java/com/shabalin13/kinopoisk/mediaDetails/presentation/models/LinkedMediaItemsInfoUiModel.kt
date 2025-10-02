package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class LinkedMediaItemsInfoUiModel(
    val linkedMediaItems: List<MediaItemInfoUiModel>,
    val isMore: Boolean,
) {
    companion object {
        const val MAX_VISIBLE = 5
    }
}
