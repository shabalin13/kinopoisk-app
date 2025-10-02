package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsPersonDto(
    @SerialName("id") val id: Int,
    @SerialName("photo") val photoUrl: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("enName") val enName: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("profession") val profession: String? = null,
    @SerialName("enProfession") val enProfession: String? = null,
)
