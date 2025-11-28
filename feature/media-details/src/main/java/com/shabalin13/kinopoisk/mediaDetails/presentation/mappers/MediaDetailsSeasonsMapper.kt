package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaItemSeasonInfo
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.SeasonsInfoUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaDetailsSeasonsMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapToSeasonsInfo(seasonsInfo: List<MediaItemSeasonInfo>): SeasonsInfoUiModel? {
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
