import androidx.compose.runtime.*
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    // Список для зберігання активних вікон
    var windowCount by remember { mutableStateOf(1) }
    val timeManager = TimeManagerImpl() // Твій клас із 4-ї лаби

    // Створюємо стільки вікон, скільки потрібно
    for (i in 0 until windowCount) {
        Window(
            onCloseRequest = {
                windowCount--
                if (windowCount == 0) exitApplication()
            },
            title = "Timezone App - Вікно ${i + 1}"
        ) {
            // Додаємо підтримку верхнього меню та гарячих клавіш
            MenuBar {
                Menu("Файл") {
                    Item(
                        "Нове вікно",
                        shortcut = KeyShortcut(Key.N, ctrl = true), // Гаряча клавіша Ctrl+N
                        onClick = { windowCount++ }
                    )
                    Item(
                        "Закрити вікно",
                        shortcut = KeyShortcut(Key.W, ctrl = true), // Гаряча клавіша Ctrl+W
                        onClick = { windowCount-- }
                    )
                    Separator()
                    Item(
                        "Вихід",
                        shortcut = KeyShortcut(Key.Q, ctrl = true),
                        onClick = { exitApplication() }
                    )
                }
            }

            // Виклик головного екрана
            TimezoneAppScreen(timeManager)
        }
    }
}