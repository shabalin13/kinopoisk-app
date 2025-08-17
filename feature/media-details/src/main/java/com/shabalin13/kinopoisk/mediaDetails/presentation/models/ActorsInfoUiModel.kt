package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class ActorsInfoUiModel(
    val actors: List<PersonInfoUiModel>,
    val isMore: Boolean,
) {
    companion object {
        const val MAX_VISIBLE = 12
    }
}
