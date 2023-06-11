package medium;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC98_ValidateBinarySearchTree {

    /**
     * <b>1st Try.</b> <br />
     * Check every subtree. Easy solution <br />
     * Solved: 2023-06-11
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftValid = isLowerSubtree(root.left, root.val);
        boolean rightValid = isGreaterSubtree(root.right, root.val);

        return leftValid && rightValid && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isLowerSubtree(TreeNode root, int val) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while there is at least one discovered node
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.val >= val) return false;
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);
        }
        return true;
    }

    public boolean isGreaterSubtree(TreeNode root, int val){
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while there is at least one discovered node
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.val <= val) return false;
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);
        }
        return true;
    }

}
