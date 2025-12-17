package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemBudget
import com.shabalin13.kinopoisk.network.dto.MediaItemBudgetDto
import javax.inject.Inject

@DataScope
internal class MediaItemBudgetMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemBudgetDto): MediaItemBudget? {
        val value = dto.value?.takeIf { it >= 1 }
        val currency = dto.currency?.takeIf { it.isNotBlank() }
        return if (value != null && currency != null) {
            MediaItemBudget(value, currency)
        } else {
            null
        }
    }
}
