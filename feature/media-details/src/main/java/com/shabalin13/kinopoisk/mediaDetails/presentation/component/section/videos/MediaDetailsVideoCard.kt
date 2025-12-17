package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.videos

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.shabalin13.kinopoisk.mediaDetails.R
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.VideoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.component.PlayButton
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Spacings

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun MediaDetailsVideoCard(
    video: VideoUiModel,
    onCardClick: (videoUrl: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = { onCardClick(video.videoUrl) }
            )
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(Spacings.small)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            GlideImage(
                model = video.posterUrl,
                contentDescription = video.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        indication = ripple(),
                        interactionSource = interactionSource,
                        onClick = { onCardClick(video.videoUrl) }
                    ),
                contentScale = ContentScale.Crop,
                loading = placeholder(R.drawable.media_details_video_poster_placeholder),
                failure = placeholder(R.drawable.media_details_video_poster_placeholder),
                transition = CrossFade
            )

            PlayButton(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = video.name,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsVideoCardPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsVideoCard(
                video = VideoUiModel(
                    videoUrl = "https://www.youtube.com/embed/ly3tLiu-bmc",
                    posterUrl = "https://img.youtube.com/vi/ly3tLiu-bmc/hqdefault.jpg",
                    name = "Гарри Поттер и философский камень"
                ),
                onCardClick = { println("Card clicked") },
                modifier = Modifier
                    .width(MediaDetailsDimens.VideoCard.width)
                    .height(MediaDetailsDimens.VideoCard.height)
            )
        }
    }
}
