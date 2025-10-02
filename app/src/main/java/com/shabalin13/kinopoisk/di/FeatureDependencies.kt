package com.shabalin13.kinopoisk.di

import com.shabalin13.kinopoisk.mediaCatalog.di.MediaCatalogDependencies
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsDependencies

interface FeatureDependencies :
    MediaCatalogDependencies, MediaDetailsDependencies
