package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC136_SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,4,1,2}));
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
}
