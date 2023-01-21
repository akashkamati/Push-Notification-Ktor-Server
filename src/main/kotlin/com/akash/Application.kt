package com.akash

import com.akash.firebase.FirebaseAdmin
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.akash.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.100.26", module = Application::module)
        .start(wait = true)

}

fun Application.module() {
    FirebaseAdmin.init()
    configureRouting()
    configureSerialization()
}
