package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class HeaderInfoUiModel(
    val name: String,
    val posterUrl: String? = null,
    val metaInfo: MetaInfoUiModel? = null,
    val actionButtonsInfo: ActionButtonsInfoUiModel = ActionButtonsInfoUiModel(),
    val descriptionInfo: DescriptionInfoUiModel? = null,
    val ratingsInfo: RatingsInfoUiModel? = null,
)
