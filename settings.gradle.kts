rootProject.name = "ktglib"

pluginManagement {
    val kotlinVersion: String by settings
    val ktorVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("io.ktor.plugin") version ktorVersion

    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include("ktglib-types")
include("ktglib-bot")
include("ktglib-app")
