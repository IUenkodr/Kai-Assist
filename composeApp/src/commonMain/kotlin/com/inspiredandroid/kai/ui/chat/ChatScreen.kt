package com.inspiredandroid.kai.ui.chat
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.draganddrop.dragAndDropTarget
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropEvent
import androidx.compose.ui.draganddrop.DragAndDropTarget
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.inspiredandroid.kai.BackIcon
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.data.supportsAgenticFlows
import com.inspiredandroid.kai.getBackgroundDispatcher
import com.inspiredandroid.kai.onDragAndDropEventDropped
import com.inspiredandroid.kai.ui.build.KaiBuildScreen
import com.inspiredandroid.kai.ui.chat.composables.BotMessage
import com.inspiredandroid.kai.ui.chat.composables.ChatHistorySheet
import com.inspiredandroid.kai.ui.chat.composables.CircleIconButton
import com.inspiredandroid.kai.ui.chat.composables.EmptyState
import com.inspiredandroid.kai.ui.chat.composables.ErrorMessage
import com.inspiredandroid.kai.ui.chat.composables.FreeProviderSuggestionsPanel
import com.inspiredandroid.kai.ui.chat.composables.HeartbeatBanner
import com.inspiredandroid.kai.ui.chat.composables.PendingSmsBanners
import com.inspiredandroid.kai.ui.chat.composables.QuestionInput
import com.inspiredandroid.kai.ui.chat.composables.ServiceSelector
import com.inspiredandroid.kai.ui.chat.composables.TopBar
import com.inspiredandroid.kai.ui.chat.composables.TrailingIcon
import com.inspiredandroid.kai.ui.chat.composables.UserMessage
import com.inspiredandroid.kai.ui.chat.composables.WaitingResponseRow
import com.inspiredandroid.kai.ui.chat.composables.uiErrorText
import com.inspiredandroid.kai.ui.components.LogoAnimation
import com.inspiredandroid.kai.ui.components.VerticalScrollbarForList
import com.inspiredandroid.kai.ui.components.animatedGradientBorder
import com.inspiredandroid.kai.ui.dynamicui.FrozenSubmission
import com.inspiredandroid.kai.ui.dynamicui.KaiUiRenderer
import com.inspiredandroid.kai.ui.dynamicui.toSpeakableText
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.markdown.KaiUiBlock
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import com.inspiredandroid.kai.ui.sandbox.SandboxTabsContent
import com.inspiredandroid.kai.ui.settings.SandboxUiState
import com.inspiredandroid.kai.ui.settings.SandboxViewModel
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.fallback_answered_by
import kai.composeapp.generated.resources.fallback_service_failed
import kai.composeapp.generated.resources.fallback_trying_next
import kai.composeapp.generated.resources.ic_stop
import kai.composeapp.generated.resources.interactive_back_content_description
import kai.composeapp.generated.resources.interactive_exit_content_description
import kai.composeapp.generated.resources.interactive_title
import kai.composeapp.generated.resources.interactive_ui_parsing_failed
import kai.composeapp.generated.resources.interactive_welcome_subtitle
import kai.composeapp.generated.resources.interactive_welcome_title
import kai.composeapp.generated.resources.scroll_to_bottom_content_description
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.errors.TextToSpeechSynthesisInterruptedError
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

                                                            ?: persistentListOf(history.content),
                                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                                                            null
                                                            style = MaterialTheme.typography.labelSmall,
                                                            text = stringResource(Res.string.fallback_answered_by, history.fallbackServiceName),
                                                            uiState.actions.setIsSpeaking(it, history.id)
                                                            uiState.actions.submitUiCallback(event, data)
                                                            { event, data -> uiState.actions.resubmit(pairedUserId, event, data) }
                                                        )
                                                        androidx.compose.material3.Text(
                                                        attachments = history.attachments,
                                                        frozen = frozen,
                                                        isInteractive = isLastAssistant && !uiState.isLoading && frozen == null,
                                                        isSpeaking = false,
                                                        isSpeaking = uiState.isSpeaking && uiState.isSpeakingContentId == history.id,
                                                        message = "",
                                                        message = history.content,
                                                        onRegenerate = if (isLastAssistant) uiState.actions.regenerate else null,
                                                        onResubmit = if (pairedUserId != null && !uiState.isLoading) {
                                                        onUiCallback = { event, data ->
                                                        reasoningSegments = reasoningSegmentsByAssistantId[history.id]
                                                        reasoningSegments = reasoningSegmentsByAssistantId[history.id] ?: persistentListOf(),
                                                        setIsSpeaking = {
                                                        setIsSpeaking = {},
                                                        textToSpeech = null,
                                                        textToSpeech = textToSpeech,
                                                        } else {
                                                        },
                                                    )
                                                    // Thinking-only turn still in flight — render as a standalone
                                                    // every earlier thinking segment in this cycle under this id.
                                                    // reasoning bubble. The precomputation above has already gathered
                                                    BotMessage(
                                                    UserMessage(
                                                    error = error,
                                                    history.content.isNotEmpty() &&
                                                    history.id !in suppressedThinkingIds
                                                    if (history.fallbackServiceName != null) {
                                                    listState.animateScrollToItem(totalItems - 1)
                                                    retry = uiState.actions.retry,
                                                    val frozen = frozenByAssistantId[history.id]
                                                    val isLastAssistant = history.id == lastAssistantId
                                                    val pairedUserId = userIdByAssistantId[history.id]
                                                    }
                                                )
                                                ) {
                                                // Don't show completed tool results in UI
                                                // Handle TTS errors gracefully (service failure, audio issues, etc.)
                                                // Rendered in WaitingResponseRow below
                                                // Speech was interrupted by user
                                                // Submissions are shown by the paired assistant's frozen kai-ui card
                                                // above; the "Responded with: …" text bubble would be redundant.
                                                ?.let { pending.add(it) }
                                                ?.takeIf { it.isNotBlank() }
                                                ErrorMessage(error = error, retry = uiState.actions.retry)
                                                FreeProviderSuggestionsPanel(
                                                addAll(pending)
                                                entry.reasoningContent?.takeIf { it.isNotBlank() }?.let { add(it) }
                                                executingTools = executingToolsState.tools,
                                                if (history.content.isNotEmpty() && !history.isThinking) {
                                                if (history.uiSubmission == null) {
                                                if (totalItems > 0) {
                                                isStatusOnly = executingToolsState.isStatusOnly,
                                                it.content == sub.sourceContent
                                                it.content.isNotEmpty() && !it.isThinking
                                                it.content.isNotEmpty() && !it.isThinking &&
                                                statusText = fallbackStatusText,
                                                textToSpeech?.say(lastMessage.content.toSpeakableText())
                                                uiState.actions.setIsSpeaking(false, lastMessage.id)
                                                val totalItems = listState.layoutInfo.totalItemsCount
                                                }
                                                } else if (history.isThinking &&
                                            !entry.isThinking &&
                                            )
                                            .handCursor(),
                                            // Assistant turn with tool calls but no answer text yet —
                                            // capture its reasoning, attach to the eventual answer.
                                            History.Role.ASSISTANT -> {
                                            History.Role.TOOL -> {
                                            History.Role.TOOL_EXECUTING -> {
                                            History.Role.USER -> {
                                            WaitingResponseRow(
                                            componentScope.launch {
                                            entry.content.isNotEmpty() -> {
                                            entry.isThinking &&
                                            entry.reasoningContent
                                            entry.toolCalls != null -> {
                                            if (combined.isNotEmpty()) byAnswerId[entry.id] = combined.toImmutableList()
                                            if (uiState.showFreeProviderSuggestions) {
                                            it.role == History.Role.ASSISTANT &&
                                            pending.add(entry.content)
                                            pending.clear()
                                            pendingThinkingIds.add(entry.id)
                                            pendingThinkingIds.clear()
                                            suppressed.addAll(pendingThinkingIds)
                                            textToSpeech?.stop()
                                            try {
                                            uiState.actions.setIsSpeaking(true, lastMessage.id)
                                            val combined = buildList {
                                            }
                                            } catch (_: Exception) {
                                            } catch (_: TextToSpeechSynthesisInterruptedError) {
                                            } else {
                                            } finally {
                                        (frozenByAssistantId.values.none { it.isPending } || executingToolsState.tools.isNotEmpty())
                                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = stringResource(Res.string.scroll_to_bottom_content_description))
                                        componentScope.launch(getBackgroundDispatcher()) {
                                        entry.role == History.Role.ASSISTANT &&
                                        entry.role == History.Role.USER -> {
                                        history[j].takeIf {
                                        isPending = uiState.isLoading && i == lastUserIdx,
                                        item(key = "error") {
                                        item(key = "loading") {
                                        modifier = Modifier
                                        onClick = {
                                        pressedEvent = sub.pressedEvent,
                                        suppressed.add(pendingThinkingIds[i])
                                        values = sub.values,
                                        when (history.role) {
                                        }
                                        },
                                        }?.id
                                    )
                                    ) {
                                    .takeUnless { primaryIsOnDevice },
                                    // Skip the generic "thinking" row during a pending kai-ui submission — the
                                    // activity so tool feedback isn't lost.
                                    // pressed button's pulse already signals work in flight. Keep it for tool
                                    SmallFloatingActionButton(
                                    byAnswerId[lastId] = pending.toImmutableList()
                                    enter = fadeIn() + scaleIn(),
                                    exit = fadeOut() + scaleOut(),
                                    for (i in 0 until pendingThinkingIds.size - 1) {
                                    frozen[originId] = FrozenSubmission(
                                    horizontalAlignment = CenterHorizontally,
                                    if (h.role != History.Role.USER) continue
                                    if (showWaitingRow) {
                                    if (uiState.isSpeechOutputEnabled && lastMessage.role == History.Role.ASSISTANT) {
                                    items(uiState.history, key = { it.id }, contentType = { it.role }) { history ->
                                    lastVisibleItem != null && lastVisibleItem.index < listState.layoutInfo.totalItemsCount - 1
                                    listState = listState,
                                    listState.requestScrollToItem(history.lastIndex)
                                    modifier = Modifier.align(BottomCenter).padding(bottom = 8.dp),
                                    modifier = Modifier.align(CenterEnd).fillMaxHeight(),
                                    modifier = Modifier.fillMaxSize(),
                                    state = listState,
                                    uiState.actions.submitUiCallback(event, data)
                                    uiState.error?.let { error ->
                                    userIdByAssistant[originId] = h.id
                                    val lastId = pendingThinkingIds.last()
                                    val lastMessage = history.last()
                                    val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()
                                    val originId = (i - 1 downTo 0).firstNotNullOfOrNull { j ->
                                    val showWaitingRow = uiState.isLoading &&
                                    val sub = h.uiSubmission ?: continue
                                    visible = showScrollToBottom,
                                    when {
                                    }
                                    } ?: (i - 1 downTo 0).firstNotNullOfOrNull { j ->
                                    } ?: continue
                                )
                                ) {
                                .firstOrNull()
                                // Capture history at effect start to prevent race conditions
                                // In-flight: the user is still waiting for the answer but earlier
                                // instead of a separate bubble per tool-loop iteration.
                                // recent thinking entry so the user sees ONE growing Thinking section
                                // thinking turns are already in history. Collapse them into the most
                                ?.let { Service.fromId(it.serviceId).isOnDevice } == true
                                LazyColumn(
                                VerticalScrollbarForList(
                                androidx.compose.animation.AnimatedVisibility(
                                byAnswerId to suppressed
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                derivedStateOf {
                                for ((i, h) in history.withIndex()) {
                                for (entry in uiState.history) {
                                frozen.toMap() to userIdByAssistant.toMap()
                                if (file != null) addFile(file)
                                if (history.isNotEmpty()) {
                                if (next != null) "$failed\n$next" else failed
                                if (pendingThinkingIds.isNotEmpty()) {
                                isDropping = false
                                isDropping = true
                                isInteractive = !uiState.isLoading,
                                isUsingSharedKey = uiState.showPrivacyInfo,
                                modifier = Modifier.fillMaxWidth().weight(1f),
                                node = block.node,
                                onCallback = { event, data ->
                                onOpenKaiBuild = onOpenKaiBuild,
                                onStartInteractiveMode = uiState.actions.enterInteractiveMode
                                return file != null
                                shouldStartDragAndDrop = shouldStartDragAndDrop,
                                style = MaterialTheme.typography.bodyLarge,
                                super.onEntered(event)
                                super.onExited(event)
                                target = dropTarget,
                                text = stringResource(Res.string.interactive_ui_parsing_failed),
                                val byAnswerId = mutableMapOf<String, ImmutableList<String>>()
                                val failed = stringResource(Res.string.fallback_service_failed, status.serviceName, uiErrorText(status.errorReason))
                                val file = onDragAndDropEventDropped(event)
                                val frozen = mutableMapOf<String, FrozenSubmission>()
                                val history = uiState.history
                                val lastUserIdx = history.indexOfLast { it.role == History.Role.USER }
                                val next = status.nextServiceName?.let { stringResource(Res.string.fallback_trying_next, it) }
                                val pending = mutableListOf<String>()
                                val pendingThinkingIds = mutableListOf<String>()
                                val suppressed = mutableSetOf<String>()
                                val userIdByAssistant = mutableMapOf<String, String>()
                                wrapInCard = false,
                                }
                                },
                            )
                            ),
                            .blur(radius = if (isDropping) 4.dp else 0.dp)
                            .dragAndDropTarget(
                            .fillMaxSize()
                            .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp + bottomPadding),
                            .verticalScroll(rememberScrollState())
                            // Group every reasoning segment in a response (intermediate tool-call /
                            // Interactive UI mode isn't offered on on-device LiteRT: the kai-ui
                            // Pair every user submission with its originating assistant so the kai-ui
                            // answer-bearing assistant message, so each response shows a single
                            // attend to, and even the minimal variant we tried was unreliable.
                            // collapsible "Thinking" section instead of N standalone ones.
                            // component schema is too large for small Gemma models to coherently
                            // renders once (on the assistant side) with a frozen snapshot — never as a
                            // separate user-side card. pressedEvent + values persist across the loading
                            // thinking-only turns plus the final answer's own reasoning) under the
                            // transition; isPending is only set for the latest in-flight submission.
                            Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
                            EmptyState(
                            KaiUiRenderer(
                            LaunchedEffect(uiState.history.size) {
                            Text(
                            bottomPadding = 88.dp,
                            color = MaterialTheme.colorScheme.onBackground,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            inputExpanded = false
                            modifier = Modifier.fillMaxSize(),
                            modifier = Modifier.padding(top = 4.dp),
                            override fun onDrop(event: DragAndDropEvent): Boolean {
                            override fun onEntered(event: DragAndDropEvent) {
                            override fun onExited(event: DragAndDropEvent) {
                            style = MaterialTheme.typography.bodyMedium,
                            style = MaterialTheme.typography.titleLarge,
                            text = stringResource(Res.string.interactive_welcome_subtitle),
                            text = stringResource(Res.string.interactive_welcome_title),
                            uiState = uiState,
                            uiState.actions.ask(it)
                            val (reasoningSegmentsByAssistantId, suppressedThinkingIds) = remember(uiState.history) {
                            val componentScope = rememberCoroutineScope()
                            val executingToolsState = rememberExecutingTools(uiState.history)
                            val fallbackStatusText = uiState.fallbackStatus?.let { status ->
                            val frozenByAssistantId = pairings.first
                            val lastAssistantId = remember(uiState.history) { uiState.history.lastRenderedAssistant()?.id }
                            val listState = rememberLazyListState()
                            val pairings = remember(uiState.history, uiState.isLoading) {
                            val primaryIsOnDevice = uiState.availableServices
                            val showScrollToBottom by remember {
                            val userIdByAssistantId = pairings.second
                            }
                        )
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                        .weight(1f)
                        BorderStroke(2.dp, gradientBrush),
                        Column(horizontalAlignment = CenterHorizontally) {
                        InteractiveModeContent(
                        LogoAnimation()
                        Modifier
                        RoundedCornerShape(28.dp),
                        Spacer(Modifier.height(16.dp))
                        Text(
                        addFile = uiState.actions.addFile,
                        ask = {
                        availableServices = interactiveServices,
                        cancel = uiState.actions.cancel,
                        error = error,
                        files = uiState.files,
                        for (block in uiBlocks) {
                        horizontalAlignment = CenterHorizontally,
                        icon = Icons.Default.Edit,
                        icon = Res.drawable.ic_stop,
                        if (uiState.history.isEmpty()) {
                        installedSkills = uiState.installedSkills,
                        isLoading = uiState.isLoading,
                        isPulsing = true,
                        modifier = Modifier
                        modifier = Modifier.align(Alignment.BottomEnd),
                        modifier = Modifier.align(Alignment.Center),
                        mutableStateOf(false)
                        object : DragAndDropTarget {
                        onClick = { inputExpanded = true },
                        onClick = { uiState.actions.cancel() },
                        onSelectService = uiState.actions.selectService,
                        onTextStateChange = { questionInputText = it },
                        removeFile = uiState.actions.removeFile,
                        retry = uiState.actions.retry,
                        services = interactiveServices,
                        supportedFileExtensions = uiState.supportedFileExtensions,
                        textState = questionInputText,
                        verticalArrangement = Arrangement.Center,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        }
                        } else {
                        },
                    )
                    ) {
                    .align(Alignment.BottomEnd)
                    .animatedGradientBorder(cornerRadius = 28.dp),
                    .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(28.dp))
                    .border(
                    .clip(RoundedCornerShape(28.dp))
                    .handCursor()
                    .height(56.dp)
                    .matchParentSize()
                    .padding(16.dp)
                    .padding(horizontal = 7.dp),
                    // AI responded with no valid kai-ui AND there's no API error underneath —
                    // set, the ErrorMessage overlay below takes over with the correct message.
                    // this is a genuine parse failure (retries exhausted). When an API error is
                    BackIcon,
                    Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    CircleIconButton(
                    Column(
                    ErrorMessage(error = error, retry = uiState.actions.retry)
                    FreeProviderSuggestionsPanel(
                    QuestionInput(
                    SelectionContainer {
                    ServiceSelector(
                    TrailingIcon(
                    addFile = uiState.actions.addFile,
                    ask = uiState.actions.ask,
                    availableServices = uiState.availableServices,
                    cancel = uiState.actions.cancel,
                    color = MaterialTheme.colorScheme.error,
                    contentDescription = stringResource(Res.string.interactive_back_content_description),
                    executingTools = remember { kotlinx.collections.immutable.persistentListOf() },
                    files = uiState.files,
                    installedSkills = uiState.installedSkills,
                    isLoading = uiState.isLoading,
                    isSandboxOpen = false
                    keyboardController?.hide()
                    modifier = Modifier
                    onCancelSandbox = sandboxViewModel?.let { { it.onCancelSandbox() } } ?: {},
                    onSelectService = uiState.actions.selectService,
                    onSetupSandbox = sandboxViewModel?.let { { it.onSetupSandbox() } } ?: {},
                    onTextStateChange = { questionInputText = it },
                    previewLines = previewSandboxLines,
                    removeFile = uiState.actions.removeFile,
                    sandboxState = sandboxState,
                    showHistorySheet = true
                    style = MaterialTheme.typography.bodySmall,
                    supportedFileExtensions = uiState.supportedFileExtensions,
                    text = stringResource(warning),
                    textState = questionInputText,
                    tint = iconColor,
                    uiState.actions.clearUnreadHeartbeat()
                    uiState.heartbeatConversationId?.let { uiState.actions.loadConversation(it) }
                    val addFile by rememberUpdatedState(uiState.actions.addFile)
                    val canAcceptDrop by rememberUpdatedState(uiState.supportedFileExtensions.isNotEmpty())
                    val dropTarget = remember {
                    val shouldStartDragAndDrop = remember { { _: DragAndDropEvent -> canAcceptDrop } }
                    var isDropping by remember {
                    }
                )
                // Content area fills remaining space
                // Full QuestionInput stays in the column flow
                Box(Modifier.weight(1f)) {
                Icon(
                Icons.Default.Close,
                Modifier
                QuestionInput(
                SandboxTabsContent(
                Text(
                WaitingResponseRow(
                actions = uiState.actions,
                contentDescription = stringResource(Res.string.interactive_exit_content_description),
                drafts = uiState.smsDrafts,
                enabled = !isLoading,
                hasSavedConversations = filteredConversations.any { it.id != uiState.currentConversationId },
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                if (!hasAssistantResponse && !uiState.isLoading) {
                if (interactiveServices.size > 1) {
                if (showFullInput) {
                if (uiBlocks.isNotEmpty()) {
                if (uiState.isLoading) {
                if (uiState.showFreeProviderSuggestions) {
                isChatHistoryEmpty = uiState.history.isEmpty(),
                isLoading = uiState.isLoading,
                isSandboxAvailable = isSandboxAvailable,
                isSandboxOpen = isSandboxOpen,
                isShellExecuting = isShellExecuting,
                isSpeaking = uiState.isSpeaking,
                isSpeechOutputEnabled = uiState.isSpeechOutputEnabled,
                isStatusOnly = executing.any { it.isStatusMessage },
                modifier = Modifier
                modifier = Modifier.fillMaxSize(),
                modifier = Modifier.handCursor(),
                navigationTabBar = navigationTabBar,
                onBack = uiState.actions.goBackInteractiveMode,
                onClick = onBack,
                onDiscard = uiState.actions.discardSmsDraft,
                onDismiss = {
                onExit = uiState.actions.exitInteractiveMode,
                onNavigateToSettings = onNavigateToSettings,
                onSend = uiState.actions.sendSmsDraft,
                onShowHistory = {
                onTap = {
                onToggleSandbox = { isSandboxOpen = !isSandboxOpen },
                showBack = hasAssistantResponse,
                targetState = contentId,
                textToSpeech = textToSpeech,
                tint = iconColor,
                tools = executing.map { it.id to (it.toolName ?: "tool") }.toImmutableList(),
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                val blocks = remember(lastAssistant.content) { parseMarkdown(lastAssistant.content).blocks }
                val isPreview = LocalInspectionMode.current
                val liveState = sandboxViewModel?.state?.collectAsStateWithLifecycle()?.value
                val sandboxState = liveState ?: previewSandboxState ?: SandboxUiState()
                val sandboxViewModel = if (!isPreview) koinViewModel<SandboxViewModel>() else null
                val uiBlocks = blocks.filterIsInstance<KaiUiBlock>()
                verticalAlignment = Alignment.CenterVertically,
                visible = uiState.hasUnreadHeartbeat,
                }
                } else if (uiState.error == null) {
                } else {
                },
            )
            ) {
            ) { _ ->
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .fillMaxWidth(),
            .filter { supportsAgenticFlows(it.serviceId, it.modelId) }
            .imePadding(),
            .navigationBarsPadding()
            .statusBarsPadding()
            .toImmutableList()
            // First load — show centered loading
            // Placeholder to keep close button aligned right
            // Top bar with back and close
            AnimatedContent(
            Box(
            Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            ExecutingToolsState(
            HeartbeatBanner(
            Icon(
            IconButton(
            InteractiveModeTopBar(
            PendingSmsBanners(
            Row(
            Snackbar(snackbarData = data)
            Spacer(Modifier.size(48.dp))
            TopBar(
            actions = uiState.actions,
            color = MaterialTheme.colorScheme.onSurface,
            conversations = filteredConversations,
            currentConversationId = uiState.currentConversationId,
            historyState.value.any { it.role == History.Role.TOOL_EXECUTING && it.content == "execute_shell_command" }
            hostState = snackbarHostState,
            if (!isSandboxOpen) {
            if (isSandboxOpen) isSandboxOpen = false
            if (isSandboxOpen) {
            initialSandboxOpen = initialSandboxOpen,
            isKaiBuildOpen = false
            isSandboxAvailable = isSandboxAvailable,
            lastConversationId = uiState.currentConversationId
            modifier = Modifier.align(BottomCenter).padding(bottom = 80.dp),
            modifier = Modifier.handCursor(),
            navigationTabBar = navigationTabBar,
            onClick = onExit,
            onConversationSelected = { isSandboxOpen = false },
            onDismiss = { showHistorySheet = false },
            onNavigateToSettings = onNavigateToSettings,
            onOpenKaiBuild = { isKaiBuildOpen = true }.takeIf { isKaiBuildAvailable },
            pendingConversationDeletion = uiState.pendingConversationDeletion,
            previewSandboxLines = previewSandboxLines,
            previewSandboxState = previewSandboxState,
            selection = TextRange(prefill.length),
            style = MaterialTheme.typography.titleMedium,
            text = prefill,
            text = stringResource(Res.string.interactive_title),
            textToSpeech = textToSpeech,
            uiState = uiState,
            uiState.warning?.let { warning ->
            val contentId = lastAssistant.id
            val executing = historyState.value.filter { it.role == History.Role.TOOL_EXECUTING }
            val gradientBrush = com.inspiredandroid.kai.ui.gradientBrush
            }
            } else {
        )
        ) {
        ) { data ->
        // "Start Interactive UI" button's border on the empty state.
        // Animated gradient frame signals the AI is working, mirroring the
        // Collapsed pill floats over content at the bottom-end
        // Error state
        ChatHistorySheet(
        Column(Modifier.fillMaxSize()) {
        IconButton(
        Modifier
        SnackbarHost(
        Spacer(Modifier.weight(1f))
        Text(
        derivedStateOf {
        else -> ChatModeScreen(
        if (!showFullInput) {
        if (hasAssistantResponse) inputExpanded = false
        if (isSandboxOpen) isSandboxOpen = false
        if (lastConversationId != uiState.currentConversationId) {
        if (pendingId != null) uiState.savedConversations.filter { it.id != pendingId }.toImmutableList() else uiState.savedConversations
        if (showBack) {
        if (uiState.composerPrefill != null && isKaiBuildOpen) {
        if (uiState.isLoading && lastAssistant == null) {
        if (uiState.isLoading) {
        isKaiBuildAvailable = isKaiBuildAvailable,
        isKaiBuildOpen -> KaiBuildScreen(onExit = { isKaiBuildOpen = false })
        isSandboxAvailable = isSandboxAvailable,
        modifier = Modifier
        mutableStateOf(TextFieldValue(""))
        navigationTabBar = navigationTabBar,
        onNavigateToSettings = onNavigateToSettings,
        questionInputText = TextFieldValue(
        snackbarHostState.showSnackbar(getString(resource))
        textToSpeech = textToSpeech,
        uiState = uiState,
        uiState.actions.clearSnackbar()
        uiState.actions.consumeComposerPrefill()
        uiState.actions.exitInteractiveMode()
        uiState.availableServices
        uiState.error?.let { error ->
        uiState.history.any { it.role == History.Role.ASSISTANT }
        uiState.isInteractiveMode && !uiState.isRestoring -> InteractiveModeScreen(
        val pendingId = uiState.pendingConversationDeletion
        val prefill = uiState.composerPrefill ?: return@LaunchedEffect
        val resource = uiState.snackbarMessage ?: return@LaunchedEffect
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        }
        } else if (lastAssistant != null) {
        } else {
    )
    ) {
    // Hoisted here so the draft survives toggling the sandbox/terminal view, which
    // Interactive mode drives a tool-calling loop and emits kai-ui JSON, so the
    // Intercept system back to exit interactive mode instead of closing the app
    // Kai Build is a transient surface, not a conversation — unlike interactive
    // Shared text opens a new chat; leave Kai Build so the composer is visible.
    // Streaming tokens mutate `history` on every frame but rarely change this derived slice.
    // When the active conversation changes (e.g. user starts a new chat from the
    // Wrap the history parameter in State so derivedStateOf can observe it, then
    // firing on the initial composition — important when returning from Settings,
    // mode it needs no persistence beyond surviving configuration changes.
    // only recompute (and only emit) when the executing-tools subset actually changes.
    // removes QuestionInput from composition and would otherwise drop the text.
    // switcher only lists services/models capable of agentic flows.
    // top bar or taps the heartbeat banner), collapse the sandbox view so the
    // user lands on the chat they just opened. Tracking the previous id avoids
    // where rememberSaveable has just restored isSandboxOpen.
    Box(
    Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).navigationBarsPadding().statusBarsPadding().imePadding()) {
    Box(modifier.fillMaxWidth()) {
    ChatScreenContent(
    ExperimentalFoundationApi::class,
    LaunchedEffect(hasAssistantResponse, uiState.history.size) {
    LaunchedEffect(uiState.composerPrefill) {
    LaunchedEffect(uiState.currentConversationId) {
    LaunchedEffect(uiState.snackbarMessage) {
    Row(
    bottomPadding: androidx.compose.ui.unit.Dp = 0.dp,
    com.inspiredandroid.kai.PlatformBackHandler(enabled = true) {
    if (showHistorySheet) {
    initialSandboxOpen: Boolean = false,
    isKaiBuildAvailable: Boolean = false,
    isLoading: Boolean,
    isSandboxAvailable: Boolean = false,
    isSandboxAvailable: Boolean,
    modifier: Modifier = Modifier,
    navigationTabBar: (@Composable () -> Unit)? = null,
    navigationTabBar: (@Composable () -> Unit)?,
    onBack: () -> Unit,
    onExit: () -> Unit,
    onNavigateToSettings: () -> Unit = {},
    onNavigateToSettings: () -> Unit,
    onOpenKaiBuild: (() -> Unit)?,
    previewSandboxLines: ImmutableList<TerminalLine> = persistentListOf(),
    previewSandboxState: SandboxUiState? = null,
    return state
    showBack: Boolean,
    textToSpeech: TextToSpeechInstance? = null,
    textToSpeech: TextToSpeechInstance?,
    uiState: ChatUiState,
    val filteredConversations = remember(uiState.savedConversations, uiState.pendingConversationDeletion) {
    val hasAssistantResponse = remember(uiState.history) {
    val historyState = rememberUpdatedState(history)
    val historyState = rememberUpdatedState(uiState.history)
    val iconColor = MaterialTheme.colorScheme.onSurface
    val interactiveServices = remember(uiState.availableServices) {
    val isShellExecuting by remember {
    val isStatusOnly: Boolean,
    val keyboardController = LocalSoftwareKeyboardController.current
    val lastAssistant = remember(uiState.history) { uiState.history.lastRenderedAssistant() }
    val showFullInput = inputExpanded && !uiState.isLoading
    val snackbarHostState = remember { SnackbarHostState() }
    val state by remember {
    val tools: ImmutableList<Pair<String, String>>,
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    var inputExpanded by remember { mutableStateOf(true) }
    var isKaiBuildOpen by rememberSaveable { mutableStateOf(false) }
    var isSandboxOpen by rememberSaveable { mutableStateOf(initialSandboxOpen) }
    var lastConversationId by remember { mutableStateOf(uiState.currentConversationId) }
    var questionInputText by rememberSaveable(stateSaver = TextFieldValue.Saver) {
    var showHistorySheet by remember { mutableStateOf(false) }
    viewModel: ChatViewModel = koinViewModel(),
    when {
    }
)
) {
// --- Interactive Mode ---
// --- Regular Chat Mode ---
@Composable
@file:OptIn(
fun ChatScreen(
fun ChatScreenContent(
private data class ExecutingToolsState(
private fun ChatModeScreen(
private fun InteractiveModeContent(
private fun InteractiveModeScreen(
private fun InteractiveModeTopBar(
private fun rememberExecutingTools(history: ImmutableList<History>): ExecutingToolsState {
}
