package com.shabalin13.kinopoisk.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shabalin13.kinopoisk.ui.R

val InterFont = FontFamily(
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_thin_italic, FontWeight.Thin, style = FontStyle.Italic),

    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_extra_light_italic, FontWeight.ExtraLight, style = FontStyle.Italic),

    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_light_italic, FontWeight.Light, style = FontStyle.Italic),

    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_italic, FontWeight.Normal, style = FontStyle.Italic),

    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_medium_italic, FontWeight.Medium, style = FontStyle.Italic),

    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_semi_bold_italic, FontWeight.SemiBold, style = FontStyle.Italic),

    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_bold_italic, FontWeight.Bold, style = FontStyle.Italic),

    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
    Font(R.font.inter_extra_bold_italic, FontWeight.ExtraBold, style = FontStyle.Italic),

    Font(R.font.inter_black, FontWeight.Black),
    Font(R.font.inter_black_italic, FontWeight.Black, style = FontStyle.Italic),
)

val KinopoiskTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Black,
        lineHeight = 64.sp,
        fontSize = 57.sp
    ),
    displayMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Black,
        lineHeight = 46.sp,
        fontSize = 38.sp
    ),
    displaySmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Black,
        lineHeight = 40.sp,
        fontSize = 32.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Black,
        lineHeight = 28.sp,
        fontSize = 20.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.ExtraBold,
        lineHeight = 25.sp,
        fontSize = 18.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.ExtraBold,
        lineHeight = 22.sp,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 15.sp,
        fontSize = 12.sp
    ),
    titleSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 14.sp,
        fontSize = 11.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 15.sp,
        fontSize = 12.sp
    ),
    bodySmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Normal,
        lineHeight = 14.sp,
        fontSize = 11.sp
    ),
    labelLarge = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.sp,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = InterFont,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.sp,
        fontSize = 11.sp
    )
)
