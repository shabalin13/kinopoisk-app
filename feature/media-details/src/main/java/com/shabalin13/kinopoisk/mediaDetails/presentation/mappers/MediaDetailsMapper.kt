package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActor
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActorProfession
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsBlooper
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFact
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsLinkedMediaItem
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.BloopersInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.FactsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.LinkedMediaItemsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaItemInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.NoteInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
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
            factsInfo = mapFactsToFactsInfo(mediaDetails.facts),
            bloopersInfo = mapBloopersToBloopersInfo(mediaDetails.bloopers),
            linkedMediaItemsInfo = mapLinkedMediaItemsToLinkedMediaItemsInfo(mediaDetails.linkedMediaItems)
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

    private fun mapBloopersToBloopersInfo(bloopers: List<MediaDetailsBlooper>): BloopersInfoUiModel? {
        if (bloopers.isEmpty()) return null

        return BloopersInfoUiModel(
            bloopers = bloopers.take(BloopersInfoUiModel.MAX_VISIBLE).map { blooper ->
                NoteInfoUiModel(
                    text = blooper.value,
                    isSpoiler = blooper.isSpoiler
                )
            },
            isMore = bloopers.size > BloopersInfoUiModel.MAX_VISIBLE
        )
    }

    private fun mapLinkedMediaItemsToLinkedMediaItemsInfo(
        linkedMediaItems: List<MediaDetailsLinkedMediaItem>,
    ): LinkedMediaItemsInfoUiModel? {
        if (linkedMediaItems.isEmpty()) return null

        return LinkedMediaItemsInfoUiModel(
            linkedMediaItems = linkedMediaItems.take(LinkedMediaItemsInfoUiModel.MAX_VISIBLE)
                .map { linkedMediaItem ->
                    MediaItemInfoUiModel(
                        id = linkedMediaItem.id,
                        name = linkedMediaItem.name,
                        posterPreviewUrl = linkedMediaItem.posterPreviewUrl,
                        year = linkedMediaItem.year,
                        rating = linkedMediaItem.rating?.run(RatingUiModel::from)
                    )
                },
            isMore = linkedMediaItems.size > LinkedMediaItemsInfoUiModel.MAX_VISIBLE
        )
    }
}
