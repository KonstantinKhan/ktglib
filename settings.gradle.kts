rootProject.name = "ktglib"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
    }

}

include("ktglib-types")
