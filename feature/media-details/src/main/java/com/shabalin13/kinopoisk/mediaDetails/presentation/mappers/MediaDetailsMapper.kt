package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsActor
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import javax.inject.Inject

internal class MediaDetailsMapper @Inject constructor(
    private val headerMapper: MediaDetailsHeaderMapper,
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
            actorsInfo = mapActorsToActorsInfo(mediaDetails.actors)
        )
    }

    private fun mapActorsToActorsInfo(actors: List<MediaDetailsActor>): ActorsInfoUiModel? {
        if (actors.isEmpty()) return null

        return ActorsInfoUiModel(
            actors = actors.take(ActorsInfoUiModel.MAX_VISIBLE).map { actor ->
                PersonInfoUiModel(
                    id = actor.id,
                    name = actor.name,
                    photoUrl = actor.photoUrl,
                    additionalInfo = actor.characterName
                )
            },
            isMore = actors.size > ActorsInfoUiModel.MAX_VISIBLE
        )
    }
}
