package easy;

import java.util.*;

public class LC728_SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(10,30));
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

    /**
     * Better solution, same approach. <br />
     * <a href="https://leetcode.com/problems/self-dividing-numbers/solutions/3054038/java-100-faster-explained-properly/">LC Solution</a>
     */
    public static List<Integer> selfDividingNumbers2(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(checking(i)) list.add(i);
        }
        return list;
    }

    public static boolean checking(int number) {
        int storingNumber = number;
        while (number != 0) {
            int r = number % 10;
            if (r == 0) return false;
            if (!(storingNumber % r == 0)) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

}
