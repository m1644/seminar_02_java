package Seminar;


/* Задание_2
Обработайте возможные исключительные ситуации. 
“Битые” значения в исходном массиве считайте нулями. 
Можно внести в код правки, которые считаете необходимыми.

public static int sum2d(String[][] arr) {
    int sum = 0;
    if (arr != null){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    sum += tryParseInt(arr[i][j]);
                }
            }
        }
    }
    return sum;
}

*/


public class sem_02 {

    public static void main(String[] args) {
        String[][] arr = {{"1","2"},{"3",null},{"1","6"}};
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
    int sum = 0;
    if (arr != null) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int value = tryParseInt(arr[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    // Обработка "битых" значений: считаем их нулями
                    sum += 0;
                }
            }
        }
    }
    return sum;
}

    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Возникла ошибка парсинга, вернем 0
            return 0;
        }
    }

}
