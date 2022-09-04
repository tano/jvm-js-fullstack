import kotlinx.serialization.Serializable

@Serializable
data class AlbumListItem(var name: String, var year: String) {
    val id: Int = name.hashCode()

    companion object {
        const val path = "/albumList"
    }
}