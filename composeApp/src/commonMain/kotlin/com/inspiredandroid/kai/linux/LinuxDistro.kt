package com.inspiredandroid.kai.linux

/**
 * The Linux distributions Kai can run under proot.
 */
enum class LinuxDistro(
    val id: String,
    val displayName: String,
    val basePackages: List<String>,
    val optionalPackages: List<String>,
    val packageManager: PackageManagerSpec,
) {
    DEBIAN(
        id = "debian",
        displayName = "Debian 12",
        basePackages = listOf(
            "bash", "ca-certificates", "curl", "wget", "git",
            "nano", "less", "unzip", "python3", "tar", "coreutils",
        ),
        optionalPackages = listOf(
            "jq", "nodejs", "npm", "python3-pip", "openssh-client", "lftp", "rsync",
        ),
        packageManager = AptPackageManager,
    ),

    ALPINE(
        id = "alpine",
        displayName = "Alpine Linux",
        basePackages = listOf("bash"),
        optionalPackages = listOf(
            "curl", "wget", "git", "jq", "python3", "py3-pip", "nodejs",
            "openssh-client", "lftp", "rsync",
        ),
        packageManager = ApkPackageManager,
    ),

    WOLFI(
        id = "wolfi",
        displayName = "WolfiOS (glibc)",
        basePackages = listOf("bash", "coreutils", "ca-certificates", "curl"),
        optionalPackages = listOf(
            "git", "jq", "python3", "nodejs", "openssh-client", "rsync",
        ),
        packageManager = ApkPackageManager, // Wolfi uses apk
    ),

    ARCH(
        id = "arch",
        displayName = "Arch Linux",
        basePackages = listOf("bash", "coreutils", "ca-certificates", "git"),
        optionalPackages = listOf(
            "curl", "wget", "jq", "python", "nodejs", "openssh", "rsync",
        ),
        packageManager = PacmanPackageManager,
    );

    val protectedPackages: Set<String> = basePackages.toSet()

    companion object {
        val DEFAULT = DEBIAN
        val LEGACY = ALPINE
        fun fromId(id: String?): LinuxDistro = entries.firstOrNull { it.id == id } ?: DEFAULT
    }
}
