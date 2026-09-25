
                                    modifier = Modifier.handCursor(),
                                    selection = TextRange(start + 1),
                                    text = newText,
                                    text = truncateFileName(file.name),
                                )
                                ),
                                Text(
                                TextFieldValue(
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(icon),
                                selection = TextRange(cursor.coerceAtMost(if (rest.isEmpty()) cursor else newText.length)),
                                text = if (rest.isEmpty()) "/${skill.id} " else newText,
                                tint = MaterialTheme.colorScheme.onBackground,
                            )
                            ),
                            // Enter without Shift -> send message and consume event
                            // Shift+Enter -> manually insert newline
                            DisableSelection {
                            Icon(
                            TextFieldValue(
                            onSelectService = onSelectService,
                            onTextStateChange(
                            return@onPreviewKeyEvent true
                            services = availableServices,
                            submitQuestion()
                            val currentText = textState.text
                            val end = maxOf(selection.start, selection.end).coerceIn(0, currentText.length)
                            val newText = currentText.replaceRange(start, end, "\n")
                            val selection = textState.selection
                            val start = minOf(selection.start, selection.end).coerceIn(0, currentText.length)
                            }
                        )
                        Res.drawable.ic_file
                        Res.drawable.ic_image
                        ServiceSelector(
                        TrailingIcon(icon = Res.drawable.ic_stop, onClick = cancel, isPulsing = true)
                        TrailingIcon(icon = Res.drawable.ic_up, onClick = { submitQuestion() })
                        icon = vectorResource(Res.drawable.ic_attach),
                        icon = {
                        if (event.isShiftPressed) {
                        label = {
                        modifier = Modifier.handCursor(),
                        modifier = Modifier.padding(start = 7.dp),
                        onClick = { filePickerLauncher.launch() },
                        onClick = { removeFile(file) },
                        onTextStateChange(
                        tint = MaterialTheme.colorScheme.onBackground,
                        val cursor = ("/" + skill.id + " ").length
                        val firstSpace = text.indexOfFirst { it.isWhitespace() }
                        val newText = "/${skill.id}$rest"
                        val rest = if (firstSpace < 0) "" else text.substring(firstSpace)
                        val text = textState.text
                        }
                        } else {
                        },
                    )
                    .fillMaxWidth(),
                    .padding(horizontal = 16.dp)
                    // Only handle hardware keyboard on desktop/web platforms
                    BorderStroke(width = 2.dp, brush = gradientBrush),
                    CircleIconButton(
                    SuggestionChip(
                    color = MaterialTheme.colorScheme.onBackground,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    if (availableServices.size > 1) {
                    if (currentPlatform !is Platform.Mobile && event.key.keyCode == Key.Enter.keyCode && event.type == KeyEventType.KeyDown) {
                    if (isLoading) {
                    modifier = Modifier.padding(end = 7.dp),
                    onSelect = { skill ->
                    query = slashQuery,
                    return@onPreviewKeyEvent false
                    shape = RoundedCornerShape(28.dp),
                    skills = installedSkills,
                    stringResource(Res.string.prompt_ask_question),
                    val icon = if (file.extension.lowercase() in imageExtensions) {
                    verticalAlignment = Alignment.CenterVertically,
                    }
                    } else if (textState.text.isNotBlank()) {
                    } else {
                    },
                )
                ) {
                .background(MaterialTheme.colorScheme.background)
                .border(
                .clip(RoundedCornerShape(28.dp))
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .heightIn(max = maxComposerHeight)
                .onPreviewKeyEvent { event ->
                .padding(16.dp)
                KeyboardActions() // No keyboard send action on mobile
                KeyboardActions(onSend = { submitQuestion() })
                Row(
                SkillAutocomplete(
                Spacer(Modifier.padding(top = 4.dp))
                Text(
                animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
                ask(text.trim())
                detectSlashQuery(textState.text, textState.selection.start)
                for (file in files) {
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                if (file != null) addFile(file)
                imeAction = if (currentPlatform is Platform.Mobile) ImeAction.Default else ImeAction.Send,
                modifier = Modifier
                null
                onClick()
                onTextStateChange(TextFieldValue(""))
                repeatMode = RepeatMode.Reverse,
                type = FileKitType.File(extensions = supportedFileExtensions),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                {
                }
                },
            ) {
            ) { file ->
            ),
            .background(brush = gradientBrush, CircleShape)
            .clickable {
            .clickable { onClick() }
            .clip(CircleShape)
            .handCursor()
            .handCursor(),
            .size(42.dp)
            FlowRow(
            alpha = pulseAlpha
            animationSpec = infiniteRepeatable(
            colors = outlineTextFieldColors(),
            contentDescription = null,
            if (!inInspection) focusRequester.requestFocus()
            if (slashQuery != null) {
            if (text.isNotBlank()) {
            imageVector = icon,
            initialValue = 0.7f,
            initialValue = 0.92f,
            keyboardActions = if (currentPlatform !is Platform.Mobile) {
            keyboardOptions = KeyboardOptions(
            leadingIcon = if (filePickerLauncher != null) {
            modifier = Modifier
            modifier = Modifier.size(24.dp),
            modifier = Modifier.size(32.dp).then(pulseModifier),
            null
            onValueChange = onTextStateChange,
            placeholder = {
            rememberFilePickerLauncher(
            scaleX = pulseScale
            scaleY = pulseScale
            targetValue = 1.0f,
            tint = Color.White,
            tint = tint,
            trailingIcon = {
            val slashQuery = remember(textState.text, textState.selection) {
            val text = textState.text
            value = textState,
            vectorResource(icon),
            }
            } else {
            },
        "${base.take(keep)}…$ext"
        "${name.take(maxChars - 1)}…"
        )
        // Slash autocomplete: shown when the user is typing the first token and it starts
        // The cap is expressed in dp but bounds a number of text lines, so it has to
        // grow with the font scale — otherwise the composer shows a single line of
        // so the ViewModel can match it at send time.
        // what the user is typing at the largest accessibility font size.
        // with `/`. Selecting an entry rewrites the first token to the canonical skill id
        Icon(
        LaunchedEffect(Unit) {
        Modifier
        Modifier.graphicsLayer {
        TextField(
        contentAlignment = Alignment.Center,
        fun submitQuestion() {
        if (files.isNotEmpty()) {
        if (installedSkills.isNotEmpty()) {
        modifier = modifier
        val allowFileAttachment = supportedFileExtensions.isNotEmpty()
        val base = name.substring(0, dotIndex)
        val ext = name.substring(dotIndex) // includes the dot
        val filePickerLauncher = if (allowFileAttachment) {
        val focusRequester = remember { FocusRequester() }
        val inInspection = LocalInspectionMode.current
        val infiniteTransition = rememberInfiniteTransition()
        val keep = (maxChars - ext.length - 1).coerceAtLeast(1)
        val maxComposerHeight = 120.dp * LocalDensity.current.fontScale
        val pulseAlpha by infiniteTransition.animateFloat(
        val pulseScale by infiniteTransition.animateFloat(
        }
        } else {
    ) {
    Box(
    Column(modifier = modifier) {
    addFile: (PlatformFile) -> Unit,
    ask: (String) -> Unit,
    availableServices: ImmutableList<ServiceEntry> = persistentListOf(),
    cancel: () -> Unit = {},
    files: ImmutableList<PlatformFile>,
    icon: ImageVector,
    icon: org.jetbrains.compose.resources.DrawableResource = Res.drawable.ic_up,
    if (!text.startsWith('/')) return null
    if (cursor > tokenEnd) return null
    if (name.length <= maxChars) return name
    installedSkills: ImmutableList<SkillManifest> = persistentListOf(),
    isLoading: Boolean = false,
    isPulsing: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onSelectService: (String) -> Unit = {},
    onTextStateChange: (TextFieldValue) -> Unit,
    removeFile: (PlatformFile) -> Unit,
    return if (dotIndex > 0 && dotIndex < name.length - 1) {
    return text.substring(1, tokenEnd).lowercase()
    supportedFileExtensions: ImmutableList<String>,
    textState: TextFieldValue,
    tint: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    val dotIndex = name.lastIndexOf('.')
    val firstSpace = text.indexOfFirst { it.isWhitespace() }
    val pulseModifier = if (isPulsing) {
    val tokenEnd = if (firstSpace < 0) text.length else firstSpace
    }
    } else {
 *  - `"/foo bar"` cursor at 6 → `null` (cursor past first space)
 *  - `"/su"` cursor at 3 → `"su"`
 *  - `"/summarize https://…"` cursor at 4 → `"sum"`
 *  - `"hello /foo"` (slash not at start) → `null`
 * Returns the slash-command query string the user is currently typing, or null if
 * Shortens a filename that is too long to display in a chip. Returns the first [maxChars]
 * characters of the base name followed by `…` and the original extension, so the user still
 * recognizes the file type. Short names are returned unchanged.
 * the cursor isn't inside a leading `/<token>`. Examples:
 */
) {
/**
@Composable
@OptIn(ExperimentalLayoutApi::class)
fun QuestionInput(
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isShiftPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.inspiredandroid.kai.Platform
import com.inspiredandroid.kai.currentPlatform
import com.inspiredandroid.kai.data.ServiceEntry
import com.inspiredandroid.kai.data.imageExtensions
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.ui.gradientBrush
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.outlineTextFieldColors
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.dialogs.FileKitType
import io.github.vinceglb.filekit.dialogs.compose.rememberFilePickerLauncher
import io.github.vinceglb.filekit.extension
import io.github.vinceglb.filekit.name
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.ic_attach
import kai.composeapp.generated.resources.ic_file
import kai.composeapp.generated.resources.ic_image
import kai.composeapp.generated.resources.ic_stop
import kai.composeapp.generated.resources.ic_up
import kai.composeapp.generated.resources.prompt_ask_question
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
internal fun CircleIconButton(
internal fun TrailingIcon(
internal fun detectSlashQuery(text: String, cursor: Int): String? {
internal fun truncateFileName(name: String, maxChars: Int = 16): String {
package com.inspiredandroid.kai.ui.chat.composables
}
