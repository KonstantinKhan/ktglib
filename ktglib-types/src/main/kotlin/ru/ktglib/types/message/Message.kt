package ru.ktglib.types.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ktglib.types.User

@Serializable
class Message(
    @SerialName("message_id")
    val messageId: Int,
    @SerialName("text")
    val text: String,
    @SerialName("from")
    val from: User
)