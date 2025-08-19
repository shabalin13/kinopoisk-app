package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class BloopersInfoUiModel(
    val bloopers: List<NoteInfoUiModel>,
    val isMore: Boolean,
) {
    companion object {
        const val MAX_VISIBLE = 5
    }
}
