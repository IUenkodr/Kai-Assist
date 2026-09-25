import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.filled.Redo
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingFlat
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Celebration
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.filled.ThumbDown
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.ui.KaiOutlinedTextField
import com.inspiredandroid.kai.ui.components.KaiChip
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.kaiAdaptiveCardBorder
import com.inspiredandroid.kai.ui.kaiAdaptiveCardColors
import com.inspiredandroid.kai.ui.rememberCopyToClipboard
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.bot_message_copy_content_description
import kai.composeapp.generated.resources.kai_ui_code_copy
import kai.composeapp.generated.resources.kai_ui_render_failed
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource

                                        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                                        pillShape,
                                    )
                                    Modifier
                                    Modifier.background(
                                    indication = null,
                                    interactionSource = interactionSource,
                                    onClick = { formState[node.id] = option },
                                )
                                MaterialTheme.colorScheme.onSurfaceVariant
                                MaterialTheme.colorScheme.primary
                                Modifier
                                Modifier.clickable(
                                currentOnCallback(action.event, data)
                                if (isSelected) current - value else current + value
                                if (isSelected) emptySet() else setOf(value)
                                if (isSelected) {
                                toggleState[action.targetId] = !(toggleState[action.targetId] ?: true)
                                val data = collectFormData(action, formState)
                                } else {
                                },
                            )
                            .clickable { selectedIndex = index }
                            .clip(pillShape)
                            .defaultMinSize(minHeight = 32.dp)
                            .handCursor()
                            .padding(horizontal = 16.dp, vertical = 4.dp),
                            .then(
                            color = if (isSelected) {
                            csv.split(",").contains(value)
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                            formState[node.id] = newSelection.joinToString(",")
                            if (!isInteractive) return@KaiChip
                            if (isInteractive) {
                            indication = ripple(bounded = false, radius = 20.dp),
                            interactionSource = interactionSource,
                            is CallbackAction -> {
                            is CopyToClipboardAction -> {}
                            is OpenUrlAction -> {}
                            is ToggleAction -> {
                            maxLines = 1,
                            null -> {}
                            style = MaterialTheme.typography.labelLarge,
                            text = tab.label,
                            val csv = formState[node.id] ?: ""
                            val current = (formState[node.id] ?: "").split(",").filter { it.isNotEmpty() }.toSet()
                            val newSelection = if (isMulti) {
                            }
                            } else {
                            },
                        )
                        ),
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(50)),
                        .fillMaxWidth()
                        .handCursor()
                        .size(20.dp)
                        .then(
                        Text(
                        Text(chip.label)
                        activeTrackColor = MaterialTheme.colorScheme.primary,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        constraints.copy(minWidth = 0, maxWidth = wider),
                        constraints.maxWidth
                        constraints.maxWidth + bleed * 2
                        contentAlignment = Alignment.Center,
                        derivedStateOf {
                        enabled = isInteractive,
                        expanded = false
                        fontWeight = FontWeight.Bold,
                        formState = formState,
                        formState[node.id] = option
                        inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                        indication = null,
                        interactionSource = interactionSource,
                        isInteractive = isInteractive,
                        modifier = Modifier
                        modifier = Modifier.indication(
                        modifier = Modifier.padding(bottom = 4.dp, end = 32.dp),
                        modifier = Modifier.padding(start = 8.dp),
                        modifier = Modifier.weight(1f),
                        node = node,
                        onCallback = safeCallback(onCallback),
                        onClick = null,
                        onClick = toggle,
                        onClick = {
                        placeable.place(0, 0)
                        selected = isSelected,
                        selected = selected == option,
                        style = MaterialTheme.typography.bodyLarge,
                        style = MaterialTheme.typography.bodyMedium,
                        style = MaterialTheme.typography.labelSmall,
                        style = MaterialTheme.typography.titleSmall,
                        text = node.headers.getOrElse(index) { "" },
                        text = node.language,
                        text = node.title,
                        text = option,
                        text = row.getOrElse(index) { "" },
                        toggleState = toggleState,
                        when (val action = node.action) {
                        }
                        },
                    )
                    ) {
                    ),
                    .align(Alignment.TopEnd)
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh, pillShape)
                    .clickable { copyToClipboard(node.code) },
                    .clip(RoundedCornerShape(6.dp))
                    .clip(pillShape)
                    .handCursor()
                    .padding(4.dp),
                    .size(28.dp)
                    Box(
                    KaiChip { Text(chip.label) }
                    KaiChip(
                    Modifier
                    Modifier.clickable(
                    RadioButton(
                    RenderChildren(node.children, isInteractive, formState, toggleState, onCallback, depth)
                    RenderNode(
                    RenderNode(item, isInteractive, formState, toggleState, onCallback, depth + 1)
                    Spacer(Modifier.height(2.dp))
                    Text(
                    clicked = true
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    color = MaterialTheme.colorScheme.primary,
                    colors = SliderDefaults.colors(
                    contentDescription = null,
                    contentDescription = stringResource(Res.string.kai_ui_code_copy),
                    copyToClipboard(action.text)
                    drawStopIndicator = null,
                    drawTick = { _, _ -> },
                    expired = true
                    fontWeight = FontWeight.Bold,
                    imageVector = Icons.Default.Person,
                    imageVector = Icons.Filled.ContentCopy,
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    layout(wider, placeable.height) {
                    modifier = Modifier
                    modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
                    modifier = Modifier.handCursor(),
                    modifier = Modifier.horizontalScroll(rememberScrollState()).padding(end = 32.dp),
                    modifier = Modifier.size(16.dp),
                    modifier = Modifier.size(sizeDp * 0.6f),
                    modifier = Modifier.weight(1f),
                    node.id?.let { formState[it] = "0" }
                    onCallback(action.event, data)
                    onClick = {
                    sliderState = sliderState,
                    style = MaterialTheme.typography.bodyMedium,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace),
                    style = MaterialTheme.typography.bodySmall,
                    style = MaterialTheme.typography.titleSmall,
                    text = "— ${node.source}",
                    text = formatSliderValue(currentValue, step),
                    text = initials,
                    text = node.code,
                    text = node.message,
                    text = node.title,
                    text = { Text(option) },
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    toggleState[action.targetId] = !(toggleState[action.targetId] ?: true)
                    try {
                    uriHandler.openUri(action.url)
                    val bleed = 12.dp.roundToPx()
                    val data = collectFormData(action, formState)
                    val isSelected = selectedIndex == index
                    val isSelected by remember {
                    val placeable = measurable.measure(
                    val wider = if (constraints.maxWidth == Int.MAX_VALUE) {
                    verticalAlignment = Alignment.CenterVertically,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    }
                    } catch (_: Exception) {}
                    } else {
                    },
                )
                ) {
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(1.5.dp)),
                .fillMaxHeight()
                .handCursor(),
                .horizontalScroll(rememberScrollState()),
                .layout { measurable, constraints ->
                .width(3.dp)
                Box(
                Column(
                Column(Modifier.padding(12.dp).wrapContentHeight()) {
                Column(Modifier.weight(1f)) {
                Column(modifier = modifier.fillMaxWidth().wrapContentHeight()) {
                DropdownMenuItem(
                Icon(
                Modifier.fillMaxWidth().padding(vertical = 4.dp),
                RenderChildren(selectedTab.children, isInteractive, formState, toggleState, onCallback, depth)
                RenderNode(child, isInteractive, formState, toggleState, onCallback, depth + 1)
                Row(
                SliderDefaults.Track(
                Spacer(Modifier.height(2.dp))
                Text(
                Text(node.label, style = MaterialTheme.typography.bodyLarge)
                Text(prefix, style = MaterialTheme.typography.bodyLarge)
                activeTickColor = Color.Transparent,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                bitmap = previewBitmap,
                border = kaiAdaptiveCardBorder(),
                break
                color = MaterialTheme.colorScheme.onSurface,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                colors = kaiAdaptiveCardColors(),
                contentAlignment = Alignment.Center,
                contentDescription = node.alt,
                contentDescription = node.name,
                contentDescription = stringResource(Res.string.bot_message_copy_content_description),
                contentScale = ContentScale.Crop,
                drawStopIndicator = {},
                enter = expandVertically(),
                exit = shrinkVertically(),
                fontStyle = FontStyle.Italic,
                for (index in 0 until columnCount) {
                gapSize = 0.dp,
                horizontalArrangement = Arrangement.SpaceBetween,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                if (!expired) {
                if (isDisplayOnly) {
                if (isInteractive) {
                if (node.language != null) {
                if (node.title != null) {
                imageVector = Icons.Filled.ContentCopy,
                inactiveTickColor = Color.Transparent,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
                indication = ripple(bounded = false, radius = 20.dp),
                interactionSource = interactionSource,
                is CallbackAction -> {
                is CopyToClipboardAction -> {
                is OpenUrlAction -> {
                is ToggleAction -> {
                model = node.imageUrl,
                model = node.url,
                modifier = Modifier
                modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
                modifier = Modifier.padding(bottom = 4.dp),
                modifier = Modifier.size(sizeDp),
                modifier = modifier,
                modifier = modifier.fillMaxWidth().wrapContentHeight(),
                node.tabs.forEachIndexed { index, tab ->
                null -> {}
                progress = { node.value.coerceIn(0f, 1f) },
                style = MaterialTheme.typography.bodyLarge,
                style = MaterialTheme.typography.bodyMedium,
                style = MaterialTheme.typography.bodySmall,
                style = MaterialTheme.typography.titleSmall,
                text = node.description,
                text = node.label,
                text = node.text,
                thumbColor = MaterialTheme.colorScheme.primary,
                val interactionSource = remember { MutableInteractionSource() }
                val prefix = if (node.ordered == true) "${index + 1}. " else "\u2022 "
                verticalAlignment = Alignment.CenterVertically,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                visible = expanded,
                }
                } else {
                },
            "$h:${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}"
            "${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}"
            "bottom_center" -> Alignment.BottomCenter
            "bottom_end" -> Alignment.BottomEnd
            "bottom_start" -> Alignment.BottomStart
            "center" -> Alignment.Center
            "center_end" -> Alignment.CenterEnd
            "center_start" -> Alignment.CenterStart
            "error" -> MaterialTheme.colorScheme.error
            "primary" -> MaterialTheme.colorScheme.primary
            "secondary" -> MaterialTheme.colorScheme.secondary
            "top_center" -> Alignment.TopCenter
            "top_end" -> Alignment.TopEnd
            "top_start" -> Alignment.TopStart
            ((max - min) / step).toInt() - 1
            )
            ) {
            ),
            .background(contentColor, androidx.compose.foundation.shape.CircleShape),
            .fillMaxWidth()
            .filter { it.isNotEmpty() }
            .handCursor()
            .joinToString("") { it.first().uppercase() }
            .size(20.dp)
            .take(2)
            .then(
            .wrapContentHeight(),
            // Prevent crashes from action handlers
            0
            AlertIcon(node.severity, contentColor, containerColor)
            AlertSeverity.ERROR -> Icon(Icons.Default.Close, null, Modifier.size(14.dp), tint = containerColor)
            AlertSeverity.INFO, null -> Text("i", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = containerColor)
            AlertSeverity.SUCCESS -> Icon(Icons.Default.Check, null, Modifier.size(14.dp), tint = containerColor)
            AlertSeverity.WARNING -> Text("!", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = containerColor)
            AnimatedVisibility(
            Box(
            Box(contentAlignment = Alignment.Center, modifier = Modifier.size(sizeDp)) {
            Card(
            Column {
            Column(
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
            HorizontalDivider()
            Icon(
            Image(
            LinearProgressIndicator(
            RenderChildren(node.children, isInteractive, formState, toggleState, onCallback, depth)
            RenderNode(child, isInteractive, formState, toggleState, onCallback, depth + 1)
            Row {
            Row(
            Row(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
            Spacer(Modifier.width(12.dp))
            Text(
            animation = tween(durationMillis = 700, easing = FastOutSlowInEasing),
            checked = checked,
            coil3.compose.AsyncImage(
            color = MaterialTheme.colorScheme.error,
            color = MaterialTheme.colorScheme.onSurface,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            color = MaterialTheme.colorScheme.primaryContainer,
            color = MaterialTheme.colorScheme.surfaceContainer,
            color = if (expired) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,
            colors = SliderDefaults.colors(
            colors = pressedColors,
            contentAlignment = alignment,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            contentDescription = node.name,
            delay(1.seconds)
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary,
            else -> Alignment.TopStart
            else -> MaterialTheme.colorScheme.onSurface
            enabled = false,
            enabled = isInteractive,
            fontSize = with(LocalDensity.current) { size.toSp() },
            fontWeight = FontWeight.Bold,
            for (child in node.children) {
            for (option in node.options) {
            formState[node.id] = ""
            frozen?.values?.let { formState.putAll(it) }
            hasError = true
            if (diff <= 0L) {
            if (node.source != null) {
            imageVector = imageVector,
            initializeFormState(node, formState)
            interactionSource = interactionSource,
            key(option) {
            key(value) {
            label = node.label?.let { { Text(it) } },
            modifier = Modifier
            modifier = Modifier.fillMaxWidth()
            modifier = Modifier.fillMaxWidth().menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable).handCursor(),
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            modifier = Modifier.indication(
            modifier = Modifier.padding(12.dp),
            modifier = Modifier.padding(16.dp).wrapContentHeight(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            modifier = Modifier.size(size),
            modifier = Modifier.size(sizeDp),
            modifier = Modifier.weight(1f),
            modifier = buttonModifier,
            modifier = modifier,
            node.id?.let { formState[it] = diff.toString() }
            onCheckedChange = null,
            onClick = {},
            onValueChange = { formState[node.id] = formatSliderValue(it, step) },
            onValueChange = {},
            readOnly = true,
            remainingSeconds = diff.coerceAtLeast(0L)
            repeatMode = RepeatMode.Reverse,
            return rounded.toLong().toString()
            shape = RoundedCornerShape(12.dp),
            shape = androidx.compose.foundation.shape.CircleShape,
            steps = steps.coerceAtLeast(0),
            style = MaterialTheme.typography.bodyLarge,
            style = MaterialTheme.typography.bodyMedium,
            style = MaterialTheme.typography.bodySmall,
            style = MaterialTheme.typography.headlineMedium,
            style = MaterialTheme.typography.labelSmall,
            text = formatted,
            text = node.label,
            text = node.name,
            text = node.value,
            text = stringResource(Res.string.kai_ui_render_failed),
            thumb = {
            tint = color,
            track = { sliderState ->
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            val diff = (targetMs - Clock.System.now().toEpochMilliseconds()) / 1000L
            val value = chip.value.ifEmpty { chip.label }
            value = currentValue.coerceIn(min, max),
            value = selected,
            valueRange = min..max,
            verticalAlignment = Alignment.CenterVertically,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            when (val action = node.action) {
            }
            },
        "error" -> MaterialTheme.colorScheme.error
        "error" -> MaterialTheme.colorScheme.onError
        "primary" -> MaterialTheme.colorScheme.onPrimary
        "primary" -> MaterialTheme.colorScheme.primary
        "secondary" -> MaterialTheme.colorScheme.onSecondary
        "secondary" -> MaterialTheme.colorScheme.secondary
        )
        ) {
        ) { labelContent() }
        ),
        // Determine decimal places from step (e.g. step=0.1 → 1 decimal)
        // Silently handle callback errors to prevent crashes
        // The pressed button in a frozen snapshot uses primary colors so it stands out
        // `size` is a Dp; converting it through Density keeps the emoji fallback the
        // against the greyed-out disabled siblings. `enabled=false` prevents clicks; the
        // override on disabled colors bypasses Material's auto-faded disabled appearance.
        // same physical size as the Icon branch above instead of drifting apart as
        // soon as the font scale is not 1.
        AlertSeverity.ERROR -> MaterialTheme.colorScheme.errorContainer
        AlertSeverity.ERROR -> MaterialTheme.colorScheme.onErrorContainer
        AlertSeverity.INFO, null -> MaterialTheme.colorScheme.onPrimaryContainer
        AlertSeverity.INFO, null -> MaterialTheme.colorScheme.primaryContainer
        AlertSeverity.SUCCESS -> onSuccessContainer
        AlertSeverity.SUCCESS -> successContainer
        AlertSeverity.WARNING -> onWarningContainer
        AlertSeverity.WARNING -> warningContainer
        Box(
        Box(Modifier.padding(12.dp)) {
        Button(
        ButtonVariant.FILLED, null -> Button(onClick = onClick, enabled = enabled, modifier = buttonModifier) { labelContent() }
        ButtonVariant.OUTLINED -> OutlinedButton(onClick = onClick, enabled = enabled, modifier = buttonModifier) { labelContent() }
        ButtonVariant.TEXT -> TextButton(onClick = onClick, enabled = enabled, modifier = buttonModifier) { labelContent() }
        ButtonVariant.TONAL -> FilledTonalButton(onClick = onClick, enabled = enabled, modifier = buttonModifier) { labelContent() }
        Checkbox(
        Column {
        Column(
        Column(Modifier.fillMaxWidth()) {
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        Icon(
        IconButton(onClick = onClick, enabled = enabled, modifier = buttonModifier) {
        Modifier.fillMaxWidth(),
        OutlinedTextField(
        RenderChildren(node.children, isInteractive, formState, toggleState, onCallback, depth)
        RenderNode(child, isInteractive, formState, toggleState, onCallback, depth + 1)
        Row(
        Slider(
        Spacer(Modifier.width(12.dp))
        Surface(
        Switch(
        Text(
        Text(node.label, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 8.dp))
        TextNodeStyle.BODY -> MaterialTheme.typography.bodyLarge
        TextNodeStyle.CAPTION -> MaterialTheme.typography.bodySmall
        TextNodeStyle.HEADLINE -> MaterialTheme.typography.headlineSmall
        TextNodeStyle.TITLE -> MaterialTheme.typography.titleMedium
        action.event == frozen.pressedEvent && collectFormData(action, formState) == frozen.values
        animationSpec = infiniteRepeatable(
        border = kaiAdaptiveCardBorder(),
        color = MaterialTheme.colorScheme.surfaceContainerLow,
        color = MaterialTheme.colorScheme.surfaceVariant,
        color = backgroundColor,
        color = color,
        color = containerColor,
        colors = kaiAdaptiveCardColors(),
        contentAlignment = Alignment.Center,
        contentColor = contentColor,
        else -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.colorScheme.onSurface
        else -> MaterialTheme.colorScheme.primary
        else -> {}
        enabled = isInteractive,
        expanded = expanded,
        fontStyle = if (node.italic == true) FontStyle.Italic else null,
        fontWeight = if (node.bold == true || node.value.startsWith("**")) FontWeight.Bold else null,
        for ((index, item) in node.items.withIndex()) {
        for (child in node.children) {
        for (chip in node.chips) {
        for (option in node.options) {
        for (row in node.rows) {
        formState[inputId]?.let { collected[inputId] = it }
        horizontalAlignment = Alignment.CenterHorizontally,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = if (allStats) Arrangement.SpaceEvenly else Arrangement.spacedBy(8.dp),
        if (isInteractive) clicked = false
        if (node.description != null) {
        if (node.headers.isNotEmpty()) {
        if (node.label != null) {
        if (node.value != null) {
        if (previewBitmap != null) {
        if (rounded == rounded.toLong().toFloat()) {
        if (selectedTab != null) {
        if (wrapInCard) {
        initialValue = 0.55f,
        initialValue = 0.96f,
        is AccordionNode -> RenderAccordion(node, isInteractive, formState, toggleState, onCallback, depth)
        is AccordionNode -> node.children.forEach { initializeFormState(it, formState) }
        is AlertNode -> RenderAlert(node)
        is AvatarNode -> RenderAvatar(node)
        is BadgeNode -> RenderBadge(node)
        is BoxNode -> RenderBox(node, isInteractive, formState, toggleState, onCallback, depth)
        is BoxNode -> node.children.forEach { initializeFormState(it, formState) }
        is ButtonNode -> RenderButton(node, isInteractive, formState, toggleState, onCallback)
        is CardNode -> RenderCard(node, isInteractive, formState, toggleState, onCallback, depth)
        is CardNode -> node.children.forEach { initializeFormState(it, formState) }
        is CheckboxNode -> RenderCheckbox(node, isInteractive, formState)
        is CheckboxNode -> if (node.id !in formState) formState[node.id] = (node.checked ?: false).toString()
        is ChipGroupNode -> RenderChipGroup(node, isInteractive, formState)
        is ChipGroupNode -> if (node.selection != "none" && node.id !in formState) {
        is CodeNode -> RenderCode(node)
        is ColumnNode -> RenderColumn(node, isInteractive, formState, toggleState, onCallback, depth)
        is ColumnNode -> node.children.forEach { initializeFormState(it, formState) }
        is CountdownNode -> RenderCountdown(node, isInteractive, formState, toggleState, onCallback)
        is DividerNode -> HorizontalDivider(Modifier.padding(vertical = 4.dp))
        is IconNode -> RenderIcon(node)
        is ImageNode -> RenderImage(node)
        is ListNode -> RenderList(node, isInteractive, formState, toggleState, onCallback, depth)
        is ListNode -> node.items.forEach { initializeFormState(it, formState) }
        is ProgressNode -> RenderProgress(node)
        is QuoteNode -> RenderQuote(node)
        is RadioGroupNode -> RenderRadioGroup(node, isInteractive, formState)
        is RadioGroupNode -> node.selected?.let { if (node.id !in formState) formState[node.id] = it }
        is RowNode -> RenderRow(node, isInteractive, formState, toggleState, onCallback, depth)
        is RowNode -> node.children.forEach { initializeFormState(it, formState) }
        is SelectNode -> RenderSelect(node, isInteractive, formState)
        is SelectNode -> node.selected?.let { if (node.id !in formState) formState[node.id] = it }
        is SliderNode -> RenderSlider(node, isInteractive, formState)
        is SliderNode -> if (node.id !in formState) formState[node.id] = formatSliderValue(node.value ?: node.min ?: 0f, node.step)
        is StatNode -> RenderStat(node)
        is SwitchNode -> RenderSwitch(node, isInteractive, formState)
        is SwitchNode -> if (node.id !in formState) formState[node.id] = (node.checked ?: false).toString()
        is TableNode -> RenderTable(node)
        is TabsNode -> RenderTabs(node, isInteractive, formState, toggleState, onCallback, depth)
        is TabsNode -> node.tabs.forEach { tab -> tab.children.forEach { initializeFormState(it, formState) } }
        is TextInputNode -> RenderTextInput(node, isInteractive, formState)
        is TextInputNode -> node.value?.let { if (node.id !in formState) formState[node.id] = it }
        is TextNode -> RenderText(node)
        label = "alpha",
        label = "scale",
        label = node.label?.let { { Text(it) } },
        modifier = Modifier
        modifier = Modifier.fillMaxWidth(),
        modifier = Modifier.fillMaxWidth().handCursor(),
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        modifier = Modifier.widthIn(min = 72.dp),
        node.headers.size,
        node.rows.maxOfOrNull { it.size } ?: 0,
        null -> MaterialTheme.typography.bodyLarge
        onCallback(event, data)
        onClick = { expanded = !expanded },
        onExpandedChange = { if (isInteractive) expanded = it },
        onValueChange = { formState[node.id] = it },
        placeholder = node.placeholder?.let { { Text(it) } },
        repeat(decimals) { factor *= 10f }
        return
        return (kotlin.math.round(rounded * factor) / factor).toString()
        rounded.toString()
        shape = RoundedCornerShape(12.dp),
        shape = RoundedCornerShape(6.dp),
        shape = RoundedCornerShape(8.dp),
        singleLine = node.multiline != true,
        style = style,
        targetValue = 1f,
        text = node.value.replace("**", ""),
        try {
        val action = node.action as? CallbackAction ?: return@run false
        val alignment = when (node.contentAlignment) {
        val color = when (node.color) {
        val decimals = stepStr.substringAfter('.', "").trimEnd('0').length.coerceIn(1, 6)
        val formatted = if (h > 0) {
        val h = remainingSeconds / 3600
        val initials = node.name.split(" ")
        val m = (remainingSeconds % 3600) / 60
        val modifier = Modifier.height(width / aspectRatio).width(width).clip(RoundedCornerShape(6.dp))
        val pressedColors = ButtonDefaults.buttonColors(
        val previewBitmap = LocalPreviewImages.current[node.url]
        val rounded = kotlin.math.round(value * 100.0f) / 100.0f
        val rounded = kotlin.math.round(value / step) * step
        val s = remainingSeconds % 60
        val selectedTab = node.tabs.getOrNull(selectedIndex)
        val stepStr = step.toString()
        val steps = if (step != null && step > 0) {
        val width = minOf(maxWidth, height * aspectRatio)
        value = formState[node.id] ?: "",
        value.toLong().toString()
        var factor = 1f
        verticalAlignment = Alignment.CenterVertically,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        when (severity) {
        while (true) {
        }
        } catch (_: Exception) {
        } else {
    "account_circle" -> Icons.Default.AccountCircle
    "add" -> Icons.Default.Add
    "alarm" -> Icons.Filled.Alarm
    "analytics" -> Icons.Filled.Analytics
    "arrow_back" -> Icons.AutoMirrored.Filled.ArrowBack
    "arrow_forward" -> Icons.AutoMirrored.Filled.ArrowForward
    "attach_file", "attachment" -> Icons.Filled.AttachFile
    "bar_chart", "chart" -> Icons.Filled.BarChart
    "battery_full", "battery" -> Icons.Filled.BatteryFull
    "bluetooth" -> Icons.Filled.Bluetooth
    "bolt", "flash", "lightning" -> Icons.Filled.Bolt
    "bookmark" -> Icons.Filled.Bookmark
    "bug_report", "bug" -> Icons.Filled.BugReport
    "build", "construction" -> Icons.Default.Build
    "calendar", "date_range", "schedule" -> Icons.Default.DateRange
    "category" -> Icons.Filled.Category
    "celebration", "party" -> Icons.Filled.Celebration
    "check", "done" -> Icons.Default.Check
    "check_circle" -> Icons.Default.CheckCircle
    "clock", "access_time" -> Icons.Filled.AccessTime
    "close" -> Icons.Default.Close
    "cloud" -> Icons.Filled.Cloud
    "code" -> Icons.Filled.Code
    "copy", "content_copy" -> Icons.Filled.ContentCopy
    "cut", "content_cut" -> Icons.Filled.ContentCut
    "dark_mode", "moon" -> Icons.Filled.DarkMode
    "dashboard" -> Icons.Filled.Dashboard
    "delete" -> Icons.Default.Delete
    "directions_car", "car" -> Icons.Filled.DirectionsCar
    "download" -> Icons.Filled.Download
    "eco", "leaf", "nature" -> Icons.Filled.Eco
    "edit" -> Icons.Default.Edit
    "emoji_events", "trophy" -> Icons.Filled.EmojiEvents
    "expand_less" -> Icons.Default.KeyboardArrowUp
    "expand_more" -> Icons.Default.KeyboardArrowDown
    "explore", "compass" -> Icons.Filled.Explore
    "favorite" -> Icons.Default.Favorite
    "filter", "filter_list" -> Icons.Filled.FilterList
    "fitness", "fitness_center" -> Icons.Filled.FitnessCenter
    "flag" -> Icons.Filled.Flag
    "flight", "airplane" -> Icons.Filled.Flight
    "group" -> Icons.Default.Face
    "health", "medical", "healing" -> Icons.Filled.Healing
    "home" -> Icons.Default.Home
    "hotel" -> Icons.Filled.Hotel
    "info" -> Icons.Default.Info
    "inventory" -> Icons.Filled.Inventory
    "label", "tag" -> Icons.AutoMirrored.Filled.Label
    "language", "globe" -> Icons.Filled.Language
    "light_mode", "sun" -> Icons.Filled.LightMode
    "lightbulb", "idea" -> Icons.Filled.Lightbulb
    "link" -> Icons.Filled.Link
    "local_cafe", "coffee" -> Icons.Filled.LocalCafe
    "location", "place" -> Icons.Default.LocationOn
    "lock" -> Icons.Default.Lock
    "lock_open" -> Icons.Filled.LockOpen
    "mail", "email" -> Icons.Default.Email
    "map" -> Icons.Filled.Map
    "menu" -> Icons.Default.Menu
    "military_tech", "medal" -> Icons.Filled.MilitaryTech
    "more", "more_vert" -> Icons.Default.MoreVert
    "notifications" -> Icons.Default.Notifications
    "paste", "content_paste" -> Icons.Filled.ContentPaste
    "pause" -> Icons.Filled.Pause
    "payments", "credit_card" -> Icons.Filled.Payments
    "person" -> Icons.Default.Person
    "pets", "pet" -> Icons.Filled.Pets
    "phone" -> Icons.Default.Call
    "photo", "image" -> Icons.Filled.Image
    "pie_chart" -> Icons.Filled.PieChart
    "pin", "push_pin" -> Icons.Filled.PushPin
    "play_arrow", "play" -> Icons.Default.PlayArrow
    "public", "earth" -> Icons.Filled.Public
    "receipt" -> Icons.Filled.Receipt
    "redo" -> Icons.AutoMirrored.Filled.Redo
    "refresh" -> Icons.Default.Refresh
    "restaurant", "food" -> Icons.Filled.Restaurant
    "rocket_launch", "rocket" -> Icons.Filled.RocketLaunch
    "savings", "money" -> Icons.Filled.Savings
    "school", "education" -> Icons.Filled.School
    "science", "flask" -> Icons.Filled.Science
    "search" -> Icons.Default.Search
    "security", "shield" -> Icons.Filled.Security
    "send" -> Icons.AutoMirrored.Filled.Send
    "settings" -> Icons.Default.Settings
    "share" -> Icons.Default.Share
    "shopping_cart", "cart" -> Icons.Default.ShoppingCart
    "show_chart" -> Icons.AutoMirrored.Filled.ShowChart
    "skip_next" -> Icons.Filled.SkipNext
    "skip_previous" -> Icons.Filled.SkipPrevious
    "sort" -> Icons.AutoMirrored.Filled.Sort
    "speed" -> Icons.Filled.Speed
    "star" -> Icons.Default.Star
    "stop" -> Icons.Filled.Stop
    "sunny", "weather" -> Icons.Filled.WbSunny
    "swap", "swap_horiz" -> Icons.Filled.SwapHoriz
    "sync" -> Icons.Filled.Sync
    "task", "task_alt" -> Icons.Filled.TaskAlt
    "terminal" -> Icons.Filled.Terminal
    "thumb_down" -> Icons.Filled.ThumbDown
    "thumb_up" -> Icons.Default.ThumbUp
    "timer" -> Icons.Filled.Timer
    "translate" -> Icons.Filled.Translate
    "trending_down" -> Icons.AutoMirrored.Filled.TrendingDown
    "trending_flat" -> Icons.AutoMirrored.Filled.TrendingFlat
    "trending_up" -> Icons.AutoMirrored.Filled.TrendingUp
    "undo" -> Icons.AutoMirrored.Filled.Undo
    "upload" -> Icons.Filled.Upload
    "verified" -> Icons.Filled.Verified
    "visibility" -> Icons.Filled.Visibility
    "visibility_off" -> Icons.Filled.VisibilityOff
    "warning" -> Icons.Default.Warning
    "water_drop", "water" -> Icons.Filled.WaterDrop
    "wifi" -> Icons.Filled.Wifi
    "work", "business" -> Icons.Filled.Work
    "workspace_premium", "premium" -> Icons.Filled.WorkspacePremium
    )
    ) {
    // LLMs frequently misuse box when they mean column, causing children to stack/overlap.
    // Only use Box layout for single-child centering; fall back to Column for multiple children.
    @OptIn(ExperimentalLayoutApi::class)
    Box(
    BoxWithConstraints(Modifier.fillMaxWidth()) {
    Card(
    Column(
    Column(Modifier.fillMaxWidth()) {
    Column(Modifier.fillMaxWidth().wrapContentHeight()) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
    CompositionLocalProvider(LocalFrozenSubmission provides frozen) {
    ExposedDropdownMenuBox(
    FlowRow(
    KaiOutlinedTextField(
    LaunchedEffect(isInteractive) {
    LaunchedEffect(node, frozen?.values) {
    LaunchedEffect(targetMs) {
    Row(
    Surface(
    Text(
    action.collectFrom?.forEach { inputId ->
    action.dataAsStrings?.let { collected.putAll(it) }
    children: ImmutableList<KaiUiNode>,
    depth: Int = 0,
    depth: Int,
    else -> null
    for (child in children) {
    formState: SnapshotStateMap<String, String>,
    frozen: FrozenSubmission? = null,
    if (!active) return Modifier
    if (columnCount == 0) return
    if (depth > MAX_DEPTH) return
    if (hasError) {
    if (imageVector != null) {
    if (isPressedSnapshot) {
    if (node.action is CopyToClipboardAction) {
    if (node.children.size <= 1 && node.contentAlignment != null) {
    if (node.imageUrl != null) {
    if (node.tabs.isEmpty()) return
    if (nodeId != null && toggleState[nodeId] == false) return
    if (step != null && step > 0) {
    isInteractive: Boolean,
    modifier: Modifier = Modifier,
    node: AccordionNode,
    node: BoxNode,
    node: ButtonNode,
    node: CardNode,
    node: CheckboxNode,
    node: ChipGroupNode,
    node: ColumnNode,
    node: CountdownNode,
    node: KaiUiNode,
    node: ListNode,
    node: RadioGroupNode,
    node: RowNode,
    node: SelectNode,
    node: SliderNode,
    node: SwitchNode,
    node: TabsNode,
    node: TextInputNode,
    onCallback: (String, Map<String, String>) -> Unit,
    onCallback: (event: String, data: Map<String, String>) -> Unit,
    return Modifier.graphicsLayer(scaleX = scale, scaleY = scale, alpha = alpha)
    return collected
    return if (value == value.toLong().toFloat()) {
    toggleState: SnapshotStateMap<String, Boolean>,
    try {
    val allStats = node.children.isNotEmpty() && node.children.all { it is StatNode }
    val alpha by transition.animateFloat(
    val aspectRatio = (node.aspectRatio ?: DEFAULT_IMAGE_ASPECT_RATIO)
    val backgroundColor = when (node.color) {
    val buttonModifier = Modifier.handCursor().then(pulseModifier(showPulse))
    val checked = formState[node.id]?.toBooleanStrictOrNull() ?: false
    val collected = mutableMapOf<String, String>()
    val color = when (node.color) {
    val columnCount = maxOf(
    val containerColor = when (node.severity) {
    val contentColor = when (node.color) {
    val contentColor = when (node.severity) {
    val copyToClipboard = rememberCopyToClipboard()
    val currentOnCallback by rememberUpdatedState(onCallback)
    val currentValue = formState[node.id]?.toFloatOrNull() ?: (node.value ?: min)
    val enabled = isInteractive && (node.enabled != false)
    val formState = remember { mutableStateMapOf<String, String>() }
    val frozen = LocalFrozenSubmission.current
    val height = (node.height ?: DEFAULT_IMAGE_HEIGHT).dp
    val imageVector = resolveIcon(node.name)
    val interactionSource = remember { MutableInteractionSource() }
    val isDark = MaterialTheme.colorScheme.surface.luminance() < 0.5f
    val isDisplayOnly = node.selection == "none"
    val isMulti = node.selection == "multi"
    val isPending: Boolean = false,
    val isPressedSnapshot = !isInteractive && frozen?.pressedEvent != null && run {
    val labelContent: @Composable () -> Unit = { Text(node.label) }
    val max = node.max ?: 100f
    val min = node.min ?: 0f
    val nodeId = node.id
    val onClick: () -> Unit = {
    val onSuccessContainer = if (isDark) Color(0xFFC8E6C9) else Color(0xFF1B5E20)
    val onWarningContainer = if (isDark) Color(0xFFFF9100) else Color(0xFFE65100)
    val pillShape = RoundedCornerShape(50)
    val pressedEvent: String? = null,
    val scale by transition.animateFloat(
    val selected = formState[node.id] ?: ""
    val showPulse = (clicked && !isInteractive) || (isPressedSnapshot && frozen.isPending)
    val size = (node.size ?: 24).dp
    val sizeDp = (node.size ?: 40).coerceIn(24, 80).dp
    val step = node.step
    val style = when (node.style) {
    val successContainer = if (isDark) Color(0xFF1B3A1B) else Color(0xFFE8F5E9)
    val targetMs = remember { Clock.System.now().toEpochMilliseconds() + node.seconds.toLong() * 1000L }
    val toggle = { formState[node.id] = (!checked).toString() }
    val toggleState = remember { mutableStateMapOf<String, Boolean>() }
    val transition = rememberInfiniteTransition(label = "button-pulse")
    val uriHandler = LocalUriHandler.current
    val values: Map<String, String> = emptyMap(),
    val warningContainer = if (isDark) Color(0xFF3D2600) else Color(0xFFFFF3E0)
    var clicked by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(node.expanded ?: false) }
    var expired by remember { mutableStateOf(false) }
    var hasError by remember { mutableStateOf(false) }
    var remainingSeconds by remember { mutableStateOf<Long>(node.seconds.toLong()) }
    var selectedIndex by remember { mutableIntStateOf((node.selectedIndex ?: 0).coerceIn(0, node.tabs.lastIndex)) }
    when (node) {
    when (node.variant) {
    wrapInCard: Boolean = true,
    }
    } catch (_: Exception) {
    } else if (node.name != null) {
    } else if (node.name.isNotEmpty() && node.name.any { it.code > 0x2600 }) {
    } else {
 * A frozen snapshot of a user's kai-ui submission: the values they submitted, plus the
 * `isPending` is a transient UI flag — true while the AI is still answering this submission;
 * event of the button they pressed. Matching a button uses event + collected form data
 * per-button data payloads, e.g. a quiz with one event and different `choice` values).
 * rather than event alone (multiple buttons often share an event but carry distinct
 * the pressed button pulses to signal the in-flight request.
 */
)
) {
): (String, Map<String, String>) -> Unit = { event, data ->
/**
// --- Form state initialization ---
// --- Icon resolution ---
// --- New component renderers ---
@Composable
@Immutable
@OptIn(ExperimentalLayoutApi::class)
@OptIn(ExperimentalMaterial3Api::class)
@file:OptIn(ExperimentalMaterial3Api::class)
data class FrozenSubmission(
fun KaiUiRenderer(
package com.inspiredandroid.kai.ui.dynamicui
private const val DEFAULT_IMAGE_ASPECT_RATIO = 1.91f
private const val DEFAULT_IMAGE_HEIGHT = 220
private const val MAX_DEPTH = 10
private fun AlertIcon(severity: AlertSeverity?, contentColor: Color, containerColor: Color) {
private fun RenderAccordion(
private fun RenderAlert(node: AlertNode) {
private fun RenderAvatar(node: AvatarNode) {
private fun RenderBadge(node: BadgeNode) {
private fun RenderBox(
private fun RenderButton(
private fun RenderCard(
private fun RenderCheckbox(
private fun RenderChildren(
private fun RenderChipGroup(
private fun RenderCode(node: CodeNode) {
private fun RenderColumn(
private fun RenderCountdown(
private fun RenderIcon(node: IconNode) {
private fun RenderImage(node: ImageNode) {
private fun RenderList(
private fun RenderNode(
private fun RenderProgress(node: ProgressNode) {
private fun RenderQuote(node: QuoteNode) {
private fun RenderRadioGroup(
private fun RenderRow(
private fun RenderSelect(
private fun RenderSlider(
private fun RenderStat(node: StatNode) {
private fun RenderSwitch(
private fun RenderTable(node: TableNode) {
private fun RenderTabs(
private fun RenderText(node: TextNode) {
private fun RenderTextInput(
private fun collectFormData(action: CallbackAction, formState: Map<String, String>): Map<String, String> {
private fun formatSliderValue(value: Float, step: Float?): String {
private fun initializeFormState(node: KaiUiNode, formState: MutableMap<String, String>) {
private fun pulseModifier(active: Boolean): Modifier {
private fun resolveIcon(name: String): ImageVector? = when (name) {
private fun safeCallback(
private val LocalFrozenSubmission = compositionLocalOf<FrozenSubmission?> { null }
val LocalPreviewImages = staticCompositionLocalOf<Map<String, ImageBitmap>> { emptyMap() }
}
