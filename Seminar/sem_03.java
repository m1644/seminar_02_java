package Seminar;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


/* Задание_3
Запишите в файл следующие строки:

Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4

Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap).
В отдельном методе нужно будет пройти по структуре данных.
Если сохранено значение ?, заменить его на соответствующее число.
Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
Записать в тот же файл данные с замененными символами ?.
*/


public class sem_03 {

    public static void main(String[] args) {
        String fileName = "Seminar\\data.txt";
        try {
            Map<String, Integer> data = readDataFromFile(fileName);
            processAndWriteData(data, fileName);
            System.out.println("Данные успешно обработаны и записаны в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке данных: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.out.println("Неверный формат данных: " + e.getMessage());
        }
    }

    private static Map<String, Integer> readDataFromFile(String fileName) throws IOException, InvalidDataException {
        Map<String, Integer> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length != 2) {
                    throw new InvalidDataException("Неверный формат данных в файле");
                }
                String name = parts[0].trim();
                String valueString = parts[1].trim();
                if (valueString.equals("?")) {
                    data.put(name, null); // Значение "?" будет обозначено как null
                } else {
                    try {
                        int value = Integer.parseInt(valueString);
                        data.put(name, value);
                    } catch (NumberFormatException e) {
                        throw new InvalidDataException("Неверный формат данных в файле");
                    }
                }
            }
        }
        return data;
    }

    private static void processAndWriteData(Map<String, Integer> data, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                String name = entry.getKey();
                Integer value = entry.getValue();
                if (value == null) {
                    value = calculateLetterCount(name); // Заменяем "?" на количество букв в имени
                }
                writer.write(name + "=" + value);
                writer.newLine();
            }
        }
    }

    private static int calculateLetterCount(String name) {
        String lettersOnly = name.replaceAll("[^a-zA-Zа-яА-Я]", ""); // Удаляем все символы, кроме букв
        return lettersOnly.length();
    }

    private static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}
