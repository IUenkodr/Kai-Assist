
                    Res.string.kai_build_terminal_input_mode_content_description,
                    contentDescription = stringResource(description),
                    enabled = enabled,
                    icon = icon,
                    onClick = { onKey(key) },
                )
                ),
                // A mode switch, not a key: it works on a session that has ended too.
                // Shows where the tap leads, not where the terminal is now.
                IconKeyCap(
                active = latched.alt,
                active = latched.ctrl,
                active = latched.shift,
                contentDescription = stringResource(
                enabled = enabled,
                enabled = true,
                icon = if (rawInput) Icons.Default.Edit else Icons.Default.Terminal,
                label = "alt",
                label = "ctrl",
                label = "shift",
                onClick = toggle,
                onClick = { onLatchChange(latched.copy(alt = !latched.alt)) },
                onClick = { onLatchChange(latched.copy(ctrl = !latched.ctrl)) },
                onClick = { onLatchChange(latched.copy(shift = !latched.shift)) },
            )
            .background(Color(0xFF151515))
            .background(Color.White.copy(alpha = 0.10f)),
            .background(container)
            .clickable(enabled = enabled, onClick = onClick)
            .clip(KeyCapShape)
            .defaultMinSize(minWidth = minWidth)
            .fillMaxWidth()
            .handCursor()
            .height(18.dp)
            .height(KeyCapHeight)
            .padding(horizontal = 8.dp),
            .padding(horizontal = 8.dp, vertical = 6.dp),
            .width(1.dp)
            // Clip before the ripple so pressing a cap lights up the cap, not its bounding box.
            // English key names on purpose — not localized. Shells, agent CLIs, and
            // docs all say Ctrl/Esc/Tab/Alt/Shift; matching that beats OS keycap
            // labels (e.g. German Strg) which would disagree with every prompt.
            ArrowCaps.forEach { (key, icon, description) ->
            IconKeyCap(
            KeyCap(
            KeyCap(label = "esc", enabled = enabled, onClick = { onKey(TerminalKey.Escape) })
            KeyCap(label = "tab", enabled = enabled, onClick = { onKey(TerminalKey.Tab) })
            KeyGroupSeparator()
            accent = true,
            contentDescription = contentDescription,
            contentDescription = stringResource(Res.string.kai_build_terminal_key_enter_content_description),
            enabled = enabled,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            icon = TerminalEnter,
            iconSize = TerminalEnterIconSize,
            imageVector = icon,
            minWidth = EnterKeyCapMinWidth,
            modifier = Modifier.size(iconSize),
            modifier = Modifier.weight(1f).horizontalScroll(rememberScrollState()),
            onClick = { onKey(TerminalKey.Enter) },
            tint = tint,
            verticalAlignment = Alignment.CenterVertically,
            }
        !enabled -> AnsiPalette[8]
        )
        ) {
        // Enter is a filled key, so its glyph is the bright thing on the fill,
        // not a green line on grey — that read as decoration rather than a key.
        Icon(
        IconKeyCap(
        Row(
        Text(text = label, style = monoStyle(KeyCapFontSize, tint))
        accent && enabled -> AnsiPalette[10].copy(alpha = 0.25f)
        accent -> AnsiPalette[15]
        accent = accent,
        active -> AnsiPalette[10]
        active -> AnsiPalette[10].copy(alpha = 0.22f)
        content(tint)
        contentAlignment = Alignment.Center,
        else -> AnsiPalette[7]
        else -> Color(0xFF262626)
        enabled = enabled,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        minWidth = minWidth,
        modifier = modifier
        modifier = modifier,
        onClick = onClick,
        onToggleInputMode?.let { toggle ->
        verticalAlignment = Alignment.CenterVertically,
        }
    )
    ) {
    ) { tint ->
    Box(
    KeyCapSurface(
    KeyCapSurface(enabled = enabled, onClick = onClick, modifier = modifier, active = active) { tint ->
    Row(
    Triple(TerminalKey.Down, TerminalArrowDown, Res.string.kai_build_terminal_key_down_content_description),
    Triple(TerminalKey.Left, TerminalArrowLeft, Res.string.kai_build_terminal_key_left_content_description),
    Triple(TerminalKey.Right, TerminalArrowRight, Res.string.kai_build_terminal_key_right_content_description),
    Triple(TerminalKey.Up, TerminalArrowUp, Res.string.kai_build_terminal_key_up_content_description),
    accent: Boolean = false,
    active: Boolean = false,
    content: @Composable (tint: Color) -> Unit,
    contentDescription: String,
    enabled: Boolean,
    icon: ImageVector,
    iconSize: Dp = TerminalKeyIconSize,
    label: String,
    latched: TerminalModifiers,
    minWidth: Dp = IconKeyCapMinWidth,
    minWidth: Dp = KeyCapMinWidth,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onKey: (TerminalKey) -> Unit,
    onLatchChange: (TerminalModifiers) -> Unit,
    onToggleInputMode: (() -> Unit)? = null,
    rawInput: Boolean = false,
    val container = when {
    val tint = when {
    }
 *
 * A hairline between groups gives a thumb a landmark to aim at.
 * Eleven caps are wider than a phone, so the row scrolls — which makes the
 * The input-mode cap is pinned next to Enter rather than left in the input bar,
 * The keys no soft keyboard has. Ctrl/Alt/Shift latch for exactly one press —
 * The latch is owned by the caller so it also applies to characters typed on
 * because that bar is hidden exactly when the switch is wanted most: while the
 * modifiers that have no physical key to hold down.
 * offers them at all; Alt and Shift trail. Enter is pinned outside the scroll,
 * order a ranking. Ctrl, Esc, Tab and the arrows lead because no soft keyboard
 * so the key that ends every command is never the one that has to be found.
 * soft keyboard is up in keyboard mode. [onToggleInputMode] is null on platforms
 * tap Ctrl then C to interrupt — which is how every mobile terminal handles
 * that only have line input, where there is nothing to switch between.
 * the soft keyboard, not just to presses from this row.
 */
)
) {
/**
/** Enter is the row's action key and gets the width to say so. */
/** Icon caps hold one glyph, so they can be squarer than the lettered ones. */
/** Navigation caps, in the order a keyboard lays them out. */
/** The cap itself: colors for the three states, and the tint its content draws with. */
@Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inspiredandroid.kai.build.terminal.TerminalKey
import com.inspiredandroid.kai.build.terminal.TerminalModifiers
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.settings.monoStyle
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.kai_build_terminal_input_mode_content_description
import kai.composeapp.generated.resources.kai_build_terminal_key_down_content_description
import kai.composeapp.generated.resources.kai_build_terminal_key_enter_content_description
import kai.composeapp.generated.resources.kai_build_terminal_key_left_content_description
import kai.composeapp.generated.resources.kai_build_terminal_key_right_content_description
import kai.composeapp.generated.resources.kai_build_terminal_key_up_content_description
import org.jetbrains.compose.resources.stringResource
internal fun TerminalKeyRow(
package com.inspiredandroid.kai.ui.build
private fun IconKeyCap(
private fun KeyCap(
private fun KeyCapSurface(
private fun KeyGroupSeparator(modifier: Modifier = Modifier) {
private val ArrowCaps = listOf(
private val EnterKeyCapMinWidth = 52.dp
private val IconKeyCapMinWidth = 38.dp
private val KeyCapFontSize = 13.sp
private val KeyCapHeight = 34.dp
private val KeyCapMinWidth = 40.dp
private val KeyCapShape = RoundedCornerShape(8.dp)
}
