import kotlinx.datetime.TimeZone

// Реалізація для твоєї поточної програми
actual fun getSystemTimeZoneId(): String = TimeZone.currentSystemDefault().id