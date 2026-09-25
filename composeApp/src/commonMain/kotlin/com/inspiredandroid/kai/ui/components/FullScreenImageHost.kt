package com.inspiredandroid.kai.ui.components
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import com.inspiredandroid.kai.PlatformBackHandler
import com.inspiredandroid.kai.ui.chat.composables.FullScreenImageViewerOverlay

            FullScreenImageViewerOverlay(bitmap = bmp, onDismiss = dismiss)
            PlatformBackHandler(enabled = true, onBack = dismiss)
            content()
        CompositionLocalProvider(LocalShowFullScreenImage provides show) {
        image?.let { bmp ->
        }
    Box(Modifier.fillMaxSize()) {
    val dismiss = remember { { image = null } }
    val show = remember { { bitmap: ImageBitmap -> image = bitmap } }
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    }
@Composable
fun FullScreenImageHost(content: @Composable () -> Unit) {
val LocalShowFullScreenImage = staticCompositionLocalOf<(ImageBitmap) -> Unit> { { } }
}
