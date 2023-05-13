package com.localiza.jdc.designsystem.ui_components.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalizaSpacings = compositionLocalOf { Spacing() }

data class Spacing(
    val quarck: Dp = 4.dp,
    val nano: Dp = 8.dp,
    val xxxs: Dp = 16.dp,
    val xxs: Dp = 24.dp,
    val xs: Dp = 32.dp,
    val sm: Dp = 40.dp,
    val md: Dp = 48.dp,
    val lg: Dp = 56.dp,
    val xl: Dp = 64.dp,
    val xxl: Dp = 256.dp,
    val xxxl: Dp = 256.dp,
    val huge: Dp = 256.dp,
    val giant: Dp = 256.dp,
)