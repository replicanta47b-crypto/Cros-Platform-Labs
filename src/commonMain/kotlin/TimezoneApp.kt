import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimezoneAppScreen(timeManager: TimeManager) {
    var selectedTab by remember { mutableStateOf(0) }
    // Стан для збереження вибраних зон
    val selectedZones = remember { mutableStateListOf<String>() }

    Scaffold(
        bottomBar = {
            TabRow(selectedTabIndex = selectedTab) {
                Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("Часові зони") })
                Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("Зустріч") })
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            if (selectedTab == 0) {
                // Сторінка з часовими зонами [cite: 49]
                TimeZonesPage(timeManager, selectedZones)
            } else {
                // Сторінка пошуку часу зустрічі [cite: 50]
                MeetingPage(selectedZones)
            }
        }
    }
}

// --- СТОРІНКА 1: ЧАСОВІ ЗОНИ ---
@Composable
fun TimeZonesPage(timeManager: TimeManager, selectedZones: MutableList<String>) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            // Летюча кнопка [cite: 49]
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Додати зону")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            // Карточка користувача [cite: 49]
            Card(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), elevation = 4.dp) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Ваша часова зона:", style = MaterialTheme.typography.h6)
                    Text(timeManager.getCurrentTimeZone())
                }
            }

            Text("Вибрані зони:", style = MaterialTheme.typography.h6)
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(selectedZones) { zone ->
                    Text(zone, modifier = Modifier.padding(vertical = 8.dp))
                    Divider()
                }
            }
        }
    }

    // Діалог вибору зон [cite: 52]
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Виберіть часову зону") },
            text = {
                LazyColumn {
                    items(timeManager.getAllTimeZones()) { zone ->
                        TextButton(onClick = {
                            if (!selectedZones.contains(zone)) selectedZones.add(zone)
                            showDialog = false
                        }) { Text(zone) }
                    }
                }
            },
            confirmButton = { TextButton(onClick = { showDialog = false }) { Text("Закрити") } }
        )
    }
}

// --- СТОРІНКА 2: ЗУСТРІЧ ---
@Composable
fun MeetingPage(selectedZones: List<String>) {
    var startHour by remember { mutableStateOf("09:00") }
    var endHour by remember { mutableStateOf("17:00") }
    var showResultDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Пошук часу зустрічі", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))

        // Кастомні елементи вибору часу (текстові поля для простоти кросплатформності) [cite: 51]
        OutlinedTextField(value = startHour, onValueChange = { startHour = it }, label = { Text("Початок (ГГ:ХХ)") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = endHour, onValueChange = { endHour = it }, label = { Text("Кінець (ГГ:ХХ)") })
        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка пошуку [cite: 51]
        Button(onClick = { showResultDialog = true }, modifier = Modifier.fillMaxWidth()) {
            Text("Знайти спільний час")
        }
    }

    // Діалог результату [cite: 53]
    if (showResultDialog) {
        AlertDialog(
            onDismissRequest = { showResultDialog = false },
            title = { Text("Результат пошуку") },
            text = {
                val zonesText = if (selectedZones.isEmpty()) "Немає вибраних зон" else selectedZones.joinToString(", ")
                Text("Зустріч з $startHour до $endHour можлива для: $zonesText")
            },
            confirmButton = { TextButton(onClick = { showResultDialog = false }) { Text("ОК") } }
        )
    }
}