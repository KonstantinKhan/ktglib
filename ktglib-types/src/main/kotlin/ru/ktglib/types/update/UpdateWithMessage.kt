package ru.ktglib.types.update

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.ktglib.types.message.Message

@Serializable
data class UpdateWithMessage(
    @SerialName("update_id")
    val updatedId: Int,
    @SerialName("message")
    val message: Message
) {
}