
                        FileVisitResult.CONTINUE
                        Log.i(TAG, "captured open-url: $url")
                        added = true
                        return FileVisitResult.CONTINUE
                        runCatching { Files.deleteIfExists(dir) }
                        runCatching { Files.deleteIfExists(file) }
                        screen.noteTextUrls(text)
                        screen.writeText(text)
                    "ls -la /root/.grok/downloads 2>/dev/null | tail -5; " +
                    "ls -la /root/.local/bin /root/.grok/bin /root/.opencode/bin /usr/local/bin 2>/dev/null; " +
                    "ls -la /root/.local/share/claude/versions 2>/dev/null | tail -5; " +
                    "ls -la /root/.opencode/bin 2>/dev/null",
                    // Always scan raw stream for URLs (OSC 8/52 may be incomplete across chunks).
                    FileVisitResult.CONTINUE
                    exit 0
                    if (attrs.isRegularFile) total += attrs.size()
                    if (screen.noteHyperlink(url)) {
                    ln -sfn "${'$'}ver_dir/${'$'}latest" "${'$'}dest"
                    override fun postVisitDirectory(dir: Path, exc: IOException?): FileVisitResult {
                    override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
                    override fun visitFileFailed(file: Path, exc: IOException): FileVisitResult =
                    repaint.trySend(Unit)
                    return FileVisitResult.CONTINUE
                    session.withScreen { screen ->
                    val text = buf.decodeToString(0, n, throwOnInvalidSequence = false)
                    }
                "/root/.opencode/bin /root/.claude/downloads /usr/local/bin",
                "command -v ${agent.binary} 2>/dev/null; " +
                .firstOrNull { it.startsWith("PRETTY_NAME=") }
                // /root itself stays on the rootfs so agent binaries under the
                // Drop the handle before closing: cancelling the job that is running
                // Keep the card's numbers up while they are re-measured; an
                // Runs on the PTY reader thread: keep it to parsing, and let the
                // mounted noexec.
                // repaint pump do the snapshotting and publishing on its own clock.
                // this block is not how it should end.
                // uninstalled system has none to keep.
                // vendor install dirs are executable — external storage is often
                ?.substringAfter('=')
                ?.takeIf { it.isNotBlank() }
                ?.trim('"')
                File(paths.tmpDir, session.openUrlFile).writeText("")
                Log.e(TAG, "Install failed", e)
                activeSessionId = id
                activeSessionId = sessions.values.lastOrNull { it.project == removed.project }?.id
                agentId = agentId?.takeIf { BuildAgents.get(it) != null },
                append(snap.cellAt(col, row).char)
                binds = listOf(paths.projectsDir.absolutePath to "/root/projects"),
                cleanUpPartialInstall(error = e.message ?: "Install failed")
                cleanUpPartialInstall(error = null)
                closeProjectSessions(project)
                columns = lastColumns.get(),
                command = launch,
                delay(IDLE_PROJECT_TTL_MS)
                delay(REPAINT_INTERVAL_MS)
                dir.toPath(),
                env = DebianSpec.env + agentEnv(columns, rows, openUrlPath),
                environment = if (ready) BuildEnvironmentState.Ready else BuildEnvironmentState.NotInstalled,
                exit 0
                extraArgs = DebianSpec.prootArgs,
                fi
                id = id,
                if (repaint.receiveCatching().isClosed) break
                if (url.startsWith("http://") || url.startsWith("https://")) {
                if [ -n "${'$'}latest" ] && [ -x "${'$'}ver_dir/${'$'}latest" ]; then
                installInternal(agentIds) { isActive }
                installedAgents = if (ready) guessAgents() else persistentSetOf(),
                is InstallStep.Configure -> setStep(BuildStep.Configure)
                is InstallStep.Download -> setStep(BuildStep.Download, progress = step.fraction)
                is InstallStep.Extract -> setStep(BuildStep.Extract)
                is InstallStep.Packages -> setStep(BuildStep.BasePackages)
                lastError = error,
                latest="${'$'}(ls -1 "${'$'}ver_dir" 2>/dev/null | sort -V | tail -1)"
                libDir = paths.libDir,
                lines.count { it.startsWith("Package: ") }
                ln -sfn "${'$'}candidate" "${'$'}dest"
                number = number,
                object : SimpleFileVisitor<Path>() {
                onOutput = { buf, n ->
                override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
                override fun visitFileFailed(file: Path, exc: IOException): FileVisitResult =
                paths.tmpDir.mkdirs()
                project = project,
                projects = scanProjects(),
                prootPath = paths.prootPath,
                publishScreen(session)
                rootfsPath = paths.rootfsDir.absolutePath,
                rows = lastRows.get(),
                session.withScreen { it.writeText("\r\n[shell exited $exit]\r\n") }
                sessions[id] = it
                staged.delete()
                synchronized(sessionsLock) { reapJobs.remove(project) }
                systemInfo = if (ready) it.systemInfo else null,
                target.writeText("$rows $columns\n")
                throw e
                timeoutSeconds = 30,
                tmpPath = paths.tmpDir.absolutePath,
                val url = line.trim()
                workingDir = "/root/projects/${session.project}",
                }
                },
            !text.contains("browser", ignoreCase = true)
            !text.contains("signing in", ignoreCase = true) &&
            """
            """.trimMargin(),
            "/root/.grok/bin/${'$'}bin" \
            "/root/.opencode/bin/${'$'}bin" \
            "/usr/local/bin/${'$'}bin"
            "command -v $binary 2>/dev/null",
            "mkdir -p /root/.local/bin /root/.grok/bin /root/.grok/downloads " +
            )
            ),
            ).also {
            .filter { executor.ensureAgentBinary(it.binary) }
            .map { it.id }
            .toImmutableSet()
            // (`bash -lc`) reset PATH via /etc/profile, and vendor installers often
            // 80x24 default into the PTY, and an agent that paints its banner once
            // An agent session runs the CLI first and leaves a usable shell behind.
            // Bookmark-style deep link so the code is visible next to the URL in the bar.
            // Closing lets the pump run its final pass, which renders whatever the
            // Geometry is taken as late as possible, and from the newest measurement
            // Interactive login shell rooted at the project folder. No stty here: the
            // Its neighbour in the same project, or nothing: other projects have
            // One last read in case the URL landed as the process exited.
            // Poll Grok's URL capture file (and our BROWSER wrapper) while the shell runs.
            // Read the geometry back rather than using the captured one: two resizes
            // Resolve an absolute path under the non-login probe PATH: login shells
            // The channel closes once the shell is done writing, so this last pass
            // Trim trailing spaces from this row only.
            // bin dir — leaving only agents that force-wrote .bashrc (e.g. Grok).
            // binary runs a probe inside the rootfs, and the viewport is normally
            // blocks above wrote. Nothing writes to the screen after this point.
            // bridge already owns the winsize, and re-asserting a captured one would
            // in flight at once would otherwise race, and the stale one could land
            // last. Re-reading makes every pending pass apply the newest viewport.
            // looking at.
            // measured while that is still going. Reading it any earlier bakes the
            // only overwrite a resize that landed while the shell was starting.
            // paints it at a width the grid never had — every line wraps, and it
            // rather than the one this session was created with: resolving the agent
            // renders the tail — including the exit line — after every writer.
            // sessions of their own now, and none of them is what the user is
            // skip writing rc PATH lines when our proot env already included their
            // stays wrapped because that output is never redrawn.
            BuildSession(
            File(paths.rootfsDir, "etc/debian_version").readText().trim().takeIf { it.isNotBlank() }
            File(paths.rootfsDir, "etc/os-release").readLines()
            File(paths.rootfsDir, "var/lib/dpkg/status").useLines { lines ->
            File(paths.tmpDir, session.openUrlFile).delete()
            File(paths.tmpDir, session.pidFile).delete()
            File(paths.tmpDir, session.winsizeFile).delete()
            Files.exists(link, LinkOption.NOFOLLOW_LINKS)
            Files.walkFileTree(
            Log.e(TAG, "Shell failed", e)
            Log.w(TAG, "${agent.id} install failed (exit detail): ${result.failureDetail()}")
            Log.w(TAG, "${agent.id} post-install probe: ${probe.stdout} ${probe.stderr}")
            _state.update { it.copy(projects = scanProjects()) }
            _state.value = KaiBuildState(projects = scanProjects())
            active = activeSessionId
            activeSessionId = id
            activeSessionId = null
            all
            append('\n')
            architecture = DebianSpec.arch(),
            closeAllSessions()
            columns = columns,
            delay(HYPERLINK_TTL_MS)
            deleteTree(dir)
            dir.toPath(),
            distribution = pretty ?: version?.let { "Debian $it" } ?: "Debian",
            ensureAgentPathProfile()
            ensureBrowserCaptureHelpers()
            exit 0
            fi
            for (col in 0 until snap.columns) {
            for (line in lines) {
            freeBytes = free,
            if (!installAgent(agent)) failed += agent.title
            if (!isActive()) throw CancellationException()
            if (!repaintJob.isActive) publishScreen(session)
            if (!sessions.containsKey(id)) return
            if (!staged.renameTo(target)) {
            if (activeSessionId == id) {
            if (end < length) deleteRange(end, length)
            if (exit > 0) {
            if (last != null) activeSessionId = last.id
            if (sessions.values.none { it.project == project }) return
            if (sessions[activeSessionId] == null) activeSessionId = sessions.values.lastOrNull()?.id
            if [ -d "${'$'}ver_dir" ]; then
            if [ -x "${'$'}candidate" ] && [ ! -d "${'$'}candidate" ]; then
            ingestOpenUrlFile(session)
            installDebian()
            it.copy(
            it.copy(environment = BuildEnvironmentState.Installing(step, progress, agentId), lastError = null)
            kotlinx.coroutines.delay(250)
            last != null
            launcher = ProotLauncher(
            list = sessions.values.map { it.toUiSession() }
            matches
            matches.forEach { sessions.remove(it.id) }
            object : SimpleFileVisitor<Path>() {
            onEnvironmentChanged?.invoke()
            packageCount = packages,
            paths.deleteInstall()
            paths.ensureLayout()
            paths.tmpDir.mkdirs()
            pidFileName = session?.pidFile ?: "kai-pid",
            projectsBytes = directorySize(paths.projectsDir),
            publishScreen(session)
            publishSessions()
            reapJobs.clear()
            reapJobs.remove(project)?.cancel()
            reapJobs.values.forEach { it.cancel() }
            reapJobs[project] = scope.launch {
            removed
            repaint.close()
            return
            rows = rows,
            runCatching {
            scheduleHyperlinkClear(session)
            screen.noteHyperlink("https://accounts.x.ai/sign-in")
            screen.noteHyperlink("https://accounts.x.ai/sign-in#code=$code")
            session.busy = false
            session.handle = handle
            session.handle = null
            session.refreshSnapshot()
            session.resize(cols, rows)
            session.resize(currentC, currentR)
            session.withScreen { it.clearHyperlinks() }
            session.withScreen { it.writeText("\r\n${e.message ?: "Shell failed"}\r\n") }
            sessions.clear()
            staged.writeText("$rows $columns\n")
            systemBytes = directorySize(paths.rootfsDir) + directorySize(paths.tmpDir),
            timeoutSeconds = 20,
            timeoutSeconds = 30,
            tmpPath = paths.tmpDir.absolutePath,
            try {
            urlPollJob = scope.launch { pollOpenUrlFile(session) }
            urlPollJob?.cancel()
            val agentBinary = BuildAgents.get(session.agentId)?.binary
            val agentCmd = agentBinary?.let { resolveAgentCommand(it) }
            val all = sessions.values.toList()
            val cols = lastColumns.get()
            val currentC = lastColumns.get()
            val currentR = lastRows.get()
            val exit = handle.awaitExit()
            val handle = executor(columns = cols, rows = rows, session = session).executeStreaming(
            val last = sessions.values.lastOrNull { it.project == project }
            val launch = if (agentCmd != null) "$agentCmd; exec bash -l" else "exec bash -l"
            val link = File(paths.rootfsDir, "root/.local/bin/${it.binary}").toPath()
            val matches = sessions.values.filter { it.project == project }
            val number = (sessions.values.filter { it.project == project }.maxOfOrNull { it.number } ?: 0) + 1
            val probe = executor.execute(
            val removed = sessions.remove(id) ?: return
            val rows = lastRows.get()
            val staged = File(paths.tmpDir, "${session.winsizeFile}.tmp")
            val start = length
            val target = File(paths.tmpDir, session.winsizeFile)
            var end = length
            ver_dir="/root/.local/share/claude/versions"
            when (step) {
            while (end > start && this[end - 1] == ' ') end--
            while (true) {
            winsizePath = "/tmp/${session?.winsizeFile ?: "kai-winsize"}",
            writeWinsize(session, columns = cols, rows = rows)
            writeWinsize(session, columns = currentC, rows = currentR)
            |
            |  printf '%s\n' "${'$'}url" >> "${'$'}target"
            |# Kai Build: capture browser-open URLs for the in-app link bar.
            |# Managed by Kai Build — keep coding-agent CLIs on PATH for login shells.
            |#!/bin/sh
            |exit 0
            |export PATH="/root/.local/bin:/root/.grok/bin:/root/.opencode/bin${'$'}{PATH:+:${'$'}PATH}"
            |fi
            |if [ -n "${'$'}url" ]; then
            |target="${'$'}{KAI_OPEN_URL_FILE:-/tmp/kai-open-url}"
            |url="${'$'}1"
            }
            } catch (e: CancellationException) {
            } catch (e: Exception) {
            },
        """
        """.trimIndent(),
        "BROWSER" to "/usr/local/bin/kai-browser",
        "COLORTERM" to "truecolor",
        "COLUMNS" to columns.toString(),
        "GROK_TEST_OPEN_URL_FILE" to openUrlPath,
        "KAI_OPEN_URL_FILE" to openUrlPath,
        "LINES" to rows.toString(),
        "PATH" to "/root/.local/bin:/root/.grok/bin:/root/.opencode/bin:$DEFAULT_GUEST_PATH",
        "USER" to "root",
        # Claude install can leave only the versioned binary under share/.
        # Prefer a real file under .local/bin; otherwise link from vendor dirs.
        )
        ) {
        ).stdout.trim().lineSequence().firstOrNull().orEmpty()
        .filter {
        .filter { it.isDirectory }
        .map { it.id }
        .map { it.name }
        .orEmpty()
        .replace(INVALID_NAME_CHARS, "-")
        .sorted()
        .take(64)
        .takeIf { it.isNotEmpty() }
        .toImmutableList()
        .toImmutableSet()
        .trim('-', '.')
        // Cheap enough to answer on the caller's thread, and the common case: the
        // Consume the file so the same URLs are not re-applied after a TTL clear.
        // Debian only: an Alpine chat sandbox cannot host the agents, and Kai Build
        // GROK_TEST_OPEN_URL_FILE is an official Grok hook that writes the URL to a file.
        // Grok opens the login URL via webbrowser; under proot there is no real browser.
        // Keep every agent dir on PATH; shell rc files are not sourced for non-login probes.
        // New URLs (OSC 8 / stream / device code) restart the auto-hide TTL.
        // Only treat as auth when the login copy is on screen. This runs on every
        // Repaint is coalesced to at most one per frame. A repaint snapshots the
        // Safe: [binary] is a fixed catalog name (claude/grok/opencode).
        // Same target for the kai-browser wrapper, so both hooks feed one session's link bar.
        // TTL is scheduled by publishScreen when it sees the new links.
        // The snapshot above is kept current either way; only a session the user
        // UI calls this on every layout pass, including each keyboard-animation frame.
        // Vendor installers: Claude → ~/.local/bin, Grok → ~/.grok/bin, OpenCode → ~/.opencode/bin.
        // Vendor scripts may leave the binary only in their private dir and only
        // Whoever installs first wins: a Debian chat sandbox already put a rootfs
        // a burst collapses into a single repaint without ever dropping the last
        // and re-probe so a successful download still counts as installed.
        // few hundred microseconds under heavy output — repainting per chunk is
        // here, in which case this only adds the agents the user ticked.
        // is actually looking at is worth pushing to the UI.
        // place, where the regex and a lowercased copy of the whole screen allocate.
        // repaint, so the keyword gate comes first: `contains(ignoreCase)` scans in
        // state: whatever arrived during the wait is still pending afterwards.
        // then installs its own Debian somewhere else.
        // update shell rc files — which Kai Build never sources. Link into PATH
        // webbrowser crate falls back to ${'$'}BROWSER when xdg-open is missing.
        // what made the app unusable while a command was running. CONFLATED means
        // whole grid and re-lays out the text, and the PTY hands us a chunk every
        File(dir, "kai-build-path.sh").writeText(
        File(paths.projectsDir, folder).mkdirs()
        Files.walkFileTree(
        Log.i(TAG, "device code detected: $code — surface https://accounts.x.ai/sign-in")
        _state.update {
        _state.update { it.copy(installedAgents = agents) }
        _state.update { it.copy(sessions = list.toImmutableList(), activeSessionId = active) }
        _state.update { it.copy(systemInfo = info) }
        _state.value = KaiBuildState(projects = scanProjects())
        activeSession()?.handle?.writeText(text)
        agentId = agentId,
        bin='$binary'
        busy = busy,
        busy = false
        closeAllSessions()
        closeProjectSessions(name)
        closing.forEach(::endSession)
        columns.set(cols)
        columns: Int = lastColumns.get(),
        dest="/root/.local/bin/${'$'}bin"
        dir.mkdirs()
        do
        done
        endSession(session)
        ensureAgentPathProfile()
        executor.execute(
        exit 0
        fi
        for (agent in agentIds.mapNotNull { BuildAgents.get(it) }) {
        for (row in 0 until snap.rows) {
        for candidate in \
        foregroundProject = null
        foregroundProject = project
        handle = null
        handle?.cancel()
        hyperlinkClearJob = null
        hyperlinkClearJob?.cancel()
        id = id,
        if (!_state.value.isReady) return
        if (!dir.renameTo(target)) return null
        if (!file.exists() || file.length() == 0L) return
        if (!installed) {
        if (!ready) return
        if (!text.contains("approve", ignoreCase = true) &&
        if (added) {
        if (c == session.columns.get() && r == session.rows.get()) return
        if (code == session.lastDeviceCode) return
        if (folder == name) return folder
        if (foregroundProject == project) foregroundProject = null
        if (installJob?.isActive == true) return
        if (lines.isEmpty()) return
        if (linksAfter.isNotEmpty() && linksAfter != linksBefore) {
        if (name.isEmpty() || name == "." || name == ".." || name.contains('/')) return null
        if (paths.readMarker() == null) {
        if (resumed) publishSessions()
        if (session.project == foregroundProject) publishSessions()
        if (target.exists()) return null
        if [ "${'$'}bin" = "claude" ]; then
        if [ -x "${'$'}dest" ] && [ ! -d "${'$'}dest" ]; then
        installJob = null
        installJob = scope.launch {
        installJob?.cancel()
        installed
        installer.install(LinuxDistro.DEBIAN) { step ->
        job = null
        job?.cancel()
        lastColumns.set(c)
        lastRows.set(r)
        mkdir -p /root/.local/bin
        noteDeviceCodeFromText(session, text)
        number = number,
        paths.copyLibtalloc()
        paths.ensureLayout()
        paths.ensureMountPoints()
        private set
        probe.ensureAgentBinary(binary)
        project = project,
        publishSessions()
        return BuildAgents.all
        return BuildProotExecutor(
        return BuildSystemInfo(
        return File(paths.projectsDir, name).takeIf { it.isDirectory }
        return folder
        return if (path.startsWith("/")) "'$path'" else binary
        return resumed
        rows.set(rws)
        rows: Int = lastRows.get(),
        runCatching {
        runCatching { file.writeText("") }
        scope.launch {
        scope.launch { _state.update { it.copy(projects = scanProjects()) } }
        scope.launch { sync() }
        script.parentFile?.mkdirs()
        script.setExecutable(true, false)
        script.writeText(
        session.hyperlinkClearJob = scope.launch {
        session.hyperlinkClearJob?.cancel()
        session.job = scope.launch { runShell(session) }
        session.lastDeviceCode = code
        session.refreshSnapshot()
        session.stop()
        session.withScreen { screen ->
        session: BuildSession? = null,
        set -e
        setStep(BuildStep.Agent, agentId = agent.id)
        snapshot = if (screen.noteTextUrls(urlText)) screen.snapshot() else snap
        sync(error = if (failed.isEmpty()) null else "Could not install ${failed.joinToString()}")
        sync(error)
        synchronized(screenLock) { screen.resize(cols, rws) }
        synchronized(sessionsLock) {
        terminal = snapshot,
        text
        timeoutSeconds = 30,
        try {
        val active: String?
        val agents = detectAgents()
        val c = columns.coerceIn(MIN_COLUMNS, MAX_COLUMNS)
        val closing = synchronized(sessionsLock) {
        val code = DEVICE_CODE_REGEX.find(text)?.groupValues?.getOrNull(1) ?: return
        val dir = File(paths.rootfsDir, "etc/profile.d")
        val dir = projectDir(name) ?: return
        val dir = projectDir(name) ?: return null
        val executor = executor()
        val failed = mutableListOf<String>()
        val file = File(paths.tmpDir, session.openUrlFile)
        val folder = sanitizeProjectName(name) ?: return null
        val folder = sanitizeProjectName(newName) ?: return null
        val free = runCatching { StatFs(paths.root.absolutePath).availableBytes }.getOrDefault(0L)
        val id = "s${sessionCounter.incrementAndGet()}"
        val info = readSystemInfo()
        val installed = executor.ensureAgentBinary(agent.binary)
        val lines = runCatching { file.readLines() }.getOrDefault(emptyList())
        val linksAfter = session.snapshot.hyperlinks
        val linksBefore = session.snapshot.hyperlinks
        val list: List<BuildTerminalSession>
        val openUrlPath = "/tmp/${session?.openUrlFile ?: "kai-open-url"}"
        val packages = runCatching {
        val path = probe.execute(
        val pretty = runCatching {
        val probe = executor()
        val r = rows.coerceIn(MIN_ROWS, MAX_ROWS)
        val ready = paths.readMarker()?.distro == LinuxDistro.DEBIAN && File(paths.prootPath).canExecute()
        val repaint = Channel<Unit>(Channel.CONFLATED)
        val repaintJob = scope.launch(Dispatchers.Default) {
        val result = executor.execute(agent.installCommand, timeoutSeconds = 900)
        val resumed = synchronized(sessionsLock) {
        val script = File(paths.rootfsDir, "usr/local/bin/kai-browser")
        val session = activeSession() ?: return
        val session = synchronized(sessionsLock) {
        val snap = screen.snapshot()
        val target = File(paths.projectsDir, folder)
        val text = session.refreshSnapshot()
        val text = visibleText(snap)
        val urlText = visibleTextForUrlScan(snap)
        val version = runCatching {
        var added = false
        var urlPollJob: Job? = null
        while (true) {
        }
        } catch (e: Exception) {
        } finally {
        }.getOrDefault(0)
        }.getOrNull()
     *
     * (confirmed via term-debug.log: zero https/OSC8), surface the known sign-in
     * (desktop-style). Safe to call from the UI on every layout pass — no-ops
     * *same* install it uses, so setting up either one sets up both.
     * A tiny `/etc/profile.d` snippet puts every agent bin dir back for login
     * Absolute path (quoted) for [binary], or the bare name if resolution fails.
     * An existing project folder, addressed by the name the list shows. Matched
     * Caches a fresh snapshot and hands back the visible text (for device-code
     * Deletes [dir] and its contents without following symlinks. A project can hold
     * Deletes the project folder and everything in it. Its shells go first: they
     * Drop the link bar a couple of minutes after the last new URL. Login flows
     * Ensures the binary is linked into a known dir before probing.
     * Fired whenever this install appears or disappears. Set when the rootfs is
     * Grok (always rewrites `.bashrc`) still works.
     * Hands the session's PTY bridge its new geometry — it polls this file and
     * Host-side guess at the installed agents: the symlink [detectAgents] leaves
     * Installs `/usr/local/bin/kai-browser` into the rootfs so `$BROWSER` captures
     * Kai Build just gave it a Linux (or took one away).
     * Login shells (`bash -l` / `bash -lc`) reset PATH from `/etc/profile`, which
     * OAuth URL reassembles into one link instead of one stump per row.
     * Opens another PTY session in [project] and makes it active. A non-null
     * PATH into shell rc when their bin dir is already on PATH during install —
     * Project whose terminal is on screen, if any. Only its sessions push repaints
     * Publishes in two passes. The first is file stats only, so the screen learns
     * Re-enters [project]: its shells kept running while the user was away, so
     * Removes the Linux, not the projects. When this install is shared with the
     * Renames the project folder, returning the sanitized new name — or null when
     * Resize the active session's VT buffer and notify its live PTY
     * Snapshotting allocates a cell object per grid position, so the second
     * Steps out of [project] without touching its shells — a build keeps building
     * The install to work in. When the chat sandbox is also Debian this is the
     * The target file is per session, passed in as `KAI_OPEN_URL_FILE`.
     * URLs Grok tries to open when no real display/browser exists under proot.
     * When Grok shows a device code but never emits the auth URL on the PTY
     * Writes text to the active session's shell/agent (UTF-8). Callers that want
     * Written to a sibling and renamed rather than in place: the bridge reads on
     * [agentId] runs that agent first and drops back to a shell when it exits.
     * a link into the rootfs (agents leave plenty), and a walk that followed one
     * a submitted line should include the trailing carriage return themselves.
     * and a shell behind it, and a project reopened days later is not one the user
     * applies TIOCSWINSZ + SIGWINCH.
     * are rooted in that folder, and one whose working directory has been unlinked
     * as a delete: their working directory is the path that just moved.
     * as-is rather than sanitized — the list is a directory listing, so it can hold
     * asked for until the next tick.
     * but never one that reaches outside the projects directory.
     * call. The reaper is the backstop: each session is a proot process with a PTY
     * chat sandbox that sandbox loses its Linux too — the setup card says so.
     * costs one stat per agent where the real probe costs a process.
     * does not need a proot round-trip.
     * drops the proot-injected vendor dirs. Vendor installers often skip writing
     * in the guest's bin dir. The link is checked without following it — its
     * is no longer a session anybody can use.
     * is still waiting on.
     * its own clock, and a read landing inside a truncate-then-write sees a torn
     * looks like they still need to sign in.
     * names a shell created that sanitizing would rewrite into a different folder —
     * number — "24 6" for "24 62" — which resizes the guest to a width nothing
     * only need the links while the user completes them; leaving them forever
     * page plus the code so the user can complete login on the phone browser.
     * process per agent plus a walk of the whole rootfs before anything is shown,
     * scans). URLs are scraped from a space-trimmed join of rows so a line-wrapped
     * screen nobody is looking at should not recompose the app sixty times a
     * second. Its snapshot is current whenever the project is opened again.
     * shared with the chat sandbox, which otherwise has no way to learn that
     * shells without depending on vendor rc edits. Written on the host so it
     * snapshot only happens when a new link actually changed the screen.
     * so Claude (`~/.local/bin`) and OpenCode (`~/.opencode/bin`) vanish while
     * target is an absolute guest path that resolves only inside proot — so this
     * that name is unusable or already taken. Shells are closed for the same reason
     * this only calls off the reaper and puts the tab they left on back in front.
     * to the UI — a background shell still parses everything it is sent, but a
     * when geometry is unchanged.
     * which is what made the setup screen flash on every open.
     * while the user reads something else, and closing a session stays the user's
     * with the authoritative probe. Doing it the other way round costs a proot
     * within milliseconds that Debian is installed; the second replaces the guess
     * would delete the Debian install instead of the project.
     */
    )
    ): BuildProotExecutor {
    /**
    /** Called when something else is about to delete the rootfs under us. */
    /** Cancels/reschedules when a new URL is captured so the bar stays for a full TTL. */
    /** Geometry of the last measured viewport — new sessions start there, not at 80×24. */
    /** Host-side file names inside the bind-mounted tmp dir — one set per session. */
    /** Kills the process and drops the per-session capture files. */
    /** Last published screen — recomputed only for the session that produced output. */
    /** Pending reaps, one per project the user has stepped out of. Guarded by [sessionsLock]. */
    /** Read straight off the rootfs — no proot round-trip, so it is cheap enough for every refresh. */
    /** Snapshot the screen, scan it for a device code, and push it to the UI. */
    /** The installer already removes a rootfs it could not finish; this reports it. */
    // --- install ---------------------------------------------------------
    // --- sessions --------------------------------------------------------
    // --- state -----------------------------------------------------------
    // --- terminal --------------------------------------------------------
    // Safe: [binary] is a fixed catalog name (claude/grok/opencode), not user input.
    @Volatile
    buildString(snap.columns * snap.rows + snap.rows) {
    buildString(snap.columns * snap.rows) {
    columns: Int,
    execute(
    execute("command -v $binary >/dev/null 2>&1", timeoutSeconds = 20).success
    fun <T> withScreen(block: (TerminalScreen) -> T): T = synchronized(screenLock) { block(screen) }
    fun cancel() {
    fun closeSession(id: String) {
    fun createProject(name: String): String? {
    fun deleteProject(name: String) {
    fun install(agentIds: Set<String>) {
    fun leaveProject(project: String) {
    fun onEnvironmentRemoved() {
    fun refresh() {
    fun refreshSnapshot(): String = synchronized(screenLock) {
    fun renameProject(name: String, newName: String): String? {
    fun resize(cols: Int, rws: Int) {
    fun resizeTerminal(columns: Int, rows: Int) {
    fun resumeProject(project: String): Boolean {
    fun selectSession(id: String) {
    fun startSession(project: String, agentId: String?) {
    fun stop() {
    fun toUiSession() = BuildTerminalSession(
    fun uninstall() {
    fun writeToTerminal(text: String) {
    if (!dir.exists()) return 0L
    init {
    private fun activeSession(): BuildSession? = synchronized(sessionsLock) { sessions[activeSessionId] }
    private fun agentEnv(columns: Int, rows: Int, openUrlPath: String) = mapOf(
    private fun cleanUpPartialInstall(error: String?) {
    private fun closeAllSessions() {
    private fun closeProjectSessions(project: String) {
    private fun deleteTree(dir: File) {
    private fun detectAgents(): ImmutableSet<String> {
    private fun endSession(session: BuildSession) {
    private fun ensureAgentPathProfile() {
    private fun ensureBrowserCaptureHelpers() {
    private fun executor(
    private fun guessAgents(): ImmutableSet<String> = BuildAgents.all
    private fun ingestOpenUrlFile(session: BuildSession) {
    private fun noteDeviceCodeFromText(session: BuildSession, text: String) {
    private fun projectDir(name: String): File? {
    private fun publishScreen(session: BuildSession) {
    private fun publishSessions() {
    private fun readSystemInfo(): BuildSystemInfo {
    private fun resolveAgentCommand(binary: String): String {
    private fun runShell(session: BuildSession) {
    private fun sanitizeProjectName(name: String): String? = name.trim()
    private fun scanProjects() = paths.projectsDir.listFiles()
    private fun scheduleHyperlinkClear(session: BuildSession) {
    private fun setStep(step: BuildStep, progress: Float? = null, agentId: String? = null) {
    private fun sync(error: String? = null) {
    private fun writeWinsize(session: BuildSession, columns: Int, rows: Int) {
    private suspend fun installAgent(agent: BuildAgent): Boolean = LinuxInstaller.packageLock.withLock {
    private suspend fun installDebian() {
    private suspend fun installInternal(agentIds: Set<String>, isActive: () -> Boolean) {
    private suspend fun pollOpenUrlFile(session: BuildSession) {
    private val _state = MutableStateFlow(KaiBuildState())
    private val installer = LinuxInstaller(paths)
    private val lastColumns = AtomicInteger(DEFAULT_COLUMNS)
    private val lastRows = AtomicInteger(DEFAULT_ROWS)
    private val paths: LinuxPaths,
    private val reapJobs = HashMap<String, Job>()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val screen = TerminalScreen(columns, rows)
    private val screenLock = Any()
    private val sessionCounter = AtomicInteger()
    private val sessions = LinkedHashMap<String, BuildSession>()
    private val sessionsLock = Any()
    private var activeSessionId: String? = null
    private var foregroundProject: String? = null
    private var installJob: Job? = null
    return hasBinary(binary)
    return total
    rows: Int,
    runCatching {
    val agentId: String?,
    val columns = AtomicInteger(columns)
    val id: String,
    val number: Int,
    val openUrlFile: String get() = "kai-open-url-$id"
    val pidFile: String get() = "kai-pid-$id"
    val project: String,
    val rows = AtomicInteger(rows)
    val state: StateFlow<KaiBuildState> = _state.asStateFlow()
    val winsizeFile: String get() = "kai-winsize-$id"
    var busy: Boolean = true
    var handle: ProotHandle? = null
    var hyperlinkClearJob: Job? = null
    var job: Job? = null
    var lastDeviceCode: String? = null
    var onEnvironmentChanged: (() -> Unit)? = null
    var snapshot: TerminalSnapshot = TerminalSnapshot.blank()
    var total = 0L
    }
 *
 * (or the newline) splits one long OAuth URL into many partial matches.
 * - Claude: `~/.local/bin/claude` → `~/.local/share/claude/versions/<ver>`
 * - Grok: `~/.grok/bin/grok`
 * - OpenCode: `~/.opencode/bin/opencode`
 * How long a project's shells keep running after the user steps out of it. Long
 * Kai Build. Process-scoped: held by the Koin-managed AndroidKaiBuildController.
 * Known layouts:
 * LXC rootfs contains link loops that would trap a naive recursive walk.
 * Like [visibleText] but trims trailing spaces on each row and joins without
 * One live PTY session: its own VT screen, geometry, and capture files. Several
 * Owns the Debian rootfs, agent installs, and the project terminal sessions for
 * Total size of the regular files under [dir], without following symlinks — an
 * True when [binary] is reachable. Always tries to place a stable symlink in
 * `/root/.local/bin` (even when already on the probe PATH) so login shells that
 * can run at once, which is what the terminal's session tabs switch between.
 * enough that leaving a build to read something else, or to work in another
 * newlines. Terminal wrap pads the rest of the line with spaces; keeping those
 * only keep a subset of vendor dirs still find every agent by name.
 * project, never costs the session; short enough that a phone is not holding a
 * proot process per project the user has forgotten about.
 */
) {
/**
/** Captured login / OSC 8 links leave the bar after this (matches the UI hide). */
/** Device-code pattern shown on Grok's login TUI (e.g. PNX4-ZGCX). */
/** Floor on the gap between two terminal repaints — roughly one display frame. */
class BuildEnvironmentManager(
import android.os.StatFs
import android.util.Log
import com.inspiredandroid.kai.build.BuildAgent
import com.inspiredandroid.kai.build.BuildAgents
import com.inspiredandroid.kai.build.BuildEnvironmentState
import com.inspiredandroid.kai.build.BuildStep
import com.inspiredandroid.kai.build.BuildSystemInfo
import com.inspiredandroid.kai.build.BuildTerminalSession
import com.inspiredandroid.kai.build.KaiBuildState
import com.inspiredandroid.kai.build.terminal.DEFAULT_COLUMNS
import com.inspiredandroid.kai.build.terminal.DEFAULT_ROWS
import com.inspiredandroid.kai.build.terminal.MAX_COLUMNS
import com.inspiredandroid.kai.build.terminal.MAX_ROWS
import com.inspiredandroid.kai.build.terminal.MIN_COLUMNS
import com.inspiredandroid.kai.build.terminal.MIN_ROWS
import com.inspiredandroid.kai.build.terminal.TerminalScreen
import com.inspiredandroid.kai.build.terminal.TerminalSnapshot
import com.inspiredandroid.kai.linux.DEFAULT_GUEST_PATH
import com.inspiredandroid.kai.linux.DebianSpec
import com.inspiredandroid.kai.linux.InstallStep
import com.inspiredandroid.kai.linux.LinuxDistro
import com.inspiredandroid.kai.linux.LinuxInstaller
import com.inspiredandroid.kai.linux.LinuxPaths
import com.inspiredandroid.kai.linux.ProotHandle
import com.inspiredandroid.kai.linux.ProotLauncher
import java.io.File
import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.withLock
package com.inspiredandroid.kai.build.runtime
private class BuildSession(
private const val HYPERLINK_TTL_MS = 2 * 60 * 1000L
private const val IDLE_PROJECT_TTL_MS = 60 * 60 * 1000L
private const val REPAINT_INTERVAL_MS = 16L
private const val TAG = "KaiBuild"
private fun BuildProotExecutor.ensureAgentBinary(binary: String): Boolean {
private fun BuildProotExecutor.hasBinary(binary: String): Boolean =
private fun directorySize(dir: File): Long {
private fun visibleText(snap: TerminalSnapshot): String =
private fun visibleTextForUrlScan(snap: TerminalSnapshot): String =
private val DEVICE_CODE_REGEX = Regex("""\b([A-Z0-9]{4}-[A-Z0-9]{4})\b""")
private val INVALID_NAME_CHARS = Regex("[^A-Za-z0-9._-]+")
}
