package com.shabalin13.kinopoisk.mediaDetails.presentation.model

internal data class HeaderInfoUiModel(
    val name: String,
    val posterUrl: String? = null,
    val metaInfo: MetaInfoUiModel? = null,
    val actionButtonsInfo: ActionButtonsInfoUiModel = ActionButtonsInfoUiModel(),
    val description: String? = null,
    val ratings: RatingsUiModel? = null,
)
