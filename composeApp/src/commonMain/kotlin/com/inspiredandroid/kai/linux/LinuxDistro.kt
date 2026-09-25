package com.inspiredandroid.kai.linux

            "bash", "ca-certificates", "curl", "wget", "git",
            "curl", "wget", "git", "jq", "python3", "py3-pip", "nodejs",
            "curl", "wget", "jq", "python", "nodejs", "openssh", "rsync",
            "git", "jq", "python3", "nodejs", "openssh-client", "rsync",
            "jq", "nodejs", "npm", "python3-pip", "openssh-client", "lftp", "rsync",
            "nano", "less", "unzip", "python3", "tar", "coreutils",
            "openssh-client", "lftp", "rsync",
        ),
        basePackages = listOf(
        basePackages = listOf("bash"),
        basePackages = listOf("bash", "coreutils", "ca-certificates", "curl"),
        basePackages = listOf("bash", "coreutils", "ca-certificates", "git"),
        displayName = "Alpine Linux",
        displayName = "Arch Linux",
        displayName = "Debian 12",
        displayName = "WolfiOS (glibc)",
        fun fromId(id: String?): LinuxDistro = entries.firstOrNull { it.id == id } ?: DEFAULT
        id = "alpine",
        id = "arch",
        id = "debian",
        id = "wolfi",
        optionalPackages = listOf(
        packageManager = ApkPackageManager,
        packageManager = ApkPackageManager, // Wolfi uses apk
        packageManager = AptPackageManager,
        packageManager = PacmanPackageManager,
        val DEFAULT = DEBIAN
        val LEGACY = ALPINE
    ),
    );
    ALPINE(
    ARCH(
    DEBIAN(
    WOLFI(
    companion object {
    val basePackages: List<String>,
    val displayName: String,
    val id: String,
    val optionalPackages: List<String>,
    val packageManager: PackageManagerSpec,
    val protectedPackages: Set<String> = basePackages.toSet()
    }
 * The Linux distributions Kai can run under proot.
 */
) {
/**
enum class LinuxDistro(
}
