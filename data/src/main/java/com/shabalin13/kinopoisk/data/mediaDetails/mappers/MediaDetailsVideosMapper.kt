package com.shabalin13.kinopoisk.data.mediaDetails.mappers

import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsVideoDto
import com.shabalin13.kinopoisk.data.mediaDetails.remote.dtos.MediaDetailsVideosDto
import com.shabalin13.kinopoisk.domain.mediaDetails.models.MediaDetailsVideo

internal class MediaDetailsVideosMapper {
    private fun mapVideoDtoToVideo(videoDto: MediaDetailsVideoDto): MediaDetailsVideo? {
        val name = videoDto.name?.takeIf { it.isNotBlank() }
        val url = videoDto.url?.takeIf { it.isNotBlank() }
        val isYouTube = videoDto.site?.equals("youtube", ignoreCase = true) == true
        val videoId = if (isYouTube && url != null) {
            Regex("(?:youtube\\.com/(?:watch\\?v=|embed/)|youtu\\.be/)([a-zA-Z0-9_-]{11})")
                .find(url)?.groupValues?.get(1)
        } else {
            null
        }

        return if (name == null || url == null || videoId == null) {
            null
        } else {
            MediaDetailsVideo(
                videoUrl = url,
                posterUrl = "https://img.youtube.com/vi/$videoId/hqdefault.jpg",
                name = name
            )
        }
    }

    fun mapVideosDtoToVideos(videosDto: MediaDetailsVideosDto?): List<MediaDetailsVideo> {
        val trailers =
            videosDto?.trailers?.mapNotNull(::mapVideoDtoToVideo) ?: emptyList()
        val teasers =
            videosDto?.teasers?.mapNotNull(::mapVideoDtoToVideo) ?: emptyList()
        return trailers + teasers
    }
}
