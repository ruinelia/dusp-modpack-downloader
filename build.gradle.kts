plugins {
    kotlin("jvm") version "2.3.20"
    kotlin("plugin.serialization") version "2.3.20"
    id("com.gradleup.shadow") version "9.2.2"
}

group = "com.ruineko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
}

kotlin {
    jvmToolchain(17)
}

tasks.shadowJar {
    archiveClassifier.set("")
    archiveVersion.set("")
    archiveBaseName.set("installer")

    manifest {
        attributes["Main-Class"] = "com.ruineko.MainKt"
    }
}