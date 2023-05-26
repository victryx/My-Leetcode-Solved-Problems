package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC283_MoveZeroes {

    public static void main(String[] args) {

        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * <b>1st Try.</b> <br />
     * Two pointer simple solution <br />
     * SOLVED: 24-05-2023
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int zeroPointer = 0;
        int nextNonZero = 0;
        while (nextNonZero < nums.length) {

            while (zeroPointer < nums.length && nums[zeroPointer] != 0) {
                zeroPointer++;
            }

            nextNonZero = zeroPointer;

            while (nextNonZero < nums.length && nums[nextNonZero] == 0) {
                nextNonZero++;
            }

            if (zeroPointer < nums.length && nextNonZero < nums.length && zeroPointer != nextNonZero) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nextNonZero];
                nums[nextNonZero] = temp;
            }
        }
    }

    /**
     * <b>Better Solution</b> <br />
     * <a href="https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/">
     *     Snowball solution
     * </a>  <br />
     * REVIEWED: 25-05-2023
     */
    public static void moveZeroes2(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i]==0) {
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                // Swap current element with snowball's most left 0
                nums[i-snowBallSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
