package com.inspiredandroid.kai.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

fun Modifier.glassSurface(
    shape: Shape = RoundedCornerShape(16.dp),
    alpha: Float = 0.8f
): Modifier = this.background(
    color = Color.White.copy(alpha = 0.08f * alpha),
    shape = shape
)
