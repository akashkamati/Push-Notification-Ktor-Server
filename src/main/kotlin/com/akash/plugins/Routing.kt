package com.akash.plugins

import com.akash.firebase.sendMessaging
import com.akash.model.NotificationDetail
import com.akash.model.Response
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        post ("/send"){
            val notificationDetail = call.receive<NotificationDetail>()
            val status = sendMessaging(notificationDetail)
            val response = Response(
                status = status,
                detail = if (status == "success") notificationDetail else null
            )
            call.respond(response)
        }
    }
}
