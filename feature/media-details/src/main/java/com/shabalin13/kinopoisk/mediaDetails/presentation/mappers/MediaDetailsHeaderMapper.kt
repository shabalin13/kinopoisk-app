package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.domain.model.MediaItemRatings
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActionButtonsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MetaInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.RatingsInfoUiModel
import com.shabalin13.kinopoisk.ui.formatters.DurationFormatter
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaDetailsHeaderMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val durationFormatter: DurationFormatter,
) {
    fun mapToHeaderInfo(mediaItem: MediaItem): HeaderInfoUiModel {
        return HeaderInfoUiModel(
            name = mediaItem.name,
            posterUrl = mediaItem.posterUrl,
            metaInfo = mapToMetaInfo(mediaItem),
            actionButtonsInfo = ActionButtonsInfoUiModel(),
            descriptionInfo = mapToDescriptionInfo(
                mediaItem.description,
                mediaItem.ageRating
            ),
            ratingsInfo = mapToRatingsInfo(mediaItem.ratings)
        )
    }

    private fun mapToMetaInfo(mediaItem: MediaItem): MetaInfoUiModel? {
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

    private fun mapToDescriptionInfo(
        description: String?,
        ageRating: Int?,
    ): DescriptionInfoUiModel? {
        if (description == null) return null

        return DescriptionInfoUiModel(
            description = description,
            ageRating = ageRating?.let { "$it+" }
        )
    }

    private fun mapToRatingsInfo(ratings: MediaItemRatings?): RatingsInfoUiModel? {
        val kpRating = ratings?.kp?.value?.run(RatingUiModel::from)
        val imdbRating = ratings?.imdb?.value?.run(RatingUiModel::from)
        if (kpRating == null && imdbRating == null) return null
        return RatingsInfoUiModel(
            kpRating = kpRating,
            imdbRating = imdbRating
        )
    }
}
