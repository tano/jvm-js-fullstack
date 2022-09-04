import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*


val jsonClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}

suspend fun getList(): List<AlbumListItem> {
    return jsonClient.get(AlbumListItem.path).body()
}

suspend fun addListItem(albumListItem: AlbumListItem) {
    jsonClient.post( AlbumListItem.path) {
        contentType(ContentType.Application.Json)
        setBody(albumListItem)
    }
}

suspend fun deleteItem(albumListItem: AlbumListItem) {
    jsonClient.delete(AlbumListItem.path + "/${albumListItem.id}")
}