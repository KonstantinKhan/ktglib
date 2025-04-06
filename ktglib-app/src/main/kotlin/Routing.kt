package ru

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import ru.ktglib.types.update.UpdateWithMessage

private val json: Json by lazy {
    Json {
        prettyPrint = true
    }
}

fun Application.configureRouting() {
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
                call.respondText("ok")
            } catch (e: Error) {
                println(e.message)
                call.respondText("error")
            }
        }
    }
}
