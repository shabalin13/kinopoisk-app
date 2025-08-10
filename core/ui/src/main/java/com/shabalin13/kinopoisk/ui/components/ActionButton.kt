package com.shabalin13.kinopoisk.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shabalin13.kinopoisk.ui.theme.KinopoiskTheme
import com.shabalin13.kinopoisk.ui.theme.Spacings

@Composable
fun ActionButton(
    icon: ImageVector,
    text: String,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: ImageVector = icon,
    isSelected: Boolean = false,
) {
    Column(
        modifier = Modifier
            .clickable(
                indication = ripple(),
                interactionSource = null,
                onClick = onActionClick
            )
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = if (isSelected) selectedIcon else icon,
            contentDescription = text,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(Spacings.extraSmall))

        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun ActionButtonPreview() {
    KinopoiskTheme {
        ActionButton(
            icon = Icons.Outlined.Star,
            text = "Оценить",
            onActionClick = { },
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun ActionButtonPreview2() {
    KinopoiskTheme {
        ActionButton(
            icon = Icons.Outlined.Star,
            text = "Оценить",
            onActionClick = { },
            modifier = Modifier,
            isSelected = true,
            selectedIcon = Icons.Filled.Star
        )
    }
}
