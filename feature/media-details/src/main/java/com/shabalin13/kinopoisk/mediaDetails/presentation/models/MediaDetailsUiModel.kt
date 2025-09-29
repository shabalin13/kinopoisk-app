package com.shabalin13.kinopoisk.mediaDetails.presentation.models

internal data class MediaDetailsUiModel(
    val id: Int,
    val headerInfo: HeaderInfoUiModel,
    val videosInfo: List<VideoInfoUiModel>? = null,
    val actorsInfo: ActorsInfoUiModel? = null,
    val contributorsInfo: ContributorsInfoUiModel? = null,
    val factsInfo: FactsInfoUiModel? = null,
    val bloopersInfo: BloopersInfoUiModel? = null,
    val linkedMediaItemsInfo: LinkedMediaItemsInfoUiModel? = null,
    val similarMediaItemsInfo: SimilarMediaItemsInfoUiModel? = null,
    val statisticsInfos: List<StatisticsInfoUiModel>? = null,
)
