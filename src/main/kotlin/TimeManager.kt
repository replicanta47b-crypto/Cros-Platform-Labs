import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

interface TimeManager {
    fun getCurrentDateTime(): String
    fun getCurrentTimeZone(): String
    fun getAllTimeZones(): List<String> // Новий метод
}

class TimeManagerImpl : TimeManager {
    override fun getCurrentTimeZone(): String {
        return TimeZone.currentSystemDefault().id
    }

    override fun getCurrentDateTime(): String {
        val currentMoment = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        return currentMoment.toLocalDateTime(timeZone).toString()
    }

    override fun getAllTimeZones(): List<String> {
        // Повертаємо список усіх доступних часових зон
        return TimeZone.availableZoneIds.toList()
    }
}