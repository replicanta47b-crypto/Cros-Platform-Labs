import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// Інтерфейс для роботи з датою, часом і зонами
interface TimeManager {
    fun getCurrentDateTime(): String
    fun getCurrentTimeZone(): String
}

// Клас, який імплементує інтерфейс
class TimeManagerImpl : TimeManager {

    override fun getCurrentTimeZone(): String {
        // Отримуємо поточну зону часу системи
        return TimeZone.currentSystemDefault().id
    }

    override fun getCurrentDateTime(): String {
        // Отримуємо поточний момент і переводимо його в локальний час
        val currentMoment = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        val localDateTime = currentMoment.toLocalDateTime(timeZone)

        return localDateTime.toString()
    }
}