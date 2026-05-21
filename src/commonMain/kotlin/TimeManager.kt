import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// Очікувана функція для різних платформ
expect fun getSystemTimeZoneId(): String

interface TimeManager {
    fun getCurrentDateTime(): String
    fun getCurrentTimeZone(): String
    fun getAllTimeZones(): List<String>
}

class TimeManagerImpl : TimeManager {
    override fun getCurrentTimeZone(): String {
        // Викликаємо нашу expect функцію
        return getSystemTimeZoneId()
    }

    override fun getCurrentDateTime(): String {
        val currentMoment = Clock.System.now()
        val timeZone = TimeZone.currentSystemDefault()
        return currentMoment.toLocalDateTime(timeZone).toString()
    }

    override fun getAllTimeZones(): List<String> {
        return TimeZone.availableZoneIds.toList()
    }
}