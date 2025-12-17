package com.shabalin13.kinopoisk.mediaDetails.presentation.model

internal data class MediaItemUiModel(
    val id: Int,
    val headerInfo: HeaderInfoUiModel,
    val seasonsInfo: SeasonsInfoUiModel? = null,
    val videos: List<VideoUiModel>? = null,
    val actors: List<PersonUiModel>? = null,
    val contributors: List<PersonUiModel>? = null,
    val facts: List<NoteUiModel>? = null,
    val bloopers: List<NoteUiModel>? = null,
    val linkedMediaItems: List<RelatedMediaItemUiModel>? = null,
    val similarMediaItems: List<RelatedMediaItemUiModel>? = null,
    val statisticsInfos: List<StatisticsInfoUiModel>? = null,
//    val actorsInfo: ActorsInfoUiModel? = null,
//    val contributorsInfo: ContributorsInfoUiModel? = null,
//    val factsInfo: FactsInfoUiModel? = null,
//    val bloopersInfo: BloopersInfoUiModel? = null,
//    val linkedMediaItemsInfo: LinkedMediaItemsInfoUiModel? = null,
//    val similarMediaItemsInfo: SimilarMediaItemsInfoUiModel? = null,
)
