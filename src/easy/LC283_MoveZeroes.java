package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC283_MoveZeroes {

    public static void main(String[] args) {

        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(arr);
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
        while (nextNonZero < nums.length){

            while (zeroPointer < nums.length && nums[zeroPointer] != 0){
                zeroPointer++;
            }

            nextNonZero = zeroPointer;

            while (nextNonZero < nums.length && nums[nextNonZero] == 0){
                nextNonZero++;
            }

            if (zeroPointer < nums.length && nextNonZero < nums.length && zeroPointer != nextNonZero) {
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[nextNonZero];
                nums[nextNonZero] = temp;
            }
        }
    }
}
