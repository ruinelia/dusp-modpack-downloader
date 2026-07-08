package com.ruineko

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

private const val MAX_RETRIES = 3
private val client = OkHttpClient()

fun download(url: String, output: Path) {
    repeat(MAX_RETRIES) { attempt ->
        try {
            download0(url, output)
            return
        } catch (e: Exception) {
            if (attempt == MAX_RETRIES - 1) {
                throw e
            }

            Thread.sleep(1000L * (attempt + 1))
        }
    }
}

private fun download0(url: String, output: Path) {
    val request = Request.Builder()
        .url(normalizeUrl(url))
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            throw IOException("HTTP ${response.code}")
        }

        response.body.byteStream().use { input ->
            Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING)
        }
    }
}