package medium;

public class LC74_Search2DMatrix {

    /**
     * <b>1st Try.</b> <br />
     * Apply Binary Search two times<br />
     * Solved: 2023-07-12
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 1. Apply Binary Search to discover the correct row.
        int hi = rows - 1;
        int lo = 0;
        int row = -1;
        while (lo <= hi && row == -1) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][cols-1] >= target && matrix[mid][0] <= target ) {
                row = mid;
            } else if (matrix[mid][cols - 1] < target ) {
                lo = mid + 1;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }
        if (row == -1) return false;

        // 2. Apply typical binary search on row
        int[] nums = matrix[row];
        hi = cols - 1;
        lo = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else if (target > nums[mid]){
                lo = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
