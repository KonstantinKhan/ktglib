package ru.calorie_craft.app

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import ru.calorie_craft.app.AppKtorConfig
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
                    config.sender.sendMessage(data.message.from.userId,"Hi!")
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
