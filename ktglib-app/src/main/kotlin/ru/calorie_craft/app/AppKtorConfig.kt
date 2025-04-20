package ru.calorie_craft.app

import io.ktor.server.application.*
import ru.calorie_craft.sql.CalorieCraftRepoSQL
import ru.ktglib.bot.Bot

class AppKtorConfig(
    val sender: Bot = Bot(""),
    val db: CalorieCraftRepoSQL = CalorieCraftRepoSQL(
        url = "",
        driver = "",
        user = "",
        password = ""
    )
) {
    internal constructor(environment: ApplicationEnvironment) : this(
        sender = Bot(
            environment.config.property("ktor.url").getString()
        ),
        db = CalorieCraftRepoSQL(
            url = environment.config.property("ktor.jdbc").getString(),
            driver = environment.config.property("ktor.driver").getString(),
            user = environment.config.property("ktor.user_db").getString(),
            password = environment.config.property("ktor.password_db").getString()
        )
    )
}
