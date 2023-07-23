package medium;


public class LC153_FindMinimumInRotatedSortedArray {


    /**
     * <b>1st Try.</b> <br />
     * Linear time solution<br />
     * Solved: 2023-07-16
     */
    public int findMin(int[] nums) {
        // 1. linear time solution
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }
    

    
    /**
     * <b>2nd Try.</b> <br />
     * Binary Search solution<br />
     * Solved: 2023-07-16
     */
    public int findMin2(int[] nums) {
        int firstElement = nums[0];
        int hi = nums.length-1;
        int lo = 0;
        if (nums[hi] >= nums[lo]) return nums[lo];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] > nums[lo]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo]) {
                hi = mid;
            }
        }
        return -1;
    }

    /**
     * <b>2nd Try.</b> <br />
     * Better Binary Search solution<br />
     * Solved: 2023-07-16
     */
    public int findMin3(int[] nums) {
        int hi = nums.length-1;
        int lo = 0;

        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) return nums[lo];
            int mid = (lo + hi) / 2;

            if (nums[mid] >= nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return 0;
    }
}
