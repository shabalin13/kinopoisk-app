package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("type") val type: MediaItemTypeDto,
    @SerialName("isSeries") val isSeries: Boolean? = null,
    @SerialName("alternativeName") val alternativeName: String? = null,
    @SerialName("year") val year: Int? = null,
    @SerialName("releaseYears") val releaseYears: List<MediaItemReleaseYearsDto>? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("slogan") val slogan: String? = null,
    @SerialName("status") val status: MediaItemStatusDto? = null,
    @SerialName("rating") val ratings: MediaItemRatingsDto? = null,
    @SerialName("votes") val votes: MediaItemVotesDto? = null,
    @SerialName("movieLength") val movieLength: Int? = null,
    @SerialName("ageRating") val ageRating: Int? = null,
    @SerialName("poster") val poster: MediaItemPosterDto? = null,
    @SerialName("genres") val genres: List<MediaItemGenreDto>? = null,
    @SerialName("countries") val countries: List<MediaItemCountryDto>? = null,
    @SerialName("persons") val people: List<MediaItemPersonDto>? = null,
    @SerialName("seasonsInfo") val seasonsInfo: List<MediaItemSeasonInfoDto>? = null,
    @SerialName("budget") val budget: MediaItemBudgetDto? = null,
    @SerialName("fees") val fees: MediaItemFeesDto? = null,
    @SerialName("premiere") val premieres: MediaItemPremieresDto? = null,
    @SerialName("sequelsAndPrequels") val linkedMediaItems: List<RelatedMediaItemDto>? = null,
    @SerialName("similarMovies") val similarMediaItems: List<RelatedMediaItemDto>? = null,
    @SerialName("facts") val notes: List<MediaItemNoteDto>? = null,
    @SerialName("videos") val videos: MediaItemVideosDto? = null,
)
