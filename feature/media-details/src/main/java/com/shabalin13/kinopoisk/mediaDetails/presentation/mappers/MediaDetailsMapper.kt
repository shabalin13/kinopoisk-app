package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import javax.inject.Inject

internal class MediaDetailsMapper @Inject constructor(
    private val headerMapper: MediaDetailsHeaderMapper,
    private val seasonsMapper: MediaDetailsSeasonsMapper,
    private val peopleMapper: MediaDetailsPeopleMapper,
    private val notesMapper: MediaDetailsNotesMapper,
    private val mediaItemsMapper: MediaDetailsMediaItemsMapper,
    private val statisticsMapper: MediaDetailsStatisticsMapper,
) {
    fun mapDomainToUiModel(mediaDetails: MediaDetails): MediaDetailsUiModel {
        return MediaDetailsUiModel(
            id = mediaDetails.id,
            headerInfo = headerMapper.mapToHeaderInfo(mediaDetails),
            seasonsInfo = seasonsMapper.mapToSeasonsInfo(mediaDetails.seasonsInfo),
            videosInfo = mediaDetails.videos.map {
                VideoInfoUiModel(
                    posterUrl = it.posterUrl,
                    videoUrl = it.videoUrl,
                    name = it.name
                )
            }.takeIf { it.isNotEmpty() },
            actorsInfo = peopleMapper.mapActorsToActorsInfo(mediaDetails.actors),
            contributorsInfo = peopleMapper.mapContributorsToContributorsInfo(mediaDetails.contributors),
            factsInfo = notesMapper.mapFactsToFactsInfo(mediaDetails.facts),
            bloopersInfo = notesMapper.mapBloopersToBloopersInfo(mediaDetails.bloopers),
            linkedMediaItemsInfo = mediaItemsMapper.mapLinkedMediaItemsToLinkedMediaItemsInfo(
                mediaDetails.linkedMediaItems
            ),
            similarMediaItemsInfo = mediaItemsMapper.mapSimilarMediaItemsToSimilarMediaItemsInfo(
                mediaDetails.similarMediaItems
            ),
            statisticsInfos = statisticsMapper.mapToStatisticsInfos(mediaDetails)
        )
    }
}
