package com.shabalin13.kinopoisk.mediaDetails.presentation.components.sections.helpers

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
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
import com.shabalin13.kinopoisk.mediaDetails.presentation.models.PersonInfoUiModel
import com.shabalin13.kinopoisk.mediaDetails.presentation.theme.MediaDetailsDimens
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Paddings
import com.shabalin13.kinopoisk.ui.theme.Spacings

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun MediaDetailsPersonCard(
    personInfo: PersonInfoUiModel,
    onCardClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .clickable(
                indication = ripple(),
                interactionSource = null,
                onClick = { onCardClick(personInfo.id) }
            )
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(Spacings.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = personInfo.photoUrl,
            contentDescription = personInfo.name,
            contentScale = ContentScale.Crop,
            loading = placeholder(R.drawable.media_details_person_photo_placeholder),
            failure = placeholder(R.drawable.media_details_person_photo_placeholder),
            transition = CrossFade,
            modifier = Modifier
                .width(MediaDetailsDimens.PersonCard.PersonPhoto.width)
                .height(MediaDetailsDimens.PersonCard.PersonPhoto.height)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(Spacings.small),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = personInfo.name,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge
            )

            personInfo.additionalInfo?.let { additionalInfo ->
                Text(
                    text = additionalInfo,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MediaDetailsPersonCardPreview() {
    KinopoiskTheme {
        Surface {
            MediaDetailsPersonCard(
                personInfo = PersonInfoUiModel(
                    id = 40778,
                    name = "Дэниэл Рэдклифф",
                    photoUrl = "https://st.kp.yandex.net/images/actor_iphone/iphone360_40778.jpg",
                    additionalInfo = "Harry Potter"
                ),
                onCardClick = { println("Person #$it card clicked") },
                modifier = Modifier
                    .padding(horizontal = Paddings.medium, vertical = Paddings.small)
                    .width(MediaDetailsDimens.PersonCard.width)
                    .height(MediaDetailsDimens.PersonCard.height)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun MediaDetailsPersonCardPreview2() {
    KinopoiskTheme {
        Surface {
            MediaDetailsPersonCard(
                personInfo = PersonInfoUiModel(
                    id = 40778,
                    name = "Дэниэл Рэдклифф",
                ),
                onCardClick = { println("Person #$it card clicked") },
                modifier = Modifier
                    .padding(horizontal = Paddings.medium, vertical = Paddings.small)
                    .width(MediaDetailsDimens.PersonCard.width)
                    .height(MediaDetailsDimens.PersonCard.height)
            )
        }
    }
}
