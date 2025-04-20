package ru.calorie_craft.sql

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

class SQLConnector(
    private val url: String,
    private val driver: String,
    private val user: String,
    private val password: String
) {
    fun connect(vararg tables: Table): Database {
        val connect = Database.connect(url, driver, user, password)
        transaction(connect) {
            SchemaUtils.create(*tables)
        }
        return connect
    }
}