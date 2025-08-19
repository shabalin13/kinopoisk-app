package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActor
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActorProfession
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFact
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.FactsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.NoteInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import javax.inject.Inject

internal class MediaDetailsMapper @Inject constructor(
    private val headerMapper: MediaDetailsHeaderMapper,
    private val contributorsMapper: MediaDetailsContributorsMapper,
) {
    fun mapDomainToUiModel(mediaDetails: MediaDetails): MediaDetailsUiModel {
        return MediaDetailsUiModel(
            id = mediaDetails.id,
            headerInfo = headerMapper.mapToHeaderInfo(mediaDetails),
            videosInfo = mediaDetails.videos.map {
                VideoInfoUiModel(
                    posterUrl = it.posterUrl,
                    videoUrl = it.videoUrl,
                    name = it.name
                )
            }.takeIf { it.isNotEmpty() },
            actorsInfo = mapActorsToActorsInfo(mediaDetails.actors),
            contributorsInfo = contributorsMapper.mapToContributorsInfo(mediaDetails.contributors),
            factsInfo = mapFactsToFactsInfo(mediaDetails.facts)
        )
    }

    private fun mapActorsToActorsInfo(actors: List<MediaDetailsActor>): ActorsInfoUiModel? {
        if (actors.isEmpty()) return null

        val actorsFiltered = actors.filter { it.profession == MediaDetailsActorProfession.ACTOR }

        return ActorsInfoUiModel(
            actors = actorsFiltered.take(ActorsInfoUiModel.MAX_VISIBLE).map { actor ->
                PersonInfoUiModel(
                    id = actor.id,
                    name = actor.name,
                    photoUrl = actor.photoUrl,
                    additionalInfo = actor.characterName
                )
            },
            isMore = actorsFiltered.size > ActorsInfoUiModel.MAX_VISIBLE
        )
    }

    private fun mapFactsToFactsInfo(facts: List<MediaDetailsFact>): FactsInfoUiModel? {
        if (facts.isEmpty()) return null

        return FactsInfoUiModel(
            facts = facts.take(FactsInfoUiModel.MAX_VISIBLE).map { fact ->
                NoteInfoUiModel(
                    text = fact.value,
                    isSpoiler = fact.isSpoiler
                )
            },
            isMore = facts.size > FactsInfoUiModel.MAX_VISIBLE
        )
    }
}
