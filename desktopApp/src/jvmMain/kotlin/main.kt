import androidx.compose.ui.window.Window // ktlint-disable filename
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainView()
    }
}
