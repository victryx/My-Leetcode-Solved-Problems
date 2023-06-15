package medium;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1161_MaximumLevelSumOfBinaryTree {

    /**
     * <b>1st Try.</b> <br />
     * Breadth First traversal, dividing each level with an inner for loop<br />
     * Solved: 2023-06-15
     */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        int curLevel = 1;
        int bestLevel = 1;
        int bestSum = Integer.MIN_VALUE;
        q.offer(cur);
        while (!q.isEmpty()) {
            int levelLength = q.size();
            int levelSum = 0;
            for (int i = 0; i < levelLength; i++) {
                cur = q.poll();
                levelSum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (levelSum > bestSum) {
                bestSum = levelSum;
                bestLevel = curLevel;
            }
            curLevel++;
        }
        return bestLevel;
    }

    /**
     * It uses DFS to create a list containing the sum of the values of each level<br />
     * Source: <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/editorial/">Leetcode</a>
     */
    public void dfs(TreeNode node, int level, List<Integer> sumOfNodesAtLevel) {
        if (node == null) {
            return;
        }

        if (sumOfNodesAtLevel.size() == level) {
            sumOfNodesAtLevel.add(node.val);
        } else {
            sumOfNodesAtLevel.set(level, sumOfNodesAtLevel.get(level) + node.val);
        }

        dfs(node.left, level + 1, sumOfNodesAtLevel);
        dfs(node.right, level + 1, sumOfNodesAtLevel);
    }

    public int maxLevelSum2(TreeNode root) {
        List<Integer> sumOfNodesAtLevel = new ArrayList<>();
        dfs(root, 0, sumOfNodesAtLevel);

        int maxSum = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < sumOfNodesAtLevel.size(); i++) {
            if (maxSum < sumOfNodesAtLevel.get(i)) {
                maxSum = sumOfNodesAtLevel.get(i);
                ans = i + 1;
            }
        }

        return ans;
    }
}
