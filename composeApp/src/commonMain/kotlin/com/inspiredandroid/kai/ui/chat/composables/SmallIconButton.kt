package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.handCursor
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

            contentDescription = contentDescription,
            imageVector = imageVector,
            modifier = Modifier.size(20.dp),
            painter = painterResource(iconResource),
            tint = MaterialTheme.colorScheme.onBackground,
        )
        Icon(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(36.dp).clip(CircleShape).handCursor().clickable { onClick() },
    ) { content() }
    Box(
    SmallIconButtonBox(onClick) {
    contentDescription: String? = null,
    iconResource: DrawableResource,
    imageVector: ImageVector,
    onClick: () -> Unit,
    }
) {
@Composable
internal fun SmallIconButton(
private fun SmallIconButtonBox(onClick: () -> Unit, content: @Composable () -> Unit) {
}
