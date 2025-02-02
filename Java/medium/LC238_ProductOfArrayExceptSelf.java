package medium;

import java.util.Arrays;

public class LC238_ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1,1,0,-3,3})));
    }

    /**
     * <b>1st Try.</b> <br />
     * Brute force approach <br />
     * Solved: 2023-06-24
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            for (int j = 0; j < result.length; j++) {
                if (i == j) continue;
                result[i] *= nums[j];
            }
        }
        return result;
    }


    /**
     * <a href="https://www.youtube.com/watch?v=bNvIQI2wAjk&ampab_channel=NeetCode">Neetcode Solution</a>
     */
    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] prefix = new int[len];
        int[] postfix = new int[len];

        prefix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * result[i];
        }

        postfix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * result[i];
        }

        result[0] = postfix[1];
        for (int i = 1; i < len - 1; i++) {
            result[i] = prefix[i-1] * postfix[i+1];
        }
        result[len - 1] = prefix[len - 2];


        return result;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int len = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1 ; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
