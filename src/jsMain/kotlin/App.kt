import react.*
import kotlinx.coroutines.*
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul

private val scope = MainScope()

val App = FC<Props> {
    var albumList by useState(emptyList<AlbumListItem>())

    useEffectOnce {
        scope.launch {
            albumList = getList()
        }
    }

    h1 {
        +"Full-Stack Album List"
    }
    ul {
        albumList.sortedByDescending(AlbumListItem::name).forEach { item ->
            li {
                key = item.toString()
                onClick = {
                    scope.launch {
                        deleteItem(item)
                        albumList = getList()
                    }
                }
                +"[Альбом: ${item.name}, год выпуска: ${item.year}]"
            }
        }
    }

    inputComponent {
        onSubmit = { input ->
            scope.launch {
                addListItem(input)
                albumList = getList()
            }
        }
    }
}