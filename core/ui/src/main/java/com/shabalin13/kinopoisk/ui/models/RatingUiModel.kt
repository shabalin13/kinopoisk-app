package com.shabalin13.kinopoisk.ui.models

import androidx.compose.ui.graphics.Color
import com.shabalin13.kinopoisk.ui.theme.RatingColors
import java.util.Locale

data class RatingUiModel(
    val value: String,
    val color: Color,
) {
    companion object {
        fun from(rating: Double): RatingUiModel {
            val color = when {
                rating > HIGH_RATING_THRESHOLD -> RatingColors.high
                rating in MEDIUM_RATING_THRESHOLD..HIGH_RATING_THRESHOLD -> RatingColors.medium
                else -> RatingColors.low
            }
            return RatingUiModel(
                value = String.format(Locale.US, "%.1f", rating),
                color = color
            )
        }

        private const val HIGH_RATING_THRESHOLD = 7.0
        private const val MEDIUM_RATING_THRESHOLD = 5.0
    }
}
