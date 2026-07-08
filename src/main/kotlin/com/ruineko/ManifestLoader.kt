package com.ruineko

import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Path

private val json = Json { ignoreUnknownKeys = true }

fun loadManifest(path: Path): Manifest {
    return json.decodeFromString<Manifest>(Files.readString(path))
}