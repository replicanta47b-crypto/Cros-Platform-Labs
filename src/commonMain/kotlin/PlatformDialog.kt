import androidx.compose.runtime.Composable

// Оголошуємо очікувану функцію (expect) для всіх платформ
expect @Composable
fun PlatformDialog(
    show: Boolean,
    title: String,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
)