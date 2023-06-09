package easy;

import java.util.*;

public class LC26_RemoveDuplicates {

    /**
     * <b>1st Try.</b> <br />
     * Level order traversal solution <br />
     * Solved: 2023-06-09
     */
     public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean symmetric = true;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            Integer[] currentLevel = new Integer[levelSize];
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = q.poll();
                if (curNode != null) {
                    currentLevel[i] = curNode.val;
                    q.offer(curNode.left);
                    q.offer(curNode.right);
                } else {
                    currentLevel[i] = null;
                }
            }
            symmetric = symmetric && arrayIsSymmetric(currentLevel);
        }
        return symmetric;
    }

    public boolean arrayIsSymmetric(Integer[] nums){
        if (nums.length <= 1) return true;
        for (int i = 0; i < nums.length/2; i++) {
            if (nums[i] != nums[nums.length - 1 - i])
                return false;
        }
        return true;
    }


}
