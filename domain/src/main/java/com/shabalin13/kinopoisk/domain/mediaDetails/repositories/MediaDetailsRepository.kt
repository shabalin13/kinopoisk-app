package com.shabalin13.kinopoisk.domain.mediaDetails.repositories

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails

interface MediaDetailsRepository {
    suspend fun getMediaDetails(mediaId: Int): Result<MediaDetails>
}
