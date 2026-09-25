import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

                    -2.0
                    -5.0
                    0.0
                    1.0
                    5.0
                    bestResult = TeamSelection(summoner.uid, team.map { it.uid }, allyColor)
                    bestTotalScore = totalScore
                    f = (b and c) or (b.inv() and d)
                    f = (d and b) or (d.inv() and c)
                    f = b xor c xor d
                    f = c xor (b or d.inv())
                    fixed
                    g = (3 * i + 5) % 16
                    g = (5 * i + 1) % 16
                    g = (7 * i) % 16
                    g = i
                    kotlinx.serialization.json.Json.parseToJsonElement(fixed)
                    return null
                    val allyColor = determineDragonAllyColor(summoner.color, team.map { it.uid }, monsterLookup)
                    val monsterLookup = team.associateBy { it.uid }
                    validColors.add("Gray")
                    validColors.clear()
                "Blast" -> if (ctx.deflectionShield) 0.0 else 3.0
                "Conscript" -> 5.0
                "Opportunity" in m.abilities || "Charge" in m.abilities
                "Resurrect" -> if (ctx.deathHasNoPower) 0.0 else 4.0
                ((ctx.armoredUp && !ctx.weakMagic) || ctx.unprotected)
                ((paddedMessage[offset + 1].toInt() and 0xFF) shl 8) or
                ((paddedMessage[offset + 2].toInt() and 0xFF) shl 16) or
                ((paddedMessage[offset + 3].toInt() and 0xFF) shl 24)
                (ctx.meleeFromAnyPosition || ctx.whatDoesntKillYou || ctx.stampede)
                .filter { !(it.isGladiator && gladCount >= gladLimit) }
                .filter { it.detailId !in usedIds && it.mana <= manaLeft }
                .map { it to scoreMonster(it, Position.BACKLINE, ctx) }
                .sortedByDescending { it.second }
                0
                a.jsonPrimitive.content
                arr[minOf(level - 1, arr.size - 1).coerceAtLeast(0)].jsonPrimitive.int
                bestResult = TeamSelection(summoner.uid, team.map { it.uid }, null)
                bestTotalScore = totalScore
                else -> 1.0
                else -> {
                extracted
                false
                fixed.add(m.uid)
                gladCount++
                i < 16 -> {
                i < 32 -> {
                i < 48 -> {
                if (!ctx.deflectionShield) score += if (ctx.amplify) 4.0 else 2.0
                if (!ctx.deflectionShield) score += if (ctx.amplify) 5.0 else 3.0
                if ("Shades of Gray" in rulesets) {
                if ("Taking Sides" in rulesets) validColors.remove("Gray")
                if (m.isGladiator) gladCount++
                if (m.mana > manaLeft) continue
                if (name.isNotBlank() && seen.add(name)) result.add(name)
                if (team.isEmpty()) continue
                if (team.size >= maxMonsters) break
                if (totalScore > bestTotalScore) {
                issues.add("${m.name} is ${m.splinter} — not allowed with this summoner")
                it !in inactiveColors && COLOR_TO_SPLINTER[it] !in inactiveColors && it != "Gold" && it != "Gray"
                kotlinx.serialization.json.Json.parseToJsonElement(extracted)
                manaLeft -= m.mana
                null
                remaining -= m.mana
                score += if (ctx.ferocity) {
                team.add(m)
                team.add(tankiest)
                team.remove(tankiest)
                teamScore += mScore
                trimmed.add(uid)
                true
                try {
                uidSet.add(m.uid)
                used += mMana
                usedDetailIds.add(m.detailId)
                usedIds.add(m.detailId)
                val (team, teamScore) = buildScoredTeam(colorPool, remaining, maxMonsters, gladLimit, ctx)
                val colorPool = dedupMonsters.filter { it.color in validColors }
                val fixed = extracted.replace(Regex("""(?<=[:\[,\s])([SM]\d+)(?=[,\]\s}])"""), "\"$1\"")
                val name = a.jsonPrimitive.content
                val sumScore = scoreSummoner(summoner, colorPool, ctx)
                val totalScore = sumScore + teamScore
                val validColors = mutableSetOf(ally, "Gray")
                validColors.add("Gray")
                validColors.clear()
                }
                } catch (_: Exception) {
                } else if (ctx.aimless) {
                } else {
            !ctx.enemyNoMagic &&
            !ctx.enemyNoMelee &&
            "Beefcakes" -> filtered.filter { health(it) >= 5 }
            "Broken Arrows" -> filtered.filter { attackType(it) != "ranged" }
            "Elite Force" -> filtered.filter { rarity(it) != "Common" }
            "Even Stevens" -> filtered.filter { mana(it) % 2 == 0 }
            "Going the Distance" -> filtered.filter { attackType(it) == "ranged" }
            "Heavy Metal" -> filtered.filter { armor(it) > 0 }
            "Junior Varsity" -> filtered.filter { mana(it) <= 6 }
            "Keep Your Distance" -> filtered.filter { attackType(it) != "melee" }
            "Little League" -> filtered.filter { mana(it) <= 4 }
            "Lost Legendaries" -> filtered.filter { rarity(it) != "Legendary" }
            "Lost Magic" -> filtered.filter { attackType(it) != "magic" }
            "Might Makes Right" -> filtered.filter { attackPower(it) >= 3 }
            "Monster" -> monsters.add(buildCardEntry(card, detail))
            "Need for Speed" -> filtered.filter { speed(it) >= 3 }
            "Odd Ones Out" -> filtered.filter { mana(it) % 2 == 1 }
            "Reach" in m.abilities || "Sneak" in m.abilities ||
            "Rise of the Commons" -> filtered.filter { rarity(it) in listOf("Common", "Rare") }
            "Shades of Gray" -> filtered.filter { color(it) == "Gray" }
            "Summoner" -> summoners.add(buildSummonerEntry(card, detail))
            "Taking Sides" -> filtered.filter { color(it) != "Gray" }
            "Up Close & Personal" -> filtered.filter { attackType(it) == "melee" }
            "Wands Out" -> filtered.filter { attackType(it) == "magic" }
            ((ctx.armoredUp && !ctx.weakMagic) || ctx.unprotected)
            (ctx.meleeFromAnyPosition || ctx.whatDoesntKillYou || ctx.stampede)
            (paddedMessage[offset].toInt() and 0xFF) or
            )
            .filter { !(it.isGladiator && gladCount >= gladLimit) }
            .filter { !(it.isGladiator && gladUsedByTank >= gladLimit) }
            .filter { it.detailId != tank.detailId && it.mana <= manaAfterTank }
            .filter { it.uid !in uidSet && it.detailId !in usedDetailIds && it.color in validColors && it.mana <= remaining }
            .map { it to scoreMonster(it, Position.BACKLINE, ctx) }
            .sortedByDescending { it.mana }
            .sortedByDescending { it.second / it.first.mana.coerceAtLeast(1) }
            // Defensive for backline
            // Dodge/Flying evasion only works vs melee/ranged
            // Dragon: try each ally color, pick the best scoring team
            // Enemy debuffs: only valuable if enemy uses that attack type
            // Healing/support
            // Magic Reflect: useless if enemy has no magic
            // Martyr
            // Offensive
            // Retaliate counters melee attackers
            // Return Fire / Magic Reflect on backline: only if enemy uses that type
            // Shield halves melee/ranged -- worthless if enemy is pure magic
            // Taunt: great for tank unless Ferocity (Fury doubles damage vs Taunt)
            // Team buffs
            // Thorns: good on tank vs melee, boosted by Amplify, useless with Deflection Shield or no enemy melee
            // Try extracted as-is, then try fixing unquoted S/M identifiers
            // Void halves magic -- worthless if enemy has no magic
            0
            a = temp
            b += sum.rotateLeft(s[i])
            bestScore = teamScore
            bestTeam = team.toList()
            c = b
            d = c
            element.jsonPrimitive.int
            else -> filtered
            for ((m, mScore) in remaining) {
            for (a in tier.jsonArray) {
            for (ally in allyCandidates) {
            if (!ctx.unprotected) score += m.armor * 1.5
            if ("Blast" in m.abilities && !ctx.deflectionShield) score += 3.0
            if ("Blind" in m.abilities && !ctx.aimTrue && !ctx.enemyOnlyMagic) score += 2.0
            if ("Blind" in m.abilities && !ctx.aimTrue) score += 2.0
            if ("Camouflage" in m.abilities) score += 2.0
            if ("Cleanse" in m.abilities) score += 3.0
            if ("Cleanse" in m.abilities) score += 5.0
            if ("Deathblow" in m.abilities) score += 1.5
            if ("Demoralize" in m.abilities && !ctx.enemyNoMelee) score += 3.0
            if ("Demoralize" in m.abilities) score += 3.0
            if ("Divine Shield" in m.abilities) score += 4.0
            if ("Dodge" in m.abilities && !ctx.aimTrue && !ctx.enemyOnlyMagic) score += 3.0
            if ("Dodge" in m.abilities && !ctx.aimTrue) score += 2.0
            if ("Double Strike" in m.abilities) score += 4.0
            if ("Enfeeble" in m.abilities) score += 2.0
            if ("Enrage" in m.abilities) score += 3.0
            if ("Flying" in m.abilities && !ctx.aimTrue && !ctx.enemyOnlyMagic) score += 2.0
            if ("Forcefield" in m.abilities) score += 4.0
            if ("Headwinds" in m.abilities && !ctx.enemyNoRanged) score += 3.0
            if ("Headwinds" in m.abilities) score += 3.0
            if ("Heal" in m.abilities && !ctx.healedOut) score += 10.0
            if ("Heal" in m.abilities && !ctx.healedOut) score += 4.0
            if ("Heal" in m.abilities && !ctx.healedOut) score += 5.0
            if ("Immunity" in m.abilities) score += 10.0
            if ("Immunity" in m.abilities) score += 6.0
            if ("Inspire" in m.abilities) score += 4.0
            if ("Last Stand" in m.abilities) score += 2.0
            if ("Magic Reflect" in m.abilities && !ctx.deflectionShield && !ctx.enemyNoMagic) score += if (ctx.amplify) 3.0 else 1.5
            if ("Magic Reflect" in m.abilities && !ctx.deflectionShield) score += 3.0
            if ("Magic Reflect" in m.abilities && !ctx.enemyNoMagic) {
            if ("Martyr" in m.abilities && !ctx.deathHasNoPower) score += 3.0
            if ("Opportunity" in m.abilities && !ctx.fogOfWar && !ctx.nowYouSeeMe) score += 2.0
            if ("Phase" in m.abilities) score += 2.0
            if ("Piercing" in m.abilities) score += 1.5
            if ("Poison" in m.abilities) score += 2.0
            if ("Protect" in m.abilities && !ctx.unprotected) score += 5.0
            if ("Rebirth" in m.abilities && !ctx.deathHasNoPower && !ctx.bornAgain) score += 3.0
            if ("Rebirth" in m.abilities && !ctx.deathHasNoPower && !ctx.bornAgain) score += 4.0
            if ("Recharge" in m.abilities) score += 1.0
            if ("Redemption" in m.abilities && !ctx.deathHasNoPower && !ctx.deflectionShield) score += 1.5
            if ("Repair" in m.abilities && !ctx.unprotected) score += 5.0
            if ("Resurrect" in m.abilities && !ctx.deathHasNoPower) score += 5.0
            if ("Retaliate" in m.abilities && !ctx.enemyNoMelee) score += 2.0
            if ("Return Fire" in m.abilities && !ctx.deflectionShield && !ctx.enemyNoRanged) score += if (ctx.amplify) 3.0 else 1.5
            if ("Return Fire" in m.abilities && !ctx.deflectionShield) score += 3.0
            if ("Rust" in m.abilities && !ctx.unprotected) score += 2.0
            if ("Shades of Gray" in rulesets) {
            if ("Shield" in m.abilities && !ctx.enemyOnlyMagic) score += 8.0
            if ("Shield" in m.abilities) score += 2.0
            if ("Shield" in m.abilities) score += 3.0
            if ("Silence" in m.abilities && !ctx.enemyNoMagic) score += 3.0
            if ("Silence" in m.abilities) score += 3.0
            if ("Slow" in m.abilities) score += if (ctx.reverseSpeed) -2.0 else 2.0
            if ("Sneak" in m.abilities && !ctx.fogOfWar && !ctx.nowYouSeeMe) score += 2.0
            if ("Snipe" in m.abilities && !ctx.fogOfWar && !ctx.nowYouSeeMe) score += 2.0
            if ("Strengthen" in m.abilities) score += 3.0
            if ("Stun" in m.abilities) score += if (ctx.heavyHitters) 8.0 else 2.0
            if ("Swiftness" in m.abilities) score += if (ctx.reverseSpeed) -2.0 else 2.0
            if ("Taking Sides" in rulesets) validColors.remove("Gray")
            if ("Tank Heal" in m.abilities && !ctx.healedOut) score += 10.0
            if ("Taunt" in m.abilities) {
            if ("Thorns" in m.abilities && !ctx.deflectionShield) score += 4.0
            if ("Thorns" in m.abilities && !ctx.enemyNoMelee) {
            if ("Trample" in m.abilities) score += if (ctx.stampede) 4.0 else 1.0
            if ("Triage" in m.abilities && !ctx.healedOut) score += 6.0
            if ("Void Armor" in m.abilities && !ctx.enemyNoMagic) score += 3.0
            if ("Void Armor" in m.abilities) score += 2.0
            if ("Void" in m.abilities && !ctx.enemyNoMagic) score += 6.0
            if ("Void" in m.abilities) score += 4.0
            if ("Weaken" in m.abilities) score += 2.0
            if ("Weapons Training" in m.abilities) score += 4.0
            if (arr.isEmpty()) {
            if (c != null && c != "Gray" && c != "Gold") c else null
            if (fixed.size >= maxMonsters) break
            if (gladCount < gladLimit) {
            if (m.color !in validColors) {
            if (m.mana <= remaining) {
            if (monster.detailId in usedIds) continue
            if (monster.isGladiator && gladCount >= gladLimit) continue
            if (monster.isGladiator) gladCount++
            if (monster.mana > manaLeft) continue
            if (name != null) abilities.add(name)
            if (tankiest != null) {
            if (team.isEmpty()) continue
            if (team.size >= maxMonsters) break
            if (totalScore > bestTotalScore) {
            if (used + mMana <= manaCap) {
            issues.add("dragon mixed ally colors: $unique — pick ONE ally color")
            manaLeft -= monster.mana
            return null
            score += m.health * 1.0
            score += s.buffs.armor * -2.0 // enemy loses armor
            score += s.buffs.armor * 2.0
            score += when (ability) {
            score -= m.attackPower * 2.0
            team.add(monster)
            teamScore += monsterScore
            true
            try {
            usedIds.add(monster.detailId)
            val (team, teamScore) = buildScoredTeam(colorPool, remaining, maxMonsters, gladLimit, ctx)
            val allyCandidates = COLOR_TO_SPLINTER.keys.filter {
            val arr = element.jsonArray
            val backline = team.subList(1, team.size)
            val c = monsterLookup[uid]?.color
            val colorPool = dedupMonsters.filter { it.color in validColors }
            val extracted = text.substring(start, end)
            val f: Int
            val g: Int
            val m = monsterLookup[uid] ?: continue
            val mMana = monsterLookup[uid]?.mana ?: 0
            val name = try {
            val offset = block * 64 + i * 4
            val remaining = monsters
            val sum = a + f + k[i] + m[g]
            val sumScore = scoreSummoner(summoner, colorPool, ctx)
            val tankiest = backline.maxByOrNull { scoreMonster(it, Position.TANK, ctx) }
            val temp = d
            val totalScore = sumScore + teamScore
            val validColors = mutableSetOf(summoner.color, "Gray")
            when {
            }
            } catch (_: Exception) {
            } else {
        !ctx.enemyNoMagic &&
        !ctx.enemyNoMelee &&
        (t * 4294967296.0).toLong().toInt()
        )
        .filter { it.mana <= remainingMana }
        .map { it to scoreMonster(it, Position.TANK, ctx) }
        .replace("{game_rules}", GAME_RULES_TEXT)
        .replace("{mana_cap}", manaCap.toString())
        .replace("{max_monsters}", maxMonsters.toString())
        .replace("{rulesets_desc}", rulesetsDesc)
        .sortedByDescending { it.second }
        // Back to Basics: only raw stat bonuses for tank
        // Counter enemy magic emphasis
        // Counter enemy melee emphasis
        // Counter enemy ranged emphasis
        // Disruptive abilities (counter any enemy strategy)
        // Predict enemy attack type emphasis
        // Score backline candidates by score-per-mana for efficient filling
        // Second pass: fill remaining slots by absolute score (not per-mana)
        // Super Sneak: move second-tankiest monster to last position
        4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
        5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
        6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21,
        7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
        COLOR_TO_SPLINTER[v]?.let { colors.add(it) }
        SPLINTER_COLORS[v]?.let { colors.add(it) }
        a0 += a
        abilities = abilities,
        abilities = getAbilities(stats, level),
        append("""{"summoner": <S number>, "monsters": [<M number>, ...], "mana_total": <number>}""")
        appendLine("MONSTERS (${filteredMonsters.size} available):")
        appendLine("Mana cap: $manaCap")
        appendLine("Max monsters: $maxMonsters")
        appendLine("Pick a strong team NOW. Do NOT list or analyze every card. Just output JSON immediately.")
        appendLine("SUMMONERS (${summoners.size} available):")
        appendLine()
        armor = atLevel(stats["armor"], level),
        armor = safeInt(stats, "armor"),
        attack = safeInt(stats, "attack"),
        attackPower = getAttackPower(stats, level),
        attackType = getAttackType(stats, level),
        b0 += b
        buffs = getSummonerBuffs(stats),
        c0 += c
        color = color,
        colors.add(v)
        d0 += d
        detailById[id] = obj
        detailId = card["card_detail_id"]!!.jsonPrimitive.int,
        digest[i + 12] = ((d0 ushr (i * 8)) and 0xFF).toByte()
        digest[i + 4] = ((b0 ushr (i * 8)) and 0xFF).toByte()
        digest[i + 8] = ((c0 ushr (i * 8)) and 0xFF).toByte()
        digest[i] = ((a0 ushr (i * 8)) and 0xFF).toByte()
        element is JsonArray -> {
        else -> try {
        filtered = when (ruleset) {
        filteredMonsters = filteredMonsters.filter { !it.isGladiator }
        fixed = fixed.take(maxMonsters).toMutableList()
        fixed = trimmed
        for ((monster, monsterScore) in backlineCandidates) {
        for (a in abList.jsonArray) {
        for (ability in s.buffs.abilities) {
        for (i in 0..63) {
        for (m in candidates) {
        for (uid in fixed) {
        for (uid in monsterUids) {
        health = atLevel(stats["health"], level),
        health = safeInt(stats, "health"),
        idMap[1000 + mid] = m.uid
        idMap[sid] = s.uid
        if (!ctx.backToBasics && "Flying" in m.abilities) score += 8.0 else score -= 6.0
        if (!ctx.backToBasics && "Reflection Shield" in m.abilities) score += 5.0
        if (!ctx.backToBasics && "True Strike" in m.abilities) score += 4.0
        if (!ctx.backToBasics) {
        if ("Affliction" in m.abilities && !ctx.healedOut) score += 3.0
        if ("Blast" in m.abilities && !ctx.deflectionShield) score += 2.0
        if ("Cripple" in m.abilities) score += 1.5
        if ("Dispel" in m.abilities) score += if (ctx.bloodMoon) 5.0 else 2.0
        if ("Double Strike" in m.abilities) score += 4.0
        if ("Enfeeble" in m.abilities && !ctx.enemyNoMelee && !enemyHeavyMelee) score += 1.0
        if ("Giant Killer" in m.abilities) score += 2.0
        if ("Halving" in m.abilities) score += 3.0
        if ("Impede" in m.abilities && !ctx.reverseSpeed) score += 1.5
        if ("Life Leech" in m.abilities && !ctx.healedOut) score += 2.0
        if ("Oppress" in m.abilities) score += 1.0
        if ("Scavenger" in m.abilities) score += 1.5
        if ("Shatter" in m.abilities && !ctx.unprotected) score += if (ctx.armoredUp) 4.0 else 2.0
        if (areYouNotEntertained) gladLimit++
        if (buffStrs.isNotEmpty()) parts.add(buffStrs.joinToString(", "))
        if (c != "Gray") colorCounts[c] = (colorCounts[c] ?: 0) + 1
        if (color in inactiveColors || splinter in inactiveColors) continue
        if (ctx.frostbite) score -= 8.0
        if (ctx.superSneak && team.size >= 3) {
        if (enemyHeavyMagic) {
        if (enemyHeavyMelee) {
        if (enemyHeavyRanged) {
        if (hint != null) "- $r: $hint" else "- $r"
        if (isSummoner && ruleset in MONSTER_ONLY_RULESETS) continue
        if (m.abilities.isNotEmpty()) "$line | ${m.abilities.joinToString(", ")}" else line
        if (m.attackType == "magic") score += 3.0
        if (m.attackType == "melee" || m.attackType == "ranged") score -= 4.0
        if (m.attackType == "ranged" || m.attackType == "magic") score += m.health * 0.5
        if (m.health <= 3 && pos == Position.BACKLINE) score -= 4.0
        if (m.isGladiator) {
        if (m.mana <= 4 && m.attackPower >= 2) score += 4.0
        if (pos == Position.BACKLINE && !ctx.meleeFromAnyPosition && !hasPositional) {
        if (pos == Position.BACKLINE) {
        if (pos == Position.TANK && !ctx.rangedFromPos1 && !hasCloseRange) {
        if (pos == Position.TANK) {
        if (remaining <= 0) continue
        if (s.buffs.abilities.isNotEmpty()) parts.add(s.buffs.abilities.joinToString(", "))
        if (s.buffs.armor != 0) buffStrs.add("${if (s.buffs.armor > 0) "+" else ""}${s.buffs.armor} armor")
        if (s.buffs.armor > 0) {
        if (s.buffs.attack != 0) buffStrs.add("${if (s.buffs.attack > 0) "+" else ""}${s.buffs.attack} attack")
        if (s.buffs.attack > 0) score -= s.buffs.attack * 1.5 * meleeRatio
        if (s.buffs.health != 0) buffStrs.add("${if (s.buffs.health > 0) "+" else ""}${s.buffs.health} health")
        if (s.buffs.magic != 0) buffStrs.add("${if (s.buffs.magic > 0) "+" else ""}${s.buffs.magic} magic")
        if (s.buffs.magic > 0) score += s.buffs.magic * 1.5 * magicRatio
        if (s.buffs.ranged != 0) buffStrs.add("${if (s.buffs.ranged > 0) "+" else ""}${s.buffs.ranged} ranged")
        if (s.buffs.ranged > 0) score -= s.buffs.ranged * 1.5 * rangedRatio
        if (s.buffs.speed != 0) buffStrs.add("${if (s.buffs.speed > 0) "+" else ""}${s.buffs.speed} speed")
        if (start >= 0 && end > start) {
        if (summoner.color == "Gold") {
        if (team.isNotEmpty() && teamScore > bestScore) {
        if (team.size < maxMonsters && manaLeft > 0) {
        if (tier is JsonArray) {
        if (unique.size > 1) {
        isGladiator = card["edition"]?.jsonPrimitive?.int == 6,
        issues.add("duplicate monsters")
        issues.add("invalid summoner")
        issues.add("mana exceeded: $totalMana > $manaCap")
        issues.add("too many gladiators: $gladCount, max $gladLimit (summoner ${if (hasConscript) "has" else "does NOT have"} Conscript)")
        issues.add("too many monsters: ${monsterUids.size} > $maxMonsters")
        kotlinx.serialization.json.Json.parseToJsonElement(jsonStr).jsonObject
        kotlinx.serialization.json.Json.parseToJsonElement(text)
        magic = safeInt(stats, "magic"),
        mana = atLevel(stats["mana"], level),
        monsterLines.forEach { appendLine(it) }
        monsters, rulesets, false,
        name = detail["name"]?.jsonPrimitive?.content ?: "?",
        paddedMessage[totalLen - 8 + i] = ((bitsLen ushr (i * 8)) and 0xFF).toByte()
        parts.joinToString(" | ") + conscriptTag
        ranged = safeInt(stats, "ranged"),
        rarity = RARITY_INT_TO_NAME[rarityInt] ?: "Common",
        repeat(length) { append(chars.random()) }
        return idMap[offset + num]
        return issues
        return null
        score += (10 - m.speed).coerceAtLeast(0) * 0.5
        score += 2.0
        score += m.attackPower * 0.5
        score += m.attackPower * 1.0
        score += m.attackPower * 2.0
        score += m.health * 0.5
        score += m.health * 1.0
        score += m.speed * 0.5
        score += s.buffs.health * -2.0
        score += s.buffs.health * 2.0
        score += s.buffs.speed * if (ctx.reverseSpeed) -1.0 else 1.0
        score += s.buffs.speed * if (ctx.reverseSpeed) 1.0 else -1.0
        score -= m.health * 0.3
        score -= m.health * 1.5
        score -= m.speed * 0.5
        score -= m.speed * 1.0
        speed = atLevel(stats["speed"], level),
        speed = safeInt(stats, "speed"),
        splinter = COLOR_TO_SPLINTER[color] ?: color,
        summonerLines.forEach { appendLine(it) }
        summoners, rulesets, true,
        text
        text = text.substringAfter("\n").substringBeforeLast("```").trim()
        uid = card["uid"]!!.jsonPrimitive.content,
        val (tank, tankScore) = tankCandidates[i]
        val allyColor = determineDragonAllyColor(summonerColor, fixed, monsterLookup)
        val backlineCandidates = monsters
        val buffStrs = mutableListOf<String>()
        val c = monsterLookup[uid]?.color ?: continue
        val candidates = allMonsters
        val card = cardEl.jsonObject
        val cardType = detail["type"]?.jsonPrimitive?.content ?: continue
        val cleaned = raw.trim().uppercase().removePrefix(prefix)
        val color = detail["color"]?.jsonPrimitive?.content ?: continue
        val conscriptTag = if ("Conscript" in s.buffs.abilities) " [CONSCRIPT]" else ""
        val detail = detailById[detailId] ?: continue
        val detailId = card["card_detail_id"]?.jsonPrimitive?.int ?: continue
        val end = text.lastIndexOf("}") + 1
        val enemyHeavyMagic = ctx.enemyOnlyMagic || (
        val enemyHeavyMelee = ctx.enemyOnlyMelee || (
        val enemyHeavyRanged = ctx.enemyOnlyRanged || (!ctx.enemyNoRanged && ctx.rangedFromPos1)
        val gladTag = if (m.isGladiator) " [GLAD]" else ""
        val gladUsedByTank = if (tank.isGladiator) 1 else 0
        val hasCloseRange = !ctx.backToBasics && "Close Range" in m.abilities
        val hasPositional = !ctx.backToBasics && (
        val hint = RULESET_STRATEGY_HINTS[r]
        val id = obj["id"]?.jsonPrimitive?.int ?: continue
        val line = "M$mid: ${m.name} | ${m.splinter} | ${m.attackType} | ${m.mana}m | ${m.attackPower}atk ${m.speed}spd ${m.armor}arm ${m.health}hp$gladTag"
        val m = IntArray(16) { i ->
        val m = monsterLookup[uid] ?: return@filter true
        val manaAfterTank = remainingMana - tank.mana
        val mid = i + 1
        val nonNeutral = monsterUids.mapNotNull { uid ->
        val num = cleaned.toIntOrNull() ?: return null
        val obj = cd.jsonObject
        val parts = mutableListOf("S$sid: ${s.name}", s.splinter, "${s.mana}m")
        val remaining = manaCap - summoner.mana
        val sid = i + 1
        val splinter = COLOR_TO_SPLINTER[color] ?: color
        val start = text.indexOf("{")
        val t = kotlin.math.abs(kotlin.math.sin((i + 1).toDouble()))
        val team = mutableListOf(tank)
        val tier = abilitiesList.jsonArray[i]
        val trimmed = mutableListOf<String>()
        val unique = nonNeutral.toSet()
        val usedIds = mutableSetOf(tank.detailId)
        val validColors = if (unique.size == 1) setOf(unique.first(), "Gray", "Gold") else setOf("Gray", "Gold")
        val validColors = setOf(summonerColor, "Gray")
        validColors = if (allyColor != null) setOf(allyColor, "Gray", "Gold") else setOf("Gray", "Gold")
        validColors = setOf(summonerColor, "Gray")
        var a = a0
        var b = b0
        var c = c0
        var d = d0
        var gladCount = gladUsedByTank
        var gladLimit = if ("Conscript" in summoner.buffs.abilities) 1 else 0
        var manaLeft = manaAfterTank
        var teamScore = tankScore
        var used = summonerEntry.mana
        when (cardType) {
        { it.color }, { it.rarity }, { it.attackType }, { it.attackPower },
        { it.mana }, { it.speed }, { it.armor }, { it.health },
        }
        } catch (_: Exception) {
        } else if (s.buffs.armor < 0) {
        } else {
    "Aim True" to "Attacks never miss - speed for dodge is useless",
    "Armored Up" to "All +2 armor - magic bypasses armor, prefer magic",
    "Back to Basics" to "All abilities removed - raw stats matter most",
    "Blood Moon" to "Bloodlust on all - each kill buffs the killer",
    "Born Again" to "All resurrect once at 1 HP - every unit gets second life",
    "Briar Patch" to "Thorns return 2 melee damage - avoid melee if possible",
    "Close Range" to "Ranged attacks from pos 1 - ranged monsters can tank",
    "Counterspell" to "Magic Reflect on all - avoid magic if possible",
    "Earthquake" to "Non-flying take 2 dmg/round - prefer flying monsters",
    "Equal Opportunity" to "All units target lowest HP - avoid low-HP glass cannons",
    "Equalizer" to "All HP = highest base HP - pick low-mana, high-attack monsters",
    "Explosive Weaponry" to "All units have Blast (splash) - spread HP, avoid clustering",
    "Fire & Regret" to "Return Fire on all - avoid ranged if possible",
    "Fog of War" to "No Sneak/Snipe/Opportunity - only pos 1 targeted",
    "Healed Out" to "No healing - raw HP/armor is king",
    "Holy Protection" to "All have Divine Shield - multi-hit is better",
    "Keep Your Distance", "Broken Arrows", "Lost Magic",
    "Maneuvers" to "All have Reach - melee from position 2 works",
    "Melee Mayhem" to "All melee attack from any position - load up on melee",
    "Might Makes Right", "Shades of Gray",
    "Need for Speed", "Heavy Metal", "Beefcakes",
    "Noxious Fumes" to "All units poisoned - high HP matters most",
    "Reverse Speed" to "Slowest attacks first - pick slow heavy hitters",
    "Stampede" to "Trample chains - big melee can chain kills",
    "Super Sneak" to "All melee have Sneak (hit last position) - protect backline",
    "Target Practice" to "All ranged/magic have Snipe - protect non-melee backline",
    "Unprotected" to "All armor is 0 - armor-based monsters weaker",
    "Up Close & Personal", "Going the Distance", "Wands Out",
    "Weak Magic" to "Magic hits armor first - prefer physical damage",
    "What Doesn't Kill You" to "All Enrage when damaged - high base stats amplify",
    )
    //   Negative values (e.g., attack=-1) debuff ENEMY team's attack type
    //   Positive values (e.g., attack=+1) buff YOUR team's attack type
    // Aim True: evasion worthless
    // Arcane Dampening (Void on all): magic halved
    // Armored Up: magic bypasses the +2 armor
    // Attack type positioning
    // Auto-fill empty slots
    // Backlash: True Strike valuable, speed helps avoid self-damage
    // Blood Moon: kills buff the killer
    // Born Again: low HP less punished (everyone resurrects)
    // Both players face the same rulesets, so we can predict what the enemy is likely to play
    // Brute Force: highest attack goes first
    // Buff value depends on your pool; debuff value depends on whether enemy uses that type
    // Collateral Damage: self-damage, HP matters
    // Color check
    // Combat modifiers
    // Damage type avoidance (reflect rulesets)
    // Damage type bonuses
    // Damage type penalties (reflect rulesets)
    // Death/resurrection
    // Deduplicate
    // Deduplicate by detailId
    // Defensive buffs (positive = helps us, negative = hurts enemy)
    // Determine ally color for Dragon
    // Dragon Breath: ranged/magic inflict Burning
    // Dragon summoner present — every monster is playable
    // Duplicate check
    // Earthquake
    // Efficiency check
    // Enemy composition (both players face same card restrictions)
    // Enemy counter bonuses for summoner debuffs based on predicted enemy meta
    // Equal Opportunity: low HP is dangerous
    // Equalizer
    // Explosive Weaponry: spread damage, Reflection Shield valuable
    // Filter out unplayable monsters
    // Fix colors
    // Fix gladiators — max 1 with Conscript, 0 otherwise
    // Gladiator check — max 1, only with Conscript summoner
    // Gladiator handling — keep gladiators only if some summoner has Conscript or Are You Not Entertained
    // Global Warming
    // Hey Jealousy: high HP attracts fire (non-tanks)
    // Holy Protection: multi-hit to pop Divine Shield
    // KMP MD5 implementation
    // Negative buffs (enemy debuffs): weighted by whether enemy can use that type
    // Noxious Fumes
    // Other
    // Positive buffs: weighted by OUR pool composition
    // Prefer cheaper summoners
    // Reverse Speed
    // Ruleset interactions
    // Score each summoner + team combination, pick the best
    // Stampede: melee with Trample
    // Stat/survival shifts
    // Summoner abilities
    // Summoner buffs have dual meaning:
    // Target Practice: backline ranged/magic get targeted
    // Targeting changes
    // Thick Skinned (Shield on all): halves melee/ranged, prefer magic
    // Tis But Scratches: Cripple on all, high attack = faster HP reduction
    // Trim mana
    // Trim to max_monsters
    // Weak Magic: magic hits armor first
    // What Doesn't Kill You: Enrage on all melee
    // and boost abilities that specifically counter those strategies.
    // ── Attack type positioning ──
    // ── Base stats ──
    // ── Counter-scoring: anticipate enemy strategies ──
    // ── Position-specific ability bonuses (gated by backToBasics) ──
    // ── Ruleset modifiers (applied to both positions) ──
    0
    aimTrue = "Aim True" in rulesets,
    aimless = "Aimless" in rulesets,
    allMonsters: List<CardEntry>,
    amplify = "Amplify" in rulesets,
    arcaneDampening = "Arcane Dampening" in rulesets,
    areYouNotEntertained = "Are You Not Entertained" in rulesets,
    armor: (T) -> Int,
    armoredUp = "Armored Up" in rulesets,
    atLevel(stats["attack"], level) > 0 -> "melee"
    atLevel(stats["attack"], level),
    atLevel(stats["magic"], level) > 0 -> "magic"
    atLevel(stats["magic"], level),
    atLevel(stats["ranged"], level) > 0 -> "ranged"
    atLevel(stats["ranged"], level),
    attackPower: (T) -> Int,
    attackType: (T) -> String,
    availableMonsters: List<CardEntry>,
    avoidMagic = "Counterspell" in rulesets,
    avoidMelee = "Briar Patch" in rulesets,
    avoidRanged = "Fire & Regret" in rulesets,
    backToBasics = "Back to Basics" in rulesets,
    backlash = "Backlash" in rulesets,
    bloodMoon = "Blood Moon" in rulesets,
    bornAgain = "Born Again" in rulesets,
    bruteForce = "Brute Force" in rulesets,
    cardDetails: JsonArray,
    cards: JsonArray,
    collateralDamage = "Collateral Damage" in rulesets,
    color: (T) -> String,
    ctx: RulesetContext,
    deathHasNoPower = "Death Has No Power" in rulesets,
    deflectionShield = "Deflection Shield" in rulesets,
    dragonBreath = "Dragon Breath" in rulesets,
    earthquake = "Earthquake" in rulesets,
    else -> "none"
    enemyNoMagic = "Lost Magic" in rulesets,
    enemyNoMelee = "Keep Your Distance" in rulesets,
    enemyNoRanged = "Broken Arrows" in rulesets,
    enemyOnlyMagic = "Wands Out" in rulesets,
    enemyOnlyMelee = "Up Close & Personal" in rulesets,
    enemyOnlyRanged = "Going the Distance" in rulesets,
    entries: List<T>,
    equalOpportunity = "Equal Opportunity" in rulesets,
    equalizer = "Equalizer" in rulesets,
    explosiveWeaponry = "Explosive Weaponry" in rulesets,
    ferocity = "Ferocity" in rulesets,
    fixed = fixed.filter { monsterLookup[it]?.color in validColors }.toMutableList()
    fixed = fixed.filter { uid ->
    fogOfWar = "Fog of War" in rulesets,
    for (block in 0 until numBlocks) {
    for (cardEl in cards) {
    for (cd in cardDetails) {
    for (i in 0 until minOf(level, abilitiesList.jsonArray.size)) {
    for (i in 0 until tankTrials) {
    for (i in 0..3) {
    for (i in 0..7) {
    for (ruleset in rulesets) {
    for (summoner in dedupSummoners) {
    for (uid in monsterUids) {
    for (v in raw) {
    frostbite = "Frostbite" in rulesets,
    fun resolveId(raw: String, prefix: String, offset: Int): String? {
    gladLimit: Int,
    globalWarming = "Global Warming" in rulesets,
    healedOut = "Healed Out" in rulesets,
    health: (T) -> Int,
    heavyHitters = "Heavy Hitters" in rulesets,
    heyJealousy = "Hey Jealousy" in rulesets,
    holyProtection = "Holy Protection" in rulesets,
    if (!ctx.backToBasics) {
    if (!ctx.unprotected) score += m.armor * 1.0
    if (!ctx.unprotected) {
    if (!hasConscript && !areYouNotEntertained) {
    if ("Four's a Crowd" in rulesets || "FabFour" in rulesets) limit = minOf(limit, 4)
    if ("Gold" in summonerColors) return monsters
    if ("High Five" in rulesets || "FiveAlive" in rulesets) limit = minOf(limit, 5)
    if (abList is JsonArray) {
    if (abilitiesList !is JsonArray) return emptyList()
    if (ctx.aimTrue) {
    if (ctx.arcaneDampening && m.attackType == "magic") score -= 4.0
    if (ctx.arcaneDampening && s.buffs.magic > 0) score -= s.buffs.magic * 1.5 * magicRatio
    if (ctx.armoredUp && !ctx.weakMagic && s.buffs.magic > 0) score += s.buffs.magic * 1.5 * magicRatio
    if (ctx.armoredUp && m.attackType == "magic" && !ctx.weakMagic) score += 3.0
    if (ctx.avoidMagic && !ctx.deflectionShield && s.buffs.magic > 0) score -= s.buffs.magic * 2.0 * magicRatio
    if (ctx.avoidMagic && m.attackType == "magic" && !ctx.deflectionShield) score -= 5.0
    if (ctx.avoidMelee && !ctx.deflectionShield && s.buffs.attack > 0) score -= s.buffs.attack * 2.0 * meleeRatio
    if (ctx.avoidMelee && m.attackType == "melee" && !ctx.deflectionShield) score -= 5.0
    if (ctx.avoidRanged && !ctx.deflectionShield && s.buffs.ranged > 0) score -= s.buffs.ranged * 2.0 * rangedRatio
    if (ctx.avoidRanged && m.attackType == "ranged" && !ctx.deflectionShield) score -= 5.0
    if (ctx.backlash) {
    if (ctx.bloodMoon) {
    if (ctx.bornAgain && m.health <= 3) {
    if (ctx.bruteForce) {
    if (ctx.collateralDamage) {
    if (ctx.dragonBreath && (m.attackType == "ranged" || m.attackType == "magic")) {
    if (ctx.earthquake) {
    if (ctx.equalOpportunity) {
    if (ctx.equalizer) {
    if (ctx.explosiveWeaponry) {
    if (ctx.globalWarming) {
    if (ctx.heyJealousy && pos == Position.BACKLINE) {
    if (ctx.holyProtection && !ctx.backToBasics) {
    if (ctx.noxiousFumes) {
    if (ctx.preferMagic) {
    if (ctx.reverseSpeed) {
    if (ctx.silencedSummoners) return -s.mana.toDouble()
    if (ctx.stampede && !ctx.backToBasics && "Trample" in m.abilities && m.attackType == "melee") score += 4.0
    if (ctx.targetPractice && pos == Position.BACKLINE) {
    if (ctx.tisButScratches) {
    if (ctx.weakMagic && m.attackType == "magic") score -= 3.0
    if (ctx.whatDoesntKillYou && m.attackType == "melee") score += 4.0
    if (ctx.whatDoesntKillYou && s.buffs.attack > 0) score += s.buffs.attack * 1.5 * meleeRatio
    if (element == null) return 0
    if (enemyHeavyMagic && s.buffs.magic < 0) score += s.buffs.magic * -2.0
    if (enemyHeavyMelee && s.buffs.attack < 0) score += s.buffs.attack * -2.0
    if (enemyHeavyRanged && s.buffs.ranged < 0) score += s.buffs.ranged * -2.0
    if (filteredSummoners.isEmpty()) return null
    if (fixed.isEmpty()) return null
    if (fixed.size > maxMonsters) {
    if (gladCount > gladLimit) {
    if (m.attackType == "melee") {
    if (m.attackType == "none") {
    if (m.attackType == "ranged") {
    if (manaCap > 0 && finalMana.toDouble() / manaCap < 0.7) return null
    if (monsterUids.isEmpty()) return null
    if (monsterUids.size != monsterUids.toSet().size) {
    if (monsterUids.size > maxMonsters) {
    if (monsters.isEmpty()) return emptyList<CardEntry>() to 0.0
    if (remaining > 0 && fixed.size < maxMonsters) {
    if (rulesetStr.isBlank()) return emptySet()
    if (s.buffs.attack < 0 && !ctx.enemyNoMelee) score += s.buffs.attack * -3.0
    if (s.buffs.attack > 0) score += s.buffs.attack * 3.0 * meleeRatio
    if (s.buffs.health > 0) {
    if (s.buffs.magic < 0 && !ctx.enemyNoMagic) score += s.buffs.magic * -3.0
    if (s.buffs.magic > 0) score += s.buffs.magic * 3.0 * magicRatio
    if (s.buffs.ranged < 0 && !ctx.enemyNoRanged) score += s.buffs.ranged * -3.0
    if (s.buffs.ranged > 0) score += s.buffs.ranged * 3.0 * rangedRatio
    if (s.buffs.speed > 0) {
    if (summonerColor != "Gold") return null
    if (summonerColor == "Gold") {
    if (summonerEntry == null) {
    if (text.startsWith("```")) {
    if (totalMana > manaCap) {
    isSummoner: Boolean,
    mana: (T) -> Int,
    manaCap: Int,
    matchInfo: JsonObject,
    maxMonsters: Int,
    meleeFromAnyPosition = "Melee Mayhem" in rulesets || "Super Sneak" in rulesets || "Hey Jealousy" in rulesets,
    message.copyInto(paddedMessage)
    monsterUids: List<String>,
    monsters: List<CardEntry>,
    noPainNoGain = "No Pain No Gain" in rulesets,
    nowYouSeeMe = "Now You See Me" in rulesets,
    noxiousFumes = "Noxious Fumes" in rulesets,
    paddedMessage[originalLen] = 0x80.toByte()
    preferMagic = "Thick Skinned" in rulesets,
    rangedFromPos1 = "Close Range" in rulesets,
    rarity: (T) -> String,
    remainingMana: Int,
    return CardEntry(
    return LlmPick(summonerUid, monsterUids)
    return LlmPromptResult(system, userMsg, idMap)
    return SummonerBuffs(
    return SummonerEntry(
    return TeamSelection(summonerUid, fixed, allyColor)
    return bestResult
    return bestTeam to bestScore
    return buildString {
    return colorCounts.maxByOrNull { it.value }?.key
    return colors
    return digest
    return filtered
    return issues
    return limit
    return md5(bytes).joinToString("") { (it.toInt() and 0xFF).toString(16).padStart(2, '0') }
    return md5Hex(payload)
    return monsters.filter { it.color in playable }
    return result
    return rulesetStr.split("|").map { it.trim() }.filter { it.isNotBlank() }.toSet()
    return score
    return when {
    reverseSpeed = "Reverse Speed" in rulesets,
    rulesets: Set<String>,
    s: SummonerEntry,
    score += m.attackPower * 2.0
    score += m.health * 1.5
    score += m.speed * 0.5
    score -= s.mana * 0.3
    silencedSummoners = "Silenced Summoners" in rulesets,
    speed: (T) -> Int,
    stampede = "Stampede" in rulesets,
    stats[key]?.jsonPrimitive?.int ?: 0
    summonerUid: String,
    summoners: List<SummonerEntry>,
    superSneak = "Super Sneak" in rulesets,
    targetPractice = "Target Practice" in rulesets,
    tisButScratches = "Tis But Scratches" in rulesets,
    unprotected = "Unprotected" in rulesets,
    val abList = stats["abilities"]
    val abilities = mutableListOf<String>()
    val abilitiesList = stats["abilities"] ?: return emptyList()
    val aimTrue: Boolean,
    val aimless: Boolean,
    val allyColor = determineDragonAllyColor(summonerColor, fixed, monsterLookup)
    val amplify: Boolean,
    val arcaneDampening: Boolean,
    val areYouNotEntertained = "Are You Not Entertained" in rulesets
    val areYouNotEntertained: Boolean,
    val armoredUp: Boolean,
    val avoidMagic: Boolean,
    val avoidMelee: Boolean,
    val avoidRanged: Boolean,
    val backToBasics: Boolean,
    val backlash: Boolean,
    val bitsLen = (originalLen.toLong() * 8)
    val bloodMoon: Boolean,
    val bornAgain: Boolean,
    val bruteForce: Boolean,
    val bytes = input.encodeToByteArray()
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val collateralDamage: Boolean,
    val color = detail["color"]?.jsonPrimitive?.content ?: ""
    val colorCounts = mutableMapOf<String, Int>()
    val colors = mutableSetOf<String>()
    val ctx = buildRulesetContext(rulesets)
    val deathHasNoPower: Boolean,
    val dedupMonsters = filteredMonsters.distinctBy { it.detailId }
    val dedupSummoners = filteredSummoners.distinctBy { it.detailId }
    val deflectionShield: Boolean,
    val detailById = mutableMapOf<Int, JsonObject>()
    val digest = ByteArray(16)
    val dragonBreath: Boolean,
    val earthquake: Boolean,
    val enemyHeavyMagic = ctx.enemyOnlyMagic || (
    val enemyHeavyMelee = ctx.enemyOnlyMelee || (
    val enemyHeavyRanged = ctx.enemyOnlyRanged || (!ctx.enemyNoRanged && ctx.rangedFromPos1)
    val enemyNoMagic: Boolean,
    val enemyNoMelee: Boolean,
    val enemyNoRanged: Boolean,
    val enemyOnlyMagic: Boolean,
    val enemyOnlyMelee: Boolean,
    val enemyOnlyRanged: Boolean,
    val equalOpportunity: Boolean,
    val equalizer: Boolean,
    val explosiveWeaponry: Boolean,
    val ferocity: Boolean,
    val filteredMonsters = filterUnplayable(monsters, summoners)
    val filteredSummoners = applyRulesetFilters(
    val finalMana = summonerEntry.mana + fixed.sumOf { monsterLookup[it]?.mana ?: 0 }
    val fogOfWar: Boolean,
    val frostbite: Boolean,
    val gladCount = monsterUids.count { monsterLookup[it]?.isGladiator == true }
    val gladLimit = if (hasConscript) 1 else 0
    val globalWarming: Boolean,
    val hasConscript = "Conscript" in summonerEntry.buffs.abilities
    val hasConscript = filteredSummoners.any { "Conscript" in it.buffs.abilities }
    val healedOut: Boolean,
    val heavyHitters: Boolean,
    val heyJealousy: Boolean,
    val holyProtection: Boolean,
    val idMap = mutableMapOf<Int, String>()
    val idMap: Map<Int, String>,
    val inactiveColors = buildInactiveColors(inactiveStr)
    val inactiveStr = matchInfo["inactive"]?.jsonPrimitive?.content ?: ""
    val issues = mutableListOf<String>()
    val jsonStr = try {
    val k = IntArray(64) { i ->
    val level = card["level"]?.jsonPrimitive?.int ?: 1
    val magicRatio = availableMonsters.count { it.attackType == "magic" } / total
    val manaCap = matchInfo["mana_cap"]?.jsonPrimitive?.int ?: 20
    val maxMonsters = getMaxMonsters(rulesets)
    val meleeFromAnyPosition: Boolean,
    val meleeRatio = availableMonsters.count { it.attackType == "melee" } / total
    val monsterLines = filteredMonsters.mapIndexed { i, m ->
    val monsterLookup = allMonsters.associateBy { it.uid }
    val monsterLookup = monsters.associateBy { it.uid }
    val monsterUids = rawMonsters.mapNotNull { resolveId(it, "M", 1000) }
    val monsterUids: List<String>,
    val monsters = mutableListOf<CardEntry>()
    val noPainNoGain: Boolean,
    val nowYouSeeMe: Boolean,
    val noxiousFumes: Boolean,
    val numBlocks = ((originalLen + 8) / 64) + 1
    val originalLen = message.size
    val paddedMessage = ByteArray(totalLen)
    val payload = (listOf(summoner) + monsters + listOf(secret)).joinToString(",")
    val pick = try {
    val playable = summonerColors + "Gray"
    val preferMagic: Boolean,
    val rangedFromPos1: Boolean,
    val rangedRatio = availableMonsters.count { it.attackType == "ranged" } / total
    val rarityInt = detail["rarity"]?.jsonPrimitive?.int ?: 1
    val raw = inactiveStr.split(",").map { it.trim() }.filter { it.isNotBlank() }.toSet()
    val rawMonsters = pick["monsters"]?.jsonArray?.map { it.jsonPrimitive.content } ?: return null
    val rawSummoner = pick["summoner"]?.jsonPrimitive?.content ?: return null
    val result = mutableListOf<String>()
    val reverseSpeed: Boolean,
    val rulesetLines = rulesets.map { r ->
    val rulesets = parseRulesets(matchInfo["ruleset"]?.jsonPrimitive?.content ?: "")
    val rulesets = rulesetsStr.split("|").map { it.trim() }.filter { it.isNotBlank() }
    val rulesetsDesc = if (rulesetLines.isNotEmpty()) rulesetLines.joinToString("\n") else "- Standard (no special rules)"
    val rulesetsStr = matchInfo["ruleset"]?.jsonPrimitive?.content ?: ""
    val s = intArrayOf(
    val seen = mutableSetOf<String>()
    val silencedSummoners: Boolean,
    val stampede: Boolean,
    val stats = detail["stats"]?.jsonObject ?: JsonObject(emptyMap())
    val summonerColor = summonerEntry.color
    val summonerColors = summoners.map { it.color }.toSet()
    val summonerEntry = summoners.find { it.uid == summonerUid }
    val summonerEntry = summoners.find { it.uid == summonerUid } ?: return null
    val summonerLines = summoners.mapIndexed { i, s ->
    val summonerUid = resolveId(rawSummoner, "S", 0) ?: return null
    val summonerUid: String,
    val summoners = mutableListOf<SummonerEntry>()
    val superSneak: Boolean,
    val system = SYSTEM_PROMPT_TEMPLATE
    val systemPrompt: String,
    val tankCandidates = monsters
    val tankTrials = minOf(3, tankCandidates.size)
    val targetPractice: Boolean,
    val tisButScratches: Boolean,
    val total = availableMonsters.size.coerceAtLeast(1).toDouble()
    val totalLen = numBlocks * 64
    val totalMana = summonerEntry.mana + monsterUids.sumOf { monsterLookup[it]?.mana ?: 0 }
    val uidSet = fixed.toMutableSet()
    val unprotected: Boolean,
    val usedDetailIds = fixed.mapNotNull { monsterLookup[it]?.detailId }.toMutableSet()
    val usedMana = summonerEntry.mana + fixed.sumOf { monsterLookup[it]?.mana ?: 0 }
    val userMessage: String,
    val userMsg = buildString {
    val validColors: Set<String>
    val weakMagic: Boolean,
    val whatDoesntKillYou: Boolean,
    var a0 = 0x67452301
    var b0 = 0xEFCDAB89.toInt()
    var bestResult: TeamSelection? = null
    var bestScore = Double.NEGATIVE_INFINITY
    var bestTeam = emptyList<CardEntry>()
    var bestTotalScore = Double.NEGATIVE_INFINITY
    var c0 = 0x98BADCFE.toInt()
    var d0 = 0x10325476
    var filtered = entries
    var filteredMonsters = applyRulesetFilters(
    var fixed = monsterUids.distinct().toMutableList()
    var gladCount = 0
    var limit = 6
    var remaining = manaCap - usedMana
    var score = 0.0
    var text = responseText.trim()
    var totalMana = summonerEntry.mana + fixed.sumOf { monsterLookup[it]?.mana ?: 0 }
    weakMagic = "Weak Magic" in rulesets,
    whatDoesntKillYou = "What Doesn't Kill You" in rulesets,
    }
    } catch (_: Exception) {
    } else if (s.buffs.health < 0) {
    } else if (s.buffs.speed < 0) {
    } else {
    }.toMutableList()
   - Dragon summoners: pick ONE ally color. ALL non-Neutral monsters must be that ONE color. Dragon-type monsters are always allowed.
   - Example: Life summoner → only Life and Neutral monsters. Fire monsters are FORBIDDEN.
 * A monster is playable if it matches at least one summoner's color or is Neutral.
 * Dragon summoners can use any color, so if any Dragon summoner exists, all monsters are playable.
 * Remove monsters that can't be played with any available summoner.
 */
""".trimIndent()
)
): Double {
): List<String> {
): List<T> {
): LlmPromptResult {
): Pair<List<CardEntry>, Double> {
): TeamSelection? {
- Afflicted: cannot be healed. 50% chance to apply on hit.
- Base accuracy: 100%.
- Blind ability: +15% miss chance on all enemy melee/ranged.
- Burning: lose 2 HP. 33% chance to spread to adjacent units each round. Can be cleansed.
- Dodge ability: +25% evasion vs melee/ranged.
- Dragon summoners pick ONE secondary element; all non-Neutral monsters must be that color or Dragon.
- Each point defender's speed exceeds attacker's: -10% accuracy.
- Enraged: +50% melee attack and speed (rounded up) when damaged.
- Exhausted: skip turn and cannot Retaliate (from Weary ability).
- Fastest attacks first (reversed by Reverse Speed ruleset).
- Flying ability: +25% evasion vs melee/ranged from non-Flying attackers.
- Forcefield: takes only 1 damage from attacks with 5+ power.
- Heal: restores 1/3 of own max HP per round (rounded down).
- Magic CANNOT miss unless target has Phase (subjects magic to normal hit/miss).
- Magic ignores armor entirely (hits HP directly), unless Void Armor or Weak Magic applies.
- Magic: Attacks from ANY position. Bypasses armor and hits HP directly, UNLESS target has Void Armor or Weak Magic ruleset is active.
- Melee/Ranged hits armor first. If armor is depleted, remaining damage is lost UNLESS attacker has Piercing (excess carries to HP).
- Melee: Attacks from position 1 ONLY. Cannot attack from positions 2-6 unless the unit has Reach (pos 2), Sneak, Opportunity, Charge, or a ruleset grants one of these.
- Neutral is always available unless Taking Sides ruleset is active.
- Poisoned: lose 2 HP at start of each round. 50% chance to apply on hit.
- Ranged: Attacks from positions 2-6. CANNOT attack from position 1 unless the unit has Close Range or the Close Range ruleset is active. If pushed to pos 1 by deaths, ranged stops attacking.
- Repair: restores armor on ally with most armor damage.
- Shield ability: halves melee/ranged damage (rounded up); attacks of 1 deal 0.
- Snare: attacks vs Flying cannot miss, removes Flying.
- Stunned: skip next turn. 50% chance to apply on hit.
- Summoner determines your element. All monsters must match summoner's element or be Neutral.
- Tank Heal: restores 1/3 of position 1 ally's max HP per round (rounded up).
- These stack (Flying + Dodge = 50% base evasion).
- Tiebreakers: Magic > Ranged > Melee > No Attack, then higher rarity, then higher level, then random.
- Triage: heals most-damaged backline ally, max HP / 3 rounded down, minimum 2.
- True Strike: attacks never miss, ignores Blind.
- Void ability: halves magic damage (rounded up); attacks of 1 deal 0.
/**
// Minimal MD5 implementation for KMP (no java.security dependency in common)
// ── Card entry building ──
// ── LLM prompt building ──
// ── LLM response parsing ──
// ── Monster and summoner scoring ──
// ── Ruleset context ──
// ── Ruleset parsing and filtering ──
// ── Scored team building ──
// ── Silent fixes (last resort) ──
// ── Stat extraction ──
// ── Team hash and secret ──
// ── Team picking ──
// ── Team validation ──
1. Pick exactly 1 summoner and 1-{max_monsters} monsters, using their numeric ID.
2. Total mana (summoner + all monsters) must not exceed {mana_cap}. Use at least 70% of available mana.
3. COLOR RULE: Every monster must be the SAME color as the summoner, or Neutral (Gray).
4. GLADIATOR RULE: [GLAD] monsters are FORBIDDEN unless your chosen summoner has [CONSCRIPT]. If the summoner is [CONSCRIPT], you may include exactly 1 [GLAD] monster. If the summoner is NOT [CONSCRIPT], you MUST NOT pick any [GLAD] monster.
5. Each monster ID can only be used once (no duplicates).
=== ALL ABILITIES ===
=== ALL RULESETS ===
=== COMBAT BASICS ===
ACTIVE RULESETS FOR THIS MATCH:
ATTACK TYPES:
Affliction: hit has 50% chance to prevent target from being healed.
Aim True: all melee/ranged attacks always hit (grants True Strike).
Aimless: all monsters have Scattershot.
Ambush: acts before battle begins (during Ambush round).
Amplify: all monsters have Amplify.
Amplify: increases Magic Reflect, Return Fire, and Thorns damage by 1 to all enemies.
Apply these rulesets when picking your team — they change which abilities/attack types are effective.
Arcane Dampening: all units have Void.
Are You Not Entertained: allows one additional Gladiator card.
Armored Strike: additional melee attack equal to armor stat.
Armored Up: all monsters get +2 armor.
Back to Basics: all monsters lose all abilities. Raw stats only.
Backfire: if enemy misses this unit, attacker takes 2 damage.
Backlash: all units that miss take 2 true damage.
Blast: splash damage to monsters adjacent to target (main damage / 2, rounded up).
Blind: all enemy melee/ranged attacks have +15% miss chance.
Blood Moon: all units have Bloodlust.
Bloodlust: +1 to all stats on each kill.
Born Again: all monsters have Rebirth.
Briar Patch: all monsters have Thorns. Avoid melee.
Broken Arrows: ranged monsters cannot be used.
Brute Force: units with highest individual attack power attack first.
Camouflage: cannot be targeted unless in position 1.
Charge: can use melee attacks from any position.
Cleanse Rearguard: cleanses last allied backline unit's magic debuffs.
Cleanse: removes all negative effects from position 1 ally.
Close Range: ranged can attack from position 1 (grants Close Range).
Close Range: ranged can attack from position 1.
Collateral Damage: all units have Reckless debilitation.
Conscript: allows using one additional Gladiator card.
Corrosive Ward: when hit by melee, deals 2 armor damage to attacker and reduces attacker's max armor by 2.
Counterspell: all monsters have Magic Reflect. Avoid magic.
Cripple: each hit reduces target's max HP by 1.
DAMAGE RESOLUTION:
Death Has No Power: units gain Final Rest (on-defeat abilities don't trigger).
Deathblow: 2x damage if target is the last enemy monster.
Deflection Shield: all units have Reflection Shield (immune to Blast/Thorns/Return Fire/Magic Reflect).
Demoralize: -1 melee attack to all enemies (min 1).
Dispel: clears all positive status effects on hit target (including Bloodlust/Martyr buffs).
Divine Shield: first hit deals no damage.
Dodge: +25% evasion vs melee/ranged.
Double Strike: attacks twice per round.
Dragon Breath: all ranged/magic attacks inflict Burning on target.
ELEMENTS: Fire, Water, Earth, Life, Death, Dragon, Neutral.
Earthquake: non-Flying take 2 damage per round. Prefer Flying monsters.
Echo: Repair and all healing/cleansing abilities trigger twice per round.
Electrified: deals 1 damage to all allied units at start of each round.
Enfeeble: -1 to target's melee power after each hit.
Enrage: +50% melee attack and speed when damaged (rounded up).
Equal Opportunity: all monsters have Opportunity (target lowest HP from any position).
Equalizer: all HP equals the highest base HP on either team. Pick low-mana high-attack monsters.
Even Stevens: only even-mana monsters allowed (0 is even).
Execute: if target has 2 or less HP after hit, attacks same target again.
Explosive Weaponry: all monsters have Blast (splash damage).
Expose: 80% chance to remove Forcefield/Lookout/Reflection Shield/Shield/Void/Void Armor/Immunity on hit. Always removes Immunity first.
Ferocity: all monsters have Fury (double damage vs Taunt).
Fire & Regret: all monsters have Return Fire. Avoid ranged.
Flank: if in position 1, the unit in position 2 gains Reach.
Flying: +25% evasion vs melee/ranged from non-Flying attackers. Immune to Earthquake damage.
Fog of War: Sneak/Snipe/Opportunity removed. Only position 1 targeted.
Forcefield: takes only 1 damage from attacks with 5+ power.
Four's a Crowd: max 4 units.
Frostbite: all units have Weary. Non-attacking units take 2 true damage per round.
Fury: double damage vs targets with Taunt.
Giant Killer: double damage vs targets costing 10+ mana.
Global Warming: all units start with Burning status (2 dmg/round, can spread).
Going the Distance: only ranged monsters allowed.
HEALING:
HIT/MISS MECHANICS:
Halving: first hit halves target's attack (rounded down).
Headwinds: -1 ranged attack to all enemies.
Heal: restores 1/3 of own max HP per round (rounded down).
Healed Out: all healing removed. Raw HP/armor matters.
Heavy Hitters: all monsters have Knock Out (double damage vs stunned).
Heavy Metal: only armored units allowed.
Hey Jealousy: all units target highest HP enemy. Melee attacks from any position.
High Five: max 5 units.
Holy Protection: all monsters have Divine Shield (first hit ignored).
IMPORTANT: Do NOT analyze every card. Just pick a strong team and output the answer.
Immunity: immune to negative status effects.
Impede: -1 to target's speed after each hit.
Incendiary: at start of round 2+, applies Burning. Burning has 33% chance to spread to adjacent units, then all Burning units lose 2 HP.
Inspire: +1 melee attack to all allies.
Junior Varsity: only units costing 6 or less mana.
Keep Your Distance: melee monsters cannot be used.
Kindred Spirit: adjacent units with Kindred Will gain True Strike at battle start.
Kindred Will: adjacent units with Kindred Spirit gain Ambush at battle start.
Knock Out: double damage vs stunned targets.
Last Stand: +50% all stats when last unit alive (rounded up).
Life Leech: gains max HP equal to damage dealt to enemy HP.
Little League: only monsters/summoners costing 4 or less mana.
Lookout: adjacent units take 1 less damage from Sneak/Snipe/Opportunity attackers. Team takes half damage from Ambush.
Lost Legendaries: legendary monsters cannot be used.
Lost Magic: magic monsters cannot be used.
Magic Reflect: returns magic damage / 2 (rounded up) to attacker.
Martyr: when this unit dies, adjacent allies get +1 to all stats.
Melee Mayhem: melee can attack from any position (grants Charge).
Might Makes Right: only units with 3+ attack power.
Mimic: at round 2+, gains random enemy ability. 25% chance to gain attacker's ability when hit.
Need for Speed: only units with 3+ speed.
No Pain No Gain: all units have Painforge.
Now You See Me: all units have Camouflage.
Noxious Fumes: all monsters start Poisoned (2 dmg/round). High HP crucial.
Odd Ones Out: only odd-mana monsters allowed (0 is not odd).
Opportunity: attacks from any position, targets lowest HP enemy.
Oppress: double damage vs targets with no attack.
POSITIONS: Monsters occupy positions 1-6. Position 1 is the frontline (tank). When position 1 dies, all monsters shift forward.
Painforge: gains additional attack when damaged by poison, burning, or allied damage (Reckless/Electrified).
Phase: magic attacks can miss this unit (normal hit/miss calculation applies).
Piercing: excess melee/ranged damage beyond armor carries to HP.
Poison Burst: on death, 100% chance to poison attacker, 50% chance to poison units adjacent to attacker.
Poison: 50% chance to apply Poisoned (2 HP loss per round).
Protect: +2 armor to all allies.
Reach: melee can attack from position 2.
Rebirth: self-resurrects with 1 HP once per battle on death.
Recharge: skips a turn, then hits for 3x damage.
Redemption: on death, deals 1 melee damage to all enemies.
Reflection Shield: immune to Blast, Thorns, Return Fire, Magic Reflect damage.
Repair: restores armor on ally with most armor damage.
Respond with ONLY valid JSON — no markdown, no explanation, no analysis.
Resurrect: revives first dead ally at 1 HP (once per battle).
Retaliate: 50% chance to counter-attack melee attackers.
Return Fire: returns ranged damage / 2 (rounded up) to attacker.
Reverse Speed: slowest attacks first, highest dodge. Pick slow heavy hitters.
Rise of the Commons: only Common and Rare monsters.
Rust: -2 armor to all enemies.
SPEED & ATTACK ORDER:
SPLINTERLANDS COMPLETE GAME RULES REFERENCE
STATUS EFFECTS:
Scattershot: attacks random enemy target.
Scavenger: +1 max HP each time any monster dies.
Shades of Gray: only Neutral monsters.
Shatter: destroys all target armor on hit.
Shield Ward: unit in front gains Shield at battle start.
Shield: halves melee/ranged damage (rounded up); attacks of 1 deal 0.
Shroud of Reflection Shield: adjacent units gain Reflection Shield at battle start.
Silence: -1 magic attack to all enemies.
Silenced Summoners: summoners give no buffs/debuffs/abilities.
Slow: -1 speed to all enemies.
Snare: attacks vs Flying cannot miss, removes Flying.
Sneak: targets last enemy instead of first. If last has Camouflage, targets second-to-last.
Snipe: targets enemy ranged/magic/no-attack units not in position 1.
Soul Siphon: self-resurrects with 100% armor and 50% max HP as long as a non-Weary ally exists.
Spite: on death, 100% chance to counterattack.
Stampede: Trample can chain multiple times per attack.
Standard: no special rules.
Strengthen: +1 HP to all allies.
Stun: 50% chance to stun target (skip next turn).
Super Sneak: all melee have Sneak (hit last enemy). All melee can attack. Protect backline.
Swiftness: +1 speed to all allies.
TEAM BUILDING RULES (CRITICAL — violating these makes the team invalid):
Taking Sides: neutral monsters cannot be used.
Tank Heal: restores 1/3 of position 1 ally's max HP per round (rounded up).
Target Practice: all ranged/magic have Snipe (target backline ranged/magic).
Taunt: all enemies must target this unit.
Thick Skinned: all units have Shield.
Thorns: returns 2 melee damage to attacker.
Tis But Scratches: all units have Cripple.
Trample: on kill, attacks next enemy in line.
Triage: heals most-damaged backline ally (max HP / 3, rounded down, min 2).
True Strike: attacks never miss. Ignores Blind.
Unprotected: all armor is 0, armor abilities don't work. Magic less valuable.
Up Close & Personal: only melee monsters allowed.
Use plain integers for IDs (e.g. 13 not "S13").
Void Armor: magic hits armor before HP.
Void: halves magic damage (rounded up); attacks of 1 deal 0.
Wands Out: only magic monsters allowed.
Weak Magic: magic hits armor first (grants Void Armor).
Weaken: -1 HP to all enemies (min 1).
Weapons Training: adjacent no-attack monsters gain this unit's attack (max 3). Cannot be dispelled.
Weary: 10% chance per round (increasing by 10%/round, max 80%) to become Exhausted (skip turn, no Retaliate).
What Doesn't Kill You: all monsters have Enrage (+50% melee/speed when damaged).
Wingbreak: always targets first Flying enemy regardless of position. +2 damage vs Flying.
You are a Splinterlands battle expert. Given the match constraints and available cards, pick the best team.
data class LlmPick(
data class LlmPromptResult(
fun <T> applyRulesetFilters(
fun applyFixes(
fun buildCardEntry(card: JsonObject, detail: JsonObject): CardEntry {
fun buildLlmPrompt(
fun buildSummonerEntry(card: JsonObject, detail: JsonObject): SummonerEntry {
fun filterUnplayable(monsters: List<CardEntry>, summoners: List<SummonerEntry>): List<CardEntry> {
fun generateSecret(length: Int = 10): String {
fun generateTeamHash(summoner: String, monsters: List<String>, secret: String): String {
fun getMaxMonsters(rulesets: Set<String>): Int {
fun parseLlmPick(responseText: String, idMap: Map<Int, String>): LlmPick? {
fun parseRulesets(rulesetStr: String): Set<String> {
fun pickTeam(
fun validateTeam(
internal fun buildInactiveColors(inactiveStr: String): Set<String> {
internal fun determineDragonAllyColor(summonerColor: String?, monsterUids: List<String>, monsterLookup: Map<String, CardEntry>): String? {
package com.inspiredandroid.kai.splinterlands
private data class RulesetContext(
private enum class Position { TANK, BACKLINE }
private fun atLevel(element: kotlinx.serialization.json.JsonElement?, level: Int): Int {
private fun buildRulesetContext(rulesets: Set<String>): RulesetContext = RulesetContext(
private fun buildScoredTeam(
private fun getAbilities(stats: JsonObject, level: Int): List<String> {
private fun getAttackPower(stats: JsonObject, level: Int): Int = maxOf(
private fun getAttackType(stats: JsonObject, level: Int): String = when {
private fun getSummonerBuffs(stats: JsonObject): SummonerBuffs {
private fun md5(message: ByteArray): ByteArray {
private fun md5Hex(input: String): String {
private fun safeInt(stats: JsonObject, key: String): Int = try {
private fun scoreMonster(m: CardEntry, pos: Position, ctx: RulesetContext): Double {
private fun scoreSummoner(
private val MONSTER_ONLY_RULESETS = setOf(
private val SYSTEM_PROMPT_TEMPLATE = """
val GAME_RULES_TEXT = """
val RULESET_STRATEGY_HINTS = mapOf(
{game_rules}
{rulesets_desc}
{{"summoner": <number>, "monsters": [<number>, ...], "mana_total": <number>}}
}
} catch (_: Exception) {
