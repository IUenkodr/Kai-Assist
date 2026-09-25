import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.MemoryStore
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_promote_learning_description
import kai.composeapp.generated.resources.tool_promote_learning_name

                "$currentSoul\n\n$soulAddition"
                "hit_count" to memory.hitCount,
                "memory_key" to ParameterSchema(type = "string", description = "The key of the memory to promote", required = true),
                "message" to "Memory promoted to soul. Original memory removed.",
                "promoted_key" to memoryKey,
                "soul_addition" to ParameterSchema(type = "string", description = "The text to append to the soul/system prompt", required = true),
                "success" to true,
                ?: return mapOf("success" to false, "error" to "Memory not found: $memoryKey")
                ?: return mapOf("success" to false, "error" to "Missing memory_key")
                ?: return mapOf("success" to false, "error" to "Missing soul_addition")
                soulAddition
            )
            ),
            // Append to soul text
            // Remove the promoted memory
            appSettings.setSoulText(newSoul)
            description = "Promote a well-established memory into the soul/system prompt. Use this for patterns that have been reinforced multiple times and should become permanent behavior.",
            memoryStore.forget(memoryKey)
            name = "promote_learning",
            parameters = mapOf(
            return mapOf(
            val currentSoul = appSettings.getSoulText()
            val memories = memoryStore.getAllMemories()
            val memory = memories.find { it.key == memoryKey }
            val memoryKey = args["memory_key"]?.toString()
            val newSoul = if (currentSoul.isEmpty()) {
            val soulAddition = args["soul_addition"]?.toString()
            }
            } else {
        )
        description = "Promote a reinforced learning into the system prompt",
        descriptionRes = Res.string.tool_promote_learning_description,
        id = "promote_learning",
        name = "Promote Learning",
        nameRes = Res.string.tool_promote_learning_name,
        override suspend fun execute(args: Map<String, Any>): Any {
        override val schema = ToolSchema(
        promoteLearningTool(memoryStore, appSettings),
        userToggleable = false,
        }
    )
    fun getHeartbeatTools(memoryStore: MemoryStore, appSettings: AppSettings): List<Tool> = listOf(
    fun promoteLearningTool(memoryStore: MemoryStore, appSettings: AppSettings) = object : Tool {
    val heartbeatToolDefinitions = listOf(promoteLearningToolInfo)
    val promoteLearningToolInfo = ToolInfo(
    }
object HeartbeatTools {
package com.inspiredandroid.kai.tools
}
