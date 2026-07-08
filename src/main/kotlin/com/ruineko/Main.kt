package com.ruineko

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.atomic.AtomicInteger

private const val DEFAULT_MANIFEST_URL = "https://raw.githubusercontent.com/DemoVPS69420/modpacklauncherupdater/main/manifest.json"
private const val DOWNLOAD_THREADS = 8

fun main() = runBlocking {
    print("Manifest URL (leave blank for default)\n> ")
    val manifestUrl = readln().ifBlank {
        println(":: Using default manifest URL: ${normalizeUrl(DEFAULT_MANIFEST_URL)}")
        DEFAULT_MANIFEST_URL
    }

    val jarDirectory = Paths.get(object {}.javaClass.protectionDomain.codeSource.location.toURI()).parent

    print("Install Path (leave blank to use current directory)\n> ")
    val installPathInput = readln()
    val installPath = if (installPathInput.isBlank()) {
        println(":: Using current directory as install path.")
        jarDirectory
    } else Paths.get(installPathInput)

    Files.createDirectories(installPath)

    val manifestPath = installPath.resolve("manifest.json")
    println(":: Downloading manifest...")
    download(manifestUrl, manifestPath)

    val manifest = loadManifest(manifestPath)

    val totalSize = manifest.files.sumOf { it.size }

    println()
    println("Information about the modpack to be installed.")
    println("Name      :: ${manifest.name}")
    println("Version   :: ${manifest.version}")
    println("Minecraft :: ${manifest.minecraft}")
    println("Loader    :: ${manifest.loader.type} ${manifest.loader.version}")
    println("Files     :: ${manifest.files.size}")
    println("Size      :: ${formatSize(totalSize)}")
    println()

    println("Please ensure you have a stable internet connection, as this installer downloads multiple files in parallel using $DOWNLOAD_THREADS thread(s).")
    print("Proceed with installation? [Y/n] (default: Y)\n> ")

    when (readln().trim().lowercase()) {
        "", "y", "yes" -> Unit
        else -> {
            println()
            println(":: Installation aborted.")
            return@runBlocking
        }
    }

    println()
    println(":: Starting installation...")
    println()

    val semaphore = Semaphore(DOWNLOAD_THREADS)
    val completed = AtomicInteger()
    val success = AtomicInteger()
    val failed = AtomicInteger()
    val skipped = AtomicInteger()

    coroutineScope {
        manifest.files.map { file ->
            launch(Dispatchers.IO) {
                semaphore.withPermit {
                    val output = installPath.resolve(file.path)
                    Files.createDirectories(output.parent)

                    val status = try {
                        if (Files.exists(output) &&
                            Files.size(output) == file.size &&
                            sha1(output).equals(file.sha1, ignoreCase = true)
                        ) {
                            skipped.incrementAndGet()
                            "Already downloaded"
                        } else {
                            download(file.url, output)
                            success.incrementAndGet()
                            "Downloaded"
                        }
                    } catch (e: Exception) {
                        failed.incrementAndGet()
                        "Failed (${e.message})"
                    }

                    val done = completed.incrementAndGet()

                    synchronized(System.out) {
                        println("[#$done/${manifest.files.size}] " + "$status :: ${file.path} (${formatSize(file.size)})")
                    }
                }
            }
        }.joinAll()
    }

    println()
    println(":: Installation completed.")
    println()
    println("Downloaded : ${success.get()}")
    println("Skipped    : ${skipped.get()}")
    println("Failed     : ${failed.get()}")
    println("Total      : ${completed.get()}")
}