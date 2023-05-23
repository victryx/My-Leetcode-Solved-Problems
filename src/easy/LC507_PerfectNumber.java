package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A perfect number is a positive integer that is equal to the sum of its positive divisors,
 * excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
 */
public class LC507_PerfectNumber {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber4(28));
    }

    /**
     * Intento 1.
     * 98/98 Testcases passed
     * Time limit exceeded
     */
    public static boolean checkPerfectNumber(int num) {
        int n = 0;
        for (Integer divisor : getDivisors(num)) {
            n += divisor;
        }

        return num == n;
    }

    public static List<Integer> getDivisors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n/2 + 1; i++) {
            if (n % i == 0){
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Intento 2.
     * 98/98 Testcases passed
     * Time limit exceeded
     */
    public static boolean checkPerfectNumber2(int num) {
        int n = 0;
        for (int i = 1; i < num/2 + 1; i++){
            if (num % i == 0){
                n+=i;
            }
        }
        return num == n;
    }

    /**
     * Solución: Mismo planteamiento, añade comprobación <br>
     *  - Un número impar no puede ser un número perfecto
     *
     */
    public static boolean checkPerfectNumber3(int num) {
        if (num % 2 != 0) {
            return false;
        }
        int n = 0;
        for (int i = 1; i < num/2 + 1; i++){
            if (num % i == 0){
                n+=i;
            }
        }
        return num == n;
    }

    /**
     * Reduce el límite del bucle for y calcula los divisores que no alcanza
     * el bucle for a través de los que sí. Por ejemplo <br>
     * 28 --> 2, 4 --> Estos los alcanza <br>
     * 28 --> (28/2) = 14 , (28/4) = 7 --> Estos los calcula
     */
    public static boolean checkPerfectNumber4(int num) {
        if (num == 1)
            return false; // 1 no cumple con la definición de número perfecto

        int sum = 1;
        double limit = Math.sqrt(num);

        for (int i = 2; i < limit; i++) {
            if (num % i == 0){
                int factor = num/i;
                sum = sum + i + factor;
            }
        }
        return sum==num;
    }
}
