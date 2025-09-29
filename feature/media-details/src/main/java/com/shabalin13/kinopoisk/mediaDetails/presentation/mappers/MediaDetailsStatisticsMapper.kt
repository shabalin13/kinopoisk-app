package com.shabalin13.kinopoisk.mediaDetails.presentation.mappers

import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetails
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsBudget
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFees
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsPremieres
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.StatisticsInfoUiModel
import com.shabalin13.kinopoisk.ui.resources.ResourceProvider
import com.shabalin13.kinopoisk.ui.utils.NumberUtils
import kotlinx.datetime.toJavaLocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

internal class MediaDetailsStatisticsMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    fun mapToStatisticsInfos(mediaDetails: MediaDetails): List<StatisticsInfoUiModel>? {
        return (
            mapPremieresToStatisticsInfos(mediaDetails.premieres) +
                mapBudgetToStatisticsInfo(mediaDetails.budget) +
                mapFeesToStatisticsInfos(mediaDetails.fees)
            ).takeIf { it.isNotEmpty() }
    }

    private fun mapPremieresToStatisticsInfos(premieres: MediaDetailsPremieres?): List<StatisticsInfoUiModel> {
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

    private fun mapBudgetToStatisticsInfo(budget: MediaDetailsBudget?): List<StatisticsInfoUiModel> {
        return buildList {
            budget?.let { budget ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${budget.currency}${NumberUtils.formatLongWithSpaces(budget.value)}",
                        description = resourceProvider.getString(R.string.budget_title)
                    )
                )
            }
        }
    }

    private fun mapFeesToStatisticsInfos(fees: MediaDetailsFees?): List<StatisticsInfoUiModel> {
        return buildList {
            fees?.world?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency}${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.world_fee_title)
                    )
                )
            }
            fees?.russia?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency}${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.russia_fee_title)
                    )
                )
            }
            fees?.usa?.let { fee ->
                add(
                    StatisticsInfoUiModel(
                        statistics = "${fee.currency}${NumberUtils.formatLongWithSpaces(fee.value)}",
                        description = resourceProvider.getString(R.string.usa_fee_title)
                    )
                )
            }
        }
    }
}
