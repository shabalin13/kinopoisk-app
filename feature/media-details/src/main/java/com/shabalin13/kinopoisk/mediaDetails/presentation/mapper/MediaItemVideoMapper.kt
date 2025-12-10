package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemVideo
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.VideoUiModel
import javax.inject.Inject
import javax.inject.Scope

@MediaDetailsScope
internal class MediaItemVideoMapper @Inject constructor() {
    fun mapDomainToUiModel(video: MediaItemVideo): VideoUiModel {
        return VideoUiModel(
            posterUrl = video.posterUrl,
            videoUrl = video.videoUrl,
            name = video.name
        )
    }
}
