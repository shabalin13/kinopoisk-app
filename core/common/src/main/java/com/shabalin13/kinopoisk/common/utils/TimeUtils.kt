package com.shabalin13.kinopoisk.common.utils

object TimeUtils {
    @Suppress("MagicNumber")
    fun splitToHoursAndMinutes(totalMinutes: Int): Pair<Int, Int> {
        val hours = totalMinutes / 60
        val minutes = totalMinutes % 60
        return hours to minutes
    }
}
