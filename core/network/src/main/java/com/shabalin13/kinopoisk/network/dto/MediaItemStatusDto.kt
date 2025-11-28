package com.shabalin13.kinopoisk.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MediaItemStatusDto {
    @SerialName("filming")
    FILMING,

    @SerialName("pre-production")
    PRE_PRODUCTION,

    @SerialName("completed")
    COMPLETED,

    @SerialName("announced")
    ANNOUNCED,

    @SerialName("post-production")
    POST_PRODUCTION,
}
