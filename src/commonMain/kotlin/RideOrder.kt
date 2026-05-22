import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// Data class у Kotlin автоматично створює гетери, сетери та toString()
data class RideOrder(
    val id: Int,
    val passengerName: String,
    val destination: String,
    val price: Double
) {
    // Фіксуємо час створення через кросплатформний kotlinx-datetime
    val orderTime: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}