package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemNoteDto(
    @SerialName("value") val value: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("spoiler") val isSpoiler: Boolean? = null,
)
