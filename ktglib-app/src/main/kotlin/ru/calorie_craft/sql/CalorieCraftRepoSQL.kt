package ru.calorie_craft.sql

import org.jetbrains.exposed.sql.insertIgnore
import org.jetbrains.exposed.sql.transactions.transaction
import ru.ktglib.types.User

class CalorieCraftRepoSQL(
    url: String,
    driver: String,
    user: String,
    password: String,
) {
    private val db = SQLConnector(url, driver, user, password).connect(TgUsers)

    init {
        transaction(db) {
            save(User(userId = 1234, isBot = false, firstName = "first", lastName = "last", username = "user"))
        }
    }

    fun save(user: User) {
        transaction(db) {
            TgUsers.insertIgnore {
                it[id] = user.userId
                it[firstName] = user.firstName
                it[lastName] = user.lastName
                it[userName] = user.username
            }
        }

    }
}