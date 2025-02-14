package com.trapezoid.app

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.cors.routing.*
//import io.ktor.server.plugins.compression.*

fun main() {
//    TODO: Fix auto-reload
    embeddedServer(Netty, port = SERVER_PORT, watchPaths = listOf("classes", "resources")) {
        install(CORS) {
            anyHost()
        }

        routing {
            get("/") {
                call.respondText("Hi: ${Greeting().greet()}")
            }
        }
    }.start(wait = true)
}