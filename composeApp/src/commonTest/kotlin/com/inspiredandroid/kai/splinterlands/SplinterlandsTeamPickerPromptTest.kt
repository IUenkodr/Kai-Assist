package com.inspiredandroid.kai.splinterlands
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

                card(uid = "c1", name = "Fire Card", color = "Red"),
                card(uid = "c1", name = "Fire Demon"),
                card(uid = "c1", name = "Normal Card"),
                card(uid = "c2", name = "Glad Card", isGladiator = true),
                card(uid = "c2", name = "Goblin Shaman"),
                card(uid = "c2", name = "Water Card", color = "Blue"),
                card(uid = "c3", name = "Neutral Card", color = "Gray"),
                card(uid = "c3", name = "Serpentine Spy"),
                summoner(uid = "s1", name = "Pyre"),
                summoner(uid = "s1", name = "Regular"),
                summoner(uid = "s2", name = "Conscripted", buffs = SummonerBuffs(abilities = listOf("Conscript"))),
                summoner(uid = "s2", name = "Tarsa"),
            ),
            matchInfo = matchInfo(),
            matchInfo = matchInfo(manaCap = 27),
            matchInfo = matchInfo(ruleset = "Little League|Melee Mayhem"),
            maxMonsters = 6,
            monsters = listOf(
            monsters = listOf(card(uid = "c1", name = "Card")),
            monsters = listOf(card(uid = "c1", name = "Fire Demon")),
            monsters = listOf(card(uid = "card-uid-1", name = "Fire Demon")),
            summoners = listOf(
            summoners = listOf(summoner(uid = "s1", name = "Pyre")),
            summoners = listOf(summoner(uid = "s1", name = "Pyre", color = "Red")),
            summoners = listOf(summoner(uid = "summoner-uid-1", name = "Pyre")),
        )
        // Monsters use 1000+index in the id map (see SplinterlandsTeamPicker.kt).
        // Red summoner can only play Red and Gray (Neutral). Blue card should be dropped.
        abilities = abilities,
        abilities: List<String> = emptyList(),
        armor = 0,
        armor = armor,
        armor: Int = 0,
        assertEquals("card-uid-1", result.idMap[1001])
        assertEquals("summoner-uid-1", result.idMap[1])
        assertFalse("M1: Normal Card" in result.userMessage && "[GLAD]" in result.userMessage.substringAfter("Normal Card").substringBefore("M2:"))
        assertFalse("Water Card" in result.userMessage, "unplayable Blue card should be filtered")
        assertFalse("{mana_cap}" in result.systemPrompt, "placeholder should be replaced")
        assertFalse("{max_monsters}" in result.systemPrompt, "placeholder should be replaced")
        assertTrue("27" in result.systemPrompt, "mana_cap should be interpolated")
        assertTrue("6" in result.systemPrompt, "max_monsters should be interpolated")
        assertTrue("Fire Card" in result.userMessage)
        assertTrue("Glad Card" in result.userMessage)
        assertTrue("Little League" in result.systemPrompt)
        assertTrue("M1: Fire Demon" in result.userMessage)
        assertTrue("M2: Goblin Shaman" in result.userMessage)
        assertTrue("M3: Serpentine Spy" in result.userMessage)
        assertTrue("Melee Mayhem" in result.systemPrompt)
        assertTrue("Neutral Card" in result.userMessage, "Gray/Neutral cards are always playable")
        assertTrue("Pick a strong team NOW" in result.userMessage)
        assertTrue("S1: Pyre" in result.userMessage)
        assertTrue("S2: Conscripted" in result.userMessage)
        assertTrue("S2: Tarsa" in result.userMessage)
        assertTrue("[CONSCRIPT]" in result.userMessage)
        assertTrue("[GLAD]" in result.userMessage)
        assertTrue(result.userMessage.trimEnd().endsWith("\"mana_total\": <number>}"))
        attackPower = 0,
        attackPower = attackPower,
        attackPower: Int = 2,
        attackType = "None",
        attackType = attackType,
        attackType: String = "Melee",
        buffs = buffs,
        buffs: SummonerBuffs = SummonerBuffs(),
        color = color,
        color: String = "Red",
        detailId = 0,
        health = 0,
        health = health,
        health: Int = 5,
        isGladiator = isGladiator,
        isGladiator: Boolean = false,
        mana = mana,
        mana: Int = 3,
        name = name,
        name: String = "Card",
        name: String = "Summoner",
        put("mana_cap", manaCap)
        put("ruleset", ruleset)
        rarity = "Common",
        speed = 0,
        speed = speed,
        speed: Int = 2,
        splinter = splinter,
        splinter: String = "Fire",
        uid = uid,
        uid: String = "c-placeholder",
        uid: String = "s-placeholder",
        val result = buildLlmPrompt(
    )
    ) = CardEntry(
    ) = SummonerEntry(
    @Test
    fun `conscript summoners are tagged CONSCRIPT in the user message`() {
    fun `custom rulesets appear in the system prompt`() {
    fun `gladiator monsters are tagged GLAD in the user message`() {
    fun `idMap maps numbered ids back to uids`() {
    fun `system prompt interpolates mana_cap and max_monsters`() {
    fun `unplayable monsters are filtered out before numbering`() {
    fun `user message ends with the JSON response schema instruction`() {
    fun `user message numbers summoners S1-Sn and monsters M1-Mn`() {
    private fun card(
    private fun matchInfo(manaCap: Int = 20, ruleset: String = "Standard"): JsonObject = buildJsonObject {
    private fun summoner(
    }
 * Locks in the contract of [buildLlmPrompt]. The Splinterlands LLM picker builds a
 * system prompt + user message pair from a match description; these tests assert
 * that the structural pieces survive refactors.
 */
/**
class SplinterlandsTeamPickerPromptTest {
}
