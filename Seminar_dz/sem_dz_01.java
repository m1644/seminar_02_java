package Seminar_dz;


import java.util.Scanner;


/* Задание_1
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
и возвращает введенное значение. 
Ввод текста вместо числа не должно приводить к падению приложения, 
вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/


public class sem_dz_01 {

    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Вы ввели число: " + number);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float number;
        while (true) {
            System.out.print("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                break;
            } else {
                System.out.println("Ошибка! Введено некорректное значение. Повторите ввод.");
                scanner.next();
            }
        }
        return number;
    }

}
