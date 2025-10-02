package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class ContributorsInfoUiModel(
    val contributors: List<PersonInfoUiModel>,
    val isMore: Boolean,
) {
    companion object {
        const val MAX_VISIBLE = 12
    }
}
