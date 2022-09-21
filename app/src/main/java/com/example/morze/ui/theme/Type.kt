package com.example.morze.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.morze.R

val geomanistFamily = FontFamily(
    Font(R.font.geomanist_regular, weight = FontWeight.Normal),
    Font(R.font.geomanist_medium, weight = FontWeight.Medium)
)

val larkenFamily = FontFamily(
    Font(R.font.larken_regular, weight = FontWeight.Normal),
    Font(R.font.larken_extra_bold, weight = FontWeight.Bold)
)

val Typography = Typography(
    // Headline 1
    h1 = TextStyle(
        fontFamily = larkenFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 0.01.em,
        lineHeight = 34.sp
    ),

    // Headline 2
    h2 = TextStyle(
        fontFamily = larkenFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.02.em,
        lineHeight = 28.sp
    ),

    // Headline 3
    h3 = TextStyle(
        fontFamily = larkenFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.02.em,
        lineHeight = 24.sp
    ),

    // Headline 4
    h4 = TextStyle(
        fontFamily = larkenFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (-0.02).em,
        lineHeight = 22.sp
    ),

    // Headline 5
    h5 = TextStyle(
        fontFamily = geomanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = (-0.02).em,
        lineHeight = 20.sp
    ),

    // Paragraph 1
    body1 = TextStyle(
        fontFamily = geomanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = (-0.02).em,
        lineHeight = 28.sp
    ),

    // Paragraph 2
    body2 = TextStyle(
        fontFamily = geomanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (-0.02).em,
        lineHeight = 23.8.sp
    ),

    // Caption 1
    caption = TextStyle(
        fontFamily = geomanistFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    // Default button text style
    button = TextStyle(
        fontFamily = geomanistFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        letterSpacing = 0.01.em,
        lineHeight = 22.sp
    )
)

// Headline L
val Typography.headlineL get() = TextStyle(
    fontFamily = larkenFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 34.sp,
    letterSpacing = 0.01.em,
    lineHeight = 41.sp
)

// Paragraph 3
val Typography.body3 get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp,
    letterSpacing = (-0.03).em,
    lineHeight = 21.sp
)
// textInput Large
val Typography.textInputL get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 28.sp
)

// Callout
val Typography.callout get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    letterSpacing = (-0.02).em,
    lineHeight = 21.sp
)

// Footnotes
val Typography.footnotes get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp,
    letterSpacing = (-0.01).em,
    lineHeight = 18.sp
)

// Footnotes 2
val Typography.footnotes2 get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.07.em,
    lineHeight = 20.sp
)

// Caption 2
val Typography.caption2 get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 11.sp,
    letterSpacing = 0.01.em,
    lineHeight = 13.sp
)

// header 2
val Typography.headerText get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 17.sp,
    letterSpacing = 0.05.em,
    lineHeight = 22.sp
)
val Typography.titleText get() = TextStyle(
    fontFamily = larkenFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 34.sp,
    color = Color.Black,
    letterSpacing = 0.01.em,
    lineHeight = 28.sp
)
// header 3
val Typography.headerTextWhite get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
    letterSpacing = 0.05.em,
    lineHeight = 24.sp,
    color = Color.White,
    textAlign = TextAlign.Center
)

// header 4
val Typography.headerXL get() = TextStyle(
    fontFamily = larkenFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 40.sp,
    lineHeight = 44.sp,
    letterSpacing = 0.36.sp,
    textAlign = TextAlign.Center
)

// header 5
val Typography.headerM get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    letterSpacing = 0.15.sp,
    lineHeight = 28.sp
)

// text 3
val Typography.textCenterAlign get() = TextStyle(
    fontFamily = geomanistFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    textAlign = TextAlign.Center
)