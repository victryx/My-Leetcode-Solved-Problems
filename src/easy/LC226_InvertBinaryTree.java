package easy;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC226_InvertBinaryTree {

    /**
     * <b>1st Try.</b> <br />
     * <br />
     * Solved: 2023-06-03
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        root.right = invertTree(root.right);
        root.left = invertTree(root.left);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    public static List<Integer> dfsTraversal(TreeNode root) {
        List<Integer> traversalResult = new ArrayList<>();
        dfsHelper(root, traversalResult);
        return traversalResult;
    }

    private static void dfsHelper(TreeNode node, List<Integer> traversalResult) {
        if (node == null) {
            return;
        }

        // Visit the current node
        traversalResult.add(node.val);

        // Traverse the left subtree
        dfsHelper(node.left, traversalResult);

        // Traverse the right subtree
        dfsHelper(node.right, traversalResult);
    }
}
