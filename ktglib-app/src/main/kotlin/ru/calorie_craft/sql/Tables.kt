package ru.calorie_craft.sql

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object TgUsers: Table("tg_users") {
    val id = long("id")
    val firstName = varchar("first_name", 128)
    val lastName: Column<String?> = varchar("last_name", 128).nullable()
    val userName: Column<String?> = varchar("user_name", 128).nullable()
    override val primaryKey = PrimaryKey(id)
}