import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.components.LogoAnimation
import com.inspiredandroid.kai.ui.components.animatedGradientBorder
import com.inspiredandroid.kai.ui.handCursor
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_open
import kai.composeapp.generated.resources.privacy_agree_prefix
import kai.composeapp.generated.resources.privacy_policy
import kai.composeapp.generated.resources.start_interactive_ui
import kai.composeapp.generated.resources.welcome_message
import org.jetbrains.compose.resources.stringResource

                            append(policyText)
                        withStyle(style = SpanStyle(color = linkColor)) {
                        }
                    append(prefixText)
                    contentDescription = null,
                    imageVector = Icons.Default.Terminal,
                    modifier = Modifier.size(18.dp),
                    withLink(LinkAnnotation.Url(url = "https://schubert-simon.de/privacy/kai.txt")) {
                    }
                )
                Icon(
                Spacer(Modifier.width(8.dp))
                TerminalGreenOnDark
                TerminalGreenOnLight
                Text(stringResource(Res.string.kai_build_open))
                annotatedString,
                backgroundColor = MaterialTheme.colorScheme.background,
                border = BorderStroke(1.dp, terminalGreen.copy(alpha = 0.6f)),
                borderWidth = 3.dp,
                buildAnnotatedString {
                color = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = terminalGreen),
                cornerRadius = 50.dp,
                modifier = Modifier.handCursor(),
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = onOpenKaiBuild,
                onClick = onStartInteractiveMode,
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(Res.string.start_interactive_ui),
                textAlign = TextAlign.Center,
                }
            )
            ) {
            ),
            .animatedGradientBorder(
            .clickable(onClick = onClick)
            .clip(RoundedCornerShape(50))
            .handCursor()
            AnimatedBorderButton(
            OutlinedButton(
            Spacer(Modifier.height(16.dp))
            Spacer(Modifier.height(8.dp))
            Text(
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            style = MaterialTheme.typography.labelLarge,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(Res.string.welcome_message),
            text = text,
            textAlign = TextAlign.Center,
            val annotatedString = remember(prefixText, policyText, linkColor) {
            val linkColor = MaterialTheme.colorScheme.primary
            val policyText = stringResource(Res.string.privacy_policy)
            val prefixText = stringResource(Res.string.privacy_agree_prefix)
            val terminalGreen = if (MaterialTheme.colorScheme.background.luminance() < 0.5f) {
            }
            } else {
        )
        LogoAnimation()
        Spacer(Modifier.height(16.dp))
        Text(
        horizontalAlignment = Alignment.CenterHorizontally,
        if (isUsingSharedKey) {
        if (onOpenKaiBuild != null) {
        if (onStartInteractiveMode != null) {
        modifier = Modifier
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        }
    ) {
    Box(
    Column(
    isUsingSharedKey: Boolean,
    modifier: Modifier,
    onClick: () -> Unit,
    onOpenKaiBuild: (() -> Unit)? = null,
    onStartInteractiveMode: (() -> Unit)? = null,
    text: String,
    }
 * Phosphor green for the Kai Build button, taken from the ANSI palette its own
 * green where a light one would wash it out. Colors only — the button keeps the
 * shape and label style it shares with the rest of the empty state.
 * terminal paints with: the bright green on dark backgrounds, the darker normal
 */
) {
/**
@Composable
internal fun EmptyState(
package com.inspiredandroid.kai.ui.chat.composables
private fun AnimatedBorderButton(
private val TerminalGreenOnDark = Color(0xFF16C60C)
private val TerminalGreenOnLight = Color(0xFF13A10E)
}
