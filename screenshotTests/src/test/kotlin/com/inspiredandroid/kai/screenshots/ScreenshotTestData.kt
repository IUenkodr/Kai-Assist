package com.inspiredandroid.kai.screenshots
import com.inspiredandroid.kai.TerminalLine
import com.inspiredandroid.kai.data.MemoryEntry
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.getPlatformToolDefinitions
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.ui.chat.ChatActions
import com.inspiredandroid.kai.ui.chat.ChatUiState
import com.inspiredandroid.kai.ui.chat.History
import com.inspiredandroid.kai.ui.settings.ConfiguredServiceEntry
import com.inspiredandroid.kai.ui.settings.ConnectionStatus
import com.inspiredandroid.kai.ui.settings.McpConnectionStatus
import com.inspiredandroid.kai.ui.settings.McpServerUiState
import com.inspiredandroid.kai.ui.settings.SandboxUiState
import com.inspiredandroid.kai.ui.settings.SettingsModel
import com.inspiredandroid.kai.ui.settings.SettingsTab
import com.inspiredandroid.kai.ui.settings.SettingsUiState
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                    content = chat["assistantMessage"]!!.jsonPrimitive.content,
                    content = chat["userMessage"]!!.jsonPrimitive.content,
                    id = "1",
                    id = "2",
                    role = History.Role.ASSISTANT,
                    role = History.Role.USER,
                ),
                History(
                apiKey = "sk-ant-••••••••••••••••••••••••••••••••",
                apiKey = "sk-••••••••••••••••••••••••••••••••••••",
                connectionStatus = ConnectionStatus.Connected,
                connectionStatus = McpConnectionStatus.Connected,
                content = "Prefers Kotlin for app development",
                content = "The user's name is Simon",
                content = "lets play a game",
                content = "suggest Cacio e Pepe recipe for 2 servings",
                content = recipeContent,
                content = survivalGameContent,
                createdAt = 1709300000000,
                createdAt = 1709310000000,
                id = "1",
                id = "2",
                id = "context7",
                id = "manifold_markets",
                instanceId = "anthropic",
                instanceId = "moonshot",
                isEnabled = true,
                key = "preferred_language",
                key = "user_name",
                name = "Context7",
                name = "Manifold Markets",
                role = History.Role.ASSISTANT,
                role = History.Role.USER,
                selectedModel = SettingsModel(id = "claude-opus-4-6", subtitle = "Claude Opus 4.6", isSelected = true, displayName = "Claude Opus 4.6"),
                selectedModel = SettingsModel(id = "kimi-k2.5", subtitle = "Kimi K2.5", isSelected = true, displayName = "Kimi K2.5"),
                service = Service.Anthropic,
                service = Service.Moonshot,
                tools = persistentListOf(),
                updatedAt = 1709300000000,
                updatedAt = 1709310000000,
                url = "https://api.manifold.markets/v0/mcp",
                url = "https://context7.liam.sh/mcp",
            "       .hddddddddddddddddddddddh.root@localhost\n" +
            "      :dddddddddddddddddddddddddd:\n" +
            "     /dddddddddddddddddddddddddddd/\n" +
            "    +dddddddddddddddddddddddddddddd+\n" +
            "  \u0060sdddddddddddddddddddddddddddddddds\u0060\n" +
            " \u0060ydddddddddddd++hdddddddddddddddddddy\u0060\n" +
            " \u0060yddddddddddddddddddddddddddddddddddy\u0060\n" +
            "--------------\n" +
            ".hddddddddddd+\u0060  \u0060+ddddh:-sdddddddddddh.\n" +
            ".hddddddddddddddddddddddddddddddddddddh.\n" +
            "CPU: Cortex-A520*4 + Cortex-A720*3 + Cortex-X4 (8) @ 3.10 GHz\n" +
            "Kernel: Linux 6.1.145-android14-11-gfa1d6308d1fe-ab14691759\n" +
            "Memory: 6.75 GiB / 7.39 GiB (91%)\n" +
            "OS: Alpine Linux v3.22 aarch64\n" +
            "Packages: 65 (apk)\n" +
            "Shell: libproot.so\n" +
            "Terminal: iredandroid.kai\n" +
            "Uptime: 3 days, 12 hours, 51 mins\n" +
            "\u001B[100m   \u001B[101m   \u001B[102m   \u001B[103m   \u001B[104m   " +
            "\u001B[105m   \u001B[106m   \u001B[107m   \u001B[0m"
            "\u001B[40m   \u001B[41m   \u001B[42m   \u001B[43m   \u001B[44m   " +
            "\u001B[45m   \u001B[46m   \u001B[47m   \u001B[0m\n" +
            "]}," +
            "]}\n" +
            "```"
            "ddd+\u0060   \u0060/o\u0060 :dddddddh/\u0060   \u0060oy-    .yddd\n" +
            "ddddddddh+\u0060   \u0060//\u0060   \u0060.\u0060     -sddddddddd\n" +
            "ddddddh+\u0060   \u0060/hddh/\u0060   \u0060:s-    -sddddddd\n" +
            "ddddh+\u0060   \u0060/+/dddddh/\u0060   \u0060+s-    -sddddd\n" +
            "hdddddddddd+\u0060      \u0060+y:    .sddddddddddh\n" +
            "hdddyo+ohddyosdddddddddho+oydddy++ohdddh\n" +
            "{\"type\":\"accordion\",\"title\":\"Step 1: Toast pepper & cook pasta\",\"children\":[{\"type\":\"text\",\"value\":\"Toast peppercorns in a dry pan until fragrant, crush coarsely. Boil pasta until al dente, reserve pasta water.\",\"style\":\"body\"}]}," +
            "{\"type\":\"accordion\",\"title\":\"Step 2: Make the sauce\",\"children\":[{\"type\":\"text\",\"value\":\"Mix grated Pecorino with warm pasta water to form a smooth cream.\",\"style\":\"body\"}]}," +
            "{\"type\":\"accordion\",\"title\":\"Step 3: Combine\",\"children\":[{\"type\":\"text\",\"value\":\"Toss hot pasta with pepper off heat. Add Pecorino cream and toss until silky.\",\"style\":\"body\"}]}" +
            "{\"type\":\"alert\",\"severity\":\"warning\",\"message\":\"\uD83D\uDC7A Two orcs block the left passage! They haven't noticed you yet.\"}," +
            "{\"type\":\"button\",\"label\":\"\u2694\ufe0f Attack with sword\",\"variant\":\"filled\",\"action\":{\"type\":\"callback\",\"event\":\"attack\"}}," +
            "{\"type\":\"button\",\"label\":\"\uD83E\uDD2B Sneak past in the shadows\",\"variant\":\"outlined\",\"action\":{\"type\":\"callback\",\"event\":\"sneak\"}}" +
            "{\"type\":\"column\",\"spacing\":8,\"children\":[" +
            "{\"type\":\"divider\"}," +
            "{\"type\":\"image\",\"url\":\"resource://cacio_e_pepe.png\",\"aspectRatio\":1.5}," +
            "{\"type\":\"image\",\"url\":\"resource://orc_survival.png\"}," +
            "{\"type\":\"list\",\"ordered\":false,\"items\":[" +
            "{\"type\":\"row\",\"spacing\":16,\"children\":[" +
            "{\"type\":\"row\",\"spacing\":8,\"children\":[{\"type\":\"badge\",\"value\":\"\u23f1 20 min\",\"color\":\"secondary\"},{\"type\":\"badge\",\"value\":\"\uD83C\uDF7D 2 servings\",\"color\":\"secondary\"},{\"type\":\"badge\",\"value\":\"\u2b50 4.9/5\",\"color\":\"primary\"}]}," +
            "{\"type\":\"spacer\",\"height\":4}," +
            "{\"type\":\"stat\",\"value\":\"20/20\",\"label\":\"HP\"}," +
            "{\"type\":\"stat\",\"value\":\"2\",\"label\":\"DEF\"}" +
            "{\"type\":\"stat\",\"value\":\"50g\",\"label\":\"Gold\"}," +
            "{\"type\":\"stat\",\"value\":\"Lv 1\",\"label\":\"Level\"}," +
            "{\"type\":\"text\",\"value\":\"150g Pecorino Romano, finely grated\"}," +
            "{\"type\":\"text\",\"value\":\"2 tsp black peppercorns\"}," +
            "{\"type\":\"text\",\"value\":\"200g tonnarelli or spaghetti\"}," +
            "{\"type\":\"text\",\"value\":\"Cacio e Pepe\",\"style\":\"headline\",\"bold\":true}," +
            "{\"type\":\"text\",\"value\":\"Chapter 1 \u2022 The Beginning\",\"style\":\"caption\",\"color\":\"secondary\"}," +
            "{\"type\":\"text\",\"value\":\"Ingredients\",\"style\":\"title\"}," +
            "{\"type\":\"text\",\"value\":\"Instructions\",\"style\":\"title\"}," +
            "{\"type\":\"text\",\"value\":\"Salt for pasta water\"}" +
            "{\"type\":\"text\",\"value\":\"The tunnel forks. To the left, faint firelight flickers. To the right, silence \u2014 and a cold draft that makes your torch sputter.\",\"style\":\"body\"}," +
            "{\"type\":\"text\",\"value\":\"\u2694\ufe0f The Goblin Tunnels\",\"style\":\"headline\",\"bold\":true}," +
            ),
            ?: error("Missing screenshot data for locale: $locale")
            ConfiguredServiceEntry(
            History(
            McpServerUiState(
            MemoryEntry(
            actions = noOpChatActions,
            history = persistentListOf(
        "       .hddddddddddddddddddddddh.\n" +
        "```kai-ui\n" +
        )
        ),
        TerminalLine.Command("fastfetch"),
        TerminalLine.Output(fastfetchOutput),
        actions = noOpChatActions,
        addFile = { _ -> },
        ask = {},
        availableServicesToAdd = persistentListOf(Service.OpenAI, Service.DeepSeek, Service.Mistral),
        cancel = {},
        clearHistory = {},
        clearSnackbar = {},
        clearUnreadHeartbeat = {},
        configuredServices = persistentListOf(
        consumeComposerPrefill = {},
        currentTab = SettingsTab.Agent,
        currentTab = SettingsTab.Sandbox,
        currentTab = SettingsTab.Services,
        currentTab = SettingsTab.Tools,
        deleteConversation = {},
        discardSmsDraft = {},
        enterInteractiveMode = { },
        exitInteractiveMode = { },
        goBackInteractiveMode = { },
        history = persistentListOf(
        history = persistentListOf(),
        installedDistros = setOf(LinuxDistro.DEBIAN),
        isMemoryEnabled = true,
        isSandboxEnabled = true,
        loadConversation = {},
        mcpServers = persistentListOf(
        memories = persistentListOf(
        regenerate = {},
        removeFile = { _ -> },
        resubmit = { _, _, _ -> },
        retry = {},
        return ChatUiState(
        return Json.parseToJsonElement(text).jsonObject
        sandboxDiskUsageMB = 578,
        sandboxInstalled = true,
        sandboxPackagesInstalled = true,
        sandboxReady = true,
        selectService = {},
        sendSmsDraft = {},
        setIsSpeaking = { _, _ -> },
        showPrivacyInfo = false,
        showSandbox = true,
        soulText = "",
        startNewChat = { },
        submitUiCallback = { _, _ -> },
        toggleSpeechOutput = {},
        tools = getPlatformToolDefinitions().toImmutableList(),
        undoDeleteConversation = { },
        val chat = json["chatWithDynamicUi"]!!.jsonObject
        val chat = json["chatWithMessages"]!!.jsonObject
        val json = loadJson(locale)
        val stream = ScreenshotTestData::class.java.getResourceAsStream("/screenshot-data/$locale.json")
        val text = stream.bufferedReader().use { it.readText() }
    )
    // --- Localized data loading for StoreScreenshotTest ---
    fun localizedChatWithDynamicUi(locale: String): ChatUiState {
    fun localizedChatWithMessages(locale: String): ChatUiState {
    private fun loadJson(locale: String): JsonObject {
    private val fastfetchOutput =
    private val recipeContent =
    private val survivalGameContent =
    val chatEmptyState = ChatUiState(
    val chatWithDynamicUi = ChatUiState(
    val chatWithMessages = ChatUiState(
    val freeConnected = SettingsUiState(
    val noOpChatActions = ChatActions(
    val sandboxState = SandboxUiState(
    val sandboxTerminalLines = persistentListOf(
    val settingsAgent = SettingsUiState(
    val settingsSandbox = SettingsUiState(
    val settingsTools = SettingsUiState(
    }
object ScreenshotTestData {
}
