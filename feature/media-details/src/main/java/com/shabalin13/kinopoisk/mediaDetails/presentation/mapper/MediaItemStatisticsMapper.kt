package com.shabalin13.kinopoisk.mediaDetails.presentation.mapper

import com.shabalin13.kinopoisk.common.utils.NumberUtils
import com.shabalin13.kinopoisk.domain.model.MediaItem
import com.shabalin13.kinopoisk.domain.model.MediaItemBudget
import com.shabalin13.kinopoisk.domain.model.MediaItemFees
import com.shabalin13.kinopoisk.domain.model.MediaItemPremieres
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.di.MediaDetailsScope
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.StatisticsInfoUiModel
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import kotlinx.datetime.toJavaLocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@MediaDetailsScope
internal class MediaItemStatisticsMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapDomainToUiModel(mediaItem: MediaItem): List<StatisticsInfoUiModel>? {
        return (
            mapPremieresToStatisticsInfos(mediaItem.premieres) +
                mapBudgetToStatisticsInfo(mediaItem.budget) +
                mapFeesToStatisticsInfos(mediaItem.fees)
            ).takeIf { it.isNotEmpty() }
    }

    private fun mapPremieresToStatisticsInfos(premieres: MediaItemPremieres?): List<StatisticsInfoUiModel> {
        return buildList {
            val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
            premieres?.world?.let { premiere ->
                add(
                    StatisticsInfoUiModel(
                        statistics = premiere.toJavaLocalDate().format(formatter),
                        description = resourceProvider.getString(R.string.world_premiere_title)
                    )
                )
            }
            premieres?.russia?.let { premiere ->
                add(
                    StatisticsInfoUiModel(
                        statistics = premiere.toJavaLocalDate().format(formatter),
                        description = resourceProvider.getString(R.string.russia_premiere_title)
                    )
                )
            }
        }
    }

    private fun mapBudgetToStatisticsInfo(budget: MediaItemBudget?): List<StatisticsInfoUiModel> {
        return buildList {
            budget?.let { budget ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${budget.currency} ${NumberUtils.formatLongWithSpaces(budget.value)}",
                        description = resourceProvider.getString(R.string.budget_title)
                    )
                )
            }
        }
    }

    private fun mapFeesToStatisticsInfos(fees: MediaItemFees?): List<StatisticsInfoUiModel> {
        return buildList {
            fees?.world?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency} ${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.world_fee_title)
                    )
                )
            }
            fees?.russia?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency} ${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.russia_fee_title)
                    )
                )
            }
            fees?.usa?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency} ${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.usa_fee_title)
                    )
                )
            }
        }
    }
}
