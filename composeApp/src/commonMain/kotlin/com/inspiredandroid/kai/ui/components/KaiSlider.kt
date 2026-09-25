
                colors = kaiSliderTrackColors(),
                drawStopIndicator = null,
                drawTick = { _, _ -> },
                rangeSliderState = rangeSliderState,
                sliderState = sliderState,
            )
            .background(MaterialTheme.colorScheme.primary, CircleShape),
            .size(20.dp)
            SliderDefaults.Track(
        colors = kaiSliderColors(),
        endThumb = { KaiSliderThumb() },
        modifier = Modifier
        modifier = modifier.handCursor(),
        onValueChange = onValueChange,
        onValueChangeFinished = onValueChangeFinished,
        startThumb = { KaiSliderThumb() },
        steps = steps,
        thumb = { KaiSliderThumb() },
        track = { rangeSliderState ->
        track = { sliderState ->
        value = value,
        valueRange = valueRange,
        },
    )
    Box(
    RangeSlider(
    Slider(
    activeTickColor = Color.Transparent,
    activeTrackColor = MaterialTheme.colorScheme.primary,
    inactiveTickColor = Color.Transparent,
    inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
    modifier: Modifier = Modifier,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    onValueChange: (Float) -> Unit,
    onValueChangeFinished: (() -> Unit)? = null,
    steps: Int = 0,
    thumbColor = MaterialTheme.colorScheme.primary,
    value: ClosedFloatingPointRange<Float>,
    value: Float,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
)
) {
@Composable
@file:OptIn(ExperimentalMaterial3Api::class)
fun KaiRangeSlider(
fun KaiSlider(
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
package com.inspiredandroid.kai.ui.components
private fun KaiSliderThumb() {
private fun kaiSliderColors() = SliderDefaults.colors(
private fun kaiSliderTrackColors() = SliderDefaults.colors(
}
