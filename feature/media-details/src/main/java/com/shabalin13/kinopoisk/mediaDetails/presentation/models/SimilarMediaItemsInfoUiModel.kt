package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class SimilarMediaItemsInfoUiModel(
    val similarMediaItems: List<MediaItemInfoUiModel>,
    val isMore: Boolean,
) {
    companion object {
        const val MAX_VISIBLE = 5
    }
}
