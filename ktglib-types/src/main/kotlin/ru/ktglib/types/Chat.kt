package ru.ktglib.types

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Chat(
    @SerialName("id")
    val id: Long
)
