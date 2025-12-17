package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.ActionButtonsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MetaInfoUiModel
import com.shabalin13.kinopoisk.ui.formatter.DurationFormatter
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemHeaderMapper @Inject constructor(
    private val ratingsMapper: MediaItemRatingsMapper,
    private val resourceProvider: ResourceProvider,
    private val durationFormatter: DurationFormatter,
) {
    fun mapDomainToUiModel(mediaItem: MediaItem): HeaderInfoUiModel {
        return HeaderInfoUiModel(
            name = mediaItem.name,
            posterUrl = mediaItem.posterUrl,
            metaInfo = buildMetaInfo(mediaItem),
            actionButtonsInfo = ActionButtonsInfoUiModel(),
            description = mediaItem.description,
            ratings = mediaItem.ratings?.let { ratingsMapper.mapDomainToUiModel(it) }
        )
    }

    private fun buildMetaInfo(mediaItem: MediaItem): MetaInfoUiModel? {
        val summary1 = buildList {
            if (mediaItem.isSeries) {
                mediaItem.releaseYears?.let { releaseYears ->
                    if (releaseYears.end == null) {
                        add(resourceProvider.getString(R.string.from_year, releaseYears.start))
                    } else if (releaseYears.start == releaseYears.end) {
                        add("${releaseYears.start}")
                    } else {
                        add("${releaseYears.start} - ${releaseYears.end}")
                    }
                }
                addAll(mediaItem.genres.take(2))
                add(
                    resourceProvider.getQuantityString(
                        R.plurals.seasons,
                        mediaItem.seasonsInfo.count(),
                        mediaItem.seasonsInfo.count()
                    )
                )
            } else {
                mediaItem.year?.let { add("$it") }
                addAll(mediaItem.genres.take(2))
            }
        }.joinToString(", ").takeIf { it.isNotBlank() }

        val summary2 = buildList {
            addAll(mediaItem.countries.take(2))
            if (!mediaItem.isSeries) {
                mediaItem.movieLength?.let { add(durationFormatter.formatMediaDuration(it)) }
            }
            mediaItem.ageRating?.let { ageRating ->
                add("$ageRating+")
            }
        }.joinToString(", ").takeIf { it.isNotBlank() }

        val summary = buildList {
            summary1?.let(this::add)
            summary2?.let(this::add)
        }.joinToString("\n").takeIf { it.isNotBlank() }

        if (mediaItem.alternativeName == null && summary == null) return null
        return MetaInfoUiModel(
            alternativeName = mediaItem.alternativeName,
            summary = summary
        )
    }
}
