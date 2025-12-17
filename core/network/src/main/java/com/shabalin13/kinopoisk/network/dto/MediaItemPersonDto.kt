package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemPersonDto(
    @SerialName("id") val id: Int,
    @SerialName("photo") val photoUrl: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("enName") val enName: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("profession") val profession: String? = null,
    @SerialName("enProfession") val enProfession: String? = null,
)
