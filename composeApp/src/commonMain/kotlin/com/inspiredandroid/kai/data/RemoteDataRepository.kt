
                                arguments = it.arguments,
                                content = content,
                                content = turn.content,
                                fallbackServiceName = fallbackServiceName,
                                id = "inline-${Uuid.random()}",
                                name = it.name,
                                put("description", param.description)
                                put("type", param.type)
                                reasoningContent = turn.reasoningContent,
                                role = History.Role.ASSISTANT,
                                role = History.Role.TOOL,
                                toolCallId = callId,
                                toolName = name,
                            )
                            ),
                            History(
                            History.Role.ASSISTANT -> "assistant"
                            History.Role.TOOL -> "tool"
                            History.Role.TOOL_EXECUTING -> "tool" // Should not happen due to filter
                            History.Role.USER -> "user"
                            ToolCallInfo(
                            ToolCallInfo(id = callId, name = name, arguments = arguments),
                            arguments = fc.arguments ?: "{}",
                            attachments = attachments,
                            content = name,
                            content = question,
                            content = result,
                            content = result.textContent,
                            descriptionRes = it.descriptionRes,
                            errorReason = ContextWindowExceededException().toUiError(),
                            id = executingIds[index],
                            id = fc.callId ?: Uuid.random().toString(),
                            id = it.id,
                            isSelected = it.id == selectedModelId,
                            isThinking = result.isThinkingContent,
                            name = fc.name.orEmpty(),
                            nextServiceName = fallbackEntries.getOrNull(index + 1)?.service?.displayName,
                            put(paramName, raw)
                            putJsonObject(paramName) {
                            reasoningContent = result.reasoningContent,
                            requests.getOpenAICompatibleModels(service, creds).getOrThrow().data,
                            role = History.Role.ASSISTANT,
                            role = History.Role.TOOL,
                            role = History.Role.TOOL_EXECUTING,
                            role = History.Role.USER,
                            selectedModelId,
                            service,
                            serviceName = entry.service.displayName,
                            subtitle = it.subtitle,
                            toolCallId = callId,
                            toolCalls = result.toolCalls.toImmutableList(),
                            toolName = name,
                            toolName = toolDisplayName,
                            uiSubmission = uiSubmission,
                            }
                        (obj["text"] as? JsonPrimitive)?.content?.length ?: 0
                        )
                        ),
                        100 // Fixed small cost for image references
                        History(
                        SettingsModel(
                        ToolCallInfo(
                        Triple(callId, name, result)
                        _fallbackStatus.value = FallbackStatus(
                        add(
                        arguments = argsJson,
                        attachments = h.attachments,
                        calls = extracted.calls.map {
                        content = "",
                        content = h.content,
                        content = name,
                        continue
                        credentials = credentials,
                        data = Base64.encode(compressed),
                        errorReason = e.toUiError(),
                        fileName = null,
                        id = "gemini-${Uuid.random()}",
                        id = block.id ?: "anthropic-${Uuid.random()}",
                        id = executingId,
                        id = h.id,
                        id = it.id,
                        if (entry.id != executingId) add(entry)
                        if (entry.role != History.Role.TOOL_EXECUTING) add(entry)
                        if (raw != null) {
                        isSelected = it.id == selectedModelId,
                        isThinking = h.isThinking,
                        lastException = ContextWindowExceededException()
                        mapOpenAICompatibleModels(
                        messages = buildAnthropicMessages(messages),
                        messages = geminiMessages,
                        messages = messages.map { it.toGeminiMessageDto() },
                        messages = msgs,
                        mimeType = "image/jpeg",
                        name = block.name ?: "unknown",
                        name = fc.name,
                        nextServiceName = fallbackEntries.getOrNull(index + 1)?.service?.displayName,
                        reasoningContent = h.reasoningContent,
                        reasoningContent = response.reasoningSummary,
                        requestTimeoutMs = requestTimeoutMs,
                        requests.openAIResponses(service, credentials, toResponsesInput(msgs), tools).getOrThrow()
                        requests.openAIResponses(service, credentials, toResponsesInput(openAIMessages), requestTimeoutMs = requestTimeoutMs).getOrThrow()
                        role = History.Role.ASSISTANT,
                        role = History.Role.TOOL_EXECUTING,
                        role = when (h.role) {
                        serviceName = entry.service.displayName,
                        subtitle = "${it.displayName} (${formatFileSize(it.sizeBytes)})",
                        systemInstruction = systemPrompt,
                        textContent = extracted.cleanedText
                        textContent = text.orEmpty(),
                        thoughtSignature = part.thoughtSignature,
                        toolCalls = calls,
                        toolCalls = persistentListOf(
                        toolName = displayName,
                        tools = tools,
                        uiSubmission = h.uiSubmission,
                        val raw = param.rawSchema
                        val result = toolExecutor.executeTool(name, arguments, conversationIdSnapshot)
                        }
                        } else {
                        },
                    "tool" -> History.Role.TOOL
                    "user" -> History.Role.USER
                    )
                    ),
                    ).getOrThrow()
                    .firstOrNull { Service.fromId(it.serviceId).isOnDevice }
                    .orEmpty()
                    // On-device services should not silently fall back — surface the error
                    // compressImageBytes can fall back to the original bytes on failure or on
                    // platforms without compression — guard against Base64 OOM for oversized input.
                    ?.let { appSettings.getInstanceModelId(it.instanceId) }
                    ?.let { trimHistoryForContext(merged, systemPrompt?.length ?: 0, it) }
                    ?: merged
                    Attachment(
                    Conversation.Message(
                    History(
                    SettingsModel(
                    ToolCallInfo(
                    ToolCallInfo(id = tc.id, name = tc.function.name, arguments = tc.function.arguments)
                    _fallbackStatus.value = FallbackStatus(
                    add(
                    appendLine("$role: ${msg.content}")
                    askWithService(entry.service, messages, systemPrompt, entry.instanceId)
                    async {
                    content = JsonPrimitive(bailoutPrompt(reason)),
                    continue
                    data = Base64.encode(rawBytes),
                    delay((attempt + 1).seconds)
                    descriptionJsonString = localToolDescriptionJson(tool),
                    else -> History.Role.ASSISTANT
                    email = account.email,
                    end++
                    execute = { jsonArgs -> runLocalToolWithUiFeedback(tool.schema.name, jsonArgs, history) },
                    fallbackServiceName = entry.service.displayName
                    fetchModelsForInstance(service, instanceId) { creds, selectedModelId ->
                    fileName = fileName,
                    for ((callId, name, content) in toolResults) {
                    for ((paramName, param) in tool.schema.parameters) {
                    for (entry in h) {
                    id = selectedModelId,
                    if (compressed.size > MAX_IMAGE_BYTES) throw FileTooLargeException()
                    if (content == null && strictEmptyResponse) throw OpenAICompatibleEmptyResponseException()
                    if (e is kotlinx.coroutines.CancellationException) throw e
                    if (entry.service.isOnDevice) throw e
                    if (extracted.calls.isNotEmpty()) {
                    if (historyChars > entryWindowChars) {
                    if (text == null && calls.isEmpty()) throw OpenAICompatibleEmptyResponseException()
                    if (type == "text") {
                    isManualEntry = true,
                    isSelected = true,
                    isThinkingContent = message.isContentFromReasoning,
                    it.toMutableList().apply {
                    lastError = state.lastError,
                    lastException = e
                    lastSyncEpochMs = state.lastSyncEpochMs,
                    mimeType = "application/pdf",
                    mimeType = fileMimeType ?: "text/plain",
                    name = tool.schema.name,
                    persistentListOf(Attachment(data = m.data, mimeType = m.mimeType, fileName = m.fileName))
                    reasoningContent = message.reasoningTraceFor(textContent),
                    requests.anthropicChat(
                    requests.geminiChat(
                    requests.openAICompatibleChat(service, credentials, msgs, tools, sessionId = sessionId).getOrThrow()
                    requests.openAICompatibleChat(service, credentials, openAIMessages, sessionId = sessionId, requestTimeoutMs = requestTimeoutMs).getOrThrow()
                    response.throwIfFailed(service)
                    return AssistantTurn(content.orEmpty(), response.reasoningSummary)
                    return LoopChatResult(
                    role = "user",
                    subtitle = "",
                    textContent = textContent,
                    tool.schema.parameters.filter { it.value.required }.keys.forEach { add(it) }
                    toolCalls = calls,
                    unreadCount = state.unreadCount,
                    updateModelsForInstance(instanceId, models, service)
                    val argsJson = block.input?.toString() ?: "{}"
                    val argsJson = fc.args?.let { JsonObject(it).toString() } ?: "{}"
                    val calls = response.functionCalls.map { fc ->
                    val compressed = compressImageBytes(rawBytes, fileMimeType ?: "image/jpeg")
                    val content = response.outputText
                    val creds = instanceCredentials(entry.instanceId, entry.service)
                    val entryWindowChars = ModelCatalog.estimateContextWindow(creds.modelId) * ESTIMATED_CHARS_PER_TOKEN
                    val extracted = extractInlineToolCalls(textContent, tools)
                    val fc = part.functionCall!!
                    val models = service.defaultModels.map {
                    val obj = element as? JsonObject
                    val response = call {
                    val response = retryApiCall {
                    val role = if (msg.role == History.Role.USER) "User" else "Assistant"
                    val selectedModelId = appSettings.getInstanceModelId(instanceId)
                    val text = response.outputText
                    val type = (obj?.get("type") as? JsonPrimitive)?.content
                    }
                    } else {
                ""
                """{"success": false, "error": "${e.message ?: "Tool execution failed"}"}"""
                )
                ),
                .filter { it.role != History.Role.TOOL_EXECUTING }
                .map { h ->
                // Bailout sends no tools — strip historic tool_calls to satisfy strict validators.
                // For thinking-only turns, the reasoning text already became the content via
                // No Sonar `/models` list — validate the key, then load the curated defaults.
                // No retry wrapper here: each network call retries inside askWithService.
                // No tools on this request — strip any historic tool_calls so Groq's strict
                // On-device models handle their own context limits, so skip this check for them
                // Retrying the whole call would re-enter the tool loop against a chat
                // Skip fallback services whose context window is too small for the current history
                // Vision messages: only count text parts, not base64 image data
                // `isContentFromReasoning`, so don't surface it again as a reasoning trace.
                // history already mutated by the failed attempt.
                // validator doesn't see calls to tools we no longer declare.
                AllServicesFailedException()
                AssistantTurn(content.orEmpty(), message?.reasoningTraceFor(content))
                AssistantTurn(response.extractText())
                EmailAccountSummary(
                FileCategory.IMAGE -> MAX_RAW_IMAGE_BYTES.toLong()
                FileCategory.IMAGE -> {
                FileCategory.PDF -> Attachment(
                FileCategory.PDF -> MAX_PDF_BYTES.toLong()
                FileCategory.TEXT -> Attachment(
                FileCategory.TEXT -> MAX_TEXT_FILE_BYTES.toLong()
                FileCategory.UNSUPPORTED -> 0L
                FileCategory.UNSUPPORTED -> throw UnsupportedFileTypeException()
                History.Role.ASSISTANT -> InferenceMessage(role = "assistant", content = msg.content)
                History.Role.USER -> InferenceMessage(role = "user", content = msg.content)
                LocalTool(
                SettingsModel(
                add(
                appSettings.setInstanceCustomModelId(instanceId, listModelId)
                appSettings.setInstanceModelId(instanceId, default.id)
                askWithService(service, messages, systemPrompt, targetInstance.instanceId, localHistory).content
                attachments = attachments,
                break
                buildList(h.size) {
                chatHistory.update {
                com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message(
                consecutiveCount++
                content = "",
                content = m.content,
                content.sumOf { element ->
                createdAt = now,
                delay((MIN_TOOL_DISPLAY_MS - elapsed).milliseconds)
                delay(MIN_TOOL_DISPLAY_MS.milliseconds - elapsed.milliseconds)
                descriptionRes = it.descriptionRes,
                else -> null
                else -> persistentListOf()
                engine.initialize(model, contextTokens)
                false
                fetchInstanceModels(service, instanceId)
                flow.update { m -> m.map { it.copy(isSelected = it.id == default.id) } }
                getConfiguredServiceInstances()
                groups.add(listOf(msg))
                groups.add(nonSystemMessages.subList(index, end).toList())
                history
                history.filter { h -> h.id !in executingIds }
                history.subList(0, lastUserIndex + 1)
                history.update { h -> h.filter { it.id != statusEntry.id } }
                i -= batchSize
                id = id,
                id = it.id,
                id = m.id,
                if (!entry.service.isOnDevice) {
                if (attempt < MAX_API_RETRIES) {
                if (calls.isEmpty() && textContent.contains("<tool_call>")) {
                if (content == null && strictEmptyResponse) throw OpenAICompatibleEmptyResponseException()
                if (e is kotlinx.coroutines.CancellationException) throw e
                if (h.none { it.id == executingId }) h else h.filter { it.id != executingId }
                if (index > 0) {
                if (isNonRetryableException(e)) throw e
                if (msg.role == History.Role.USER || msg.role == History.Role.ASSISTANT) {
                if (requiresResponsesApi(service, credentials.modelId, credentials.baseUrl)) {
                if (service.modelsUrl != null) {
                if (useResponsesApi) {
                index = end
                index++
                isSelected = it.id == selectedModelId,
                isStatusMessage = true,
                isThinking = m.isThinking,
                it.toMutableList().apply {
                lastException = e
                lastException ?: OpenAICompatibleEmptyResponseException()
                loadConversation(latest.id)
                m.attachments.isNotEmpty() -> m.attachments.toImmutableList()
                m.data != null && m.mimeType != null ->
                mapAnthropicModels(requests.getAnthropicModels(creds).getOrThrow().data, selectedModelId)
                mapGeminiModels(requests.getGeminiModels(creds).getOrThrow().models, selectedModelId)
                messages = emptyList(),
                put("type", "object")
                putJsonArray("required") {
                putJsonObject("properties") {
                reasoningContent = m.reasoningContent,
                requests.openAIResponses(service, credentials, toResponsesInput(bailoutMessages)).getOrThrow()
                requests.validateOpenRouterApiKey(creds).getOrThrow()
                requests.validatePerplexityApiKey(creds).getOrThrow()
                result.toolCalls.map { Triple(it.id, it.name, it.arguments) },
                return
                return AssistantTurn(result.textContent, reasoning)
                return AssistantTurn(strategy.bailout(visible, systemPrompt, BailoutReason.LIMIT_REACHED))
                return AssistantTurn(strategy.bailout(visible, systemPrompt, BailoutReason.REPEATING))
                return LoopChatResult(
                return LoopChatResult(textContent = textContent, toolCalls = toolCallInfos)
                return block()
                return makeFinalCallWithoutTools(service, credentials, msgs, reason, useResponsesApi)
                role = History.Role.TOOL_EXECUTING,
                role = when (m.role) {
                saveCurrentConversation()
                skillManager.load()
                smsDraftStore.updateStatus(draftId, SmsDraftStatus.FAILED, result.message)
                smsDraftStore.updateStatus(draftId, SmsDraftStatus.SENT)
                strategy.historyContextWindowTokens
                subtitle = it.subtitle,
                toolCalls.map { (callId, name, arguments) ->
                toolExecutor.executeTool(name, arguments, conversationIdForTool)
                toolName = "Initializing ${model.displayName}",
                true
                type = Conversation.TYPE_HEARTBEAT,
                uiSubmission = m.uiSubmission,
                updateModelsForInstance(instanceId, models, service)
                updatedAt = now,
                val content = message?.effectiveContent
                val downloaded = engine.getDownloadedModels()
                val engine = localInferenceEngine ?: return
                val geminiMessages = history.map { it.toGeminiMessageDto() }
                val merged = buildList(h.size + toolResults.size) {
                val message = response.choices.firstOrNull()?.message
                val message = response.choices.firstOrNull()?.message ?: throw OpenAICompatibleEmptyResponseException()
                val models = downloaded.map {
                val msgs = buildAnthropicMessages(history)
                val msgs = trimMessagesForContext(buildOpenAIMessages(service, history, systemPrompt, credentials.modelId, declaredToolNames = emptySet()), contextWindowTokens)
                val msgs = trimMessagesForContext(buildOpenAIMessages(service, history, systemPrompt, credentials.modelId, declaredToolNames), contextWindowTokens)
                val openAIMessages = buildOpenAIMessages(service, messages, systemPrompt, credentials.modelId, declaredToolNames = emptySet())
                val parts = response.candidates.firstOrNull()?.content?.parts.orEmpty()
                val partsWithFunctionCalls = parts.filter { it.functionCall != null }
                val reasoning = result.reasoningContent?.takeIf { !result.isThinkingContent }
                val response = call {
                val response = retryApiCall {
                val selectedModelId = appSettings.getInstanceModelId(instanceId)
                val sessionId = activeConversationId()
                val state = emailStore.getSyncState(account.id)
                val textContent = parts.filterNot { it.isThought }.mapNotNull { it.text }.joinToString("\n")
                val textContent = response.content.filter { it.type == "text" }.mapNotNull { it.text }.joinToString("\n")
                val toolCallInfos = partsWithFunctionCalls.map { part ->
                val toolCallInfos = toolUseBlocks.map { block ->
                val toolUseBlocks = response.content.filter { it.type == "tool_use" }
                val turn = try {
                var calls = message.toolCalls.orEmpty().map { tc ->
                var end = index + 1
                var textContent = message.effectiveContent ?: ""
                while (end < nonSystemMessages.size && nonSystemMessages[end].role == "tool") {
                }
                } catch (e: Exception) {
                } else if (service.defaultModels.isNotEmpty()) {
                },
                }.awaitAll()
            )
            ) + defaultSettingsModels
            ),
            .filter { !it.service.isOnDevice || localInferenceEngine != null }
            .filter { it.service != Service.Free }
            // (`ask()`/`askWithTools()`) pre-fetched a CHAT_REMOTE prompt, but on-device
            // No retry: local-inference failures are deterministic, and this path mutates
            // On cancellation the fused update above never ran — drop the stranded
            // Prefer the modern `attachments` field. Fall back to the legacy single-file
            // Prefill from list selection so the field is not empty when the checkbox is first enabled.
            // Re-fetch the system prompt with the CHAT_LOCAL variant — the caller
            // Reject oversized files by stat size before readBytes(), which would otherwise
            // Remove all TOOL_EXECUTING indicators — also on cancellation, so stopping a
            // Retry once without tools so the user gets *some* answer rather than a hard
            // Summarization failed — fall back to dropping old messages
            // The create-skill flow writes a new /root/skills/<id>/SKILL.md via
            // Throwaway history — we don't want tool-execution rows leaking into the
            // allocate a ByteArray large enough to OOM the process on multi-GB inputs.
            // automaticToolCalling = false, so the parser is bypassed entirely on the retry.
            // chat history through tool execution, so a replay could re-run tools.
            // error in the UI. With an empty tool list, LiteRTInferenceEngine sets
            // execute_shell_command; rescan so it shows up in the slash menu and Settings
            // fields for conversations saved before multi-attachment support.
            // indicator. On the success path this is a no-op (id already removed).
            // litert-lm's strict ANTLR function-call parser sometimes rejects malformed
            // needs the trimmed variant.
            // prompt so small on-device models get the right section set.
            // run doesn't strand spinner rows in the chat. Non-suspending, safe in finally.
            // tool-call output from small Gemma models, throwing INVALID_ARGUMENT from JNI.
            // visible chatHistory for a "silent" call. LOCAL variant of the system
            // without a restart. Cheap (one listDirectory) and only runs on those turns.
            ?: deriveTitle(history)
            ?: downloadedModels.firstOrNull()
            ?: instances.firstOrNull { !Service.fromId(it.serviceId).isOnDevice }
            ?: instances.firstOrNull { Service.fromId(it.serviceId).isOnDevice }
            ?: models.firstOrNull()
            ?: return ""
            ?: return ModelImportResult.Failure(ModelImportError.COPY_FAILED, "On-device inference not available")
            ?: return askSilently(prompt)
            ?: throw IllegalStateException("On-device inference not available on this platform")
            ?: throw NoModelDownloadedException()
            Conversation(
            History(
            Service.Anthropic -> fetchModelsForInstance(service, instanceId) { creds, selectedModelId ->
            Service.Anthropic -> handleAnthropicChatWithTools(creds, messages, tools, systemPrompt, history)
            Service.Anthropic -> {
            Service.Free -> { /* Always valid */ }
            Service.Free -> { /* No model listing */ }
            Service.Gemini -> fetchModelsForInstance(service, instanceId) { creds, selectedModelId ->
            Service.Gemini -> handleGeminiChatWithTools(creds, messages, tools, systemPrompt, history)
            Service.Gemini -> {
            Service.LiteRT -> {
            Service.OpenRouter -> {
            Service.Perplexity -> {
            SettingsModel(
            SystemPromptVariant.CHAT_LOCAL -> getLocalSafeTools().isNotEmpty() && localModelDeclaresTools(modelId)
            SystemPromptVariant.CHAT_REMOTE -> !isLimited && getAvailableTools().isNotEmpty()
            _fallbackStatus.value = null
            activeSkill = activeSkill,
            add(
            appSettings.getFreeMode().modelId
            appSettings.getInstanceEffectiveModelId(instanceId).ifEmpty { appSettings.getSelectedModelId(service) }
            appSettings.getMemoryInstructions().ifEmpty { null }
            appSettings.getSelectedModelId(service)
            appSettings.isDynamicUiEnabled() && !isLimited -> ChatPromptUiMode.DYNAMIC_UI
            appSettings.markCurrentConversationMigrated()
            askInternal(question, files, uiSubmission)
            askSilently(summaryPrompt)
            askWithService(service, messages, systemPrompt, targetInstance.instanceId, localHistory).content
            chatHistory.update {
            chatHistory.update { history ->
            chatHistory.value = emptyList()
            chatHistory.value = recentMessages
            content = "[Conversation summary: $summary]",
            content = content,
            createdAt = existing?.createdAt ?: now,
            createdAt = existingConversation?.createdAt ?: now,
            credentials = creds,
            defaultSettingsModels
            else -> ChatPromptUiMode.NONE
            else -> content?.toString()?.length ?: 0
            else -> fetchInstanceModels(service, instanceId)
            else -> handleOpenAICompatibleChatWithTools(service, creds, messages, tools, systemPrompt, history)
            else -> {
            emailAccounts = emailAccounts,
            emailStore.getAccounts().map { account ->
            emptyList()
            engine.chat(messages = inferenceMessages, systemPrompt = systemPrompt, tools = emptyList())
            engine.chat(messages = inferenceMessages, systemPrompt = systemPrompt, tools = localTools)
            engine.initialize(model, contextTokens)
            ensureSelectedModelPresent(models, modelId)
            entries
            entries + freeEntry
            errorMemories = byCategory[MemoryCategory.ERROR].orEmpty(),
            fetchInstanceModels(service, instanceId)
            firstUserMessage
            for ((index, entry) in fallbackEntries.withIndex()) {
            for (msg in olderMessages) {
            generalMemories = byCategory[MemoryCategory.GENERAL].orEmpty(),
            getLocalSafeTools().map { tool ->
            hasTools = hasTools,
            heartbeatAdditions = heartbeatAdditions,
            history.update {
            history.update { h ->
            history.update { it + statusEntry }
            icon = service.icon,
            id = Uuid.random().toString(),
            id = conversationId,
            id = heartbeatId,
            if (category == FileCategory.UNSUPPORTED) throw UnsupportedFileTypeException()
            if (default != null) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (elapsed < MIN_TOOL_DISPLAY_MS) {
            if (file.size() > rawSizeLimit) throw FileTooLargeException()
            if (h.role == History.Role.USER) index else null
            if (index >= 0) history.take(index) else history
            if (isRepeatingToolCalls(recentSignatures, signatures)) {
            if (iteration > MAX_TOOL_ITERATIONS) {
            if (lastSpace > 20) truncated.substring(0, lastSpace) + "..." else truncated + "..."
            if (lastUserIndex >= 0) history.take(lastUserIndex) else history
            if (lastUserIndex >= 0) {
            if (latest != null) {
            if (listModelId.isNotBlank()) {
            if (msg.role == "assistant" && !msg.tool_calls.isNullOrEmpty()) {
            if (resolvedSkillId == createSkillId) {
            if (result.toolCalls.isEmpty()) {
            if (service.isOnDevice) {
            if (slice == currentSignatures) {
            if (usedChars + groupChars > availableChars) break
            if (usedChars + msgChars > availableChars) break
            instanceId = instance.instanceId,
            interactiveModeFlag -> ChatPromptUiMode.INTERACTIVE_UI
            is JsonArray -> {
            is JsonPrimitive -> content.content.length
            is SmsSendResult.Failure -> {
            is SmsSendResult.Success -> {
            it.toMutableList().apply {
            iteration++
            kept.add(0, msg)
            kept.addAll(0, group)
            learningMemories = byCategory[MemoryCategory.LEARNING].orEmpty(),
            listOf(
            listOf(freeEntry)
            listOf(freeEntry) + entries
            loadConversation(persistedId)
            localInferenceEngine.releaseInBackground()
            memoryEnabled = memoryEnabled,
            memoryInstructions = memoryInstructions,
            messages = history
            messages = messages,
            modelId = modelId,
            models.firstOrNull { it.id == defaultModel }?.let { return it }
            nowLocalIsoWithOffset = "$localDateTime$offset",
            nowUtcIsoString = now.toString(),
            null
            override suspend fun bailout(history: List<History>, systemPrompt: String?, reason: BailoutReason): String = plainChat(Service.Anthropic, credentials, history, "${bailoutPrompt(reason)} $systemPrompt").content
            override suspend fun bailout(history: List<History>, systemPrompt: String?, reason: BailoutReason): String = plainChat(Service.Gemini, credentials, history, "${bailoutPrompt(reason)} $systemPrompt").content
            override suspend fun bailout(history: List<History>, systemPrompt: String?, reason: BailoutReason): String {
            override suspend fun chat(history: List<History>, systemPrompt: String?): LoopChatResult {
            override val historyContextWindowTokens = contextWindowTokens
            pendingActiveSkillId = null
            pendingTasks = pendingTasks,
            platform = currentPlatform.displayName,
            preferenceMemories = byCategory[MemoryCategory.PREFERENCE].orEmpty(),
            println("LiteRT: tool-call parser failed (${e.message?.take(200)}). Falling back to plain chat.")
            providerName = service.displayName,
            put("description", tool.schema.description)
            put("name", tool.schema.name)
            putJsonObject("parameters") {
            recentSignatures.addAll(signatures)
            requestTimeoutMs = timeoutMs.takeIf { it > 0 },
            requests.openAICompatibleChat(service, credentials, bailoutMessages, sessionId = sessionId).getOrThrow()
            response.throwIfFailed(service)
            retry = false,
            return
            return AssistantTurn(askWithLocalEngine(messages, localPrompt, instanceId, history))
            return askWithLocalEngine(messages, localPrompt, firstInstance.instanceId, MutableStateFlow(messages))
            return askWithLocalEngine(messages, null, instanceId, MutableStateFlow(messages))
            return plainChat(service, creds, messages, systemPrompt, strictEmptyResponse = true)
            return response.outputText.orEmpty()
            return result
            return results
            role = "assistant",
            role = History.Role.ASSISTANT,
            runtime = runtime,
            savedConversations.value.any { it.id == currentId }
            schedulingEnabled = schedulingEnabled,
            service = service,
            serviceId = service.id,
            serviceName = service.displayName,
            setCurrentConversationId(Uuid.random().toString())
            setCurrentConversationId(it)
            setCurrentConversationId(null)
            soul = soul,
            systemPrompt = null,
            throw if (fallbackEntries.size > 1 && lastException != null) {
            timeZoneId = timeZone.id,
            title = title,
            try {
            type = Conversation.TYPE_HEARTBEAT,
            type = existingConversation?.type ?: if (interactiveModeFlag) Conversation.TYPE_INTERACTIVE else Conversation.TYPE_CHAT,
            uiMode = uiMode,
            updatedAt = now,
            usedChars += groupChars
            usedChars += msgChars
            val (_, name, _) = toolCall
            val attachments = when {
            val category = classifyFile(fileMimeType, fileName)
            val default = pickDefaultModel(withSelected, service)
            val elapsed = Clock.System.now().toEpochMilliseconds() - startTime
            val fileMimeType = file.mimeType()?.toString()
            val fileName = file.name
            val groupChars = group.sumOf { estimateMessageChars(it) }
            val index = history.indexOfFirst { it.id == messageId }
            val lastSpace = truncated.lastIndexOf(' ')
            val lastUserIndex = history.indexOfLast { it.role == History.Role.USER }
            val latest = savedConversations.value.maxByOrNull { it.updatedAt }
            val listModelId = appSettings.getInstanceModelId(instanceId)
            val localPrompt = getActiveSystemPrompt(SystemPromptVariant.CHAT_LOCAL)
            val msg = nonSystemMessages[index]
            val msgChars = msg.content.length
            val rawBytes = file.readBytes()
            val rawSizeLimit = when (category) {
            val response = retryApiCall {
            val result = strategy.chat(visible, systemPrompt)
            val result = try {
            val results = coroutineScope {
            val signatures = result.toolCalls.map { "${it.name}:${it.arguments.hashCode()}" }
            val slice = recentSignatures.subList(i, i + batchSize)
            val statusEntry = History(
            val toolDisplayName = toolExecutor.getToolDisplayName(name)
            val toolResults = executeToolCallsInParallel(
            val truncated = firstUserMessage.take(50)
            val visible = history.value.filter { it.role != History.Role.TOOL_EXECUTING }
            variant = variant,
            when (category) {
            when (msg.role) {
            withContext(ConversationIdElement(conversationIdOverride)) {
            }
            } catch (e: Exception) {
            } else {
            } finally {
        )
        ) {
        ).content
        ).ifEmpty { null }
        .filter { it.schema.name in LOCAL_TOOL_ALLOWLIST }
        .filter { it.userToggleable }
        .map { it.copy(isEnabled = appSettings.isToolEnabled(it.id, defaultEnabled = it.isEnabled)) }
        // "current" pointer so the upgrade is non-disruptive.
        // (Splinterlands via `askSilentlyWithInstance`, where the caller owns the full
        // (the chat the user is viewing), routing the heartbeat's shell commands into
        // +1 for the current batch that's about to be executed
        // Add all TOOL_EXECUTING indicators first
        // Allocate a conversation id immediately for fresh chats. Without this,
        // Already-loaded guard (covers re-entry from refreshSettings)
        // Append the assistant tool-call row and the executing indicator in a single
        // Background runs must not leak shell commands into whatever chat is open.
        // Build a transcript of the older messages for summarization
        // Callers pass either a CHAT_LOCAL system prompt (chat + silent paths) or null
        // Count how many consecutive times the same signature set appeared at the tail
        // DeepSeek via OpenCode Zen) reject an assistant `tool_calls` message that isn't followed
        // Deferring until the next chat would briefly hold both models' GPU buffers resident
        // Drop the per-conversation shell session so a future conversation reusing
        // Execute all tools concurrently, ensuring indicators show for at least 2 seconds.
        // Free the previously-loaded on-device model as soon as the user picks a new one.
        // GPT-5.6 and friends reject function tools on chat completions; the same messages are
        // Group each assistant tool-call turn together with the tool responses that follow it so
        // Images are offered only when both the service and the active model accept them —
        // Keep messages from the end until we exceed the budget
        // Keep system prompt (first message if role is "system") and trim from oldest non-system
        // Keep whole groups from the end until we exceed the budget.
        // Mirror the tool list the request will carry: remote uses the full set (when the
        // Native litert-lm `automaticToolCalling` owns the tool loop — our allowlisted
        // On-device models are only tried as the primary service, never as a fallback
        // On-device services store the active model ID per-instance, not globally, so
        // One-time migration for existing users: pin the latest conversation as the new
        // Only auto-pick when nothing is stored yet — never overwrite a custom / unlisted model id.
        // Process every attached file: classify, compress/encode, and build an Attachment.
        // Selection: explicit instance > first remote > first on-device. The simple-tool
        // Snapshot the conversation id once so all parallel tool calls in this batch
        // Split history: older messages to summarize, recent to keep verbatim
        // StateFlow update so the UI doesn't flash twice before the tool even starts.
        // Surface connected email accounts so the AI knows they exist in regular chat,
        // The active skill (if any) is consumed for this single turn only — stored in a
        // Tool-use guidance is only worth sending when the model is actually given tools.
        // Use a local history to avoid polluting the current conversation's chatHistory
        // Use primary service's context window for compaction decisions
        // When a conversation override is set (heartbeat / scheduled tasks), bind any
        // `getSelectedModelId` comes back blank for LiteRT. Fall back to the first
        // allowlist works at any context size, so on-device is always eligible for fallback.
        // and the driver's lazy reclaim can push us past LMK thresholds on mid-range devices.
        // aren't in the local allowlist. Gated on the email toggle: if the user has email
        // assembly, tool-call pairing, context trimming — is shared.
        // by its tool responses, and a `tool` message without a preceding `tool_calls`.
        // callers (heartbeat, askWithTools, etc.) don't all need a new parameter. The
        // collide on the same shell mutex. Persistence is deferred to the
        // configured on-device instance's model ID in that case.
        // coroutine context — otherwise tool dispatch would inherit `_currentConversationId`
        // didn't ask for (mirrors the guard that keeps on-device errors from silently
        // else: null id or stale id → leave history empty (this is the new-empty-chat state)
        // existing saveCurrentConversation() flow that runs after the response.
        // falling back to cloud services).
        // falls through to a shared default — which both makes the new chat
        // field rather than a parameter on getActiveSystemPrompt so the existing internal
        // invisible in the Terminal session picker and lets unrelated callers
        // materialized here.
        // memory is freed.
        // mixed services (e.g. Z.AI) pair text-only models with multimodal ones.
        // model supports tools), local uses the allowlist-filtered set.
        // not just during heartbeats. Only the remote variant uses this — email tools
        // off, the AI shouldn't reference the accounts.
        // prompt shape). We hand whichever one through to the engine unchanged.
        // readBytes() is suspend, so this happens before the StateFlow.update block.
        // see a stable value even if the user switches conversations mid-flight.
        // skill's files already live in the sandbox at ~/skills/<id>/, so nothing is
        // still null, so per-conversation routing (e.g. the sandbox shell)
        // target — falling into one would silently start a heavy model load the user
        // that chat's persistent bash session.
        // the very first tool call lands here with _currentConversationId.value
        // this id (very unlikely — random uuids) doesn't inherit stale state, and
        // tool calls in this run to that conversation's sandbox session via the
        // tools are passed once via [localToolDescriptionJson] and the engine drives them.
        // translated to Responses API items instead. Everything before the wire call — prompt
        // trimming never strands one without the other. Strict OpenAI-compatible providers (e.g.
        @Suppress("UNUSED_PARAMETER") messages: List<History>,
        MutableStateFlow(models)
        ServiceEntry(
        _currentConversationId.value = id
        _hasUnreadHeartbeat.value = false
        _hasUnreadHeartbeat.value = true
        _openAssistRequested.value = false
        _openAssistRequested.value = true
        _openHeartbeatRequested.value = false
        _openHeartbeatRequested.value = true
        _pendingShareText.value = null
        _pendingShareText.value = text
        apiKey = appSettings.getInstanceApiKey(instanceId),
        appSettings.removeInstanceSettings(instanceId)
        appSettings.setConfiguredServiceInstances(current)
        appSettings.setConfiguredServiceInstances(reordered)
        appSettings.setCurrentConversationId(id)
        appSettings.setCurrentInteractiveMode(enabled)
        appSettings.setDaemonEnabled(enabled)
        appSettings.setDynamicUiEnabled(enabled)
        appSettings.setEmailEnabled(enabled)
        appSettings.setEmailPollIntervalMinutes(minutes)
        appSettings.setFreeFallbackEnabled(enabled)
        appSettings.setFreeMode(mode)
        appSettings.setFreeServicePrimary(false)
        appSettings.setFreeServicePrimary(primary)
        appSettings.setHeartbeatPrompt(text)
        appSettings.setInstanceApiKey(instanceId, apiKey)
        appSettings.setInstanceBaseUrl(instanceId, baseUrl)
        appSettings.setInstanceCustomModelId(instanceId, modelId)
        appSettings.setInstanceModelId(instanceId, modelId)
        appSettings.setInstanceUseCustomModel(instanceId, useCustom)
        appSettings.setKaiBuildLaunchAgent(agentId)
        appSettings.setMemoryEnabled(enabled)
        appSettings.setModelContextTokens(modelId, contextTokens)
        appSettings.setNotificationsEnabled(enabled)
        appSettings.setSandboxDistro(distro)
        appSettings.setSandboxEnabled(enabled)
        appSettings.setSchedulingEnabled(enabled)
        appSettings.setSmsEnabled(enabled)
        appSettings.setSmsPollIntervalMinutes(minutes)
        appSettings.setSmsSendEnabled(enabled)
        appSettings.setSoulText(text)
        appSettings.setThemeMode(mode)
        appSettings.setToolEnabled(toolId, enabled)
        appSettings.setUiScale(scale)
        arguments: String,
        baseUrl = getInstanceBaseUrl(instanceId, service),
        buildJsonObject {
        chatHistory.update {
        chatHistory.update { history ->
        chatHistory.value = conversation.messages.map { m ->
        chatHistory.value = emptyList()
        chatHistory.value = listOf(summaryEntry) + recentMessages
        compactHistoryIfNeeded()
        contextWindowTokens: Int = ModelCatalog.DEFAULT_CONTEXT_WINDOW_TOKENS,
        conversationStorage.deleteConversation(id)
        conversationStorage.loadConversations()
        conversationStorage.saveConversation(
        conversationStorage.saveConversation(conversation)
        credentials: ServiceCredentials,
        current.add(instance)
        current.removeAll { it.instanceId == instanceId }
        emailPoller.poll(account)
        emailStore.removeAccount(id)
        fetchAndMap: suspend (ServiceCredentials, String) -> List<SettingsModel>,
        flow.update { withSelected }
        for ((index, toolCall) in toolCalls.withIndex()) {
        for (attempt in 0..MAX_API_RETRIES) {
        for (group in groups.asReversed()) {
        for (msg in history.reversed()) {
        heartbeatManager.saveConfig(config.copy(activeHoursStart = start, activeHoursEnd = end))
        heartbeatManager.saveConfig(config.copy(enabled = enabled))
        heartbeatManager.saveConfig(config.copy(heartbeatInstanceId = instanceId))
        heartbeatManager.saveConfig(config.copy(intervalMinutes = minutes))
        history.update {
        history: List<History>,
        history: MutableStateFlow<List<History>> = chatHistory,
        history: MutableStateFlow<List<History>>,
        if (!appSettings.isCurrentConversationMigrated()) {
        if (!service.requiresApiKey && !service.supportsOptionalApiKey) return true
        if (_currentConversationId.value == id) {
        if (_currentConversationId.value == null) {
        if (appSettings.isFreeServicePrimary()) return Service.Free
        if (currentId != null && chatHistory.value.isNotEmpty() &&
        if (currentSignatures.isEmpty()) return false
        if (defaultModel != null) {
        if (draft.status != SmsDraftStatus.PENDING) return false
        if (existing != null) return existing.id
        if (history.isEmpty()) return
        if (needsInit) {
        if (olderMessages.isEmpty()) return
        if (persistedId != null && savedConversations.value.any { it.id == persistedId }) {
        if (question != null) {
        if (service == Service.Free) return true
        if (service.isOnDevice && localInferenceEngine?.currentModelId?.let { it != modelId } == true) {
        if (service.isOnDevice) return emptyList()
        if (service.isOnDevice) return true
        if (service.isOnDevice) {
        if (service.requiresApiKey) return appSettings.getInstanceApiKey(instanceId).isNotBlank()
        if (tools.isEmpty()) {
        if (totalChars <= (maxChars * COMPACTION_THRESHOLD).toInt()) return
        if (totalChars <= maxChars) return history
        if (totalChars <= maxChars) return messages
        if (useCustom && appSettings.getInstanceCustomModelId(instanceId).isBlank()) {
        if (useResponsesApi) {
        if (userIndices.size <= COMPACTION_KEEP_RECENT) return
        if (userIndices.size <= maxExchanges) return history
        if (withSelected.isNotEmpty() && withSelected.none { it.isSelected }) {
        instanceId: String,
        interactiveModeFlag = enabled
        localInferenceEngine?.cancelDownload()
        localInferenceEngine?.cancelImport()
        localInferenceEngine?.deleteModel(modelId)
        localInferenceEngine?.release()
        localInferenceEngine?.startDownload(model)
        mcpServerManager.connectEnabledServers()
        mcpServerManager.removeServer(serverId)
        mcpServerManager.setServerEnabled(serverId, enabled)
        memoryStore.forget(key)
        memoryStore.updateContent(key, content)
        messages: List<History>,
        messages: List<com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message>,
        modelId = if (service == Service.Free) {
        modelsByInstance.remove(instanceId)
        modelsByInstance[instanceId]?.update { emptyList() }
        modelsByInstance[instanceId]?.update { models ->
        name: String,
        notificationListenerController.openAccessSettings()
        notificationStore.clearPending()
        pendingActiveSkillId = resolvedSkillId
        reason: BailoutReason,
        requestTimeoutMs: Long? = null,
        retry: Boolean = true,
        return appSettings.getInstanceEffectiveModelId(instance.instanceId).ifEmpty { appSettings.getSelectedModelId(service) }
        return appSettings.importFromJson(jsonObject, toolIds, sections, replace)
        return buildChatSystemPrompt(
        return consecutiveCount + 1 >= MAX_REPEATED_TOOL_CALLS
        return contentChars + msg.role.length
        return detectExportableSections(jsonObject)
        return engine.importModel(source)
        return history.subList(cutoffIndex, history.size)
        return id
        return if (conversationIdOverride != null) {
        return if (firstUserMessage.length <= 50) {
        return if (service.supportsPdf) base + "pdf" else base
        return instance
        return instances.firstOrNull()?.let { Service.fromId(it.serviceId) } ?: Service.Free
        return kept
        return models.firstOrNull { it.id.contains("kimi-k2.5", ignoreCase = true) }
        return ordered.filterIndexed { index, entry -> index == 0 || !entry.service.isOnDevice }
        return plainChat(
        return plainChat(service, creds, messages, systemPrompt, retry = false).content
        return prettyJson.encodeToString(JsonObject.serializer(), jsonObject)
        return response.choices.firstOrNull()?.message?.effectiveContent ?: ""
        return result.map { mcpServerManager.getToolsForServer(serverId) }
        return runToolLoop(strategy, systemPrompt, history)
        return systemMessages + kept
        return true // Optional API key services are always valid
        return try {
        return url.ifBlank { if (service is Service.OpenAICompatible) Service.DEFAULT_OPENAI_COMPATIBLE_BASE_URL else "" }
        return when (service) {
        return when (val result = smsSender.send(draft.address, draft.body)) {
        sandboxController.closeSession(id)
        service: Service,
        setCurrentConversationId(id)
        setCurrentConversationId(null)
        skillManager.uninstall(id)
        smsDraftStore.removeDraft(draftId)
        smsDraftStore.updateStatus(draftId, SmsDraftStatus.SENDING)
        smsPoller.poll()
        strategy: ToolLoopStrategy,
        strictEmptyResponse: Boolean = false,
        suspend fun <T> call(block: suspend () -> T): T = if (retry) retryApiCall(block) else block()
        systemPrompt: String? = null,
        systemPrompt: String?,
        systemPromptChars: Int = 0,
        taskStore.removeTask(id)
        throw lastException!!
        toolCalls: List<Triple<String, String, String>>,
        tools: List<Tool>,
        try {
        updateModelsForInstance(instanceId, fetchAndMap(creds, selectedModelId))
        useResponsesApi: Boolean = false,
        val account = emailStore.getAccount(accountId) ?: return
        val activeSkill = pendingActiveSkillId?.let { skillManager.getSkill(it) }
        val attachments = files.map { file ->
        val availableChars = maxChars - systemChars
        val availableChars = maxChars - systemPromptChars
        val bailoutMessages = messages.toMutableList().apply {
        val base = if (imagesSupported) supportedFileExtensions else supportedFileExtensions - imageExtensions
        val batchSize = currentSignatures.size
        val byCategory = memories.groupBy { it.category }
        val byId = current.associateBy { it.instanceId }
        val callId = "local-${Uuid.random()}"
        val catalogModel = engine.getAvailableModels().find { it.id == model.id }
        val config = heartbeatManager.getConfig()
        val contentChars = when (val content = msg.content) {
        val contextTokens = if (storedContext > 0) storedContext else catalogModel?.defaultContextTokens ?: 0
        val contextWindowTokens = ModelCatalog.estimateContextWindow(credentials.modelId)
        val contextWindowTokens = ModelCatalog.estimateContextWindow(modelId)
        val conversation = Conversation(
        val conversation = savedConversations.value.find { it.id == id } ?: return
        val conversationId = _currentConversationId.value ?: Uuid.random().toString().also {
        val conversationIdForTool = activeConversationId()
        val conversationIdSnapshot = activeConversationId()
        val creds = instanceCredentials(firstInstance.instanceId, service)
        val creds = instanceCredentials(instanceId, service)
        val current = appSettings.getConfiguredServiceInstances()
        val current = appSettings.getConfiguredServiceInstances().toMutableList()
        val currentId = _currentConversationId.value
        val cutoffIndex = userIndices[userIndices.size - COMPACTION_KEEP_RECENT]
        val cutoffIndex = userIndices[userIndices.size - maxExchanges]
        val declaredToolNames = tools.map { it.schema.name }.toSet()
        val defaultModel = service?.defaultModel
        val defaultSettingsModels = service.defaultModels.map {
        val displayName = toolExecutor.getToolDisplayName(name)
        val downloadedModels = engine.getDownloadedModels()
        val draft = smsDraftStore.getDraft(draftId) ?: return false
        val emailAccounts = if (variant == SystemPromptVariant.CHAT_REMOTE && appSettings.isEmailEnabled()) {
        val engine = localInferenceEngine
        val entries = instances.map { FallbackEntry(instanceId = it.instanceId, service = Service.fromId(it.serviceId)) }
        val executingId = Uuid.random().toString()
        val executingIds = toolCalls.map { Uuid.random().toString() }
        val existing = savedConversations.value.find { it.type == Conversation.TYPE_HEARTBEAT }
        val existingConversation = savedConversations.value.find { it.id == conversationId }
        val fallbackEntries = getOrderedFallbackEntries().filter { hasValidInstanceApiKey(it.instanceId, it.service) }
        val firstInstance = getConfiguredServiceInstances().firstOrNull() ?: return
        val firstInstance = getConfiguredServiceInstances().firstOrNull() ?: return ""
        val firstUserMessage = history.firstOrNull { it.role == History.Role.USER }?.content ?: return ""
        val flow = modelsByInstance.getOrPut(instanceId) { MutableStateFlow(emptyList()) }
        val freeEntry = FallbackEntry(instanceId = "free", service = Service.Free)
        val groups = mutableListOf<List<com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message>>()
        val hasTools = when (variant) {
        val heartbeatAdditions = tasksSplit.heartbeatAdditions
        val heartbeatId = existing?.id ?: getOrCreateHeartbeatConversationId()
        val history = chatHistory.value.filter { it.role != History.Role.TOOL_EXECUTING }
        val history = trimToRecentExchanges(chatHistory.value, 20)
        val historyChars = messages.sumOf { it.content.length } + (systemPrompt?.length ?: 0)
        val id = Uuid.random().toString()
        val imagesSupported = service.supportsImages && modelSupportsImages(currentModelId())
        val inferenceMessages = messages.mapNotNull { msg ->
        val instance = ServiceInstance(instanceId = instanceId, serviceId = serviceId)
        val instance = getConfiguredServiceInstances().find { it.instanceId == instanceId }
        val instance = getConfiguredServiceInstances().firstOrNull() ?: return ""
        val instanceId = appSettings.generateInstanceId(serviceId)
        val instances = getConfiguredServiceInstances()
        val isLimited = !supportsTools(modelId)
        val jsonObject = SharedJson.parseToJsonElement(json).jsonObject
        val jsonObject = appSettings.exportToJson(toolIds, conversations = conversationStorage.conversations.value)
        val jsonObject = appSettings.exportToJson(toolIds, sections, conversationStorage.conversations.value)
        val kept = mutableListOf<History>()
        val kept = mutableListOf<com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message>()
        val localDateTime = now.toLocalDateTime(timeZone)
        val localHistory = MutableStateFlow(messages)
        val localTools: List<LocalTool> = if (localModelDeclaresTools(model.id)) {
        val maxChars = contextWindowTokens * ESTIMATED_CHARS_PER_TOKEN
        val memories = if (memoryEnabled) memoryStore.getAllMemories() else emptyList()
        val memoryEnabled = appSettings.isMemoryEnabled()
        val memoryInstructions = if (memoryEnabled) {
        val messages = ((existing?.messages ?: emptyList()) + newMessage).takeLast(MAX_HEARTBEAT_MESSAGES)
        val messages = chatHistory.value
        val messages = listOf(History(role = History.Role.USER, content = prompt))
        val messages = listOf(History(role = History.Role.USER, content = question))
        val model = downloadedModels.find { it.id == modelId }
        val modelId = appSettings.getInstanceEffectiveModelId(instance.instanceId).ifEmpty {
        val modelId = appSettings.getInstanceModelId(instanceId)
        val modelId = appSettings.getSelectedModelId(service)
        val modelId = appSettings.getSelectedModelId(service).ifBlank {
        val models = if (selectedModelId.isNotEmpty() && defaultSettingsModels.none { it.id == selectedModelId }) {
        val needsInit = engine.engineState.value != EngineState.READY || engine.currentModelId != model.id
        val newMessage = Conversation.Message(
        val nonSystemMessages = messages.drop(systemMessages.size)
        val now = Clock.System.now()
        val now = Clock.System.now().toEpochMilliseconds()
        val offset = timeZone.offsetAt(now)
        val olderMessages = history.subList(0, cutoffIndex)
        val ordered = if (entries.isEmpty()) {
        val pendingTasks = tasksSplit.scheduled
        val persistedId = appSettings.getCurrentConversationId()
        val recentMessages = history.subList(cutoffIndex, history.size)
        val recentSignatures = mutableListOf<String>()
        val reordered = orderedInstanceIds.mapNotNull { byId[it] }
        val resolvedSkillId = activeSkillId?.takeIf { skillManager.getSkill(it) != null }
        val response = retryApiCall {
        val result = mcpServerManager.connectAndDiscoverTools(serverId)
        val runtime = ChatPromptRuntimeContext(
        val schedulingEnabled = appSettings.isSchedulingEnabled()
        val selectedModelId = appSettings.getInstanceModelId(instanceId)
        val service = Service.fromId(firstInstance.serviceId)
        val service = Service.fromId(instance.serviceId)
        val service = Service.fromId(targetInstance.serviceId)
        val service = currentService()
        val sessionId = activeConversationId()
        val soul = appSettings.getSoulText().ifEmpty { getString(Res.string.default_soul) }
        val startTime = Clock.System.now().toEpochMilliseconds()
        val storedContext = appSettings.getModelContextTokens(model.id)
        val strategy = object : ToolLoopStrategy {
        val summary = try {
        val summaryEntry = History(
        val summaryPrompt = "Summarize this conversation concisely, preserving key facts, decisions, and any information the assistant would need to continue helping. Be brief but complete:\n\n$transcript"
        val systemChars = systemMessages.sumOf { estimateMessageChars(it) }
        val systemMessages = messages.takeWhile { it.role == "system" }
        val systemPrompt = getActiveSystemPrompt()
        val systemPromptChars = getActiveSystemPrompt()?.length ?: 0
        val targetInstance = instanceId?.let { id -> instances.find { it.instanceId == id } }
        val tasksSplit = if (schedulingEnabled) taskStore.getPendingTasksPartitioned() else PendingTaskPartition(emptyList(), emptyList())
        val timeZone = TimeZone.currentSystemDefault()
        val title = existingConversation?.title?.ifEmpty { null }
        val toolIds = getPlatformToolDefinitions().map { it.id }
        val tools = if (supportsTools(creds.modelId)) getAvailableTools() else emptyList()
        val totalChars = history.sumOf { it.content.length } + systemPromptChars
        val totalChars = messages.sumOf { estimateMessageChars(it) }
        val transcript = buildString {
        val uiMode = when {
        val url = appSettings.getInstanceBaseUrl(instanceId)
        val useResponsesApi = requiresResponsesApi(service, credentials.modelId, credentials.baseUrl)
        val userIndices = history.mapIndexedNotNull { index, h ->
        val withSelected = ensureSelectedModelPresent(models, selectedModelId)
        var consecutiveCount = 0
        var fallbackServiceName: String? = null
        var i = recentSignatures.size - batchSize
        var index = 0
        var iteration = 0
        var lastException: Exception? = null
        var usedChars = 0
        when (service) {
        while (i >= 0) {
        while (index < nonSystemMessages.size) {
        while (true) {
        }
        } catch (_: Exception) {
        } catch (e: RuntimeException) {
        } else if (appSettings.isFreeFallbackEnabled()) {
        } else if (appSettings.isFreeServicePrimary()) {
        } else {
        } finally {
        },
        }.toImmutableList()
        }.toString()
     *
     * (keeping the most recent). Used by Gemini and Anthropic tool loops where the system prompt
     * (keeping the system prompt and most recent messages).
     * 0.6B reports a fictional time rather than calling `get_local_time`. Withholding the
     * Cached OpenAPI/OpenAI-style JSON descriptions for local tools, keyed by tool name.
     * Compacts chat history by summarizing older messages via an LLM call when the history
     * Context budget used to trim raw history between tool rounds. Providers that send the
     * Detects if the current batch of tool calls is repeating a recent pattern.
     * Executes tool calls in parallel, showing TOOL_EXECUTING indicators in the UI.
     * Fetches [service]'s model list for [instanceId] and publishes it. [fetchAndMap] is the only
     * Gemini/Anthropic tool-loop bailouts — funnels through here.
     * Makes a final OpenAI-compatible API call without tools, asking the model to summarize.
     * One assistant turn with no tools declared, dispatched to whichever API [service] speaks.
     * OpenAI `{type: "function", function: {…}}` wrapper, so litert-lm's `OpenApiTool`
     * Retries an API call with simple exponential backoff.
     * Returns a list of (callId, toolName, result).
     * Returns the cached OpenAPI/OpenAI-style JSON description for [tool], building it on
     * Returns the tools exposed to the on-device (LiteRT) model. Filtered by name against
     * Runs a single tool invocation requested by the on-device engine, mirroring the UI
     * Schemas are static for allowlisted tools, so serializing them once per tool avoids
     * TOOL_EXECUTING indicator (with a 2 s minimum so it's visible), execute the tool, then
     * The conversation a request belongs to: an explicit coroutine-context id (set by
     * The engine reports null when it cannot read the declaration (iOS, or a bundle whose
     * The three providers differ only in message shape and text extraction, so every caller
     * Trims History entries to fit within the estimated context window by dropping oldest messages
     * Trims messages to fit within the estimated context window by dropping oldest messages
     * Whether the on-device model file for [modelId] carries a tool section in its chat
     * [LOCAL_TOOL_ALLOWLIST]. Tools the user has disabled in settings (e.g. shell command,
     * [retry] wraps the call in [retryApiCall]; silent callers skip it because they run on a
     * `getAvailableTools()` in the first place, so they're naturally excluded.
     * adapter can forward it straight to the model. If a parameter has a `rawSchema`,
     * askWithTools for heartbeat / scheduled runs) wins over the globally active chat id, so
     * background runs aren't attributed to whatever chat the user is viewing. Null before any
     * caller-supplied deadline. [strictEmptyResponse] turns a missing OpenAI-compatible message
     * calling them, inventing whatever the tool would have returned, which is how Qwen3
     * conversation exists. Used as the upstream session id for providers that require one.
     * engine to feed back to the model.
     * error surfaced, silent callers prefer empty text.
     * exceeds a percentage of the context window. Keeps recent exchanges verbatim and replaces
     * first request. Shape mirrors `Tool.toRequestTool()` in `Requests.kt` without the
     * flow used by [executeToolCallsInParallel]: write the assistant tool-call row, show a
     * history as-is (Gemini, Anthropic) declare their window here; the OpenAI-compatible
     * is sent separately (not as a message).
     * it's passed through verbatim — that preserves array/enum/nested-object shapes the
     * metadata predates it). That is *unknown*, not *no*: keep offering the allowlist there
     * needing a plain completion — the no-tools path above, the silent asks, and the
     * older ones with a single summary. Falls back to simple drop-oldest trimming on failure.
     * or content into [OpenAICompatibleEmptyResponseException] — the visible chat path wants that
     * per-provider part: it issues the request and maps the response to [SettingsModel]s, given
     * re-running the JSON builder on every message.
     * replace the indicator with a TOOL result row. Returns the raw result string for the
     * simple `{type, description}` form would lose.
     * so existing setups behave exactly as before.
     * strategy trims the built message list inside [chat] instead and leaves this null.
     * template. A model that doesn't isn't merely worse at tools — it answers *instead* of
     * the instance credentials and the currently selected model id.
     * tools makes it a plain chat model, which is what it actually is.
     * which is gated behind `isToolEnabled("execute_shell_command")`) won't appear in
     */
    "execute_shell_command",
    "get_local_time",
    "get_location_from_ip",
    "memory_forget",
    "memory_reinforce",
    "memory_store",
    "open_url",
    "web_search",
    )
    ) {
    ): AssistantTurn {
    ): List<History> {
    ): List<Triple<String, String, String>> {
    ): List<com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message> {
    ): String {
    /**
    /** Build credentials from per-instance settings */
    /** Built-in skill id; matches the bundled SKILL.md under composeResources. */
    /** Model id of the active (first configured, non-Free) instance, or "" when none. */
    // Conversation management
    // Explicit user-triggered (never AI-triggered) — the banner is the gate.
    // Flips the draft to SENDING, delegates to SmsSender, then updates to SENT/FAILED.
    // MCP servers
    // On-device inference (LiteRT)
    // Per-instance model storage: instanceId -> models flow
    // Per-instance settings
    // Skills
    // Soul (system prompt)
    // Tool management
    BailoutReason.LIMIT_REACHED -> "You have reached the tool call limit. Please respond with the best answer you have so far based on the information gathered."
    BailoutReason.REPEATING -> "You are repeating the same tool calls. Please respond with the best answer you have so far."
    override fun addConfiguredService(serviceId: String): ServiceInstance {
    override fun cancelLocalModelDownload() {
    override fun cancelLocalModelImport() {
    override fun clearHistory() {
    override fun clearInstanceModels(instanceId: String, service: Service) {
    override fun clearUnreadHeartbeat() {
    override fun consumeOpenAssistRequest() {
    override fun consumeOpenHeartbeatRequest() {
    override fun consumeOpenShareRequest() {
    override fun currentService(): Service {
    override fun exportSettingsToJson(sections: Set<ImportSection>): String {
    override fun getConfiguredServiceInstances(): List<ServiceInstance> = appSettings.getConfiguredServiceInstances().filter { Service.fromId(it.serviceId) != Service.Free }
    override fun getEmailAccounts(): List<EmailAccount> = emailStore.getAccounts()
    override fun getEmailPollIntervalMinutes(): Int = appSettings.getEmailPollIntervalMinutes()
    override fun getEmailSyncStates(): Map<String, EmailSyncState> = emailStore.getAllSyncStates()
    override fun getExportPreview(): Map<ImportSection, String?> {
    override fun getFreeMode(): FreeMode = appSettings.getFreeMode()
    override fun getHeartbeatConfig(): HeartbeatConfig = heartbeatManager.getConfig()
    override fun getHeartbeatInstanceId(): String? = heartbeatManager.getConfig().heartbeatInstanceId
    override fun getHeartbeatLog(): List<HeartbeatLogEntry> = heartbeatManager.getHeartbeatLog()
    override fun getHeartbeatPrompt(): String = appSettings.getHeartbeatPrompt()
    override fun getInstalledSkills(): List<SkillManifest> = skillManager.getInstalled()
    override fun getInstanceApiKey(instanceId: String): String = appSettings.getInstanceApiKey(instanceId)
    override fun getInstanceBaseUrl(instanceId: String, service: Service): String {
    override fun getInstanceCustomModelId(instanceId: String): String = appSettings.getInstanceCustomModelId(instanceId)
    override fun getInstanceModels(instanceId: String, service: Service): StateFlow<List<SettingsModel>> = modelsByInstance.getOrPut(instanceId) {
    override fun getInstanceUseCustomModel(instanceId: String): Boolean = appSettings.getInstanceUseCustomModel(instanceId)
    override fun getKaiBuildLaunchAgent(): String? = appSettings.getKaiBuildLaunchAgent()
    override fun getLocalAvailableModels(): List<LocalModel> = localInferenceEngine?.getAvailableModels() ?: emptyList()
    override fun getLocalDownloadError(): StateFlow<DownloadError?>? = localInferenceEngine?.downloadError
    override fun getLocalDownloadProgress(): StateFlow<Float?>? = localInferenceEngine?.downloadProgress
    override fun getLocalDownloadedModels(): List<DownloadedModel> = localInferenceEngine?.getDownloadedModels() ?: emptyList()
    override fun getLocalDownloadingModelId(): StateFlow<String?>? = localInferenceEngine?.downloadingModelId
    override fun getLocalEngineState(): StateFlow<EngineState>? = localInferenceEngine?.engineState
    override fun getLocalFreeSpaceBytes(): Long = localInferenceEngine?.getFreeSpaceBytes() ?: 0L
    override fun getLocalImportError(): StateFlow<ModelImportError?>? = localInferenceEngine?.importError
    override fun getLocalImportProgress(): StateFlow<Float?>? = localInferenceEngine?.importProgress
    override fun getLocalImportedModels(): List<LocalModel> = localInferenceEngine?.getImportedLocalModels() ?: emptyList()
    override fun getLocalImportingFileName(): StateFlow<String?>? = localInferenceEngine?.importingFileName
    override fun getMcpServers(): List<McpServerConfig> = mcpServerManager.getServers()
    override fun getMcpToolsForServer(serverId: String): List<ToolInfo> = mcpServerManager.getToolsForServer(serverId)
    override fun getMemories(): List<MemoryEntry> = memoryStore.getAllMemories()
    override fun getModelContextTokens(modelId: String): Int = appSettings.getModelContextTokens(modelId)
    override fun getNotificationSyncState(): NotificationSyncState = notificationStore.getSyncState()
    override fun getPendingEmailCount(): Int = emailStore.getPending().size
    override fun getPendingNotificationCount(): Int = notificationStore.getPending().size
    override fun getPendingSmsCount(): Int = smsStore.getPending().size
    override fun getSandboxDistro(): LinuxDistro = appSettings.getSandboxDistro()
    override fun getScheduledTasks(): List<ScheduledTask> = taskStore.getAllTasks()
    override fun getServiceEntries(): List<ServiceEntry> = getConfiguredServiceInstances().map { instance ->
    override fun getSmsPollIntervalMinutes(): Int = appSettings.getSmsPollIntervalMinutes()
    override fun getSmsSyncState(): SmsSyncState = smsStore.getSyncState()
    override fun getSoulText(): String = appSettings.getSoulText()
    override fun getThemeMode(): ThemeMode = appSettings.getThemeMode()
    override fun getToolDefinitions(): List<ToolInfo> = getPlatformToolDefinitions()
    override fun getTotalDeviceMemoryBytes(): Long = getTotalMemoryBytes()
    override fun getUiScale(): Float = appSettings.getUiScale()
    override fun hasSmsPermission(): Boolean = smsReader.hasPermission()
    override fun hasSmsSendPermission(): Boolean = smsSender.hasPermission()
    override fun importSettingsFromJson(json: String, sections: Set<ImportSection>, replace: Boolean): Int {
    override fun isDaemonEnabled(): Boolean = appSettings.isDaemonEnabled()
    override fun isDynamicUiEnabled(): Boolean = appSettings.isDynamicUiEnabled()
    override fun isEmailEnabled(): Boolean = appSettings.isEmailEnabled()
    override fun isFreeFallbackEnabled(): Boolean = appSettings.isFreeFallbackEnabled()
    override fun isFreeServicePrimary(): Boolean = appSettings.isFreeServicePrimary()
    override fun isInteractiveModeActive(): Boolean = interactiveModeFlag
    override fun isLocalInferenceAvailable(): Boolean = localInferenceEngine != null
    override fun isMcpServerConnected(serverId: String): Boolean = mcpServerManager.isConnected(serverId)
    override fun isMemoryEnabled(): Boolean = appSettings.isMemoryEnabled()
    override fun isNotificationListenerAccessGranted(): Boolean = notificationListenerController.isAccessGranted()
    override fun isNotificationsEnabled(): Boolean = appSettings.isNotificationsEnabled()
    override fun isSandboxEnabled(): Boolean = appSettings.isSandboxEnabled()
    override fun isSchedulingEnabled(): Boolean = appSettings.isSchedulingEnabled()
    override fun isSmsEnabled(): Boolean = appSettings.isSmsEnabled()
    override fun isSmsSendEnabled(): Boolean = appSettings.isSmsSendEnabled()
    override fun isUsingSharedKey(): Boolean = currentService() == Service.Free
    override fun loadConversation(id: String) {
    override fun loadConversations() {
    override fun openNotificationListenerSettings() {
    override fun popLastExchange() {
    override fun regenerate() {
    override fun removeConfiguredService(instanceId: String) {
    override fun removeMcpServer(serverId: String) {
    override fun reorderConfiguredServices(orderedInstanceIds: List<String>) {
    override fun requestOpenAssist() {
    override fun requestOpenHeartbeat() {
    override fun requestOpenShare(text: String) {
    override fun restoreCurrentConversation() {
    override fun setDaemonEnabled(enabled: Boolean) {
    override fun setDynamicUiEnabled(enabled: Boolean) {
    override fun setEmailEnabled(enabled: Boolean) {
    override fun setEmailPollIntervalMinutes(minutes: Int) {
    override fun setFreeFallbackEnabled(enabled: Boolean) {
    override fun setFreeMode(mode: FreeMode) {
    override fun setFreeServicePrimary(primary: Boolean) {
    override fun setHeartbeatActiveHours(start: Int, end: Int) {
    override fun setHeartbeatEnabled(enabled: Boolean) {
    override fun setHeartbeatInstanceId(instanceId: String?) {
    override fun setHeartbeatIntervalMinutes(minutes: Int) {
    override fun setHeartbeatPrompt(text: String) {
    override fun setInteractiveMode(enabled: Boolean) {
    override fun setKaiBuildLaunchAgent(agentId: String?) {
    override fun setMcpServerEnabled(serverId: String, enabled: Boolean) {
    override fun setMemoryEnabled(enabled: Boolean) {
    override fun setModelContextTokens(modelId: String, contextTokens: Int) {
    override fun setNotificationsEnabled(enabled: Boolean) {
    override fun setSandboxDistro(distro: LinuxDistro) {
    override fun setSandboxEnabled(enabled: Boolean) {
    override fun setSchedulingEnabled(enabled: Boolean) {
    override fun setSmsEnabled(enabled: Boolean) {
    override fun setSmsPollIntervalMinutes(minutes: Int) {
    override fun setSmsSendEnabled(enabled: Boolean) {
    override fun setSoulText(text: String) {
    override fun setThemeMode(mode: ThemeMode) {
    override fun setToolEnabled(toolId: String, enabled: Boolean) {
    override fun setUiScale(scale: Float) {
    override fun startLocalModelDownload(model: LocalModel) {
    override fun startNewChat() {
    override fun supportedFileExtensions(): List<String> {
    override fun truncateFrom(messageId: String) {
    override fun updateInstanceApiKey(instanceId: String, apiKey: String) {
    override fun updateInstanceBaseUrl(instanceId: String, baseUrl: String) {
    override fun updateInstanceCustomModelId(instanceId: String, modelId: String) {
    override fun updateInstanceSelectedModel(instanceId: String, service: Service, modelId: String) {
    override fun updateInstanceUseCustomModel(instanceId: String, useCustom: Boolean) {
    override suspend fun addAssistantMessage(content: String) {
    override suspend fun addMcpServer(name: String, url: String, headers: Map<String, String>): McpServerConfig = mcpServerManager.addServer(name, url, headers)
    override suspend fun ask(question: String?, files: List<PlatformFile>, uiSubmission: UiSubmission?, activeSkillId: String?) {
    override suspend fun askSilently(question: String): String {
    override suspend fun askSilentlyWithInstance(instanceId: String, prompt: String, timeoutMs: Long): String {
    override suspend fun askWithTools(prompt: String, instanceId: String?, conversationIdOverride: String?): String {
    override suspend fun browseSkillMarketplaces(): Result<List<RegistrySkillEntry>> = skillManager.browseMarketplaces()
    override suspend fun cancelScheduledTask(id: String) {
    override suspend fun clearPendingNotifications() {
    override suspend fun connectEnabledMcpServers() {
    override suspend fun connectMcpServer(serverId: String): Result<List<ToolInfo>> {
    override suspend fun deleteConversation(id: String) {
    override suspend fun deleteLocalModel(modelId: String) {
    override suspend fun deleteMemory(key: String) {
    override suspend fun discardSmsDraft(draftId: String) {
    override suspend fun getActiveSystemPrompt(variant: SystemPromptVariant): String? {
    override suspend fun getOrCreateHeartbeatConversationId(): String {
    override suspend fun importLocalModel(source: PlatformFile): ModelImportResult {
    override suspend fun installBrowsedSkill(entry: RegistrySkillEntry): Result<SkillManifest> = skillManager.installFromRegistryEntry(entry)
    override suspend fun installGitHubSkill(owner: String, repo: String, ref: String, path: String): Result<SkillManifest> = skillManager.installFromGitHub(owner, repo, ref, path)
    override suspend fun pollEmailAccount(accountId: String) {
    override suspend fun pollSms() {
    override suspend fun releaseLocalEngine() {
    override suspend fun removeEmailAccount(id: String) {
    override suspend fun requestSmsPermission(): Boolean = smsPermissionController.requestPermission()
    override suspend fun requestSmsSendPermission(): Boolean = smsSendPermissionController.requestPermission()
    override suspend fun sendSmsDraft(draftId: String): Boolean {
    override suspend fun uninstallSkill(id: String) {
    override suspend fun updateMemoryContent(key: String, content: String) {
    override suspend fun validateConnection(service: Service, instanceId: String) {
    override val chatHistory: MutableStateFlow<List<History>> = MutableStateFlow(emptyList())
    override val currentConversationId: StateFlow<String?> = _currentConversationId
    override val fallbackStatus: StateFlow<FallbackStatus?> = _fallbackStatus
    override val hasUnreadHeartbeat: StateFlow<Boolean> = _hasUnreadHeartbeat
    override val openAssistRequested: StateFlow<Boolean> = _openAssistRequested
    override val openHeartbeatRequested: StateFlow<Boolean> = _openHeartbeatRequested
    override val pendingShareText: StateFlow<String?> = _pendingShareText
    override val savedConversations: StateFlow<List<Conversation>> = conversationStorage.conversations
    override val smsDrafts: StateFlow<List<SmsDraft>> = smsDraftStore.drafts
    private data class FallbackEntry(val instanceId: String, val service: Service)
    private fun currentModelId(): String {
    private fun deriveTitle(history: List<History>): String {
    private fun estimateMessageChars(msg: com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto.Message): Int {
    private fun getLocalSafeTools(): List<Tool> = getAvailableTools()
    private fun getOrderedFallbackEntries(): List<FallbackEntry> {
    private fun hasValidInstanceApiKey(instanceId: String, service: Service): Boolean {
    private fun instanceCredentials(instanceId: String, service: Service): ServiceCredentials = ServiceCredentials(
    private fun isNonRetryableException(e: Exception): Boolean = e is AnthropicInsufficientCreditsException || e is OpenAICompatibleQuotaExhaustedException
    private fun isRepeatingToolCalls(recentSignatures: List<String>, currentSignatures: List<String>): Boolean {
    private fun localToolDescriptionJson(tool: Tool): String = localToolDescriptionJsonCache.getOrPut(tool.schema.name) {
    private fun pickDefaultModel(models: List<SettingsModel>, service: Service? = null): SettingsModel? {
    private fun setCurrentConversationId(id: String?) {
    private fun trimHistoryForContext(
    private fun trimMessagesForContext(
    private fun trimToRecentExchanges(history: List<History>, maxExchanges: Int): List<History> {
    private fun updateModelsForInstance(instanceId: String, models: List<SettingsModel>, service: Service? = null) {
    private suspend fun <T> retryApiCall(block: suspend () -> T): T {
    private suspend fun activeConversationId(): String? = currentConversationIdOrNull() ?: _currentConversationId.value
    private suspend fun askInternal(question: String?, files: List<PlatformFile>, uiSubmission: UiSubmission?) {
    private suspend fun askWithLocalEngine(
    private suspend fun askWithService(
    private suspend fun compactHistoryIfNeeded() {
    private suspend fun executeToolCallsInParallel(
    private suspend fun fetchInstanceModels(service: Service, instanceId: String) {
    private suspend fun fetchModelsForInstance(
    private suspend fun handleAnthropicChatWithTools(
    private suspend fun handleGeminiChatWithTools(
    private suspend fun handleOpenAICompatibleChatWithTools(
    private suspend fun localModelDeclaresTools(modelId: String): Boolean = localInferenceEngine?.modelCapabilities(modelId)?.supportsFunctionCalling != false
    private suspend fun makeFinalCallWithoutTools(
    private suspend fun plainChat(
    private suspend fun runLocalToolWithUiFeedback(
    private suspend fun runToolLoop(
    private suspend fun saveCurrentConversation() {
    private val _currentConversationId = MutableStateFlow<String?>(null)
    private val _fallbackStatus = MutableStateFlow<FallbackStatus?>(null)
    private val _hasUnreadHeartbeat = MutableStateFlow(false)
    private val _openAssistRequested = MutableStateFlow(false)
    private val _openHeartbeatRequested = MutableStateFlow(false)
    private val _pendingShareText = MutableStateFlow<String?>(null)
    private val appSettings: AppSettings,
    private val conversationStorage: ConversationStorage,
    private val createSkillId = "create-skill"
    private val emailPoller: EmailPoller,
    private val emailStore: EmailStore,
    private val heartbeatManager: HeartbeatManager,
    private val localInferenceEngine: LocalInferenceEngine? = null,
    private val localToolDescriptionJsonCache = mutableMapOf<String, String>()
    private val mcpServerManager: McpServerManager,
    private val memoryStore: MemoryStore,
    private val modelsByInstance: MutableMap<String, MutableStateFlow<List<SettingsModel>>> = mutableMapOf()
    private val notificationListenerController: NotificationListenerController,
    private val notificationStore: NotificationStore,
    private val prettyJson = Json { prettyPrint = true }
    private val requests: Requests,
    private val sandboxController: SandboxController,
    private val skillManager: SkillManager,
    private val smsDraftStore: SmsDraftStore,
    private val smsPermissionController: PermissionController,
    private val smsPoller: SmsPoller,
    private val smsReader: SmsReader,
    private val smsSendPermissionController: PermissionController,
    private val smsSender: SmsSender,
    private val smsStore: SmsStore,
    private val taskStore: TaskStore,
    private val toolExecutor: ToolExecutor,
    private var interactiveModeFlag = appSettings.getCurrentInteractiveMode()
    private var pendingActiveSkillId: String? = null
    suspend fun bailout(history: List<History>, systemPrompt: String?, reason: BailoutReason): String
    suspend fun chat(history: List<History>, systemPrompt: String?): LoopChatResult
    throw OpenAICompatibleGenericException("${service.displayName}: $message")
    val content: String,
    val historyContextWindowTokens: Int? get() = null
    val isThinkingContent: Boolean = false,
    val message = error?.message ?: return
    val reasoningContent: String? = null,
    val textContent: String,
    val toolCalls: List<ToolCallInfo>,
    }
 * The Responses API reports a failed turn inside a 200 body (`status: "failed"`), which would
 * error.
 * otherwise read as an empty answer. Surface OpenAI's message instead of a generic empty-response
 * that produced it. Returned from [askWithService] so the caller can persist both. */
 */
)
) : DataRepository {
/**
/** Final answer from a single assistant turn — text and (optionally) the reasoning trace
// Explicit allowlist of tools exposed to the on-device (LiteRT) model. We use a
// a couple of string parameters. Excluded by design: memory_learn (4 params + enum),
// hardcoded name list rather than a structural filter because small Gemma models hit
// litert-lm's strict ANTLR function-call parser hard on anything more complex than
// schedule_task / list_tasks / cancel_task (datetime + cron), the entire email family,
// the heartbeat config tools, and MCP tools.
@file:OptIn(ExperimentalEncodingApi::class, ExperimentalTime::class, ExperimentalUuidApi::class)
class RemoteDataRepository(
import com.inspiredandroid.kai.SandboxController
import com.inspiredandroid.kai.compressImageBytes
import com.inspiredandroid.kai.currentPlatform
import com.inspiredandroid.kai.data.providers.buildAnthropicMessages
import com.inspiredandroid.kai.data.providers.buildOpenAIMessages
import com.inspiredandroid.kai.data.providers.toResponsesInput
import com.inspiredandroid.kai.email.EmailPoller
import com.inspiredandroid.kai.formatFileSize
import com.inspiredandroid.kai.getAvailableTools
import com.inspiredandroid.kai.getPlatformToolDefinitions
import com.inspiredandroid.kai.inference.DownloadError
import com.inspiredandroid.kai.inference.DownloadedModel
import com.inspiredandroid.kai.inference.EngineState
import com.inspiredandroid.kai.inference.InferenceMessage
import com.inspiredandroid.kai.inference.LocalInferenceEngine
import com.inspiredandroid.kai.inference.LocalModel
import com.inspiredandroid.kai.inference.LocalTool
import com.inspiredandroid.kai.inference.ModelImportError
import com.inspiredandroid.kai.inference.ModelImportResult
import com.inspiredandroid.kai.inference.NoModelDownloadedException
import com.inspiredandroid.kai.inference.getTotalMemoryBytes
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.mcp.McpServerConfig
import com.inspiredandroid.kai.mcp.McpServerManager
import com.inspiredandroid.kai.network.AllServicesFailedException
import com.inspiredandroid.kai.network.AnthropicInsufficientCreditsException
import com.inspiredandroid.kai.network.ContextWindowExceededException
import com.inspiredandroid.kai.network.FileTooLargeException
import com.inspiredandroid.kai.network.OpenAICompatibleEmptyResponseException
import com.inspiredandroid.kai.network.OpenAICompatibleGenericException
import com.inspiredandroid.kai.network.OpenAICompatibleQuotaExhaustedException
import com.inspiredandroid.kai.network.Requests
import com.inspiredandroid.kai.network.ServiceCredentials
import com.inspiredandroid.kai.network.UnsupportedFileTypeException
import com.inspiredandroid.kai.network.dtos.anthropic.extractText
import com.inspiredandroid.kai.network.dtos.gemini.extractText
import com.inspiredandroid.kai.network.dtos.openaicompatible.extractInlineToolCalls
import com.inspiredandroid.kai.network.dtos.openairesponses.OpenAIResponsesResponseDto
import com.inspiredandroid.kai.network.toUiError
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.skills.RegistrySkillEntry
import com.inspiredandroid.kai.skills.SkillManager
import com.inspiredandroid.kai.skills.SkillManifest
import com.inspiredandroid.kai.sms.SmsPoller
import com.inspiredandroid.kai.sms.SmsReader
import com.inspiredandroid.kai.sms.SmsSendResult
import com.inspiredandroid.kai.sms.SmsSender
import com.inspiredandroid.kai.tools.NotificationListenerController
import com.inspiredandroid.kai.tools.PermissionController
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.chat.ToolCallInfo
import com.inspiredandroid.kai.ui.chat.toGeminiMessageDto
import com.inspiredandroid.kai.ui.settings.SettingsModel
import io.github.vinceglb.filekit.PlatformFile
import io.github.vinceglb.filekit.mimeType
import io.github.vinceglb.filekit.name
import io.github.vinceglb.filekit.readBytes
import io.github.vinceglb.filekit.size
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.default_soul
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import kotlinx.datetime.TimeZone
import kotlinx.datetime.offsetAt
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray
import kotlinx.serialization.json.putJsonObject
import org.jetbrains.compose.resources.getString
internal val LOCAL_TOOL_ALLOWLIST = setOf(
package com.inspiredandroid.kai.data
private const val COMPACTION_KEEP_RECENT = 4 // Number of recent user exchanges to keep verbatim
private const val COMPACTION_THRESHOLD = 0.7 // Compact when history exceeds 70% of context window
private const val ESTIMATED_CHARS_PER_TOKEN = 4
private const val MAX_API_RETRIES = 2
private const val MAX_HEARTBEAT_MESSAGES = 50
private const val MAX_REPEATED_TOOL_CALLS = 3
private const val MAX_TOOL_ITERATIONS = 15
private const val MIN_TOOL_DISPLAY_MS = 2000L
private data class AssistantTurn(
private data class LoopChatResult(
private enum class BailoutReason { LIMIT_REACHED, REPEATING }
private fun OpenAIResponsesResponseDto.throwIfFailed(service: Service) {
private fun bailoutPrompt(reason: BailoutReason): String = when (reason) {
private interface ToolLoopStrategy {
}
