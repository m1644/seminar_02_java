package Seminar;

import java.util.Scanner;


/* Задание_1
Посмотрите на этот код. Все ли с ним хорошо? 
Если нет, то скорректируйте его и обоснуйте свое решение.

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[10];
    System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
    int index = scanner.nextInt();
    try {
        arr[index] = 1;
    } catch (Exception e) {
        System.out.println("Указан индекс за пределами массива");
    }
}
*/


/* Ответ:
Вместо использования общего "Exception" для перехвата всех возможных исключений, 
нужно использовать конкретное исключение, такое как "ArrayIndexOutOfBoundsException"
*/


public class sem_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
        int index = scanner.nextInt();
        try {
            arr[index] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Указан индекс за пределами массива");
        }
    }

}
