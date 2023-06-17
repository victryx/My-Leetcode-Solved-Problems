package easy;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC111_MinimumDepthOfBinaryTree {

    /**
     * <b>1st Try.</b> <br />
     * Preorder Traversal Solution <br />
     * Solved: 2023-06-17
     */
    int minLevel = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        preorder(root,1);
        return minLevel;
    }

    public void preorder(TreeNode root, int curLevel) {
        if (root == null) return;

        if (root.right == null && root.left == null && curLevel < minLevel) {
            minLevel = curLevel;
            return;
        }

        preorder(root.left, curLevel + 1);
        preorder(root.right, curLevel + 1);
    }


    /**
     * <b>2nd Try.</b> <br />
     * Breadth first traversal <br />
     * It is faster because the first leaf node we encounter will have the minimum depth <br />
     * Solved: 2023-06-17
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        int curLevel = 1;
        q.offer(cur);
        while (!q.isEmpty()) {
            int levelLength = q.size();
            for (int i = 0; i < levelLength; i++) {
                cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.right == null && cur.left == null) {
                    return curLevel;
                }
            }
            curLevel++;
        }
        return curLevel;
    }

    /**
     * Better DFS solution<br />
     * SOURCE: <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/editorial/">Leetcode</a>
     */
    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If only one of child is non-null, then go into that recursion.
        if (root.left == null) {
            return 1 + minDepth3(root.right);
        } else if (root.right == null) {
            return 1 + minDepth3(root.left);
        }

        // Both children are non-null, hence call for both childs.
        return 1 + Math.min(minDepth3(root.left), minDepth3(root.right));
    }
}
