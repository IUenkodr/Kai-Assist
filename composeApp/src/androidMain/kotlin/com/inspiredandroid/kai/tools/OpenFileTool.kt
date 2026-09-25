
                "Path relative to /root, e.g. site/index.html or notes.md",
                "content_uri" to (result.contentUri ?: ""),
                "mime_type" to result.mimeType,
                "path" to path,
                "string",
                "success" to true,
                true,
            "path" to ParameterSchema(
            )
            ),
            ?: return mapOf("success" to false, "error" to "Invalid path: must be relative to /root, no leading / or .. segments")
            ?: return mapOf("success" to false, "error" to "path is required")
            mapOf(
            mapOf("success" to false, "error" to (result.error ?: "Failed to open file"))
            return mapOf("success" to false, "error" to "File not found: $path")
            return mapOf("success" to false, "error" to "Not a file: $path")
        ),
        description = "Open sandbox files in your default Android app",
        description = OPEN_FILE_DESCRIPTION,
        descriptionRes = Res.string.tool_open_file_description,
        id = "open_file",
        if (!file.exists()) {
        if (!file.isFile) {
        name = "Open File",
        name = "open_file",
        nameRes = Res.string.tool_open_file_name,
        parameters = mapOf(
        return if (result.success) {
        val file = resolveSandboxFile(sandboxManager.homePath, path)
        val path = (args["path"] as? String)?.trim()
        val result = openFileWithIntent(context, file)
        }
        } else {
    )
    override suspend fun execute(args: Map<String, Any>): Any {
    override val schema = ToolSchema(
    private val context: Context by inject(Context::class.java)
    private val sandboxManager: LinuxSandboxManager by inject(LinuxSandboxManager::class.java)
    val toolInfo = ToolInfo(
    }
Path is relative to /root. What the shell tool calls /root/page.html, this tool takes as path="page.html".
Write self-contained files — for HTML, inline all CSS and JavaScript in the same file (no external <link rel="stylesheet"> or <script src=...>), since the file is opened in isolation."""
import android.content.Context
import com.inspiredandroid.kai.network.tools.ParameterSchema
import com.inspiredandroid.kai.network.tools.Tool
import com.inspiredandroid.kai.network.tools.ToolInfo
import com.inspiredandroid.kai.network.tools.ToolSchema
import com.inspiredandroid.kai.sandbox.LinuxSandboxManager
import com.inspiredandroid.kai.sandbox.openFileWithIntent
import com.inspiredandroid.kai.sandbox.resolveSandboxFile
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tool_open_file_description
import kai.composeapp.generated.resources.tool_open_file_name
import org.koin.java.KoinJavaComponent.inject
object OpenFileTool : Tool {
package com.inspiredandroid.kai.tools
private const val OPEN_FILE_DESCRIPTION = """Open a file from the sandbox /root directory in the user's default Android app — browser for HTML, image viewer for PNG/JPG, PDF viewer for PDF, markdown viewer for .md, etc. This is how you show finished work to the user.
}
