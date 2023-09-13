import androidx.compose.desktop.ui.tooling.preview.Preview // ktlint-disable filename
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

@Composable fun MainView() = App()

@Preview
@Composable
fun AppPreview() {
    App()
}
