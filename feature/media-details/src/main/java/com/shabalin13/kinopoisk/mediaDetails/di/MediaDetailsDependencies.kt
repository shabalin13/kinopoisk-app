package com.shabalin13.kinopoisk.mediaDetails.di

import com.shabalin13.kinopoisk.domain.usecase.GetMediaItemUseCase
import com.shabalin13.kinopoisk.ui.formatter.DurationFormatter
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider

interface MediaDetailsDependencies {
    val getMediaItemUseCase: GetMediaItemUseCase
    val resourceProvider: ResourceProvider
    val durationFormatter: DurationFormatter
}
