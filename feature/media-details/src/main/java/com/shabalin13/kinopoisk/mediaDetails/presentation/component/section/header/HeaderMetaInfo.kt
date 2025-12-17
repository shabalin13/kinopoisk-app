package com.shabalin13.kinopoisk.mediaDetails.presentation.component.section.header

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.shabalin13.kinopoisk.mediaDetails.presentation.model.MetaInfoUiModel
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
internal fun HeaderMetaInfo(
    metaInfo: MetaInfoUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacings.small)
    ) {
        metaInfo.alternativeName?.let { alternativeName ->
            Text(
                text = alternativeName,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
            )
        }

        metaInfo.summary?.let { summary ->
            Text(
                text = summary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderMetaInfoPreview() {
    KinopoiskTheme {
        Surface {
            HeaderMetaInfo(
                metaInfo = MetaInfoUiModel(
                    alternativeName = "Harry Potter and the Sorcerer's Stone",
                    summary = "2001, фэнтэзи, приключения, детектив, триллер, боевик, ужасы" +
                        "\nВеликобритания, США, Россия, Уругвай, Китая, Австралия, 2 ч 32 мин, 12+",
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderMetaInfoPreview2() {
    KinopoiskTheme {
        Surface {
            HeaderMetaInfo(
                metaInfo = MetaInfoUiModel(
                    summary = "2001, фэнтэзи, приключения, детектив, триллер, боевик, ужасы" +
                        "\nВеликобритания, США, Россия, Уругвай, Китая, Австралия, 2 ч 32 мин, 12+",
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun HeaderMetaInfoPreview3() {
    KinopoiskTheme {
        Surface {
            HeaderMetaInfo(
                metaInfo = MetaInfoUiModel(
                    alternativeName = "Harry Potter and the Sorcerer's Stone",
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
