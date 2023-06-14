package easy;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC530_MinimumAbsoluteDifference {

    /**
     * <b>1st Try.</b> <br />
     * Inorder traversal to get a sorted list.<br />
     * Solved: 2023-06-14
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        toList(root, values);
        int bestDiff = Integer.MAX_VALUE;
        int curDiff;
        for (int i = 1; i < values.size(); i++) {
            curDiff = values.get(i) - values.get(i-1);
            bestDiff = Math.min(bestDiff,curDiff);
        }
        return bestDiff;
    }

    public void toList(TreeNode root, List<Integer> values) {
        if (root == null) return;
        toList(root.left, values);
        values.add(root.val);
        toList(root.right, values);
    }

    /**
     * In-order Traversal Without List.<br />
     * Source: <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/editorial/">Leetcode</a>
     */
    int minDifference = Integer.MAX_VALUE;
    // Initially, it will be null.
    TreeNode prevNode;

    int getMinimumDifference2(TreeNode root) {
        inorderTraversal(root);
        return minDifference;
    }

    void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        // Find the difference with the previous value if it is there.
        if (prevNode != null) {
            minDifference = Math.min(minDifference, node.val - prevNode.val);
        }
        prevNode = node;
        inorderTraversal(node.right);
    }

}
