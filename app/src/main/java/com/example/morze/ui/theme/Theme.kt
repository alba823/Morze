package com.example.morze.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val ColorPalette = lightColors(
    primary = PineGreen,
    primaryVariant = TeaGreen,
    onPrimary = Color.White,
    background = Cultured,
    onBackground = Charcoal,
    surface = Color.White,
    onSurface = Charcoal,
    error = Tomato,
    onSecondary = DarkJungleGreen
)

@Composable
fun MorzeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}