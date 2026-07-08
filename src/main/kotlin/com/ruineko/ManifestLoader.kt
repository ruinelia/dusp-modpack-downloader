package com.ruineko

import kotlinx.serialization.json.Json

private val json = Json { ignoreUnknownKeys = true }

fun loadManifest(string: String): Manifest {
    return json.decodeFromString<Manifest>(string)
}