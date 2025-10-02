package com.shabalin13.kinopoisk.mediaDetails.di

import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase
import com.shabalin13.kinopoisk.ui.formatters.DurationFormatter
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider

interface MediaDetailsDependencies {
    val getMediaDetailsUseCase: GetMediaDetailsUseCase
    val resourceProvider: ResourceProvider
    val durationFormatter: DurationFormatter
}
