package medium;

public class LC209_MinimumSizeSubarraySum {


    /**
     * <b>1st Try.</b> <br />
     * Sliding window simple problem<br />
     * Solved: 2023-07-06
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int bestLen = 0;
        int curSum = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            while (curSum >= target) {
                int curLen = r - l + 1;
                if (curLen < bestLen || bestLen == 0) {
                    bestLen = curLen;
                }
                curSum -= nums[l];
                l++;
            }
        }

        return bestLen;
    }
}
