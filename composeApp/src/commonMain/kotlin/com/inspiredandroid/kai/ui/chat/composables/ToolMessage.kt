package com.inspiredandroid.kai.ui.chat.composables
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tools_count
import kai.composeapp.generated.resources.waiting_brewing
import kai.composeapp.generated.resources.waiting_content_description
import kai.composeapp.generated.resources.waiting_thinking
import kai.composeapp.generated.resources.waiting_working
import kotlin.time.Duration.Companion.seconds
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource

                        .using(SizeTransform(clip = false) { _, _ -> tween(300) })
                    (fadeIn(tween(300)) togetherWith fadeOut(tween(300)))
                    MaterialTheme.colorScheme.surfaceVariant,
                    RoundedCornerShape(8.dp),
                    alpha = pulseAlpha
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
                    color = textColor,
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    scaleX = pulseScale
                    scaleY = pulseScale
                    style = textStyle,
                    text = " · $toolSummary",
                    text = stringResource(waitingTexts[targetIndex]),
                )
                .animateContentSize(
                .background(
                .background(dotColor, CircleShape),
                .graphicsLayer {
                .padding(12.dp)
                .semantics { contentDescription = waitingCd },
                .size(dotSize)
                // Weighted: the animated status text ahead of this takes what it needs,
                // actually doing — is pushed off the right edge at large font scales.
                // and without a weight the summary — the only hint of what the agent is
                Text(
                color = textColor,
                dotColor = MaterialTheme.colorScheme.onSurfaceVariant,
                dotSize = 16.dp,
                isStatusOnly = effectiveStatusOnly,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = textStyle,
                targetState = index,
                text = toolSummary,
                textAlign = TextAlign.Center,
                textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                textStyle = MaterialTheme.typography.bodyMedium,
                toolSummary = summary,
                transitionSpec = {
                }
                },
            )
            ) { targetIndex ->
            .clipToBounds(),
            .padding(horizontal = 16.dp, vertical = 8.dp)
            AnimatedContent(
            PulsingStatusIndicator(
            Res.string.waiting_brewing,
            Res.string.waiting_thinking,
            Res.string.waiting_working,
            Text(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            delay(3.seconds)
            if (toolSummary != null) {
            index = (index + 1) % waitingTexts.size
            modifier = Modifier
            repeatMode = RepeatMode.Reverse,
            }
        )
        ) {
        ),
        Box(
        Spacer(Modifier.width(8.dp))
        animationSpec = infiniteRepeatable(
        if (isStatusOnly && toolSummary != null) {
        initialValue = 0.4f,
        initialValue = 0.6f,
        listOf(
        modifier = Modifier
        modifier = modifier,
        targetValue = 1.0f,
        verticalAlignment = Alignment.CenterVertically,
        while (true) {
        }
        } else {
    )
    ) {
    LaunchedEffect(Unit) {
    Row(
    dotColor: Color,
    dotSize: Dp,
    else -> stringResource(Res.string.tools_count, executingTools.size)
    executingTools.isEmpty() -> null
    executingTools.size == 1 -> executingTools.first().second
    executingTools: ImmutableList<Pair<String, String>>,
    isStatusOnly: Boolean = false,
    modifier: Modifier = Modifier,
    statusText: String? = null,
    textColor: Color,
    textStyle: TextStyle,
    toolSummary: String?,
    val effectiveStatusOnly = isStatusOnly || statusText != null
    val infiniteTransition = rememberInfiniteTransition()
    val pulseAlpha by infiniteTransition.animateFloat(
    val pulseScale by infiniteTransition.animateFloat(
    val summary = statusText ?: toolSummaryText(executingTools)
    val waitingCd = stringResource(Res.string.waiting_content_description)
    val waitingTexts = remember {
    var index by remember { mutableIntStateOf(0) }
    }
) {
): String? = when {
@Composable
internal fun PulsingStatusIndicator(
internal fun WaitingResponseRow(
internal fun toolSummaryText(
}
