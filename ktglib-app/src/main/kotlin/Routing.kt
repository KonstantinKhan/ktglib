package ru

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            println("call get /")
            call.respondText("Hello World!")
        }
        post("/") {
            println("call post /")
        }
    }
}
