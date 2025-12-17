package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.domain.model.MediaItemContributor
import com.shabalin13.kinopoisk.domain.model.MediaItemContributorProfession
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.PersonUiModel
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemContributorMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapDomainToUiModel(contributor: MediaItemContributor): PersonUiModel {
        return PersonUiModel(
            id = contributor.id,
            name = contributor.name,
            photoUrl = contributor.photoUrl,
            additionalInfo = mapContributorProfessionToAdditionalInfo(contributor.profession)
        )
    }

    private fun mapContributorProfessionToAdditionalInfo(profession: MediaItemContributorProfession): String {
        return when (profession) {
            MediaItemContributorProfession.DIRECTOR -> resourceProvider.getString(R.string.director_profession_title)
            MediaItemContributorProfession.PRODUCER -> resourceProvider.getString(R.string.producer_profession_title)
            MediaItemContributorProfession.WRITER -> resourceProvider.getString(R.string.writer_profession_title)
            MediaItemContributorProfession.OPERATOR -> resourceProvider.getString(R.string.operator_profession_title)
            MediaItemContributorProfession.COMPOSER -> resourceProvider.getString(R.string.composer_profession_title)
            MediaItemContributorProfession.DESIGNER -> resourceProvider.getString(R.string.designer_profession_title)
            MediaItemContributorProfession.EDITOR -> resourceProvider.getString(R.string.editor_profession_title)
        }
    }
}
