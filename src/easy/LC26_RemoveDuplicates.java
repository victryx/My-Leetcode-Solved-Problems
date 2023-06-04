package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC26_RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates3(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * <b>1st Try.</b> <br />
     * Hashset solution <br />
     * Solved: 2023-06-04
     */
    public static int removeDuplicates(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add((nums[i]));
        }

        int i = 0;

        for (Integer num : uniqueNums) {
            nums[i] = num;
            i++;
        }

        Arrays.sort(nums, 0, uniqueNums.size());

        return uniqueNums.size();
    }

    /**
     * <b>2nd Try.</b> <br />
     * Two Pointer solution <br />
     * Solved: 2023-06-04
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }

    /**
     * foreach solution <br />
     * Source: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/11780/5-lines-c-java-nicer-loops/">Leetcode</a>
     */
    public static int removeDuplicates3(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums){
            if (n > nums[i-1]) {
                nums[i] = n;
                i++;
            }
        }

        return i;
    }
}
