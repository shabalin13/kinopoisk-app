package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemRatings
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.RatingsUiModel
import com.shabalin13.kinopoisk.ui.model.RatingUiModel
import com.shabalin13.kinopoisk.ui.model.RatingUiModel.Companion.from
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemRatingsMapper @Inject constructor() {
    fun mapDomainToUiModel(ratings: MediaItemRatings): RatingsUiModel? {
        val kpRating = ratings.kp?.value?.run(RatingUiModel::from)
        val imdbRating = ratings.imdb?.value?.run(RatingUiModel::from)
        if (kpRating == null && imdbRating == null) return null
        return RatingsUiModel(
            kpRating = kpRating,
            imdbRating = imdbRating
        )
    }
}
