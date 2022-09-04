import kotlinx.serialization.Serializable

@Serializable
data class AlbumListItem(val name: String, val year: String) {
    val id: Int = name.hashCode()

    companion object {
        const val path = "/albumList"
    }
}