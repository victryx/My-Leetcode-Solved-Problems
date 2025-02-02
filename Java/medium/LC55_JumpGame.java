package medium;

import java.util.Arrays;

public class LC55_JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump2(new int[]{2,0,0}));
        System.out.println(canJump2(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }

    /**
     * <b>1st Try.</b> <br />
     * Inefficient recursive solution <br />
     * Time limit exceeded <br />
     * Solved: 2023-06-13
     */
    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int jumps = nums[0];
        boolean jump = false;
        for (int i = 1; i < jumps + 1; i++) {
            if (i < nums.length) {
                jump = jump || canJump(Arrays.copyOfRange(nums,i,nums.length));
                if (jump) return true;
            }
        }
        return jump;
    }

    /**
     * <b>2nd Try.</b> <br />
     * works ^^ <br />
     * Solved: 2023-06-13
     */
    public static boolean canJump2(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;

        int goal = nums.length - 1;
        int cur = goal;

        while (cur >= 0) {
            int necessarySteps = goal - cur;
            if (nums[cur] >= necessarySteps)
                goal = cur;

            cur--;
        }
        return goal == cur+1;
    }

}
