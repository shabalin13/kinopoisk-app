package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsBudgetDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsFeeDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsFeesDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsPremieresDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsBudget
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFee
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsFees
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsPremieres
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal class MediaDetailsMarketingMapper {
    fun mapBudgetDtoToBudget(budgetDto: MediaDetailsBudgetDto?): MediaDetailsBudget? {
        val value = budgetDto?.value?.takeIf { it >= 1 }
        val currency = budgetDto?.currency?.takeIf { it.isNotBlank() }
        return if (value != null && currency != null) {
            MediaDetailsBudget(value, currency)
        } else {
            null
        }
    }

    private fun mapFeeDtoToFee(feeDto: MediaDetailsFeeDto?): MediaDetailsFee? {
        val value = feeDto?.value?.takeIf { it >= 1 }
        val currency = feeDto?.currency?.takeIf { it.isNotBlank() }
        return if (value != null && currency != null) {
            MediaDetailsFee(value, currency)
        } else {
            null
        }
    }

    fun mapFeesDtoToFees(feesDto: MediaDetailsFeesDto?): MediaDetailsFees? {
        val worldFee = mapFeeDtoToFee(feesDto?.world)
        val russiaFee = mapFeeDtoToFee(feesDto?.russia)
        val usaFee = mapFeeDtoToFee(feesDto?.usa)

        return if (worldFee == null && russiaFee == null && usaFee == null) {
            null
        } else {
            MediaDetailsFees(
                world = worldFee,
                russia = russiaFee,
                usa = usaFee
            )
        }
    }

    fun mapPremieresDtoToPremieres(premieresDto: MediaDetailsPremieresDto?): MediaDetailsPremieres? {
        val worldPremiere = premieresDto?.world?.takeIf { it.isNotBlank() }?.let {
            Instant.parse(it).toLocalDateTime(TimeZone.UTC).date
        }
        val russiaPremiere = premieresDto?.russia?.takeIf { it.isNotBlank() }?.let {
            Instant.parse(it).toLocalDateTime(TimeZone.UTC).date
        }
        return if (worldPremiere == null && russiaPremiere == null) {
            null
        } else {
            MediaDetailsPremieres(
                world = worldPremiere,
                russia = russiaPremiere
            )
        }
    }
}
