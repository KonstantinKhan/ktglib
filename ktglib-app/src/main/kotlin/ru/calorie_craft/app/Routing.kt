package ru.calorie_craft.app

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import ru.ktglib.types.User
import ru.ktglib.types.update.UpdateWithMessage

private val json: Json by lazy {
    Json {
        prettyPrint = true
    }
}

fun Application.configureRouting(config: AppKtorConfig) {
    routing {
        get("/") {
            println("call get /")
            call.respondText("Hello World!")
        }
        post("/") {
            println("call post /")
            try {
                println("try")
                val data = call.receive<UpdateWithMessage>()
                println(
                    "data: ${
                        json
                            .encodeToString(data)
                    }"
                )
                try {
                    config.db.save(
                        User(
                            userId = data.message.from.userId,
                            isBot = data.message.from.isBot,
                            firstName = data.message.from.firstName,
                            lastName = data.message.from.lastName,
                            username = data.message.from.username
                        )
                    )
                    config.sender.sendMessage(data.message.from.userId,
                        "Мы пилим приложение, чтобы Вы наслаждались процессом своего преображения!")
                } catch (e: Error) {
                    println("error: $e")
                }
                call.respondText("ok")
            } catch (e: Error) {
                println(e.message)
                call.respondText("error")
            }
        }
    }
}
