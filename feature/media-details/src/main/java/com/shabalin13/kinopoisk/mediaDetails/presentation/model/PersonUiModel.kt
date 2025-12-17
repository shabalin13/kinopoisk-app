package com.shabalin13.kinopoisk.mediaDetails.presentation.model

internal data class PersonUiModel(
    val id: Int,
    val name: String,
    val photoUrl: String? = null,
    val additionalInfo: String? = null,
)
