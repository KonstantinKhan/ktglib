plugins {
    kotlin("jvm") apply false
}

group = "ru.ktglib"
version = "1.0-SNAPSHOT"

subprojects {
    group = rootProject.group
    version = rootProject.version
    repositories {
        mavenCentral()
    }
}