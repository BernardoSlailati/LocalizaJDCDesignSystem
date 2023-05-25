package com.localiza.jdc.designsystem.ui_components.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val LocalizaBorderRadius = compositionLocalOf { BorderRadius() }
val LocalizaBorderWidths = compositionLocalOf { BorderWidth() }

data class BorderRadius(
    val none: Dp = 0.dp,
    val ssm: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 16.dp,
    val lg: Dp = 16.dp,
    val pill: Dp = 500.dp,
) {
    fun circular(size: Dp): Dp = size
}

data class BorderWidth(
    val none: Dp = 0.dp,
    val hairline: Dp = 1.dp,
    val thin: Dp = 2.dp,
    val thick: Dp = 4.dp,
    val heavy: Dp = 8.dp,
)