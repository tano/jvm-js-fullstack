import csstype.px
import emotion.react.css
import org.w3c.dom.HTMLFormElement
import react.*
import org.w3c.dom.HTMLInputElement
import react.dom.events.ChangeEventHandler
import react.dom.events.FormEventHandler
import react.dom.html.ButtonType
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.form
import react.dom.html.ReactHTML.input

external interface InputProps : Props {
    var onSubmit: (AlbumListItem) -> Unit
}

val inputComponent = FC<InputProps> { props ->
    val (item, setItem) = useState(AlbumListItem("", ""))

    val submitHandler: FormEventHandler<HTMLFormElement> = {
        it.preventDefault()
        setItem(AlbumListItem("", ""))
        props.onSubmit(item)
    }

    val changeItemNameHandler: ChangeEventHandler<HTMLInputElement> = {
        setItem(AlbumListItem(it.target.value, item.year))
    }

    val changeItemYearHandler: ChangeEventHandler<HTMLInputElement> = {
        setItem(AlbumListItem(item.name, it.target.value))
    }

    form {
        onSubmit = submitHandler
        div {
            input {
                type = InputType.text
                onChange = changeItemNameHandler
                value = item.name
                placeholder = "Название"
            }
            input {
                type = InputType.text
                onChange = changeItemYearHandler
                value = item.year
                placeholder = "Год выпуска"
            }
            css {
                marginBottom = 5.px
            }
        }
        button {
            type = ButtonType.submit
            name = "Добавить"
            +"Добавить"
        }
    }
}