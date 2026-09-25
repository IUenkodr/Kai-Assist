
                            appendLine("### [$i]")
                            appendLine(seg.rawJson)
                        "${r.count { it.status == Status.PARSE_ERROR }} | ${r.count { it.status == Status.API_ERROR }} |",
                        "${r.count { it.status == Status.PARTIAL }} | ${r.count { it.status == Status.NO_UI }} | " +
                        appendLine("## Error blocks (rawJson)")
                        appendLine("- `${r.prompt.slug}` (${r.status}): see `${p.slug}/${r.prompt.slug}.error.txt`")
                        appendLine()
                        errorBlocks.forEachIndexed { i, seg ->
                        parts = listOf(GeminiChatRequestDto.Part(text = userMessage)),
                        role = "user",
                        }
                    "| ${p.label} | `${p.modelId}` | ${r.count { it.status == Status.SUCCESS }} | " +
                    ),
                    AnthropicChatRequestDto.Message(role = "user", content = JsonPrimitive(userMessage)),
                    GeminiChatRequestDto.Content(
                    OpenAICompatibleChatRequestDto.Message(role = "system", content = JsonPrimitive(systemPrompt)),
                    OpenAICompatibleChatRequestDto.Message(role = "user", content = JsonPrimitive(userMessage)),
                    Status.API_ERROR -> "API "
                    Status.NO_UI -> "NOUI"
                    Status.PARSE_ERROR -> "ERR "
                    Status.PARTIAL -> "WARN"
                    Status.SUCCESS -> "OK  "
                    appendLine("# Error blocks: ${errorBlocks.size}")
                    appendLine("# Prompt: ${prompt.description}")
                    appendLine("# Status: $status")
                    appendLine("# UI blocks: ${uiBlocks.size}")
                    appendLine("# User message: ${prompt.userMessage}")
                    appendLine("# containsUiBlocks: $hasFence")
                    appendLine("## Raw response")
                    appendLine("### Failed prompts")
                    appendLine("| `${r.prompt.slug}` | ${r.status} | $escaped |")
                    appendLine()
                    appendLine(raw)
                    failures += file to "NO_UI"
                    failures += file to "PARSE_ERROR: $err err"
                    failures += file to "PARTIAL: $ui ui, $err err"
                    failures.joinToString("\n") { (f, why) -> "  - ${f.relativeTo(reportDir).path} ($why)" },
                    for (r in failed) {
                    if (errorBlocks.isNotEmpty()) {
                    noUi++
                    parseError++
                    partial++
                    println("  [$marker] $rel ($err err)")
                    println("  [$marker] $rel ($ui ui)")
                    println("  [$marker] $rel ($ui ui, $err err)")
                    println("  [$marker] $rel")
                    success++
                    val escaped = r.summary.replace("|", "\\|")
                    }
                !hasFence && ui == 0 && err == 0 -> "NO_UI"
                "",
                "API error: ${e::class.qualifiedName}\n${e.message}\n\n${e.stackTraceToString()}",
                "API error: ${e::class.simpleName}: ${e.message?.take(200)}",
                "Anthropic",
                "Ask me what my favorite color is using a form input and submit button.",
                "Build a game menu screen with a title, a card per game mode (Classic, Timed, Endless), each card with a Play button.",
                "Build a simple dashboard screen showing 3 stat cards (users, revenue, growth) and a list of recent activity with a refresh button.",
                "Bulleted list and action buttons",
                "Cerebras",
                "Chip group for tag selection",
                "Complex screen that stresses multiple components at once",
                "Create a product info screen with three tabs: Overview, Specs, Reviews. Use tabs component.",
                "Dashboard with stat cards and a chart-like display",
                "Data table with headers and rows",
                "DeepSeek",
                "Design a booking screen for a restaurant reservation: date picker (use select for date and time), party size slider, special requests text input, dietary restrictions chips, and a confirm button.",
                "Display components: quote and stat",
                "Explain what a linked list is in a paragraph, then show me a button to see an example.",
                "Form with multiple input types (text, select, slider, checkbox)",
                "Gemini",
                "Groq",
                "Help me pick pizza toppings. Show a multi-select chip group with 8 options and an order button.",
                "I want to sign up for a newsletter. Show me a form with name, email, frequency selector, topics checkboxes, and a submit button.",
                "Mistral Fine-tuned",
                "Mistral",
                "Moonshot",
                "Multiple-choice quiz using a row of buttons",
                "NO_UI" -> {
                "Nested layouts — card containing row containing buttons",
                "OpenAI",
                "OpenRouter",
                "PARSE_ERROR" -> {
                "PARTIAL" -> {
                "Quiz me on the capitals of Europe. Give me one question with 4 button answers.",
                "Replay strict mode: ${failures.size} file(s) did not parse cleanly:\n" +
                "Response that mixes markdown explanation with kai-ui interactive block",
                "SUCCESS" -> {
                "Show me a comparison table of the top 3 programming languages with columns Name, Year, Paradigm.",
                "Show me a todo list with 5 items and buttons to mark all done or add new.",
                "Show me an inspirational quote about learning programming and a stat showing there are 4 million developers in Germany.",
                "Simple question expecting a text response with kai-ui elements",
                "Success rate %.1f%% is below required %.1f%%".format(rate * 100, minRate * 100)
                "Tabs with different content per tab",
                "Together",
                "anthropic",
                "cerebras",
                "chip-selection",
                "complex-screen",
                "dashboard-stats",
                "deepseek",
                "gemini",
                "groq",
                "list-items",
                "mistral",
                "mistral-ft",
                "mixed-markdown",
                "moonshot",
                "multi-field-form",
                "nested-cards",
                "openai",
                "openrouter",
                "quiz-buttons",
                "quote-and-stat",
                "simple-question",
                "table-data",
                "tabs-layout",
                "together",
                "xAI",
                "xai",
                )
                0,
                ProviderSpec.Kind.ANTHROPIC,
                ProviderSpec.Kind.GEMINI,
                ProviderSpec.Kind.OPENAI_COMPAT,
                Service.Anthropic,
                Service.Cerebras,
                Service.DeepSeek,
                Service.Gemini,
                Service.Groq,
                Service.Mistral,
                Service.Moonshot,
                Service.OpenAI,
                Service.OpenRouter,
                Service.Together,
                Service.XAI,
                Status.API_ERROR,
                TestPrompt.Mode.DYNAMIC_UI,
                TestPrompt.Mode.INTERACTIVE,
                allResults.add(result)
                appendLine(
                appendLine("## ${p.label} (`${p.modelId}`)")
                appendLine("| Prompt | Status | Summary |")
                appendLine("|--------|--------|---------|")
                appendLine()
                buildString {
                else -> "NO_UI"
                env("KAI_ANTHROPIC_MODEL") ?: "claude-3-5-haiku-latest",
                env("KAI_CEREBRAS_MODEL") ?: "llama-3.3-70b",
                env("KAI_DEEPSEEK_MODEL") ?: "deepseek-chat",
                env("KAI_GEMINI_MODEL") ?: "gemini-2.0-flash",
                env("KAI_GROQ_MODEL") ?: "llama-3.3-70b-versatile",
                env("KAI_MISTRAL_FT_MODEL") ?: "ft:open-mistral-7b:latest",
                env("KAI_MISTRAL_MODEL") ?: "mistral-small-latest",
                env("KAI_MOONSHOT_MODEL") ?: "moonshot-v1-8k",
                env("KAI_OPENAI_MODEL") ?: "gpt-4o-mini",
                env("KAI_OPENROUTER_MODEL") ?: "openai/gpt-4o-mini",
                env("KAI_TOGETHER_MODEL") ?: "meta-llama/Llama-3.3-70B-Instruct-Turbo",
                env("KAI_XAI_MODEL") ?: "grok-2-latest",
                err > 0 && ui == 0 -> "PARSE_ERROR"
                err > 0 -> "PARTIAL"
                for (r in results.filter { it.provider.slug == p.slug }) {
                if (failed.isNotEmpty()) {
                it,
                println("  [$marker] ${prompt.slug}: ${result.summary}")
                prompt,
                provider,
                resp.choices.firstOrNull()?.message?.effectiveContent.orEmpty()
                resp.extractText()
                ui > 0 -> "SUCCESS"
                val failed = results.filter { it.provider.slug == p.slug && it.status != Status.SUCCESS }
                val marker = when (result.status) {
                val messages = listOf(
                val r = results.filter { it.provider.slug == p.slug }
                val resp = requests.anthropicChat(creds, messages, systemInstruction = systemPrompt).getOrThrow()
                val resp = requests.geminiChat(creds, messages, systemInstruction = systemPrompt).getOrThrow()
                val resp = requests.openAICompatibleChat(provider.service, creds, messages).getOrThrow()
                val result = runPrompt(requests, provider, prompt, providerDir)
                }
                },
            !hasFence && uiBlocks.isEmpty() && errorBlocks.isEmpty() -> Status.NO_UI
            )
            ),
            .filter { it.isFile && it.name.endsWith(".raw.txt") }
            .sortedBy { it.absolutePath }
            .toList()
            File(providerDir, "${prompt.slug}.error.txt").writeText(
            ProviderSpec.Kind.ANTHROPIC -> {
            ProviderSpec.Kind.GEMINI -> {
            ProviderSpec.Kind.OPENAI_COMPAT -> {
            TestPrompt(
            append("- Always include clear primary action buttons so the user can proceed.\n")
            append("- Do NOT include back buttons, navigation bars, or any navigation controls.\n")
            append("- Each response is a COMPLETE screen layout. Include all content and actions in one kai-ui block.\n")
            append("- Each screen is independent.\n")
            append("- Every screen MUST have at least one interactive element with a callback action.\n")
            append("- Keep button labels short (1-3 words)\n")
            append("- Keep button labels short (1-3 words)\n\n")
            append("- Only use the exact components and properties defined above.\n")
            append("- Put buttons INSIDE cards, directly below related content\n")
            append("- Start with simple, clean layouts.\n\n")
            append("- The UI is static once rendered. NEVER show loading, fetching, or verifying states.\n")
            append("- Use columns for vertical flow. Use the full component set.\n\n")
            append("- Use headline text for screen titles. Structure screens with cards for grouping related content.\n")
            append("- Use rows for groups of buttons or chips — rows wrap automatically\n")
            append("Example:\n```kai-ui\n{\"type\":\"column\",\"children\":[{\"type\":\"text\",\"value\":\"Welcome\",\"style\":\"headline\"},{\"type\":\"card\",\"children\":[{\"type\":\"text\",\"value\":\"What would you like to do?\",\"style\":\"title\"},{\"type\":\"button\",\"label\":\"Get Started\",\"action\":{\"type\":\"callback\",\"event\":\"get_started\"}}]}]}\n```\n")
            append("Example:\n```kai-ui\n{\"type\":\"column\",\"children\":[{\"type\":\"text\",\"value\":\"Your name?\",\"style\":\"title\"},{\"type\":\"text_input\",\"id\":\"name\",\"placeholder\":\"Enter name\"},{\"type\":\"button\",\"label\":\"Submit\",\"action\":{\"type\":\"callback\",\"event\":\"submit\",\"collectFrom\":[\"name\"]}}]}\n```\n")
            append("For example, if the user asks you to help plan a trip, present destination options as buttons; if you need preferences, show a form; if presenting choices, use interactive cards. ")
            append("Layout tips:\n")
            append("Layout:\n")
            append("Limitations — respect these strictly:\n")
            append("Proactively use them whenever you need input from the user — don't just ask in plain text if a form, selector, or buttons would be more natural. ")
            append("Rules:\n")
            append("Use kai-ui whenever collecting data, offering choices, presenting structured information, or guiding multi-step workflows. ")
            append("You are in full-screen interactive UI mode. The user ONLY sees rendered kai-ui components — they cannot see markdown, plain text, or anything outside a kai-ui fence.\n")
            append("You can enhance your chat responses with interactive UI elements using kai-ui blocks. ")
            append("You can mix kai-ui blocks with regular markdown text naturally — use markdown for explanations and kai-ui for interactive elements.\n\n")
            append("Your ENTIRE response must be a single ```kai-ui code fence. No text before it, no text after it, no markdown. If you write anything outside the fence, the user will NOT see it.\n\n")
            append("\n## Dynamic UI\n")
            append("\n## Interactive UI Mode (ACTIVE)\n")
            appendLine("# kai-ui Integration Report")
            appendLine("## Summary")
            appendLine("Generated: ${java.time.LocalDateTime.now()}")
            appendLine("Total prompts: ${results.size}  |  Success: ${results.count { it.status == Status.SUCCESS }}")
            appendLine("| Provider | Model | OK | Partial | NoUI | ParseErr | ApiErr |")
            appendLine("|----------|-------|----|---------|------|----------|--------|")
            appendLine()
            callApi(requests, provider, systemPrompt, prompt.userMessage)
            check(rate >= minRate) {
            else -> Status.NO_UI
            error(
            errorBlocks.isNotEmpty() && uiBlocks.isEmpty() -> Status.PARSE_ERROR
            errorBlocks.isNotEmpty() -> Status.PARTIAL
            errorFile.writeText(
            for (p in providers) {
            for (prompt in TEST_PROMPTS) {
            out += ProviderSpec(
            println("    Run the online test first with KAI_INTEGRATION=1 and at least one provider key.")
            println("    Set any of: KAI_OPENAI_KEY, KAI_ANTHROPIC_KEY, KAI_GEMINI_KEY, KAI_GROQ_KEY, KAI_OPENROUTER_KEY")
            println("  ${p.label.padEnd(12)} $ok/${r.size} success  (${p.modelId})")
            println("[KaiUiValidationTest] Replay skipped — no .raw.txt files under ${reportDir.absolutePath}")
            println("[KaiUiValidationTest] Replay skipped — no report directory at ${reportDir.absolutePath}")
            println("[KaiUiValidationTest] Skipped — no provider API keys found in env.")
            println("[KaiUiValidationTest] Skipped — set KAI_INTEGRATION=1 to run.")
            println("\n[KaiUiValidationTest] === ${provider.label} (${provider.modelId}) ===")
            return
            return result
            uiBlocks.isNotEmpty() -> Status.SUCCESS
            val blocks = parseMarkdown(raw).blocks
            val err = blocks.filterIsInstance<KaiUiError>().size
            val errorFile = File(providerDir, "${prompt.slug}.error.txt")
            val hasFence = ui > 0 || err > 0
            val marker = status.padEnd(11)
            val ok = r.count { it.status == Status.SUCCESS }
            val providerDir = File(reportDir, provider.slug).apply { mkdirs() }
            val r = results.filter { it.provider.slug == p.slug }
            val rate = allResults.count { it.status == Status.SUCCESS }.toDouble() / allResults.size
            val raw = file.readText()
            val rel = file.relativeTo(reportDir).path
            val result = PromptResult(
            val status = when {
            val ui = blocks.filterIsInstance<KaiUiBlock>().size
            when (status) {
            }
        )
        File(providerDir, "${prompt.slug}.raw.txt").writeText(raw)
        File(reportDir, "report.md").writeText(report)
        append("- Form inputs only store state locally. Their values are ONLY sent when a button's collectFrom includes their id. Always pair form inputs with a submit button that collects from them.\n\n")
        append("- accordion: {\"type\":\"accordion\",\"title\":\"...\",\"children\":[...],\"expanded\":false}\n")
        append("- alert: {\"type\":\"alert\",\"message\":\"...\",\"title\":\"...\",\"severity\":\"info|success|warning|error\"}\n")
        append("- avatar: {\"type\":\"avatar\",\"name\":\"John Doe\",\"imageUrl\":\"https://...\",\"size\":40}\n\n")
        append("- badge: {\"type\":\"badge\",\"value\":\"3\",\"color\":\"primary|secondary|error\"}\n")
        append("- box: {\"type\":\"box\",\"children\":[...],\"contentAlignment\":\"center\"}\n")
        append("- button: {\"type\":\"button\",\"label\":\"...\",\"action\":{...},\"variant\":\"filled|outlined|text|tonal\"}\n")
        append("- callback: {\"type\":\"callback\",\"event\":\"event_name\",\"data\":{\"key\":\"val\"},\"collectFrom\":[\"input_id1\",\"input_id2\"]}\n")
        append("- checkbox: {\"type\":\"checkbox\",\"id\":\"...\",\"label\":\"...\",\"checked\":false}\n")
        append("- chip_group: {\"type\":\"chip_group\",\"id\":\"...\",\"chips\":[{\"label\":\"Tag\",\"value\":\"tag\"}],\"selection\":\"single|multi|none\"}\n")
        append("- code: {\"type\":\"code\",\"code\":\"...\",\"language\":\"kotlin\"}\n")
        append("- countdown: {\"type\":\"countdown\",\"seconds\":300,\"label\":\"Time left\",\"action\":{\"type\":\"callback\",\"event\":\"timer_done\"}}\n")
        append("- list: {\"type\":\"list\",\"items\":[...],\"ordered\":false}\n")
        append("- open_url: {\"type\":\"open_url\",\"url\":\"https://...\"}\n\n")
        append("- progress: {\"type\":\"progress\",\"value\":0.5,\"label\":\"50%\"}\n")
        append("- quote: {\"type\":\"quote\",\"text\":\"...\",\"source\":\"Author Name\"}\n")
        append("- radio_group: {\"type\":\"radio_group\",\"id\":\"...\",\"label\":\"...\",\"options\":[\"A\",\"B\"],\"selected\":\"A\"}\n")
        append("- select: {\"type\":\"select\",\"id\":\"...\",\"label\":\"...\",\"options\":[\"A\",\"B\"],\"selected\":\"A\"}\n")
        append("- slider: {\"type\":\"slider\",\"id\":\"...\",\"label\":\"...\",\"value\":50,\"min\":0,\"max\":100,\"step\":10}\n")
        append("- stat: {\"type\":\"stat\",\"value\":\"\$1,234\",\"label\":\"Revenue\",\"description\":\"12% increase\"}\n")
        append("- switch: {\"type\":\"switch\",\"id\":\"...\",\"label\":\"...\",\"checked\":false}\n")
        append("- table: {\"type\":\"table\",\"headers\":[\"Col1\",\"Col2\"],\"rows\":[[\"a\",\"b\"]]}\n")
        append("- tabs: {\"type\":\"tabs\",\"tabs\":[{\"label\":\"Tab 1\",\"children\":[...]},{\"label\":\"Tab 2\",\"children\":[...]}],\"selectedIndex\":0}\n")
        append("- text: {\"type\":\"text\",\"value\":\"...\",\"style\":\"headline|title|body|caption\",\"bold\":true,\"color\":\"primary|secondary|error\"} — do NOT use markdown formatting (**, *, #, etc.) in text values; use the bold/italic/style properties instead\n")
        append("- text_input: {\"type\":\"text_input\",\"id\":\"...\",\"label\":\"...\",\"placeholder\":\"...\",\"value\":\"...\"}\n")
        append("- toggle: {\"type\":\"toggle\",\"targetId\":\"element_id\"}\n")
        append("Actions (on buttons, countdown expiry):\n")
        append("Components: column, row, card, box, text, button, text_input, checkbox, switch, select, radio_group, slider, chip_group, table, list, divider, image, icon, code, progress, countdown, alert, tabs, accordion, quote, badge, stat, avatar.\n")
        append("Format: wrap a JSON object in ```kai-ui fences.\n\n")
        enum class Kind { OPENAI_COMPAT, GEMINI, ANTHROPIC }
        enum class Mode { DYNAMIC_UI, INTERACTIVE }
        env("KAI_ANTHROPIC_KEY")?.let {
        env("KAI_CEREBRAS_KEY")?.let {
        env("KAI_DEEPSEEK_KEY")?.let {
        env("KAI_GEMINI_KEY")?.let {
        env("KAI_GROQ_KEY")?.let {
        env("KAI_MISTRAL_FT_KEY")?.let {
        env("KAI_MISTRAL_KEY")?.let {
        env("KAI_MOONSHOT_KEY")?.let {
        env("KAI_OPENAI_KEY")?.let {
        env("KAI_OPENROUTER_KEY")?.let {
        env("KAI_TOGETHER_KEY")?.let {
        env("KAI_XAI_KEY")?.let {
        for (file in rawFiles) {
        for (p in providers) {
        for (provider in providers) {
        if (!reportDir.isDirectory) {
        if (System.getenv("KAI_INTEGRATION") != "1") {
        if (dynamicUiOnly) {
        if (minRate > 0.0) {
        if (providers.isEmpty()) {
        if (rawFiles.isEmpty()) {
        if (status != Status.SUCCESS) {
        if (strict && failures.isNotEmpty()) {
        printSummary(allResults, providers)
        println("  ${"TOTAL".padEnd(12)} $successes/$total success")
        println("\n[KaiUiValidationTest] === SUMMARY ===")
        println("\n[KaiUiValidationTest] Replay summary: $success ok, $partial partial, $noUi no-ui, $parseError parse-error  (total ${rawFiles.size})")
        println("\n[KaiUiValidationTest] Replaying ${rawFiles.size} saved responses from ${reportDir.absolutePath}")
        println("\n[KaiUiValidationTest] Report written to: ${File(reportDir, "report.md").absolutePath}")
        private val TEST_PROMPTS = listOf(
        prompt: TestPrompt,
        provider: ProviderSpec,
        providerDir: File,
        reportDir.mkdirs()
        requests: Requests,
        return PromptResult(provider, prompt, status, summary, uiBlocks.size, errorBlocks.size, raw)
        return out
        systemPrompt: String,
        userMessage: String,
        val allResults = mutableListOf<PromptResult>()
        val apiKey: String,
        val blocks = parseMarkdown(raw).blocks
        val creds = ServiceCredentials(apiKey = provider.apiKey, modelId = provider.modelId)
        val description: String,
        val dynamicUiOnly = mode == TestPrompt.Mode.DYNAMIC_UI
        val errorBlocks = blocks.filterIsInstance<KaiUiError>()
        val errorSegmentCount: Int,
        val failures = mutableListOf<Pair<File, String>>()
        val hasFence = uiBlocks.isNotEmpty() || errorBlocks.isNotEmpty()
        val kind: Kind,
        val label: String,
        val minRate = System.getenv("KAI_MIN_SUCCESS_RATE")?.toDoubleOrNull() ?: 0.0
        val mode: Mode,
        val modelId: String,
        val out = mutableListOf<ProviderSpec>()
        val prompt: TestPrompt,
        val provider: ProviderSpec,
        val providers = discoverProviders()
        val raw = try {
        val rawFiles = reportDir.walkTopDown()
        val rawResponse: String,
        val report = buildString {
        val reportDir = File(System.getenv("KAI_REPORT_DIR") ?: "build/reports/kaiui-integration")
        val requests = Requests()
        val service: Service,
        val slug: String,
        val status = when {
        val status: Status,
        val strict = System.getenv("KAI_REPLAY_STRICT") == "1"
        val successes = results.count { it.status == Status.SUCCESS }
        val summary = "${uiBlocks.size} ui, ${errorBlocks.size} err, ${raw.length} chars"
        val summary: String,
        val systemPrompt = buildSystemPrompt(prompt.mode)
        val total = results.size
        val uiBlocks = blocks.filterIsInstance<KaiUiBlock>()
        val uiSegmentCount: Int,
        val userMessage: String,
        var noUi = 0
        var parseError = 0
        var partial = 0
        var success = 0
        when (provider.kind) {
        writeReport(reportDir, allResults, providers)
        }
        } catch (e: Exception) {
        } else {
     *
     * API keys — use this while iterating on parser fixes or prompt tweaks.
     * Duplicates the kai-ui portion of the app's system prompt. Mirrors
     * Keep in sync manually if the real prompt changes — there is no automated drift check.
     * Offline re-parse of responses saved by a previous run of the integration test.
     * Skips silently if no saved responses are found. Set `KAI_REPLAY_STRICT=1` to make
     * Walks every `.raw.txt` file under the report directory, feeds each file through
     * `RemoteDataRepository.getActiveSystemPrompt()` lines 1417-1495 (as of 2026-04-05).
     * `parseMarkdown()`, and reports which ones still fail. Free, fast, and needs no
     * the test fail when any previously-failing response still fails to parse cleanly.
     */
    )
    ) {
    ): PromptResult {
    ): String = runBlocking {
    /**
    // endregion
    // region Prompt execution ------------------------------------------------------------------
    // region Provider discovery ----------------------------------------------------------------
    // region Reporting -------------------------------------------------------------------------
    // region System prompt (mirror of RemoteDataRepository.getActiveSystemPrompt) --------------
    // region Test prompts ----------------------------------------------------------------------
    @Test
    companion object {
    fun `replay saved responses`() {
    fun `validate kai-ui output across providers`() {
    private data class PromptResult(
    private data class ProviderSpec(
    private data class TestPrompt(
    private enum class Status { SUCCESS, PARTIAL, NO_UI, PARSE_ERROR, API_ERROR }
    private fun buildSystemPrompt(mode: TestPrompt.Mode): String = buildString {
    private fun callApi(
    private fun discoverProviders(): List<ProviderSpec> {
    private fun env(name: String): String? = System.getenv(name)?.takeIf { it.isNotBlank() }
    private fun printSummary(results: List<PromptResult>, providers: List<ProviderSpec>) {
    private fun runPrompt(
    private fun writeReport(reportDir: File, results: List<PromptResult>, providers: List<ProviderSpec>) {
    }
 *
 *   ./gradlew :composeApp:desktopTest --tests "*KaiUiValidationTest*" --info
 *   KAI_ANTHROPIC_KEY=sk-ant-... \
 *   KAI_OPENAI_KEY=sk-... \
 *   `ErrorSegment` or no `UiSegment` at all; contains raw JSON plus parser diagnostics
 *   no longer parses cleanly. Default off (report-only).
 * ## How to run
 * ## Iteration workflow
 * ## What it produces
 * - `<provider>/<slug>.error.txt` — only for prompts where the parser produced
 * - `<provider>/<slug>.raw.txt` — raw assistant response for every prompt
 * - `KAI_MIN_SUCCESS_RATE` — 0.0-1.0, fail the test below this rate (default: 0.0, never fail)
 * - `KAI_REPLAY_STRICT` — set to `1` to make the replay test fail when any saved response
 * - `KAI_REPORT_DIR` — where to write the report (default: `build/reports/kaiui-integration`)
 * - `report.md` — overall summary table plus per-provider/per-prompt status
 * 1. Run the online integration test once with API keys (costs money, saves responses)
 * 2. Modify the parser / prompt
 * 3. Run the `replay saved responses` test (no keys, free, fast) to check the fix
 * 4. When green, copy the now-passing payloads into `KaiUiParserTest` as regressions
 * Additional knobs:
 * Any subset of provider keys can be supplied — the test auto-detects which ones are
 * By default this test is **skipped** — it only runs when `KAI_INTEGRATION=1` is set
 * Integration test that exercises real LLM providers with a battery of prompts and
 * KAI_INTEGRATION=1 \
 * The `.raw.txt` files are pure LLM output with no headers — safe to feed back
 * Under the report directory:
 * ```
 * below for an offline re-parse harness.
 * in the environment, because it makes real (paid) API calls.
 * present and only runs those. Supported env vars:
 * through `parseMarkdown()` directly. See the `replay saved responses` test
 * validates that their responses contain well-formed kai-ui blocks.
 * | Anthropic    | KAI_ANTHROPIC_KEY     | KAI_ANTHROPIC_MODEL      | claude-3-5-haiku-latest      |
 * | Cerebras     | KAI_CEREBRAS_KEY      | KAI_CEREBRAS_MODEL       | llama-3.3-70b                |
 * | DeepSeek     | KAI_DEEPSEEK_KEY      | KAI_DEEPSEEK_MODEL       | deepseek-chat                |
 * | Gemini       | KAI_GEMINI_KEY        | KAI_GEMINI_MODEL         | gemini-2.0-flash             |
 * | Groq         | KAI_GROQ_KEY          | KAI_GROQ_MODEL           | llama-3.3-70b-versatile      |
 * | Mistral      | KAI_MISTRAL_KEY       | KAI_MISTRAL_MODEL        | mistral-small-latest         |
 * | Mistral FT   | KAI_MISTRAL_FT_KEY    | KAI_MISTRAL_FT_MODEL     | ft:open-mistral-7b:latest  |
 * | Moonshot     | KAI_MOONSHOT_KEY      | KAI_MOONSHOT_MODEL       | moonshot-v1-8k               |
 * | OpenAI       | KAI_OPENAI_KEY        | KAI_OPENAI_MODEL         | gpt-4o-mini                  |
 * | OpenRouter   | KAI_OPENROUTER_KEY    | KAI_OPENROUTER_MODEL     | openai/gpt-4o-mini           |
 * | Provider     | Key env var           | Model env var (optional) | Default model                |
 * | Together     | KAI_TOGETHER_KEY      | KAI_TOGETHER_MODEL       | meta-llama/Llama-3.3-70B-Instruct-Turbo |
 * | xAI          | KAI_XAI_KEY           | KAI_XAI_MODEL            | grok-2-latest                |
 * |--------------|-----------------------|--------------------------|------------------------------|
 */
/**
class KaiUiValidationTest {
import com.inspiredandroid.kai.data.Service
import com.inspiredandroid.kai.network.Requests
import com.inspiredandroid.kai.network.ServiceCredentials
import com.inspiredandroid.kai.network.dtos.anthropic.AnthropicChatRequestDto
import com.inspiredandroid.kai.network.dtos.anthropic.extractText
import com.inspiredandroid.kai.network.dtos.gemini.GeminiChatRequestDto
import com.inspiredandroid.kai.network.dtos.gemini.extractText
import com.inspiredandroid.kai.network.dtos.openaicompatible.OpenAICompatibleChatRequestDto
import com.inspiredandroid.kai.ui.markdown.KaiUiBlock
import com.inspiredandroid.kai.ui.markdown.KaiUiError
import com.inspiredandroid.kai.ui.markdown.parseMarkdown
import java.io.File
import kotlin.test.Test
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.JsonPrimitive
package com.inspiredandroid.kai.integration
}
