import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class Bot(baseUrl: String) {
    private val client: HttpClient = HttpClient(CIO) {
        defaultRequest {
            url(baseUrl)
            contentType(ContentType.Application.Json)
        }
    }

    suspend fun sendMessage(message: String) {
        client.post("sendMessage") {
            setBody(message)
        }.bodyAsText()
    }
}