package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.model.MediaItemActor
import com.shabalin13.kinopoisk.domain.model.MediaItemActorProfession
import com.shabalin13.kinopoisk.domain.model.MediaItemContributor
import com.shabalin13.kinopoisk.domain.model.MediaItemContributorProfession
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ActorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.ContributorsInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import javax.inject.Inject

@MediaDetailsScope
internal class MediaDetailsPeopleMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapActorsToActorsInfo(actors: List<MediaItemActor>): ActorsInfoUiModel? {
        if (actors.isEmpty()) return null

        val actorsFiltered = actors.filter { it.profession == MediaItemActorProfession.ACTOR }

        return ActorsInfoUiModel(
            actors = actorsFiltered.take(ActorsInfoUiModel.MAX_VISIBLE).map { actor ->
                PersonInfoUiModel(
                    id = actor.id,
                    name = actor.name,
                    photoUrl = actor.photoUrl,
                    additionalInfo = actor.characterName
                )
            },
            isMore = actorsFiltered.size > ActorsInfoUiModel.MAX_VISIBLE
        )
    }

    fun mapContributorsToContributorsInfo(contributors: List<MediaItemContributor>): ContributorsInfoUiModel? {
        if (contributors.isEmpty()) return null

        return ContributorsInfoUiModel(
            contributors = contributors.sortedBy { it.profession }
                .take(ContributorsInfoUiModel.MAX_VISIBLE)
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
