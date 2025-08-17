package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsContributor
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsContributorProfession
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ContributorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import javax.inject.Inject

internal class MediaDetailsContributorsMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapToContributorsInfo(contributors: List<MediaDetailsContributor>): ContributorsInfoUiModel? {
        if (contributors.isEmpty()) return null

        return ContributorsInfoUiModel(
            contributors = contributors.sortedBy { it.profession }.take(ContributorsInfoUiModel.MAX_VISIBLE)
                .map { contributor ->
                    PersonInfoUiModel(
                        id = contributor.id,
                        name = contributor.name,
                        photoUrl = contributor.photoUrl,
                        additionalInfo = mapContributorProfessionToAdditionalInfo(contributor.profession)
                    )
                },
            isMore = contributors.size > ContributorsInfoUiModel.MAX_VISIBLE
        )
    }

    private fun mapContributorProfessionToAdditionalInfo(profession: MediaDetailsContributorProfession): String {
        return when (profession) {
            MediaDetailsContributorProfession.DIRECTOR -> resourceProvider.getString(R.string.director_profession_title)
            MediaDetailsContributorProfession.PRODUCER -> resourceProvider.getString(R.string.producer_profession_title)
            MediaDetailsContributorProfession.WRITER -> resourceProvider.getString(R.string.writer_profession_title)
            MediaDetailsContributorProfession.OPERATOR -> resourceProvider.getString(R.string.operator_profession_title)
            MediaDetailsContributorProfession.COMPOSER -> resourceProvider.getString(R.string.composer_profession_title)
            MediaDetailsContributorProfession.DESIGNER -> resourceProvider.getString(R.string.designer_profession_title)
            MediaDetailsContributorProfession.EDITOR -> resourceProvider.getString(R.string.editor_profession_title)
        }
    }
}
