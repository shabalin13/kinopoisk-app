package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MediaDetailsBudgetDto(
    @SerialName("value") val value: Long? = null,
    @SerialName("currency") val currency: String? = null,
)
