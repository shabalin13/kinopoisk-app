package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemSeasonInfo
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.SeasonsInfoUiModel
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemSeasonsInfoMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapDomainToUiModel(seasonsInfo: List<MediaItemSeasonInfo>): SeasonsInfoUiModel? {
        if (seasonsInfo.isEmpty()) return null
        val seasonsCount = seasonsInfo.count()
        val episodesCount = seasonsInfo.sumOf { it.episodesCount }
        return buildList {
            add(
                resourceProvider.getQuantityString(
                    R.plurals.seasons,
                    seasonsCount,
                    seasonsCount
                )
            )
            add(
                resourceProvider.getQuantityString(
                    R.plurals.episodes,
                    episodesCount,
                    episodesCount
                )
            )
        }.joinToString(", ")
    }
}
