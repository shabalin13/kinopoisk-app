package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsNoteDto(
    @SerialName("value") val value: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("spoiler") val isSpoiler: Boolean? = null,
)
