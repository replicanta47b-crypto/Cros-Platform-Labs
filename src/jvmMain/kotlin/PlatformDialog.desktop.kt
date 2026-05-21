import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window

// Реалізація (actual) спеціально для Desktop
actual @Composable
fun PlatformDialog(
    show: Boolean,
    title: String,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    if (show) {
        Window(
            onCloseRequest = onDismiss,
            title = title
        ) {
            content()
        }
    }
}