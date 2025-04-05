plugins {
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false
    id("io.ktor.plugin") apply false
}

group = "ru.ktglib"
version = "0.0.1"

subprojects {
    group = rootProject.group
    version = rootProject.version
    repositories {
        mavenCentral()
    }
}