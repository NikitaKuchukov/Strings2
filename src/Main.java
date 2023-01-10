import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1();
        task2();
//        task3();
    }

    public static void checkLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 > 0) || (year % 400 == 0)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    public static void task1() {
        System.out.println("Задача 1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = sc.nextInt();
        checkLeapYear(year);
    }

    public static void detectionVersionOS(int currentYear) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите год выпуска устройства:");
        int clientDeviceYear = sc.nextInt();
        int clientOS = 0;
        while (true) {
            System.out.println("Выберите тип ОС");
            System.out.println("0 - iOS");
            System.out.println("1 - Android");
            clientOS = sc.nextInt();
            if (clientOS == 0 || clientOS == 1) {
                break;
            }
            System.out.println("Некорректный ввод. Введите значение 0 или 1");
        }
        if (clientOS == 0 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (clientOS == 0 && clientDeviceYear == currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    public static void task2() {
        System.out.println("Задача 2");
        int currentYear = LocalDate.now().getYear();
        detectionVersionOS(currentYear);
    }

    public static int checkDeliveryTime(int deliveryDistance) {
        int day = 0;
        if (deliveryDistance <= 20) {
            day = day + 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            day = day + 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            day = day + 3;
        } else {
            day = -1;
        }
        return day;
    }

    public static void task3() {
        System.out.println("Задача 3");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите расстояние:");
        int deliveryDistance = sc.nextInt();
        checkDeliveryTime(deliveryDistance);
        if (checkDeliveryTime(deliveryDistance) == -1) {
            System.out.println("Свыше 100км доставки нет");
        } else {
            System.out.println("Для доставки потребуется дней: " + checkDeliveryTime(deliveryDistance));
        }
    }
}
