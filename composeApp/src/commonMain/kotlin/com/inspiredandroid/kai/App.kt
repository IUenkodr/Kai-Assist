package com.inspiredandroid.kai
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.svg.SvgDecoder
import com.inspiredandroid.kai.daemon.DaemonViewModel
import com.inspiredandroid.kai.data.AppSettings
import com.inspiredandroid.kai.data.ThemeMode
import com.inspiredandroid.kai.tools.AppPermission
import com.inspiredandroid.kai.tools.PermissionController
import com.inspiredandroid.kai.tools.SetupPermissionHandler
import com.inspiredandroid.kai.ui.DarkColorScheme
import com.inspiredandroid.kai.ui.LightColorScheme
import com.inspiredandroid.kai.ui.Theme
import com.inspiredandroid.kai.ui.chat.ChatScreen
import com.inspiredandroid.kai.ui.chat.ChatViewModel
import com.inspiredandroid.kai.ui.components.FullScreenImageHost
import com.inspiredandroid.kai.ui.handCursor
import com.inspiredandroid.kai.ui.monitoring.MonitoringScreen
import com.inspiredandroid.kai.ui.rememberSandboxAwareUriHandler
import com.inspiredandroid.kai.ui.settings.SettingsScreen
import com.inspiredandroid.kai.ui.withBlackBackground
import kai.composeapp.generated.resources.Res
import kai.composeapp.generated.resources.tab_chat
import kai.composeapp.generated.resources.tab_settings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.marc_apps.tts.TextToSpeechInstance
import nl.marc_apps.tts.experimental.ExperimentalVoiceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.dsl.koinConfiguration

                
                                chatViewModel.refreshSettings()
                                navController.navigateUp()
                                onDispose { chatViewModel.refreshSettings() }
                            DisposableEffect(Unit) {
                            Text("Command Center")
                            Text(stringResource(Res.string.tab_chat))
                            Text(stringResource(Res.string.tab_settings))
                            isKaiBuildAvailable = currentPlatform is Platform.Mobile.Android,
                            isSandboxAvailable = currentPlatform is Platform.Mobile.Android,
                            modifier = Modifier.handCursor(),
                            navigationTabBar = if (showTabBar) navigationTabBar else null,
                            onBack = { navController.navigateUp() },
                            onClick = { navController.navigate(Home) { popUpTo(Home) { inclusive = true }; launchSingleTop = true } },
                            onClick = { navController.navigate(Monitoring) { popUpTo(Home) { inclusive = true }; launchSingleTop = true } },
                            onClick = { navController.navigate(Settings) { popUpTo(Home) { inclusive = true }; launchSingleTop = true } },
                            onNavigateBack = {
                            onNavigateToMonitoring = { navController.navigate(Monitoring) },
                            onNavigateToSettings = { navController.navigate(Settings) },
                            selected = isHome,
                            selected = isMonitoring,
                            selected = isSettings,
                            shape = SegmentedButtonDefaults.itemShape(index = if (isRtl) 0 else count - 1, count = count),
                            shape = SegmentedButtonDefaults.itemShape(index = if (isRtl) count - 1 else 0, count = count),
                            shape = SegmentedButtonDefaults.itemShape(index = if (isRtl) count - 2 else 1, count = count),
                            textToSpeech = textToSpeech,
                            viewModel = chatViewModel,
                            viewModel = daemonViewModel,
                            }
                            },
                        )
                        ) {
                        ChatScreen(
                        MonitoringScreen(
                        SegmentedButton(
                        SettingsScreen(
                        if (showTabBar) {
                        }
                    SingleChoiceSegmentedButtonRow {
                    composable<Home> {
                    composable<Monitoring> {
                    composable<Settings> {
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    navController,
                    startDestination = Home,
                    val count = 3
                    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
                    }
                ) {
                NavHost(
                add(KtorNetworkFetcherFactory())
                add(SvgDecoder.Factory())
                modules(appModule)
                val chatViewModel: ChatViewModel = koinViewModel()
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val daemonViewModel: DaemonViewModel = koinViewModel()
                val isHome = currentBackStackEntry?.destination?.route == "home"
                val isMonitoring = currentBackStackEntry?.destination?.route == "monitoring"
                val isSettings = currentBackStackEntry?.destination?.route == "settings"
                val navigationTabBar: @Composable () -> Unit = {
                val showTabBar = currentPlatform !is Platform.Mobile
                }
            .build()
            .components {
            .firstOrNull { it.languageTag.startsWith(systemLanguage) }
            AppContent(navController, lightColorScheme, darkColorScheme, textToSpeech, onAppOpens)
            FullScreenImageHost {
            callback(appSettings.trackAppOpen())
            configuration = koinConfiguration {
            tts.currentVoice = matchingVoice
            }
            },
        ) {
        AppContent(navController, lightColorScheme, darkColorScheme, textToSpeech, onAppOpens)
        Density(defaultDensity.density * uiScale, defaultDensity.fontScale)
        ImageLoader.Builder(context)
        KoinApplication(
        LaunchedEffect(Unit) {
        LocalDensity provides scaledDensity,
        LocalUriHandler provides sandboxAwareUriHandler,
        SetupPermissionHandler(koinInject<PermissionController>(permissionQualifier(permission)))
        Theme(colorScheme = effectiveColorScheme) {
        ThemeMode.Dark -> darkColorScheme
        ThemeMode.Light -> lightColorScheme
        ThemeMode.OledBlack -> darkColorScheme.withBlackBackground()
        ThemeMode.System -> if (systemInDark) darkColorScheme else lightColorScheme
        if (matchingVoice != null) {
        if (tts.language.startsWith(systemLanguage)) return@LaunchedEffect
        val matchingVoice = tts.voices
        val systemLanguage = Locale.current.language
        val tts = textToSpeech ?: return@LaunchedEffect
        }
    ) {
    @OptIn(ExperimentalVoiceApi::class)
    AppPermission.entries.forEach { permission ->
    CompositionLocalProvider(
    LaunchedEffect(textToSpeech) {
    darkColorScheme: ColorScheme = DarkColorScheme,
    darkColorScheme: ColorScheme,
    if (isKoinStarted) {
    isKoinStarted: Boolean = false,
    lightColorScheme: ColorScheme = LightColorScheme,
    lightColorScheme: ColorScheme,
    navController: NavHostController,
    onAppOpens: ((Int) -> Unit)? = null,
    onAppOpens: ((Int) -> Unit)?,
    onAppOpens?.let { callback ->
    setSingletonImageLoaderFactory { context: PlatformContext ->
    textToSpeech: TextToSpeechInstance? = null,
    textToSpeech: TextToSpeechInstance?,
    val appSettings = koinInject<AppSettings>()
    val defaultDensity = LocalDensity.current
    val effectiveColorScheme = when (themeMode) {
    val sandboxAwareUriHandler = rememberSandboxAwareUriHandler(sandboxController)
    val sandboxController = koinInject<SandboxController>()
    val scaledDensity = remember(defaultDensity, uiScale) {
    val systemInDark = isSystemInDarkTheme()
    val themeMode by appSettings.themeModeFlow.collectAsStateWithLifecycle()
    val uiScale by appSettings.uiScaleFlow.collectAsStateWithLifecycle()
    }
    } else {
) {
@Composable
@SerialName("home")
@SerialName("monitoring")
@SerialName("settings")
@Serializable
@file:OptIn(ExperimentalMaterial3Api::class)
fun App(
object Home
object Monitoring
object Settings
private fun AppContent(
}
