package medium;

public class LC11_ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(new LC11_ContainerWithMostWater().maxArea2(new int[]{1,2}));
    }

    /**
     * <b>1st Try.</b> <br />
     * Simulated problem, too slow.<br />
     * Solved: 2023-06-27
     */
    public int maxArea(int[] height) {
        int bestArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i - 1; j < height.length; j++) {
                bestArea = Math.max(Math.min(height[i], height[j]) * (j-i), bestArea);
            }
        }
        return bestArea;
    }



    /**
     * <b>2nd Try.</b> <br />
     * Two Pointer Solution<br />
     * Solved: 2023-06-27
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int bestArea = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                bestArea = Math.max(height[left] * (right-left), bestArea);
                left++;
            } else {
                bestArea = Math.max(height[right] * (right-left), bestArea);
                right--;
            }
        }

        return bestArea;
    }
}
