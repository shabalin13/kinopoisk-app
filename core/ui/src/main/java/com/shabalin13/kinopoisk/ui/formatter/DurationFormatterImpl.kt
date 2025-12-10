package com.shabalin13.kinopoisk.ui.formatter

import com.shabalin13.kinopoisk.common.utils.TimeUtils
import com.shabalin13.kinopoisk.ui.R
import com.shabalin13.kinopoisk.ui.resource.ResourceProvider
import javax.inject.Inject

class DurationFormatterImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
) : DurationFormatter {
    override fun formatMediaDuration(duration: Int): String {
        val (hours, minutes) = TimeUtils.splitToHoursAndMinutes(duration)
        return buildList {
            if (hours > 0) add(resourceProvider.getString(R.string.duration_hours_short, hours))
            if (minutes > 0 || hours == 0) {
                add(resourceProvider.getString(R.string.duration_minutes_short, minutes))
            }
        }.joinToString(" ")
    }
}
