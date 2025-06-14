package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsReleaseYearsDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsSeasonInfoDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsStatusDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsTypeDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsReleaseYears
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsSeasonInfo
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsStatus
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsType
import javax.inject.Inject

internal class MediaDetailsMapper @Inject constructor(
    private val ratingsMapper: MediaDetailsRatingsMapper,
    private val peopleMapper: MediaDetailsPeopleMapper,
    private val marketingMapper: MediaDetailsMarketingMapper,
    private val mediaItemsMapper: MediaDetailsMediaItemsMapper,
    private val notesMapper: MediaDetailsNotesMapper,
    private val videosMapper: MediaDetailsVideosMapper,
) {

    fun mapDtoToDomain(dto: MediaDetailsDto): MediaDetails {
        return MediaDetails(
            id = dto.id,
            name = dto.name?.takeIf { it.isNotBlank() } ?: "",
            type = mapTypeDtoToType(dto.type),
            isSeries = dto.isSeries ?: false,
            alternativeName = dto.alternativeName?.takeIf { it.isNotBlank() },
            year = dto.year?.takeIf { it >= 1 },
            releaseYears = mapReleaseYearsDtoToReleaseYears(dto.releaseYears),
            description = dto.description?.takeIf { it.isNotBlank() },
            slogan = dto.slogan?.takeIf { it.isNotBlank() },
            status = mapStatusDtoToStatus(dto.status),
            ratings = ratingsMapper.mapRatingsDtoToRatings(dto.ratings, dto.votes),
            movieLength = dto.movieLength?.takeIf { it >= 1 },
            ageRating = dto.ageRating?.takeIf { it >= 1 },
            posterUrl = dto.poster?.url,
            genres = dto.genres?.map { it.name }?.filter { it.isNotBlank() } ?: emptyList(),
            countries = dto.countries?.map { it.name }?.filter { it.isNotBlank() } ?: emptyList(),
            actors = peopleMapper.mapPeopleDtoToActors(dto.people),
            contributors = peopleMapper.mapPeopleDtoToContributors(dto.people),
            seasonsInfo = mapSeasonsInfoDtoToSeasonsInfo(dto.seasonsInfo),
            budget = marketingMapper.mapBudgetDtoToBudget(dto.budget),
            fees = marketingMapper.mapFeesDtoToFees(dto.fees),
            premieres = marketingMapper.mapPremieresDtoToPremieres(dto.premieres),
            linkedMediaItems = mediaItemsMapper.mapLinkedItemsDtoToLinkedItems(dto.linkedMediaItems),
            similarMediaItems = mediaItemsMapper.mapSimilarItemsDtoToSimilarItems(dto.similarMediaItems),
            facts = notesMapper.mapNotesDtoToFacts(dto.notes),
            bloopers = notesMapper.mapNotesDtoToBloopers(dto.notes),
            videos = videosMapper.mapVideosDtoToVideos(dto.videos)
        )
    }

    private fun mapTypeDtoToType(typeDto: MediaDetailsTypeDto): MediaDetailsType {
        return when (typeDto) {
            MediaDetailsTypeDto.MOVIE -> MediaDetailsType.MOVIE
            MediaDetailsTypeDto.TV_SERIES -> MediaDetailsType.TV_SERIES
            MediaDetailsTypeDto.CARTOON -> MediaDetailsType.CARTOON
            MediaDetailsTypeDto.ANIME -> MediaDetailsType.ANIME
            MediaDetailsTypeDto.ANIMATED_SERIES -> MediaDetailsType.ANIMATED_SERIES
            MediaDetailsTypeDto.TV_SHOW -> MediaDetailsType.TV_SHOW
        }
    }

    private fun mapReleaseYearsDtoToReleaseYears(
        releaseYearsDto: List<MediaDetailsReleaseYearsDto>?,
    ): MediaDetailsReleaseYears? {
        val first = releaseYearsDto?.firstOrNull()
        if (first?.start == null || first.start < 1) return null
        return MediaDetailsReleaseYears(
            start = first.start,
            end = first.end?.takeIf { it >= 1 }
        )
    }

    private fun mapStatusDtoToStatus(statusDto: MediaDetailsStatusDto?): MediaDetailsStatus? {
        if (statusDto == null) return null
        return when (statusDto) {
            MediaDetailsStatusDto.FILMING -> MediaDetailsStatus.FILMING
            MediaDetailsStatusDto.PRE_PRODUCTION -> MediaDetailsStatus.PRE_PRODUCTION
            MediaDetailsStatusDto.COMPLETED -> MediaDetailsStatus.COMPLETED
            MediaDetailsStatusDto.ANNOUNCED -> MediaDetailsStatus.ANNOUNCED
            MediaDetailsStatusDto.POST_PRODUCTION -> MediaDetailsStatus.POST_PRODUCTION
        }
    }

    private fun mapSeasonInfoDtoToSeasonInfo(seasonInfoDto: MediaDetailsSeasonInfoDto?): MediaDetailsSeasonInfo? {
        val seasonNumber = seasonInfoDto?.seasonNumber?.takeIf { it >= 1 }
        val episodesCount = seasonInfoDto?.episodesCount?.takeIf { it >= 1 }
        return if (seasonNumber != null && episodesCount != null) {
            MediaDetailsSeasonInfo(seasonNumber, episodesCount)
        } else {
            null
        }
    }

    private fun mapSeasonsInfoDtoToSeasonsInfo(
        seasonsInfoDto: List<MediaDetailsSeasonInfoDto>?,
    ): List<MediaDetailsSeasonInfo> {
        return seasonsInfoDto?.mapNotNull(::mapSeasonInfoDtoToSeasonInfo) ?: emptyList()
    }
}
