package com.inspiredandroid.kai.data
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

            assertEquals(displayName, info.displayName, "displayName for $modelId")
        assertContext("claude-3-5-sonnet", 200_000L)
        assertContext("claude-fable-5", 1_000_000L)
        assertContext("claude-fable-5-1", 1_000_000L)
        assertContext("claude-fable-5.1", 1_000_000L, "Claude Fable 5.1")
        assertContext("claude-fable-5.1-max", 1_000_000L)
        assertContext("claude-haiku-4.5", 200_000L, "Claude Haiku 4.5")
        assertContext("claude-opus-4", 200_000L)
        assertContext("claude-opus-4-6", 1_000_000L)
        assertContext("claude-opus-4-6-high", 1_000_000L)
        assertContext("claude-opus-4-6-thinking", 1_000_000L)
        assertContext("claude-opus-4.5", 200_000L, "Claude Opus 4.5")
        assertContext("claude-opus-4.6", 1_000_000L, "Claude Opus 4.6")
        assertContext("claude-opus-4.6-fast", 1_000_000L)
        assertContext("claude-opus-4.7", 1_000_000L)
        assertContext("claude-opus-4.8", 1_000_000L)
        assertContext("claude-opus-5", 1_000_000L)
        assertContext("claude-sonnet-4", 200_000L, "Claude Sonnet 4")
        assertContext("claude-sonnet-4-5", 200_000L)
        assertContext("claude-sonnet-4-5-20250929", 200_000L)
        assertContext("claude-sonnet-4-6", 1_000_000L)
        assertContext("claude-sonnet-4.5", 200_000L, "Claude Sonnet 4.5")
        assertContext("claude-sonnet-4.6", 1_000_000L, "Claude Sonnet 4.6")
        assertContext("claude-sonnet-5", 1_000_000L)
        assertContext("gemini-2.5-flash", 1_000_000L)
        assertContext("gemini-2.5-pro", 1_000_000L, "Gemini 2.5 Pro")
        assertContext("gemini-2.5-pro-latest", 1_000_000L)
        assertContext("gemini-2.5-pro-preview", 1_000_000L)
        assertContext("gemini-3-pro", 1_000_000L, "Gemini 3 Pro")
        assertContext("gemini-3-pro-preview", 1_000_000L)
        assertContext("gemini-3.1-pro-preview", 1_000_000L)
        assertContext("gemini-3.7-flash-high", 1_000_000L)
        assertContext("gemini-3.8-flash", 1_000_000L, "Gemini 3.8 Flash")
        assertContext("gemini-3.8-flash-high", 1_000_000L)
        assertContext("gemma-3-27b-it", 262_144L)
        assertContext("gemma-4-26b-a4b-it", 262_144L)
        assertContext("gemma-4-31b-it", 262_144L)
        assertContext("gpt-4.1", 1_000_000L, "GPT-4.1")
        assertContext("gpt-4o", 128_000L, "GPT-4o")
        assertContext("gpt-5", 400_000L, "GPT-5")
        assertContext("gpt-5.2", 400_000L, "GPT-5.2")
        assertContext("gpt-5.4", 1_050_000L, "GPT-5.4")
        assertContext("gpt-5.4-chat", 1_050_000L)
        assertContext("gpt-5.4-mini", 400_000L)
        assertContext("gpt-5.4-nano", 400_000L)
        assertContext("gpt-5.4-pro", 1_050_000L)
        assertContext("gpt-5.5", 1_050_000L, "GPT-5.5")
        assertContext("gpt-5.5-instant", 1_050_000L)
        assertContext("gpt-5.5-pro", 1_050_000L)
        assertContext("gpt-latest", 1_050_000L)
        assertContext("grok-4", 256_000L, "Grok 4")
        assertContext("grok-4-fast", 2_000_000L)
        assertContext("grok-4.20", 2_000_000L, "Grok 4.20")
        assertContext("grok-4.20-multi-agent", 2_000_000L)
        assertContext("grok-4.3", 1_000_000L, "Grok 4.3")
        assertContext("grok-4.5", 500_000L, "Grok 4.5")
        assertContext("grok-4.6", 500_000L, "Grok 4.6")
        assertContext("grok-4.6-high", 500_000L, "Grok 4.6 (High)")
        assertContext("kimi-k2-0905", 262_144L)
        assertContext("kimi-k2-thinking", 262_144L)
        assertContext("kimi-k2.5", 256_000L)
        assertContext("kimi-k3", 1_000_000L)
        assertContext("lyria-3-clip-preview", 0L)
        assertContext("lyria-3-pro-preview", 0L)
        assertContext("minimax-m2", 204_800L, "MiniMax M2")
        assertContext("minimax-m2-her", 65_536L, "MiniMax M2 Her")
        assertContext("minimax-m2.1", 204_800L, "MiniMax M2.1")
        assertContext("minimax-m2.1-preview", 204_800L)
        assertContext("minimax-m2.5", 204_800L, "MiniMax M2.5")
        assertContext("minimax-m2.5-free", 204_800L)
        assertContext("minimax-m2.5:free", 204_800L)
        assertContext("minimax-m2.7", 204_800L, "MiniMax M2.7")
        assertContext("minimax-m3", 1_000_000L, "MiniMax M3")
        assertContext("mistral-large-2512", 262_144L)
        assertContext("mistral-large-3", 262_144L)
        assertContext("mistral-medium-3-5", 262_144L)
        assertContext("mistral-medium-3.5", 262_144L)
        assertContext("qwen-plus", 1_000_000L)
        assertContext("qwen-plus-latest", 1_000_000L)
        assertContext("qwen3-235b-a22b-2507", 262_144L)
        assertContext("qwen3-coder-flash", 1_000_000L)
        assertContext("qwen3.5-27b", 262_144L)
        assertContext("qwen3.5-397b-a17b", 262_144L)
        assertContext("qwen3.5-9b", 262_144L)
        assertContext("qwen3.5-flash", 1_000_000L)
        assertContext("qwen3.5-plus", 1_000_000L)
        assertContext("qwen3.6-flash", 1_000_000L)
        assertContext("qwen3.6-plus", 1_000_000L)
        assertContext("qwen3.7-max", 1_000_000L)
        assertContext("qwen3.8-27b", 262_144L)
        assertEquals(1427, ModelCatalog.lookup("muse-glimmer")?.arenaScore)
        assertEquals(1461, ModelCatalog.lookup("grok-4.6-high")?.arenaScore)
        assertEquals(1482, ModelCatalog.lookup("glm-5.3-max")?.arenaScore)
        assertEquals(1491, ModelCatalog.lookup("gemini-3.7-flash-high")?.arenaScore)
        assertEquals(1494, ModelCatalog.lookup("gemini-3.8-flash-high")?.arenaScore)
        assertEquals(1504, ModelCatalog.lookup("claude-fable-5.1-max")?.arenaScore)
        assertEquals(1507, ModelCatalog.lookup("claude-fable-5")?.arenaScore)
        assertEquals(204_800, ModelCatalog.estimateContextWindow("minimax-m2.7"))
        assertEquals(ModelCatalog.DEFAULT_CONTEXT_WINDOW_TOKENS, unknown)
        assertEquals(expected, info.contextWindow, "contextWindow for $modelId")
        assertNotNull(info, "Missing catalog entry for $modelId")
        if (displayName != null) {
        val info = ModelCatalog.lookup(modelId)
        val unknown = ModelCatalog.estimateContextWindow("totally-unknown-model-xyz")
        }
    //          https://developers.openai.com/api/docs/models/gpt-5.5
    // ------------------------------------------------------------------
    // 1M: Opus 5 / 4.8 / 4.7 / 4.6, Sonnet 5 / 4.6, Fable 5 / 5.1
    // 200k: Sonnet 4.5, Haiku 4.5, Opus 4.5, older Claude 4/3.x
    // Anthropic — https://platform.claude.com/docs/en/build-with-claude/context-windows
    // Google Gemini — 2.5/3 Pro are 1M (not 2M) on standard API
    // MiniMax — https://platform.minimax.io/docs/guides/text-generation
    // OpenAI — https://developers.openai.com/api/docs/models/gpt-5.4
    // Other high-traffic families
    // Qwen cloud + open weights (OpenRouter + Alibaba docs)
    // xAI Grok
    @Test
    fun `arena scores attach attested text-leaderboard Elo`() {
    fun `audio models keep zero context window`() {
    fun `claude 1M models`() {
    fun `claude 200k models including Sonnet 4_5 default`() {
    fun `estimateContextWindow falls back for unknown ids`() {
    fun `gemini pro models are 1M not 2M`() {
    fun `gemma 4 and gemma 3 27b are 256k-class`() {
    fun `gpt-5_4 and gpt-5_5 are 1_05M API context`() {
    fun `gpt-5_4 mini nano and earlier gpt-5 keep 400k`() {
    fun `grok 4_20 is 2M and grok 4_3 is 1M`() {
    fun `kimi k2 thinking and 0905 are 256k-class`() {
    fun `minimax M2 series is 204800 not 1M`() {
    fun `minimax M3 is 1M and M2-her is 64K`() {
    fun `mistral large 3 and medium 3_5 are 256k-class`() {
    fun `qwen plus flash max cloud models are 1M`() {
    fun `qwen3_5 open weights are 256k-class`() {
    private fun assertContext(modelId: String, expected: Long, displayName: String? = null) {
    }
 *
 * Regression coverage for curated [ModelCatalog] context windows.
 * Values are pinned to official provider docs (or OpenRouter when that is the
 * best public source). If a lookup fails or a window drifts, prefer fixing the
 * catalog entry over relaxing the assertion.
 */
/**
class ModelCatalogTest {
}
