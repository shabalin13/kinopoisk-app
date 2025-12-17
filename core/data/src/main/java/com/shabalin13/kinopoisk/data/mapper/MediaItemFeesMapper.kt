package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemFees
import com.shabalin13.kinopoisk.network.dto.MediaItemFeesDto
import javax.inject.Inject

@DataScope
internal class MediaItemFeesMapper @Inject constructor(
    private val feeMapper: MediaItemFeeMapper,
) {
    fun mapDtoToDomain(dto: MediaItemFeesDto): MediaItemFees? {
        val worldFee = dto.world?.let { feeMapper.mapDtoToDomain(it) }
        val russiaFee = dto.russia?.let { feeMapper.mapDtoToDomain(it) }
        val usaFee = dto.usa?.let { feeMapper.mapDtoToDomain(it) }

        return if (worldFee == null && russiaFee == null && usaFee == null) {
            null
        } else {
            MediaItemFees(
                world = worldFee,
                russia = russiaFee,
                usa = usaFee
            )
        }
    }
}
