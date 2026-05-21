import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Timezone App") {
        // Ініціалізуємо клас із даними
        val timeManager = TimeManagerImpl()

        // Передаємо його в головний екран Compose
        TimezoneAppScreen(timeManager)
    }
}