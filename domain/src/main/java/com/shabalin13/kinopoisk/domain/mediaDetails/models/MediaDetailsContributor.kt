package com.shabalin13.kinopoisk.domain.mediaDetails.models

data class MediaDetailsContributor(
    val id: Int,
    val profession: MediaDetailsContributorProfession,
    val name: String,
    val photoUrl: String?,
    val enName: String?,
)
