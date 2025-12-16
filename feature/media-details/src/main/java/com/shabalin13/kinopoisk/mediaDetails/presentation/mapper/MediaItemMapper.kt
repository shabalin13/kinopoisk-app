package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.domain.model.MediaItemActorProfession
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MediaItemUiModel
import javax.inject.Inject

@Suppress("LongParameterList")
@MediaDetailsScope
internal class MediaItemMapper @Inject constructor(
    private val headerMapper: MediaItemHeaderMapper,
    private val seasonsMapper: MediaItemSeasonsInfoMapper,
    private val videoMapper: MediaItemVideoMapper,
    private val actorMapper: MediaItemActorMapper,
    private val contributorMapper: MediaItemContributorMapper,
    private val factMapper: MediaItemFactMapper,
    private val blooperMapper: MediaItemBlooperMapper,
    private val relatedMediaItemMapper: RelatedMediaItemMapper,
    private val statisticsMapper: MediaItemStatisticsMapper,
) {
    fun mapDomainToUiModel(mediaItem: MediaItem): MediaItemUiModel {
        return MediaItemUiModel(
            id = mediaItem.id,
            headerInfo = headerMapper.mapDomainToUiModel(mediaItem),
            seasonsInfo = seasonsMapper.mapDomainToUiModel(mediaItem.seasonsInfo),
            videos = mediaItem.videos.map { videoMapper.mapDomainToUiModel(it) }
                .takeIf { it.isNotEmpty() },
            actors = mediaItem.actors.filter { it.profession == MediaItemActorProfession.ACTOR }
                .map { actorMapper.mapDomainToUiModel(it) }.takeIf { it.isNotEmpty() },
            contributors = mediaItem.contributors.sortedBy { it.profession }
                .map { contributorMapper.mapDomainToUiModel(it) }.takeIf { it.isNotEmpty() },
            facts = mediaItem.facts.map { factMapper.mapDomainToUiModel(it) }
                .takeIf { it.isNotEmpty() },
            bloopers = mediaItem.bloopers.map { blooperMapper.mapDomainToUiModel(it) }
                .takeIf { it.isNotEmpty() },
            linkedMediaItems = mediaItem.linkedMediaItems.map {
                relatedMediaItemMapper.mapDomainToUiModel(
                    it
                )
            }.takeIf { it.isNotEmpty() },
            similarMediaItems = mediaItem.similarMediaItems.map {
                relatedMediaItemMapper.mapDomainToUiModel(
                    it
                )
            }.takeIf { it.isNotEmpty() },
            statisticsInfos = statisticsMapper.mapDomainToUiModel(mediaItem)
        )
    }
}
