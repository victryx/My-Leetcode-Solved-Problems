package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }

    /**
     * <b>1st Try.</b> <br />
     * Sorted array solution<br />
     * Solved: 2023-05-30
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestConsecutive = 1;
        int currentConsecutive = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                continue;
            }
            if (nums[i] + 1 == nums[i+1]){
                currentConsecutive++;
                if (currentConsecutive > longestConsecutive) {
                    longestConsecutive = currentConsecutive;
                }
            } else {
                currentConsecutive = 1;
            }
        }
        return longestConsecutive;
    }

    /**
     * Set solution<br />
     * SOURCE: <a href="https://leetcode.com/problems/longest-consecutive-sequence/solutions/41057/simple-o-n-with-explanation-just-walk-each-streak/">Leetcode</a>
     */
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}
