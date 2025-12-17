package com.shabalin13.kinopoisk.mediaDetails.di

import com.shabalin13.kinopoisk.mediaDetails.presentation.MediaDetailsViewModel
import dagger.Component

@MediaDetailsScope
@Component(
    dependencies = [MediaDetailsDependencies::class]
)
internal interface MediaDetailsComponent {
    fun mediaDetailsViewModelFactory(): MediaDetailsViewModel.MediaDetailsViewModelFactory.Factory

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: MediaDetailsDependencies,
        ): MediaDetailsComponent
    }
}
