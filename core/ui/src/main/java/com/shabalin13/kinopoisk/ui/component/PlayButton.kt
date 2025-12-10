package com.shabalin13.kinopoisk.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shabalin13.kinopoisk.ui.R
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme

@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(42.dp)
            .background(
                color = Color.Gray.copy(alpha = 0.7f),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.core_play_icon),
            contentDescription = stringResource(R.string.play_button_content_description),
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlayButtonPreview() {
    KinopoiskTheme {
        Surface {
            PlayButton()
        }
    }
}
