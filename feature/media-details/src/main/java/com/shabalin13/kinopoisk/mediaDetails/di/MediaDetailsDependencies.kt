package com.shabalin13.kinopoisk.mediaDetails.di

import com.shabalin13.kinopoisk.domain.mediaDetails.usecases.GetMediaDetailsUseCase

interface MediaDetailsDependencies {
    val getMediaDetailsUseCase: GetMediaDetailsUseCase
}
