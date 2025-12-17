package com.shabalin13.kinopoisk.mediaDetails.presentation.theme

import androidx.compose.ui.unit.dp

internal object MediaDetailsDimens {
    object HeaderPoster {
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

    object FactsSection {
        object NoteCard {
            val height = 180.dp
            val width = 300.dp
        }

        object ShowAllCard {
            val width = 150.dp
        }
    }

    object BloopersSection {
        object NoteCard {
            val height = 180.dp
            val width = 300.dp
        }

        object ShowAllCard {
            val width = 150.dp
        }
    }

    object RelatedMediaItemCard {
        val height = 280.dp
        val width = 140.dp

        object Poster {
            val height = 210.dp
            val width = RelatedMediaItemCard.width
        }
    }
}
