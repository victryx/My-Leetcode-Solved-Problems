package entities;

import java.util.Iterator;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public static TreeNode of(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildTree(nums, 0);
    }

    private static TreeNode buildTree(Integer[] nums, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < nums.length && nums[i] != null) {
            root = new TreeNode(nums[i]);

            // insert left child
            root.left = buildTree(nums, 2 * i + 1);

            // insert right child
            root.right = buildTree(nums, 2 * i + 2);
        }
        return root;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(right!=null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if(left!=null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}

