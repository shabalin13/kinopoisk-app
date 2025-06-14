package com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class MediaDetailsStatusDto {
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
