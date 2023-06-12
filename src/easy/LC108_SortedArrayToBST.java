package easy;

import entities.TreeNode;

import java.util.Arrays;

public class LC108_SortedArrayToBST {

    public static void main(String[] args) {
//      System.out.println(TreeNode.of(new Integer[]{-10,-3,2,5,9,4,null,1,2}));
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));

    }

    /**
     * <b>1st Try.</b> <br />
     * Simple solution <br />
     * Solved: 2023-06-12
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums,0, mid);
        int[] right = Arrays.copyOfRange(nums,mid+1,nums.length);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }

    /**
     * Same approach without creating new arrays<br />
     * Source: <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/2404676/java-solution-recursion-0ms-100-faster-beginner-friendly/">Leetcode</a>
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) { // Base Condition or Recursion Stoping Condition
            return null;
        }
        // Basically in this question we have to convert sorted array to height balanced tree,
        // if we directly create tree in given sorted order it will become linked list,
        // so we have to take middle element as head value such it will  become height balanced tree
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]); // mid value or median
        root.left = CreateBST(nums, l, mid - 1); // assign the value for left of subtree that is l to mid -1 for given array
        root.right = CreateBST(nums, mid + 1, r); // assign the value for right go subtree that is mid+1 to r for given array
        return root;
    }
}
