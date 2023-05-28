package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC169_MajorityElement {
    public static void main(String[] args) {

    }

    /**
     * <b>1st Try.</b> <br />
     * HashMap solution<br />
     * Solved: 2023-05-28
     */
    public static int majorityElement(int[] nums) {
        int limit = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num,0);
            map.put(num, map.get(num) + 1);
            if(map.get(num) > limit){
                return num;
            }
        }
        return -1;
    }

    /**
     * <b>2nd Try.</b> <br />
     * Sorting solution<br />
     * Solved: 2023-05-28
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Better solution, Moore voting algorithm<br />
     * SOURCE: <a href="https://leetcode.com/problems/majority-element/solutions/51613/o-n-time-o-1-space-fastest-solution/">Leetcode</a>
     */
    public int majorityElement3(int[] nums) {
        int me = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (me == nums[i]){
                count++;
            } else if (count == 0){
                me = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return me;
    }
}
