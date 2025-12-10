package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemActor
import com.shabalin13.kinopoisk.domain.model.MediaItemActorProfession
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.PersonUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemActorMapper @Inject constructor() {
    fun mapDomainToUiModel(actor: MediaItemActor): PersonUiModel {
        return PersonUiModel(
            id = actor.id,
            name = actor.name,
            photoUrl = actor.photoUrl,
            additionalInfo = actor.characterName
        )
    }
}
