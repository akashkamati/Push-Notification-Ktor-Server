package com.akash.model

import kotlinx.serialization.Serializable


@Serializable
data class Response(
    val status: String,
    val detail: NotificationDetail?
)

