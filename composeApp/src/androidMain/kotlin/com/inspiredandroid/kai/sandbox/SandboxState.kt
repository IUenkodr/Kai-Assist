
    data class Downloading(val progress: Float) : SandboxState
    data class Error(val label: SandboxStatusLabel.Failure) : SandboxState
    data class Installing(val label: SandboxStatusLabel = SandboxStatusLabel.Installing) : SandboxState
    data object Extracting : SandboxState
    data object NotInstalled : SandboxState
    data object Ready : SandboxState
import com.inspiredandroid.kai.SandboxStatusLabel
package com.inspiredandroid.kai.sandbox
sealed interface SandboxState {
}
