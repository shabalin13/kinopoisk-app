package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemRating
import com.shabalin13.kinopoisk.domain.model.MediaItemRatings
import com.shabalin13.kinopoisk.network.dto.MediaItemRatingsDto
import com.shabalin13.kinopoisk.network.dto.MediaItemVotesDto
import javax.inject.Inject

@DataScope
internal class MediaItemRatingsMapper @Inject constructor() {
    fun mapDtoToDomain(
        ratingsDto: MediaItemRatingsDto?,
        votesDto: MediaItemVotesDto?,
    ): MediaItemRatings? {
        val kpRating = ratingsDto?.kp?.takeIf { it >= 1 }
        val imdbRating = ratingsDto?.imdb?.takeIf { it >= 1 }
        val filmCriticsRating = ratingsDto?.filmCritics?.takeIf { it >= 1 }

        return if (kpRating == null && imdbRating == null && filmCriticsRating == null) {
            null
        } else {
            MediaItemRatings(
                kp = kpRating?.let { rating ->
                    MediaItemRating(
                        value = rating,
                        votesCount = votesDto?.kp?.takeIf { it >= 1 }
                    )
                },
                imdb = imdbRating?.let { rating ->
                    MediaItemRating(
                        value = rating,
                        votesCount = votesDto?.imdb?.takeIf { it >= 1 }
                    )
                },
                filmCritics = filmCriticsRating?.let { rating ->
                    MediaItemRating(
                        value = rating,
                        votesCount = votesDto?.filmCritics?.takeIf { it >= 1 }
                    )
                }
            )
        }
    }
}
