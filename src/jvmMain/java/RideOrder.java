import java.time.LocalDateTime;

public class RideOrder {
    private int id;
    private String passengerName;
    private String destination;
    private double price;
    private LocalDateTime orderTime; // Обов'язкове поле дати та часу

    public RideOrder(int id, String passengerName, String destination, double price) {
        this.id = id;
        this.passengerName = passengerName;
        this.destination = destination;
        this.price = price;
        this.orderTime = LocalDateTime.now(); // Автоматично фіксуємо час створення
    }

    // Гетери та сетери
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public LocalDateTime getOrderTime() { return orderTime; }

    @Override
    public String toString() {
        return "Замовлення #" + id +
                " | Пасажир: " + passengerName +
                " | Пункт призначення: " + destination +
                " | Ціна: ₴" + price +
                " | Час: " + orderTime;
    }
}