package hard;

public class LC42_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new LC42_TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * <b>1st Try.</b> <br />
     * Two Pointer Solution<br />
     * Solved: 2023-06-28
     */
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int left = 0;
        int right = 1;

        int curSum = 0;
        int curSub = 0;

        int greatestElement = 0;
        greatestElement = Math.max(height[left], greatestElement);

        while (right < height.length) {
            greatestElement = Math.max(height[right], greatestElement);
            if (height[right] < height[left]){
                curSub += height[right];
            } else { // Greatest or equal element found
                int area = Math.min(height[right], height[left]) * (right-left-1);
                curSum += area - curSub;

                curSub = 0;
                left = right;
            }
            right++;

            if (right == height.length && height[left] == greatestElement) {
                height[left]--;
                greatestElement--;
                right = left + 1;
                curSub = 0;
            }
        }
        return curSum;
    }

    /**
     * Neetcode solution
     */
    public int trap2(int[] heights) {
        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }

        return res;
    }
}
