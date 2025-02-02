package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC136_SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{1,2,4,1,2,5,5,9,9}));
    }

    /**
     * <b>1st Try.</b> <br />
     * Hashset simple solution <br />
     * SOLVED: 25-05-2023
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> singles = new HashSet<>();
        singles.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (singles.contains(nums[i])){
                singles.remove(nums[i]);
            } else {
                singles.add(nums[i]);
            }
        }
        return singles.iterator().next();
    }

    /**
     * XOR Solution <br />
     * SOURCE: <a href="https://leetcode.com/problems/single-number/solutions/3021354/java-easy-solution-beats-100-runtime-1ms-bit-manipulation/">Leetcode</a>
     */
    public static int singleNumber2(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
