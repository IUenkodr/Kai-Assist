package com.inspiredandroid.kai.ui.components
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.gradientMagenta
import com.inspiredandroid.kai.ui.gradientPurple
import com.inspiredandroid.kai.ui.gradientViolet

                brush = Brush.sweepGradient(colorStops = colorStops),
                colA = colB
                colB = colC
                colB = tc
                colC = tc
                cornerRadius = cr,
                drawRoundRect(color = backgroundColor, cornerRadius = cr)
                posA = posB
                posB = posC
                posB = tp
                posC = tp
                style = strokeStyle,
                val tc = colA
                val tc = colB
                val tp = posA
                val tp = posB
            )
            // Boundary color so the wrap-around at 0 and 1 matches seamlessly.
            // Shift the three base stops by `progress`, wrap into [0,1), then
            // sort ascending. Three comparisons ≪ the previous list map+sort.
            0f to Color.Transparent,
            0f to gradientMagenta,
            0f to gradientPurple,
            0f to gradientViolet,
            1f to Color.Transparent,
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            colorStops[0] = 0f to boundary
            colorStops[1] = posA to colA
            colorStops[2] = posB to colB
            colorStops[3] = posC to colC
            colorStops[4] = 1f to boundary
            drawContent()
            drawRoundRect(
            if (backgroundColor != null) {
            if (posA > posB) {
            if (posB > posC) {
            val boundary = lerp(colC, colA, t)
            val p = progress
            val t = if (wrapDist > 0f) (1f - posC) / wrapDist else 0f
            val wrapDist = 1f - posC + posA
            var colA = gradientPurple
            var colB = gradientViolet
            var colC = gradientMagenta
            var posA = (STOP_A - p + 1f) % 1f
            var posB = (STOP_B - p + 1f) % 1f
            var posC = (STOP_C - p + 1f) % 1f
            }
        )
        ),
        animationSpec = infiniteRepeatable(
        arrayOf(
        initialValue = 0f,
        onDrawWithContent {
        targetValue = 1f,
        val borderPx = borderWidth.toPx()
        val cr = CornerRadius(cornerRadius.toPx())
        val strokeStyle = Stroke(width = borderPx)
        }
    )
    // Reuse the same color-stops array across frames; only the pair positions
    // are mutated per frame so no allocations happen in the animated draw loop.
    backgroundColor: Color? = null,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp,
    return this.drawWithCache {
    val colorStops = remember {
    val infiniteTransition = rememberInfiniteTransition()
    val progress by infiniteTransition.animateFloat(
    }
): Modifier {
@Composable
fun Modifier.animatedGradientBorder(
private const val STOP_A = 0f
private const val STOP_B = 0.33f
private const val STOP_C = 0.66f
}
