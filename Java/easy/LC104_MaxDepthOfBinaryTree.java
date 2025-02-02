package easy;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(maxDepth2(TreeNode.of(new Integer[]{3,9,20,null,null,15,7})));
    }


    /**
     * <b>1st Try.</b> <br />
     * Iterative Breadth First Traversal <br />
     * Solved: 2023-06-16
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        int curLevel = 0;
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
            }
            curLevel++;
        }
        return curLevel;
    }

    /**
     * Recursive solution<br />
     * SOURCE: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/1769344/java-c-easy-to-go-explanation-solution/">Leetcode</a>
     */
    public static int maxDepth2(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }

}
