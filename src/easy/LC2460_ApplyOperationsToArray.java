package easy;

public class LC2460_ApplyOperationsToArray {
    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * simple solution <br />
     * SOLVED: 25-05-2023
     */
    public static int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        moveZeroes(nums);
        return nums;
    }

    /**
     * Uses solution from problem {@link LC283_MoveZeroes}
     * to shift all zeroes to the end of the array.
     */
    public static void moveZeroes(int[] nums) {
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
