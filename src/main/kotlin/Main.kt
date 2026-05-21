import co.touchlab.kermit.Logger

fun main() {
    // 1. Ініціалізуємо логер
    val logger = Logger.withTag("CyberTaxi_Lab2")

    // 2. Ініціалізуємо наш клас
    val timeManager: TimeManager = TimeManagerImpl()

    // 3. Використовуємо логування замість звичайного println
    logger.i { "Додаток успішно запущено" }
    logger.d { "Поточна часова зона системи: ${timeManager.getCurrentTimeZone()}" }
    logger.i { "Зафіксований час операції: ${timeManager.getCurrentDateTime()}" }
}