package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemFee
import com.shabalin13.kinopoisk.network.dto.MediaItemFeeDto
import javax.inject.Inject

@DataScope
internal class MediaItemFeeMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemFeeDto): MediaItemFee? {
        val value = dto.value?.takeIf { it >= 1 }
        val currency = dto.currency?.takeIf { it.isNotBlank() }
        return if (value != null && currency != null) {
            MediaItemFee(value, currency)
        } else {
            null
        }
    }
}
