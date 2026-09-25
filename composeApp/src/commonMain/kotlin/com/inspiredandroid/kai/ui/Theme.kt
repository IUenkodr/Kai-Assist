
    
                    .alpha(if (focused && value.isNotEmpty()) 1f else 0f),
                    Color.White.copy(alpha = 0.05f)
                    Color.White.copy(alpha = borderAlpha),
                    contentDescription = null,
                    imageVector = Icons.Default.Clear,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Icon(
                colors = listOf(
                enabled = value.isNotEmpty(),
                modifier = Modifier.handCursor()
                onClick = { onValueChange("") },
            ) {
            ),
            IconButton(
            brush = Brush.verticalGradient(
            if (isOled) Color.Black.copy(alpha = 0.5f) else Color.White.copy(alpha = alpha)
            shape = shape
            width = 1.dp,
            }
        )
        .background(
        .border(
        .clip(shape)
        brush = AI_Gradient,
        colorScheme = colorScheme,
        colors = outlineTextFieldColors(),
        content()
        enabled = enabled,
        label = label,
        maxLines = maxLines,
        minLines = minLines,
        modifier = modifier,
        modifier = modifier.fillMaxWidth().onFocusChanged { focused = it.isFocused },
        onValueChange = onValueChange,
        placeholder = placeholder,
        readOnly = readOnly,
        shape = RoundedCornerShape(16.dp),
        shape = shape
        singleLine = singleLine,
        trailingIcon = trailingIcon,
        trailingIcon = {
        value = value,
        visualTransformation = visualTransformation,
        width = 2.dp,
        },
    )
    ) {
    .border(
    .glassSurface(shape = shape)
    KaiOutlinedTextField(
    MaterialTheme(
    OutlinedTextField(
    alpha: Float = 0.15f,
    background = Color(0xFF0B0B0B),
    background = Color.Black,
    borderAlpha: Float = 0.2f
    colorScheme: ColorScheme,
    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
    content: @Composable () -> Unit,
    enabled: Boolean = true,
    focusedBorderColor = ElectricIndigo,
    focusedLabelColor = ElectricIndigo,
    label: @Composable (() -> Unit)? = null,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    modifier: Modifier = Modifier,
    onBackground = Color.White,
    onPrimary = Color.White,
    onSurface = Color.White,
    onValueChange: (String) -> Unit,
    outlineVariant = Color(0xFF333333),
    placeholder: @Composable (() -> Unit)? = null,
    primary = ElectricIndigo,
    readOnly: Boolean = false,
    return this
    shape: Shape = RoundedCornerShape(16.dp),
    singleLine: Boolean = false,
    surface = Color(0xFF121212),
    surface = Color.Black,
    surfaceVariant = Color(0xFF1E1E1E),
    surfaceVariant = Color.Black,
    trailingIcon: @Composable (() -> Unit)? = null,
    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
    val isOled = MaterialTheme.colorScheme.isOledFlavor
    value: String,
    var focused by remember { mutableStateOf(false) }
    visualTransformation: VisualTransformation = VisualTransformation.None,
    }
)
) {
): Modifier {
// --- Color Schemes ---
// --- Component Extensions ---
// --- Form Components ---
// --- Glassmorphism Modifiers ---
// --- Glassmorphism Tokens ---
// Gemini-style Accent Gradients
@Composable
@Preview
@file:Suppress("DEPRECATION")
fun ColorScheme.withBlackBackground(): ColorScheme = copy(
fun KaiClearableTextField(
fun KaiOutlinedTextField(
fun Modifier.aiAccentBorder(shape: Shape = RoundedCornerShape(16.dp)): Modifier = this
fun Modifier.glassSurface(
fun Modifier.handCursor() = pointerHoverIcon(PointerIcon.Hand, overrideDescendants = true)
fun Modifier.kaiAdaptiveCardSurface(shape: Shape = RoundedCornerShape(16.dp)): Modifier = this
fun Theme(
fun kaiAdaptiveCardColors(): CardColors = CardDefaults.cardColors(
fun outlineTextFieldColors() = OutlinedTextFieldDefaults.colors(
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
package com.inspiredandroid.kai.ui
val AI_Gradient = Brush.linearGradient(listOf(ElectricIndigo, DeepViolet, CyanAccent))
val ColorScheme.isOledFlavor: Boolean get() = background == Color.Black
val CyanAccent = Color(0xFF06B6D4)
val DarkColorScheme = darkColorScheme(
val DeepViolet = Color(0xFF8B5CF6)
val ElectricIndigo = Color(0xFF6366F1)
val GlassBorder = Color(0x4DFFFFFF)
val GlassShadow = Color(0x1A000000)
val GlassWhite = Color(0x33FFFFFF)
}
