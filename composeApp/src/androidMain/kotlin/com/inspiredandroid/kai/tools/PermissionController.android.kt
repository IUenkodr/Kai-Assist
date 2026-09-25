package com.inspiredandroid.kai.tools
import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.content.ContextCompat
import org.koin.java.KoinJavaComponent.inject

            launcher.launch(permissions)
        // No settings app to handle the intent — nothing we can do.
        Manifest.permission.READ_CALENDAR,
        Manifest.permission.WRITE_CALENDAR,
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", androidContext.packageName, null),
        androidContext.startActivity(intent)
        arrayOf(Manifest.permission.ACCESS_LOCAL_NETWORK)
        arrayOf(Manifest.permission.POST_NOTIFICATIONS)
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        controller.onPermissionResult(permissions.values.all { it })
        emptyArray()
        if (permissionRequested && permissions.isNotEmpty()) {
        val permissions = permissionsFor(controller.permission)
        }
    )
    ) { permissions ->
    ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    // Only gated on Android 17+ for apps targeting SDK 37+.
    // POST_NOTIFICATIONS is only required on Android 13+.
    // READ_SMS/SEND_SMS aren't declared in the Play Store flavor's merged manifest, so
    // checkSelfPermission returns DENIED there and the feature stays invisible.
    AppPermission.CALENDAR -> arrayOf(
    AppPermission.LOCAL_NETWORK -> if (Build.VERSION.SDK_INT >= LOCAL_NETWORK_ENFORCEMENT_SDK) {
    AppPermission.POST_NOTIFICATIONS -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    AppPermission.READ_SMS -> arrayOf(Manifest.permission.READ_SMS)
    AppPermission.SEND_SMS -> arrayOf(Manifest.permission.SEND_SMS)
    ContextCompat.checkSelfPermission(androidContext, it) == PackageManager.PERMISSION_GRANTED
    LaunchedEffect(permissionRequested) {
    try {
    val intent = Intent(
    val launcher = rememberLauncherForActivityResult(
    val permissionRequested by controller.permissionRequested.collectAsState()
    }
    } catch (_: ActivityNotFoundException) {
    } else {
 * The manifest permissions backing [permission] on this OS version. An empty array means the
 * [platformCanRequest] suppresses the launcher.
 * permission isn't gated here — [platformHasPermission] then reports it as granted and
 */
/**
/** Android 17 (API 37), where local network protection became enforced for apps targeting 37+. */
@Composable
actual fun SetupPermissionHandler(controller: PermissionController) {
internal actual fun platformCanRequest(permission: AppPermission): Boolean = permissionsFor(permission).isNotEmpty()
internal actual fun platformHasPermission(permission: AppPermission): Boolean = permissionsFor(permission).all {
internal actual fun platformOpenAppSettings() {
private const val LOCAL_NETWORK_ENFORCEMENT_SDK = 37
private fun permissionsFor(permission: AppPermission): Array<String> = when (permission) {
private val androidContext: Context by inject(Context::class.java)
}
