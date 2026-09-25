package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.ui.handCursor
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.vectorResource

                                            onSelectService(entry.instanceId)
                                        expanded = false
                                        if (!isCurrent) {
                                        }
                                    entry = entry,
                                    isCurrent = isCurrent,
                                    onClick = {
                                    },
                                )
                                .heightIn(max = maxMenuHeight)
                                .padding(vertical = 4.dp),
                                .verticalScroll(rememberScrollState())
                                ServiceMenuItem(
                                val isCurrent = entry.instanceId == current.instanceId
                            modifier = Modifier
                            services.forEach { entry ->
                            }
                        ) {
                        Column(
                        color = MaterialTheme.colorScheme.surface,
                        shadowElevation = 8.dp,
                        shape = RoundedCornerShape(16.dp),
                        tonalElevation = 3.dp,
                        }
                    ) {
                    Surface(
                    color = subTextColor,
                    style = MaterialTheme.typography.bodySmall,
                    text = entry.modelId,
                    val maxMenuHeight = maxHeight - 24.dp // keep a margin from screen edges
                    }
                )
                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                .clickable { expanded = true }
                .clip(CircleShape)
                .handCursor(),
                .size(42.dp)
                BoxWithConstraints {
                Text(
                color = textColor,
                contentDescription = current.serviceName,
                imageVector = vectorResource(current.icon),
                modifier = Modifier.size(18.dp),
                onDismissRequest = { expanded = false },
                popupPositionProvider = remember(spacingPx) { AnchorAbovePositionProvider(spacingPx) },
                properties = PopupProperties(focusable = false),
                style = MaterialTheme.typography.bodyMedium,
                text = entry.serviceName,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                }
            (anchorBounds.bottom + verticalSpacing).coerceAtMost(maxY)
            )
            ) {
            .background(rowBackground)
            .clickable(onClick = onClick)
            .clip(RoundedCornerShape(12.dp))
            .handCursor()
            .padding(horizontal = 12.dp, vertical = 10.dp)
            .padding(horizontal = 4.dp)
            .widthIn(min = 200.dp),
            Icon(
            Popup(
            Text(
            above
            contentAlignment = Alignment.Center,
            contentDescription = null,
            if (entry.modelId.isNotEmpty()) {
            imageVector = vectorResource(entry.icon),
            modifier = Modifier
            modifier = Modifier.size(18.dp),
            tint = textColor,
            val maxY = (windowSize.height - popupContentSize.height).coerceAtLeast(0)
            val spacingPx = with(LocalDensity.current) { 8.dp.roundToPx() }
            }
        )
        ) {
        Box(
        Color.Transparent
        Column {
        Icon(
        MaterialTheme.colorScheme.onPrimaryContainer
        MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
        MaterialTheme.colorScheme.onSurface
        MaterialTheme.colorScheme.onSurfaceVariant
        MaterialTheme.colorScheme.primaryContainer
        Spacer(Modifier.width(12.dp))
        anchorBounds: IntRect,
        if (expanded) {
        layoutDirection: LayoutDirection,
        modifier = Modifier
        popupContentSize: IntSize,
        return IntOffset(x, y)
        val above = anchorBounds.top - popupContentSize.height - verticalSpacing
        val maxX = (windowSize.width - popupContentSize.width).coerceAtLeast(0)
        val x = (anchorBounds.right - popupContentSize.width).coerceIn(0, maxX)
        val y = if (above >= 0) {
        verticalAlignment = Alignment.CenterVertically,
        windowSize: IntSize,
        }
        } else {
    ) {
    ): IntOffset {
    Box {
    Row(
    entry: ServiceEntry,
    if (services.isEmpty()) return
    isCurrent: Boolean,
    onClick: () -> Unit,
    onSelectService: (String) -> Unit,
    override fun calculatePosition(
    private val verticalSpacing: Int,
    services: ImmutableList<ServiceEntry>,
    val current = services.first()
    val rowBackground = if (isCurrent) {
    val subTextColor = if (isCurrent) {
    val textColor = if (isCurrent) {
    var expanded by remember { mutableStateOf(false) }
    }
    } else {
) : PopupPositionProvider {
) {
@Composable
internal fun ServiceSelector(
private class AnchorAbovePositionProvider(
private fun ServiceMenuItem(
}
