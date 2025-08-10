package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActionButtonsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.DescriptionInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.HeaderInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.MetaInfoUiModel
import com.shabalin13.kinopoisk.ui.formatters.DurationFormatter
import com.shabalin13.kinopoisk.ui.models.RatingUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import javax.inject.Inject

internal class MediaDetailsHeaderMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val durationFormatter: DurationFormatter,
) {
    fun mapToHeaderInfo(mediaDetails: MediaDetails): HeaderInfoUiModel {
        val metaInfo = mapToMetaInfo(mediaDetails)
        val descriptionInfo = mapToDescriptionInfo(mediaDetails.description, mediaDetails.ageRating)

        return HeaderInfoUiModel(
            name = mediaDetails.name,
            posterUrl = mediaDetails.posterUrl,
            metaInfo = metaInfo,
            actionButtonsInfo = ActionButtonsInfoUiModel(),
            descriptionInfo = descriptionInfo
        )
    }

    private fun mapToMetaInfo(mediaDetails: MediaDetails): MetaInfoUiModel? {
        val rating = mediaDetails.ratings?.kp?.value?.run(RatingUiModel::from)

        val summary1 = buildList {
            if (mediaDetails.isSeries) {
                mediaDetails.releaseYears?.let { releaseYears ->
                    if (releaseYears.end == null) {
                        add(resourceProvider.getString(R.string.from_year, releaseYears.start))
                    } else if (releaseYears.start == releaseYears.end) {
                        add("${releaseYears.start}")
                    } else {
                        add("${releaseYears.start} - ${releaseYears.end}")
                    }
                }
                addAll(mediaDetails.genres.take(2))
                add(
                    resourceProvider.getQuantityString(
                        R.plurals.seasons,
                        mediaDetails.seasonsInfo.count(),
                        mediaDetails.seasonsInfo.count()
                    )
                )
            } else {
                mediaDetails.year?.let { add("$it") }
                addAll(mediaDetails.genres.take(2))
            }
        }.joinToString(", ").takeIf { it.isNotBlank() }

        val summary2 = buildList {
            addAll(mediaDetails.countries.take(2))
            if (!mediaDetails.isSeries) {
                mediaDetails.movieLength?.let { add(durationFormatter.formatMediaDuration(it)) }
            }
            mediaDetails.ageRating?.let { ageRating ->
                add("$ageRating+")
            }
        }.joinToString(", ").takeIf { it.isNotBlank() }

        val summary = buildList {
            summary1?.let(this::add)
            summary2?.let(this::add)
        }.joinToString("\n").takeIf { it.isNotBlank() }

        if (mediaDetails.alternativeName == null && summary == null) return null
        return MetaInfoUiModel(
            rating = rating,
            alternativeName = mediaDetails.alternativeName,
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
}
