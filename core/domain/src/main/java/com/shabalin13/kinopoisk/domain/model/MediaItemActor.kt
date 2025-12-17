package com.shabalin13.kinopoisk.domain.model

data class MediaItemActor(
    val id: Int,
    val profession: MediaItemActorProfession,
    val name: String,
    val photoUrl: String?,
    val characterName: String?,
)
