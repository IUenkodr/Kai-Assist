package com.inspiredandroid.kai.ui.components
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

            hoverColor = onSurface.copy(alpha = 0.5f),
            hoverDurationMillis = 300,
            minimalHeight = 48.dp,
            shape = RoundedCornerShape(4.dp),
            thickness = 8.dp,
            unhoverColor = onSurface.copy(alpha = 0.3f),
        )
        ScrollbarStyle(
        adapter = rememberScrollbarAdapter(gridState),
        adapter = rememberScrollbarAdapter(listState),
        adapter = rememberScrollbarAdapter(scrollState),
        modifier = modifier,
        style = scrollbarStyle(),
    )
    VerticalScrollbar(
    gridState: LazyGridState,
    listState: LazyListState,
    modifier: Modifier,
    return remember(onSurface) {
    scrollState: ScrollState,
    val onSurface = MaterialTheme.colorScheme.onSurface
    }
) {
@Composable
actual fun VerticalScrollbarForGrid(
actual fun VerticalScrollbarForList(
actual fun VerticalScrollbarForScroll(
private fun scrollbarStyle(): ScrollbarStyle {
}
