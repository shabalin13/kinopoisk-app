package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsDto(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String? = null,
    @SerialName("type") val type: MediaDetailsTypeDto,
    @SerialName("isSeries") val isSeries: Boolean? = null,
    @SerialName("alternativeName") val alternativeName: String? = null,
    @SerialName("year") val year: Int? = null,
    @SerialName("releaseYears") val releaseYears: List<MediaDetailsReleaseYearsDto>? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("slogan") val slogan: String? = null,
    @SerialName("status") val status: MediaDetailsStatusDto? = null,
    @SerialName("rating") val ratings: MediaDetailsRatingsDto? = null,
    @SerialName("votes") val votes: MediaDetailsVotesDto? = null,
    @SerialName("movieLength") val movieLength: Int? = null,
    @SerialName("ageRating") val ageRating: Int? = null,
    @SerialName("poster") val poster: MediaDetailsPosterDto? = null,
    @SerialName("genres") val genres: List<MediaDetailsGenreDto>? = null,
    @SerialName("countries") val countries: List<MediaDetailsCountryDto>? = null,
    @SerialName("persons") val people: List<MediaDetailsPersonDto>? = null,
    @SerialName("seasonsInfo") val seasonsInfo: List<MediaDetailsSeasonInfoDto>? = null,
    @SerialName("budget") val budget: MediaDetailsBudgetDto? = null,
    @SerialName("fees") val fees: MediaDetailsFeesDto? = null,
    @SerialName("premiere") val premieres: MediaDetailsPremieresDto? = null,
    @SerialName("sequelsAndPrequels") val linkedMediaItems: List<MediaDetailsLinkedMediaItemDto>? = null,
    @SerialName("similarMovies") val similarMediaItems: List<MediaDetailsSimilarMediaItemDto>? = null,
    @SerialName("facts") val notes: List<MediaDetailsNoteDto>? = null,
    @SerialName("videos") val videos: MediaDetailsVideosDto? = null,
)
