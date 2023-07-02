package Seminar;


import java.io.*;


/* Задание_4
Дан следующий код:
Исправьте код, примените подходящие способы обработки исключений.

public static void main(String[] args) {
    InputStream inputStream;
    try {
        String[] strings = {"asdf", "asdf"};
        String strings1 = strings[strings.length-1];
        test();
        int a = 1 / 0;
        inputStream = new FileInputStream("sdafgdsaf");
    } catch (StackOverflowError error) {
        System.out.println("Стек переполнен");
    } catch (Throwable e) {
        e.printStackTrace();
    } finally {
        System.out.println("Я все равно выполнился!");
    }
    System.out.println("Я жив!");
}

public static void test() throws IOException {
    File file = new File("l");
    file.createNewFile();
    FileReader reader = new FileReader(file);
    reader.read();
    test();
}
*/


public class sem_04 {

    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String strings1 = strings[strings.length - 1];
            test();
            try {
                int a = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Ошибка деления на ноль");
            }
            inputStream = new FileInputStream("Seminar\\sdafgdsaf");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            System.out.println("Произошло исключение: " + t.getClass().getSimpleName());
        } finally {
            System.out.println("Я все равно выполнился!");
            System.out.println("Я жив!");
        }
    }

    public static void test() throws IOException {
        File file = new File("Seminar\\l");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader reader = new FileReader(file);
        reader.read();
        // Добавьте условие для выхода из рекурсии
        if (file.length() < 10000) {
            test();
        }
    }
}
