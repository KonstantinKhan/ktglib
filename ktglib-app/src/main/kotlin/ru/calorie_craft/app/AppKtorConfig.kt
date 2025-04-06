package ru.calorie_craft.app

import io.ktor.server.application.*
import ru.ktglib.bot.Bot

class AppKtorConfig(
    val sender: Bot = Bot("")
) {
    internal constructor(environment: ApplicationEnvironment) : this(
        sender = Bot(
            environment.config.property("ktor.url").getString()
        )
    )
}
