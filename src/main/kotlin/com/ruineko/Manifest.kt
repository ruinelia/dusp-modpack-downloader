package com.ruineko

import kotlinx.serialization.Serializable

@Serializable
data class Manifest(
    val name: String,
    val version: String,
    val minecraft: String,
    val loader: Loader,
    val files: List<ManifestFile>
)

@Serializable
data class ManifestFile(
    val path: String,
    val url: String,
    val sha1: String,
    val size: Long,
    val once: Boolean = false,
    val optional: Boolean = false
)

@Serializable
data class Loader(
    val type: String,
    val version: String
)