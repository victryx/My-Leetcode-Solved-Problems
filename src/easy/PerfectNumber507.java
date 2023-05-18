package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A perfect number is a positive integer that is equal to the sum of its positive divisors,
 * excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
 */
public class PerfectNumber507 {

    public static void main(String[] args) {
        System.out.println(getDivisors(28));
    }

    /**
     * 1. 98/98 Testcases passed
     * Time limmit exceeded
     * @param num
     * @return
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
    //  int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i < n/2 + 1; i++) {
            if (n % i == 0){
                result.add(i);
            }
        }
        return result;
    }
}
