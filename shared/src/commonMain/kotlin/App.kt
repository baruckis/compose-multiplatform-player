import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalAnimationApi::class)
@Composable
fun App() {
    MaterialTheme(colors = darkColors()) {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showContent by remember { mutableStateOf(false) }
        var showPlayer by remember { mutableStateOf(false) }
        Scaffold {
            // your content
            Column(
                modifier = Modifier.background(Color.Black).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = {
                    greetingText = "Hello, ${getPlatformName()}"
                    showContent = !showContent
                    if (!showContent) {
                        showPlayer = false
                    }
                }) {
                    Text(greetingText)
                }
                AnimatedVisibility(showContent) {
                    if (this.transition.currentState == this.transition.targetState && showContent && !showPlayer) {
                        showPlayer = true
                    }
                    Column {
                        Image(
                            painter = painterResource("compose-multiplatform.xml"),
                            null,
                            modifier = Modifier.fillMaxWidth().height(100.dp),
                        )
                        if (showPlayer) {
                            Player(
                                modifier = Modifier.fillMaxWidth().height(400.dp),
                                url =
                                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                            )
                        }
                    }
                }
            }
        }
    }
}

expect fun getPlatformName(): String
