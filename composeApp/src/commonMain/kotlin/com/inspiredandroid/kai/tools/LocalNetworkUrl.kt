package com.inspiredandroid.kai.tools

            (first == 169 && second == 254)
            (first == 172 && second in 16..31) ||
            (first == 192 && second == 168) ||
            host.startsWith("fc") || host.startsWith("fd")
            host.startsWith("fea") || host.startsWith("feb") ||
        authority.substringAfter("[").substringBefore("]")
        authority.substringBefore(":")
        return first == 10 ||
        return host.startsWith("fe8") || host.startsWith("fe9") ||
        val first = octets[0]
        val second = octets[1]
    // IPv6 link-local and unique-local addresses.
    // Loopback isn't gated by local network protection.
    // Private and link-local IPv4 ranges.
    // mDNS names and bare hostnames resolve on the local network.
    if (host == "localhost" || host == "::1" || host.startsWith("127.")) return false
    if (host.contains(":")) {
    if (host.isEmpty()) return false
    if (octets.size == 4 && octets.all { it in 0..255 }) {
    if (url.isBlank()) return false
    return host.endsWith(".local") || !host.contains(".")
    val afterScheme = url.substringAfter("://")
    val authority = afterScheme.substringBefore("/").substringAfterLast("@").lowercase()
    val host = if (authority.startsWith("[")) {
    val octets = host.split(".").mapNotNull { it.toIntOrNull() }
    }
    } else {
 * True if the URL points at a host on the local network — the traffic Android's local network
 * names that happen to resolve to LAN addresses can't be detected without resolving them; those
 * protection gates. Loopback stays false: it never leaves the device and isn't gated. Public DNS
 * still fail with a plain connection error.
 */
/**
fun isLocalNetworkUrl(url: String): Boolean {
}
