package easy;

import java.util.Arrays;

public class LC27_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(removeElement(nums,2));
        System.out.println(Arrays.toString((nums)));
        
    }
    
     /**
     * <b>1st Try.</b> <br />
     * Two pointers solution <br />
     * Solved: 2023-06-08
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while (i < j) {
            if (nums[i] == val) {
                while (i < j && nums[j] == val) j--;
                nums[i] = nums[j];
                nums[j] = val;
            }
            i++;
        }
        
        i = nums.length - 1;
        while (i >= 0 && nums[i] == val){
            k++;
            i--;
        }
        return nums.length - k;
    }
}
