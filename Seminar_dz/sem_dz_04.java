package Seminar_dz;


import java.util.Scanner;


/* Задание_4
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/


public class sem_dz_04 {

    public static void main(String[] args) {
        try {
            String input = readNonEmptyString();
            System.out.println("Вы ввели: " + input);
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String readNonEmptyString() throws EmptyStringException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new EmptyStringException("Пустые строки вводить нельзя!");
        }
        return input;
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }

}
