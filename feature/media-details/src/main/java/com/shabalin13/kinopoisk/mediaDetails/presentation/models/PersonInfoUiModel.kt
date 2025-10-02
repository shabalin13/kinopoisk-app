package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class PersonInfoUiModel(
    val id: Int,
    val name: String,
    val photoUrl: String? = null,
    val additionalInfo: String? = null,
)
