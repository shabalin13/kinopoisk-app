package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MediaDetailsUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.VideoInfoUiModel
import javax.inject.Inject

@MediaDetailsScope
internal class MediaDetailsMapper @Inject constructor(
    private val headerMapper: MediaDetailsHeaderMapper,
    private val seasonsMapper: MediaDetailsSeasonsMapper,
    private val peopleMapper: MediaDetailsPeopleMapper,
    private val notesMapper: MediaDetailsNotesMapper,
    private val mediaItemsMapper: MediaDetailsMediaItemsMapper,
    private val statisticsMapper: MediaDetailsStatisticsMapper,
) {
    fun mapDomainToUiModel(mediaItem: MediaItem): MediaDetailsUiModel {
        return MediaDetailsUiModel(
            id = mediaItem.id,
            headerInfo = headerMapper.mapToHeaderInfo(mediaItem),
            seasonsInfo = seasonsMapper.mapToSeasonsInfo(mediaItem.seasonsInfo),
            videosInfo = mediaItem.videos.map {
                VideoInfoUiModel(
                    posterUrl = it.posterUrl,
                    videoUrl = it.videoUrl,
                    name = it.name
                )
            }.takeIf { it.isNotEmpty() },
            actorsInfo = peopleMapper.mapActorsToActorsInfo(mediaItem.actors),
            contributorsInfo = peopleMapper.mapContributorsToContributorsInfo(mediaItem.contributors),
            factsInfo = notesMapper.mapFactsToFactsInfo(mediaItem.facts),
            bloopersInfo = notesMapper.mapBloopersToBloopersInfo(mediaItem.bloopers),
            linkedMediaItemsInfo = mediaItemsMapper.mapLinkedMediaItemsToLinkedMediaItemsInfo(
                mediaItem.linkedMediaItems
            ),
            similarMediaItemsInfo = mediaItemsMapper.mapSimilarMediaItemsToSimilarMediaItemsInfo(
                mediaItem.similarMediaItems
            ),
            statisticsInfos = statisticsMapper.mapToStatisticsInfos(mediaItem)
        )
    }
}
