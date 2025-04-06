val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/io.ktor/ktor-server-content-negotiation-jvm
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-server-core
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-serialization-kotlinx-json
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-server-cors
    implementation("io.ktor:ktor-server-cors:$ktorVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-server-netty
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    // https://mvnrepository.com/artifact/io.ktor/ktor-server-config-yaml-jvm
    implementation("io.ktor:ktor-server-config-yaml:$ktorVersion")

    implementation(project(":ktglib-types"))

    // https://mvnrepository.com/artifact/io.ktor/ktor-server-test-host
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
    testImplementation(kotlin("test"))
}
