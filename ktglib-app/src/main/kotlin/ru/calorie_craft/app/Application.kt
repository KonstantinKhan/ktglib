package ru.calorie_craft.app

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module(
    config: AppKtorConfig = AppKtorConfig(environment)
) {
    configureSerialization()
    configureHTTP()
    configureRouting(config)
}
