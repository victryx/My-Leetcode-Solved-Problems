package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3,2,4}, 6)));
    }

    /**
     * 1. Brute force
     *
     */
    public static int[] twoSum(int[] nums, int target){

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j)
                    return new int[]{i,j};
            }

        }

        return new int[2];
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toTarget = target-nums[i];
            if (map.containsKey(toTarget)){
                return new int[]{i,map.get(toTarget)};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
