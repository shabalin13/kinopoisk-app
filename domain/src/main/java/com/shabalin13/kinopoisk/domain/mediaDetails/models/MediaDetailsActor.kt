package com.shabalin13.kinopoisk.domain.mediaDetails.models

data class MediaDetailsActor(
    val id: Int,
    val profession: MediaDetailsActorProfession,
    val name: String,
    val photoUrl: String?,
    val characterName: String?,
)
