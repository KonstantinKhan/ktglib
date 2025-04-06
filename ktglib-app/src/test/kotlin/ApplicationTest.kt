package ru

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import ru.calorie_craft.app.module
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
        }
    }

}
