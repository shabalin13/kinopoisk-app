package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsRatingsDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsVotesDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsRating
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsRatings

internal class MediaDetailsRatingsMapper {
    fun mapRatingsDtoToRatings(
        ratingsDto: MediaDetailsRatingsDto?,
        votesDto: MediaDetailsVotesDto?,
    ): MediaDetailsRatings? {
        val kpRating = ratingsDto?.kp?.takeIf { it >= 1 }
        val imdbRating = ratingsDto?.imdb?.takeIf { it >= 1 }
        val filmCriticsRating = ratingsDto?.filmCritics?.takeIf { it >= 1 }

        return if (kpRating == null && imdbRating == null && filmCriticsRating == null) {
            null
        } else {
            MediaDetailsRatings(
                kp = kpRating?.let { rating ->
                    MediaDetailsRating(
                        value = rating,
                        votesCount = votesDto?.kp?.takeIf { it >= 1 }
                    )
                },
                imdb = imdbRating?.let { rating ->
                    MediaDetailsRating(
                        value = rating,
                        votesCount = votesDto?.imdb?.takeIf { it >= 1 }
                    )
                },
                filmCritics = filmCriticsRating?.let { rating ->
                    MediaDetailsRating(
                        value = rating,
                        votesCount = votesDto?.filmCritics?.takeIf { it >= 1 }
                    )
                }
            )
        }
    }
}
