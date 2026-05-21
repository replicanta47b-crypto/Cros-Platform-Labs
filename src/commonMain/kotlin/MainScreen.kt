import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    CyberTaxiTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") { MainScreen(navController) }

            // Заглушки для всіх 10 екранів
            composable("buttons") { ComponentScreen("Buttons") }
            composable("checkboxes") { ComponentScreen("Checkboxes") }
            composable("chips") { ComponentScreen("Chips") }
            composable("datepicker") { ComponentScreen("Datepicker dialog") }
            composable("dialog") { ComponentScreen("Dialog") }
            composable("divider") { ComponentScreen("Divider") }
            composable("progressbar") { ComponentScreen("Progress bar") }
            composable("radiobuttons") { ComponentScreen("Radio buttons") }
            composable("switch") { ComponentScreen("Switch") }
            composable("timepicker") { ComponentScreen("Timepicker dialog") }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("CYBER TAXI: КОМПОНЕНТИ", style = androidx.compose.material.MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(20.dp))

        // Кнопки навігації [cite: 30]
        val routes = listOf(
            "buttons" to "Buttons", "checkboxes" to "Checkboxes", "chips" to "Chips",
            "datepicker" to "Datepicker dialog", "dialog" to "Dialog", "divider" to "Divider",
            "progressbar" to "Progress bar", "radiobuttons" to "Radio buttons",
            "switch" to "Switch", "timepicker" to "Timepicker dialog"
        )

        routes.forEach { (route, label) ->
            Button(
                onClick = { navController.navigate(route) },
                modifier = Modifier.fillMaxWidth().padding(4.dp)
            ) {
                Text(label)
            }
        }
    }
}

// Універсальний екран-заглушка для демонстрації
@Composable
fun ComponentScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Екран компонента: $title", style = androidx.compose.material.MaterialTheme.typography.h1)
    }
}