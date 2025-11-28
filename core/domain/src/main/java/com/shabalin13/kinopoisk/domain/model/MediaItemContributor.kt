package com.shabalin13.kinopoisk.domain.model

data class MediaItemContributor(
    val id: Int,
    val profession: MediaItemContributorProfession,
    val name: String,
    val photoUrl: String?,
    val enName: String?,
)
