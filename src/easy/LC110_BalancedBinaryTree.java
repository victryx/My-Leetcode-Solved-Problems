package easy;

import entities.TreeNode;

public class LC110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean balanced = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return balanced && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
