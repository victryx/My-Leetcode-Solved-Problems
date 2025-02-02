package easy;

public class LC1464_MaxProductOfTwoArrayElements {

    /**
     * <b>1st Try.</b> <br />
     * Brute force solution<br />
     * Solved: 2023-12-12
     */
    public int maxProduct(int[] nums) {
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                maxVal = Math.max(maxVal, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return maxVal;
    }

    /**
     * <b>2nd Try.</b> <br />
     * 2 highest values<br />
     * Solved: 2023-12-12
     */
    public int maxProduct2(int[] nums) {
        int first = 0;
        int sec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                sec = first;
                first = nums[i];
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        return (first - 1) * (sec - 1);
    }
}
