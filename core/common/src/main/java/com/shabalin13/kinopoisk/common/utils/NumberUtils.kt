package com.shabalin13.kinopoisk.common.utils

object NumberUtils {
    @Suppress("MagicNumber")
    fun formatLongWithSpaces(number: Long): String {
        return number.toString().reversed().chunked(3).joinToString(" ").reversed()
    }
}
