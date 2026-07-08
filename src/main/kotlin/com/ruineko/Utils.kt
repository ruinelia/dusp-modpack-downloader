package com.ruineko

import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest

fun formatSize(bytes: Long): String {
    val units = listOf("B", "KiB", "MiB", "GiB", "TiB")

    var size = bytes.toDouble()
    var unit = 0

    while (size >= 1024 && unit < units.lastIndex) {
        size /= 1024
        unit++
    }

    return if (unit == 0) {
        "${size.toLong()} ${units[unit]}"
    } else {
        "%.2f %s".format(size, units[unit])
    }
}

fun sha1(path: Path): String {
    val digest = MessageDigest.getInstance("SHA-1")

    Files.newInputStream(path).use { input ->
        val buffer = ByteArray(8192)

        while (true) {
            val read = input.read(buffer)
            if (read == -1) {
                break
            }

            digest.update(buffer, 0, read)
        }
    }

    return digest.digest().joinToString("") { "%02x".format(it) }
}

private val githubUrlRegex = Regex("""^https://raw\.githubusercontent\.com/([^/]+)/([^/]+)/(?:refs/(?:heads|tags)/)?([^/]+)/(.*)$""")

fun normalizeUrl(url: String): String {
    val match = githubUrlRegex.matchEntire(url) ?: return url
    val (owner, repo, ref, path) = match.destructured

    return "https://cdn.jsdelivr.net/gh/$owner/$repo@$ref/$path"
}