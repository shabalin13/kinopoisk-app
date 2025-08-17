package com.shabalin13.kinopoisk.mediaDetails.presentation.theme

import androidx.compose.ui.unit.dp

internal object MediaDetailsDimens {
    object Poster {
        val height = 315.dp
        val width = 210.dp
    }

    object SectionHeader {
        val height = 50.dp
    }

    object VideoCard {
        val height = 180.dp
        val width = 250.dp
    }

    object PersonCard {
        val height = 105.dp
        val width = 235.dp

        object PersonPhoto {
            val height = PersonCard.height
            val width = 70.dp
        }
    }
}
