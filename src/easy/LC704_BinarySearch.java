package easy;

public class LC704_BinarySearch {

    public static void main(String[] args) {
        int n = new LC704_BinarySearch().search(new int[] {-1,0,3,5,9,12}, 12);
        System.out.println(n);
    }

    /**
     * <b>1st Try.</b> <br />
     * Iterative Binary Search<br />
     * Solved: 2023-07-11
     */
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * <b>1st Try.</b> <br />
     * Recursive Binary Search<br />
     * Solved: 2023-07-11
     */
    public int searchRecursive(int[] nums, int target) {
        return search2(nums, target, nums.length - 1, 0);
    }
    public int search2(int[] nums, int target, int hi, int lo) {
        if (lo >= hi) {
            return -1;
        }
        int mid = (hi + lo) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return search2(nums, target, hi, mid + 1);
        }

        return search2(nums, target, mid - 1, lo);
    }
}
