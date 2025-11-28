package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaItemFeeDto(
    @SerialName("value") val value: Long? = null,
    @SerialName("currency") val currency: String? = null,
)
