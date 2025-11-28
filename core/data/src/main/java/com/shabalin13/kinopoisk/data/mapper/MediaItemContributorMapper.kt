package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemContributor
import com.shabalin13.kinopoisk.domain.model.MediaItemContributorProfession
import com.shabalin13.kinopoisk.network.dto.MediaItemPersonDto
import javax.inject.Inject

@DataScope
internal class MediaItemContributorMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemPersonDto): MediaItemContributor? {
        val profession = when (dto.enProfession?.uppercase()) {
            "DIRECTOR" -> MediaItemContributorProfession.DIRECTOR
            "PRODUCER" -> MediaItemContributorProfession.PRODUCER
            "WRITER" -> MediaItemContributorProfession.WRITER
            "OPERATOR" -> MediaItemContributorProfession.OPERATOR
            "COMPOSER" -> MediaItemContributorProfession.COMPOSER
            "DESIGNER" -> MediaItemContributorProfession.DESIGNER
            "EDITOR" -> MediaItemContributorProfession.EDITOR
            else -> null
        }
        val name = dto.name
        return if (name.isNullOrBlank() || profession == null) {
            null
        } else {
            MediaItemContributor(
                id = dto.id,
                profession = profession,
                name = name,
                enName = dto.enName?.takeIf { it.isNotBlank() },
                photoUrl = dto.photoUrl?.takeIf { it.isNotBlank() }
            )
        }
    }
}
