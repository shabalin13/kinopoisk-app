package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.network.dto.MediaItemDto
import javax.inject.Inject

@Suppress("LongParameterList")
@DataScope
internal class MediaItemMapper @Inject constructor(
    private val typeMapper: MediaItemTypeMapper,
    private val releaseYearsMapper: MediaItemReleaseYearsMapper,
    private val statusMapper: MediaItemStatusMapper,
    private val ratingsMapper: MediaItemRatingsMapper,
    private val actorMapper: MediaItemActorMapper,
    private val contributorMapper: MediaItemContributorMapper,
    private val seasonInfoMapper: MediaItemSeasonInfoMapper,
    private val budgetMapper: MediaItemBudgetMapper,
    private val feesMapper: MediaItemFeesMapper,
    private val premieresMapper: MediaItemPremieresMapper,
    private val relatedMediaItemMapper: RelatedMediaItemMapper,
    private val factMapper: MediaItemFactMapper,
    private val blooperMapper: MediaItemBlooperMapper,
    private val videoMapper: MediaItemVideoMapper,
) {
    @Suppress("CyclomaticComplexMethod")
    fun mapDtoToDomain(dto: MediaItemDto): MediaItem {
        return MediaItem(
            id = dto.id,
            name = dto.name?.takeIf { it.isNotBlank() } ?: "",
            type = typeMapper.mapDtoToDomain(dto.type),
            isSeries = dto.isSeries ?: false,
            alternativeName = dto.alternativeName?.takeIf { it.isNotBlank() },
            year = dto.year?.takeIf { it >= 1 },
            releaseYears = dto.releaseYears?.firstOrNull()
                ?.let { releaseYearsMapper.mapDtoToDomain(it) },
            description = dto.description?.takeIf { it.isNotBlank() },
            slogan = dto.slogan?.takeIf { it.isNotBlank() },
            status = dto.status?.let { statusMapper.mapDtoToDomain(it) },
            ratings = ratingsMapper.mapDtoToDomain(dto.ratings, dto.votes),
            movieLength = dto.movieLength?.takeIf { it >= 1 },
            ageRating = dto.ageRating?.takeIf { it >= 1 },
            posterUrl = dto.poster?.url,
            genres = dto.genres?.map { it.name }?.filter { it.isNotBlank() } ?: emptyList(),
            countries = dto.countries?.map { it.name }?.filter { it.isNotBlank() } ?: emptyList(),
            actors = dto.people?.mapNotNull { actorMapper.mapDtoToDomain(it) } ?: emptyList(),
            contributors = dto.people?.mapNotNull { contributorMapper.mapDtoToDomain(it) }
                ?: emptyList(),
            seasonsInfo = dto.seasonsInfo?.mapNotNull { seasonInfoMapper.mapDtoToDomain(it) }
                ?: emptyList(),
            budget = dto.budget?.let { budgetMapper.mapDtoToDomain(it) },
            fees = dto.fees?.let { feesMapper.mapDtoToDomain(it) },
            premieres = dto.premieres?.let { premieresMapper.mapDtoToDomain(it) },
            linkedMediaItems = dto.linkedMediaItems?.mapNotNull {
                relatedMediaItemMapper.mapDtoToDomain(it)
            } ?: emptyList(),
            similarMediaItems = dto.similarMediaItems?.mapNotNull {
                relatedMediaItemMapper.mapDtoToDomain(it)
            } ?: emptyList(),
            facts = dto.notes?.mapNotNull { factMapper.mapDtoToDomain(it) } ?: emptyList(),
            bloopers = dto.notes?.mapNotNull { blooperMapper.mapDtoToDomain(it) } ?: emptyList(),
            videos = (
                dto.videos?.trailers?.mapNotNull { videoMapper.mapDtoToDomain(it) }
                    ?: emptyList()
                ) + (
                dto.videos?.teasers?.mapNotNull { videoMapper.mapDtoToDomain(it) }
                    ?: emptyList()
                )
        )
    }
}
