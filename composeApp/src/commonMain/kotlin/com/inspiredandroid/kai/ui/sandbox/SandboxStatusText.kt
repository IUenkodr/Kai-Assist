import androidx.compose.runtime.Composable
import com.inspiredandroid.kai.SandboxStatusLabel
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.sandbox_status_base_packages
import kai.composeapp.generated.resources.sandbox_status_configuring
import kai.composeapp.generated.resources.sandbox_status_copy_failed
import kai.composeapp.generated.resources.sandbox_status_copying_files
import kai.composeapp.generated.resources.sandbox_status_copying_files_progress
import kai.composeapp.generated.resources.sandbox_status_downloading
import kai.composeapp.generated.resources.sandbox_status_error
import kai.composeapp.generated.resources.sandbox_status_extracting
import kai.composeapp.generated.resources.sandbox_status_install_failed
import kai.composeapp.generated.resources.sandbox_status_installing
import kai.composeapp.generated.resources.sandbox_status_installing_package
import kai.composeapp.generated.resources.sandbox_status_not_installed
import kai.composeapp.generated.resources.sandbox_status_package_failed
import kai.composeapp.generated.resources.sandbox_status_ready
import kai.composeapp.generated.resources.sandbox_status_setup_failed
import kai.composeapp.generated.resources.sandbox_status_unknown_error
import org.jetbrains.compose.resources.stringResource

                stringResource(Res.string.sandbox_status_package_failed, label.packageName, detail)
            is SandboxStatusLabel.Failure.Copy -> stringResource(Res.string.sandbox_status_copy_failed, detail)
            is SandboxStatusLabel.Failure.Install -> stringResource(Res.string.sandbox_status_install_failed, detail)
            is SandboxStatusLabel.Failure.Package ->
            is SandboxStatusLabel.Failure.Setup -> stringResource(Res.string.sandbox_status_setup_failed, detail)
            is SandboxStatusLabel.Failure.Status -> stringResource(Res.string.sandbox_status_error, detail)
        // The underlying text arrives from the OS or a download mirror untranslated,
        // and is missing altogether often enough to need a stand-in of its own.
        stringResource(Res.string.sandbox_status_copying_files)
        stringResource(Res.string.sandbox_status_copying_files_progress, label.done, label.total)
        stringResource(Res.string.sandbox_status_installing_package, label.packageName)
        val detail = label.detail.ifBlank { stringResource(Res.string.sandbox_status_unknown_error) }
        when (label) {
        }
    SandboxStatusLabel.BasePackages -> stringResource(Res.string.sandbox_status_base_packages)
    SandboxStatusLabel.Configuring -> stringResource(Res.string.sandbox_status_configuring)
    SandboxStatusLabel.Downloading -> stringResource(Res.string.sandbox_status_downloading)
    SandboxStatusLabel.Extracting -> stringResource(Res.string.sandbox_status_extracting)
    SandboxStatusLabel.Installing -> stringResource(Res.string.sandbox_status_installing)
    SandboxStatusLabel.NotInstalled -> stringResource(Res.string.sandbox_status_not_installed)
    SandboxStatusLabel.Ready -> stringResource(Res.string.sandbox_status_ready)
    is SandboxStatusLabel.CopyingFiles -> if (label.total > 0) {
    is SandboxStatusLabel.Failure -> {
    is SandboxStatusLabel.InstallingPackage ->
    null -> ""
    }
    } else {
 * Turns the sandbox's reported step into the sentence the card shows. The install
 * runs outside composition, so this is the only place that knows the wording.
 */
/**
@Composable
internal fun sandboxStatusText(label: SandboxStatusLabel?): String = when (label) {
package com.inspiredandroid.kai.ui.sandbox
}
