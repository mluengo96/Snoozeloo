package com.mluengo.snoozeloo.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val fontStyle52Medium by lazy {
    TextStyle(
        fontSize = 52.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 63.39.sp,
        fontFamily = MontserratFontFamily,
        color = primary,
    )
}

val fontStyle16SemiBold by lazy {
    TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 19.5.sp,
        fontFamily = MontserratFontFamily,
    )
}