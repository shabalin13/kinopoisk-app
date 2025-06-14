package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsPersonDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActor
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActorProfession
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsContributor
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsContributorProfession

internal class MediaDetailsPeopleMapper {
    private fun mapPersonDtoToActor(personDto: MediaDetailsPersonDto): MediaDetailsActor? {
        val profession = when (personDto.enProfession?.uppercase()) {
            "ACTOR" -> MediaDetailsActorProfession.ACTOR
            "VOICE_ACTOR" -> MediaDetailsActorProfession.VOICE_ACTOR
            else -> null
        }

        return if (personDto.name.isNullOrBlank() || profession == null) {
            null
        } else {
            MediaDetailsActor(
                id = personDto.id,
                profession = profession,
                name = personDto.name,
                photoUrl = personDto.photoUrl?.takeIf { it.isNotBlank() },
                characterName = personDto.description?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun mapPeopleDtoToActors(peopleDto: List<MediaDetailsPersonDto>?): List<MediaDetailsActor> {
        return peopleDto?.mapNotNull(::mapPersonDtoToActor) ?: emptyList()
    }

    private fun mapPersonDtoToContributor(personDto: MediaDetailsPersonDto): MediaDetailsContributor? {
        val profession = when (personDto.enProfession?.uppercase()) {
            "DIRECTOR" -> MediaDetailsContributorProfession.DIRECTOR
            "PRODUCER" -> MediaDetailsContributorProfession.PRODUCER
            "WRITER" -> MediaDetailsContributorProfession.WRITER
            "OPERATOR" -> MediaDetailsContributorProfession.OPERATOR
            "COMPOSER" -> MediaDetailsContributorProfession.COMPOSER
            "DESIGNER" -> MediaDetailsContributorProfession.DESIGNER
            "EDITOR" -> MediaDetailsContributorProfession.EDITOR
            else -> null
        }
        return if (personDto.name.isNullOrBlank() || profession == null) {
            null
        } else {
            MediaDetailsContributor(
                id = personDto.id,
                profession = profession,
                name = personDto.name,
                enName = personDto.enName?.takeIf { it.isNotBlank() },
                photoUrl = personDto.photoUrl?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun mapPeopleDtoToContributors(peopleDto: List<MediaDetailsPersonDto>?): List<MediaDetailsContributor> {
        return peopleDto?.mapNotNull(::mapPersonDtoToContributor) ?: emptyList()
    }
}
