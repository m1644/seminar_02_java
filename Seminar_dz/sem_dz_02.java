package Seminar_dz;


/* Задание_2
Если необходимо, исправьте данный код:

try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}
*/


public class sem_dz_02 {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            int d = 0;
                
            if (intArray.length >= 9) {
                if (d != 0) {
                    double catchedRes1 = intArray[8] / d;
                    System.out.println("catchedRes1 = " + catchedRes1);
                } else {
                    System.out.println("Невозможно выполнить деление: делитель равен нулю.");
                }
            } else {
                System.out.println("Невозможно выполнить деление: индекс выходит за пределы массива.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

}
