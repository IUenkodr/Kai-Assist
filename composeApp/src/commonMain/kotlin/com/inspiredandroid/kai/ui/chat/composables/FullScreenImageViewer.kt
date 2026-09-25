
                                offset = Offset.Zero
                                scale = 1f
                                scale = 2.5f
                            if (scale > 1f) {
                            }
                            } else {
                        offset = if (scale > 1f) offset + pan else Offset.Zero
                        onDoubleTap = {
                        scale = (scale * zoom).coerceIn(1f, 5f)
                        },
                    )
                    detectTapGestures(
                    detectTransformGestures { _, pan, zoom, _ ->
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offset.x,
                    translationY = offset.y,
                    }
                )
                .align(Alignment.TopEnd)
                .background(Color.Black.copy(alpha = 0.4f))
                .clip(CircleShape)
                .fillMaxSize()
                .graphicsLayer(
                .handCursor(),
                .padding(8.dp)
                .pointerInput(Unit) {
                .statusBarsPadding()
                // Single-tap on the backdrop dismisses, matching the old Dialog UX.
                contentDescription = stringResource(Res.string.image_viewer_close),
                detectTapGestures(onTap = { onDismiss() })
                imageVector = Icons.Default.Close,
                tint = Color.White,
                }
                },
            )
            .background(Color.Black.copy(alpha = 0.95f))
            .fillMaxSize()
            .pointerInput(Unit) {
            Icon(
            bitmap = bitmap,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
            onClick = onDismiss,
            },
        )
        ) {
        IconButton(
        Image(
        modifier = Modifier
        }
    ) {
    Box(
    bitmap: ImageBitmap,
    onDismiss: () -> Unit,
    var offset by remember { mutableStateOf(Offset.Zero) }
    var scale by remember { mutableStateOf(1f) }
    }
 * Fullscreen image overlay. Rendered at the App root (not in a Dialog) so it
 * Use via [com.inspiredandroid.kai.ui.components.FullScreenImageHost] +
 * [com.inspiredandroid.kai.ui.components.LocalShowFullScreenImage].
 * covers the entire Activity content including status / navigation bar areas.
 */
) {
/**
@Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.image_viewer_close
import org.jetbrains.compose.resources.stringResource
internal fun FullScreenImageViewerOverlay(
package com.inspiredandroid.kai.ui.chat.composables
}
