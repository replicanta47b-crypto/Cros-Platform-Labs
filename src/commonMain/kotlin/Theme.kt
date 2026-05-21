import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// 1. Кольори [cite: 26]
val CyberYellow = Color(0xFFFCEE0A)
val CyberDark = Color(0xFF121212)
val CyberCyan = Color(0xFF00F0FF)

private val CyberpunkColors = darkColors(
    primary = CyberYellow,
    primaryVariant = CyberCyan,
    background = CyberDark,
    surface = Color(0xFF1E1E1E),
    onPrimary = CyberDark,
    onBackground = CyberYellow
)

// 2. Шрифти [cite: 27]
val CyberTypography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)

// 3. Будівельник теми [cite: 25]
@Composable
fun CyberTaxiTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = CyberpunkColors,
        typography = CyberTypography,
        content = content
    )
}