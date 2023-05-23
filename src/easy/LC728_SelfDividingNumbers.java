package easy;

import java.util.*;

public class LC728_SelfDividingNumbers {
    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * Structured brute force solution <br />
     * Solved: 2023-05-23
     */
    /// <editor-fold>
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isSelfDividing(int number) {
        for (int digit: getDigits(number)) {
            if (digit == 0 || number % digit != 0) return false;
        }
        return true;
    }

    public static List<Integer> getDigits(int number) {
        List<Integer> result = new ArrayList<>();

        while (number > 0){
            result.add(number%10);
            number /= 10;
        }

        return result;
    }
    /// </editor-fold>


}
