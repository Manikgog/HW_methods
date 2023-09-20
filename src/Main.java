import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1.");
        /*
        Реализуйте метод, который получает в качестве параметра год,
        проверяет, является ли он високосным, и выводит результат в консоль.
        Результат программы выведите в консоль. Если год високосный, то
        напечатайте сообщение: «...  год — високосный год». Если год
        невисокосный, то: «... год — невисокосный год».
        */
        Scanner input = new Scanner(System.in);
        System.out.print("Введите номер года: ");
        int year = input.nextInt();
        if(checkIsLeapYear(year)){
            System.out.println(year + " год - високосный год");
        }else {
            System.out.println(year + " год - невисокосный год");
        }

        System.out.println("\nЗадача 2.");
        /*
        Напишите метод, куда подаются два параметра:
        тип операционной системы (0 — iOS, 1 — Android ) и год выпуска устройства.
        Если устройство старше текущего года, предложите ему установить
        облегченную версию. Текущий год можно получить таким способом:
        int currentYear = LocalDate.now().getYear();
        Или самим задать значение вручную — ввести в переменную числовое значение.
        В результате программа должна выводить в консоль сообщение, какую версию
        приложения (обычную или облегченную) и для какой ОС (Android или iOS)
        установить пользователю.
        */
        System.out.print("Введите год выпуска Вашего телефона -> ");
        int yearOfRelease;
        yearOfRelease = input.nextInt();
        System.out.println("Укажите Вашу операционную систему:");
        int clientOS;
        do {
            System.out.println("0. iOS");
            System.out.println("1. Android");
            System.out.print("Введите соответствующий пункт -> ");
            clientOS = input.nextInt();
        }while(clientOS != 0 && clientOS != 1);
        getTypeProgram(clientOS, yearOfRelease);

        System.out.println("\nЗадача 3.");
        /*
        В банке для клиентов организовывается доставка карт на дом.
        Чтобы известить клиента о том, когда будет доставлена его карта,
        нужно знать расстояние от офиса до адреса доставки.
        Правила доставки такие:
        Доставка в пределах 20 км занимает сутки.
        Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
        Доставка в пределах от 60 км до 100 км добавляет еще одни сутки.
        Свыше 100 км доставки нет.
        То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.
        Напишите программу, которая выдает сообщение в консоль:
        «Потребуется дней: ... » + срок доставки.
        Объявите целочисленную переменную deliveryDistance = 95,
        которая содержит дистанцию до клиента.
        Ваша задача — доработать код, а именно написать метод,
        который на вход принимает дистанцию и возвращает итоговое
        количество дней доставки.
        */
        System.out.print("Введите величину расстояния от офиса до адреса доставки -> ");
        int distance = input.nextInt();
        int deliveryTime = getDeliveryTimeInDays(distance);
        if(deliveryTime != 0) {
            System.out.println("Потребуется дней: " + deliveryTime + "\n");
        }else{
            System.out.println("Доставки нет.\n");
        }
    }

    private static boolean checkIsLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && year > 1584;
    }

    private static void getTypeProgram(int typeOS, int yearOfRelease){
        int currentYear = LocalDate.now().getYear();
        if (yearOfRelease < currentYear && typeOS == 0) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке.");
        } else if (yearOfRelease < currentYear && typeOS == 1) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке.");
        } else if (typeOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке.");
        } else {
            System.out.println("Установите версию приложения для Android по ссылке.");
        }
    }

    private static int getDeliveryTimeInDays(int distance){
        int deliveryTime = 0;
        if(distance <= 20){
            ++deliveryTime;
        }else if(distance <= 60){
            deliveryTime += 2;
        }else if(distance <= 100){
            deliveryTime += 3;
        }
        return deliveryTime;
    }

}