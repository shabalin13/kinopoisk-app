package com.shabalin13.kinopoisk.data.mapper

import com.shabalin13.kinopoisk.data.di.DataScope
import com.shabalin13.kinopoisk.domain.model.MediaItemVideo
import com.shabalin13.kinopoisk.network.dto.MediaItemVideoDto
import javax.inject.Inject

@DataScope
internal class MediaItemVideoMapper @Inject constructor() {
    fun mapDtoToDomain(dto: MediaItemVideoDto): MediaItemVideo? {
        val name = dto.name?.takeIf { it.isNotBlank() }
        val url = dto.url?.takeIf { it.isNotBlank() }
        val isYouTube = dto.site?.equals("youtube", ignoreCase = true) == true
        val videoId = if (isYouTube && url != null) {
            Regex("(?:youtube\\.com/(?:watch\\?v=|embed/)|youtu\\.be/)([a-zA-Z0-9_-]{11})")
                .find(url)?.groupValues?.get(1)
        } else {
            null
        }

        return if (name == null || url == null || videoId == null) {
            null
        } else {
            MediaItemVideo(
                videoUrl = url,
                posterUrl = "https://img.youtube.com/vi/$videoId/hqdefault.jpg",
                name = name
            )
        }
    }
}
