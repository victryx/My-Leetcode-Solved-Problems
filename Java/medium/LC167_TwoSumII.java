package medium;

import java.util.Arrays;
import java.util.HashMap;

public class LC167_TwoSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997}, 542)));
    }

    /**
     * <b>1st Try.</b> <br />
     * Two pointer solution, wrong<br />
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = 1;
        while (j < numbers.length ) {
            int curSum = numbers[i] + numbers[j];
            if (curSum < target) {
                j++;
            } else if (curSum > target) {
                i++;
                j--;
            } else {
                return new int[]{i+1,j+1};
            }
        }

        j--;
        while (i < j) {
            int curSum = numbers[i] + numbers[j];
            if (curSum == target) {
                return new int[]{i+1, j+1};
            }
            i++;
        }
        return null;
    }

    /**
     * <b>2nd Try.</b> <br />
     * Same solution as Two Sum problem<br />
     * Solved: 2023-06-25
     */
    public static int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int toTarget = target-numbers[i];
            if (map.containsKey(toTarget)){
                return new int[]{map.get(toTarget) + 1,i + 1};
            }
            map.put(numbers[i],i);
        }
        return new int[2];
    }

    /**
     * Two pointer solution<br />
     * <a href="https://youtu.be/cQ1Oz4ckceM">Neetcode</a>
     */
    public static int[] twoSum3(int[] numbers, int target) {
         int i = 0;
         int j = numbers.length - 1;
         while (i < j) {
             int curSum = numbers[i] + numbers[j];
             if (curSum < target) {
                 i++;
             } else if (curSum > target) {
                 j--;
             } else {
                 return new int[]{i+1, j+1};
             }
         }
         return null;
    }
}
