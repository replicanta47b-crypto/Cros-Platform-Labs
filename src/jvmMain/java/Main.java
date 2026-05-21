import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Вітаємо в терміналі управління Cyber Taxi!");

        while (isRunning) {
            System.out.println("\n--- Головне меню ---");
            System.out.println("1. Створення замовлення");
            System.out.println("2. Зчитування (показати всі замовлення)");
            System.out.println("3. Оновлення замовлення");
            System.out.println("4. Видалення замовлення");
            System.out.println("5. Пошук");
            System.out.println("6. Сортування");
            System.out.println("0. Вихід");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("[Система]: Логіка створення замовлення...");
                    break;
                case "2":
                    System.out.println("[Система]: Виведення списку поїздок...");
                    break;
                case "3":
                    System.out.println("[Система]: Логіка оновлення даних...");
                    break;
                case "4":
                    System.out.println("[Система]: Логіка видалення...");
                    break;
                case "5":
                    System.out.println("[Система]: Пошук за параметрами...");
                    break;
                case "6":
                    System.out.println("[Система]: Сортування замовлень...");
                    break;
                case "0":
                    System.out.println("[Система]: Завершення роботи. До зустрічі!");
                    isRunning = false; // Вихід з циклу
                    break;
                default:
                    System.out.println("[Помилка]: Невідома команда. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}