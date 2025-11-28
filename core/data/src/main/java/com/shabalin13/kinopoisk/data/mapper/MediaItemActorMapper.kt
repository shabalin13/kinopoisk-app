package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemActor
import com.shabalin13.kinopoisk.domain.model.MediaItemActorProfession
import com.shabalin13.kinopoisk.network.dto.MediaItemPersonDto
import javax.inject.Inject

@DataScope
internal class MediaItemActorMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemPersonDto): MediaItemActor? {
        val profession = when (dto.enProfession?.uppercase()) {
            "ACTOR" -> MediaItemActorProfession.ACTOR
            "VOICE_ACTOR" -> MediaItemActorProfession.VOICE_ACTOR
            else -> null
        }

        val name = dto.name
        return if (name.isNullOrBlank() || profession == null) {
            null
        } else {
            MediaItemActor(
                id = dto.id,
                profession = profession,
                name = name,
                photoUrl = dto.photoUrl?.takeIf { it.isNotBlank() },
                characterName = dto.description?.takeIf { it.isNotBlank() }
            )
        }
    }
}
